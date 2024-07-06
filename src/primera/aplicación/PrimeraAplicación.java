package primera.aplicación;

public class PrimeraAplicación {
    
    static boolean compruebaSignos(String expr){
        for(int i = 0; i<expr.length(); i++){
            if(expr.charAt(i) == '-' || expr.charAt(i) == '/' || expr.charAt(i) == '%'){
                System.out.println("Expresion algebraica incorrecta. Debe contener solo +, *, (, )");
                return false;
            }
        }
        
        return true;
    }
        
    static boolean compruebaNumeroParentesis(String expr) {
        int contadorApertura = 0;
        int contadorCierre = 0;

        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                contadorApertura++;
            } else if (expr.charAt(i) == ')') {
                contadorCierre++;
            }
        }

        if (contadorApertura != contadorCierre) {
            return false;
        }

        return true;
    }

    static boolean compruebaParentesis(String expr) {
        int contadorApertura = 0;
        int contadorCierre = 0;
        boolean encontrado;
        int posicionCierre = 0;

        if (compruebaNumeroParentesis(expr) == false || compruebaSignos(expr) == false) {
            return false;
        } else {
            for (int j = 0; j < expr.length(); j++) {

                if (expr.charAt(j) == '(') {
                    System.out.println("( encontrado en la posicion " + j);
                    contadorApertura++;

                    encontrado = false;
                    for (int i = j + 1; i <= (expr.length() - 1) && encontrado == false; i++) {
                        if (expr.charAt(i) == ')' && i > posicionCierre) {
                            posicionCierre = i;
                            System.out.println(") encontrado en la posicion " + i);
                            encontrado = true;
                            contadorCierre++;
                        }
                    }
                }
            }
        }
        
        if(contadorApertura == contadorCierre){
            return true;
        }else{
            return false;
        }
        
    }

    public static void main(String[] args) {

        String expresion = "8+3-56*((6+9))";
        System.out.println("Longitud de la expresion: " + expresion.length());

        System.out.println(compruebaParentesis(expresion));

    }

}
