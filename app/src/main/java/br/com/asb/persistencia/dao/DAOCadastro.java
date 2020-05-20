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
import br.com.asb.persistencia.bd.DbASB;



public class DAOCadastro  implements ControlerBD  {

    private static final DAOCadastro ourInstance = new DAOCadastro();


    public static DAOCadastro getInstance() {
        return ourInstance;
    }

    private DAOCadastro() {

    }

    @Override
    public ArrayList<DiarioClasseBean> listarClasses() {

        ArrayList<DiarioClasseBean> diarioClasseBeans = new ArrayList<>();

        try {

            DbASB dbASB = new DbASB(App.getAppContext());
            dbASB.getWritableDatabase();
            diarioClasseBeans = dbASB.listarProfissionaisEntrevistados();

        }catch(SQLiteException e){

            Log.e("ERROR_BD",e.getMessage().toString());
        }

        return diarioClasseBeans;
    }

    @Override
    public ArrayList<DiarioClasseBean> listarClassesByID(int id) {

        ArrayList<DiarioClasseBean> diarioClasseBeans = new ArrayList<>();

        try {

            DbASB dbASB = new DbASB(App.getAppContext());
            dbASB.getWritableDatabase();
            diarioClasseBeans = dbASB.listarClassesByID(id);

        }catch(SQLiteException e){

            Log.e("ERROR_BD",e.getMessage().toString());
        }

        return diarioClasseBeans;
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
    public ArrayList<DiarioClasseBean> listarAlunosClassesByID(int id) {

        ArrayList<DiarioClasseBean> diarioClasseBeans = new ArrayList<>();
        try {

            DbASB dbASB = new DbASB(App.getAppContext());
            dbASB.getWritableDatabase();
            diarioClasseBeans = dbASB.listarAlunosIDClasse(id);

        }catch(SQLiteException e){

            Log.e("ERROR_BD",e.getMessage().toString());
        }

        return diarioClasseBeans;



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
}
