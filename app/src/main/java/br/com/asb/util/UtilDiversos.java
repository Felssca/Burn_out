package br.com.asb.util;

public class UtilDiversos {




    public String unmask(String mask){

        String unmaskRetun = null;

        if(mask.contains("-")){

            unmaskRetun = mask.replace("-","").toString();

        }


        return unmaskRetun;


    } public int unmaskHoras(String mask){

        int unmaskRetun = 0;

        if(mask.contains(":")){

            try {
                String maskNum= mask.replace(":","");
                unmaskRetun = Integer.parseInt(maskNum);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }


        }


        return unmaskRetun;


    }


    public Boolean converterDadosBd(int bd){
        Boolean retorno = false;

        if(bd == 1){
            retorno = true;

        }else{
            retorno = false;

        }

        return retorno;


    }

}
