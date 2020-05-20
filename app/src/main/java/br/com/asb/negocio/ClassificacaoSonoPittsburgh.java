package br.com.asb.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;


import br.com.asb.bean.ClassificacaoSonoPittsburghBeans;
import br.com.asb.bean.SonoPittsburghBeans;
import br.com.asb.util.Constantes;

import static java.time.temporal.ChronoUnit.HOURS;

public class ClassificacaoSonoPittsburgh {

    private ClassificacaoSonoPittsburghBeans classificacaoSonoPittsburghBeans;


    public void classificarSonoPitssburgh(SonoPittsburghBeans sonoPittsburghBeans) {

        classificacaoSonoPittsburghBeans = new ClassificacaoSonoPittsburghBeans();


        /**
         * Componente 1: Qualidade subjetiva do sono: examine a questão 6 e atribua a pontuação da
         * seguinte maneira:
         */
        int escorePontuacaoComponente1 = pontuacaoClassificacao(sonoPittsburghBeans, 1);
        getClassificacaoSonoPittsburghBeans().setComponente_1_escore_qualidadeSubjetivaSono_q6(escorePontuacaoComponente1);
        getClassificacaoSonoPittsburghBeans().setComponente_1_resposta_qualidadeSubjetivaSono_q6(sonoPittsburghBeans.getPergunta_sono_06());
        getClassificacaoSonoPittsburghBeans().setPontuacaoComponente_1(escorePontuacaoComponente1);

        /**
         * Componente 2: Latência do sono:
         */
        int escorePontuacaoComponente2 = pontuacaoClassificacao(sonoPittsburghBeans, 2);
        getClassificacaoSonoPittsburghBeans().setPontuacaoComponente_2(escorePontuacaoComponente2);
        /**
         * Componente 3: Duração do sono:
         */
        int escorePontuacaoComponente3 = pontuacaoClassificacao(sonoPittsburghBeans, 3);
        getClassificacaoSonoPittsburghBeans().setPontuacaoComponente_3(escorePontuacaoComponente3);

        /**
         * Componente 4: Eficiência habitual do sono:
         */
        int escorePontuacaoComponente4 = pontuacaoClassificacao(sonoPittsburghBeans, 4);
        getClassificacaoSonoPittsburghBeans().setPontuacaoComponente_4(escorePontuacaoComponente4);

        /**
         * Componente 5:Distúrbios do sono:
         */
        int escorePontuacaoComponente5 = pontuacaoClassificacao(sonoPittsburghBeans, 5);
        getClassificacaoSonoPittsburghBeans().setPontuacaoComponente_5(escorePontuacaoComponente5);


        /**
         * Componente 6:uso de medicação para dormir
         */
        int escorePontuacaoComponente6 = sonoPittsburghBeans.getPergunta_sono_07();
        respostaComponente6(escorePontuacaoComponente6);
        getClassificacaoSonoPittsburghBeans().setPontuacaoComponente_6(escorePontuacaoComponente6);
        /**
         * Componente 7:uso de medicação para dormir
         */
        int escorePontuacaoComponente7 = pontuacaoClassificacao(sonoPittsburghBeans, 7);

        /**
         * somatorio final PSQI
         */
        int somatorioFinalPSQI = escorePontuacaoComponente1 + escorePontuacaoComponente2 + escorePontuacaoComponente3 +
                escorePontuacaoComponente4 + escorePontuacaoComponente5 + escorePontuacaoComponente6 + escorePontuacaoComponente7;

        resultadoPSQUI(somatorioFinalPSQI);


    }

    private int pontuacaoClassificacao(SonoPittsburghBeans sonoPittsburghBeans, int componente) {
        int escore = 0;

        /**
         *Componente 1: Qualidade subjetiva do sono: examine a questão 6
         *
         *
         * 3. Some a pontuação da questão 2 e 5a
         *
         * 4. Atribua a pontuação do componente 2 da seguinte maneira:
         *
         * Componente 3: Duração do sono:
         * 1. Examine questão 4 e atribua a pontuação da seguinte maneira:
         *
         * Componente 4: Eficiência habitual do sono:
         *
         * 1. Examine a questão 2 e atribua a pontuação da seguinte maneira:
         *  Escreva o número de horas dormidas (questão 4)
         *  Calcule o número de horas no leito:
         * {horário de levantar (questão 3) – horário de deitar (questão 1)}
         *  Calcule a eficiência do sono:
         * {no de horas dormidas/no de horas no leito} x 100 = eficiência do sono(%)
         *  Atribua a pontuação do componente 4 da seguinte maneira:
         *
         * Componente 5: Distúrbios do sono:
         * 1. Examine as questões de 5b a 5j e atribua a pontuação
         * 2. Some a pontuação de 5b a 5j:
         * 3. Atribua a pontuação do componente 5 da seguinte forma:
         *
         * Componente 6: Uso de medicação para dormir:
         *
         * Componente 7: Disfunção durante o dia:
         * Examine a questão 9 e atribua a pontuação da seguinte maneira:
         *
         * Os escores dos sete componentes são somados para conferir uma pontuação global do PSQI, a
         * qual varia de 0 a 21.
         */

        switch (componente) {

            case 1:
                if (sonoPittsburghBeans.getPergunta_sono_06().equals(Constantes.RESULTADO_BOA)) {
                    escore = 1;
                } else if (sonoPittsburghBeans.getPergunta_sono_06().equals(Constantes.RESULTADO_MUITO_BOA)) {
                    escore = 0;
                } else if (sonoPittsburghBeans.getPergunta_sono_06().equals(Constantes.RESULTADO_RUIM)) {
                    escore = 2;
                } else if (sonoPittsburghBeans.getPergunta_sono_06().equals(Constantes.RESULTADO_MUITO_RUIM)) {
                    escore = 3;
                }
                break;
            case 2:
                int escoreLatenciaSono = latenciaDoSonoComponente2(sonoPittsburghBeans.getPergunta_sono_02());
                getClassificacaoSonoPittsburghBeans().setComponente_2_escore_LatenciaSono_q2(escoreLatenciaSono);

                getClassificacaoSonoPittsburghBeans().setComponente_2_escore_q5(sonoPittsburghBeans.getPergunta_sono_05_a());
                getClassificacaoSonoPittsburghBeans().setComponente_2_2_resposta_q5(latenciaDoSonoComponente2_2_resposta(sonoPittsburghBeans.getPergunta_sono_05_a()));

                int somatorioPasso3 = escoreLatenciaSono + sonoPittsburghBeans.getPergunta_sono_05_a();
                getClassificacaoSonoPittsburghBeans().setComponente_2_4_soma(somatorioPasso3);
                escore = escoreComponente2(somatorioPasso3);
                break;

            case 3:
                escore = duracaoDoSonoComponente3(sonoPittsburghBeans.getPergunta_sono_04());

                break;
            case 4:

                escore = calculoEficienciaSonoComponente4(sonoPittsburghBeans);

                break;

            case 5:
                escore = calculoDisturbioSono(sonoPittsburghBeans);

                break;

            case 7:
                escore = calculoDisfuncaoDiaComp7(sonoPittsburghBeans);

                break;

        }


        return escore;
    }

    /**
     * Retorno os minutos componente 2
     *
     * @param minutos
     * @return
     */
    private int latenciaDoSonoComponente2(int minutos) {
        int restposta = 0;

        if (minutos <= 15) {
            restposta = 0;
            getClassificacaoSonoPittsburghBeans().setComponente_2_resposta_LatenciaSono_q2(Constantes.RESULTADO_LATENCIA_0);
        } else if (minutos >= 16 || minutos <= 30) {
            restposta = 1;
            getClassificacaoSonoPittsburghBeans().setComponente_2_resposta_LatenciaSono_q2(Constantes.RESULTADO_LATENCIA_1);
        } else if (minutos >= 31 || minutos <= 60) {
            restposta = 2;
            getClassificacaoSonoPittsburghBeans().setComponente_2_resposta_LatenciaSono_q2(Constantes.RESULTADO_LATENCIA_2);
        } else if (minutos > 60) {
            restposta = 3;
            getClassificacaoSonoPittsburghBeans().setComponente_2_resposta_LatenciaSono_q2(Constantes.RESULTADO_LATENCIA_3);

        }

        return restposta;

    }

    /**
     * Latencia do sono Q2_2
     *
     * @param escore
     * @return
     */
    private String latenciaDoSonoComponente2_2_resposta(int escore) {
        String restposta = null;

        if (escore == 0) {
            restposta = Constantes.RESULTADO_QUESTAO_5_0;

        } else if (escore == 1) {
            restposta = Constantes.RESULTADO_QUESTAO_5_1;

        } else if (escore == 2) {
            restposta = Constantes.RESULTADO_QUESTAO_5_2;

        } else if (escore == 3) {
            restposta = Constantes.RESULTADO_QUESTAO_5_3;

        }

        return restposta;

    }


    /**
     * converte o restultado do componente 2 resposta
     *
     * @param resultado
     * @return
     */
    private int escoreComponente2(int resultado) {
        int restposta = 0;
        if (resultado == 0) {
            restposta = 0;

        } else if (resultado == 1 || resultado == 2) {
            restposta = 1;

        } else if (resultado == 3 || resultado == 4) {
            restposta = 2;

        } else if (resultado == 5 || resultado == 6) {
            restposta = 3;

        }

        return restposta;
    }

    /**
     * Componente 3
     *
     * @param horas
     * @return
     */
    private int duracaoDoSonoComponente3(int horas) {
        int restposta = 0;

        if (horas > 7) {
            restposta = 0;
            getClassificacaoSonoPittsburghBeans().setComponente_3resposta_Questao_4(Constantes.RESULTADO_QUESTAO_4_0);
        } else if (horas == 6 || horas == 7) {
            restposta = 1;
            getClassificacaoSonoPittsburghBeans().setComponente_3resposta_Questao_4(Constantes.RESULTADO_QUESTAO_4_1);
        } else if (horas >= 5 || horas < 6) {
            restposta = 2;
            getClassificacaoSonoPittsburghBeans().setComponente_3resposta_Questao_4(Constantes.RESULTADO_QUESTAO_4_2);
        } else if (horas < 5) {
            restposta = 3;
            getClassificacaoSonoPittsburghBeans().setComponente_3resposta_Questao_4(Constantes.RESULTADO_QUESTAO_4_3);

        }

        return restposta;

    }

    //=====================componente4=================

    /**
     * @param sonoPittsburghBeans
     * @return
     */
    private int calculoEficienciaSonoComponente4(SonoPittsburghBeans sonoPittsburghBeans) {
        int resposta = 0;
        //Escreva o número de horas dormidas (questão 4)

        int horasDormidas = sonoPittsburghBeans.getPergunta_sono_04();
        getClassificacaoSonoPittsburghBeans().setComponente_4_numHorasDormidas(horasDormidas);

        int horaDormir = sonoPittsburghBeans.getPergunta_sono_01();
        int horaLevantar = sonoPittsburghBeans.getPergunta_sono_03();

        String horaFragLevantar = Integer.toString(horaLevantar);
        getClassificacaoSonoPittsburghBeans().setComponente_4_horarioLevantar(Integer.parseInt(horaFragLevantar));

        if (horaFragLevantar.length() == 0) {
            horaFragLevantar =  horaFragLevantar = "0000";
        }else if(horaFragLevantar.length() == 1){
            horaFragLevantar =  horaFragLevantar = "000"+ horaFragLevantar;
        }else if(horaFragLevantar.length() == 2){
            horaFragLevantar =  horaFragLevantar = "00"+ horaFragLevantar;
        }else if(horaFragLevantar.length() == 3) {
            horaFragLevantar = "0" + horaFragLevantar;
        }
        String horaAcordar = horaFragLevantar.substring(0, 2);
        String minutosAcordar = horaFragLevantar.substring(2, 4);
        int fragHoraLevantar = Integer.parseInt(horaAcordar);
        int fragMinuLevantar = Integer.parseInt(minutosAcordar);



//-------------dormir---------------------------------------------
        String horaFragDormir = Integer.toString(horaDormir);
        getClassificacaoSonoPittsburghBeans().setComponente_4_horarioDormir(Integer.parseInt(horaFragDormir));


        if (horaFragDormir.length() == 0) {
            horaFragDormir =  horaFragDormir = "0000";
        }else if(horaFragDormir.length() == 1){
            horaFragDormir =  horaFragDormir = "000"+ horaFragDormir;
        }else if(horaFragDormir.length() == 2){
            horaFragDormir =  horaFragDormir = "00"+ horaFragDormir;
        }else if(horaFragDormir.length() == 3) {
            horaFragDormir = "0" + horaFragDormir;
        }
        String horaDorm = horaFragDormir.substring(0, 2);
        String minutosDrom = horaFragDormir.substring(2,4);

        int fragHoraDormir = Integer.parseInt(horaDorm);
        int fragMinuDormir = Integer.parseInt(minutosDrom);


        long horasNoLeito = 0;
        // Calcule o número de horas no leito:
        //{horário de levantar (questão 3) – horário de deitar (questão 1)}

//--------------------------------------------------------------------------






        /*
        ZoneId americaBr = ZoneId.of("America/Sao_Paulo");


        LocalDateTime dateTimeDormir = LocalDateTime.of(2019, 10, 28,fragHoraDormir,fragMinuDormir,0);
        LocalDateTime dateTimeAcordar = LocalDateTime.of(2019, 10, 29,fragHoraLevantar,fragMinuLevantar,0);


        LocalTime horaAcodarLocal = LocalTime.of(fragHoraLevantar, fragMinuLevantar, 0);
        LocalTime horaDormirLocal = LocalTime.of(fragHoraDormir, fragMinuDormir, 0);

      //  horasNoLeito = horaDormirLocal.until(horaAcodarLocal, ChronoUnit.HOURS);

      //  Duration duration = Duration.between(horaDormirLocal,horaAcodarLocal);
        Duration duration = Duration.between(dateTimeDormir,dateTimeAcordar);
        horasNoLeito = duration.toHours();
        getClassificacaoSonoPittsburghBeans().setComponente_4_numHorasLeito(horasNoLeito);

//*
        //horasNoLeito = duration.get(ChronoUnit.HOURS);


         */
        horasNoLeito = calcularHorasLeito(fragHoraDormir,fragHoraLevantar);
        getClassificacaoSonoPittsburghBeans().setComponente_4_numHorasLeito(horasNoLeito);


        /**
         *  Calcule a eficiência do sono:
         * {no de horas dormidas/no de horas no leito} x 100 = eficiência do sono(%)
         *  Atribua a pontuação do componente 4 da seguinte maneira:
         */
        long resultadoEficienciaSono = (horasDormidas/horasNoLeito )* 100;

        resposta = (int) eficienciaSonoComponente4(resultadoEficienciaSono);


        return resposta;
    }

    private int calcularHorasLeito(int horasDormir, int horasAcordar){
        int horasParc = 0;

        if((horasDormir >=18 && horasDormir <=22)){
                horasParc = (24 - horasDormir)+horasAcordar;

        }else if( horasDormir==23){
            horasParc = horasAcordar+1;
        }
        else if(horasDormir==0){
            horasParc = horasAcordar;

        }else if(horasDormir>0){
            horasParc = horasAcordar-horasDormir;

        }

        return horasParc;

    }




    /**
     * Eficiencia do sono COmponente 4
     *
     * @param escore
     * @return
     */
    private long eficienciaSonoComponente4(long escore) {
        long restposta = 0;

        if (escore > 85) {
            restposta = 0;
            getClassificacaoSonoPittsburghBeans().setPercentagem_componente_04(Constantes.RESULTADO_COMPONENTE_4_0);
        } else if (escore >= 75 && escore <= 84) {
            restposta = 1;
            getClassificacaoSonoPittsburghBeans().setPercentagem_componente_04(Constantes.RESULTADO_COMPONENTE_4_1);
        } else if (escore >= 65 && escore <= 74) {
            restposta = 2;
            getClassificacaoSonoPittsburghBeans().setPercentagem_componente_04(Constantes.RESULTADO_COMPONENTE_4_2);
        } else if (escore < 65) {
            restposta = 3;
            getClassificacaoSonoPittsburghBeans().setPercentagem_componente_04(Constantes.RESULTADO_COMPONENTE_4_3);

        }

        return restposta;

    }

    //=======================componente 5==================================

    /**
     * @param sonoPittsburghBeans
     * @return
     */
    private int calculoDisturbioSono(SonoPittsburghBeans sonoPittsburghBeans) {

        int escore = 0;

        int resulatadoPontuacao = sonoPittsburghBeans.getPergunta_sono_05_a() + sonoPittsburghBeans.getPergunta_sono_05_b() +
                sonoPittsburghBeans.getPergunta_sono_05_c() + sonoPittsburghBeans.getPergunta_sono_05_d() + sonoPittsburghBeans.getPergunta_sono_05_e() +
                sonoPittsburghBeans.getPergunta_sono_05_f() + sonoPittsburghBeans.getPergunta_sono_05_g() + sonoPittsburghBeans.getPergunta_sono_05_h() +
                sonoPittsburghBeans.getPergunta_sono_05_i() + sonoPittsburghBeans.getPergunta_sono_05_k();
        classificacaoSonoPittsburghBeans.setComponente_5_somatoria_a_k(resulatadoPontuacao);

        if (resulatadoPontuacao == 0) {
            escore = 0;
        } else if (resulatadoPontuacao >= 1 && resulatadoPontuacao <= 9) {
            escore = 1;
        } else if (resulatadoPontuacao >= 10 && resulatadoPontuacao <= 18) {
            escore = 2;
        } else  {
            escore = 3;
        }
        classificacaoSonoPittsburghBeans.setPontuacaoComponente_5(escore);


        return escore;

    }

    //Componenete 6==========================================

    /**
     * resposta componente 6
     * @param resultado
     *
     */
    private void respostaComponente6(int resultado) {

        String resposta = null;
        if (resultado == 0) {
            resposta = Constantes.RESULTADO_QUESTAO_5_0;
        } else if (resultado == 1) {
            resposta = Constantes.RESULTADO_QUESTAO_5_1;
        } else if (resultado == 2) {
            resposta = Constantes.RESULTADO_QUESTAO_5_2;
        } else if (resultado == 3) {
            resposta = Constantes.RESULTADO_QUESTAO_5_3;
        }
        getClassificacaoSonoPittsburghBeans().setPontuacao_questao_6(resultado);
        getClassificacaoSonoPittsburghBeans().setComponente_6_resposta(resposta);
        getClassificacaoSonoPittsburghBeans().setPontuacaoComponente_6(resultado);



    }


    //=======================componente 7

    /**
     * Calculo 7
     * @param sonoPittsburghBeans
     * @return
     */
    private int calculoDisfuncaoDiaComp7(SonoPittsburghBeans sonoPittsburghBeans) {

        getClassificacaoSonoPittsburghBeans().setPontuacao_questao_7_1(sonoPittsburghBeans.getPergunta_sono_07());
        getClassificacaoSonoPittsburghBeans().setResposta_questao_7_1(respostaComponente7(sonoPittsburghBeans.getPergunta_sono_07()));

        getClassificacaoSonoPittsburghBeans().setPontuacao_questao_7_2(sonoPittsburghBeans.getPergunta_sono_09());
        getClassificacaoSonoPittsburghBeans().setResposta_questao_7_2(respostaComponente7_2(sonoPittsburghBeans.getPergunta_sono_09()));

        int somatorioGeral = 0;
        int somatorioQ8Q9 = sonoPittsburghBeans.getPergunta_sono_08() + sonoPittsburghBeans.getPergunta_sono_09();
        int pontuacaoComponente7 = 0;

        getClassificacaoSonoPittsburghBeans().setSomatoria_questao_7_3_9_sum_8(somatorioQ8Q9);

        somatorioGeral = somatorioQ8Q9;

        pontuacaoComponente7 = escoreComponente7_Pontuacao(somatorioGeral);
        getClassificacaoSonoPittsburghBeans().setPontuacaoComponente_7(pontuacaoComponente7);

        return somatorioGeral;
    }

    private String respostaComponente7(int resultado) {

        String resposta = null;


        if (resultado == 0) {
            resposta = Constantes.RESULTADO_QUESTAO_5_0;
        } else if (resultado == 1) {
            resposta = Constantes.RESULTADO_QUESTAO_5_1;
        } else if (resultado == 2) {
            resposta = Constantes.RESULTADO_QUESTAO_5_2;
        } else if (resultado == 3) {
            resposta = Constantes.RESULTADO_QUESTAO_5_3;
        }
        return resposta;
    }
    private String respostaComponente7_2(int resultado) {

        String resposta = null;


        if (resultado == 0) {
            resposta = Constantes.RESULTADO_NENHUMA;
        } else if (resultado == 1) {
            resposta = Constantes.RESULTADO_PEQUENA;
        } else if (resultado == 2) {
            resposta = Constantes.RESULTADO_MODERADA;
        } else if (resultado == 3) {
            resposta = Constantes.RESULTADO_MUITO;
        }
        return resposta;
    }
    private int escoreComponente7_Pontuacao(int soma){

        int escore = 0;

        if(soma==0){

            escore=0;

        }else if(soma ==1 || soma ==2){

            escore=1;
        }else if(soma==3 || soma ==4){

            escore=2;
        }else if(soma >=5 && soma <=7){

            escore=3;
        }


        return escore;

    }






    //Somatorio dos componentes  de 1 a 7  PSQI SOMATORIO

    private void resultadoPSQUI(int somatorio) {

        if (somatorio >= 0 && somatorio <= 4) {
            getClassificacaoSonoPittsburghBeans().setResultado_total_PSQI_componentes(Constantes.RESULTADO_COMPONENTE_soma_7_0_4);
            getClassificacaoSonoPittsburghBeans().setEscore_total_PSQI_componentes(somatorio);
        } else if (somatorio >= 5 && somatorio <= 10) {
            getClassificacaoSonoPittsburghBeans().setResultado_total_PSQI_componentes(Constantes.RESULTADO_COMPONENTE_soma_7_5_10);
            getClassificacaoSonoPittsburghBeans().setEscore_total_PSQI_componentes(somatorio);
        } else if (somatorio > 10) {
            getClassificacaoSonoPittsburghBeans().setResultado_total_PSQI_componentes(Constantes.RESULTADO_COMPONENTE_soma_7_maior_10);
            getClassificacaoSonoPittsburghBeans().setEscore_total_PSQI_componentes(somatorio);
        }
    }


    public ClassificacaoSonoPittsburghBeans getClassificacaoSonoPittsburghBeans() {
        return classificacaoSonoPittsburghBeans;
    }

    public void setClassificacaoSonoPittsburghBeans(ClassificacaoSonoPittsburghBeans classificacaoSonoPittsburghBeans) {
        this.classificacaoSonoPittsburghBeans = classificacaoSonoPittsburghBeans;
    }
}
