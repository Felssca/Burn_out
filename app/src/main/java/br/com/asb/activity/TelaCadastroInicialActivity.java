package br.com.asb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.ArrayList;
import java.util.Map;

import br.com.asb.R;
import br.com.asb.bean.AlimentacaoBeans;
import br.com.asb.bean.AnamineseProfissionalBean;
import br.com.asb.bean.BurnOutBean;
import br.com.asb.bean.SonoPittsburghBeans;
import br.com.asb.dialog.GeneralSysDialog;
import br.com.asb.persistencia.dao.DAOCadastro;
import br.com.asb.util.Constantes;
import br.com.asb.util.UtilDiversos;

public class TelaCadastroInicialActivity extends Activity {

    ArrayAdapter<String> adapter;
    ArrayList<String> listAlunos;
    ArrayList<Map.Entry<String, String>> listaAlunosMatChave;

    AnamineseProfissionalBean anamineseProfissionalBean;


    //ANAMNASE
    private EditText edtxtNomeProfissional;
    private EditText edtxtTelefone;
    private EditText edtxtEmail;
    private EditText edtxtDataEntrevista;
   // private EditText edtxCDE;
    private EditText edtxtIdade;
    private EditText edtxtPeso;
    private EditText edtxtAltura;

    private RadioGroup radioGroupSexo;
    private RadioButton radioButtonSexo;

    //ANAMNASE NUTRICIONAL
    private RadioGroup radioGroupRefeicoes;
    private RadioButton radioButtonRefeicoes;

    //ANAMNESE ATIVIDADE FISICA
    private RadioGroup radioGroupAtividadeFisica;
    private RadioButton radioButtonAtividadeFisica;
    private RadioButton radioIntensidadeLeve;
    private RadioButton radioIntensidadeMedia;
    private RadioButton radioIntensidadeAlta;

    private EditText edtxtQualAtividade;
    private EditText edtxtDuracao;
    private EditText edtxtQuantasVezesSemana;

    private RadioGroup radioGroupIntensidade;
    private RadioButton radioButtonIntensidade;

    //ANAMNESE PROFISSIONAL
    private EditText edtxtFormacao;
    private EditText edtxtTempoProfissao;
    private EditText edtxtTempoInstituicao;

    private RadioGroup radioGroupCapacitacao;
    private RadioButton radioButtonCapacitacao;

    private EditText edtxtCargaHorarioTrabalhoSemanal;
    private EditText edtxtCargaQuantasEscolasTrabalho;
    private EditText edtxtAtividadeExerce;

    //SINDROME DE BURNOUT
    private RadioGroup radioGroupResposta_burnout_1;
    private RadioButton radioButtomResposta_burnout_1;
    private RadioGroup radioGroupResposta_burnout_2;
    private RadioButton radioButtomResposta_burnout_2;
    private RadioGroup radioGroupResposta_burnout_3;
    private RadioButton radioButtomResposta_burnout_3;
    private RadioGroup radioGroupResposta_burnout_4;
    private RadioButton radioButtomResposta_burnout_4;
    private RadioGroup radioGroupResposta_burnout_5;
    private RadioButton radioButtomResposta_burnout_5;

    private RadioGroup radioGroupResposta_burnout_6;
    private RadioButton radioButtomResposta_burnout_6;
    private RadioGroup radioGroupResposta_burnout_7;
    private RadioButton radioButtomResposta_burnout_7;
    private RadioGroup radioGroupResposta_burnout_8;
    private RadioButton radioButtomResposta_burnout_8;
    private RadioGroup radioGroupResposta_burnout_9;
    private RadioButton radioButtomResposta_burnout_9;
    private RadioGroup radioGroupResposta_burnout_10;
    private RadioButton radioButtomResposta_burnout_10;

    private RadioGroup radioGroupResposta_burnout_11;
    private RadioButton radioButtomResposta_burnout_11;
    private RadioGroup radioGroupResposta_burnout_12;
    private RadioButton radioButtomResposta_burnout_12;
    private RadioGroup radioGroupResposta_burnout_13;
    private RadioButton radioButtomResposta_burnout_13;
    private RadioGroup radioGroupResposta_burnout_14;
    private RadioButton radioButtomResposta_burnout_14;
    private RadioGroup radioGroupResposta_burnout_15;
    private RadioButton radioButtomResposta_burnout_15;

    private RadioGroup radioGroupResposta_burnout_16;
    private RadioButton radioButtomResposta_burnout_16;
    private RadioGroup radioGroupResposta_burnout_17;
    private RadioButton radioButtomResposta_burnout_17;
    private RadioGroup radioGroupResposta_burnout_18;
    private RadioButton radioButtomResposta_burnout_18;
    private RadioGroup radioGroupResposta_burnout_19;
    private RadioButton radioButtomResposta_burnout_19;
    private RadioGroup radioGroupResposta_burnout_20;
    private RadioButton radioButtomResposta_burnout_20;

    private ImageView imagemBell;
    private ImageView imagemBell2;
    private ImageView imagemBell3;
    private ImageView imagemBell4;

    //INDICE DE QUALIDADE DO SONO
    private EditText edtxtSono_1;
    private EditText edtxtSono_2;
    private EditText edtxtSono_3;
    private EditText edtxtSono_4;

    private RadioGroup radioGroupResposta_sono_5_a;
    private RadioButton radioButtomResposta__sono_5_a;
    private RadioGroup radioGroupResposta_sono_5_b;
    private RadioButton radioButtomResposta__sono_5_b;
    private RadioGroup radioGroupResposta_sono_5_c;
    private RadioButton radioButtomResposta__sono_5_c;
    private RadioGroup radioGroupResposta_sono_5_d;
    private RadioButton radioButtomResposta__sono_5_d;
    private RadioGroup radioGroupResposta_sono_5_e;
    private RadioButton radioButtomResposta__sono_5_e;
    private RadioGroup radioGroupResposta_sono_5_f;
    private RadioButton radioButtomResposta__sono_5_f;
    private RadioGroup radioGroupResposta_sono_5_g;
    private RadioButton radioButtomResposta__sono_5_g;
    private RadioGroup radioGroupResposta_sono_5_h;
    private RadioButton radioButtomResposta__sono_5_h;
    private RadioGroup radioGroupResposta_sono_5_i;
    private RadioButton radioButtomResposta__sono_5_i;

    private EditText edtxtSono_5_j;
    private RadioGroup radioGroupResposta_sono_5_k;
    private RadioButton radioButtomResposta__sono_5_k;

    private RadioGroup radioGroupResposta_sono_6;
    private RadioButton radioButtomResposta__sono_6;

    private RadioGroup radioGroupResposta_sono_7;
    private RadioButton radioButtomResposta__sono_7;

    private RadioGroup radioGroupResposta_sono_8;
    private RadioButton radioButtomResposta__sono_8;

    private RadioGroup radioGroupResposta_sono_9;
    private RadioButton radioButtomResposta__sono_9;

    private ImageView imagemBell5;
    private ImageView imagemBell6;
    private ImageView imagemBell7;

    //ALIMENTACAO
    private RadioGroup radioGroupResposta_alimentacao_1;
    private RadioButton radioButtomResposta__alimentacao_1;
    private RadioGroup radioGroupResposta_alimentacao_2;
    private RadioButton radioButtomResposta__alimentacao_2;
    private RadioGroup radioGroupResposta_alimentacao_3;
    private RadioButton radioButtomResposta__alimentacao_3;
    private RadioGroup radioGroupResposta_alimentacao_4;
    private RadioButton radioButtomResposta__alimentacao_4;
    private RadioGroup radioGroupResposta_alimentacao_5;
    private RadioButton radioButtomResposta__alimentacao_5;
    private RadioGroup radioGroupResposta_alimentacao_6;
    private RadioButton radioButtomResposta__alimentacao_6;
    private RadioGroup radioGroupResposta_alimentacao_7;
    private RadioButton radioButtomResposta__alimentacao_7;
    private RadioGroup radioGroupResposta_alimentacao_8;
    private RadioButton radioButtomResposta__alimentacao_8;
    private RadioGroup radioGroupResposta_alimentacao_9;
    private RadioButton radioButtomResposta__alimentacao_9;
    private RadioGroup radioGroupResposta_alimentacao_10;
    private RadioButton radioButtomResposta__alimentacao_10;


    private Button btnCadastro;


    String nenhuma = "Nenhuma";


    private TextView txtInicioContadorLista;
    private GeneralSysDialog generalSysDialog;

    private int cont = 0;

    UtilDiversos utilDiversos = new UtilDiversos();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_inicial);
        View view = (View) this.getWindow().getDecorView().findViewById(android.R.id.content);

        intiView();
        maskText();
        acaoButton();
        controleAtividadeFisica();

    }

    private void intiView() {

        //Anamnese

     //   edtxtNomeProfissional = (EditText) findViewById(R.id.nome_profissional);
        edtxtTelefone = (EditText) findViewById(R.id.telefone_profissional);
        edtxtEmail = (EditText) findViewById(R.id.email_profissional);
        edtxtDataEntrevista = (EditText) findViewById(R.id.data_entrevista);
       // edtxCDE = (EditText) findViewById(R.id.CDE);
        edtxtIdade = (EditText) findViewById(R.id.idade);
        edtxtPeso = (EditText) findViewById(R.id.peso);
        edtxtAltura = (EditText) findViewById(R.id.altura);
        radioGroupSexo = (RadioGroup) findViewById(R.id.sexo);

        //Anamnese mutrticvional
        radioGroupRefeicoes = (RadioGroup) findViewById(R.id.refeicoes);

        //Amnesia atividade fisica
        radioGroupAtividadeFisica = (RadioGroup) findViewById(R.id.bol_pratica_atividade_fisica);
        edtxtQualAtividade = (EditText) findViewById(R.id.tipo_atividade_fisica);
        edtxtDuracao = (EditText) findViewById(R.id.tipo_atividade_duracao);
        edtxtQuantasVezesSemana = (EditText) findViewById(R.id.tipo_atividade_x_semana);
        radioGroupIntensidade = (RadioGroup) findViewById(R.id.intensidade_atividade_fisca);
        radioIntensidadeLeve = (RadioButton) findViewById(R.id.intensidade_atividade_fisca_leve);
        radioIntensidadeMedia = (RadioButton) findViewById(R.id.intensidade_atividade_fisca_media);
        radioIntensidadeAlta = (RadioButton) findViewById(R.id.intensidade_atividade_fisca_alta);


        //Amnesia atividade profissional
        //edtxtFormacao = (EditText) findViewById(R.id.tipo_formacao);
        edtxtTempoProfissao = (EditText) findViewById(R.id.tipo_formacao_profissao_tempo);
        //edtxtTempoInstituicao = (EditText) findViewById(R.id.tipo_formacao_instituicao);
        radioGroupCapacitacao = (RadioGroup) findViewById(R.id.tipo_capacitacao);
        edtxtCargaHorarioTrabalhoSemanal = (EditText) findViewById(R.id.tipo_profissional_media_carga_horaria);
        edtxtCargaQuantasEscolasTrabalho = (EditText) findViewById(R.id.tipo_profissional_qt_escola);
        edtxtAtividadeExerce = (EditText) findViewById(R.id.tipo_profissional_escolas_outras);


        //====================>SINDROME DE BURNOUT<===========================

        radioGroupResposta_burnout_1 = (RadioGroup) findViewById(R.id.resposta_burnout_1);
        radioGroupResposta_burnout_2 = (RadioGroup) findViewById(R.id.resposta_burnout_2);

        radioGroupResposta_burnout_3 = (RadioGroup) findViewById(R.id.resposta_burnout_3);
        radioGroupResposta_burnout_4 = (RadioGroup) findViewById(R.id.resposta_burnout_4);

        radioGroupResposta_burnout_5 = (RadioGroup) findViewById(R.id.resposta_burnout_5);
        radioGroupResposta_burnout_6 = (RadioGroup) findViewById(R.id.resposta_burnout_6);

        radioGroupResposta_burnout_7 = (RadioGroup) findViewById(R.id.resposta_burnout_7);
        radioGroupResposta_burnout_8 = (RadioGroup) findViewById(R.id.resposta_burnout_8);

        radioGroupResposta_burnout_9 = (RadioGroup) findViewById(R.id.resposta_burnout_9);
        radioGroupResposta_burnout_10 = (RadioGroup) findViewById(R.id.resposta_burnout_10);

        radioGroupResposta_burnout_11 = (RadioGroup) findViewById(R.id.resposta_burnout_11);
        radioGroupResposta_burnout_12 = (RadioGroup) findViewById(R.id.resposta_burnout_12);

        radioGroupResposta_burnout_13 = (RadioGroup) findViewById(R.id.resposta_burnout_13);
        radioGroupResposta_burnout_14 = (RadioGroup) findViewById(R.id.resposta_burnout_14);

        radioGroupResposta_burnout_15 = (RadioGroup) findViewById(R.id.resposta_burnout_15);
        radioGroupResposta_burnout_16 = (RadioGroup) findViewById(R.id.resposta_burnout_16);

        radioGroupResposta_burnout_17 = (RadioGroup) findViewById(R.id.resposta_burnout_17);
        radioGroupResposta_burnout_18 = (RadioGroup) findViewById(R.id.resposta_burnout_18);

        radioGroupResposta_burnout_19 = (RadioGroup) findViewById(R.id.resposta_burnout_19);
        radioGroupResposta_burnout_20 = (RadioGroup) findViewById(R.id.resposta_burnout_20);

        imagemBell = (ImageView) findViewById(R.id.imagemLembrete);
        imagemBell2 = (ImageView) findViewById(R.id.imagemLembrete_2);
        imagemBell3 = (ImageView) findViewById(R.id.imagemLembrete_3);
        imagemBell4 = (ImageView) findViewById(R.id.imagemLembrete_4);


//================================>SONO<=============================================


        edtxtSono_1 = (EditText) findViewById(R.id.questao_sono_1);
        edtxtSono_2 = (EditText) findViewById(R.id.questao_sono_2);
        edtxtSono_3 = (EditText) findViewById(R.id.questao_sono_3);
        edtxtSono_4 = (EditText) findViewById(R.id.questao_sono_4);

        radioGroupResposta_sono_5_a = (RadioGroup) findViewById(R.id.resposta_sonos_5_a);
        radioGroupResposta_sono_5_b = (RadioGroup) findViewById(R.id.resposta_sonos_5_b);
        radioGroupResposta_sono_5_c = (RadioGroup) findViewById(R.id.resposta_sonos_5_c);
        radioGroupResposta_sono_5_d = (RadioGroup) findViewById(R.id.resposta_sonos_5_d);
        radioGroupResposta_sono_5_e = (RadioGroup) findViewById(R.id.resposta_sonos_5_e);
        radioGroupResposta_sono_5_f = (RadioGroup) findViewById(R.id.resposta_sonos_5_f);
        radioGroupResposta_sono_5_g = (RadioGroup) findViewById(R.id.resposta_sonos_5_g);
        radioGroupResposta_sono_5_h = (RadioGroup) findViewById(R.id.resposta_sonos_5_h);
        radioGroupResposta_sono_5_i = (RadioGroup) findViewById(R.id.resposta_sonos_5_i);

        edtxtSono_5_j = (EditText) findViewById(R.id.resposta_sonos_5_j);
        radioGroupResposta_sono_5_k = (RadioGroup) findViewById(R.id.resposta_sonos_5_k);

        radioGroupResposta_sono_6 = (RadioGroup) findViewById(R.id.resposta_sono_6);
        radioGroupResposta_sono_7 = (RadioGroup) findViewById(R.id.resposta_sonos_7);
        radioGroupResposta_sono_8 = (RadioGroup) findViewById(R.id.resposta_sonos_8);
        radioGroupResposta_sono_9 = (RadioGroup) findViewById(R.id.resposta_sonos_9);

        imagemBell5 = (ImageView) findViewById(R.id.imagemLembrete_pittsburgh_1);
        imagemBell6 = (ImageView) findViewById(R.id.imagemLembrete_pittsburgh_2);
        imagemBell7 = (ImageView) findViewById(R.id.imagemLembrete_pittsburgh_3);


//================================>ALIMENTACAO<=============================================
        radioGroupResposta_alimentacao_1 = (RadioGroup) findViewById(R.id.resposta_alimento_1);
        radioGroupResposta_alimentacao_2 = (RadioGroup) findViewById(R.id.resposta_alimento_2);
        radioGroupResposta_alimentacao_3 = (RadioGroup) findViewById(R.id.resposta_alimento_3);
        radioGroupResposta_alimentacao_4 = (RadioGroup) findViewById(R.id.resposta_alimento_4);
        radioGroupResposta_alimentacao_5 = (RadioGroup) findViewById(R.id.resposta_alimento_5);
        radioGroupResposta_alimentacao_6 = (RadioGroup) findViewById(R.id.resposta_alimento_6);
        radioGroupResposta_alimentacao_7 = (RadioGroup) findViewById(R.id.resposta_alimento_7);
        radioGroupResposta_alimentacao_8 = (RadioGroup) findViewById(R.id.resposta_alimento_8);
        radioGroupResposta_alimentacao_9 = (RadioGroup) findViewById(R.id.resposta_alimento_9);
        radioGroupResposta_alimentacao_10 = (RadioGroup) findViewById(R.id.resposta_alimento_10);


        btnCadastro = (Button) findViewById(R.id.btn_cadastrar_pesquisa_completa);

    }

    private void controleAtividadeFisica() {


        radioGroupAtividadeFisica.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                if (checkedId == R.id.bol_pratica_atividade_fisica_sim) {
                    habilitarCamposAtividadeFisica();

                } else if (checkedId == R.id.bol_pratica_atividade_fisica_nao) {
                    DesabilitarCamposAtividadeFisica();
                }

            }

        });

    }

    private void habilitarCamposAtividadeFisica() {

        edtxtQualAtividade.setEnabled(true);
        edtxtDuracao.setEnabled(true);
        edtxtQuantasVezesSemana.setEnabled(true);
        radioIntensidadeLeve.setEnabled(true);
        radioIntensidadeMedia.setEnabled(true);
        radioIntensidadeAlta.setEnabled(true);

    }

    private void DesabilitarCamposAtividadeFisica() {

        edtxtQualAtividade.setEnabled(false);
        edtxtDuracao.setEnabled(false);
        edtxtQuantasVezesSemana.setEnabled(false);
        radioIntensidadeLeve.setEnabled(false);
        radioIntensidadeMedia.setEnabled(false);
        radioIntensidadeAlta.setEnabled(false);


    }







    private void acaoButton() {


        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    cadastrarEntrevistado();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }

    private boolean isEmpty(String campo) {
        boolean isEmpty;

        if (TextUtils.isEmpty(campo)) {
            isEmpty = true;

        } else {
            isEmpty = false;

        }

        return isEmpty;
    }


    private void maskText() {

        SimpleMaskFormatter simpleMaskFormatterTelefone = new SimpleMaskFormatter("(NN) NNNNN-NNNN");
        MaskTextWatcher maskTelefone = new MaskTextWatcher(edtxtTelefone, simpleMaskFormatterTelefone);
        edtxtTelefone.addTextChangedListener(maskTelefone);

        SimpleMaskFormatter simpleMaskFormatterData = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher maskData = new MaskTextWatcher(edtxtDataEntrevista, simpleMaskFormatterData);
        edtxtDataEntrevista.addTextChangedListener(maskData);

        SimpleMaskFormatter simpleMaskFormatterHora = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher maskHora = new MaskTextWatcher(edtxtSono_1, simpleMaskFormatterHora);
        edtxtSono_1.addTextChangedListener(maskHora);

        MaskTextWatcher maskHora_3 = new MaskTextWatcher(edtxtSono_3, simpleMaskFormatterHora);
        edtxtSono_3.addTextChangedListener(maskHora_3);

        //      SimpleMaskFormatter simpleMaskFormatterMetrica = new SimpleMaskFormatter("NNNNNNN-N");
        //       MaskTextWatcher maskPeso = new MaskTextWatcher(edtxtMatricula, simpleMaskFormatterMetrica);
//        edtxtMatricula.addTextChangedListener(maskPeso);
/*


        SimpleMaskFormatter simpleMaskFormatterCep = new SimpleMaskFormatter(" NNNNN-NNN");
        MaskTextWatcher maskCEP = new MaskTextWatcher(etxtCEP, simpleMaskFormatterCep);
        etxtCEP.addTextChangedListener(maskCEP);

        SimpleMaskFormatter simpleMaskFormatterCPF = new SimpleMaskFormatter(" NNN.NNN.NNN-NN");
        MaskTextWatcher maskCPF = new MaskTextWatcher(txtCPF, simpleMaskFormatterCPF);
        txtCPF.addTextChangedListener(maskCPF);

*/
    }

    /**
     * Cadastrar Pesquisa
     */
    private void cadastrarEntrevistado() throws Exception {

       /*
       ANAMNESE
        */
        anamineseProfissionalBean = new AnamineseProfissionalBean();

/*
        if (isEmpty(edtxtNomeProfissional.getText().toString())) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String nomeProfissional = getApplicationContext().getString(R.string.lbl_txt_nome_profissional);
            generalSysDialog.setDialog(nomeProfissional, nomeProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);

            return;

        } else {
            anamineseProfissionalBean.setNomeProfissional(edtxtNomeProfissional.getText().toString());

        }

 */
        anamineseProfissionalBean.setNomeProfissional(Constantes.OPICIONAL);

        if (isEmpty(edtxtTelefone.getText().toString())) {
/*
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String telefoneProfissional = getApplicationContext().getString(R.string.lbl_txt_telefone_profissional);
            generalSysDialog.setDialog(telefoneProfissional, telefoneProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;
 */
            anamineseProfissionalBean.setTelefone(Constantes.OPICIONAL);

        } else {

            anamineseProfissionalBean.setTelefone(edtxtTelefone.getText().toString());

        }


        if (isEmpty(edtxtEmail.getText().toString())) {
/*
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String emailProfissional = getApplicationContext().getString(R.string.lbl_txt_email_profissional);
            generalSysDialog.setDialog(emailProfissional, emailProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);

            return;

 */

            anamineseProfissionalBean.setEmail(Constantes.OPICIONAL);

        } else {
            anamineseProfissionalBean.setEmail(edtxtEmail.getText().toString());

        }

        if (isEmpty(edtxtDataEntrevista.getText().toString())) {
            /*

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String dataProfissional = getApplicationContext().getString(R.string.lbl_txt_data_entrevista_profissional);
            generalSysDialog.setDialog(dataProfissional, dataProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);

            return;

             */
            anamineseProfissionalBean.setDtEntrevista(Constantes.OPICIONAL);

        } else {
            anamineseProfissionalBean.setDtEntrevista(edtxtDataEntrevista.getText().toString());


        }
        /*
        if (isEmpty(edtxCDE.getText().toString())) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String dataProfissional = getApplicationContext().getString(R.string.lbl_txt_CDE);
            generalSysDialog.setDialog(dataProfissional, dataProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);

            return;

        } else {
            anamineseProfissionalBean.setCDE(Integer.parseInt(edtxCDE.getText().toString()));

        }*/

        anamineseProfissionalBean.setCDE(0);


        if (isEmpty(edtxtIdade.getText().toString())) {

            /*

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String telefoneProfissional = getApplicationContext().getString(R.string.lbl_idade);
            generalSysDialog.setDialog(telefoneProfissional, telefoneProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

             */
            anamineseProfissionalBean.setIdade(Constantes.OPICIONAL);
        } else {

            anamineseProfissionalBean.setIdade(edtxtIdade.getText().toString());

        }

        if (isEmpty(edtxtPeso.getText().toString())) {

            /*

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pesoProfissional = getApplicationContext().getString(R.string.lbl_txt_peso_profissional);
            generalSysDialog.setDialog(pesoProfissional, pesoProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

             */
            anamineseProfissionalBean.setPeso(Constantes.OPICIONAL);

        } else {

            anamineseProfissionalBean.setPeso(edtxtPeso.getText().toString());

        }
        if (isEmpty(edtxtAltura.getText().toString())) {

            /*

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String alturaProfissional = getApplicationContext().getString(R.string.lbl_txt_altura_profissional);
            generalSysDialog.setDialog(alturaProfissional, alturaProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

             */
            anamineseProfissionalBean.setAltura(Constantes.OPICIONAL);
        } else {

            anamineseProfissionalBean.setAltura(edtxtAltura.getText().toString());

        }


        if (radioGroupSexo.getCheckedRadioButtonId() == -1) {

/*
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String sexoProfissional = getApplicationContext().getString(R.string.lbl_txt_sexo_profissional);
            generalSysDialog.setDialog(sexoProfissional, sexoProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

 */
            anamineseProfissionalBean.setSexo(Constantes.OPICIONAL);
        } else {

            int idSexo = radioGroupSexo.getCheckedRadioButtonId();
            radioButtonSexo = (RadioButton) findViewById(idSexo);
            anamineseProfissionalBean.setSexo(radioButtonSexo.getText().toString());


        }


          /*
       ANAMNESE NUTRICIONAL
        */

        if (radioGroupRefeicoes.getCheckedRadioButtonId() == -1) {
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String refeicoesProfissional = getApplicationContext().getString(R.string.lbl_txt_radio_refeicao);
            generalSysDialog.setDialog(refeicoesProfissional, refeicoesProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;
        } else {

            int idRefeicoes = radioGroupRefeicoes.getCheckedRadioButtonId();


            if (idRefeicoes == R.id.refeicoes_1_3_dia) {
                anamineseProfissionalBean.setRefeicaoDiariaA(true);
                anamineseProfissionalBean.setRefeicaoDiariaB(false);
            } else if (idRefeicoes == R.id.refeicoes_3_6_dia) {
                anamineseProfissionalBean.setRefeicaoDiariaA(false);
                anamineseProfissionalBean.setRefeicaoDiariaB(true);


            }
        }




            /*
       ANAMNESE ATIVIDADE FISICA
        */
        if (radioGroupAtividadeFisica.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String ativadeProfissional = getApplicationContext().getString(R.string.lbl_txt_radio_atiividade_fisica);
            generalSysDialog.setDialog(ativadeProfissional, ativadeProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {


            int idaAtividade = radioGroupAtividadeFisica.getCheckedRadioButtonId();

            if (idaAtividade == R.id.bol_pratica_atividade_fisica_nao) {

                anamineseProfissionalBean.setPraticaAtividadeFisica(false);
                anamineseProfissionalBean.setNomeAtividade(nenhuma);
                anamineseProfissionalBean.setDuracaoAtividade("0");
                anamineseProfissionalBean.setQtAtividadeVezesSemana(0);
                anamineseProfissionalBean.setIntensidadeAlta(false);
                anamineseProfissionalBean.setIntensidadeMedia(false);
                anamineseProfissionalBean.setIntensidadeLeve(false);

            } else if (idaAtividade == R.id.bol_pratica_atividade_fisica_sim) {
                anamineseProfissionalBean.setPraticaAtividadeFisica(true);

                if (isEmpty(edtxtQualAtividade.getText().toString())) {

                    generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
                    String qualProfissional = getApplicationContext().getString(R.string.lbl_txt_qual_atividade);
                    generalSysDialog.setDialog(qualProfissional, qualProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                            , 3);
                    return;


                } else {
                    anamineseProfissionalBean.setNomeAtividade(edtxtQualAtividade.getText().toString());
                }
                if (isEmpty(edtxtDuracao.getText().toString())) {
                    generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
                    String duracaoProfissional = getApplicationContext().getString(R.string.lbl_txt_qual_duracao);
                    generalSysDialog.setDialog(duracaoProfissional, duracaoProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                            , 3);
                    return;

                } else {
                    anamineseProfissionalBean.setDuracaoAtividade((edtxtDuracao.getText().toString()));
                }
                if (isEmpty(edtxtQuantasVezesSemana.getText().toString())) {
                    generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
                    String qtXProfissional = getApplicationContext().getString(R.string.lbl_txt_qual_x_semana);
                    generalSysDialog.setDialog(qtXProfissional, qtXProfissional + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                            , 3);
                    return;
                } else {
                    anamineseProfissionalBean.setQtAtividadeVezesSemana(Integer.parseInt(edtxtQuantasVezesSemana.getText().toString()));
                }

                if (radioGroupIntensidade.getCheckedRadioButtonId() == -1) {

                    generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
                    String intensidade = getApplicationContext().getString(R.string.lbl_txt_atividade_intensidade);
                    generalSysDialog.setDialog(intensidade, intensidade + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                            , 3);
                    return;

                } else {

                    int idIntensidade = radioGroupIntensidade.getCheckedRadioButtonId();

                    if (idIntensidade == R.id.intensidade_atividade_fisca_leve) {

                        anamineseProfissionalBean.setIntensidadeLeve(true);
                        anamineseProfissionalBean.setIntensidadeMedia(false);
                        anamineseProfissionalBean.setIntensidadeAlta(false);

                    } else if (idIntensidade == R.id.intensidade_atividade_fisca_media) {

                        anamineseProfissionalBean.setIntensidadeLeve(false);
                        anamineseProfissionalBean.setIntensidadeMedia(true);
                        anamineseProfissionalBean.setIntensidadeAlta(false);

                    } else if (idIntensidade == R.id.intensidade_atividade_fisca_alta) {

                        anamineseProfissionalBean.setIntensidadeLeve(false);
                        anamineseProfissionalBean.setIntensidadeMedia(false);
                        anamineseProfissionalBean.setIntensidadeAlta(true);

                    } else {

                        generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
                        String intensidade = getApplicationContext().getString(R.string.lbl_txt_atividade_intensidade);
                        generalSysDialog.setDialog(intensidade, intensidade + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                                , 3);
                        return;

                    }


                }


            }

        }






               /*
            ANAMNESE ATIVIDADE PROFISSIONAL
        */



            anamineseProfissionalBean.setFormacaoProf(Constantes.OPICIONAL);




        if (isEmpty(edtxtTempoProfissao.getText().toString())) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String formacao = getApplicationContext().getString(R.string.lbl_txt_atividade_formacao_tempo);
            generalSysDialog.setDialog(formacao, formacao + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            anamineseProfissionalBean.setTempoFormacaoProf(Integer.parseInt(edtxtTempoProfissao.getText().toString()));

        }


            anamineseProfissionalBean.setIntituicaoFormacaoProf(Constantes.OPICIONAL);


        if (radioGroupCapacitacao.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String treinameto = getApplicationContext().getString(R.string.lbl_txt_atividade_formacao_treinamento);
            generalSysDialog.setDialog(treinameto, treinameto + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idParticipacaoAtividades = radioGroupCapacitacao.getCheckedRadioButtonId();

            if (idParticipacaoAtividades == R.id.bol_tipo_capacitacao_nao) {
                anamineseProfissionalBean.setCapacitacaoDoisAnos(false);
            } else if (idParticipacaoAtividades == R.id.bol_tipo_capacitacao_sim) {
                anamineseProfissionalBean.setCapacitacaoDoisAnos(true);

            } else {

                generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
                String treinameto = getApplicationContext().getString(R.string.lbl_txt_atividade_formacao_treinamento);
                generalSysDialog.setDialog(treinameto, treinameto + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                        , 3);
                return;

            }

        }

        if (isEmpty(edtxtCargaHorarioTrabalhoSemanal.getText().toString())) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String treinameto = getApplicationContext().getString(R.string.lbl_txt_atividade_formacao_treinamento_media);
            generalSysDialog.setDialog(treinameto, treinameto + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {
            anamineseProfissionalBean.setCargaHoraria(Integer.parseInt(edtxtCargaHorarioTrabalhoSemanal.getText().toString()));
        }
        if (isEmpty(edtxtCargaQuantasEscolasTrabalho.getText().toString())) {
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String treinameto = getApplicationContext().getString(R.string.lbl_txt_atividade_formacao_treinamento_escolas);
            generalSysDialog.setDialog(treinameto, treinameto + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {
            anamineseProfissionalBean.setQTEscolas(Integer.parseInt(edtxtCargaQuantasEscolasTrabalho.getText().toString()));
        }

        if (isEmpty(edtxtAtividadeExerce.getText().toString())) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String treinameto = getApplicationContext().getString(R.string.lbl_txt_atividade_formacao_treinamento_outras);
            generalSysDialog.setDialog(treinameto, treinameto + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {
            anamineseProfissionalBean.setOutrasAtividades((edtxtAtividadeExerce.getText().toString()));
        }


//================================>SINDROME DE BURNOUT<=============================================

        BurnOutBean burnOutBean = new BurnOutBean();

        if (radioGroupResposta_burnout_1.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_1);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;


        } else {

            int idBurnout1 = radioGroupResposta_burnout_1.getCheckedRadioButtonId();
            radioButtomResposta_burnout_1 = (RadioButton) findViewById(idBurnout1);
            burnOutBean.setPergunta_01(Integer.parseInt(radioButtomResposta_burnout_1.getText().toString()));

        }

        if (radioGroupResposta_burnout_2.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_2);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout2 = radioGroupResposta_burnout_2.getCheckedRadioButtonId();
            radioButtomResposta_burnout_2 = (RadioButton) findViewById(idBurnout2);
            burnOutBean.setPergunta_02(Integer.parseInt(radioButtomResposta_burnout_2.getText().toString()));

        }


        if (radioGroupResposta_burnout_3.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_3);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout3 = radioGroupResposta_burnout_3.getCheckedRadioButtonId();
            radioButtomResposta_burnout_3 = (RadioButton) findViewById(idBurnout3);
            burnOutBean.setPergunta_03(Integer.parseInt(radioButtomResposta_burnout_3.getText().toString()));

        }

        if (radioGroupResposta_burnout_4.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_4);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout4 = radioGroupResposta_burnout_4.getCheckedRadioButtonId();
            radioButtomResposta_burnout_4 = (RadioButton) findViewById(idBurnout4);
            burnOutBean.setPergunta_04(Integer.parseInt(radioButtomResposta_burnout_4.getText().toString()));

        }
        if (radioGroupResposta_burnout_5.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_5);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout5 = radioGroupResposta_burnout_5.getCheckedRadioButtonId();
            radioButtomResposta_burnout_5 = (RadioButton) findViewById(idBurnout5);
            burnOutBean.setPergunta_05(Integer.parseInt(radioButtomResposta_burnout_5.getText().toString()));

        }

        if (radioGroupResposta_burnout_6.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_6);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout6 = radioGroupResposta_burnout_6.getCheckedRadioButtonId();
            radioButtomResposta_burnout_6 = (RadioButton) findViewById(idBurnout6);
            burnOutBean.setPergunta_06(Integer.parseInt(radioButtomResposta_burnout_6.getText().toString()));

        }
        if (radioGroupResposta_burnout_7.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_7);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout7 = radioGroupResposta_burnout_7.getCheckedRadioButtonId();
            radioButtomResposta_burnout_7 = (RadioButton) findViewById(idBurnout7);
            burnOutBean.setPergunta_07(Integer.parseInt(radioButtomResposta_burnout_7.getText().toString()));

        }

        if (radioGroupResposta_burnout_8.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_8);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout8 = radioGroupResposta_burnout_8.getCheckedRadioButtonId();
            radioButtomResposta_burnout_8 = (RadioButton) findViewById(idBurnout8);
            burnOutBean.setPergunta_08(Integer.parseInt(radioButtomResposta_burnout_8.getText().toString()));
        }

        if (radioGroupResposta_burnout_9.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_9);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout9 = radioGroupResposta_burnout_9.getCheckedRadioButtonId();
            radioButtomResposta_burnout_9 = (RadioButton) findViewById(idBurnout9);
            burnOutBean.setPergunta_09(Integer.parseInt(radioButtomResposta_burnout_9.getText().toString()));
        }

        if (radioGroupResposta_burnout_10.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_10);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout10 = radioGroupResposta_burnout_10.getCheckedRadioButtonId();
            radioButtomResposta_burnout_10 = (RadioButton) findViewById(idBurnout10);
            burnOutBean.setPergunta_10(Integer.parseInt(radioButtomResposta_burnout_10.getText().toString()));
        }

        if (radioGroupResposta_burnout_11.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_11);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout11 = radioGroupResposta_burnout_11.getCheckedRadioButtonId();
            radioButtomResposta_burnout_11 = (RadioButton) findViewById(idBurnout11);
            burnOutBean.setPergunta_11(Integer.parseInt(radioButtomResposta_burnout_11.getText().toString()));
        }

        if (radioGroupResposta_burnout_12.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_12);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout12 = radioGroupResposta_burnout_12.getCheckedRadioButtonId();
            radioButtomResposta_burnout_12 = (RadioButton) findViewById(idBurnout12);
            burnOutBean.setPergunta_12(Integer.parseInt(radioButtomResposta_burnout_12.getText().toString()));
        }

        if (radioGroupResposta_burnout_13.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_13);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout13 = radioGroupResposta_burnout_13.getCheckedRadioButtonId();
            radioButtomResposta_burnout_13 = (RadioButton) findViewById(idBurnout13);
            burnOutBean.setPergunta_13(Integer.parseInt(radioButtomResposta_burnout_13.getText().toString()));
        }

        if (radioGroupResposta_burnout_14.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_14);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout14 = radioGroupResposta_burnout_14.getCheckedRadioButtonId();
            radioButtomResposta_burnout_14 = (RadioButton) findViewById(idBurnout14);
            burnOutBean.setPergunta_14(Integer.parseInt(radioButtomResposta_burnout_14.getText().toString()));
        }

        if (radioGroupResposta_burnout_15.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_15);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout15 = radioGroupResposta_burnout_15.getCheckedRadioButtonId();
            radioButtomResposta_burnout_15 = (RadioButton) findViewById(idBurnout15);
            burnOutBean.setPergunta_15(Integer.parseInt(radioButtomResposta_burnout_15.getText().toString()));
        }

        if (radioGroupResposta_burnout_16.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_16);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout16 = radioGroupResposta_burnout_16.getCheckedRadioButtonId();
            radioButtomResposta_burnout_16 = (RadioButton) findViewById(idBurnout16);
            burnOutBean.setPergunta_16(Integer.parseInt(radioButtomResposta_burnout_16.getText().toString()));
        }

        if (radioGroupResposta_burnout_17.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_17);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout17 = radioGroupResposta_burnout_17.getCheckedRadioButtonId();
            radioButtomResposta_burnout_17 = (RadioButton) findViewById(idBurnout17);
            burnOutBean.setPergunta_17(Integer.parseInt(radioButtomResposta_burnout_17.getText().toString()));
        }

        if (radioGroupResposta_burnout_18.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_18);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout18 = radioGroupResposta_burnout_18.getCheckedRadioButtonId();
            radioButtomResposta_burnout_18 = (RadioButton) findViewById(idBurnout18);
            burnOutBean.setPergunta_18(Integer.parseInt(radioButtomResposta_burnout_18.getText().toString()));
        }

        if (radioGroupResposta_burnout_19.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_19);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout19 = radioGroupResposta_burnout_19.getCheckedRadioButtonId();
            radioButtomResposta_burnout_19 = (RadioButton) findViewById(idBurnout19);
            burnOutBean.setPergunta_19(Integer.parseInt(radioButtomResposta_burnout_19.getText().toString()));
        }

        if (radioGroupResposta_burnout_20.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String burnOuts = getApplicationContext().getString(R.string.lbl_txt_burn_20);
            generalSysDialog.setDialog(burnOuts, burnOuts + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idBurnout20 = radioGroupResposta_burnout_20.getCheckedRadioButtonId();
            radioButtomResposta_burnout_20 = (RadioButton) findViewById(idBurnout20);
            burnOutBean.setPergunta_20(Integer.parseInt(radioButtomResposta_burnout_20.getText().toString()));
        }


//================================>SONO<=============================================

        SonoPittsburghBeans sonoPittsburghBeans = new SonoPittsburghBeans();


        if (isEmpty(edtxtSono_1.getText().toString())) {
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_1);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else if(edtxtSono_1.getText().toString().length() < 5) {
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_1);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_sono_pitsburg_hora)
                    , 3);
            return;


        }else{

            UtilDiversos utilDiversos =  new UtilDiversos();
            int hora = utilDiversos.unmaskHoras(edtxtSono_1.getText().toString());
            sonoPittsburghBeans.setPergunta_sono_01(hora);
            //sonoPittsburghBeans.setPergunta_sono_01(Integer.parseInt(edtxtSono_1.getText().toString()));

        }

        if (isEmpty(edtxtSono_2.getText().toString())) {
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_2);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;


        } else {
            sonoPittsburghBeans.setPergunta_sono_02(Integer.parseInt(edtxtSono_2.getText().toString()));

        }

        if (isEmpty(edtxtSono_3.getText().toString())) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_3);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else if(edtxtSono_3.getText().toString().length()<5){
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_3);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_sono_pitsburg_hora)
                    , 3);
            return;

        }else {

            UtilDiversos utilDiversos =  new UtilDiversos();
            int horaSono3 = utilDiversos.unmaskHoras(edtxtSono_3.getText().toString());
            sonoPittsburghBeans.setPergunta_sono_03(horaSono3);
            //sonoPittsburghBeans.setPergunta_sono_03(Integer.parseInt(edtxtSono_3.getText().toString()));

        }


        if (isEmpty(edtxtSono_4.getText().toString())) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_4);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;


        } else {
            sonoPittsburghBeans.setPergunta_sono_04(Integer.parseInt(edtxtSono_4.getText().toString()));

        }


        if (radioGroupResposta_sono_5_a.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_5_a);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;


        } else {

            int idSono5_a = radioGroupResposta_sono_5_a.getCheckedRadioButtonId();
            radioButtomResposta__sono_5_a = (RadioButton) findViewById(idSono5_a);
            sonoPittsburghBeans.setPergunta_sono_05_a(Integer.parseInt(radioButtomResposta__sono_5_a.getText().toString()));
        }

        if (radioGroupResposta_sono_5_b.getCheckedRadioButtonId() == -1) {
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_5_b);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;


        } else {

            int idSono5_b = radioGroupResposta_sono_5_b.getCheckedRadioButtonId();
            radioButtomResposta__sono_5_b = (RadioButton) findViewById(idSono5_b);
            sonoPittsburghBeans.setPergunta_sono_05_b(Integer.parseInt(radioButtomResposta__sono_5_b.getText().toString()));
        }


        if (radioGroupResposta_sono_5_c.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_5_c);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idSono5_c = radioGroupResposta_sono_5_c.getCheckedRadioButtonId();
            radioButtomResposta__sono_5_c = (RadioButton) findViewById(idSono5_c);
            sonoPittsburghBeans.setPergunta_sono_05_c(Integer.parseInt(radioButtomResposta__sono_5_c.getText().toString()));
        }

        if (radioGroupResposta_sono_5_d.getCheckedRadioButtonId() == -1) {
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_5_d);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;


        } else {

            int idSono5_d = radioGroupResposta_sono_5_d.getCheckedRadioButtonId();
            radioButtomResposta__sono_5_d = (RadioButton) findViewById(idSono5_d);
            sonoPittsburghBeans.setPergunta_sono_05_d(Integer.parseInt(radioButtomResposta__sono_5_d.getText().toString()));
        }

        if (radioGroupResposta_sono_5_e.getCheckedRadioButtonId() == -1) {
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_5_e);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;


        } else {

            int idSono5_e = radioGroupResposta_sono_5_e.getCheckedRadioButtonId();
            radioButtomResposta__sono_5_e = (RadioButton) findViewById(idSono5_e);
            sonoPittsburghBeans.setPergunta_sono_05_e(Integer.parseInt(radioButtomResposta__sono_5_e.getText().toString()));
        }


        if (radioGroupResposta_sono_5_f.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_5_f);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;


        } else {

            int idSono5_f = radioGroupResposta_sono_5_f.getCheckedRadioButtonId();
            radioButtomResposta__sono_5_f = (RadioButton) findViewById(idSono5_f);
            sonoPittsburghBeans.setPergunta_sono_05_f(Integer.parseInt(radioButtomResposta__sono_5_f.getText().toString()));
        }

        if (radioGroupResposta_sono_5_g.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_5_g);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;


        } else {

            int idSono5_g = radioGroupResposta_sono_5_g.getCheckedRadioButtonId();
            radioButtomResposta__sono_5_g = (RadioButton) findViewById(idSono5_g);
            sonoPittsburghBeans.setPergunta_sono_05_g(Integer.parseInt(radioButtomResposta__sono_5_g.getText().toString()));
        }
        if (radioGroupResposta_sono_5_h.getCheckedRadioButtonId() == -1) {
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_5_h);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;


        } else {

            int idSono5_h = radioGroupResposta_sono_5_h.getCheckedRadioButtonId();
            radioButtomResposta__sono_5_h = (RadioButton) findViewById(idSono5_h);
            sonoPittsburghBeans.setPergunta_sono_05_h(Integer.parseInt(radioButtomResposta__sono_5_h.getText().toString()));
        }

        if (radioGroupResposta_sono_5_i.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_5_i);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;


        } else {

            int idSono5_i = radioGroupResposta_sono_5_i.getCheckedRadioButtonId();
            radioButtomResposta__sono_5_i = (RadioButton) findViewById(idSono5_i);
            sonoPittsburghBeans.setPergunta_sono_05_i(Integer.parseInt(radioButtomResposta__sono_5_i.getText().toString()));
        }


        if (isEmpty(edtxtSono_5_j.getText().toString())) {

          //  generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
          //  String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_5_j);
      //      generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
        //            , 3);

            sonoPittsburghBeans.setPergunta_sono_05_j((" "));




        } else {
            sonoPittsburghBeans.setPergunta_sono_05_j((edtxtSono_5_j.getText().toString()));

        }

        if (radioGroupResposta_sono_5_k.getCheckedRadioButtonId() == -1) {
            sonoPittsburghBeans.setPergunta_sono_05_k(0);

         //   generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
         //   String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_5_k);
        //    generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
        //            , 3);
       //     return;

        } else {

            int idSono5_k = radioGroupResposta_sono_5_k.getCheckedRadioButtonId();
            radioButtomResposta__sono_5_k = (RadioButton) findViewById(idSono5_k);
            sonoPittsburghBeans.setPergunta_sono_05_k(Integer.parseInt(radioButtomResposta__sono_5_k.getText().toString()));
        }

        if (radioGroupResposta_sono_6.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_6);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idSono_6 = radioGroupResposta_sono_6.getCheckedRadioButtonId();
            radioButtomResposta__sono_6 = (RadioButton) findViewById(idSono_6);
            sonoPittsburghBeans.setPergunta_sono_06((radioButtomResposta__sono_6.getText().toString()));
        }


        if (radioGroupResposta_sono_7.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_7);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idSono17 = radioGroupResposta_sono_7.getCheckedRadioButtonId();
            radioButtomResposta__sono_7 = (RadioButton) findViewById(idSono17);
            sonoPittsburghBeans.setPergunta_sono_07(Integer.parseInt(radioButtomResposta__sono_7.getText().toString()));
        }

        if (radioGroupResposta_sono_8.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_8);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idSono18 = radioGroupResposta_sono_8.getCheckedRadioButtonId();
            radioButtomResposta__sono_8 = (RadioButton) findViewById(idSono18);
            sonoPittsburghBeans.setPergunta_sono_08(Integer.parseInt(radioButtomResposta__sono_8.getText().toString()));
        }


        if (radioGroupResposta_sono_9.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String pittsburg = getApplicationContext().getString(R.string.lbl_txt_sono_9);
            generalSysDialog.setDialog(pittsburg, pittsburg + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idSono19 = radioGroupResposta_sono_9.getCheckedRadioButtonId();
            radioButtomResposta__sono_9 = (RadioButton) findViewById(idSono19);
            sonoPittsburghBeans.setPergunta_sono_09(Integer.parseInt(radioButtomResposta__sono_9.getText().toString()));
        }


//================================>ALIMENTACAO<=============================================

        AlimentacaoBeans alimentacaoBeans = new AlimentacaoBeans();

        if (radioGroupResposta_alimentacao_1.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String alimentacao = getApplicationContext().getString(R.string.lbl_txt_alimento_1);
            generalSysDialog.setDialog(alimentacao, alimentacao + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idAlimentacao_01 = radioGroupResposta_alimentacao_1.getCheckedRadioButtonId();
            radioButtomResposta__alimentacao_1 = (RadioButton) findViewById(idAlimentacao_01);
            alimentacaoBeans.setPergunta_alimentacao_01(Integer.parseInt(radioButtomResposta__alimentacao_1.getText().toString()));
        }

        if (radioGroupResposta_alimentacao_2.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String alimentacao = getApplicationContext().getString(R.string.lbl_txt_alimento_3);
            generalSysDialog.setDialog(alimentacao, alimentacao + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idAlimentacao_02 = radioGroupResposta_alimentacao_2.getCheckedRadioButtonId();
            radioButtomResposta__alimentacao_2 = (RadioButton) findViewById(idAlimentacao_02);
            alimentacaoBeans.setPergunta_alimentacao_02(Integer.parseInt(radioButtomResposta__alimentacao_2.getText().toString()));
        }

        if (radioGroupResposta_alimentacao_3.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String alimentacao = getApplicationContext().getString(R.string.lbl_txt_alimento_4);
            generalSysDialog.setDialog(alimentacao, alimentacao + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idAlimentacao_03 = radioGroupResposta_alimentacao_3.getCheckedRadioButtonId();
            radioButtomResposta__alimentacao_3 = (RadioButton) findViewById(idAlimentacao_03);
            alimentacaoBeans.setPergunta_alimentacao_03(Integer.parseInt(radioButtomResposta__alimentacao_3.getText().toString()));
        }


        if (radioGroupResposta_alimentacao_4.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String alimentacao = getApplicationContext().getString(R.string.lbl_txt_alimento_5);
            generalSysDialog.setDialog(alimentacao, alimentacao + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idAlimentacao_4 = radioGroupResposta_alimentacao_4.getCheckedRadioButtonId();
            radioButtomResposta__alimentacao_4 = (RadioButton) findViewById(idAlimentacao_4);
            alimentacaoBeans.setPergunta_alimentacao_04(Integer.parseInt(radioButtomResposta__alimentacao_4.getText().toString()));
        }

        if (radioGroupResposta_alimentacao_5.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String alimentacao = getApplicationContext().getString(R.string.lbl_txt_alimento_6);
            generalSysDialog.setDialog(alimentacao, alimentacao + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idAlimentacao_5 = radioGroupResposta_alimentacao_5.getCheckedRadioButtonId();
            radioButtomResposta__alimentacao_5 = (RadioButton) findViewById(idAlimentacao_5);
            alimentacaoBeans.setPergunta_alimentacao_05(Integer.parseInt(radioButtomResposta__alimentacao_5.getText().toString()));
        }

        if (radioGroupResposta_alimentacao_6.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String alimentacao = getApplicationContext().getString(R.string.lbl_txt_alimento_7);
            generalSysDialog.setDialog(alimentacao, alimentacao + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idAlimentacao_6 = radioGroupResposta_alimentacao_6.getCheckedRadioButtonId();
            radioButtomResposta__alimentacao_6 = (RadioButton) findViewById(idAlimentacao_6);
            alimentacaoBeans.setPergunta_alimentacao_06(Integer.parseInt(radioButtomResposta__alimentacao_6.getText().toString()));
        }

        if (radioGroupResposta_alimentacao_7.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String alimentacao = getApplicationContext().getString(R.string.lbl_txt_alimento_8);
            generalSysDialog.setDialog(alimentacao, alimentacao + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idAlimentacao_7 = radioGroupResposta_alimentacao_7.getCheckedRadioButtonId();
            radioButtomResposta__alimentacao_7 = (RadioButton) findViewById(idAlimentacao_7);
            alimentacaoBeans.setPergunta_alimentacao_07(Integer.parseInt(radioButtomResposta__alimentacao_7.getText().toString()));
        }

        if (radioGroupResposta_alimentacao_8.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String alimentacao = getApplicationContext().getString(R.string.lbl_txt_alimento_9);
            generalSysDialog.setDialog(alimentacao, alimentacao + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idAlimentacao_8 = radioGroupResposta_alimentacao_8.getCheckedRadioButtonId();
            radioButtomResposta__alimentacao_8 = (RadioButton) findViewById(idAlimentacao_8);
            alimentacaoBeans.setPergunta_alimentacao_08(Integer.parseInt(radioButtomResposta__alimentacao_8.getText().toString()));
        }

        if (radioGroupResposta_alimentacao_9.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String alimentacao = getApplicationContext().getString(R.string.lbl_txt_alimento_10);
            generalSysDialog.setDialog(alimentacao, alimentacao + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idAlimentacao_9 = radioGroupResposta_alimentacao_9.getCheckedRadioButtonId();
            radioButtomResposta__alimentacao_9 = (RadioButton) findViewById(idAlimentacao_9);
            alimentacaoBeans.setPergunta_alimentacao_09(Integer.parseInt(radioButtomResposta__alimentacao_9.getText().toString()));
        }

        if (radioGroupResposta_alimentacao_10.getCheckedRadioButtonId() == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String alimentacao = getApplicationContext().getString(R.string.lbl_txt_alimento_11);
            generalSysDialog.setDialog(alimentacao, alimentacao + " " + getApplicationContext().getString(R.string.dialog_generico_obrigatorio)
                    , 3);
            return;

        } else {

            int idAlimentacao_10 = radioGroupResposta_alimentacao_10.getCheckedRadioButtonId();
            radioButtomResposta__alimentacao_10 = (RadioButton) findViewById(idAlimentacao_10);
            alimentacaoBeans.setPergunta_alimentacao_10(Integer.parseInt(radioButtomResposta__alimentacao_10.getText().toString()));
        }


        //validar campos
        long retorno = DAOCadastro.getInstance().cadastarProfissionalPesquisa(anamineseProfissionalBean, burnOutBean, sonoPittsburghBeans, alimentacaoBeans);
        if (retorno == -1) {

            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
            String erro = getApplicationContext().getString(R.string.erro_sql_pesquisa);
            generalSysDialog.setDialog(erro, erro, 1);


        } else {

            concluirCadastro();
/*
            generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this) ;
            String cadastro = getApplicationContext().getString(R.string.sucesso_sql_pesquisa);
            String anaminase = getApplicationContext().getString(R.string.lbl_txt_titulo_cadastro_anaminase);
            generalSysDialog.setDialog(anaminase,cadastro,2);

 */


        }

    }


    //painel contluido

    public void concluirCadastro() {


        GeneralSysDialog generalSystemDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
        generalSystemDialog.setAboutGeneralSystemDialogListener(new GeneralSysDialog.GeneralSystemDialogListener() {


            @Override
            public void onDoneClick() {

                startActivity(new Intent(TelaCadastroInicialActivity.this, MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                finish();

            }


        });

        //  generalSystemDialog.setACAO_BOTAO(2);
        String cadastro = getApplicationContext().getString(R.string.sucesso_sql_pesquisa);
        String anaminase = getApplicationContext().getString(R.string.titulo_entrevista_concluida);
       generalSystemDialog.setDialog(cadastro, anaminase, 2);


    }

    //ação dos butões


    public void botaoImagem(View view) {
        imagemBell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostgrarPainelBurnOut();

            }
        });
        imagemBell2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostgrarPainelBurnOut();

            }
        });
        imagemBell3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostgrarPainelBurnOut();

            }
        });
        imagemBell4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostgrarPainelBurnOut();

            }
        });
        imagemBell5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostgrarPainelPittsburhg();

            }
        });
        imagemBell6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostgrarPainelPittsburhg();

            }
        });
        imagemBell7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostgrarPainelPittsburhg();

            }
        });


    }


    public void tabelaDiarioClasse() {

     //   startActivity(new Intent(TelaCadastroInicialActivity.this, TabelaDiarioClasseActivity.class));

    }

    public void listaDiarioClasse() {

        startActivity(new Intent(TelaCadastroInicialActivity.this, TelaMontarDadosCompletosActivity.class));

    }

    public void mostgrarPainelBurnOut() {


        String titulo = getResources().getString(R.string.dialog_titulo_lembrete);
        String titulo2 = getResources().getString(R.string.dialog_lembrete_corpo_burnout);


        generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
        generalSysDialog.setDialog(titulo, titulo2, 3);


    }

    public void mostgrarPainelPittsburhg() {


        String titulo = getResources().getString(R.string.dialog_titulo_lembrete);
        String titulo2 = getResources().getString(R.string.dialog_lembrete_corpo_pittsburgh);


        generalSysDialog = new GeneralSysDialog(TelaCadastroInicialActivity.this);
        generalSysDialog.setDialog(titulo, titulo2, 3);


    }


}
