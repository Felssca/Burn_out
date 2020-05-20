package br.com.asb.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.asb.R;
import br.com.asb.bean.AnamineseProfissionalBean;
import br.com.asb.holders.LineHolder;
import br.com.asb.persistencia.dao.DAOCadastro;

public class ListarProfissionaisEntrevistadosActivity extends AppCompatActivity {

    public ImageView imageDadosCompletos;
    private TextView totalCadasatrado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listar_profissionais_entrevistados);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_lista_escolas);
        imageDadosCompletos       = (ImageView)    findViewById(R.id.item_pesquisa_completa);
        totalCadasatrado          = (TextView) findViewById(R.id.txt_total_profissionais_entrevistados);



        ArrayList<AnamineseProfissionalBean> listaProfissionais = retornoListaProfissionais();
        recyclerView.setAdapter(new ListaProfissionaisAdapter(listaProfissionais, this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);
    }

    private ArrayList<AnamineseProfissionalBean> retornoListaProfissionais() {

        ArrayList<AnamineseProfissionalBean> listaEntrevistados = new ArrayList<>();
        listaEntrevistados = DAOCadastro.getInstance().listarTodosProfissionaisCadastrados();
        totalCadasatrado.setText("Total de Entrevistados :"+ Integer.toString(listaEntrevistados.size()));
        return listaEntrevistados;

    }





    public void visualizarPesquisaCompleta(Integer id) {

       startActivity(new Intent(ListarProfissionaisEntrevistadosActivity.this, TelaCadastroInicialRespostaActivity.class)
               .putExtra("ID",id));


    }


    public class ListaProfissionaisAdapter extends RecyclerView.Adapter {

        private ArrayList<AnamineseProfissionalBean> listaProfissionais;
        private Context context;

        public ListaProfissionaisAdapter(ArrayList<AnamineseProfissionalBean> listaEntrevistados , Context context) {

            this.listaProfissionais = listaEntrevistados;
            this.context = context;

        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.holder_list_view, parent, false);
            LineHolder lineHolder = new LineHolder(view);
            return lineHolder;

        }

        @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            LineHolder lineHolder = (LineHolder) holder;

           final AnamineseProfissionalBean anamineseProfissionalBean = listaProfissionais.get(position);

            ((LineHolder) holder).id.setText(Integer.toString(anamineseProfissionalBean.getIdProfissional()));
            ((LineHolder) holder).profissional.setText(anamineseProfissionalBean.getNomeProfissional());
            ((LineHolder) holder).telefone.setText(anamineseProfissionalBean.getTelefone());
            ((LineHolder) holder).email.setText(anamineseProfissionalBean.getEmail());
            ((LineHolder) holder).sexo.setText(anamineseProfissionalBean.getSexo());
            ((LineHolder) holder).idade.setText(anamineseProfissionalBean.getIdade());
            ((LineHolder) holder).dtEntrevista.setText(anamineseProfissionalBean.getDtEntrevista());
            ((LineHolder) holder).cde.setText(Integer.toString(anamineseProfissionalBean.getCDE()));


            ((LineHolder) holder).mostrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        visualizarPesquisaCompleta((anamineseProfissionalBean.getIdProfissional()));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });









         //   ((LineHolder) holder).ano.setText(profissionaisEntrevistadoBean.getAnoLetivo());
          //  ((LineHolder) holder).qtAlunos.setText(Integer.toString(profissionaisEntrevistadoBean.getAlunoMatricula().size()));
       //     ((LineHolder) holder).id.setText(Integer.toString(profissionaisEntrevistadoBean.getId()));
      //      ((LineHolder) holder).setText(Integer.toString(profissionaisEntrevistadoBean.getId()));



         //   ((LineHolder) holder).listaMedidasAlunos.setOnClickListener(new View.OnClickListener() {
           //     @Override
             //   public void onClick(View v) {

           //         sendTabelaDiarioClasse(id);

               //     }



            //              });


        }

        @Override
        public int getItemCount() {
            return listaProfissionais.size();
        }
    }


}










