package br.com.asb.negocio;

import br.com.asb.util.Constantes;
import kotlin.jvm.Synchronized;

public class ClassificacaoBurnOutCalculos {

    private static ClassificacaoBurnOutCalculos instancia;

    private ClassificacaoBurnOutCalculos() {


    }

    /**
     *
     * @return
     */
    public static synchronized ClassificacaoBurnOutCalculos getInstance() {
        if (instancia == null) {
            instancia = new ClassificacaoBurnOutCalculos();
        }

        return instancia;
    }


    /**
     *### ILUSAO DO TRABALHO ###
     */
    /**
     * calcula a media do trabaho
     *
     * @param mediaTrabalho
     * @return
     */
    protected String calculoClassificacaoIlusaoTrabalho(int mediaTrabalho) {
        String resultado = null;

        //ilusão pelo trabalho tem perguntas invertidas. quanto mais perto do 0 maior nivel de burnout

        /**
         *0 a3 - muito ruim
         * 4 a 8 ruim
         * 9 a 12 médio
         * 13 a 16 baixo
         * 17 a 20 muito baixo
         *
         */
        if (mediaTrabalho <= 3) {
            resultado = Constantes.RESULTADO_MUITO_RUIM;
        } else if (mediaTrabalho >= 4 && mediaTrabalho <= 8) {
            resultado = Constantes.RESULTADO_RUIM;
        } else if (mediaTrabalho >= 9 && mediaTrabalho <= 12) {
            resultado = Constantes.RESULTADO_MÉDIO;
        } else if (mediaTrabalho >= 13 && mediaTrabalho <= 16) {
            resultado = Constantes.RESULTADO_BAIXO;
        } else if (mediaTrabalho >= 17 && mediaTrabalho <= 20) {
            resultado = Constantes.RESULTADO_MUITO_BAIXO;
        } else {
            resultado = Constantes.RESULTADO_MUITO_BAIXO;
        }

        return resultado;
    }

    /**
     * calcula perc parcial (regra de negocio add)
     * @param mediaIlusaTrabalho
     * @return
     */
    protected Integer calculoPercParcialIlusaoTrabalho(int mediaIlusaTrabalho){
        int resultado = 0;

        if (mediaIlusaTrabalho <= 3) {
            resultado = 5;
        } else if (mediaIlusaTrabalho >= 4 && mediaIlusaTrabalho <= 8) {
            resultado = 10;
        } else if (mediaIlusaTrabalho >= 9 && mediaIlusaTrabalho <= 12) {
            resultado = 20;
        } else if (mediaIlusaTrabalho >= 13 && mediaIlusaTrabalho <= 16) {
            resultado = 25;
        } else if (mediaIlusaTrabalho >= 17 && mediaIlusaTrabalho <= 20) {
            resultado = 30;
        } else {
            resultado = 0;
        }


        return resultado;

    }

    /**
     * Calcular Níveis Ilusao
     *
     * @param porcentagem
     * @return
     */
    protected String calcularNiveisEstresseIlusao(int porcentagem) {

        String nivel = null;

        if (porcentagem >=3  && porcentagem <= 8) {
            nivel = Constantes.RESULTADO_NIVEL_BO_ELEVADO;

        } else if (porcentagem >= 9 && porcentagem <= 12) {
            nivel = Constantes.RESULTADO_NIVEL_BO_MEDIO;

        } else if (porcentagem >= 13 && porcentagem <= 16) {
            nivel = Constantes.RESULTADO_NIVEL_BO_BAIXO;

        } else if (porcentagem >= 17 && porcentagem <= 20) {
            nivel = Constantes.RESULTADO_NIVEL_BO_MUITO_BAIXO;

        }else{
            nivel = Constantes.DEFAULT;
        }

        return nivel;
    }

    /*###DESGASTE PSIQUICO/###*

  /**
   * calculo separado desgaste psiquico
   * @param mediaDesgastePsiquico
   * @return
   */
    protected String calculoClassificacaoDesgastePsiquico(int mediaDesgastePsiquico) {

        String resultado = null;

            /*
            Questões de Desgaste Psíquico são 8,12,17,18.
            0 a 5= nível baixo =10%
            6 a 11= nível médio =20%
            12 a 16= nível elevado =30%
            */
        if (mediaDesgastePsiquico <= 5) {
            resultado = Constantes.RESULTADO_NIVEL_BO_BAIXO;
        } else if (mediaDesgastePsiquico >= 6 && mediaDesgastePsiquico <= 11) {
            resultado = Constantes.RESULTADO_NIVEL_BO_MEDIO;
        } else if (mediaDesgastePsiquico >= 12 && mediaDesgastePsiquico <= 16) {
            resultado = Constantes.RESULTADO_NIVEL_BO_ELEVADO;
        }


        return resultado;


    }

    /**
     * @param totalResposta
     * @return
     */
    protected Integer calculoPercParcialDesgastePsiquico(int totalResposta) {
        int percentualTotal = 0;
        if (totalResposta <= 5) {
            percentualTotal = 10;
        } else if (totalResposta >= 6 && totalResposta <= 11) {
            percentualTotal = 20;
        } else if (totalResposta >= 12 && totalResposta <= 16) {
            percentualTotal = 30;
        }

        return percentualTotal;
    }


    /*INDOLENCIA*/

    /**
     * calculo separado indolencia
     * @param mediaIndolencia
     * @return
     */
    protected String calculoClassificacaoIndolencia(int mediaIndolencia) {

        String resultado = null;

            /*
                    Questões de Indolência são 2,3,6,7,11,14
                    0 a 8= nível baixo =10%
                    9 a 16=nível médio =20%
                    17 a 24= nível elevado =30%

            */

        if (mediaIndolencia <= 8) {
            resultado = Constantes.RESULTADO_NIVEL_BO_BAIXO;
        } else if (mediaIndolencia >= 9 && mediaIndolencia <= 16) {
            resultado = Constantes.RESULTADO_NIVEL_BO_MEDIO;
        } else if (mediaIndolencia >= 17 && mediaIndolencia <= 24) {
            resultado = Constantes.RESULTADO_NIVEL_BO_ELEVADO;
        }

        return resultado;


    }

    /**
     * Retorna calculo perc Indolencia
     * @param totalRespostaIndolencia
     * @return
     */
    protected Integer claculoPercIndolencia(int totalRespostaIndolencia) {
        int percentualTotal = 0;
        if (totalRespostaIndolencia <= 8) {
            percentualTotal = 10;
        } else if (totalRespostaIndolencia >= 9 && totalRespostaIndolencia <= 16) {
            percentualTotal = 20;
        } else if (totalRespostaIndolencia >= 17 && totalRespostaIndolencia <= 24) {
            percentualTotal = 30;
        }

        return percentualTotal;
    }


    /*DESGASTE PSIQUICO + INDOLENCIA/*
/**
* calcula a media do desgaste desgaste psiquico e indolencia
*
* @param media
* @return
*/
    protected String calculoClassificacaoIndolenciaDesgastePsiquico(int media) {
        String resultado = null;


        /**
         *30 a 40 nivel critico
         * 24 a 29 muito ruim
         * 18 a 23 ruim
         * 12 a 17 médio
         * 6 a 11 baixo
         * 0 a 5 muito baixo
         *
         */

        if (media >= 0 && media <= 5) {
            resultado = Constantes.RESULTADO_MUITO_BAIXO;
        } else if (media >= 6 && media <= 11) {
            resultado = Constantes.RESULTADO_BAIXO;
        } else if (media >= 12 && media <= 17) {
            resultado = Constantes.RESULTADO_MÉDIO;
        } else if (media >= 18 && media <= 23) {
            resultado = Constantes.RESULTADO_RUIM;
        } else if (media >= 24 && media <= 29) {
            resultado = Constantes.RESULTADO_MUITO_RUIM;
        } else if (media >= 30 && media <= 40) {
            resultado = Constantes.RESULTADO_CRITICO;
        } else {
            resultado = Constantes.RESULTADO_CRITICO;
        }


        return resultado;
    }

    /*## CULPA ##/*
    /**
     * Culpa
     *
     * @param media
     * @return
     */
    protected String calculoClassificacaoCulpa(int media, int percentualDesgasteIndolencia) {
        String resultado = null;
        if (percentualDesgasteIndolencia >= 90) {

            if (media <= 17) {
                resultado = Constantes.RESULTADO_NIVEL_CRITICO_1;

            } else if (media >= 18 && media <= 29) {
                resultado = Constantes.RESULTADO_NIVEL_CRITICO_2;
            }
        } else {
            resultado = Constantes.RESULTADO_NIVEL_CRITICO_0;

        }

        return resultado;
    }

    protected String calculoPercentualFinalCulpa(int total) {
        String resultado = null;
        if(total<=10){
            resultado = Constantes.RESULTADO_NIVEL_CRITICO_1;
        }else if (total>=11 && total<=20){
            resultado = Constantes.RESULTADO_NIVEL_CRITICO_2;

        }else{

            resultado = Constantes.DEFAULT;
        }




        return resultado;
    }


    /**
     * Calcular Níveis exceto Ilusão
     *
     * @param porcentagem
     * @return
     */
    protected String calcularNiveisEstressePsicoIndolencia(int porcentagem) {

        String nivel = null;

        if (porcentagem <= 10) {
            nivel = Constantes.RESULTADO_NIVEL_BO_MUITO_BAIXO;

        } else if (porcentagem >= 11 && porcentagem <= 33) {
            nivel = Constantes.RESULTADO_NIVEL_BO_BAIXO;

        } else if (porcentagem >= 34 && porcentagem <= 66) {
            nivel = Constantes.RESULTADO_NIVEL_BO_MEDIO;

        } else if (porcentagem >= 67 && porcentagem <= 90) {
            nivel = Constantes.RESULTADO_NIVEL_BO_ELEVADO;

        } else {
            nivel = Constantes.DEFAULT;

        }

        return nivel;
    }

    /** BURN_OUT RESULTADO
     */
    protected String calcularResultadoSomatoriaBurnOutPercentual(int porcentagem){


        String nivel = null;

        if (porcentagem <= 10) {
            nivel = Constantes.RESULTADO_NIVEL_BO_MUITO_BAIXO;

        } else if (porcentagem >= 11 && porcentagem <= 33) {
            nivel = Constantes.RESULTADO_NIVEL_BO_BAIXO;

        } else if (porcentagem >= 34 && porcentagem <= 66) {
            nivel = Constantes.RESULTADO_NIVEL_BO_MEDIO;

        } else if (porcentagem >= 67 && porcentagem <= 90) {
            nivel = Constantes.RESULTADO_NIVEL_BO_ELEVADO;

        } else {
            nivel = Constantes.DEFAULT;

        }

        return nivel;

    }


}
