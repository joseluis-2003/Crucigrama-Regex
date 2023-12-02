package Practicas.TablaRegEx;

public class CrucigramaJoseluisGonzalezAlamo {
    public static void main(String[] args) {
        CrucigramaJoseluisGonzalez1 crucigrama1 = new CrucigramaJoseluisGonzalez1(
                new String[]{"[JUNDT]*", "APA|OPI|OLK", "(NA|FE|HE)[CV]"},
                new String[]{"[DEF][MNO]*", "[^DJNU]P[ABC]", "[ICAN]*"});
        CrucigramaJoseluisGonzalez1 crucigrama2 = new CrucigramaJoseluisGonzalez1(
                new String[]{"UB|IE|AW", "[TUBE]*", "[BORF]."},
                new String[]{"[NOTAD]*", "WEL|BAL|EAR"});
        CrucigramaJoseluisGonzalez1 crucigrama3 = new CrucigramaJoseluisGonzalez1(
                new String[]{"[BQW](PR|LE)", "[RANK]+"},
                new String[]{"[AWE]+", "[ALP]+K", "(PR|ER|EP)"});
        CrucigramaJoseluisGonzalez1[] arrayCrucicramas =
                new CrucigramaJoseluisGonzalez1[]{crucigrama1, crucigrama2, crucigrama3};
        for (int i = 0; i < arrayCrucicramas.length; i++) {
            System.out.println(arrayCrucicramas[i]);
            arrayCrucicramas[i].introducirSol();
            System.out.println(arrayCrucicramas[i]);
            arrayCrucicramas[i].comprobarSol();
        }
    }
}