package br.com.asb.controller;

import java.util.ArrayList;

import br.com.asb.bean.AlimentacaoBeans;
import br.com.asb.bean.AnamineseProfissionalBean;
import br.com.asb.bean.BurnOutBean;
import br.com.asb.bean.DiarioClasseBean;
import br.com.asb.bean.ListaTotalDadosPesquisa;
import br.com.asb.bean.SonoPittsburghBeans;
import br.com.asb.negocio.ClassificacaoAlimentacao;
import br.com.asb.negocio.ClassificacaoBurnOut;
import br.com.asb.negocio.ClassificacaoSonoPittsburgh;

public interface ControlerBD {



     public  ArrayList<AnamineseProfissionalBean> listarTodosProfissionaisCadastrados();
     public long cadastarProfissionalPesquisa(AnamineseProfissionalBean anamineseProfissionalBean, BurnOutBean burnOutBean,
                                              SonoPittsburghBeans sonoPittsburghBeans, AlimentacaoBeans alimentacaoBeans);
     public ListaTotalDadosPesquisa listarDadosProfissionalPorId(Integer id,Integer tabela);

     public long inserirResultadosBurnOut(Integer id,ClassificacaoBurnOut classificacaoBurnOut);
     public long inserirResultadosSonoPittsburg(Integer id, ClassificacaoSonoPittsburgh classificacaoSonoPittsburgh);
     public long inserirResultadosAlimentacao(Integer id, ClassificacaoAlimentacao classificacaoAlimentacao);















}
