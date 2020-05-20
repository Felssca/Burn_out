package br.com.asb.bean;

public class ListaTotalDadosPesquisa {

    public AnamineseProfissionalBean getAnamineseProfissionalBean() {
        return anamineseProfissionalBean;
    }

    public void setAnamineseProfissionalBean(AnamineseProfissionalBean anamineseProfissionalBean) {
        this.anamineseProfissionalBean = anamineseProfissionalBean;
    }

    public BurnOutBean getBurnOutBean() {
        return burnOutBean;
    }

    public void setBurnOutBean(BurnOutBean burnOutBean) {
        this.burnOutBean = burnOutBean;
    }

    public SonoPittsburghBeans getSonoPittsburghBeans() {
        return sonoPittsburghBeans;
    }

    public void setSonoPittsburghBeans(SonoPittsburghBeans sonoPittsburghBeans) {
        this.sonoPittsburghBeans = sonoPittsburghBeans;
    }

    public AlimentacaoBeans getAlimentacaoBeans() {
        return alimentacaoBeans;
    }

    public void setAlimentacaoBeans(AlimentacaoBeans alimentacaoBeans) {
        this.alimentacaoBeans = alimentacaoBeans;
    }

    private AnamineseProfissionalBean anamineseProfissionalBean;
    private BurnOutBean burnOutBean;
    private SonoPittsburghBeans sonoPittsburghBeans;
    private AlimentacaoBeans alimentacaoBeans;

}
