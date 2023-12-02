package Practicas.TablaRegEx;
import java.util.Scanner;

    public class CrucigramaJoseluisGonzalez1 {
        static final Scanner sc = new Scanner(System.in);
        String[] col;
        String[] row;
        char[][] sol;
        int maxLen;
        public CrucigramaJoseluisGonzalez1() {
            this.col = new String[]{"."};
            this.row = new String[]{"."};
            this.sol = new char[1][1];
            this.maxLen = 1;
        }
        public CrucigramaJoseluisGonzalez1(String[] col, String[] row) {
            validarCol(col);
            this.col = col;
            validarRow(row);
            this.row = row;
            sol = new char[row.length][col.length];
            this.maxLen = maxLong();
        }

        public void setSol(char[][] sol) {
            validarSol(sol);
            this.sol = sol;
        }
        private void validarRow(String[] row){
            if(row == null){
                throw new NullPointerException("El array no puede ser nulo");
            }
        }
        private void validarCol(String[] col){
            if(col == null){
                throw new NullPointerException("El array no puede estar nulo");
            }
        }
        private void validarSol(char[][] sol){
            for (int i = 0; i < sol.length; i++) {
                for (int j = 0; j < sol[i].length; j++) {
                    if ((sol[i][j]+"").length() != 1){
                        throw new IllegalArgumentException("La solución debe tener un sólo carácter en cada espacio" +
                                " de la matriz");
                    }
                }
            }
            if(sol == null){
                throw new NullPointerException("La matriz no puede estar nula");
            }
        }
        public int maxLong(){
            int maxLong = 0;
            for (int i = 0; i < col.length; i++) {
                if (col[i].length() > maxLong){
                    maxLong = col[i].length();
                }
            }
            for (int i = 0; i < row.length; i++) {
                if (row[i].length() > maxLong){
                    maxLong = row[i].length();
                }
            }
            return maxLong;
        }
        public String ampliar(String str){
            return " ".repeat(maxLen-str.length()) + str + " |";
        }
        public void introducirSol(){
            for (int i = 0; i < sol.length; i++) {
                for (int j = 0; j < sol[i].length; j++) {
                    System.out.println("Introduce el carácter en la posición (" + i + ", " + j + "):");
                    sol[i][j] = sc.next().charAt(0);
                }
            }
        }

        public boolean comprobarSol(){
            boolean solucionCorrecta = true;
            String lineaSol = "";
            for (int i = 0; i < sol.length; i++) {
                for (int j = 0; j < sol[i].length; j++) {
                    lineaSol += sol[i][j];
                }
                if (!lineaSol.matches(row[i])){
                    solucionCorrecta = false;
                }
                lineaSol = "";
            }
            for (int i = 0; i < sol.length; i++) {
                for (int j = 0; j < sol[i].length; j++) {
                    lineaSol += sol[j][i];
                }
                if (!lineaSol.matches(col[i])){
                    solucionCorrecta = false;
                }
                lineaSol = "";
            }

            if (solucionCorrecta){
                System.out.println("ENHORABUENA HAS ACERTADO,NO SABES NI COMO");
            }else{
                System.out.println("HAS FALLADO CRACK, INTENTALO DE NUEVO");
            }
            return solucionCorrecta;
        }

        public void borrarSol(){
            sol = new char[row.length][col.length];
        }

        @Override
        public String toString() {
            String resultado = "";
            resultado += ampliar("");
            for (int i = 0; i < col.length; i++) {
                resultado += ampliar(col[i]);
            }
            resultado += "\n";
            for (int i = 0; i < row.length; i++) {
                resultado += ampliar(row[i]);
                for (int j = 0; j < sol.length; j++) {
                    resultado += ampliar(sol[i][j] + "");
                }
                resultado += "\n";
            }
            return resultado;
        }
    }
