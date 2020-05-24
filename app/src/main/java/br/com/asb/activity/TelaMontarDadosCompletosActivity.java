package br.com.asb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.asb.R;
import br.com.asb.bean.AlimentacaoBeans;
import br.com.asb.bean.AnamineseProfissionalBean;
import br.com.asb.bean.BurnOutBean;
import br.com.asb.bean.DiarioClasseBean;
import br.com.asb.bean.ListaTotalDadosPesquisa;
import br.com.asb.bean.SonoPittsburghBeans;
import br.com.asb.persistencia.dao.DAOCadastro;
import br.com.asb.util.Constantes;

public class TelaMontarDadosCompletosActivity extends Activity {



    private ArrayAdapter<String> adapter;
    private ListaTotalDadosPesquisa lista;
    private ArrayList<String>listaAtualizada;
    private TextView textViewDadosAnamnese_1 ;
    private TextView textViewDadosAnamnese_2 ;
    private TextView textViewDadosAnamnese_3 ;
    private TextView textViewDadosAnamnese_4 ;
    private TextView textViewDadosAnamnese_5 ;
    private TextView textViewDadosAnamnese_6 ;
    private TextView textViewDadosAnamnese_7 ;
    private TextView textViewDadosAnamnese_8 ;
    private TextView textViewDadosAnamnese_9 ;
    private TextView textViewDadosAnamnese_10 ;
    private TextView textViewDadosAnamnese_11 ;
    private TextView textViewDadosAnamnese_12 ;
    private TextView textViewDadosAnamnese_13 ;
    private TextView textViewDadosAnamnese_14 ;
    private TextView textViewDadosAnamnese_15 ;
    private TextView textViewDadosAnamnese_16 ;
    private TextView textViewDadosAnamnese_17 ;
    private TextView textViewDadosAnamnese_18 ;
    private int id;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_montar_lista_profissionais_cadastrados);
        id = (Integer)getIntent().getSerializableExtra("ID");
        intiView();
    }

    protected void intiView() {

            textViewDadosAnamnese_1  = (TextView) findViewById(R.id.lista_dados_anamnase_1);
            textViewDadosAnamnese_2  = (TextView) findViewById(R.id.lista_dados_anamnase_2);
            textViewDadosAnamnese_3  = (TextView) findViewById(R.id.lista_dados_anamnase_3);
            textViewDadosAnamnese_4  = (TextView) findViewById(R.id.lista_dados_anamnase_4);
            textViewDadosAnamnese_5  = (TextView) findViewById(R.id.lista_dados_anamnase_5);
            textViewDadosAnamnese_6  = (TextView) findViewById(R.id.lista_dados_anamnase_6);
            textViewDadosAnamnese_7  = (TextView) findViewById(R.id.lista_dados_anamnase_7);
            textViewDadosAnamnese_8  = (TextView) findViewById(R.id.lista_dados_anamnase_8);
            textViewDadosAnamnese_9  = (TextView) findViewById(R.id.lista_dados_anamnase_9);
            textViewDadosAnamnese_10  = (TextView) findViewById(R.id.lista_dados_anamnase_10);


        popularLista();

    }


    private ListaTotalDadosPesquisa retornoListaCLasse() {

        ListaTotalDadosPesquisa listaClasses = new ListaTotalDadosPesquisa();
        listaClasses = (ListaTotalDadosPesquisa)DAOCadastro.getInstance().listarDadosProfissionalPorId(id, Constantes.TABELA_CADASTRO_BURNOUT);
        return listaClasses;

    }

    private void popularLista(){

        AlimentacaoBeans alimentacaoBeans;
        SonoPittsburghBeans sonoPittsburghBeans;
        AnamineseProfissionalBean anamineseProfissionalBean;
        BurnOutBean burnOutBean;
        ListaTotalDadosPesquisa listaTotalDadosPesquisa = retornoListaCLasse();

            anamineseProfissionalBean = new AnamineseProfissionalBean();
            anamineseProfissionalBean =(AnamineseProfissionalBean)listaTotalDadosPesquisa.getAnamineseProfissionalBean();
            anamineseProfissionalBean.getIdProfissional();


        textViewDadosAnamnese_1.setText(Integer.toString(anamineseProfissionalBean.getIdProfissional()));
        textViewDadosAnamnese_2.setText(anamineseProfissionalBean.getNomeProfissional());
        textViewDadosAnamnese_3.setText(anamineseProfissionalBean.getTelefone());
        textViewDadosAnamnese_3.setText(anamineseProfissionalBean.getDtEntrevista());
        textViewDadosAnamnese_4.setText(Integer.toString(anamineseProfissionalBean.getCDE()));
        textViewDadosAnamnese_5.setText(anamineseProfissionalBean.getSexo());
        textViewDadosAnamnese_6.setText(anamineseProfissionalBean.getIdade());
        textViewDadosAnamnese_7.setText(anamineseProfissionalBean.getAltura());
        textViewDadosAnamnese_8.setText(Boolean.toString(anamineseProfissionalBean.getRefeicaoDiariaA()));
        textViewDadosAnamnese_9.setText(Boolean.toString(anamineseProfissionalBean.getRefeicaoDiariaB()));
        textViewDadosAnamnese_10.setText(Boolean.toString(anamineseProfissionalBean.getPraticaAtividadeFisica()));
        textViewDadosAnamnese_11.setText(Boolean.toString(anamineseProfissionalBean.getPraticaAtividadeFisica()));
        textViewDadosAnamnese_12.setText(Boolean.toString(anamineseProfissionalBean.getPraticaAtividadeFisica()));
        textViewDadosAnamnese_13.setText(Boolean.toString(anamineseProfissionalBean.getPraticaAtividadeFisica()));
        textViewDadosAnamnese_14.setText(Boolean.toString(anamineseProfissionalBean.getPraticaAtividadeFisica()));
        textViewDadosAnamnese_15.setText(Boolean.toString(anamineseProfissionalBean.getPraticaAtividadeFisica()));
        textViewDadosAnamnese_16.setText(Boolean.toString(anamineseProfissionalBean.getPraticaAtividadeFisica()));
        textViewDadosAnamnese_17.setText(Boolean.toString(anamineseProfissionalBean.getPraticaAtividadeFisica()));
        textViewDadosAnamnese_18.setText(Boolean.toString(anamineseProfissionalBean.getPraticaAtividadeFisica()));






/*






        listaAtualizada.add(Boolean.toString(anamineseProfissionalBean.getPraticaAtividadeFisica()));
        listaAtualizada.add(anamineseProfissionalBean.getNomeAtividade());
        listaAtualizada.add(anamineseProfissionalBean.getDuracaoAtividade());
        listaAtualizada.add(Integer.toString(anamineseProfissionalBean.getQtAtividadeVezesSemana()));
        listaAtualizada.add(Boolean.toString(anamineseProfissionalBean.getIntensidadeLeve()));
        listaAtualizada.add(Boolean.toString(anamineseProfissionalBean.getIntensidadeMedia()));
        listaAtualizada.add(Boolean.toString(anamineseProfissionalBean.getIntensidadeAlta()));
        listaAtualizada.add(Boolean.toString(anamineseProfissionalBean.getPraticaAtividadeFisica()));
        listaAtualizada.add(anamineseProfissionalBean.getFormacaoProf());
        listaAtualizada.add(Integer.toString(anamineseProfissionalBean.getTempoFormacaoProf()));
        listaAtualizada.add(anamineseProfissionalBean.getIntituicaoFormacaoProf());
        listaAtualizada.add(Boolean.toString(anamineseProfissionalBean.getCapacitacaoDoisAnos()));
        listaAtualizada.add(Integer.toString(anamineseProfissionalBean.getCargaHoraria()));
        listaAtualizada.add(Integer.toString(anamineseProfissionalBean.getQTEscolas()));
        listaAtualizada.add(anamineseProfissionalBean.getOutrasAtividades());

 */




//            adapter.notifyDataSetChanged();

        }










}
