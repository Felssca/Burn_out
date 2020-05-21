package br.com.asb.bean

class ClassificacaoBurnOutBeans {

    var idBurnOut: Int = 0
    var FkProfissional: Int = 0

    var somatorioIlusao:Int = 0
    var classificacaoIlusaoTrabalho:String = ""

    var somatorioDesgastePsiquico:Int = 0
    var classificacaoDesgastePsiquico:Int = 0

    var somatorioIndolencia:Int = 0
    var classificacaoIndolencia:Int = 0

    var desgastePsiquicoIndolenciaTotal:Int = 0
    var classificacaoDesgastePsiquicoIndolencia:String =""

    var somatorioCulpa: Int =0;
    var classificacaoCulpa: String =""

    //percentual
    var percentualIlusao : Int = 0;
    var percentuaDesgasteIndolencia : Int = 0;
    var percentuaCulpa   : Int = 0;

    //classificacaoBurnOUt
    var classifcacaoNivelIlusao: String = ""
    var classifcacaoNivelPsiquicoIndolencia: String = ""




}