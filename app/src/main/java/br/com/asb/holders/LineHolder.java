package br.com.asb.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.asb.R;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView id;
    public TextView profissional;
    public TextView telefone;
    public TextView email;
    public TextView dtEntrevista;
    public TextView cde;
    public TextView sexo;
    public TextView idade;
    public Button mostrar;

    public ImageView listaMedidasAlunos;






    public LineHolder(View itemView) {
        super(itemView);

        id = (TextView) itemView.findViewById(R.id.txt_item_id);
        profissional = (TextView) itemView.findViewById(R.id.txt_item_profissional);
        telefone = (TextView) itemView.findViewById(R.id.txt_item_telefone);
        email = (TextView) itemView.findViewById(R.id.txt_item_email);
        dtEntrevista = (TextView) itemView.findViewById(R.id.txt_item_data_entrevista);
        cde = (TextView) itemView.findViewById(R.id.txt_item_cde);
        sexo = (TextView) itemView.findViewById(R.id.txt_item_sexo);
        idade = (TextView) itemView.findViewById(R.id.txt_item_idade);

        listaMedidasAlunos  =  (ImageView) itemView.findViewById(R.id.item_pesquisa_completa);
        mostrar = (Button) itemView.findViewById(R.id.btn_visulizar_dados_completos);




    }
}
