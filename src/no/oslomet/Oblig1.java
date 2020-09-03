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
                throw new IllegalStateException("Tabellen er ikke sortert stigende");
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

    //Oppgave 4

    public static void delsortering (int [] a){

        int left = 0;
        int right = a.length-1;


        for(int i = 0; i < a.length; i++){

            while(a[left]%2==1 && left < right){
                left++;
            }
            while(a[right]%2==0 && left < right){
                right--;
            }

            if(left<right){
                int temp = a[left];
                a[left]=a[right];
                a[right]=temp;
            }
        }

    }

    //Oppgave 5
    public static void rotasjon(char[] a) {
        if(a.length == 0) {
            return;
        }
        char temp = a[a.length-1];

        for (int i=a.length-1;i>0;i--) {
            a[i] = a[i-1];
        }

        //Vet ikke om denne er lov å bruke
        //System.arraycopy(a, 0, a, 1, a.length - 1);

        a[0] = temp;
    }

    //Oppgave 6
    /*
    TODO:
        Bare testet av Thomas, trenger testing av de andre
        Sjekke om det kan skrives mer elegant
     */
    public static void rotasjon(char[] a, int k) {
        if(a.length == 0 || k == 0) {
            return;
        }

        if (k < 0) {
            for (int times=0;times>k;times--) {
                char temp = a[0];

                for (int i=0;i < a.length-1; i++) {
                    a[i] = a[i+1];
                }
                a[a.length-1] = temp;
            }
        }
        else {
            for (int times=0;times<k;times++){
                char temp = a[a.length-1];

                for (int i=a.length-1;i>0;i--) {
                    a[i] = a[i-1];
                }

                a[0] = temp;
            }
        }
    }
    //Oppgave 7 a)

    public static String flett(String s,String t) {
        String out = "";
        int len;
        String big;

        if (s.length() < t.length()) {
            big = t;
            len = s.length();
        } else {
            big = s;
            len = t.length();
        }

        for (int i = 0; i < len; i++) {
            out += s.charAt(i);
            out += t.charAt(i);
        }

        out += big.substring(len);

        return out;
    }
    //Oppgave 7 b)

    public static String flett(String...s) {
        int len = s.length;
        String out = "";

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len ; j++) {
                if (i < s[j].length()){
                    out += s[j].charAt(i);
                }
            }
        }
        return out;
    }


    //Oppgave 8
    static void skriv(int[] a) {
        String mellomrom = "";
        for (int i : a) {
            System.out.print(mellomrom + i);
            mellomrom = " ";
        }
    }

    public static int[] indekssortering(int[] a){
        int[] indeks = new int[a.length];
        if(a.length == 0){
            return a;
        }
        indeks[0]=0;
        for(int i = 1; i < a.length; i ++){
            int j = i;
            for(j= i; j >= 1 && a[j]<a[j-1];j--){
                int temp = a[j];
                a[j] = a[j-1];
                indeks[j] = indeks[j-1];
                a[j-1] = temp;
            }
            indeks[j] = i;

        }
        skriv(indeks);
        return indeks;
    }

    //Oppgave 9
    public static int[] tredjeMin(int[] a){

        int n = a.length;

        if (n < 3)
        {
            throw new NoSuchElementException("Det må være mer enn 3 elementer i arrayet, du har "+n+" elementer!!" );
        }

        int minst = 0;
        int nm = 1;
        int nnm = 2;

        if (a[nm] < a[minst]) {
            minst = 1;
            nm = 0;
        }
        if(a[nnm] < a[nm]){
            nm = 2;
            nnm = 1;
        }
        if(a[nnm] < a[minst]) {
            minst = 2;
            nnm = 0;
        }
        int minverdi = a[minst];
        int nestminverdi = a[nm];
        int nestnestminverdi = a[nnm];

        for (int i = 3; i < n; i++)
        {
            if(a[i] < nestnestminverdi){
                if (a[i] < nestminverdi){
                    if (a[i] < minverdi){
                        nnm = nm;
                        nm = minst;
                        nestnestminverdi = nestminverdi;
                        nestminverdi = minverdi;

                        minst = i;
                        minverdi = a[i];
                    }else{
                        nnm = nm;
                        nestnestminverdi =nestminverdi;

                        nm = i;
                        nestminverdi = a[i];
                    }
                } else {
                    nnm = i;
                    nestnestminverdi = a[i];
                }
            }
        }
        return new int[] {minst,nm,nnm};
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
