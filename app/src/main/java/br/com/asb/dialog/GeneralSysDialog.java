package br.com.asb.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.asb.R;

public class GeneralSysDialog {


    private GeneralSystemDialogListener aboutGeneralSystemDialogListener;
    private final Activity mContext;
    //  private final Fragment fContext;
    private TextView customTextViewTitulo;
    private TextView customTextViewCorpo;
    private ImageView customIcone;
    private Button customButton;
    // private Button customButtonCancel;
    private int ACAO_BOTAO = 0;



    private void initViews() {


        AlertDialog.Builder mBuilder = new AlertDialog.Builder(mContext);
        View mView = LayoutInflater.from(mContext).inflate(R.layout.dialog_general_system_list, null);


        /**
         * Recebe os componentes para customiza os parametros de todos os Dialogs
         */

        customButton = mView.findViewById(R.id.btn_voltar_dialog);
        //customButtonCancel = mView.findViewById(R.id.btn_dialog_cancellation_confirm);
        customTextViewTitulo = mView.findViewById(R.id.titulo_mensagem_dialog);
        customTextViewCorpo = mView.findViewById(R.id.corpo_mensagem_dialog);
        customIcone = mView.findViewById(R.id.icone_dialog);


        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();

        /**
         * Configura açao do botao neutro
         */
        buttonActionNeutro(dialog);

        /**
         * Configura açao do botao neutro
         */
     //   buttonActionNeutro(dialog);
        /**
         * Configura açao do botao cancelar
         */
        //      buttonActionCancelar(dialog);

        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        DisplayMetrics displayMetrics = new DisplayMetrics();

        mContext.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        // The absolute width of the available display size in pixels.
        int displayWidth = displayMetrics.widthPixels;
        // The absolute height of the available display size in pixels.
        int displayHeight = displayMetrics.heightPixels;

        // Initialize a new window manager layout parameters
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();

        // Copy the alert dialog window attributes to new layout parameter instance
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        // Set alert dialog width equal to screen width 70%
        int dialogWindowWidth = (int) (displayWidth * 0.7f);
        // Set alert dialog height equal to screen height 70%
        int dialogWindowHeight = (int) (displayHeight * 0.7f);

        // Set the width and height for the layout parameters
        // This will bet the width and height of alert dialog
        layoutParams.width = dialogWindowWidth;
        layoutParams.height = dialogWindowHeight;

        // Apply the newly created layout parameters to the alert dialog window
        dialog.getWindow().setAttributes(layoutParams);


    }


    public GeneralSysDialog(Activity mContext) {
        this.mContext = mContext;
        initViews();
    }



    /**
     * @Utilizado para maioria dos casos
     */
    public void setDialog(Integer titulo, Integer corpo, int icone) {


        customTextViewTitulo.setText(titulo);
        customTextViewCorpo.setText(corpo);
        setIcons(icone);

    }
    /**
     * @Utilizado para usar livremente em mensagens String
     */

    public void setDialog(String titulo, String corpo, int icone) {


        customTextViewTitulo.setText(titulo);
        customTextViewCorpo.setText(corpo);
        setIcons(icone);

    }

    public interface GeneralSystemDialogListener{
        void onDoneClick();

    }

    /**
     * Açao dos butões

    private void buttonActionNeutro(final AlertDialog dialog) {

        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //FAZ O BoTAO SER EXTENDIDO E UTILIZADO
                //opção 1 botão altera propriedades dos botoes e do dialogo em si
                if (ACAO_BOTAO == 1) {

                    aboutGeneralSystemDialogListener.onDoneClick();


                }
                if (ACAO_BOTAO == 2) {
                    aboutGeneralSystemDialogListener.onDoneClick();

                }

                dialog.dismiss();
            }
        });

    } */

    /**
     * Customizar o restante do painel
     *
     * @param iconeConfig
     */
    private void setIcons(Integer iconeConfig) {

        switch (iconeConfig) {
            //Caso de ERRRO    com as demais configurações e mudança nos butoes
            case 1:
                customIcone.setImageResource(R.drawable.ic_dialog_x);
                customButton.setBackgroundColor(Color.rgb(155, 155, 155));
                break;
            //Caso Mais comum de CONFIRMACAO
            case 2:
                customIcone.setImageResource(R.drawable.ic_dialog_ok);
                break;
            //Caso de campos OBRIGATORIOS
            case 3:
                customIcone.setImageResource(R.drawable.ic_dialog_requerido);
                break;


            //Casos de CANCELAMENTO
            case 4:
                customIcone.setImageResource(R.drawable.ic_atention);
                break;


        }


    }


    public GeneralSystemDialogListener getAboutGeneralSystemDialogListener() {
        return aboutGeneralSystemDialogListener;
    }

    public void setAboutGeneralSystemDialogListener(GeneralSystemDialogListener aboutGeneralSystemDialogListener) {
        this.aboutGeneralSystemDialogListener = aboutGeneralSystemDialogListener;
    }


    /**
     * Açao dos butões
     */
    private void buttonActionNeutro(final AlertDialog dialog) {

        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //FAZ O BoTAO SER EXTENDIDO E UTILIZADO
                //opção 1 botão altera propriedades dos botoes e do dialogo em si
                if (ACAO_BOTAO == 1){

                    aboutGeneralSystemDialogListener.onDoneClick();


                }if(ACAO_BOTAO == 2 ){
                    aboutGeneralSystemDialogListener.onDoneClick();

                }

                dialog.dismiss();
            }
        });


    }}
