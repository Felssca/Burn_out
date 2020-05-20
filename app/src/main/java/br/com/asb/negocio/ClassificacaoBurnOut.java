package br.com.asb.negocio;

import android.provider.ContactsContract;
import android.util.Log;

import br.com.asb.bean.AnamineseProfissionalBean;
import br.com.asb.bean.BurnOutBean;
import br.com.asb.bean.ClassificacaoBurnOutBeans;
import br.com.asb.util.Constantes;

public class ClassificacaoBurnOut {

    public ClassificacaoBurnOutBeans getClassificacaoBurnOutBeans() {
        return classificacaoBurnOutBeans;
    }

    public void setClassificacaoBurnOutBeans(ClassificacaoBurnOutBeans classificacaoBurnOutBeans) {
        this.classificacaoBurnOutBeans = classificacaoBurnOutBeans;
    }

    private ClassificacaoBurnOutBeans classificacaoBurnOutBeans;




    /*
    20 itens
    4 subescalas
    Ilusão pelo trabalho (cinco itens)
    Desgaste psíquico (quatro itens)
    Indolência (seis itens)
    Culpa (cinco itens)

    0 a 4
     2 ponto intermediario
      o a pontuação 2
 Cada subescala
foi calculada pela média da pontuação dos itens que
a compunham.

 Baixas pontuações na Ilusão pelo
trabalho (< 2) e altas pontuações em Desgaste psíquico,
Indolência e Culpa (≥ 2) supõe altos níveis do síndrome
de burnout

     */



public void calcularSindromeBurnOut(AnamineseProfissionalBean anamineseProfissionalBean,BurnOutBean burnOutBean){

        /**
         * Media pontuação de ilusão
         * Baixas pontuações na Ilusão pelo
         * trabalho (< 2) e altas pontuações em Desgaste psíquico,
         * Indolência e Culpa (≥ 2) supõe altos níveis do síndrome
         *
         * ilusão pelo trabalho sao perguntas 1,5,10,15,19
         * desgaste psiquico 8,12,17,18
         * indolencia        3,2,6,7,11,14
         * culpa4,9,13,16,20
         */

        /**
         *
         * ilusāo pelo trabalho tem 5 perguntas,
         * somando as respostas o máximo que pode dar é 20, podemos dividir nas subescalas
         * critico
         * muito ruim
         * ruim
         * médio
         * baixo
         * muito baixo
         *

         */


        //
   //     ClassificacaoBurnOutBeans classificacaoBurnOutBeans = new ClassificacaoBurnOutBeans();


        classificacaoBurnOutBeans = new ClassificacaoBurnOutBeans();

        int somatorioIlusaoTrabalho;
        int classificacaoIlusaoTrabalho;

        //* ilusão pelo trabalho sao perguntas 1,5,10,15,19

        somatorioIlusaoTrabalho =  burnOutBean.getPergunta_01()+ burnOutBean.getPergunta_05()+ burnOutBean.getPergunta_10()
                +burnOutBean.getPergunta_15()+burnOutBean.getPergunta_19();
        classificacaoIlusaoTrabalho = somatorioIlusaoTrabalho;

        classificacaoBurnOutBeans.setClassificacaoIlusaoTrabalho(calculoClassificacaoIlusaoTrabalho(classificacaoIlusaoTrabalho));
        classificacaoBurnOutBeans.setSomatorioIlusao(somatorioIlusaoTrabalho);
        calculoClassificacaoIlusaoTrabalho(classificacaoIlusaoTrabalho);


        //desgaste psiquico   8,12,17,18


        int somatorioDesgastePsiquico;
        int classificacaoDesgastePsiquico;

        somatorioDesgastePsiquico = burnOutBean.getPergunta_08()+burnOutBean.getPergunta_12()+burnOutBean.getPergunta_17()+burnOutBean.getPergunta_18();
        classificacaoDesgastePsiquico = somatorioDesgastePsiquico;

        classificacaoBurnOutBeans.setSomatorioDesgastePsiquico(somatorioDesgastePsiquico);
        classificacaoBurnOutBeans.setClassificacaoDesgastePsiquico(classificacaoDesgastePsiquico);

      //  somatorioDesgastePsiquico

    //  indolencia        3,2,6,7,11,14

        int somatorioIndolencia;
        int classificacaoIndolencia;

        int classificacaoDesgastePsiquicoIndolencia;

        somatorioIndolencia = burnOutBean.getPergunta_03()+burnOutBean.getPergunta_02()+burnOutBean.getPergunta_06()+burnOutBean.getPergunta_07()+
                burnOutBean.getPergunta_11()+burnOutBean.getPergunta_14();
        classificacaoIndolencia = somatorioIndolencia;

        classificacaoBurnOutBeans.setSomatorioIndolencia(somatorioIndolencia);
        classificacaoBurnOutBeans.setClassificacaoIndolencia(classificacaoIndolencia);

        //classificacao_geral

        classificacaoDesgastePsiquicoIndolencia = classificacaoIndolencia+classificacaoDesgastePsiquico;
        classificacaoBurnOutBeans.setDesgastePsiquicoIndolenciaTotal(classificacaoDesgastePsiquicoIndolencia);

        classificacaoBurnOutBeans.setClassificacaoDesgastePsiquicoIndolencia(
                calculoClassificacaoIndolenciaDesgastePsiquico(classificacaoDesgastePsiquicoIndolencia)
        );

    // culpa culpa 4,9,13,16,20
    //0 a 18 nivel critico 1
    //18 a 20 nivel critico 2

    int somatorioCulpa;
    int totalCulp;

        somatorioCulpa = burnOutBean.getPergunta_04()+burnOutBean.getPergunta_09()+burnOutBean.getPergunta_13()+burnOutBean.getPergunta_16()+
            burnOutBean.getPergunta_20();

          totalCulp = somatorioCulpa;

        classificacaoBurnOutBeans.setSomatorioCulpa(somatorioCulpa);


        ///Calcular resultado total dos testesBurnOUT:
        calcularPercentil(classificacaoBurnOutBeans);
        classificacaoBurnOutBeans.setClassificacaoCulpa(calculoClassificacaoCulpa(totalCulp));

    }

    /**
     * calcula a media do trabaho
     * @param mediaTrabalho
     * @return
     */
    private String calculoClassificacaoIlusaoTrabalho(int mediaTrabalho){
        String resultado = null;

        //ilusão pelo trabalho tem perguntas invertidas. quanto mais perto do 0 maior nivel de burnout

        /**
         *
         * 4 a 8 ruim
         * 9 a 12 médio
         * 13 a 16 baixo
         * 17 a 20 muito baixo
         *
         */
            if(mediaTrabalho <= 8){
            resultado = Constantes.RESULTADO_RUIM;

            }else if(mediaTrabalho >= 9 && mediaTrabalho <=12 ){
                resultado = Constantes.RESULTADO_MÉDIO;
            }else if(mediaTrabalho >= 13 && mediaTrabalho <=16 ){
                resultado = Constantes.RESULTADO_BAIXO;
            }else if(mediaTrabalho >= 17 && mediaTrabalho <=20 ) {
                resultado = Constantes.RESULTADO_MUITO_BAIXO;
            }

        return resultado;
    }  /**
     * calcula a media do desgaste desgaste psiquico e indolencia
     * @param media
     * @return
     */
    private String calculoClassificacaoIndolenciaDesgastePsiquico(int media){
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

            if(media >=0 && media <=5){
                resultado = Constantes.RESULTADO_MUITO_BAIXO;
            }else if(media >=6 && media <=11){
                resultado = Constantes.RESULTADO_BAIXO;
            }else if(media >=12 && media <=17 ){
                resultado = Constantes.RESULTADO_MÉDIO;
            }else if(media >=18 && media <=23){
                resultado = Constantes.RESULTADO_RUIM;
            }else if(media >=24 && media <=29 ){
                resultado = Constantes.RESULTADO_MUITO_RUIM;
            }else if(media <= 30 && media <=40  ) {
                resultado = Constantes.RESULTADO_CRITICO;
            }




        return resultado;
    }
/**
     * calcula a media do desgaste desgaste psiquico e indolencia
     * @param media
     * @return
     */
    private String calculoClassificacaoCulpa(int media){
        String resultado = null;


        /**
         *
         *
         */
         if(classificacaoBurnOutBeans.getPercentuaDesgasteIndolencia()>=90){


            if(media <=17 ){
            resultado = Constantes.RESULTADO_NIVEL_CRITICO_1;

            }else if(media >= 18 && media <=29 ) {
                resultado = Constantes.RESULTADO_NIVEL_CRITICO_2;
            }}else{
             resultado = Constantes.RESULTADO_NIVEL_CRITICO_0;

         }

        return resultado;
    }


    /**
     * Calcular Níveis exceto Ilusão
     * @param porcentagem
     * @return
     */
    private String calcularNiveisEstressePsicoIndolencia(int porcentagem){

        String nivel = null;

            if(porcentagem<=10){
            nivel = Constantes.RESULTADO_NIVEL_BO_MUITO_BAIXO;

            }else if(porcentagem >= 11 && porcentagem <= 33){
                nivel = Constantes.RESULTADO_NIVEL_BO_BAIXO;

            }else if(porcentagem >=34 && porcentagem <=66){
                nivel = Constantes.RESULTADO_NIVEL_BO_MEDIO;

            }else if(porcentagem >=67 && porcentagem<=90){
                nivel = Constantes.RESULTADO_NIVEL_BO_ELEVADO;

            }

        return nivel;
    }
 /**
     * Calcular Níveis Ilusao
     * @param porcentagem
     * @return
     */
    private String calcularNiveisEstresseIlusao(int porcentagem){

        String nivel = null;

            if(porcentagem<=10){
            nivel = Constantes.RESULTADO_NIVEL_BO_ELEVADO;

            }else if(porcentagem >=11 && porcentagem <=33){
                nivel = Constantes.RESULTADO_NIVEL_BO_MEDIO;

            }else if(porcentagem >=34 && porcentagem <=66){
                nivel = Constantes.RESULTADO_NIVEL_BO_BAIXO;

            }else if(porcentagem >=67 && porcentagem<=90 ){
                nivel = Constantes.RESULTADO_NIVEL_BO_MUITO_BAIXO;

            }

        return nivel;
    }

    /**
     * Calcular percentual e níveis de burnmOut
     * @param classificacaoBurnOutBeans
     */
 private void calcularPercentil(ClassificacaoBurnOutBeans classificacaoBurnOutBeans){

     /**
      * Questões de Ilusão pelo Trabalho estão invertidas, respostas muito baixas significam mais alto nível de burnout
      *  calcular a % do ilusão do trabalho: total de perguntas 5(1, 5, 10,15 e 19)
      */

     int ilusaoTotal = classificacaoBurnOutBeans.getSomatorioIlusao();
    //20 total de pontos 100%

     int ilusaoTotalPercent = ((ilusaoTotal*20)/100);
     classificacaoBurnOutBeans.setPercentualIlusao(ilusaoTotalPercent);
     classificacaoBurnOutBeans.setClassifcacaoNivelIlusao(calcularNiveisEstresseIlusao(ilusaoTotalPercent));

     /**
      *
      * Questões de Desgaste Psíquico são 8,12,17,18.
      * E Questões de Indolência são 2,3,6,7,11,14 são
      * somadas junto, faz o cálculo pela regra de três para verificar a porcentagem
      */

     int indolenciaDesgaste = classificacaoBurnOutBeans.getSomatorioDesgastePsiquico()+classificacaoBurnOutBeans.getSomatorioIndolencia();
     int  indolenciaDesgastePercent = ((indolenciaDesgaste*40)/100);
     classificacaoBurnOutBeans.setPercentuaDesgasteIndolencia(indolenciaDesgastePercent);
     classificacaoBurnOutBeans.setClassifcacaoNivelPsiquicoIndolencia(calcularNiveisEstressePsicoIndolencia(indolenciaDesgastePercent));

     /**
      *Escala de Culpa são as questões 4,9,13,16 e 20. São calculadas separadamente.
      * Representa o perfil crítico 1 e perfil crítico 2 de burnout.
      * Isso significa que no total do questionário o resultado foi maior que 90%.
      */

     int culpaTotal = classificacaoBurnOutBeans.getSomatorioCulpa();
     int culpaPercentual = ((culpaTotal*20)/100);
     classificacaoBurnOutBeans.setPercentuaCulpa(culpaPercentual);

 }


}
