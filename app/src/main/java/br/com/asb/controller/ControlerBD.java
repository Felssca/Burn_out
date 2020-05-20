package br.com.asb.controller;

import java.util.ArrayList;

import br.com.asb.bean.AlimentacaoBeans;
import br.com.asb.bean.AnamineseProfissionalBean;
import br.com.asb.bean.BurnOutBean;
import br.com.asb.bean.DiarioClasseBean;
import br.com.asb.bean.ListaTotalDadosPesquisa;
import br.com.asb.bean.SonoPittsburghBeans;

public interface ControlerBD {



     public  ArrayList<AnamineseProfissionalBean> listarTodosProfissionaisCadastrados();
     public long cadastarProfissionalPesquisa(AnamineseProfissionalBean anamineseProfissionalBean, BurnOutBean burnOutBean,
                                              SonoPittsburghBeans sonoPittsburghBeans, AlimentacaoBeans alimentacaoBeans);
     public ListaTotalDadosPesquisa listarDadosProfissionalPorId(Integer id,Integer tabela);




     //public ArrayList<>



     public  ArrayList<DiarioClasseBean> listarClasses();
     public ArrayList<DiarioClasseBean> listarClassesByID(int id);
     public ArrayList<DiarioClasseBean> listarAlunosClassesByID(int id);

















}
