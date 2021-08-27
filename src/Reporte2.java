import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Reporte2 {

    private File archivo;

    public void crearArchivo(){
        archivo = new File("Reporte2.html");
        try {
            if(archivo.createNewFile()){
                System.out.println("");
            }
        } catch (IOException e) {
            System.err.println("No se pudo crear el archivo ");
        }
    }

    public boolean eliminarArchivo(){
        if(archivo.delete()){
            return true;
        }
        return false;
    }

    public void escribirEnArchivo(int[] reporte1Opciones, int[] bitacora){
        try {
            FileWriter escribir = new FileWriter("Reporte2.html");
            String texto = escribirReporte(reporte1Opciones,bitacora);
            escribir.write(texto);
            escribir.close();
        } catch (IOException e) {
            System.err.println("No se pudo escribir sobre el archivo ");
        }
    }

    private String escribirReporte(int[] reporte1Opciones, int[] bitacora){
        StringBuilder texto = new StringBuilder();
        texto.append("<html>\n" +
                "<head>\n" +
                "\t<meta charset=\"utf-8\">\n" +
                "\t<title>REPORTE #2</title>\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"estilo2.css\">\n" +
                "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                "<link href=\"https://fonts.googleapis.com/css2?family=Yanone+Kaffeesatz&display=swap\" rel=\"stylesheet\">" +
                "<script src=\"https://polyfill.io/v3/polyfill.min.js?features=es6\"></script>\n" +
                "<script id=\"MathJax-script\" async src=\"https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js\"></script>" +
                "\t<body>" +
                "<h1>Reporte #2 (Bitácora Del Juego) </h1>"
        );
        texto.append("<div class=\"Caja\">");
                        texto.append("<div class=\"Caja__cajita\">" );
                        texto.append("Turnos Jugados: " + "<br>"+bitacora[0]);
                        texto.append("</div>");
                        texto.append("<div class=\"Caja__cajita\">");
                        texto.append("Penalizaciones en el tablero " + "<br>"+ bitacora[1]);
                        texto.append("</div>");
                        texto.append("<div class=\"Caja__cajita\">");
                        texto.append("Operaciones realizadas " + "<br>"+" con éxito " +"<br>"+ bitacora[2]);
                        texto.append("</div>");
        texto.append("</div>");

        texto.append("<div class=\"Caja\">");
                        texto.append("<div class=\"Caja__cajita--OP\">");
                        texto.append("Operaciones Realizadas <br>");
                        if(reporte1Opciones[0] != 0){
                            texto.append("Dificultad Fácil<br>");
                            texto.append("Opción: " + reporte1Opciones[0] + "<br>");
                        }else{
                            texto.append("Dificultad Fácil<br>" );
                        }
                        if(!(reporte1Opciones[1] == -1 || reporte1Opciones[1] == 0)){
                            texto.append("Opción: " + reporte1Opciones[1]+"<br>");
                        }

        if(!(reporte1Opciones[2] == -1 || reporte1Opciones[2] == 0 || reporte1Opciones[2] == -2 )){
            texto.append("Dificultad Intermedia<br>");
            texto.append("Opción: " + reporte1Opciones[2] +"<br>");
        }else{
            texto.append("Dificultad Intermedia"+"<br>");
        }

        if(!(reporte1Opciones[3] == -1 || reporte1Opciones[3] == 0 || reporte1Opciones[3] == -2 )){
            texto.append("Opción: " + reporte1Opciones[3] +"<br>");
        }

        if(!(reporte1Opciones[4] == -1 || reporte1Opciones[4] == 0 || reporte1Opciones[4] == -2 || reporte1Opciones[4] == -3)){
            texto.append("Dificultad Difícil"+"<br>");
            texto.append("Opción: " + reporte1Opciones[4]+"<br>");
        }else{
            texto.append("Dificultad Difícil"+"<br>");
        }
        if(!(reporte1Opciones[5] == -1 || reporte1Opciones[5] == 0 || reporte1Opciones[5] == -2 || reporte1Opciones[5] == -3 )){
            texto.append("Opción: " + reporte1Opciones[5]+"<br>");
        }
                        texto.append("</div>");
                        texto.append("<div class=\"Caja__cajita\">");
                        texto.append("Operaciones Fallidas " + "<br>" + bitacora[3]);
                        texto.append("</div>");
        texto.append("</div>");

        texto.append("</body>" + "</head>"+"</html>");
        return texto.toString();
    }

}
