package br.com.asb.negocio;

import br.com.asb.bean.AnamineseProfissionalBean;
import br.com.asb.bean.ClassificacaoAtividadeFisicaBeans;

public class ClassificacaoAtividadeFisica {

    final int LEVE = 5;
    final int MEDIA = 6;
    final int ALTA = 7;
    final int MEDIA3X = 8;

    final int NAO_INFORMADO = 0;
    final int ADEQUADO = 1;
    final int INADEQUADO = 2;
    final int RISCO = 3;

    private ClassificacaoAtividadeFisicaBeans classificacaoAtividadeFisicaBeans;

    public ClassificacaoAtividadeFisicaBeans getClassificacaoAtividadeFisicaBeans() {
        return classificacaoAtividadeFisicaBeans;
    }

    public void setClassificacaoAtividadeFisicaBeans(ClassificacaoAtividadeFisicaBeans classificacaoAtividadeFisicaBeans) {
        this.classificacaoAtividadeFisicaBeans = classificacaoAtividadeFisicaBeans;
    }

    ClassificacaoAtividadeFisica() {

        classificacaoAtividadeFisicaBeans = new ClassificacaoAtividadeFisicaBeans();

    }

    /**
     * Todos estes marcados com x são considerados inúteis para a produção hormonal que proteja
     * do estresse, depressão e burnout. Por isso são considerados inadequados, ou seja, a pessoa
     * não faz atividade física suficiente.
     * <p>
     * Observando os padrões de tempo, se a pessoa faz menos
     * <p>
     * [X]tempo do que vinte minutos é também inadequado. Mais do que 1 hora está sujeito a lesão.
     * <p>
     * [x]Prática de atividade física só 1 vez por semana é considerada de alto risco de morte,
     * <p>
     * Atividade física de alta intensidade pode ser
     * [X]adequada a partir de 20 minutos
     *
     * @param anamineseProfissionalBean
     */

    public void classificarAtividadeFisica(AnamineseProfissionalBean anamineseProfissionalBean) {
        //1 -  adequado ,// 2  - inadequado e // 3 risco.// 0- não informado

        // intensidade 5 - fraca
        //intensidade 6 - media
        //intendidade 7 - forte


        int numResultado = 0;

        if (anamineseProfissionalBean.getPraticaAtividadeFisica() == true) {

            switch (anamineseProfissionalBean.getQtAtividadeVezesSemana()) {
                case (1): {

                    numResultado = 3;
                }
                case (2): {

                    numResultado = 3;
                }

                case (3): {
                    if (anamineseProfissionalBean.getIntensidadeLeve()) {
                        numResultado = 2;

                    } else if (anamineseProfissionalBean.getIntensidadeMedia()) {

                        int tempo = alterarDuracao(anamineseProfissionalBean.getDuracaoAtividade());
                        numResultado = resultadoAtividadeDuracao(tempo, isHoras(tempo), MEDIA);

                    } else if (anamineseProfissionalBean.getIntensidadeAlta()) {

                        int tempo = alterarDuracao(anamineseProfissionalBean.getDuracaoAtividade());
                        numResultado = resultadoAtividadeDuracao(tempo, isHoras(tempo), ALTA);

                    }

                }
                case (4): {

                    if (anamineseProfissionalBean.getIntensidadeLeve()) {
                        numResultado = 2;

                    } else if (anamineseProfissionalBean.getIntensidadeMedia()) {
                        int tempo = alterarDuracao(anamineseProfissionalBean.getDuracaoAtividade());
                        numResultado = resultadoAtividadeDuracao(tempo, isHoras(tempo), MEDIA);

                    } else if (anamineseProfissionalBean.getIntensidadeAlta()) {
                        int tempo = alterarDuracao(anamineseProfissionalBean.getDuracaoAtividade());
                        numResultado = resultadoAtividadeDuracao(tempo, isHoras(tempo), ALTA);
                    }
                }

                case (5): {

                    if (anamineseProfissionalBean.getIntensidadeLeve()) {
                        int tempo = alterarDuracao(anamineseProfissionalBean.getDuracaoAtividade());
                        numResultado = resultadoAtividadeDuracao(tempo, isHoras(tempo), LEVE);

                    } else if (anamineseProfissionalBean.getIntensidadeMedia()) {
                        int tempo = alterarDuracao(anamineseProfissionalBean.getDuracaoAtividade());
                        numResultado = resultadoAtividadeDuracao(tempo, isHoras(tempo), MEDIA);

                    } else if (anamineseProfissionalBean.getIntensidadeAlta()) {
                        int tempo = alterarDuracao(anamineseProfissionalBean.getDuracaoAtividade());
                        numResultado = resultadoAtividadeDuracao(tempo, isHoras(tempo), ALTA);
                    }
                }


                case (6): {

                    if (anamineseProfissionalBean.getIntensidadeLeve()) {
                        int tempo = alterarDuracao(anamineseProfissionalBean.getDuracaoAtividade());
                        numResultado = resultadoAtividadeDuracao(tempo, isHoras(tempo), LEVE);

                    } else if (anamineseProfissionalBean.getIntensidadeMedia()) {
                        int tempo = alterarDuracao(anamineseProfissionalBean.getDuracaoAtividade());
                        numResultado = resultadoAtividadeDuracao(tempo, isHoras(tempo), MEDIA);

                    } else if (anamineseProfissionalBean.getIntensidadeAlta()) {
                        int tempo = alterarDuracao(anamineseProfissionalBean.getDuracaoAtividade());
                        numResultado = resultadoAtividadeDuracao(tempo, isHoras(tempo), ALTA);
                    }

                }
                case (7): {

                    if (anamineseProfissionalBean.getIntensidadeLeve()) {
                        int tempo = alterarDuracao(anamineseProfissionalBean.getDuracaoAtividade());
                        numResultado = resultadoAtividadeDuracao(tempo, isHoras(tempo), LEVE);

                    } else if (anamineseProfissionalBean.getIntensidadeMedia()) {
                        int tempo = alterarDuracao(anamineseProfissionalBean.getDuracaoAtividade());
                        numResultado = resultadoAtividadeDuracao(tempo, isHoras(tempo), MEDIA);

                    } else if (anamineseProfissionalBean.getIntensidadeAlta()) {
                        int tempo = alterarDuracao(anamineseProfissionalBean.getDuracaoAtividade());
                        numResultado = resultadoAtividadeDuracao(tempo, isHoras(tempo), ALTA);
                    }
                }

                default: {
                    numResultado = NAO_INFORMADO;

                }

            }

        } else {

            numResultado = NAO_INFORMADO;

        }
        classificacaoAtividadeFisicaBeans.setNumResultado(numResultado);
        classificacaoAtividadeFisicaBeans.setTextResultado(textResultado(numResultado));

    }

    /**
     * Resolve regra de negocio atividade física
     *
     * @param tempo
     * @param isHora
     * @param intensidade
     * @return
     */
    private int resultadoAtividadeDuracao(int tempo, boolean isHora, int intensidade) {
        int resultDuracao = 0;

        //intnsidade fraca
        switch (intensidade) {
            case (LEVE): {

                if (isHoras(tempo) == true) {
                    if (tempo > 1) {
                        resultDuracao = INADEQUADO;
                    } else if (tempo == 1) {
                        resultDuracao = INADEQUADO;
                    } else {
                        resultDuracao = INADEQUADO;
                    }
                } else {
                    if (tempo < 30) {
                        resultDuracao = INADEQUADO;
                    } else if (tempo == 30) {
                        resultDuracao = ADEQUADO;
                    } else {
                        resultDuracao = INADEQUADO;
                    }

                }

            }
            case (MEDIA): {

                if (isHoras(tempo) == true) {
                    if (tempo > 1) {
                        resultDuracao = INADEQUADO;
                    } else if (tempo == 1) {
                        resultDuracao = ADEQUADO;
                    } else {
                        resultDuracao = INADEQUADO;
                    }
                } else {
                    if (tempo < 30 || tempo > 60) {
                        resultDuracao = INADEQUADO;
                    } else if (tempo == 30 || tempo == 60) {
                        resultDuracao = ADEQUADO;
                    } else {
                        resultDuracao = INADEQUADO;
                    }

                }
            }
            case (MEDIA3X): {

                if (isHoras(tempo) == true) {
                    if (tempo > 1) {
                        resultDuracao = INADEQUADO;
                    } else if (tempo == 1) {
                        resultDuracao = ADEQUADO;
                    } else {
                        resultDuracao = INADEQUADO;
                    }
                } else {
                    if (tempo < 60 || tempo > 60) {
                        resultDuracao = INADEQUADO;
                    } else if (tempo == 60) {
                        resultDuracao = ADEQUADO;
                    } else {
                        resultDuracao = INADEQUADO;
                    }

                }
            }
            case (ALTA): {
                if (isHoras(tempo) == true) {
                    if (tempo > 1) {
                        resultDuracao = INADEQUADO;
                    } else if (tempo == 1) {
                        resultDuracao = ADEQUADO;
                    } else {
                        resultDuracao = INADEQUADO;
                    }
                } else {
                    if (tempo < 20 || tempo > 60) {
                        resultDuracao = INADEQUADO;
                    } else if (tempo == 20 || tempo == 60) {
                        resultDuracao = ADEQUADO;
                    } else {
                        resultDuracao = INADEQUADO;
                    }

                }

            }


        }


        return resultDuracao;
    }

    /**
     * resultado expresso
     *
     * @param total
     * @return
     */
    private String textResultado(int total) {

        String resultado = "";
        if (total == ADEQUADO) {
            resultado = "ADEQUADO";

        } else if (total == INADEQUADO) {
            resultado = "INADEQUADO";

        } else if (total == RISCO) {
            resultado = "RISCO";

        } else {
            resultado = "NÃO INFORMADO";
        }

        return resultado;
    }

    /**
     * verifica se é  o tempo é minuto ou hora
     *
     * @param tempo
     * @return
     */
    private boolean isHoras(int tempo) {
        boolean isHora = false;

        if (tempo == 1) {
            isHora = true;

        } else if (tempo >= 20 && tempo <= 120) {
            isHora = false;

        } else if (tempo > 120 && tempo <= 200) {

            isHora = true;
        }


        return isHora;
    }


    /**
     * Transforma texto para numero
     *
     * @param duracao
     * @return
     */
    private int alterarDuracao(String duracao) {

        int numDuracao = 0;
        int minutos = 0;
        int horas = 0;
        String parcial = null;
//h, : mim mi
        int size = duracao.length();

        if (size == 1) {

            char[] chars = duracao.toCharArray();
            if (!Character.isDigit(chars[1])) {
                numDuracao = 0;

            } else {

                numDuracao = chars[1];
            }

        } else if (size > 1) {


            for (int x = 0; x < duracao.length(); x++) {

                if (duracao.charAt(x) == 'n') {
                    parcial += duracao.replace("n", "");
                }
                if (duracao.charAt(x) == 'm') {
                    parcial += duracao.replace("m", "");
                }
                if (duracao.charAt(x) == 'h') {
                    parcial += duracao.replace("h", "");
                }
                if (duracao.charAt(x) == ':') {
                    parcial += duracao.replace(":", "");
                }
                if (duracao.charAt(x) == 'i') {
                    parcial += duracao.replace("i", "");
                }


            }

            numDuracao = Integer.parseInt(parcial);


        }
        return numDuracao;

    }
}