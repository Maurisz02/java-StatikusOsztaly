package hu.petrik.statikusOsztaly;

public class Main {
    int nemStatikusTag;
    static int statikusTag;




    public static void main(String[] args) {

        for(int i = 0; i < 100; i++){
            System.out.println(Veletlen.velEgesz(5,10));
        }

        System.out.println();

        for(int i = 0; i < 50; i++){
            System.out.println(Veletlen.velKarakter((char) 30, (char) 50));//'A','C'
        }

        System.out.println();

        for (int i = 0; i < 5; i++){
            System.out.println(Veletlen.velTeljesNev(true));
        }

        System.out.println();

        for (int i = 0; i < 5; i++){
            System.out.println(Veletlen.velTeljesNev(false));
        }

        /*
        Main r = new Main();
        System.out.println(r.nemStatikusTag);
        System.out.println(Main.statikusTag);
        */

        System.out.println();

        System.out.println(Veletlen.velEmail("Pintér Ádám"));

        System.out.println(Veletlen.velMobil());

    }
}
