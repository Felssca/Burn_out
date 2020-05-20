package br.com.asb.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilDate {


    public String converterMesNum(int num) {

        String mes = null;


        switch (num) {

            case 0:
                mes = "Janeiro";
                break;
            case 1:
                mes = "Fevereiro";
                break;
            case 2:
                mes = "Março";
                break;
            case 3:
                mes = "Abril";
                break;
            case 4:
                mes = "Maio";
                break;
            case 5:
                mes = "Junho ";
                break;
            case 6:
                mes = "Julho ";
                break;
            case 7:
                mes = "Agosto ";
                break;
            case 8:
                mes = "Setembro ";
                break;
            case 9:
                mes = "Outubro ";
                break;
            case 10:
                mes = "Novembro ";
                break;
            case 11:
                mes = "Desembro ";
                break;


        }

        return mes;
    }


    public String dataAtual(){
        String dataAtual = null;
        Date date = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        dataAtual = df.format(date);

        return dataAtual;
    }

    public String gerarNumeroAliatorio(){
        String numero=" ";
        double i = Math.random();
        numero = Double.toString(i).substring(2,6);
        return numero;
    }
}

