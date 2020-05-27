package br.com.asb.negocio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import br.com.asb.bean.AlimentacaoBeans;
import br.com.asb.bean.AnamineseProfissionalBean;
import br.com.asb.bean.ClassificacaoAlimentacaoBeans;

public class ClassificacaoAlimentacao {


    private ClassificacaoAlimentacaoBeans classificacaoAlimentacaoBeans;

    public ClassificacaoAlimentacaoBeans getClassificacaoAlimentacaoBeans() {
        return classificacaoAlimentacaoBeans;
    }

    public void setClassificacaoAlimentacaoBeans(ClassificacaoAlimentacaoBeans classificacaoAlimentacaoBeans) {
        this.classificacaoAlimentacaoBeans = classificacaoAlimentacaoBeans;
    }

    public ClassificacaoAlimentacao() {

        classificacaoAlimentacaoBeans = new ClassificacaoAlimentacaoBeans();
    }


    /**
     * Classifar alimentacao
     */

    public void calcularIMC(AnamineseProfissionalBean anamineseProfissionalBean) {


        double altura = 0;
        double IMC = 0;
        double peso = 0;
        double alturaMedia = 0;
        BigDecimal bigDecimal;
        double IMCnovo = 0;


        altura = Double.parseDouble(anamineseProfissionalBean.getAltura());
        //altura = Integer.parseInt(anamineseProfissionalBean.getAltura());
        peso = Double.parseDouble(anamineseProfissionalBean.getPeso());
        //peso = Integer.parseInt(anamineseProfissionalBean.getPeso());
        alturaMedia = altura /100 ;
        IMC = peso / (alturaMedia * alturaMedia);
        bigDecimal = new BigDecimal(IMC).setScale(2, RoundingMode.HALF_UP);
        IMCnovo = bigDecimal.doubleValue();

        classificacaoAlimentacaoBeans.setIMC(IMCnovo);
        classificacaoAlimentacaoBeans.setResultado_IMC(classificacaoIMC(IMCnovo));




    }

    private String classificacaoIMC(Double resultado) {
        String classificacaoIMC = "";

        if (resultado <= 18.5) {
            classificacaoIMC = "Abaixo do peso";

        } else if (resultado >= 18.6 && resultado <= 24.9) {
            classificacaoIMC = "Peso ideal";

        } else if (resultado >= 25 && resultado <= 29.9) {
            classificacaoIMC = "Levemente acima do peso";

        } else if (resultado >= 30 && resultado <= 34.9) {
            classificacaoIMC = "Obesidade grau 1";

        } else if (resultado >= 35 && resultado <= 39.9) {
            classificacaoIMC = "Obesidade grau 2 (severa)";

        } else if (resultado >= 40) {
            classificacaoIMC = "Obesidade grau 3 (mórbida)";

        } else {
            classificacaoIMC = "Não foi possivel calcular !";
        }


        return classificacaoIMC;
    }

    /**
     * Classificar alimentação
     * Da questão 1 a 5 as respostas 3 e 4 são as corretas.
     * Nas questões 6 a 10 as respostas 0 e 1 são as corretas
     * Qualquer outra resposta significa 0
     * Junto com a informação sobre o número de refeições diárias
     */

    public void classificarFrequenciaAlimentar(AlimentacaoBeans alimentacaoBeans) {

        int q1 = alimentacaoBeans.getPergunta_alimentacao_01();
        int q2 = alimentacaoBeans.getPergunta_alimentacao_02();
        int q3 = alimentacaoBeans.getPergunta_alimentacao_03();
        int q4 = alimentacaoBeans.getPergunta_alimentacao_04();
        int q5 = alimentacaoBeans.getPergunta_alimentacao_05();
        int totalQ05 = 0;
        int q6 = alimentacaoBeans.getPergunta_alimentacao_06();
        int q7 = alimentacaoBeans.getPergunta_alimentacao_07();
        int q8 = alimentacaoBeans.getPergunta_alimentacao_08();
        int q9 = alimentacaoBeans.getPergunta_alimentacao_09();
        int q10 = alimentacaoBeans.getPergunta_alimentacao_10();
        int totalQ10 = 0;

        int total;

        int[] x = {q1, q2, q3, q4, q5};
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 3 || x[i] == 4) {
                totalQ05 += +1;
            }


        }
        int[] y = {q6, q7, q8, q9, q10};
        for (int i = 0; i < y.length; i++) {
            if (y[i] == 0 || y[i] == 1) {
                totalQ10 += +1;
            }

        }

        total = totalQ05+totalQ10;

        classificacaoAlimentacaoBeans.setRespostas_resultados_corretas(total);
        classificacaoAlimentacaoBeans.setClassificacao_resultado_respostas(resultadoAvaliacaoFrequenciaAlimento(total));

    }

    private String resultadoAvaliacaoFrequenciaAlimento(int total) {
        String resultado;
        if (total >= 0 && total <= 2) {
            resultado = "Muito ruim";
        } else if (total == 3 || total == 4) {
            resultado = "Ruim";
        } else if (total == 5 || total == 6){
            resultado = "Bom";
        } else if(total == 7 || total == 8){
            resultado = "Muito Bom";
        }else if(total == 9 || total == 10){
            resultado = "Excelente";
        }else{
            resultado = "Não foi possível aferir";
        }


            return resultado;

    }


}
