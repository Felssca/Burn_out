package br.com.asb.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import br.com.asb.R;
import br.com.asb.dialog.GeneralSysDialog;
import br.com.asb.util.UtilDate;

import static android.support.v4.content.FileProvider.getUriForFile;

public class BackupSQLActivity extends Activity {



    TextView nomeBakup;
    Button btnBackup;
    Button btnCompartilhar;
    final String caminhoBancoIn = "/data/data/com.aplication.asb.asb/databases/ASB.db";
    GeneralSysDialog generalSysDialog;
    String nomeArquivoBackup = "";
    String arquivoBackupType = "";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_backup);
        intiView();
        acaoButton();


    }


    void intiView(){

        nomeBakup = (TextView) findViewById(R.id.txt_nome_ultimo_backup);
        btnBackup = (Button) findViewById(R.id.btn_novo_backup);
        btnCompartilhar = (Button) findViewById(R.id.btn_compartilhar_backup);

        PermissoesActivity.verifyStoragePermissions(this);

        try {
            if(criarPastaDadosSQLiteBakcup()){
                backupBaseDados();
            }else{


            }


        }catch(Exception ex){
            ex.printStackTrace();
        }

    }


    private void acaoButton() {



        btnBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    backupBaseDados();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        btnCompartilhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                   compartilharBancoDados();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });




    }


    private boolean criarPastaDadosSQLiteBakcup(){

        PermissoesActivity.verifyStoragePermissions(this);
        boolean success = false;
        try {
            File folder = new File(Environment.getExternalStorageDirectory() +
                    File.separator + "ASB");
            success = true;
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {
                // Do something on success
            } else {
                generalSysDialog = new GeneralSysDialog(BackupSQLActivity.this);
                generalSysDialog.setDialog(R.string.dialog_corpo_backup_sql_erro_01,R.string.dialog_corpo_backup_sql_erro_01,1);
            }
        } catch (Exception e) {
            generalSysDialog = new GeneralSysDialog(BackupSQLActivity.this);
            generalSysDialog.setDialog(e.getMessage(),e.getCause().toString(),1);
        } finally {

        }

        return success;

    }

    /*
    Persiste os dados no celular "Efetua o Backup da base de dados"
     */

    private void backupBaseDados()throws IOException{

        OutputStream output = null;
        FileInputStream fis = null;
        UtilDate utilDate = new UtilDate();
        PermissoesActivity.verifyStoragePermissions(this);

        try {

            File dbFile = new File(caminhoBancoIn);
            fis = new FileInputStream(dbFile);

            String numeroAliatorio = utilDate.gerarNumeroAliatorio();
            nomeArquivoBackup = "ASB_copy_"+utilDate.dataAtual()+"-"+numeroAliatorio+".db";

            String outFileName = Environment.getExternalStorageDirectory() +"/ASB/"+nomeArquivoBackup;

            // Open the empty db as the output stream
            output = new FileOutputStream(outFileName);
            nomeBakup.setText(outFileName);

            // Transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            generalSysDialog = new GeneralSysDialog(BackupSQLActivity.this);
            generalSysDialog.setDialog(R.string.dialog_titulo_backup_sql,R.string.dialog_corpo_backup_sql,2);


        }catch(IOException ex){
            ex.printStackTrace();
            generalSysDialog = new GeneralSysDialog(BackupSQLActivity.this);
            generalSysDialog.setDialog(ex.getMessage(),ex.getCause().toString(),1);

        }finally {
            output.flush();
            output.close();
            fis.close();

        }




    }

       /*
    Preparar arquivo
     */

    private void compartilharBancoDados()throws IOException{

        PermissoesActivity.verifyStoragePermissions(this);
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        File bancoBkp;



        try {
            String arquivo = nomeBakup.getText().toString();
            bancoBkp = new File(Environment.getExternalStorageDirectory()+"/ASB/",nomeArquivoBackup);
            compartilharBancoDadosShare(bancoBkp);

/*
            fileInputStream = openFileInput(bancoBkp.toString());
            int size = fileInputStream.available();
            byte[]buffer = new byte[size];
            fileInputStream.read(buffer);
            bancoBkp = new File(fileInputStream.toString());

*/
        }catch(Exception ex){
            ex.printStackTrace();
            generalSysDialog = new GeneralSysDialog(BackupSQLActivity.this);
            generalSysDialog.setDialog(ex.getMessage(),ex.getCause().toString(),1);

        }finally {

            inputStream.close();
            fileOutputStream.close();
        }


    }

        /*
    Compartilhar o arquivo
     */

    private void compartilharBancoDadosShare(File file)throws IOException{

        PermissoesActivity.verifyStoragePermissions(this);


        try {

            Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
            shareIntent.setAction(Intent.ACTION_SEND);
            Uri fileUri = getUriForFile(getApplicationContext(),"br.com.asb",file);
            shareIntent.putExtra (Intent.EXTRA_STREAM, fileUri);
            shareIntent.setType("application/vnd.sqlite3");
            startActivity(shareIntent);


        }catch( Exception ex){
            ex.printStackTrace();
            generalSysDialog = new GeneralSysDialog(BackupSQLActivity.this);
            generalSysDialog.setDialog(ex.toString(),ex.getCause().toString(),1);

        }

    }





}
