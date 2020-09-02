package no.oslomet;

public class Oblig1 {


    public static boolean inneholdt(String a, String b) {
        /*
        Oppgave 10.
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
