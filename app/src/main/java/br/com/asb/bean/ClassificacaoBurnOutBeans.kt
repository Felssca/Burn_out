package br.com.asb.bean

class ClassificacaoBurnOutBeans {

    var idBurnOut: Int = 0
    var FkProfissional: Int = 0

    //ILUSAO
    var somatorioIlusao:Int = 0
    var classificacaoIlusaoTrabalho:String = ""
    var percentualParcialIlusao : Int = 0;
    var classificacaoNivelIlusao: String = ""

    //DESGASTE
    var somatorioDesgastePsiquico:Int = 0;
    var classificacaoDesgastePsiquico:String=""
    var percentualParcialDesgastePsiquico:Int =0;
    var classificacaoResultadoDesgastePsiquico:Int = 0

    //INDOLENCIA
    var somatorioIndolencia:Int = 0
    var classificacaoIndolencia:String=""
    var percentualParcialIndolencia:Int = 0;
    //var classificacaoResultadoIndolencia:Int =0;

    //INDOLENCIA + DESGASTE
    var desgastePsiquicoIndolenciaTotal:Int = 0
    var classificacaoDesgastePsiquicoIndolencia:String =""
    var percentuaDesgasteIndolencia : Int = 0;

    //CULPA
    var somatorioCulpa: Int =0;
    var classificacaoCulpa: String =""
    var percentualFinalCulpa   : Int = 0;

    //CLASSIFICACAO BURNOUT:
    var classifcacaoNivelPsiquicoIndolencia: String = ""
    var somatoriaPercentualTotalBurnOUT: Int =0;
    var classificacaoSomatorioTotalBurnOUT: String=""





}