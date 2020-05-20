package br.com.asb.bean

class ClassificacaoSonoPittsburghBeans {

    var idPiits: Int = 0
    var FkProfissional: Int = 0

    var pontuacaoComponente_1: Int = 0
    //componente 1
    var componente_1_escore_qualidadeSubjetivaSono_q6: Int = 0;
    var componente_1_resposta_qualidadeSubjetivaSono_q6: String = "";

    //Componente 2: Latência do sono
    var componente_2_escore_LatenciaSono_q2: Int = 0;
    var componente_2_resposta_LatenciaSono_q2: String = ""

    //Componente 2 Examine a questão 5a e atribua a pontuação da seguinte maneira:
    var componente_2_escore_q5: Int = 0;
    var componente_2_2_resposta_q5: String = ""

    //3. Some a pontuação da questão 2 e 5a
    var componente_2_4_soma: Int = 0
    var pontuacaoComponente_2: Int = 0;


    //Componente 3: Duração do sono:
    var pontuacaoComponente_3:Int = 0;
    var componente_3resposta_Questao_4:String = "";

    //Componente 4: Eficiência habitual do sono:
    var componente_4_numHorasDormidas: Int = 0

    //{horário de levantar (questão 3) – horário de deitar (questão 1)}
    var componente_4_horarioLevantar: Int = 0
    var componente_4_horarioDormir: Int = 0

    var componente_4_numHorasLeito: Long = 0

    //efeiciencia sono %
    var componente_4_percent_eficienticia_sono: Int =0;
    var percentagem_componente_04: String=""

    var pontuacaoComponente_4 :Int = 0;

    //questão 5 disturbio

    var pontuacaoComponente_5 :Int = 0;
    var componente_5_somatoria_a_k:Int = 0

    //Componente 6: Uso de medicação para dormir
    var pontuacao_questao_6: Int = 0
    var componente_6_resposta: String  =""
    var pontuacaoComponente_6 :Int = 0;

    //Componente 7: Disfunção durante o dia:
    var pontuacao_questao_7_1: Int = 0
    var resposta_questao_7_1: String = ""
    var pontuacao_questao_7_2: Int = 0
    var resposta_questao_7_2: String = ""
    var somatoria_questao_7_3_9_sum_8: Int =0


    var pontuacaoComponente_7: Int = 0


    //Os escores dos sete componentes são somados para conferir uma pontuação global do PSQI, a
    //qual varia de 0 a 21.
    var escore_total_PSQI_componentes: Int = 0;
    var resultado_total_PSQI_componentes: String = "";











}