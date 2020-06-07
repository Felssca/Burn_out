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



    public void calcularSindromeBurnOut(AnamineseProfissionalBean anamineseProfissionalBean, BurnOutBean burnOutBean) {


        classificacaoBurnOutBeans = new ClassificacaoBurnOutBeans();


        /* ILUSÃO DO TRABALHO*/
        int somatorioIlusaoTrabalho;
        int classificacaoIlusaoTrabalho;

        //* ilusão pelo trabalho sao perguntas 1,5,10,15,19

        somatorioIlusaoTrabalho = burnOutBean.getPergunta_01() + burnOutBean.getPergunta_05() + burnOutBean.getPergunta_10()
                + burnOutBean.getPergunta_15() + burnOutBean.getPergunta_19();
        classificacaoIlusaoTrabalho = somatorioIlusaoTrabalho;
        classificacaoBurnOutBeans.setClassificacaoIlusaoTrabalho(ClassificacaoBurnOutCalculos.getInstance().calculoClassificacaoIlusaoTrabalho(classificacaoIlusaoTrabalho));
        classificacaoBurnOutBeans.setPercentualParcialIlusao(ClassificacaoBurnOutCalculos.getInstance().calculoPercParcialIlusaoTrabalho(somatorioIlusaoTrabalho));
        classificacaoBurnOutBeans.setSomatorioIlusao(somatorioIlusaoTrabalho);
        classificacaoBurnOutBeans.setClassificacaoNivelIlusao(ClassificacaoBurnOutCalculos.getInstance().calcularNiveisEstresseIlusao(somatorioIlusaoTrabalho));

        /* DESGASTE PSIQUICO*/

        //desgaste psiquico   8,12,17,18
        //Para isso vamos somar as respostas de cada componente separadamente.
        //Questões de Desgaste Psíquico são 8,12,17,18.
        //0 a 5 =nível baixo = 10%
        //6 a 11 =nível médio = 20%
        //12 a 16 =nível elevado = 30%

        int somatorioDesgastePsiquico;
        int classificacaoDesgastePsiquico;

        somatorioDesgastePsiquico = burnOutBean.getPergunta_08() + burnOutBean.getPergunta_12() + burnOutBean.getPergunta_17()
                + burnOutBean.getPergunta_18();
        classificacaoDesgastePsiquico = somatorioDesgastePsiquico;
        classificacaoBurnOutBeans.setSomatorioDesgastePsiquico(somatorioDesgastePsiquico);
        classificacaoBurnOutBeans.setClassificacaoDesgastePsiquico(ClassificacaoBurnOutCalculos.getInstance().calculoClassificacaoDesgastePsiquico(somatorioDesgastePsiquico));
        classificacaoBurnOutBeans.setPercentualParcialDesgastePsiquico(ClassificacaoBurnOutCalculos.getInstance().calculoPercParcialDesgastePsiquico(somatorioDesgastePsiquico));
        classificacaoBurnOutBeans.setClassificacaoResultadoDesgastePsiquico(somatorioDesgastePsiquico);

        /* INDOLENCIA*/

        //  indolencia  3,2,6,7,11,14
        /*
        Questões de Indolência são 2,3,6,7,11,14
         0 a 8=nível baixo =10%
         9 a 16=nível médio =20%
         17 a 24= nível elevado =30%
         */

        int somatorioIndolencia;
        int classificacaoIndolencia;

        somatorioIndolencia = burnOutBean.getPergunta_03() + burnOutBean.getPergunta_02() + burnOutBean.getPergunta_06() + burnOutBean.getPergunta_07() +
                burnOutBean.getPergunta_11() + burnOutBean.getPergunta_14();
        classificacaoIndolencia = somatorioIndolencia;

        classificacaoBurnOutBeans.setSomatorioIndolencia(somatorioIndolencia);
        classificacaoBurnOutBeans.setClassificacaoIndolencia(ClassificacaoBurnOutCalculos.getInstance().calculoClassificacaoIndolencia(somatorioIndolencia));
        classificacaoBurnOutBeans.setPercentualParcialIndolencia(ClassificacaoBurnOutCalculos.getInstance().claculoPercIndolencia(somatorioIndolencia));

        /* INDOLENCIA + DESGASTE PSIQUICO */
        int classificacaoDesgastePsiquicoIndolencia;

        classificacaoDesgastePsiquicoIndolencia = classificacaoIndolencia + classificacaoDesgastePsiquico;
        classificacaoBurnOutBeans.setDesgastePsiquicoIndolenciaTotal(classificacaoDesgastePsiquicoIndolencia);
        classificacaoBurnOutBeans.setClassificacaoDesgastePsiquicoIndolencia(
                ClassificacaoBurnOutCalculos.getInstance().calculoClassificacaoIndolenciaDesgastePsiquico(classificacaoDesgastePsiquicoIndolencia));


        /* CULPA */


        // culpa culpa 4,9,13,16,20
        //0 a 18 nivel critico 1
        //18 a 20 nivel critico 2
        int somatorioCulpa;
        int totalCulp;

        somatorioCulpa = burnOutBean.getPergunta_04() + burnOutBean.getPergunta_09() + burnOutBean.getPergunta_13() + burnOutBean.getPergunta_16() +
                burnOutBean.getPergunta_20();

        totalCulp = somatorioCulpa;
        classificacaoBurnOutBeans.setSomatorioCulpa(somatorioCulpa);
        classificacaoBurnOutBeans.setClassificacaoCulpa(ClassificacaoBurnOutCalculos.getInstance()
        .calculoPercentualFinalCulpa(totalCulp));

        /* RESULTADO FINAL BURNOUT:*/




        //SOMAR OS 3 NÍVEIS
        // Ou seja, cada componente corresponde a 30% das respostas.
        /*
        Nível elevado em ilusão pelo trabalho =30%
        nível médio em indolência =20%
        nível baixo em  desgaste psíquico =10%
         */

        int somatorioFinalBurnOut = classificacaoBurnOutBeans.getSomatorioIlusao() + classificacaoBurnOutBeans.getSomatorioIndolencia()
                +classificacaoBurnOutBeans.getSomatorioDesgastePsiquico();
        classificacaoBurnOutBeans.setSomatoriaPercentualTotalBurnOUT(somatorioFinalBurnOut);

        classificacaoBurnOutBeans.setClassificacaoSomatorioTotalBurnOUT(ClassificacaoBurnOutCalculos.getInstance().calcularResultadoSomatoriaBurnOutPercentual(somatorioFinalBurnOut));







    }










    /**
     *
     * Removido do projeto na versão final
     * Calcular percentual e níveis de burnmOut
     *
     * @param classificacaoBurnOutBeans

    private void calcularPercentil(ClassificacaoBurnOutBeans classificacaoBurnOutBeans) {

        /**
         * Questões de Ilusão pelo Trabalho estão invertidas, respostas muito baixas significam mais alto nível de burnout
         *  calcular a % do ilusão do trabalho: total de perguntas 5(1, 5, 10,15 e 19)
         */

      //  int ilusaoTotal = classificacaoBurnOutBeans.getSomatorioIlusao();
        //20 total de pontos 100%

      //  int ilusaoTotalPercent = ((ilusaoTotal * 20) / 100);
      //  classificacaoBurnOutBeans.setPercentualFinalIlusao(ilusaoTotalPercent);
      //  classificacaoBurnOutBeans.setClassificacaoNivelIlusao(calcularNiveisEstresseIlusao(ilusaoTotalPercent));

        /**
         * DESGASTE
         */
      //  int desgasteTotal = classificacaoBurnOutBeans.getSomatorioDesgastePsiquico();
      //  int desgasteTotalPercentualFinal = ((desgasteTotal * 20) /100);
      //  classificacaoBurnOutBeans.setPercentualFinalDesgastePsiquico(desgasteTotalPercentualFinal);

        /**
         * INDOLENCIA
         */
       // int indolenciaTotal = classificacaoBurnOutBeans.getSomatorioIndolencia();
       // int indolenciaTotalPercentualFinal = ((indolenciaTotal * 20 ) /100);
      //  classificacaoBurnOutBeans.setPercentualFinalDesgastePsiquico(indolenciaTotalPercentualFinal);


        /**
         * DESGASTE+INDOLECNIA

         * Questões de Desgaste Psíquico são 8,12,17,18.
         * E Questões de Indolência são 2,3,6,7,11,14 são
         * somadas junto, faz o cálculo pela regra de três para verificar a porcentagem
         */

       // int indolenciaDesgaste = classificacaoBurnOutBeans.getSomatorioDesgastePsiquico() + classificacaoBurnOutBeans.getSomatorioIndolencia();
       // int indolenciaDesgastePercent = ((indolenciaDesgaste * 40) / 100);
       // classificacaoBurnOutBeans.setPercentuaDesgasteIndolencia(indolenciaDesgastePercent);
        //classificacaoBurnOutBeans.setClassifcacaoNivelPsiquicoIndolencia(calcularNiveisEstressePsicoIndolencia(indolenciaDesgastePercent));

        /**
         *Escala de Culpa são as questões 4,9,13,16 e 20. São calculadas separadamente.
         * Representa o perfil crítico 1 e perfil crítico 2 de burnout.
         * Isso significa que no total do questionário o resultado foi maior que 90%.
         */

       // int culpaTotal = classificacaoBurnOutBeans.getSomatorioCulpa();
       // int culpaPercentual = ((culpaTotal * 20) / 100);
        //classificacaoBurnOutBeans.setPercentualFinalCulpa(culpaPercentual);

    //}



}
