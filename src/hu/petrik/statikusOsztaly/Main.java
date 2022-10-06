package hu.petrik.statikusOsztaly;

public class Main {
    int nemStatikusTag;
    static int statikusTag;




    public static void main(String[] args) {

        for(int i = 0; i < 100; i++){
            System.out.println(Veletlen.velEgesz(5,10));
        }

        /*
        Main r = new Main();
        System.out.println(r.nemStatikusTag);
        System.out.println(Main.statikusTag);
        */

    }
}
