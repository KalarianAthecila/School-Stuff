package dev.kalarianathecila.schoolStuff.mathematics;

public class sth {
    public static void main(String[] args) {
        System.out.println("start:" );
        doIt(10);
        System.out.println("Ende:" );
    }

    public static void doIt(int a){
        if (a > 1) {doIt((a / 3));}
        if (a > 1) {doIt((a / 2));}
        System.out.println("ergebnis " + a);
    }
}