package no.oslomet;

import java.util.NoSuchElementException;

public class Oblig1 {

    //Oppgave 1
    public static int maks(int[] a) throws NoSuchElementException {
        if (a.length < 1) {
            throw new NoSuchElementException("A list of length 0 has no biggest number!");
        }

        for (int i=0;i<a.length-1;i++) {
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }

        return a[a.length-1];
    }

    //Oppgave 2
    public static int antallUlikeSortert(int[] a){

        for(int i = 0; i < a.length-1; i++) {
            if (a[i] <= a[i + 1]) {
            }else{
                throw new IllegalArgumentException("Tabellen er ikke sortert stigende");
            }
        }

        int ant = 0;
        for(int i = 0; i < a.length; i++){
            int j;
            for(j = 0; j < i; j++){
                if(a[i] == a [j]) {
                    break;
                }
            }
            if( i == j) {
                ant++;
            }
        } return ant;
    }

    //Oppgave 3
    public static int antallUlikeUsortert(int[] a){
        int ant = 0;
        for(int i = 0; i < a.length; i++){
            int j;
            for(j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    break;
                }
            }
            if( i == j) {
                ant++;
            }
        } return ant;
    }



    //Oppgave 10
    public static boolean inneholdt(String a, String b) {
        /*
        popper ut chars når den finner en char som er lik, om sammenlignings strengen er tom vil det
        si at alle bokstavene fant seg en lik.
         */
        for (int i=0;i<b.length();i++) {
            for (int j=0;j<a.length();j++) {
                if (b.charAt(i) == a.charAt(j)) {
                    a = a.substring(0, j) + a.substring(j+1);
                    break;
                }
            }
        }

        return a.length() == 0;
    }
}
