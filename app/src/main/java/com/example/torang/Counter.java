package com.example.torang;

public class Counter {

    public Double getNilai(String angkaAwal, String tebakan){
        Double nilai=0.0;

        String[] arrayAngka;
        String[] arrayTebakan;

        arrayAngka=angkaAwal.split("");
        arrayTebakan=tebakan.split("");

        System.out.println("panjang :"+arrayAngka.length+" "+arrayTebakan.length);

        Double nilaiDepan=0.0;
        Double nilaiBelakang=0.0;

        for(int i=0; i<arrayAngka.length; i++){

            for(int j=0; j<arrayTebakan.length; j++){
                System.out.println("isi nilai: "+arrayTebakan[j]);
                if((arrayAngka[i].equals(arrayTebakan[j]))&&(!arrayAngka[i].equals(""))&&(!arrayTebakan[j].equals(""))) {
                    nilaiDepan++;
                    if(i==j) {
                        nilaiBelakang++;
                    }
                    System.out.println("depan : "+nilaiDepan+"  belakang: "+nilaiBelakang+" index awal:"+i+" index tebak:"+j);
                }


            }

        }

        nilai=nilaiDepan+(nilaiBelakang/10);
        System.out.println("NILAI : "+nilai);
        return nilai;
    }

    public boolean checkUnique(String tebakan){

        String[] arrayTebakan;

        arrayTebakan=tebakan.split("");

        for(int i=0; i<arrayTebakan.length; i++){

            for(int j=i+1; j<arrayTebakan.length; j++){

                if((arrayTebakan[i].equals(arrayTebakan[j]))&&(!arrayTebakan[i].equals(""))&&(!arrayTebakan[j].equals(""))) {
                   return true;
                    }

                }


            }

        return false;
    }





}
