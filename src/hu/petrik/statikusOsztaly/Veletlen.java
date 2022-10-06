package hu.petrik.statikusOsztaly;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public final class Veletlen {
    private Veletlen(){}

    private static final Random rnd = new Random();

    private static final List<String> vezNevek = feltolt("files/veznev.txt");
    private static final List<String> ferfiKerNevek = feltolt("files/ferfikernev.txt");
    private static final List<String> noiKerNevek = feltolt("files/noikernev.txt");

    private static  final List<String> sportagak = feltolt("files/sportag.txt");

    private static  final List<String> egyesuletek = feltolt("files/egyesulet.txt");


    private static List<String> feltolt(String fajlnev) {
        List<String> lista = new ArrayList<>();

        try{
            Scanner file = new Scanner(new File(fajlnev));

            while(file.hasNext()){
                String sor = file.nextLine();
                lista.add(sor);
            }
            file.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return lista;
    }

    public static int velEgesz(int min, int max){
        return rnd.nextInt(max - min + 1) + min;
    }

    public static char velKarakter(char min, char max){
        return (char) velEgesz(min,max);
    }

    public static String velVezetekNev(){
        return vezNevek.get(rnd.nextInt(vezNevek.size()));
    }

    /**
     * Véletlen magyar keresztnév generálása
     * @param nem A generált név neme Férfi true, Nő false
     * @return A generált keresztnév
     */

    public static String velKeresztNev(boolean nem){
        String keresztNev = null;
        if(nem){
            keresztNev = velFerfiKeresztNev();
        }else{
            keresztNev = velNoiKeresztNev();
        }
        return keresztNev;
    }

    private static String velFerfiKeresztNev(){
        return ferfiKerNevek.get(rnd.nextInt(ferfiKerNevek.size()));
    }

    private static String velNoiKeresztNev(){
        return noiKerNevek.get(rnd.nextInt(noiKerNevek.size()));
    }

    public static String velTeljesNev(boolean nem){
        return velVezetekNev()+ " " + velKeresztNev(nem);
    }

    public static String velDatum(int ev1, int ev2){
        int day = velEgesz(1,28);
        int month = velEgesz(1,12);
        int year = 0;
        if(ev1 < ev2){
            year = velEgesz(ev1,ev2);
        }else{
            year = velEgesz(ev2,ev1);
        }
        return String.format("%d.%d.%d",year,month,day);
    }

    public static String velEmail(String nev){
        int szam = rnd.nextInt(100);
        String egybeNev = nev.replace(" ", "");
        String email =  egybeNev.toLowerCase(Locale.ROOT) + szam + "@gmail.com";
        email = Normalizer.normalize(email, Normalizer.Form.NFD);
        email = email.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return email;
    }

    public static String velMobil(){
        int num1 = 36;
        int num2 = rnd.nextInt(8)+1;
        int num3 = rnd.nextInt(8);

         int set2 = rnd.nextInt(643) + 100;

         int set3 = rnd.nextInt(8999) + 1000;

        String mobile ="+"+num1+"("+ num2 + "" + num3 + ")" + "-" + set2 + "-" + set3;
        return mobile;
    }

    public static String velSportag(){
        return sportagak.get(rnd.nextInt(sportagak.size()));
    }

    public static String velSportEgyesulet(){
        return egyesuletek.get(rnd.nextInt(egyesuletek.size()));
    }

}
