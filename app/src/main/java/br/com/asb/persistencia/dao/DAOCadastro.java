package br.com.asb.persistencia.dao;

import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;

import br.com.asb.app.App;
import br.com.asb.bean.AlimentacaoBeans;
import br.com.asb.bean.AnamineseProfissionalBean;
import br.com.asb.bean.BurnOutBean;
import br.com.asb.bean.DiarioClasseBean;
import br.com.asb.bean.ListaTotalDadosPesquisa;
import br.com.asb.bean.SonoPittsburghBeans;
import br.com.asb.controller.ControlerBD;
import br.com.asb.negocio.ClassificacaoAlimentacao;
import br.com.asb.negocio.ClassificacaoAtividadeFisica;
import br.com.asb.negocio.ClassificacaoBurnOut;
import br.com.asb.negocio.ClassificacaoSonoPittsburgh;
import br.com.asb.persistencia.bd.DbASB;



public class DAOCadastro  implements ControlerBD  {

    private static final DAOCadastro ourInstance = new DAOCadastro();


    public static DAOCadastro getInstance() {
        return ourInstance;
    }

    private DAOCadastro() {

    }


    @Override
    public ArrayList<AnamineseProfissionalBean> listarTodosProfissionaisCadastrados() {

        ArrayList<AnamineseProfissionalBean> listaTodosProfissionais = new ArrayList<>();
        try {

            DbASB dbASB = new DbASB(App.getAppContext());
            dbASB.getWritableDatabase();
            listaTodosProfissionais = dbASB.listarTodosProfissionaisCadastrados();

        }catch(SQLiteException e){

            Log.e("ERROR_BD",e.getMessage().toString());
        }

        return listaTodosProfissionais;

    }

    @Override
    public long cadastarProfissionalPesquisa(AnamineseProfissionalBean anamineseProfissionalBean,
                                             BurnOutBean burnOutBean, SonoPittsburghBeans sonoPittsburghBeans, AlimentacaoBeans alimentacaoBeans) {

        long retorno = 0;

        try {

            DbASB dbASB = new DbASB(App.getAppContext());
            dbASB.getWritableDatabase();
            retorno = dbASB.inserirCadastroAnamineseProfissional(anamineseProfissionalBean,burnOutBean,sonoPittsburghBeans,alimentacaoBeans);

        }catch(SQLiteException e){

            Log.e("ERROR_BD",e.getMessage().toString());

        }finally {

        }

        return retorno;
    }

    @Override
    public ListaTotalDadosPesquisa listarDadosProfissionalPorId(Integer id,Integer tabela) {

        ListaTotalDadosPesquisa listaTotalDadosPesquisas =  new ListaTotalDadosPesquisa();
        try {

            DbASB dbASB = new DbASB(App.getAppContext());
            dbASB.getWritableDatabase();
            listaTotalDadosPesquisas = dbASB.listarDadosProfissionalPorId(id,tabela);

        }catch(SQLiteException e){

            Log.e("ERROR_BD",e.getMessage().toString());

            }finally {

        }


        return listaTotalDadosPesquisas;
    }

    @Override
    public long inserirResultadosBurnOut(Integer id,ClassificacaoBurnOut classificacaoBurnOut) {

        long retorno = 0;

        try{
            DbASB dbASB = new DbASB(App.getAppContext());
            dbASB.getWritableDatabase();
            retorno = dbASB.inserirResultadosBurnOut(id,classificacaoBurnOut);

        }catch(SQLiteException ex){

            Log.e("ERROR_BD",ex.getMessage().toString());

        }


        return 0;
    }

    @Override
    public long inserirResultadosSonoPittsburg(Integer id, ClassificacaoSonoPittsburgh classificacaoSonoPittsburgh) {

        long retorno = 0;

        try{
            DbASB dbASB = new DbASB(App.getAppContext());
            dbASB.getWritableDatabase();
            retorno = dbASB.inserirResultadosSonoPittsburg(id,classificacaoSonoPittsburgh);

        }catch(SQLiteException ex){

            Log.e("ERROR_BD",ex.getMessage().toString());

        }

        return 0;
    }

    @Override
    public long inserirResultadosAlimentacao(Integer id, ClassificacaoAlimentacao classificacaoAlimentacao) {
        long retorno = 0;

        try{
            DbASB dbASB = new DbASB(App.getAppContext());
            dbASB.getWritableDatabase();
            retorno = dbASB.inserirResultadoAlimentacao(id,classificacaoAlimentacao);

        }catch(SQLiteException ex){

            Log.e("ERROR_BD",ex.getMessage().toString());

        }

        return 0;
    }

    @Override
    public long inserirResultadosAtividadeFisica(Integer id, ClassificacaoAtividadeFisica classificacaoAtividadeFisica) {
        long retorno = 0;

        try{
            DbASB dbASB = new DbASB(App.getAppContext());
            dbASB.getWritableDatabase();
            retorno = dbASB.inserirResultadoAtividadeFisica(id,classificacaoAtividadeFisica);

        }catch(SQLiteException ex){

            Log.e("ERROR_BD",ex.getMessage().toString());

        }

        return 0;
    }
}
