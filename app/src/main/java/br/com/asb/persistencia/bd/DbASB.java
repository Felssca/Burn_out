package br.com.asb.persistencia.bd;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;


import br.com.asb.bean.AlimentacaoBeans;
import br.com.asb.bean.AnamineseProfissionalBean;
import br.com.asb.bean.BurnOutBean;
import br.com.asb.bean.DiarioClasseBean;
import br.com.asb.bean.ListaTotalDadosPesquisa;
import br.com.asb.bean.SonoPittsburghBeans;
import br.com.asb.dialog.GeneralSysDialog;
import br.com.asb.util.UtilDiversos;

public class DbASB extends SQLiteOpenHelper {


    public static final String DB_NAME = "ASB.db";
    public static final int VERSAO = 9;

    public static final String TABELA_CADASTRO_PROFISSIONAL = "tb_cadastro_profissional";
    public static final String TABELA_CADASTRO_BURNOUT = "tb_cadastro_burnout";
    public static final String TABELA_CADASTRO_SONO_PITSBURGH = "tb_qualidade_sono_pitsburgh";
    public static final String TABELA_CADASTRO_FREQUENCIA_ALIMENTO = "tb_freqeuncia_alimento";
//TB Resultado
    public static final String TABELA_RESULTADO_BURN_OUT = "tb_resultado_burnOut";

    /**
     * Tabela ANAMINESE PROF
     *
     * @param context
     */
    public static final String ID_PROFISSIONAL = "id_profissional";
    public static final String NOME_PROFISSIONAL = "txt_nome";
    public static final String EMAIL = "txt_email";
    public static final String TELEFONE = "txt_telefone";
    public static final String DATA_ENTREVISTA = "dt_data";
    public static final String CDE = "num_cde";
    public static final String SEXO = "txt_sexo";
    public static final String IDADE = "num_idade";
    public static final String PESO = "num_peso";
    public static final String ALTURA = "num_altura";
    //ANAMINASE NUTRICIONAL
    public static final String REFEICOES_DIARIAS_A = "bol_refeicao_a";
    public static final String REFEICOES_DIARIAS_B = "bol_refeicao_b";
    //ANAMINASE ATIVIDADE FISICA
    public static final String PRAT_ATIVIDADE = "bol_atividade_fisica";
    public static final String NOME_ATIVIDADE = "txt_nome_atividade";
    public static final String DURACAO = "txt_duracao";
    public static final String QT_SEMANA = "num_qt_semana";
    public static final String INTENSIDADE_LEVE = "bol_leve";
    public static final String INTENSIDADE_MEDIA = "bol_media";
    public static final String INTENSIDADE_ALTA = "bol_alta";
    public static final String OBJETIVO_PRATICA = "txt_objetivos";
    //ANAMINASE PROFISSIONAL
    public static final String FORMACAO_PROFISSIONAL = "txt_formacao";
    public static final String TEMPO_FORMACAO_PROFISSIONAL = "num_tempo_formacao";
    public static final String INSTITUICAO_FORMACAO_PROFISSIONAL = "txt_instituicao_formacao";
    public static final String CAPACITACAO_DOIS_ANOS = "bol_capacitacao";
    public static final String CARGA_HORARIA = "num_carga_horaria";
    public static final String QT_ESCOLAS = "num_escolas_horaria";
    public static final String OUTRAS_ATIVIDADES = "txt_outras_atividades";

    /**
     * Tabela BURN_OUT
     *
     * @param context
     */
    public static final String ID_BURNOUT = "id_burnout";
    //public static final String ID_FK_PROFISSIONAL = "id_profissional";
    public static final String PERGUNTA_BURNOUT_1 = "num_resposta_burnout_1";
    public static final String PERGUNTA_BURNOUT_2 = "num_resposta_burnout_2";
    public static final String PERGUNTA_BURNOUT_3 = "num_resposta_burnout_3";
    public static final String PERGUNTA_BURNOUT_4 = "num_resposta_burnout_4";
    public static final String PERGUNTA_BURNOUT_5 = "num_resposta_burnout_5";
    public static final String PERGUNTA_BURNOUT_6 = "num_resposta_burnout_6";
    public static final String PERGUNTA_BURNOUT_7 = "num_resposta_burnout_7";
    public static final String PERGUNTA_BURNOUT_8 = "num_resposta_burnout_8";
    public static final String PERGUNTA_BURNOUT_9 = "num_resposta_burnout_9";
    public static final String PERGUNTA_BURNOUT_10 = "num_resposta_burnout_10";
    public static final String PERGUNTA_BURNOUT_11 = "num_resposta_burnout_11";
    public static final String PERGUNTA_BURNOUT_12 = "num_resposta_burnout_12";
    public static final String PERGUNTA_BURNOUT_13 = "num_resposta_burnout_13";
    public static final String PERGUNTA_BURNOUT_14 = "num_resposta_burnout_14";
    public static final String PERGUNTA_BURNOUT_15 = "num_resposta_burnout_15";
    public static final String PERGUNTA_BURNOUT_16 = "num_resposta_burnout_16";
    public static final String PERGUNTA_BURNOUT_17 = "num_resposta_burnout_17";
    public static final String PERGUNTA_BURNOUT_18 = "num_resposta_burnout_18";
    public static final String PERGUNTA_BURNOUT_19 = "num_resposta_burnout_19";
    public static final String PERGUNTA_BURNOUT_20 = "num_resposta_burnout_20";

    /**
     * Tabela SONO PITTSBURGH
     *
     * @param context
     */
    public static final String ID_SONO = "id_sono";
    //  public static final String ID_FK_PROFISSIONAL = "id_profissional";
    public static final String PERGUNTA_SONO_1 = "num_resposta_sono_1";
    public static final String PERGUNTA_SONO_2 = "num_resposta_sono_2";
    public static final String PERGUNTA_SONO_3 = "num_resposta_sono_3";
    public static final String PERGUNTA_SONO_4 = "num_resposta_sono_4";
    public static final String PERGUNTA_SONO_5 = "num_resposta_sono_5";
    public static final String PERGUNTA_SONO_6 = "num_resposta_sono_6";
    public static final String PERGUNTA_SONO_7 = "num_resposta_sono_7";
    public static final String PERGUNTA_SONO_8 = "num_resposta_sono_8";
    public static final String PERGUNTA_SONO_9 = "num_resposta_sono_9";
    public static final String PERGUNTA_SONO_10 = "num_resposta_sono_10";
    public static final String PERGUNTA_SONO_11 = "num_resposta_sono_11";
    public static final String PERGUNTA_SONO_12 = "num_resposta_sono_12";
    public static final String PERGUNTA_SONO_13 = "num_resposta_sono_13";
    //outras razoes
    public static final String PERGUNTA_SONO_14 = "text_resposta_sono_14";
    public static final String PERGUNTA_SONO_15 = "text_resposta_sono_15";
    //
    public static final String PERGUNTA_SONO_16 = "num_resposta_sono_16";
    public static final String PERGUNTA_SONO_17 = "num_resposta_sono_17";
    public static final String PERGUNTA_SONO_18 = "num_resposta_sono_18";
    public static final String PERGUNTA_SONO_19 = "num_resposta_sono_19";
    public static final String PERGUNTA_SONO_20 = "num_resposta_sono_20";


    /**
     * Tabela Alimentos
     *
     * @param context
     */
    public static final String ID_ALIMENTO = "id_alimento";
    //  public static final String ID_FK_PROFISSIONAL = "fk_profissional";
    public static final String PERGUNTA_ALIMENTO_1 = "num_resposta_alimento_1";
    public static final String PERGUNTA_ALIMENTO_2 = "num_resposta_alimento_2";
    public static final String PERGUNTA_ALIMENTO_3 = "num_resposta_alimento_3";
    public static final String PERGUNTA_ALIMENTO_4 = "num_resposta_alimento_4";
    public static final String PERGUNTA_ALIMENTO_5 = "num_resposta_alimento_5";
    public static final String PERGUNTA_ALIMENTO_6 = "num_resposta_alimento_6";
    public static final String PERGUNTA_ALIMENTO_7 = "num_resposta_alimento_7";
    public static final String PERGUNTA_ALIMENTO_8 = "num_resposta_alimento_8";
    public static final String PERGUNTA_ALIMENTO_9 = "num_resposta_alimento_9";
    public static final String PERGUNTA_ALIMENTO_10 = "num_resposta_alimento_10";

    /**
     * TABELA RESULTADO BURN_OUT
     */
    public static final String ID_RESULTADO_BURN_OUT = "id_ResultadoBurnOut";
    //  public static final String ID_FK_PROFISSIONAL = "fk_profissional";

    public static final String SOMATORIO_ILUSAO_TRABALHO = "num_somatorio_ilusao_trabalho";
    public static final String CLASSIFICACAO_ILUSAO_TRABALHO = "text_classificacao_somatorio_ilusao_trabalho";

    public static final String SOMATORIO_DESGASTE_PSIQUICO = "num_somatorio_desgaste_psiquico";
    public static final String CLASSIFICACAO_DESGASTE_PSIQUICO = "text_classificacao_desgaste_psiquico";

    public static final String SOMATORIO_INDOLENCIA = "num_somatorio_indolencia";
    public static final String CLASSIFICACAO_SOMATORIO_INDOLENCIA = "text_classificacao_indolencia";
    public static final String TOTAL_INDOLENCIA_DESGASTE_PSIQUICO = "num_total_indolencia_desgaste_psiquico";
    public static final String CLASSIFICACAO_TOTAL_INDOLENCIA_DESGASTE_PSIQUICO = "text_classificacao_total_indolencia_desgaste_psiquico";

    public static final String SOMATORIO_CULPA = "num_somatorio_culpa";
    public static final String RESULTADO_SOMATORIO_CULPA = "num_resultado_somatorio_culpa";
    public static final String CLASSIFICACAO_SOMATORIO_CULPA = "text_classificacao_somatorio_culpa";

    public static final String CLASSIFICACAO_PERFIL = "text_classificacao_perfil";
    //classificacao Burn Out
    public static final String PERCENTUAL_ILUSAO_TRABALHO = "perc_ilusao_trabalho";
    public static final String CLASSIFICACAO_RESULTADO_ILUSAO_TRABALHO = "text_classificacao_ilusao_trabalho";

    public static final String PERCENTUAL_INDOLENCIA_DESGASTE = "perc_indolencia_desgaste";
    public static final String CLASSIFICACAO_INDOLENCIA_DESGASTE = "text_classificacao_indolencia_desgaste";
    public static final String PERCENTUAL_NIVEL_CULPA = "perc_nivel_culpa";

    /**
     * TABELA RESULTADO QUALIDADE DE SONO DE PITTSBURG
     */

    public static final String ID_RESULTADO_SONO_PITSBURG = "id_ResultadoPittsBurg";
    //  public static final String ID_FK_PROFISSIONAL = "fk_profissional";
    //Componente 1
    public static final String ESCORE_QUALIDADE_SUBJETIVA = "num_escore_qualidade_subjetiva";
    public static final String CLASSIFICACAO_QUALIDADE_SUBJETIVA = "text_classificacao_escore_qualidade_subjetiva";
    public static final String PONTUACAO_QUALIDADE_SUBJETIVA = "num_pontuacao_escore_qualidade_subjetiva";
    //Componente 2 Latencia Questão 2
    public static final String ESCORE_LATENCIA_DO_SONO = "num_escore_latencia_sono";
    //Questao 5a
    public static final String ESCORE_5_A = "num_escore_5_a";
    //SOmatorio  da 2 e 5
    public static final String SOMATORIO_QUESTOES_2_5 = "num_somatorio_questoes_2_5";
    public static final String PONTUACAO_COMPOENENTE_2 = "num_pontuacao_componente_2";
    //Componente 3 Duracao do sono
    public static final String ESCORE_COMPONENTE_3 = "num_escore_componente_3";
    public static final String PONTUACAO_COMPONENTE_3 = "num_pontuacao_componente_3";
    //Componente 4 Duracao do sono
    public static final String PERCENTUAL_EFICIENCIA_SONO = "perc_eficiencia_sono";
    public static final String PONTUACAO_COMPONENTE_4 = "num_pontuacao_componente_4";
    //Componente 5
    public static final String SOMA_QUESTOES_5B_5J = "num_soma_questoes_b_5j";
    public static final String PONTUACAO_COMPONENTE_5 = "num_pontuacao_componente_5";
    //Componente 6
    public static final String ESCORE_COMPONENTE_6 = "num_escore_componente_6";
    public static final String PONTUACAO_COMPONENTE_6 = "num_pontuacao_componente_6";
    //Compoente 7
    public static final String SOMA_COMPONENTE_7 = "num_soma_componente_7";
    public static final String PONTUACAO_COMPONENTE_7 = "num_pontuacao_componente_7";
    //Pontuacao global PSQI
    public static final String CLASSIFICACAO_GLOBAL_PSQI = "txt_classificacao_global_PSQI";
    public static final String PONTUACAO_GLOBAL_PSQI = "num_pontuacao_global_PSQI";


    /**
     * MONTAR TABELA RESPOSTA BURN_OUT
     */
    public static final String MONTAR_TABELA_RESPOSTA_BURN_OUT = "CREATE TABLE IF NOT EXISTS " + TABELA_RESULTADO_BURN_OUT + "( "
            + ID_RESULTADO_BURN_OUT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ID_PROFISSIONAL + " INTEGER, "
            + SOMATORIO_ILUSAO_TRABALHO + " NUMERIC,"
            + CLASSIFICACAO_ILUSAO_TRABALHO + " TEXT,"
            + SOMATORIO_DESGASTE_PSIQUICO + " NUMERIC, "
            + CLASSIFICACAO_DESGASTE_PSIQUICO+ " TEXT, "
            + SOMATORIO_INDOLENCIA+ " NUMERIC, "
            + CLASSIFICACAO_SOMATORIO_INDOLENCIA+ " TEXT, "
            + TOTAL_INDOLENCIA_DESGASTE_PSIQUICO+ " NUMERIC, "
            + CLASSIFICACAO_TOTAL_INDOLENCIA_DESGASTE_PSIQUICO+ " TEXT, "
            + SOMATORIO_CULPA+ " NUMERIC, "
            + RESULTADO_SOMATORIO_CULPA+ " NUMERIC, "
            + CLASSIFICACAO_SOMATORIO_CULPA+ " TEXT, "
            + CLASSIFICACAO_PERFIL+ " TEXT, "
            + PERCENTUAL_ILUSAO_TRABALHO+ " NUMERIC, "
            + CLASSIFICACAO_RESULTADO_ILUSAO_TRABALHO+ " TEXT, "
            + PERCENTUAL_INDOLENCIA_DESGASTE+ " NUMERIC, "
            + CLASSIFICACAO_INDOLENCIA_DESGASTE+ " TEXT, "
            + PERCENTUAL_NIVEL_CULPA+ " NUMERIC ) ";

    /**
     * MONTAR TABELA RESPOSTA SONO DE PITTSBURG
     */


    /**
     * MONTAR_TABELA_CADASTRO_PROFISSIONAL
     */
    public static final String MONTAR_TABELA_CADASTRO_PROFISSIONAL = "CREATE TABLE IF NOT EXISTS " + TABELA_CADASTRO_PROFISSIONAL + "( "
            + ID_PROFISSIONAL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOME_PROFISSIONAL + " TEXT,"
            + EMAIL + " TEXT,"
            + TELEFONE + " TEXT,"
            + DATA_ENTREVISTA + " TEXT, "
            + CDE + " INTEGER, "
            + SEXO + " TEXT, "
            + IDADE + " TEXT, "
            + PESO + " TEXT, "
            + ALTURA + " TEXT, "
            + REFEICOES_DIARIAS_A + " NUMERIC, "
            + REFEICOES_DIARIAS_B + " NUMERIC, "
            + PRAT_ATIVIDADE + " NUMERIC, "
            + NOME_ATIVIDADE + " TEXT, "
            + DURACAO + " TEXT, "
            + QT_SEMANA + " INTEGER, "
            + INTENSIDADE_LEVE + " NUMERIC, "
            + INTENSIDADE_MEDIA + " NUMERIC, "
            + INTENSIDADE_ALTA + " NUMERIC, "
            + OBJETIVO_PRATICA + " TEXT, "
            + FORMACAO_PROFISSIONAL + " TEXT, "
            + TEMPO_FORMACAO_PROFISSIONAL + " INTEGER, "
            + INSTITUICAO_FORMACAO_PROFISSIONAL + " TEXT, "
            + CAPACITACAO_DOIS_ANOS + " NUMERIC, "
            + CARGA_HORARIA + " INTEGER, "
            + QT_ESCOLAS + " INTEGER, "
            + OUTRAS_ATIVIDADES + " TEXT )";

    public static final String MONTAR_TABELA_AVALIACAO_SINDROME_BURNOUT = "CREATE TABLE IF NOT EXISTS " + TABELA_CADASTRO_BURNOUT + "( "
            + ID_BURNOUT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ID_PROFISSIONAL + " INTEGER, "
            + PERGUNTA_BURNOUT_1 + " INTEGER, "
            + PERGUNTA_BURNOUT_2 + " INTEGER, "
            + PERGUNTA_BURNOUT_3 + " INTEGER, "
            + PERGUNTA_BURNOUT_4 + " INTEGER, "
            + PERGUNTA_BURNOUT_5 + " INTEGER, "
            + PERGUNTA_BURNOUT_6 + " INTEGER, "
            + PERGUNTA_BURNOUT_7 + " INTEGER, "
            + PERGUNTA_BURNOUT_8 + " INTEGER, "
            + PERGUNTA_BURNOUT_9 + " INTEGER, "
            + PERGUNTA_BURNOUT_10 + " INTEGER, "
            + PERGUNTA_BURNOUT_11 + " INTEGER, "
            + PERGUNTA_BURNOUT_12 + " INTEGER, "
            + PERGUNTA_BURNOUT_13 + " INTEGER, "
            + PERGUNTA_BURNOUT_14 + " INTEGER, "
            + PERGUNTA_BURNOUT_15 + " INTEGER, "
            + PERGUNTA_BURNOUT_16 + " INTEGER, "
            + PERGUNTA_BURNOUT_17 + " INTEGER, "
            + PERGUNTA_BURNOUT_18 + " INTEGER, "
            + PERGUNTA_BURNOUT_19 + " INTEGER, "
            + PERGUNTA_BURNOUT_20 + " INTEGER )";

    public static final String MONTAR_QUAlIDADE_SONO_PITTSBURG = "CREATE TABLE IF NOT EXISTS " + TABELA_CADASTRO_SONO_PITSBURGH + "( "
            + ID_SONO + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ID_PROFISSIONAL + " INTEGER,"
            + PERGUNTA_SONO_1 + " INTEGER, "
            + PERGUNTA_SONO_2 + " INTEGER, "
            + PERGUNTA_SONO_3 + " INTEGER, "
            + PERGUNTA_SONO_4 + " INTEGER, "
            + PERGUNTA_SONO_5 + " INTEGER, "
            + PERGUNTA_SONO_6 + " INTEGER, "
            + PERGUNTA_SONO_7 + " INTEGER, "
            + PERGUNTA_SONO_8 + " INTEGER, "
            + PERGUNTA_SONO_9 + " INTEGER, "
            + PERGUNTA_SONO_10 + " INTEGER, "
            + PERGUNTA_SONO_11 + " INTEGER, "
            + PERGUNTA_SONO_12 + " INTEGER, "
            + PERGUNTA_SONO_13 + " INTEGER, "
            + PERGUNTA_SONO_14 + " TEXT, "
            + PERGUNTA_SONO_15 + " TEXT, "
            + PERGUNTA_SONO_16 + " INTEGER, "
            + PERGUNTA_SONO_17 + " INTEGER, "
            + PERGUNTA_SONO_18 + " INTEGER, "
            + PERGUNTA_SONO_19 + " INTEGER, "
            + PERGUNTA_SONO_20 + " INTEGER )";

    public static final String MONTAR_FREQUENCIA_ALIMENTO = "CREATE TABLE IF NOT EXISTS " + TABELA_CADASTRO_FREQUENCIA_ALIMENTO + "( "
            + ID_ALIMENTO + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ID_PROFISSIONAL + "  INTEGER, "
            + PERGUNTA_ALIMENTO_1 + " INTEGER, "
            + PERGUNTA_ALIMENTO_2 + " INTEGER, "
            + PERGUNTA_ALIMENTO_3 + " INTEGER, "
            + PERGUNTA_ALIMENTO_4 + " INTEGER, "
            + PERGUNTA_ALIMENTO_5 + " INTEGER, "
            + PERGUNTA_ALIMENTO_6 + " INTEGER, "
            + PERGUNTA_ALIMENTO_7 + " INTEGER, "
            + PERGUNTA_ALIMENTO_8 + " INTEGER, "
            + PERGUNTA_ALIMENTO_9 + " INTEGER, "
            + PERGUNTA_ALIMENTO_10 + " INTEGER )";




    public DbASB(Context context) {
        super(context, DB_NAME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(MONTAR_TABELA_CADASTRO_PROFISSIONAL);
        db.execSQL(MONTAR_TABELA_AVALIACAO_SINDROME_BURNOUT);
        db.execSQL(MONTAR_QUAlIDADE_SONO_PITTSBURG);
        db.execSQL(MONTAR_FREQUENCIA_ALIMENTO);
        db.execSQL(MONTAR_TABELA_RESPOSTA_BURN_OUT);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS tb_cadastro_profissional");
        db.execSQL(" DROP TABLE IF EXISTS tb_cadastro_burnout");
        db.execSQL(" DROP TABLE IF EXISTS tb_qualidade_sono_pitsburgh");
        db.execSQL(" DROP TABLE IF EXISTS tb_freqeuncia_alimento");
        db.execSQL(" DROP TABLE IF EXISTS tb_resultado_burnOut");
        onCreate(db);

    }

    public long inserirResultadosBurnOut(){
        long retornoCadasto = -1;
        


        return retornoCadasto;
    }


    public long inserirCadastroAnamineseProfissional(AnamineseProfissionalBean anamineseProfissionalBean, BurnOutBean burnOutBean,
                                                     SonoPittsburghBeans sonoPittsburghBeans, AlimentacaoBeans alimentacaoBeans
    ) {

        long retornoCadastro = -1;

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NOME_PROFISSIONAL, anamineseProfissionalBean.getNomeProfissional());
        contentValues.put(EMAIL, anamineseProfissionalBean.getEmail());
        contentValues.put(TELEFONE, anamineseProfissionalBean.getTelefone());
        contentValues.put(DATA_ENTREVISTA, anamineseProfissionalBean.getDtEntrevista());
        contentValues.put(CDE, anamineseProfissionalBean.getCDE());
        contentValues.put(SEXO, anamineseProfissionalBean.getSexo());
        contentValues.put(IDADE, anamineseProfissionalBean.getIdade());
        contentValues.put(ALTURA, anamineseProfissionalBean.getAltura());
        contentValues.put(PESO, anamineseProfissionalBean.getPeso());
        contentValues.put(REFEICOES_DIARIAS_A, anamineseProfissionalBean.getRefeicaoDiariaA());
        contentValues.put(REFEICOES_DIARIAS_B, anamineseProfissionalBean.getRefeicaoDiariaB());
        contentValues.put(PRAT_ATIVIDADE, anamineseProfissionalBean.getPraticaAtividadeFisica());
        contentValues.put(NOME_ATIVIDADE, anamineseProfissionalBean.getNomeAtividade());
        contentValues.put(DURACAO, anamineseProfissionalBean.getDuracaoAtividade());
        contentValues.put(QT_SEMANA, anamineseProfissionalBean.getQtAtividadeVezesSemana());
        contentValues.put(INTENSIDADE_LEVE, anamineseProfissionalBean.getIntensidadeLeve());
        contentValues.put(INTENSIDADE_MEDIA, anamineseProfissionalBean.getIntensidadeMedia());
        contentValues.put(INTENSIDADE_ALTA, anamineseProfissionalBean.getIntensidadeAlta());
        contentValues.put(OBJETIVO_PRATICA, anamineseProfissionalBean.getPraticaAtividadeFisica());
        contentValues.put(FORMACAO_PROFISSIONAL, anamineseProfissionalBean.getFormacaoProf());
        contentValues.put(TEMPO_FORMACAO_PROFISSIONAL, anamineseProfissionalBean.getTempoFormacaoProf());
        contentValues.put(INSTITUICAO_FORMACAO_PROFISSIONAL, anamineseProfissionalBean.getIntituicaoFormacaoProf());
        contentValues.put(CAPACITACAO_DOIS_ANOS, anamineseProfissionalBean.getCapacitacaoDoisAnos());
        contentValues.put(CARGA_HORARIA, anamineseProfissionalBean.getCargaHoraria());
        contentValues.put(QT_ESCOLAS, anamineseProfissionalBean.getQTEscolas());
        contentValues.put(OUTRAS_ATIVIDADES, anamineseProfissionalBean.getOutrasAtividades());

        long iretornoTabelaProf = db.insert(TABELA_CADASTRO_PROFISSIONAL, null, contentValues);

        long retornoCadSindromeBurnout = -1;
        long retornoCadSono = -1;
        long retornoAlimentacao = -1;


        if (iretornoTabelaProf == -1) {


            //   alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            //  generalSysDialog = new GeneralSysDialog(DbASB.this) ;
            //generalSysDialog.setDialog("Erro salvar profissional anamnase","Erro salvar profissional anamnase",1);
// ERRO
            System.out.println(" Erro salvar profissional anaminase");


        } else {

//persistir cadastro burnout


            ContentValues contentValuesBurnOut = new ContentValues();
            contentValuesBurnOut.put(ID_PROFISSIONAL, iretornoTabelaProf);
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_1, burnOutBean.getPergunta_01());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_2, burnOutBean.getPergunta_02());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_3, burnOutBean.getPergunta_03());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_4, burnOutBean.getPergunta_04());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_5, burnOutBean.getPergunta_05());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_6, burnOutBean.getPergunta_06());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_7, burnOutBean.getPergunta_07());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_8, burnOutBean.getPergunta_08());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_9, burnOutBean.getPergunta_09());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_10, burnOutBean.getPergunta_10());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_11, burnOutBean.getPergunta_11());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_12, burnOutBean.getPergunta_12());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_13, burnOutBean.getPergunta_13());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_14, burnOutBean.getPergunta_14());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_15, burnOutBean.getPergunta_15());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_16, burnOutBean.getPergunta_16());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_17, burnOutBean.getPergunta_17());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_18, burnOutBean.getPergunta_18());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_19, burnOutBean.getPergunta_19());
            contentValuesBurnOut.put(PERGUNTA_BURNOUT_20, burnOutBean.getPergunta_20());


            retornoCadSindromeBurnout = db.insert(TABELA_CADASTRO_BURNOUT, null, contentValuesBurnOut);


        }
        if (retornoCadSindromeBurnout == -1) {

            System.out.println(" Erro salvar profissional cadSindromeBurnOut");


        } else {

            ContentValues contentValuesBurnOut = new ContentValues();
            contentValuesBurnOut.put(ID_PROFISSIONAL, iretornoTabelaProf);
            contentValuesBurnOut.put(PERGUNTA_SONO_1, sonoPittsburghBeans.getPergunta_sono_01());
            contentValuesBurnOut.put(PERGUNTA_SONO_2, sonoPittsburghBeans.getPergunta_sono_02());
            contentValuesBurnOut.put(PERGUNTA_SONO_3, sonoPittsburghBeans.getPergunta_sono_03());
            contentValuesBurnOut.put(PERGUNTA_SONO_4, sonoPittsburghBeans.getPergunta_sono_04());
            contentValuesBurnOut.put(PERGUNTA_SONO_5, sonoPittsburghBeans.getPergunta_sono_05_a());
            contentValuesBurnOut.put(PERGUNTA_SONO_6, sonoPittsburghBeans.getPergunta_sono_05_b());
            contentValuesBurnOut.put(PERGUNTA_SONO_7, sonoPittsburghBeans.getPergunta_sono_05_c());
            contentValuesBurnOut.put(PERGUNTA_SONO_8, sonoPittsburghBeans.getPergunta_sono_05_d());
            contentValuesBurnOut.put(PERGUNTA_SONO_9, sonoPittsburghBeans.getPergunta_sono_05_e());
            contentValuesBurnOut.put(PERGUNTA_SONO_10, sonoPittsburghBeans.getPergunta_sono_05_f());
            contentValuesBurnOut.put(PERGUNTA_SONO_11, sonoPittsburghBeans.getPergunta_sono_05_g());
            contentValuesBurnOut.put(PERGUNTA_SONO_12, sonoPittsburghBeans.getPergunta_sono_05_h());
            contentValuesBurnOut.put(PERGUNTA_SONO_13, sonoPittsburghBeans.getPergunta_sono_05_i());
            contentValuesBurnOut.put(PERGUNTA_SONO_14, sonoPittsburghBeans.getPergunta_sono_05_j());
            contentValuesBurnOut.put(PERGUNTA_SONO_15, sonoPittsburghBeans.getPergunta_sono_05_k());
            contentValuesBurnOut.put(PERGUNTA_SONO_16, sonoPittsburghBeans.getPergunta_sono_06());
            contentValuesBurnOut.put(PERGUNTA_SONO_17, sonoPittsburghBeans.getPergunta_sono_07());
            contentValuesBurnOut.put(PERGUNTA_SONO_18, sonoPittsburghBeans.getPergunta_sono_08());
            contentValuesBurnOut.put(PERGUNTA_SONO_19, sonoPittsburghBeans.getPergunta_sono_09());


            retornoCadSono = db.insert(TABELA_CADASTRO_SONO_PITSBURGH, null, contentValuesBurnOut);


        }
        if (retornoCadSono == -1) {

            System.out.println(" Erro salvar profissional pittsburg");

        } else {

            ContentValues contentValuesAlimentacao = new ContentValues();
            contentValuesAlimentacao.put(ID_PROFISSIONAL, iretornoTabelaProf);
            contentValuesAlimentacao.put(PERGUNTA_ALIMENTO_1, alimentacaoBeans.getPergunta_alimentacao_01());
            contentValuesAlimentacao.put(PERGUNTA_ALIMENTO_2, alimentacaoBeans.getPergunta_alimentacao_02());
            contentValuesAlimentacao.put(PERGUNTA_ALIMENTO_3, alimentacaoBeans.getPergunta_alimentacao_03());
            contentValuesAlimentacao.put(PERGUNTA_ALIMENTO_4, alimentacaoBeans.getPergunta_alimentacao_04());
            contentValuesAlimentacao.put(PERGUNTA_ALIMENTO_5, alimentacaoBeans.getPergunta_alimentacao_05());
            contentValuesAlimentacao.put(PERGUNTA_ALIMENTO_6, alimentacaoBeans.getPergunta_alimentacao_06());
            contentValuesAlimentacao.put(PERGUNTA_ALIMENTO_7, alimentacaoBeans.getPergunta_alimentacao_07());
            contentValuesAlimentacao.put(PERGUNTA_ALIMENTO_8, alimentacaoBeans.getPergunta_alimentacao_08());
            contentValuesAlimentacao.put(PERGUNTA_ALIMENTO_9, alimentacaoBeans.getPergunta_alimentacao_09());
            contentValuesAlimentacao.put(PERGUNTA_ALIMENTO_10, alimentacaoBeans.getPergunta_alimentacao_10());


            retornoAlimentacao = db.insert(TABELA_CADASTRO_FREQUENCIA_ALIMENTO, null, contentValuesAlimentacao);

        }
        if (retornoAlimentacao == -1) {

            System.out.println(" Erro salvar profissional Alimentacao");


        } else {

            db.close();
            retornoCadastro = 1;
        }


        return retornoCadastro;
    }

    /**
     * listar todos entrevistados all
     *
     * @return
     */
    public ArrayList<AnamineseProfissionalBean> listarTodosProfissionaisCadastrados() {

        ArrayList<AnamineseProfissionalBean> consulatarProfissionais = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABELA_CADASTRO_PROFISSIONAL;

        //  SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                AnamineseProfissionalBean anamineseProfissionalBean = new AnamineseProfissionalBean();
                anamineseProfissionalBean.setIdProfissional(cursor.getInt(cursor.getColumnIndex(ID_PROFISSIONAL)));
                anamineseProfissionalBean.setNomeProfissional(cursor.getString(cursor.getColumnIndex(NOME_PROFISSIONAL)));
                anamineseProfissionalBean.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL)));
                anamineseProfissionalBean.setTelefone(cursor.getString(cursor.getColumnIndex(TELEFONE)));
                anamineseProfissionalBean.setDtEntrevista(cursor.getString(cursor.getColumnIndex(DATA_ENTREVISTA)));
                anamineseProfissionalBean.setCDE(cursor.getInt(cursor.getColumnIndex(CDE)));
                anamineseProfissionalBean.setSexo(cursor.getString(cursor.getColumnIndex(SEXO)));
                anamineseProfissionalBean.setIdade(cursor.getString(cursor.getColumnIndex(IDADE)));
                anamineseProfissionalBean.setPeso(cursor.getString(cursor.getColumnIndex(PESO)));
                consulatarProfissionais.add(anamineseProfissionalBean);

            } while (cursor.moveToNext());
        }
        db.close();


        return consulatarProfissionais;
    }

    /**
     * listar todos entrevistados POR ID
     *
     * @return
     */
    public ListaTotalDadosPesquisa listarDadosProfissionalPorId(Integer id, int tabelaPesquisa) {

        ListaTotalDadosPesquisa listaTotalDadosPesquisa = new ListaTotalDadosPesquisa();
        String selectQuery = null;

        switch (tabelaPesquisa) {

            case 0:
                selectQuery = "SELECT  * FROM " + TABELA_CADASTRO_PROFISSIONAL + " WHERE " + ID_PROFISSIONAL + "=" + id;
                break;
            case 1:
                selectQuery = "SELECT  * FROM " + TABELA_CADASTRO_BURNOUT + " WHERE " + ID_PROFISSIONAL + "=" + id;
                break;
            case 2:
                selectQuery = "SELECT  * FROM " + TABELA_CADASTRO_SONO_PITSBURGH + " WHERE " + ID_PROFISSIONAL + "=" + id;
                break;
            case 3:
                selectQuery = "SELECT  * FROM " + TABELA_CADASTRO_FREQUENCIA_ALIMENTO + " WHERE " + ID_PROFISSIONAL + "=" + id;
                break;
            default:
                selectQuery = "SELECT  * FROM " + TABELA_CADASTRO_PROFISSIONAL + " WHERE " + ID_PROFISSIONAL + "=" + id;
        }


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {


            AnamineseProfissionalBean anamineseProfissionalBean = new AnamineseProfissionalBean();
            SonoPittsburghBeans sonoPittsburghBeans = new SonoPittsburghBeans();
            AlimentacaoBeans alimentacaoBeans = new AlimentacaoBeans();
            BurnOutBean burnOutBean = new BurnOutBean();

            if (tabelaPesquisa == 0) {

                anamineseProfissionalBean.setIdProfissional(cursor.getInt(cursor.getColumnIndex(ID_PROFISSIONAL)));
                anamineseProfissionalBean.setNomeProfissional(cursor.getString(cursor.getColumnIndex(NOME_PROFISSIONAL)));
                anamineseProfissionalBean.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL)));
                anamineseProfissionalBean.setTelefone(cursor.getString(cursor.getColumnIndex(TELEFONE)));
                anamineseProfissionalBean.setDtEntrevista(cursor.getString(cursor.getColumnIndex(DATA_ENTREVISTA)));
                anamineseProfissionalBean.setCDE(cursor.getInt(cursor.getColumnIndex(CDE)));
                anamineseProfissionalBean.setSexo(cursor.getString(cursor.getColumnIndex(SEXO)));
                anamineseProfissionalBean.setIdade(cursor.getString(cursor.getColumnIndex(IDADE)));
                anamineseProfissionalBean.setPeso(cursor.getString(cursor.getColumnIndex(PESO)));
                anamineseProfissionalBean.setAltura(cursor.getString(cursor.getColumnIndex(ALTURA)));
                //ANAMINASE PNUTRICIONAL

                Integer.toString(cursor.getInt(cursor.getColumnIndex(REFEICOES_DIARIAS_B)));
                UtilDiversos utilDiversos = new UtilDiversos();
                anamineseProfissionalBean.setRefeicaoDiariaA(utilDiversos.converterDadosBd(cursor.getInt(cursor.getColumnIndex(REFEICOES_DIARIAS_A))));
                anamineseProfissionalBean.setRefeicaoDiariaB(utilDiversos.converterDadosBd(cursor.getInt(cursor.getColumnIndex(REFEICOES_DIARIAS_B))));
                //ANAMINASE atv fisica

                anamineseProfissionalBean.setPraticaAtividadeFisica(utilDiversos.converterDadosBd(cursor.getInt(cursor.getColumnIndex(PRAT_ATIVIDADE))));
                anamineseProfissionalBean.setNomeAtividade(cursor.getString(cursor.getColumnIndex(NOME_ATIVIDADE)));
                anamineseProfissionalBean.setDuracaoAtividade(cursor.getString(cursor.getColumnIndex(DURACAO)));
                anamineseProfissionalBean.setQtAtividadeVezesSemana(cursor.getInt(cursor.getColumnIndex(QT_SEMANA)));

                anamineseProfissionalBean.setIntensidadeLeve(utilDiversos.converterDadosBd((cursor.getInt(cursor.getColumnIndex(INTENSIDADE_LEVE)))));
                anamineseProfissionalBean.setIntensidadeMedia(utilDiversos.converterDadosBd(cursor.getInt(cursor.getColumnIndex(INTENSIDADE_MEDIA))));
                anamineseProfissionalBean.setIntensidadeAlta(utilDiversos.converterDadosBd(cursor.getInt(cursor.getColumnIndex(INTENSIDADE_ALTA))));
                //anaminase profissional
                anamineseProfissionalBean.setFormacaoProf(cursor.getString(cursor.getColumnIndex(FORMACAO_PROFISSIONAL)));
                anamineseProfissionalBean.setTempoFormacaoProf(cursor.getInt(cursor.getColumnIndex(TEMPO_FORMACAO_PROFISSIONAL)));
                anamineseProfissionalBean.setIntituicaoFormacaoProf(cursor.getString(cursor.getColumnIndex(INSTITUICAO_FORMACAO_PROFISSIONAL)));

                anamineseProfissionalBean.setCapacitacaoDoisAnos(utilDiversos.converterDadosBd(cursor.getInt(cursor.getColumnIndex(CAPACITACAO_DOIS_ANOS))));
                anamineseProfissionalBean.setCargaHoraria(cursor.getInt(cursor.getColumnIndex(CARGA_HORARIA)));
                anamineseProfissionalBean.setQTEscolas(cursor.getInt(cursor.getColumnIndex(QT_ESCOLAS)));
                anamineseProfissionalBean.setOutrasAtividades(cursor.getString(cursor.getColumnIndex(OUTRAS_ATIVIDADES)));
                listaTotalDadosPesquisa.setAnamineseProfissionalBean(anamineseProfissionalBean);


            }
            if (tabelaPesquisa == 1) {
                //BURN OUT
                burnOutBean.setPergunta_01(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_1)));
                burnOutBean.setPergunta_02(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_2)));
                burnOutBean.setPergunta_03(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_3)));
                burnOutBean.setPergunta_04(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_4)));
                burnOutBean.setPergunta_05(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_5)));
                burnOutBean.setPergunta_06(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_6)));
                burnOutBean.setPergunta_07(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_7)));
                burnOutBean.setPergunta_08(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_8)));
                burnOutBean.setPergunta_09(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_9)));
                burnOutBean.setPergunta_10(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_10)));
                burnOutBean.setPergunta_11(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_11)));
                burnOutBean.setPergunta_12(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_12)));
                burnOutBean.setPergunta_13(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_13)));
                burnOutBean.setPergunta_14(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_14)));
                burnOutBean.setPergunta_15(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_15)));
                burnOutBean.setPergunta_16(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_16)));
                burnOutBean.setPergunta_17(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_17)));
                burnOutBean.setPergunta_18(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_18)));
                burnOutBean.setPergunta_19(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_19)));
                burnOutBean.setPergunta_20(cursor.getInt(cursor.getColumnIndex(PERGUNTA_BURNOUT_20)));
                listaTotalDadosPesquisa.setBurnOutBean(burnOutBean);

            }
            if (tabelaPesquisa == 2) {
                //PITTSBURGUER
                sonoPittsburghBeans.setPergunta_sono_01(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_1)));
                sonoPittsburghBeans.setPergunta_sono_02(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_2)));
                sonoPittsburghBeans.setPergunta_sono_03(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_3)));
                sonoPittsburghBeans.setPergunta_sono_04(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_4)));
                sonoPittsburghBeans.setPergunta_sono_05_a(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_5)));
                sonoPittsburghBeans.setPergunta_sono_05_b(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_6)));
                sonoPittsburghBeans.setPergunta_sono_05_c(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_7)));
                sonoPittsburghBeans.setPergunta_sono_05_d(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_8)));
                sonoPittsburghBeans.setPergunta_sono_05_e(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_9)));
                sonoPittsburghBeans.setPergunta_sono_05_f(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_10)));
                sonoPittsburghBeans.setPergunta_sono_05_g(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_11)));
                sonoPittsburghBeans.setPergunta_sono_05_h(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_12)));
                sonoPittsburghBeans.setPergunta_sono_05_i(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_13)));
                sonoPittsburghBeans.setPergunta_sono_05_j(cursor.getString(cursor.getColumnIndex(PERGUNTA_SONO_14)));
                sonoPittsburghBeans.setPergunta_sono_05_k(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_15)));
                sonoPittsburghBeans.setPergunta_sono_06(cursor.getString(cursor.getColumnIndex(PERGUNTA_SONO_16)));
                sonoPittsburghBeans.setPergunta_sono_07(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_17)));
                sonoPittsburghBeans.setPergunta_sono_08(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_18)));
                sonoPittsburghBeans.setPergunta_sono_09(cursor.getInt(cursor.getColumnIndex(PERGUNTA_SONO_19)));
                listaTotalDadosPesquisa.setSonoPittsburghBeans(sonoPittsburghBeans);

            }
            if (tabelaPesquisa == 3) {

                //Alimento
                alimentacaoBeans.setPergunta_alimentacao_01(cursor.getInt(cursor.getColumnIndex(PERGUNTA_ALIMENTO_1)));
                alimentacaoBeans.setPergunta_alimentacao_02(cursor.getInt(cursor.getColumnIndex(PERGUNTA_ALIMENTO_2)));
                alimentacaoBeans.setPergunta_alimentacao_03(cursor.getInt(cursor.getColumnIndex(PERGUNTA_ALIMENTO_3)));
                alimentacaoBeans.setPergunta_alimentacao_04(cursor.getInt(cursor.getColumnIndex(PERGUNTA_ALIMENTO_4)));
                alimentacaoBeans.setPergunta_alimentacao_05(cursor.getInt(cursor.getColumnIndex(PERGUNTA_ALIMENTO_5)));
                alimentacaoBeans.setPergunta_alimentacao_06(cursor.getInt(cursor.getColumnIndex(PERGUNTA_ALIMENTO_6)));
                alimentacaoBeans.setPergunta_alimentacao_07(cursor.getInt(cursor.getColumnIndex(PERGUNTA_ALIMENTO_7)));
                alimentacaoBeans.setPergunta_alimentacao_08(cursor.getInt(cursor.getColumnIndex(PERGUNTA_ALIMENTO_8)));
                alimentacaoBeans.setPergunta_alimentacao_09(cursor.getInt(cursor.getColumnIndex(PERGUNTA_ALIMENTO_9)));
                alimentacaoBeans.setPergunta_alimentacao_10(cursor.getInt(cursor.getColumnIndex(PERGUNTA_ALIMENTO_10)));
                listaTotalDadosPesquisa.setAlimentacaoBeans(alimentacaoBeans);

            }


        }
        db.close();
        return listaTotalDadosPesquisa;
    }

    /**
     * listaTodosAlunosDoSistemaPorIDClasse
     *
     * @return
     */
    public ArrayList<DiarioClasseBean> listarAlunosIDClasse(int id) {

        ArrayList<DiarioClasseBean> consulatarAlunos = new ArrayList<>();
/*

 */
        return consulatarAlunos;
    }

    /**
     * Lista todas as classes
     *
     * @return
     */

    public ArrayList<DiarioClasseBean> listarProfissionaisEntrevistados() {

        ArrayList<DiarioClasseBean> consultarProfissionaisCadastrados = new ArrayList<>();
        /*

         */
        return consultarProfissionaisCadastrados;
    }


    /**
     * Escolha por ID
     *
     * @param id
     * @return
     */

    public ArrayList<DiarioClasseBean> listarClassesByID(int id) {

        ArrayList<DiarioClasseBean> consultarClasses = new ArrayList<>();

        /*


         */
        return consultarClasses;
    }


}










