package br.com.asb.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import br.com.asb.R;
import br.com.asb.bean.AlimentacaoBeans;
import br.com.asb.bean.AnamineseProfissionalBean;
import br.com.asb.bean.BurnOutBean;
import br.com.asb.bean.ListaTotalDadosPesquisa;
import br.com.asb.bean.SonoPittsburghBeans;
import br.com.asb.dialog.GeneralSysDialog;
import br.com.asb.negocio.ClassificacaoAlimentacao;
import br.com.asb.negocio.ClassificacaoBurnOut;
import br.com.asb.negocio.ClassificacaoSonoPittsburgh;
import br.com.asb.persistencia.dao.DAOCadastro;
import br.com.asb.util.Constantes;

public class ClassificacaoASBActivity extends AppCompatActivity {

    private Button buttonClassificar;

    int id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela_processo_pesquisa);
        View view = (View) this.getWindow().getDecorView().findViewById(android.R.id.content);
        initView();

    }

    private void initView(){

        buttonClassificar = (Button) findViewById(R.id.btn_executar_classificacao);
        acaoButton();

    }
    private void acaoButton() {

        buttonClassificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    classificarPesquisaToda();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }


    private void classificarPesquisaToda(){

        //lista total de cadastros
        ArrayList<AnamineseProfissionalBean> listaEntrevistados = new ArrayList<>();
        listaEntrevistados = DAOCadastro.getInstance().listarTodosProfissionaisCadastrados();
        int totalEntrevistados = listaEntrevistados.size();

        AlimentacaoBeans alimentacaoBeans;
        SonoPittsburghBeans sonoPittsburghBeans;
        AnamineseProfissionalBean anamineseProfissionalBean;
        BurnOutBean burnOutBean;

        for(int i = 1; i <= totalEntrevistados; i++) {
            id = i;

            anamineseProfissionalBean = new AnamineseProfissionalBean();
            sonoPittsburghBeans = new SonoPittsburghBeans();
            alimentacaoBeans = new AlimentacaoBeans();
            burnOutBean = new BurnOutBean();

            //dados Anaminase
            ListaTotalDadosPesquisa listaTotalDadosPesquisaAnaminase = retornoListaCLasse(Constantes.TABELA_CADASTRO_PROFISSIONAL);
            anamineseProfissionalBean = (AnamineseProfissionalBean) listaTotalDadosPesquisaAnaminase.getAnamineseProfissionalBean();

            //dados burnOut
            ListaTotalDadosPesquisa listaTotalDadosBurnOut = retornoListaCLasse(Constantes.TABELA_CADASTRO_BURNOUT);
            burnOutBean = (BurnOutBean) listaTotalDadosBurnOut.getBurnOutBean();

            //dados Sono Pittsburg
            ListaTotalDadosPesquisa listaTotalDadosSonoPitt = retornoListaCLasse(Constantes.TABELA_CADASTRO_SONO_PITSBURGH);
            sonoPittsburghBeans = (SonoPittsburghBeans) listaTotalDadosSonoPitt.getSonoPittsburghBeans();

            //alimentacao
            ListaTotalDadosPesquisa listaTotalDadosAlimentacao = retornoListaCLasse(Constantes.TABELA_CADASTRO_FREQUENCIA_ALIMENTO);
            alimentacaoBeans = (AlimentacaoBeans) listaTotalDadosAlimentacao.getAlimentacaoBeans();

            /**
             * classificação resultados Burn out exibir na tela
             */
            ClassificacaoBurnOut classificacaoBurnOut = new ClassificacaoBurnOut();
            classificacaoBurnOut.calcularSindromeBurnOut(anamineseProfissionalBean, burnOutBean);

            /**
             *
             *Inserir dados automaticamente RESPOSTA CLASSIFICACAO BURN OUT
             */

            DAOCadastro.getInstance().inserirResultadosBurnOut(id, classificacaoBurnOut);

            /**
             * classificação resultados Sonopuittsburg
             */
            ClassificacaoSonoPittsburgh classificacaoSonoPittsburgh = new ClassificacaoSonoPittsburgh();
            classificacaoSonoPittsburgh.classificarSonoPitssburgh(sonoPittsburghBeans);

            /**
             *
             *Inserir dados automaticamente SONOPITSBURG
             */
            DAOCadastro.getInstance().inserirResultadosSonoPittsburg(id, classificacaoSonoPittsburgh);

            /**
             * CLASSIFICAR alimentação
             */
            ClassificacaoAlimentacao classificacaoAlimentacao = new ClassificacaoAlimentacao();
            classificacaoAlimentacao.calcularIMC(anamineseProfissionalBean);
            classificacaoAlimentacao.classificarFrequenciaAlimentar(alimentacaoBeans);
            /**
             *
             *Inserir dados automaticamente RESPOSTA CLASSIFICACAO ALIMENTACAO
             */
            DAOCadastro.getInstance().inserirResultadosAlimentacao(id,classificacaoAlimentacao);

        }

        GeneralSysDialog generalSysDialog;
        generalSysDialog = new GeneralSysDialog(ClassificacaoASBActivity.this);
        generalSysDialog.setDialog(R.string.dialog_corpo_Classificacao_geral,R.string.titulo_classificacao_concluida,2);
    }

    private ListaTotalDadosPesquisa retornoListaCLasse(int tabela) {
        ListaTotalDadosPesquisa listaClasses = new ListaTotalDadosPesquisa();
        listaClasses = (ListaTotalDadosPesquisa) DAOCadastro.getInstance().listarDadosProfissionalPorId(id,tabela);
        return listaClasses;

    }

}
