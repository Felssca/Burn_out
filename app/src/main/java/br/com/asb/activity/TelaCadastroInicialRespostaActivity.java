package br.com.asb.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import org.w3c.dom.Text;

import br.com.asb.R;
import br.com.asb.bean.AlimentacaoBeans;
import br.com.asb.bean.AnamineseProfissionalBean;
import br.com.asb.bean.BurnOutBean;
import br.com.asb.bean.ListaTotalDadosPesquisa;
import br.com.asb.bean.SonoPittsburghBeans;
import br.com.asb.negocio.ClassificacaoBurnOut;
import br.com.asb.negocio.ClassificacaoSonoPittsburgh;
import br.com.asb.persistencia.dao.DAOCadastro;
import br.com.asb.util.Constantes;

public class TelaCadastroInicialRespostaActivity extends Activity {


    private int id;


    //ANAMNASE
    private EditText edtxtNomeProfissional;
    private EditText edtxtTelefone;
    private EditText edtxtEmail;
    private EditText edtxtDataEntrevista;
    private EditText edtxCDE;
    private EditText edtxtIdade;
    private EditText edtxtPeso;
    private EditText edtxtAltura;

    private TextView radioGroupSexo;


    //ANAMNASE NUTRICIONAL
    private TextView radioGroupRefeicoes;
    private TextView radioGroupRefeicoesB;

    private TextView txt_tipo_atividade_fisica_sim_nao;


    //ANAMNESE ATIVIDADE FISICA

    private EditText edtxtQualAtividade;
    private EditText edtxtDuracao;
    private EditText edtxtQuantasVezesSemana;

    private TextView intensidade_atividade_fisca;

    private TextView radioGroupIntensidade;
    private RadioButton radioButtonIntensidade;

    //ANAMNESE PROFISSIONAL
    private EditText edtxtFormacao;
    private EditText edtxtTempoProfissao;
    private EditText edtxtFormacaoInstituicao;

    private TextView edtxtCapacitacao;

    private EditText edtxtCargaHorarioTrabalhoSemanal;
    private EditText edtxtCargaQuantasEscolasTrabalho;
    private EditText edtxtAtividadeExerce;

    //SINDROME DE BURNOUT
    private TextView textViewResposta_burnout_1;

    private TextView textViewResposta_burnout_2;

    private TextView textViewResposta_burnout_3;

    private TextView textViewResposta_burnout_4;

    private TextView textViewResposta_burnout_5;


    private TextView textViewResposta_burnout_6;

    private TextView textViewResposta_burnout_7;

    private TextView textViewResposta_burnout_8;

    private TextView textViewResposta_burnout_9;

    private TextView textViewResposta_burnout_10;


    private TextView textViewResposta_burnout_11;

    private TextView textViewResposta_burnout_12;

    private TextView textViewResposta_burnout_13;

    private TextView textViewResposta_burnout_14;

    private TextView textViewResposta_burnout_15;


    private TextView textViewResposta_burnout_16;

    private TextView textViewResposta_burnout_17;

    private TextView textViewResposta_burnout_18;

    private TextView textViewResposta_burnout_19;

    private TextView textViewResposta_burnout_20;


    private ImageView imagemBell;


    //INDICE DE QUALIDADE DO SONO
    private EditText edtxtSono_1;
    private EditText edtxtSono_2;
    private EditText edtxtSono_3;
    private EditText edtxtSono_4;

    private TextView textViewResposta_sono_5_a;

    private TextView textViewResposta_sono_5_b;

    private TextView textViewResposta_sono_5_c;

    private TextView textViewResposta_sono_5_d;

    private TextView textViewResposta_sono_5_e;

    private TextView textViewResposta_sono_5_f;

    private TextView textViewResposta_sono_5_g;

    private TextView textViewResposta_sono_5_h;

    private TextView textViewResposta_sono_5_i;


    private EditText edtxtSono_5_j;

    private TextView textViewResposta_sono_5_k;


    private TextView textViewResposta_sono_6;


    private TextView textViewResposta_sono_7;


    private TextView textViewResposta_sono_8;


    private TextView textViewResposta_sono_9;


    //ALIMENTACAO
    private TextView textViewResposta_alimentacao_1;

    private TextView textViewResposta_alimentacao_2;

    private TextView textViewResposta_alimentacao_3;

    private TextView textViewResposta_alimentacao_4;

    private TextView textViewResposta_alimentacao_5;

    private TextView textViewResposta_alimentacao_6;

    private TextView textViewResposta_alimentacao_7;

    private TextView textViewResposta_alimentacao_8;

    private TextView textViewResposta_alimentacao_9;

    private TextView textViewResposta_alimentacao_10;

    //Reultado Classificacao BurnOut
    private TextView textViewResposta_classificacao_burn_out_somatorio_ilusao;
    private TextView textViewResposta_classificacao_burn_out_classificacao_ilusao;
    private TextView textViewResposta_classificacao_burn_out_somatorio_desgaste_psiquico;
    private TextView textViewResposta_classificacao_burn_out_classificaco_desgaste_psiquico;

    private TextView textViewResposta_classificacao_burn_out_somatorio_indolencia;
    private TextView textViewResposta_classificacao_burn_out_classificaco_indolencia;

    private TextView textViewResposta_classificacao_burn_out_somatorio_indolencia_psiquica;
    private TextView textViewResposta_classificacao_burn_out_classificacao_indolencia_psiquica;

    private TextView textViewResposta_classificacao_burn_out_somatiorio_culpa;
    private TextView textViewResposta_classificacao_burn_out_classificacao_culpa;

    private TextView textViewResposta_classificacao_burn_out_classificacao_final_ilusao;
    private TextView textViewResposta_classificacao_burn_out_classificacao_final_ilusao_niveis;
    private TextView textViewResposta_classificacao_burn_out_classificacao_final_indolencia_desgaste;
    private TextView textViewResposta_classificacao_burn_out_classificacao_final_indolencia_desgaste_niveis;
    private TextView textViewResposta_classificacao_burn_out_classificacao_final_culpa;

    //Reultado Classificacao Sono Pittsburg
    private TextView textViewResposta_classificacao_sono_componente_1;
    private TextView textViewResposta_classificacao_sono_escore_1;
    private TextView textViewResposta_classificacao_sono_pontuacao_componente_1;

    private TextView textViewResposta_classificacao_sono_componente_2_1_escore;
    private TextView textViewResposta_classificacao_sono_componente_2_1_resposta;
    private TextView textViewResposta_classificacao_sono_componente_2_2_escore;
    private TextView textViewResposta_classificacao_sono_componente_2_2_resposta;
    private TextView textViewResposta_classificacao_sono_componente_2_3_soma;
    private TextView textViewResposta_classificacao_sono_pontuacao_componente_2;


    private TextView textViewResposta_classificacao_sono_componenete_3_escore;
    private TextView textViewResposta_classificacao_sono_componente_3_resposta;
    private TextView textViewResposta_classificacao_sono_pontuacao_componente_3;

    private TextView textViewResposta_classificacao_sono_componente_4_num_horas_dormidas;
    private TextView textViewResposta_classificacao_sono_componente_4_num_horas_leito;
    private TextView textViewResposta_classificacao_sono_componente_4_eficiencia_sono;
    private TextView textViewResposta_classificacao_sono_componente_4_pontuacao;

    private TextView textViewResposta_classificacao_sono_componente_5_1_somatoria;
    private TextView textViewResposta_classificacao_sono_componente_5_1_resposta;
    private TextView textViewResposta_classificacao_sono_componente_5_pontuacao;

    private TextView textViewResposta_classificacao_sono_componente_6_resposta;
    private TextView textViewResposta_classificacao_sono_componente_6_escore;
    private TextView textViewResposta_classificacao_sono_componente_6_pontuacao;


    private TextView textViewResposta_classificacao_sono_componente_7_1_escore;
    private TextView textViewResposta_classificacao_sono_componente_7_1_resposta;
    private TextView textViewResposta_classificacao_sono_componente_7_2_escore;
    private TextView textViewResposta_classificacao_sono_componente_7_2_resposta;
    private TextView textViewResposta_classificacao_sono_componente_7_3_soma;
    private TextView textViewResposta_classificacao_sono_componente_7_pontuacao;

    private TextView textViewResposta_classificacao_sono_PSQI_qualidade;
    private TextView textViewResposta_classificacao_sono_PSQI_pontuacao;




    private int cont = 0;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_inicial_respostas);
        View view = (View) this.getWindow().getDecorView().findViewById(android.R.id.content);

        intiView();
        maskText();
        popularLista();

    }


    private void intiView() {

        //BUrnOut_classificacao
        textViewResposta_classificacao_burn_out_somatorio_ilusao = (TextView)
                findViewById(R.id.resp__classificacao_burn_out_somatorio_ilusao_trabalho);
        textViewResposta_classificacao_burn_out_classificacao_ilusao = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_ilusao_trabalho);

        textViewResposta_classificacao_burn_out_somatorio_desgaste_psiquico = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_somatorio_desgaste_psiquico);
        textViewResposta_classificacao_burn_out_classificaco_desgaste_psiquico = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_desgaste_psiquico);

        textViewResposta_classificacao_burn_out_somatorio_indolencia = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_somatorio_indolencia);
        textViewResposta_classificacao_burn_out_classificaco_indolencia = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_indolencia);

        textViewResposta_classificacao_burn_out_somatorio_indolencia_psiquica = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_somatorio_indolenci_desgaste);
        textViewResposta_classificacao_burn_out_classificacao_indolencia_psiquica = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_indolencia_desgaste);

        textViewResposta_classificacao_burn_out_somatiorio_culpa = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_somatorio_culpa);
        textViewResposta_classificacao_burn_out_classificacao_culpa = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_culpa);

        textViewResposta_classificacao_burn_out_classificacao_final_ilusao = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_burnOut_ilusao);
        textViewResposta_classificacao_burn_out_classificacao_final_ilusao_niveis = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_burnOut_ilusao_nivel);

        textViewResposta_classificacao_burn_out_classificacao_final_indolencia_desgaste = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_burnOut_indolencia_desgaste);
        textViewResposta_classificacao_burn_out_classificacao_final_indolencia_desgaste_niveis = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_burnOut_indolencia_desgaste_niveis);

        textViewResposta_classificacao_burn_out_classificacao_final_culpa = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_burnOut_culpa);

        //Sono Pitsburg
        //componente 1
        textViewResposta_classificacao_sono_componente_1 = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_1);

        textViewResposta_classificacao_sono_escore_1 = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_1_escore);

        textViewResposta_classificacao_sono_pontuacao_componente_1 = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_pontuacao_componente_1);

        //Componente 2

        textViewResposta_classificacao_sono_componente_2_1_escore = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_2_1_escore);

        textViewResposta_classificacao_sono_componente_2_1_resposta = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_2_1_resposta);

        textViewResposta_classificacao_sono_componente_2_2_escore = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_2_2_escore);

        textViewResposta_classificacao_sono_componente_2_2_resposta = (TextView)
                    findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_2_2_resposta);

        textViewResposta_classificacao_sono_componente_2_3_soma = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_2_3_soma);

        textViewResposta_classificacao_sono_pontuacao_componente_2 = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_pontuacao_componenete_2);

        //COmponente 3

        textViewResposta_classificacao_sono_componenete_3_escore = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_3_escore);
        textViewResposta_classificacao_sono_componente_3_resposta= (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_3_resposta);

        textViewResposta_classificacao_sono_pontuacao_componente_3= (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_pontuacao_componenete_3);

        //componente 4
        textViewResposta_classificacao_sono_componente_4_num_horas_dormidas = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_num_horas_dormidas);

        textViewResposta_classificacao_sono_componente_4_num_horas_leito = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_num_horas_leito);
            textViewResposta_classificacao_sono_componente_4_eficiencia_sono = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_eficiencia_sono);
  textViewResposta_classificacao_sono_componente_4_pontuacao = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_4_escore);
  //componete 5
        textViewResposta_classificacao_sono_componente_5_1_somatoria = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_5_1_somatoria);
        textViewResposta_classificacao_sono_componente_5_1_resposta = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_5_escore);
        textViewResposta_classificacao_sono_componente_5_pontuacao = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_5_pontuacao);

        //componete 6
        textViewResposta_classificacao_sono_componente_6_resposta = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_6);
        textViewResposta_classificacao_sono_componente_6_escore = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_6_escore);
        textViewResposta_classificacao_sono_componente_6_pontuacao = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_6_pontuacao);
        //componente 7

        textViewResposta_classificacao_sono_componente_7_1_escore = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_7_1_escore);
        textViewResposta_classificacao_sono_componente_7_1_resposta = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_7_1_resp);

        textViewResposta_classificacao_sono_componente_7_2_escore = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_7_2_escore);
        textViewResposta_classificacao_sono_componente_7_2_resposta = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_7_2_resp);

        textViewResposta_classificacao_sono_componente_7_3_soma = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_7_3_soma);

        textViewResposta_classificacao_sono_componente_7_pontuacao = (TextView)
                findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_7_pontuacao);

        //SPQI

        textViewResposta_classificacao_sono_PSQI_qualidade = (TextView)
        findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_PSQI_qualidade);

        textViewResposta_classificacao_sono_PSQI_pontuacao = (TextView)
        findViewById(R.id.resp_classificacao_burn_out_classificacao_final_sono_componente_PSQI_pontuacao);



        //Anamnese

       // edtxtNomeProfissional = (EditText) findViewById(R.id.nome_profissional);
        edtxtTelefone = (EditText) findViewById(R.id.telefone_profissional);
        edtxtEmail = (EditText) findViewById(R.id.email_profissional);
        edtxtDataEntrevista = (EditText) findViewById(R.id.data_entrevista);
        edtxCDE = (EditText) findViewById(R.id.CDE);
        edtxtIdade = (EditText) findViewById(R.id.idade);
        edtxtPeso = (EditText) findViewById(R.id.peso);
        edtxtAltura = (EditText) findViewById(R.id.altura);
        radioGroupSexo = (TextView) findViewById(R.id.sexo);

        //Anamnese mutrticvional
        radioGroupRefeicoes = (TextView) findViewById(R.id.refeicoes);
        radioGroupRefeicoesB = (TextView) findViewById(R.id.refeicoes_b);


        //Amnesia atividade fisica
        txt_tipo_atividade_fisica_sim_nao = (TextView) findViewById(R.id.tipo_atividade_fisica_sim_nao);
        edtxtQualAtividade = (EditText) findViewById(R.id.tipo_atividade_fisica);
        edtxtDuracao = (EditText) findViewById(R.id.tipo_atividade_duracao);
        edtxtQuantasVezesSemana = (EditText) findViewById(R.id.tipo_atividade_x_semana);
        intensidade_atividade_fisca = (TextView) findViewById(R.id.intensidade_atividade_fisca);

        //Amnesia atividade profissional
        edtxtFormacao = (EditText) findViewById(R.id.tipo_formacao);
        edtxtTempoProfissao = (EditText) findViewById(R.id.tipo_formacao_profissao_tempo);
        edtxtFormacaoInstituicao = (EditText) findViewById(R.id.tipo_formacao_instituicao);
        edtxtCapacitacao = (TextView) findViewById(R.id.tipo_capacitacao);
        edtxtCargaHorarioTrabalhoSemanal = (EditText) findViewById(R.id.tipo_profissional_media_carga_horaria);
        edtxtCargaQuantasEscolasTrabalho = (EditText) findViewById(R.id.tipo_profissional_qt_escola);
        edtxtAtividadeExerce = (EditText) findViewById(R.id.tipo_profissional_escolas_outras);


        //====================>SINDROME DE BURNOUT<===========================

        textViewResposta_burnout_1 = (TextView) findViewById(R.id.resposta_burnout_1);
        textViewResposta_burnout_2 = (TextView) findViewById(R.id.resposta_burnout_2);

        textViewResposta_burnout_3 = (TextView) findViewById(R.id.resposta_burnout_3);
        textViewResposta_burnout_4 = (TextView) findViewById(R.id.resposta_burnout_4);

        textViewResposta_burnout_5 = (TextView) findViewById(R.id.resposta_burnout_5);
        textViewResposta_burnout_6 = (TextView) findViewById(R.id.resposta_burnout_6);

        textViewResposta_burnout_7 = (TextView) findViewById(R.id.resposta_burnout_7);
        textViewResposta_burnout_8 = (TextView) findViewById(R.id.resposta_burnout_8);

        textViewResposta_burnout_9 = (TextView) findViewById(R.id.resposta_burnout_9);
        textViewResposta_burnout_10 = (TextView) findViewById(R.id.resposta_burnout_10);

        textViewResposta_burnout_11 = (TextView) findViewById(R.id.resposta_burnout_11);
        textViewResposta_burnout_12 = (TextView) findViewById(R.id.resposta_burnout_12);

        textViewResposta_burnout_13 = (TextView) findViewById(R.id.resposta_burnout_13);
        textViewResposta_burnout_14 = (TextView) findViewById(R.id.resposta_burnout_14);

        textViewResposta_burnout_15 = (TextView) findViewById(R.id.resposta_burnout_15);
        textViewResposta_burnout_16 = (TextView) findViewById(R.id.resposta_burnout_16);

        textViewResposta_burnout_17 = (TextView) findViewById(R.id.resposta_burnout_17);
        textViewResposta_burnout_18 = (TextView) findViewById(R.id.resposta_burnout_18);

        textViewResposta_burnout_19 = (TextView) findViewById(R.id.resposta_burnout_19);
        textViewResposta_burnout_20 = (TextView) findViewById(R.id.resposta_burnout_20);


//================================>SONO<=============================================


        edtxtSono_1 = (EditText) findViewById(R.id.questao_sono_1);
        edtxtSono_2 = (EditText) findViewById(R.id.questao_sono_2);
        edtxtSono_3 = (EditText) findViewById(R.id.questao_sono_3);
        edtxtSono_4 = (EditText) findViewById(R.id.questao_sono_4);

        textViewResposta_sono_5_a = (TextView) findViewById(R.id.resposta_sonos_5_a);
        textViewResposta_sono_5_b = (TextView) findViewById(R.id.resposta_sonos_5_b);
        textViewResposta_sono_5_c = (TextView) findViewById(R.id.resposta_sonos_5_c);
        textViewResposta_sono_5_d = (TextView) findViewById(R.id.resposta_sonos_5_d);
        textViewResposta_sono_5_e = (TextView) findViewById(R.id.resposta_sonos_5_e);
        textViewResposta_sono_5_f = (TextView) findViewById(R.id.resposta_sonos_5_f);
        textViewResposta_sono_5_g = (TextView) findViewById(R.id.resposta_sonos_5_g);
        textViewResposta_sono_5_h = (TextView) findViewById(R.id.resposta_sonos_5_h);
        textViewResposta_sono_5_i = (TextView) findViewById(R.id.resposta_sonos_5_i);

        edtxtSono_5_j = (EditText) findViewById(R.id.resposta_sonos_5_j);
        textViewResposta_sono_5_k = (TextView) findViewById(R.id.resposta_sonos_5_k);

        textViewResposta_sono_6 = (TextView) findViewById(R.id.resposta_sonos_6);
        textViewResposta_sono_7 = (TextView) findViewById(R.id.resposta_sonos_7);
        textViewResposta_sono_8 = (TextView) findViewById(R.id.resposta_sonos_8);
        textViewResposta_sono_9 = (TextView) findViewById(R.id.resposta_sonos_9);

//================================>ALIMENTACAO<=============================================
        textViewResposta_alimentacao_1 = (TextView) findViewById(R.id.resposta_alimento_1);
        textViewResposta_alimentacao_2 = (TextView) findViewById(R.id.resposta_alimento_2);
        textViewResposta_alimentacao_3 = (TextView) findViewById(R.id.resposta_alimento_3);
        textViewResposta_alimentacao_4 = (TextView) findViewById(R.id.resposta_alimento_4);
        textViewResposta_alimentacao_5 = (TextView) findViewById(R.id.resposta_alimento_5);
        textViewResposta_alimentacao_6 = (TextView) findViewById(R.id.resposta_alimento_6);
        textViewResposta_alimentacao_7 = (TextView) findViewById(R.id.resposta_alimento_7);
        textViewResposta_alimentacao_8 = (TextView) findViewById(R.id.resposta_alimento_8);
        textViewResposta_alimentacao_9 = (TextView) findViewById(R.id.resposta_alimento_9);
        textViewResposta_alimentacao_10 = (TextView) findViewById(R.id.resposta_alimento_10);

        id = (Integer) getIntent().getSerializableExtra("ID");
        popularLista();

    }


    private void maskText() {

        SimpleMaskFormatter simpleMaskFormatterTelefone = new SimpleMaskFormatter("(NN) NNNNN-NNNN");
        MaskTextWatcher maskTelefone = new MaskTextWatcher(edtxtTelefone, simpleMaskFormatterTelefone);
        edtxtTelefone.addTextChangedListener(maskTelefone);

        SimpleMaskFormatter simpleMaskFormatterData = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher maskData = new MaskTextWatcher(edtxtDataEntrevista, simpleMaskFormatterData);
        edtxtDataEntrevista.addTextChangedListener(maskData);

    }

    private ListaTotalDadosPesquisa retornoListaCLasse(int tabela) {

        ListaTotalDadosPesquisa listaClasses = new ListaTotalDadosPesquisa();
        listaClasses = (ListaTotalDadosPesquisa) DAOCadastro.getInstance().listarDadosProfissionalPorId(id,tabela);
        return listaClasses;

    }



    private void popularLista() {

        AlimentacaoBeans alimentacaoBeans;
        SonoPittsburghBeans sonoPittsburghBeans;
        AnamineseProfissionalBean anamineseProfissionalBean;
        BurnOutBean burnOutBean;


        anamineseProfissionalBean = new AnamineseProfissionalBean();
        sonoPittsburghBeans = new SonoPittsburghBeans();
        alimentacaoBeans = new AlimentacaoBeans();
        burnOutBean = new BurnOutBean();


        ListaTotalDadosPesquisa listaTotalDadosPesquisaAnaminase = retornoListaCLasse(Constantes.TABELA_CADASTRO_PROFISSIONAL);
        anamineseProfissionalBean = (AnamineseProfissionalBean) listaTotalDadosPesquisaAnaminase.getAnamineseProfissionalBean();


            /*
       ANAMNESE
        */


     //   edtxtNomeProfissional.setText(anamineseProfissionalBean.getNomeProfissional());
        edtxtTelefone.setText(anamineseProfissionalBean.getTelefone());
        edtxtEmail.setText(anamineseProfissionalBean.getEmail());
        edtxtDataEntrevista.setText(anamineseProfissionalBean.getDtEntrevista());
        edtxCDE.setText(Integer.toString(anamineseProfissionalBean.getCDE()));
        edtxtPeso.setText(anamineseProfissionalBean.getPeso());
        edtxtAltura.setText(anamineseProfissionalBean.getAltura());
        edtxtIdade.setText(anamineseProfissionalBean.getIdade());
        radioGroupSexo.setText(anamineseProfissionalBean.getSexo());

        if (anamineseProfissionalBean.getRefeicaoDiariaA() == true) {

            radioGroupRefeicoesB.setText(" ");
        } else {
            radioGroupRefeicoes.setText(" ");

        }
        if (anamineseProfissionalBean.getPraticaAtividadeFisica()) {
            txt_tipo_atividade_fisica_sim_nao.setText("Sim");
        } else {
            txt_tipo_atividade_fisica_sim_nao.setText("Não");
        }


        edtxtQualAtividade.setText(anamineseProfissionalBean.getNomeAtividade());
        edtxtDuracao.setText(anamineseProfissionalBean.getDuracaoAtividade());
        edtxtQuantasVezesSemana.setText(Integer.toString(anamineseProfissionalBean.getQtAtividadeVezesSemana()));

        if (Boolean.valueOf(anamineseProfissionalBean.getIntensidadeLeve())) {
            intensidade_atividade_fisca.setText("Leve");
        }
        if (Boolean.valueOf(anamineseProfissionalBean.getIntensidadeMedia())) {
            intensidade_atividade_fisca.setText("Media");
        }
        if (Boolean.valueOf(anamineseProfissionalBean.getIntensidadeAlta())) {
            intensidade_atividade_fisca.setText("Alta");
        }

        edtxtFormacao.setText(anamineseProfissionalBean.getFormacaoProf());
        edtxtTempoProfissao.setText(Integer.toString(anamineseProfissionalBean.getTempoFormacaoProf()));
        edtxtFormacaoInstituicao.setText(anamineseProfissionalBean.getIntituicaoFormacaoProf());
        if (anamineseProfissionalBean.getCapacitacaoDoisAnos()) {
            edtxtCapacitacao.setText(" Sim");
        } else {
            edtxtCapacitacao.setText(" Não");
        }

        edtxtCargaHorarioTrabalhoSemanal.setText(Integer.toString(anamineseProfissionalBean.getCargaHoraria()));
        edtxtCargaQuantasEscolasTrabalho.setText(Integer.toString(anamineseProfissionalBean.getQTEscolas()));
        edtxtAtividadeExerce.setText(anamineseProfissionalBean.getOutrasAtividades());

        //burnout
        ListaTotalDadosPesquisa listaTotalDadosBurnOut = retornoListaCLasse(Constantes.TABELA_CADASTRO_BURNOUT);
        burnOutBean = (BurnOutBean) listaTotalDadosBurnOut.getBurnOutBean();
        textViewResposta_burnout_1.setText(Integer.toString(burnOutBean.getPergunta_01()));
        textViewResposta_burnout_2.setText(Integer.toString(burnOutBean.getPergunta_02()));
        textViewResposta_burnout_3.setText(Integer.toString(burnOutBean.getPergunta_03()));
        textViewResposta_burnout_4.setText(Integer.toString(burnOutBean.getPergunta_04()));
        textViewResposta_burnout_5.setText(Integer.toString(burnOutBean.getPergunta_05()));
        textViewResposta_burnout_6.setText(Integer.toString(burnOutBean.getPergunta_06()));
        textViewResposta_burnout_7.setText(Integer.toString(burnOutBean.getPergunta_07()));
        textViewResposta_burnout_8.setText(Integer.toString(burnOutBean.getPergunta_08()));
        textViewResposta_burnout_9.setText(Integer.toString(burnOutBean.getPergunta_09()));
        textViewResposta_burnout_10.setText(Integer.toString(burnOutBean.getPergunta_10()));
        textViewResposta_burnout_11.setText(Integer.toString(burnOutBean.getPergunta_11()));
        textViewResposta_burnout_12.setText(Integer.toString(burnOutBean.getPergunta_12()));
        textViewResposta_burnout_13.setText(Integer.toString(burnOutBean.getPergunta_13()));
        textViewResposta_burnout_14.setText(Integer.toString(burnOutBean.getPergunta_14()));
        textViewResposta_burnout_15.setText(Integer.toString(burnOutBean.getPergunta_15()));
        textViewResposta_burnout_16.setText(Integer.toString(burnOutBean.getPergunta_16()));
        textViewResposta_burnout_17.setText(Integer.toString(burnOutBean.getPergunta_17()));
        textViewResposta_burnout_18.setText(Integer.toString(burnOutBean.getPergunta_18()));
        textViewResposta_burnout_19.setText(Integer.toString(burnOutBean.getPergunta_19()));
        textViewResposta_burnout_20.setText(Integer.toString(burnOutBean.getPergunta_20()));
        //sono pittsburg

        ListaTotalDadosPesquisa listaTotalDadosSonoPitt = retornoListaCLasse(Constantes.TABELA_CADASTRO_SONO_PITSBURGH);
        sonoPittsburghBeans = (SonoPittsburghBeans) listaTotalDadosSonoPitt.getSonoPittsburghBeans();

        edtxtSono_1.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_01()));
        edtxtSono_2.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_02()));
        edtxtSono_3.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_03()));
        edtxtSono_4.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_04()));
        textViewResposta_sono_5_a.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_05_a()));
        textViewResposta_sono_5_b.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_05_b()));
        textViewResposta_sono_5_c.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_05_c()));
        textViewResposta_sono_5_d.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_05_d()));
        textViewResposta_sono_5_e.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_05_e()));
        textViewResposta_sono_5_f.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_05_f()));
        textViewResposta_sono_5_g.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_05_g()));
        textViewResposta_sono_5_h.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_05_h()));
        textViewResposta_sono_5_i.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_05_h()));
        edtxtSono_5_j.setText((sonoPittsburghBeans.getPergunta_sono_05_j()));
        textViewResposta_sono_5_k.setText(Integer.toString(sonoPittsburghBeans.getPergunta_sono_05_h()));
        textViewResposta_sono_6.setText((sonoPittsburghBeans.getPergunta_sono_06()));
        textViewResposta_sono_7.setText((Integer.toString(sonoPittsburghBeans.getPergunta_sono_07())));
        textViewResposta_sono_8.setText((Integer.toString(sonoPittsburghBeans.getPergunta_sono_08())));
        textViewResposta_sono_9.setText((Integer.toString(sonoPittsburghBeans.getPergunta_sono_09())));

        //alimentacao
        ListaTotalDadosPesquisa listaTotalDadosAlimentacao = retornoListaCLasse(Constantes.TABELA_CADASTRO_FREQUENCIA_ALIMENTO);
        alimentacaoBeans = (AlimentacaoBeans) listaTotalDadosAlimentacao.getAlimentacaoBeans();
        textViewResposta_alimentacao_1.setText(Integer.toString(alimentacaoBeans.getPergunta_alimentacao_01()));
        textViewResposta_alimentacao_2.setText(Integer.toString(alimentacaoBeans.getPergunta_alimentacao_02()));
        textViewResposta_alimentacao_3.setText(Integer.toString(alimentacaoBeans.getPergunta_alimentacao_03()));
        textViewResposta_alimentacao_4.setText(Integer.toString(alimentacaoBeans.getPergunta_alimentacao_04()));
        textViewResposta_alimentacao_5.setText(Integer.toString(alimentacaoBeans.getPergunta_alimentacao_05()));
        textViewResposta_alimentacao_6.setText(Integer.toString(alimentacaoBeans.getPergunta_alimentacao_06()));
        textViewResposta_alimentacao_7.setText(Integer.toString(alimentacaoBeans.getPergunta_alimentacao_07()));
        textViewResposta_alimentacao_8.setText(Integer.toString(alimentacaoBeans.getPergunta_alimentacao_08()));
        textViewResposta_alimentacao_9.setText(Integer.toString(alimentacaoBeans.getPergunta_alimentacao_09()));
        textViewResposta_alimentacao_10.setText(Integer.toString(alimentacaoBeans.getPergunta_alimentacao_10()));


        /**
         * classificação resultados Burn out exibir na tela
         */
        ClassificacaoBurnOut classificacaoBurnOut = new ClassificacaoBurnOut();
        classificacaoBurnOut.calcularSindromeBurnOut(anamineseProfissionalBean, burnOutBean);

        /**
         *
         *Inserir dados automaticamente RESPOSTA CLASSIFICACAO BURN OUT
         */

        DAOCadastro.getInstance().inserirResultadosBurnOut(id,classificacaoBurnOut);


        textViewResposta_classificacao_burn_out_somatorio_ilusao.setText(
                Integer.toString(burnOutBean.getPergunta_01()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_05()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_10()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_15()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_19()) + "+" +
                        "=" +
                        Integer.toString(classificacaoBurnOut.getClassificacaoBurnOutBeans().getSomatorioIlusao()));

        textViewResposta_classificacao_burn_out_classificacao_ilusao.setText(
                classificacaoBurnOut.getClassificacaoBurnOutBeans().getClassificacaoIlusaoTrabalho()
        );

        textViewResposta_classificacao_burn_out_somatorio_desgaste_psiquico.setText(
                Integer.toString(burnOutBean.getPergunta_08()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_12()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_17()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_18()) + "+" +
                        "=" +
                        Integer.toString(classificacaoBurnOut.getClassificacaoBurnOutBeans().getSomatorioDesgastePsiquico())

        );

        textViewResposta_classificacao_burn_out_classificaco_desgaste_psiquico.setText(Integer.toString(classificacaoBurnOut
                .getClassificacaoBurnOutBeans().getClassificacaoDesgastePsiquico()));

        //indolencia
        textViewResposta_classificacao_burn_out_somatorio_indolencia.setText(
                Integer.toString(burnOutBean.getPergunta_03()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_02()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_06()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_07()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_11()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_14()) + "+" +
                        "=" +
                        Integer.toString(classificacaoBurnOut.getClassificacaoBurnOutBeans().getSomatorioIndolencia())

        );
        textViewResposta_classificacao_burn_out_classificaco_indolencia.setText(
                Integer.toString(classificacaoBurnOut.getClassificacaoBurnOutBeans().getClassificacaoIndolencia())
        );
        //classifcacao indolencia + psiquico

        textViewResposta_classificacao_burn_out_somatorio_indolencia_psiquica.setText(
                Integer.toString(classificacaoBurnOut.getClassificacaoBurnOutBeans().getDesgastePsiquicoIndolenciaTotal())
        );

        textViewResposta_classificacao_burn_out_classificacao_indolencia_psiquica.setText(
                classificacaoBurnOut.getClassificacaoBurnOutBeans().getClassificacaoDesgastePsiquicoIndolencia()
        );

        //culpa
        textViewResposta_classificacao_burn_out_somatiorio_culpa.setText(
                Integer.toString(burnOutBean.getPergunta_04()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_09()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_13()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_16()) + "+" +
                        Integer.toString(burnOutBean.getPergunta_20()) + "+" +
                        "=" +
                        Integer.toString(classificacaoBurnOut.getClassificacaoBurnOutBeans().getSomatorioCulpa())
        );
        textViewResposta_classificacao_burn_out_classificacao_culpa.setText(
                classificacaoBurnOut.getClassificacaoBurnOutBeans().getClassificacaoCulpa()


        );

        //Classificacao Geral
        textViewResposta_classificacao_burn_out_classificacao_final_ilusao.setText(
                Integer.toString(classificacaoBurnOut.getClassificacaoBurnOutBeans().getPercentualIlusao()) + "%"
        );
        textViewResposta_classificacao_burn_out_classificacao_final_ilusao_niveis.setText(
                classificacaoBurnOut.getClassificacaoBurnOutBeans().getClassifcacaoNivelIlusao()
        );

        textViewResposta_classificacao_burn_out_classificacao_final_indolencia_desgaste.setText(
                Integer.toString(classificacaoBurnOut.getClassificacaoBurnOutBeans().getPercentuaDesgasteIndolencia()) + "%"

        );

        textViewResposta_classificacao_burn_out_classificacao_final_indolencia_desgaste_niveis.setText(
                classificacaoBurnOut.getClassificacaoBurnOutBeans().getClassifcacaoNivelPsiquicoIndolencia()

        );
        textViewResposta_classificacao_burn_out_classificacao_final_culpa.setText(
                Integer.toString(classificacaoBurnOut.getClassificacaoBurnOutBeans().getPercentuaCulpa()) + "%"

        );


        ClassificacaoSonoPittsburgh classificacaoSonoPittsburgh = new ClassificacaoSonoPittsburgh();
        classificacaoSonoPittsburgh.classificarSonoPitssburgh(sonoPittsburghBeans);

        //Classificacao Sono Pittsburgh


        //componente 1

        textViewResposta_classificacao_sono_componente_1.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPontuacaoComponente_1())


        );

        textViewResposta_classificacao_sono_escore_1.setText(

                classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getComponente_1_resposta_qualidadeSubjetivaSono_q6()


        );

        textViewResposta_classificacao_sono_pontuacao_componente_1.setText(

                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPontuacaoComponente_1())
        );

        //Componente 2

        textViewResposta_classificacao_sono_componente_2_1_escore.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getComponente_2_escore_LatenciaSono_q2())
        );
        textViewResposta_classificacao_sono_componente_2_1_resposta.setText(
                classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getComponente_2_resposta_LatenciaSono_q2()
        );

        textViewResposta_classificacao_sono_componente_2_2_escore.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getComponente_2_escore_q5())

        );
        textViewResposta_classificacao_sono_componente_2_2_resposta.setText(
                classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getComponente_2_2_resposta_q5()

        );
        textViewResposta_classificacao_sono_componente_2_3_soma.setText(
               Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getComponente_2_4_soma())

        );
        textViewResposta_classificacao_sono_pontuacao_componente_2.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPontuacaoComponente_2())

        );

        //componenete 3

        textViewResposta_classificacao_sono_componenete_3_escore.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPontuacaoComponente_3())

        );

        textViewResposta_classificacao_sono_componente_3_resposta.setText(
                classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getComponente_3resposta_Questao_4()

        );
        textViewResposta_classificacao_sono_pontuacao_componente_3.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPontuacaoComponente_3())

        );

        //componenete 4

        textViewResposta_classificacao_sono_componente_4_num_horas_dormidas.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getComponente_4_numHorasDormidas())
        );

        textViewResposta_classificacao_sono_componente_4_num_horas_leito.setText(

                Long.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getComponente_4_numHorasLeito())
        );

        textViewResposta_classificacao_sono_componente_4_eficiencia_sono.setText(

                classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPercentagem_componente_04()
        );

        textViewResposta_classificacao_sono_componente_4_pontuacao.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPontuacaoComponente_4())
        );
        //componentge 5

        textViewResposta_classificacao_sono_componente_5_1_somatoria.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getComponente_5_somatoria_a_k())
        );

        textViewResposta_classificacao_sono_componente_5_1_resposta.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPontuacaoComponente_5())

        );
        textViewResposta_classificacao_sono_componente_5_pontuacao.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPontuacaoComponente_5())

        );

        //Componenet 6

        textViewResposta_classificacao_sono_componente_6_resposta.setText(
                classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getComponente_6_resposta()
        );
        textViewResposta_classificacao_sono_componente_6_escore.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPontuacaoComponente_6())
        );
        textViewResposta_classificacao_sono_componente_6_pontuacao.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPontuacaoComponente_6())
        );
        //Componenet 7

        textViewResposta_classificacao_sono_componente_7_1_resposta.setText(
                classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getResposta_questao_7_1()

        );
        textViewResposta_classificacao_sono_componente_7_1_escore.setText(
               Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPontuacao_questao_7_1())


        ); textViewResposta_classificacao_sono_componente_7_2_resposta.setText(
                classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getResposta_questao_7_2()

        );
        textViewResposta_classificacao_sono_componente_7_2_escore.setText(
               Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPontuacao_questao_7_1())


        );
        textViewResposta_classificacao_sono_componente_7_3_soma.setText(
               Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getSomatoria_questao_7_3_9_sum_8())


        );

        textViewResposta_classificacao_sono_componente_7_pontuacao.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getPontuacaoComponente_7())
        );

        //PSQI
        textViewResposta_classificacao_sono_PSQI_qualidade.setText(
                classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getResultado_total_PSQI_componentes()
        );
        textViewResposta_classificacao_sono_PSQI_pontuacao.setText(
                Integer.toString(classificacaoSonoPittsburgh.getClassificacaoSonoPittsburghBeans().getEscore_total_PSQI_componentes())
        );



    }



}




