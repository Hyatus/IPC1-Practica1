import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class Reporte1 {

    private int[] reporte1Opciones = new int[6];
    private double[][][] reporte1Datos = new double[23][][];
    private File archivo;


    public void crearArchivo(){
        archivo = new File("Reporte1.html");
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

    public void escribirEnArchivo(int[] reporte1Opciones, double[][][] reporte1Datos){
        try {
            FileWriter escribir = new FileWriter("Reporte1.html");
            String texto = escribirReporte(reporte1Opciones,reporte1Datos);
            escribir.write(texto);
            escribir.close();
        } catch (IOException e) {
            System.err.println("No se pudo escribir sobre el archivo ");
        }
    }

    private String escribirReporte(int[] reporte1Opciones, double[][][] reporte1Datos){
        StringBuilder texto = new StringBuilder();
        texto.append("<html>\n" +
                "<head>\n" +
                "\t<meta charset=\"utf-8\">\n" +
                "\t<title>REPORTE #1</title>\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\">\n" +
                "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                        "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                        "<link href=\"https://fonts.googleapis.com/css2?family=Yanone+Kaffeesatz&display=swap\" rel=\"stylesheet\">" +
                "<script src=\"https://polyfill.io/v3/polyfill.min.js?features=es6\"></script>\n" +
                        "<script id=\"MathJax-script\" async src=\"https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js\"></script>" +
                "\t<body>" +
                "<h1>Reporte #1 (Operaciones realizadas durante el juego) </h1>" +
                "<h2 class = \"h2__sub--Fa\">Reporte de penalizaciones fáciles: </h2>"
                );
        texto.append("<div>");
        texto.append(OperacionesFaciles(reporte1Opciones,reporte1Datos));
        texto.append("</div>");
        texto.append("<h2 class = \"h2__sub--Inter\">Reporte de penalizaciones Intermedias: </h2>");
        texto.append("<div>");
        texto.append(OperacionesIntermedias(reporte1Opciones,reporte1Datos));
        texto.append("</div>");
        texto.append("<h2 class = \"h2__sub--Dif\">Reporte de penalizaciones Difíciles: </h2>");
        texto.append("<div>");
        texto.append(OperacionesDificiles(reporte1Opciones,reporte1Datos));
        texto.append("</div>");
        texto.append("</body>" + "</head>"+"</html>");
        return texto.toString();
    }

    private StringBuilder OperacionesFaciles(int[] reporte1Opciones, double[][][] reporte1Datos){
        DecimalFormat df = new DecimalFormat("###.###");
        StringBuilder opeFacil = new StringBuilder();
        if(reporte1Opciones[0] == 1){
            opeFacil.append("<p>");
            opeFacil.append("<h3 class = \"h3__sub--Fa\">Se realizó con éxito la operación 1 en la primera penalización </h3>");
            opeFacil.append("<h3>Instrucciones: Mediante ley de cosenos encontrar lado B y ángulos \\(\\beta\\) y \\(\\gamma\\) " +
                    "del siguiente triángulo</h3>");
            opeFacil.append("<br>"+" <img src=\"triangulo.png\"><br> ");
            opeFacil.append("<h3>Los datos fueron los siguientes: </h3>");
            opeFacil.append("<h3>Lado A = " + reporte1Datos[0][0][0]  + "</h3>");
            opeFacil.append("<h3>Lado C = " + reporte1Datos[0][0][1] + "</h3>" );
            opeFacil.append("<h3>Ángulo \\(\\alpha\\) = " + df.format(Math.toDegrees(reporte1Datos[0][0][2])) + " grados</h3>");
            opeFacil.append("<h3>Utilizando la fórmula  \\(b^2 = a^2 + c^2 - 2ac*\\cos(\\alpha)\\)" + "</h3>");
            opeFacil.append("<h3> Despejamos para b = \\(\\sqrt{a^2 + c^2 - 2ac*\\cos(\\alpha)}\\)  </h3>");
            opeFacil.append("<h3> Para hallar \\(\\beta\\) =  \\[ \\arccos = (-{ a^2 - b^2 - c^2\\over 2bc}) \\]  </h3>");
            opeFacil.append("<h3> Para hallar \\(\\gamma\\) =  \\[ \\arccos = (-{ c^2 - a^2 - b^2\\over 2ab}) \\]  </h3>");
            opeFacil.append("<h3 class=\"h3__sub--resFa\">Los resultados fueron los siguientes: " + "</h3>");
            opeFacil.append("<h3>Lado B =  " + reporte1Datos[0][0][3] + " unidades</h3>");
            opeFacil.append("<h3>Ángulo \\(\\beta\\) =  " + reporte1Datos[0][0][4]  + " grados</h3>");
            opeFacil.append("<h3>Ángulo \\(\\gamma\\) =  " + reporte1Datos[0][0][5] + " grados</h3>");
            opeFacil.append("</p>");
        }else if(reporte1Opciones[0] == 2){
            opeFacil.append("<p>");
            opeFacil.append("<h3 class = \"h3__sub--Fa\">Se realizó con éxito la operación 2 en la primera penalización </h3>");
            opeFacil.append("<h3>Instrucciones: Mediante ley de cosenos encontrar lado A y ángulos \\(\\alpha\\) y \\(\\gamma\\) " +
                    "del siguiente triángulo</h3>");
            opeFacil.append("<br>"+" <img src=\"triangulo.png\"><br> ");
            opeFacil.append("<h3>Los datos fueron los siguientes: </h3>");
            opeFacil.append("<h3>Lado B = " + reporte1Datos[0][1][0]  + "</h3>");
            opeFacil.append("<h3>Lado C = " + reporte1Datos[0][1][1] + "</h3>" );
            opeFacil.append("<h3>Ángulo \\(\\beta\\) = " + df.format(Math.toDegrees(reporte1Datos[0][1][2])) + " grados</h3>");
            opeFacil.append("<h3>Utilizando la fórmula  \\(a^2 = b^2 + c^2 - 2bc*\\cos(\\beta)\\)" + "</h3>");
            opeFacil.append("<h3> Despejamos para a = \\(\\sqrt{b^2 + c^2 - 2bc*\\cos(\\beta)}\\)  </h3>");
            opeFacil.append("<h3> Para hallar \\(\\alpha\\) =  \\[ \\arccos = (-{ b^2 - a^2 - c^2\\over 2ac}) \\]  </h3>");
            opeFacil.append("<h3> Para hallar \\(\\gamma\\) =  \\[ \\arccos = (-{ c^2 - a^2 - b^2\\over 2ab}) \\]  </h3>");
            opeFacil.append("<h3 class=\"h3__sub--resFa\">Los resultados fueron los siguientes: " + "</h3>");
            opeFacil.append("<h3>Lado B =  " + reporte1Datos[0][1][3] + " unidades</h3>");
            opeFacil.append("<h3>Ángulo \\(\\alpha\\) =  " + reporte1Datos[0][1][4]  + " grados</h3>");
            opeFacil.append("<h3>Ángulo \\(\\gamma\\) =  " + reporte1Datos[0][1][5]  + " grados</h3>");
            opeFacil.append("</p>");
        }else if(reporte1Opciones[0] == 3){
            opeFacil.append("<p>");
            opeFacil.append("<h3 class = \"h3__sub--Fa\">Se realizó con éxito la operación 3 en la primera penalización </h3>");
            opeFacil.append("<h3>Instrucciones: Mediante ley de cosenos encontrar lado C y ángulos \\(\\alpha\\) y \\(\\beta\\) " +
                    "del siguiente triángulo</h3>");
            opeFacil.append("<br>"+" <img src=\"triangulo.png\"><br> ");
            opeFacil.append("<h3>Los datos fueron los siguientes: </h3>");
            opeFacil.append("<h3>Lado A = " + reporte1Datos[0][2][0]  + "</h3>");
            opeFacil.append("<h3>Lado B = " + reporte1Datos[0][2][1] + "</h3>" );
            opeFacil.append("<h3>Ángulo \\(\\gamma\\) = " + df.format(Math.toDegrees(reporte1Datos[0][2][2]))  + " grados</h3>");
            opeFacil.append("<h3>Utilizando la fórmula  \\(c^2 = b^2 + a^2 - 2ab*\\cos(\\gamma)\\)" + "</h3>");
            opeFacil.append("<h3> Despejamos para c = \\(\\sqrt{b^2 + a^2 - 2ab*\\cos(\\gamma)}\\)  </h3>");
            opeFacil.append("<h3> Para hallar \\(\\alpha\\) =  \\[ \\arccos = (-{ b^2 - a^2 - c^2\\over 2ac}) \\]  </h3>");
            opeFacil.append("<h3> Para hallar \\(\\beta\\) =  \\[ \\arccos = (-{ a^2 - b^2 - c^2\\over 2bc}) \\]  </h3>");
            opeFacil.append("<h3 class=\"h3__sub--resFa\">Los resultados fueron los siguientes: " + "</h3>");
            opeFacil.append("<h3>Lado B =  " + reporte1Datos[0][2][3] + " unidades</h3>");
            opeFacil.append("<h3>Ángulo \\(\\alpha\\) =  " + reporte1Datos[0][2][4] + " grados</h3>");
            opeFacil.append("<h3>Ángulo \\(\\beta\\) =  " + reporte1Datos[0][2][5] + " grados</h3>");
            opeFacil.append("</p>");
        }else if(reporte1Opciones[0] == 0){
        opeFacil.append("<p>");
        opeFacil.append("<br>");
        opeFacil.append("<h2 class=\"h2__err\">No hubo una primera penalización en operaciones fáciles </h2>");
        opeFacil.append("<br>");
        opeFacil.append("</p>");
        }

        if(reporte1Opciones[1] == 1){
            opeFacil.append("<p>");
            opeFacil.append("<h3 class = \"h3__sub--Fa\">Se realizó con éxito la operación 1 en la segunda penalización </h3>");
            opeFacil.append("<h3>Instrucciones: Mediante ley de cosenos encontrar lado B y ángulos \\(\\beta\\) y \\(\\gamma\\) " +
                    "del siguiente triángulo</h3>");
            opeFacil.append("<br>"+" <img src=\"triangulo.png\"><br> ");
            opeFacil.append("<h3>Los datos fueron los siguientes: </h3>");
            opeFacil.append("<h3>Lado A = " + reporte1Datos[0][0][0]  + "</h3>");
            opeFacil.append("<h3>Lado C = " + reporte1Datos[0][0][1] + "</h3>" );
            opeFacil.append("<h3>Ángulo \\(\\alpha\\) = " + df.format(Math.toDegrees(reporte1Datos[0][0][2])) + " grados</h3>");
            opeFacil.append("<h3>Utilizando la fórmula  \\(b^2 = a^2 + c^2 - 2ac*\\cos(\\alpha)\\)" + "</h3>");
            opeFacil.append("<h3> Despejamos para b = \\(\\sqrt{a^2 + c^2 - 2ac*\\cos(\\alpha)}\\)  </h3>");
            opeFacil.append("<h3> Para hallar \\(\\beta\\) =  \\[ \\arccos = (-{ a^2 - b^2 - c^2\\over 2bc}) \\]  </h3>");
            opeFacil.append("<h3> Para hallar \\(\\gamma\\) =  \\[ \\arccos = (-{ c^2 - a^2 - b^2\\over 2ab}) \\]  </h3>");
            opeFacil.append("<h3 class=\"h3__sub--resFa\">Los resultados fueron los siguientes: " + "</h3>");
            opeFacil.append("<h3>Lado B =  " + reporte1Datos[0][0][3] + " unidades</h3>");
            opeFacil.append("<h3>Ángulo \\(\\beta\\) =  " + reporte1Datos[0][0][4]  + " grados</h3>");
            opeFacil.append("<h3>Ángulo \\(\\gamma\\) =  " + reporte1Datos[0][0][5] + " grados</h3>");
            opeFacil.append("</p>");
        }else if(reporte1Opciones[1] == 2){
            opeFacil.append("<p>");
            opeFacil.append("<h3 class = \"h3__sub--Fa\">Se realizó con éxito la operación 2 en la segunda penalización </h3>");
            opeFacil.append("<h3>Instrucciones: Mediante ley de cosenos encontrar lado A y ángulos \\(\\alpha\\) y \\(\\gamma\\) " +
                    "del siguiente triángulo</h3>");
            opeFacil.append("<br>"+" <img src=\"triangulo.png\"><br> ");
            opeFacil.append("<h3>Los datos fueron los siguientes: </h3>");
            opeFacil.append("<h3>Lado B = " + reporte1Datos[0][1][0]  + "</h3>");
            opeFacil.append("<h3>Lado C = " + reporte1Datos[0][1][1] + "</h3>" );
            opeFacil.append("<h3>Ángulo \\(\\beta\\) = " + df.format(Math.toDegrees(reporte1Datos[0][1][2])) + " grados</h3>");
            opeFacil.append("<h3>Utilizando la fórmula  \\(a^2 = b^2 + c^2 - 2bc*\\cos(\\beta)\\)" + "</h3>");
            opeFacil.append("<h3> Despejamos para a = \\(\\sqrt{b^2 + c^2 - 2bc*\\cos(\\beta)}\\)  </h3>");
            opeFacil.append("<h3> Para hallar \\(\\alpha\\) =  \\[ \\arccos = (-{ b^2 - a^2 - c^2\\over 2ac}) \\]  </h3>");
            opeFacil.append("<h3> Para hallar \\(\\gamma\\) =  \\[ \\arccos = (-{ c^2 - a^2 - b^2\\over 2ab}) \\]  </h3>");
            opeFacil.append("<h3 class=\"h3__sub--resFa\">Los resultados fueron los siguientes: " + "</h3>");
            opeFacil.append("<h3>Lado B =  " + reporte1Datos[0][1][3] + " unidades</h3>");
            opeFacil.append("<h3>Ángulo \\(\\alpha\\) =  " + reporte1Datos[0][1][4]  + " grados</h3>");
            opeFacil.append("<h3>Ángulo \\(\\gamma\\) =  " + reporte1Datos[0][1][5]  + " grados</h3>");
            opeFacil.append("</p>");
        }else if(reporte1Opciones[1] == 3){
            opeFacil.append("<p>");
            opeFacil.append("<h3 class=\"h3__sub--Fa\">Se realizó con éxito la operación 3 en la segunda penalización </h3>");
            opeFacil.append("<h3>Instrucciones: Mediante ley de cosenos encontrar lado C y ángulos \\(\\alpha\\) y \\(\\beta\\) " +
                    "del siguiente triángulo</h3>");
            opeFacil.append("<br>"+" <img src=\"triangulo.png\"><br> ");
            opeFacil.append("<h3>Los datos fueron los siguientes: </h3>");
            opeFacil.append("<h3>Lado A = " + reporte1Datos[0][2][0]  + "</h3>");
            opeFacil.append("<h3>Lado B = " + reporte1Datos[0][2][1] + "</h3>" );
            opeFacil.append("<h3>Ángulo \\(\\gamma\\) = " + df.format(Math.toDegrees(reporte1Datos[0][2][2]))  + " grados</h3>");
            opeFacil.append("<h3>Utilizando la fórmula  \\(c^2 = b^2 + a^2 - 2ab*\\cos(\\gamma)\\)" + "</h3>");
            opeFacil.append("<h3> Despejamos para c = \\(\\sqrt{b^2 + a^2 - 2ab*\\cos(\\gamma)}\\)  </h3>");
            opeFacil.append("<h3> Para hallar \\(\\alpha\\) =  \\[ \\arccos = (-{ b^2 - a^2 - c^2\\over 2ac}) \\]  </h3>");
            opeFacil.append("<h3> Para hallar \\(\\beta\\) =  \\[ \\arccos = (-{ a^2 - b^2 - c^2\\over 2bc}) \\]  </h3>");
            opeFacil.append("<h3 class=\"h3__sub--resFa\">Los resultados fueron los siguientes: " + "</h3>");
            opeFacil.append("<h3>Lado B =  " + reporte1Datos[0][2][3] + " unidades</h3>");
            opeFacil.append("<h3>Ángulo \\(\\alpha\\) =  " + reporte1Datos[0][2][4] + " grados</h3>");
            opeFacil.append("<h3>Ángulo \\(\\beta\\) =  " + reporte1Datos[0][2][5] + " grados</h3>");
            opeFacil.append("</p>");
        }else if(reporte1Opciones[1] == -1 || reporte1Opciones[1] == 0){
            opeFacil.append("<p>");
            opeFacil.append("<br>");
            opeFacil.append("<h2 class=\"h2__err\">No hubo una segunda penalización en operaciones fáciles </h2>");
            opeFacil.append("<br>");
            opeFacil.append("</p>");
        }
        return opeFacil;
    }

    private StringBuilder OperacionesIntermedias(int[] reporte1Opciones, double[][][] reporte1Datos){
        DecimalFormat df = new DecimalFormat("###.###");
        StringBuilder opeInter = new StringBuilder();
        if(reporte1Opciones[2] == 1){
            opeInter.append("<p>");
            opeInter.append("<h3 class = \"h3__sub--Inter\">Se realizó con éxito la operación 1 en la tercera penalización </h3>");
            opeInter.append("<h3>Instrucciones: Realizar la suma de matrices de A y B</h3>");
            opeInter.append("<h3>Datos: </h3>");
            opeInter.append("<h3>Matriz A: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[1][0][0]+"&"+reporte1Datos[1][0][1]+"&"+reporte1Datos[1][0][2]+"&"+reporte1Datos[1][0][3]+"&"+reporte1Datos[1][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[1][1][0]+"&"+reporte1Datos[1][1][1]+"&"+reporte1Datos[1][1][2]+"&"+reporte1Datos[1][1][3]+"&"+reporte1Datos[1][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[1][2][0]+"&"+reporte1Datos[1][2][1]+"&"+reporte1Datos[1][2][2]+"&"+reporte1Datos[1][2][3]+"&"+reporte1Datos[1][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[1][3][0]+"&"+reporte1Datos[1][3][1]+"&"+reporte1Datos[1][3][2]+"&"+reporte1Datos[1][3][3]+"&"+reporte1Datos[1][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[1][4][0]+"&"+reporte1Datos[1][4][1]+"&"+reporte1Datos[1][4][2]+"&"+reporte1Datos[1][4][3]+"&"+reporte1Datos[1][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("<h3>Matriz B: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[2][0][0]+"&"+reporte1Datos[2][0][1]+"&"+reporte1Datos[2][0][2]+"&"+reporte1Datos[2][0][3]+"&"+reporte1Datos[2][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[2][1][0]+"&"+reporte1Datos[2][1][1]+"&"+reporte1Datos[2][1][2]+"&"+reporte1Datos[2][1][3]+"&"+reporte1Datos[2][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[2][2][0]+"&"+reporte1Datos[2][2][1]+"&"+reporte1Datos[2][2][2]+"&"+reporte1Datos[2][2][3]+"&"+reporte1Datos[2][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[2][3][0]+"&"+reporte1Datos[2][3][1]+"&"+reporte1Datos[2][3][2]+"&"+reporte1Datos[2][3][3]+"&"+reporte1Datos[2][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[2][4][0]+"&"+reporte1Datos[2][4][1]+"&"+reporte1Datos[2][4][2]+"&"+reporte1Datos[2][4][3]+"&"+reporte1Datos[2][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("<h3>Para realizar esta operación tanto A como B deben tener las mismas dimensiones</h3>");
            opeInter.append("<h3>La matriz resultante se obtiene sumando los elementos de las dos matrices que ocupan la misma posición</h3>");
            opeInter.append("<h3 class = \"h3__sub--resInter\"> La matriz resultante fue: </h3>");
            opeInter.append("<h3>Matriz R: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[3][0][0]+"&"+reporte1Datos[3][0][1]+"&"+reporte1Datos[3][0][2]+"&"+reporte1Datos[3][0][3]+"&"+reporte1Datos[3][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[3][1][0]+"&"+reporte1Datos[3][1][1]+"&"+reporte1Datos[3][1][2]+"&"+reporte1Datos[3][1][3]+"&"+reporte1Datos[3][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[3][2][0]+"&"+reporte1Datos[3][2][1]+"&"+reporte1Datos[3][2][2]+"&"+reporte1Datos[3][2][3]+"&"+reporte1Datos[3][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[3][3][0]+"&"+reporte1Datos[3][3][1]+"&"+reporte1Datos[3][3][2]+"&"+reporte1Datos[3][3][3]+"&"+reporte1Datos[3][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[3][4][0]+"&"+reporte1Datos[3][4][1]+"&"+reporte1Datos[3][4][2]+"&"+reporte1Datos[3][4][3]+"&"+reporte1Datos[3][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("</p>");
        }else if(reporte1Opciones[2] == 2){
            opeInter.append("<p>");
            opeInter.append("<h3 class = \"h3__sub--Inter\">Se realizó con éxito la operación 1 en la tercera penalización </h3>");
            opeInter.append("<h3>Instrucciones: Realizar la suma de matrices de A y B</h3>");
            opeInter.append("<h3>Datos: </h3>");
            opeInter.append("<h3>Matriz A: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[4][0][0]+"&"+reporte1Datos[4][0][1]+"&"+reporte1Datos[4][0][2]+"&"+reporte1Datos[4][0][3]+"&"+reporte1Datos[4][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[4][1][0]+"&"+reporte1Datos[4][1][1]+"&"+reporte1Datos[4][1][2]+"&"+reporte1Datos[4][1][3]+"&"+reporte1Datos[4][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[4][2][0]+"&"+reporte1Datos[4][2][1]+"&"+reporte1Datos[4][2][2]+"&"+reporte1Datos[4][2][3]+"&"+reporte1Datos[4][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[4][3][0]+"&"+reporte1Datos[4][3][1]+"&"+reporte1Datos[4][3][2]+"&"+reporte1Datos[4][3][3]+"&"+reporte1Datos[4][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[4][4][0]+"&"+reporte1Datos[4][4][1]+"&"+reporte1Datos[4][4][2]+"&"+reporte1Datos[4][4][3]+"&"+reporte1Datos[4][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("<h3>Matriz B: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[5][0][0]+"&"+reporte1Datos[5][0][1]+"&"+reporte1Datos[5][0][2]+"&"+reporte1Datos[5][0][3]+"&"+reporte1Datos[5][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[5][1][0]+"&"+reporte1Datos[5][1][1]+"&"+reporte1Datos[5][1][2]+"&"+reporte1Datos[5][1][3]+"&"+reporte1Datos[5][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[5][2][0]+"&"+reporte1Datos[5][2][1]+"&"+reporte1Datos[5][2][2]+"&"+reporte1Datos[5][2][3]+"&"+reporte1Datos[5][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[5][3][0]+"&"+reporte1Datos[5][3][1]+"&"+reporte1Datos[5][3][2]+"&"+reporte1Datos[5][3][3]+"&"+reporte1Datos[5][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[5][4][0]+"&"+reporte1Datos[5][4][1]+"&"+reporte1Datos[5][4][2]+"&"+reporte1Datos[5][4][3]+"&"+reporte1Datos[5][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("<h3>Para realizar esta operación tanto A como B deben tener las mismas dimensiones</h3>");
            opeInter.append("<h3>La matriz resultante se obtiene sumando los elementos de las dos matrices que ocupan la misma posición</h3>");
            opeInter.append("<h3 class = \"h3__sub--resInter\"> La matriz resultante fue: </h3>");
            opeInter.append("<h3>Matriz R: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[6][0][0]+"&"+reporte1Datos[6][0][1]+"&"+reporte1Datos[6][0][2]+"&"+reporte1Datos[6][0][3]+"&"+reporte1Datos[6][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[6][1][0]+"&"+reporte1Datos[6][1][1]+"&"+reporte1Datos[6][1][2]+"&"+reporte1Datos[6][1][3]+"&"+reporte1Datos[6][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[6][2][0]+"&"+reporte1Datos[6][2][1]+"&"+reporte1Datos[6][2][2]+"&"+reporte1Datos[6][2][3]+"&"+reporte1Datos[6][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[6][3][0]+"&"+reporte1Datos[6][3][1]+"&"+reporte1Datos[6][3][2]+"&"+reporte1Datos[6][3][3]+"&"+reporte1Datos[6][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[6][4][0]+"&"+reporte1Datos[6][4][1]+"&"+reporte1Datos[6][4][2]+"&"+reporte1Datos[6][4][3]+"&"+reporte1Datos[6][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("</p>");
        }else if(reporte1Opciones[2] == 3){
            opeInter.append("<p>");
            opeInter.append("<h3 class = \"h3__sub--Inter\">Se realizó con éxito la operación 1 en la tercera penalización </h3>");
            opeInter.append("<h3>Instrucciones: Realizar la suma de matrices de A y B</h3>");
            opeInter.append("<h3>Datos: </h3>");
            opeInter.append("<h3>Matriz A: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[7][0][0]+"&"+reporte1Datos[7][0][1]+"&"+reporte1Datos[7][0][2]+"&"+reporte1Datos[7][0][3]+"&"+reporte1Datos[7][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[7][1][0]+"&"+reporte1Datos[7][1][1]+"&"+reporte1Datos[7][1][2]+"&"+reporte1Datos[7][1][3]+"&"+reporte1Datos[7][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[7][2][0]+"&"+reporte1Datos[7][2][1]+"&"+reporte1Datos[7][2][2]+"&"+reporte1Datos[7][2][3]+"&"+reporte1Datos[7][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[7][3][0]+"&"+reporte1Datos[7][3][1]+"&"+reporte1Datos[7][3][2]+"&"+reporte1Datos[7][3][3]+"&"+reporte1Datos[7][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[7][4][0]+"&"+reporte1Datos[7][4][1]+"&"+reporte1Datos[7][4][2]+"&"+reporte1Datos[7][4][3]+"&"+reporte1Datos[7][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("<h3>Matriz B: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[8][0][0]+"&"+reporte1Datos[8][0][1]+"&"+reporte1Datos[8][0][2]+"&"+reporte1Datos[8][0][3]+"&"+reporte1Datos[8][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[8][1][0]+"&"+reporte1Datos[8][1][1]+"&"+reporte1Datos[8][1][2]+"&"+reporte1Datos[8][1][3]+"&"+reporte1Datos[8][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[8][2][0]+"&"+reporte1Datos[8][2][1]+"&"+reporte1Datos[8][2][2]+"&"+reporte1Datos[8][2][3]+"&"+reporte1Datos[8][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[8][3][0]+"&"+reporte1Datos[8][3][1]+"&"+reporte1Datos[8][3][2]+"&"+reporte1Datos[8][3][3]+"&"+reporte1Datos[8][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[8][4][0]+"&"+reporte1Datos[8][4][1]+"&"+reporte1Datos[8][4][2]+"&"+reporte1Datos[8][4][3]+"&"+reporte1Datos[8][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("<h3>Para realizar esta operación tanto A como B deben tener las mismas dimensiones</h3>");
            opeInter.append("<h3>La matriz resultante se obtiene sumando los elementos de las dos matrices que ocupan la misma posición</h3>");
            opeInter.append("<h3 class = \"h3__sub--resInter\"> La matriz resultante fue: </h3>");
            opeInter.append("<h3>Matriz R: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[9][0][0]+"&"+reporte1Datos[9][0][1]+"&"+reporte1Datos[9][0][2]+"&"+reporte1Datos[9][0][3]+"&"+reporte1Datos[9][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[9][1][0]+"&"+reporte1Datos[9][1][1]+"&"+reporte1Datos[9][1][2]+"&"+reporte1Datos[9][1][3]+"&"+reporte1Datos[9][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[9][2][0]+"&"+reporte1Datos[9][2][1]+"&"+reporte1Datos[9][2][2]+"&"+reporte1Datos[9][2][3]+"&"+reporte1Datos[9][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[9][3][0]+"&"+reporte1Datos[9][3][1]+"&"+reporte1Datos[9][3][2]+"&"+reporte1Datos[9][3][3]+"&"+reporte1Datos[9][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[9][4][0]+"&"+reporte1Datos[9][4][1]+"&"+reporte1Datos[9][4][2]+"&"+reporte1Datos[9][4][3]+"&"+reporte1Datos[9][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("</p>");
        }else if(reporte1Opciones[2] == -1 || reporte1Opciones[1] == 0){
            opeInter.append("<p>");
            opeInter.append("<br>");
            opeInter.append("<h2 class=\"h2__err\">No hubo una tercera penalización en operaciones Intermedias </h2>");
            opeInter.append("<br>");
            opeInter.append("</p>");
        }else if(reporte1Opciones[2] == -2){
            opeInter.append("<p>");
            opeInter.append("<br>");
            opeInter.append("<h2 class=\"h2__err\">No se pudo realizar la suma en la tercera penalización porque una de las matrices es inválida </h2>");
            opeInter.append("<br>");
            opeInter.append("</p>");
        }

        if(reporte1Opciones[3] == 1){
            opeInter.append("<p>");
            opeInter.append("<h3 class = \"h3__sub--Inter\">Se realizó con éxito la operación 1 en la cuarta penalización </h3>");
            opeInter.append("<h3>Instrucciones: Realizar la suma de matrices de A y B</h3>");
            opeInter.append("<h3>Datos: </h3>");
            opeInter.append("<h3>Matriz A: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[1][0][0]+"&"+reporte1Datos[1][0][1]+"&"+reporte1Datos[1][0][2]+"&"+reporte1Datos[1][0][3]+"&"+reporte1Datos[1][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[1][1][0]+"&"+reporte1Datos[1][1][1]+"&"+reporte1Datos[1][1][2]+"&"+reporte1Datos[1][1][3]+"&"+reporte1Datos[1][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[1][2][0]+"&"+reporte1Datos[1][2][1]+"&"+reporte1Datos[1][2][2]+"&"+reporte1Datos[1][2][3]+"&"+reporte1Datos[1][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[1][3][0]+"&"+reporte1Datos[1][3][1]+"&"+reporte1Datos[1][3][2]+"&"+reporte1Datos[1][3][3]+"&"+reporte1Datos[1][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[1][4][0]+"&"+reporte1Datos[1][4][1]+"&"+reporte1Datos[1][4][2]+"&"+reporte1Datos[1][4][3]+"&"+reporte1Datos[1][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("<h3>Matriz B: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[2][0][0]+"&"+reporte1Datos[2][0][1]+"&"+reporte1Datos[2][0][2]+"&"+reporte1Datos[2][0][3]+"&"+reporte1Datos[2][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[2][1][0]+"&"+reporte1Datos[2][1][1]+"&"+reporte1Datos[2][1][2]+"&"+reporte1Datos[2][1][3]+"&"+reporte1Datos[2][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[2][2][0]+"&"+reporte1Datos[2][2][1]+"&"+reporte1Datos[2][2][2]+"&"+reporte1Datos[2][2][3]+"&"+reporte1Datos[2][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[2][3][0]+"&"+reporte1Datos[2][3][1]+"&"+reporte1Datos[2][3][2]+"&"+reporte1Datos[2][3][3]+"&"+reporte1Datos[2][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[2][4][0]+"&"+reporte1Datos[2][4][1]+"&"+reporte1Datos[2][4][2]+"&"+reporte1Datos[2][4][3]+"&"+reporte1Datos[2][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("<h3>Para realizar esta operación tanto A como B deben tener las mismas dimensiones</h3>");
            opeInter.append("<h3>La matriz resultante se obtiene sumando los elementos de las dos matrices que ocupan la misma posición</h3>");
            opeInter.append("<h3 class = \"h3__sub--resInter\"> La matriz resultante fue: </h3>");
            opeInter.append("<h3>Matriz R: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[3][0][0]+"&"+reporte1Datos[3][0][1]+"&"+reporte1Datos[3][0][2]+"&"+reporte1Datos[3][0][3]+"&"+reporte1Datos[3][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[3][1][0]+"&"+reporte1Datos[3][1][1]+"&"+reporte1Datos[3][1][2]+"&"+reporte1Datos[3][1][3]+"&"+reporte1Datos[3][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[3][2][0]+"&"+reporte1Datos[3][2][1]+"&"+reporte1Datos[3][2][2]+"&"+reporte1Datos[3][2][3]+"&"+reporte1Datos[3][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[3][3][0]+"&"+reporte1Datos[3][3][1]+"&"+reporte1Datos[3][3][2]+"&"+reporte1Datos[3][3][3]+"&"+reporte1Datos[3][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[3][4][0]+"&"+reporte1Datos[3][4][1]+"&"+reporte1Datos[3][4][2]+"&"+reporte1Datos[3][4][3]+"&"+reporte1Datos[3][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("</p>");
        }else if(reporte1Opciones[3] == 2){
            opeInter.append("<p>");
            opeInter.append("<h3 class = \"h3__sub--Inter\">Se realizó con éxito la operación 1 en la cuarta penalización </h3>");
            opeInter.append("<h3>Instrucciones: Realizar la suma de matrices de A y B</h3>");
            opeInter.append("<h3>Datos: </h3>");
            opeInter.append("<h3>Matriz A: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[4][0][0]+"&"+reporte1Datos[4][0][1]+"&"+reporte1Datos[4][0][2]+"&"+reporte1Datos[4][0][3]+"&"+reporte1Datos[4][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[4][1][0]+"&"+reporte1Datos[4][1][1]+"&"+reporte1Datos[4][1][2]+"&"+reporte1Datos[4][1][3]+"&"+reporte1Datos[4][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[4][2][0]+"&"+reporte1Datos[4][2][1]+"&"+reporte1Datos[4][2][2]+"&"+reporte1Datos[4][2][3]+"&"+reporte1Datos[4][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[4][3][0]+"&"+reporte1Datos[4][3][1]+"&"+reporte1Datos[4][3][2]+"&"+reporte1Datos[4][3][3]+"&"+reporte1Datos[4][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[4][4][0]+"&"+reporte1Datos[4][4][1]+"&"+reporte1Datos[4][4][2]+"&"+reporte1Datos[4][4][3]+"&"+reporte1Datos[4][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("<h3>Matriz B: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[5][0][0]+"&"+reporte1Datos[5][0][1]+"&"+reporte1Datos[5][0][2]+"&"+reporte1Datos[5][0][3]+"&"+reporte1Datos[5][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[5][1][0]+"&"+reporte1Datos[5][1][1]+"&"+reporte1Datos[5][1][2]+"&"+reporte1Datos[5][1][3]+"&"+reporte1Datos[5][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[5][2][0]+"&"+reporte1Datos[5][2][1]+"&"+reporte1Datos[5][2][2]+"&"+reporte1Datos[5][2][3]+"&"+reporte1Datos[5][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[5][3][0]+"&"+reporte1Datos[5][3][1]+"&"+reporte1Datos[5][3][2]+"&"+reporte1Datos[5][3][3]+"&"+reporte1Datos[5][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[5][4][0]+"&"+reporte1Datos[5][4][1]+"&"+reporte1Datos[5][4][2]+"&"+reporte1Datos[5][4][3]+"&"+reporte1Datos[5][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("<h3>Para realizar esta operación tanto A como B deben tener las mismas dimensiones</h3>");
            opeInter.append("<h3>La matriz resultante se obtiene sumando los elementos de las dos matrices que ocupan la misma posición</h3>");
            opeInter.append("<h3 class = \"h3__sub--resInter\"> La matriz resultante fue: </h3>");
            opeInter.append("<h3>Matriz R: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[6][0][0]+"&"+reporte1Datos[6][0][1]+"&"+reporte1Datos[6][0][2]+"&"+reporte1Datos[6][0][3]+"&"+reporte1Datos[6][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[6][1][0]+"&"+reporte1Datos[6][1][1]+"&"+reporte1Datos[6][1][2]+"&"+reporte1Datos[6][1][3]+"&"+reporte1Datos[6][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[6][2][0]+"&"+reporte1Datos[6][2][1]+"&"+reporte1Datos[6][2][2]+"&"+reporte1Datos[6][2][3]+"&"+reporte1Datos[6][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[6][3][0]+"&"+reporte1Datos[6][3][1]+"&"+reporte1Datos[6][3][2]+"&"+reporte1Datos[6][3][3]+"&"+reporte1Datos[6][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[6][4][0]+"&"+reporte1Datos[6][4][1]+"&"+reporte1Datos[6][4][2]+"&"+reporte1Datos[6][4][3]+"&"+reporte1Datos[6][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("</p>");
        }else if(reporte1Opciones[3] == 3){
            opeInter.append("<p>");
            opeInter.append("<h3 class = \"h3__sub--Inter\">Se realizó con éxito la operación 1 en la cuarta penalización </h3>");
            opeInter.append("<h3>Instrucciones: Realizar la suma de matrices de A y B</h3>");
            opeInter.append("<h3>Datos: </h3>");
            opeInter.append("<h3>Matriz A: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[7][0][0]+"&"+reporte1Datos[7][0][1]+"&"+reporte1Datos[7][0][2]+"&"+reporte1Datos[7][0][3]+"&"+reporte1Datos[7][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[7][1][0]+"&"+reporte1Datos[7][1][1]+"&"+reporte1Datos[7][1][2]+"&"+reporte1Datos[7][1][3]+"&"+reporte1Datos[7][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[7][2][0]+"&"+reporte1Datos[7][2][1]+"&"+reporte1Datos[7][2][2]+"&"+reporte1Datos[7][2][3]+"&"+reporte1Datos[7][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[7][3][0]+"&"+reporte1Datos[7][3][1]+"&"+reporte1Datos[7][3][2]+"&"+reporte1Datos[7][3][3]+"&"+reporte1Datos[7][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[7][4][0]+"&"+reporte1Datos[7][4][1]+"&"+reporte1Datos[7][4][2]+"&"+reporte1Datos[7][4][3]+"&"+reporte1Datos[7][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("<h3>Matriz B: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[8][0][0]+"&"+reporte1Datos[8][0][1]+"&"+reporte1Datos[8][0][2]+"&"+reporte1Datos[8][0][3]+"&"+reporte1Datos[8][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[8][1][0]+"&"+reporte1Datos[8][1][1]+"&"+reporte1Datos[8][1][2]+"&"+reporte1Datos[8][1][3]+"&"+reporte1Datos[8][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[8][2][0]+"&"+reporte1Datos[8][2][1]+"&"+reporte1Datos[8][2][2]+"&"+reporte1Datos[8][2][3]+"&"+reporte1Datos[8][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[8][3][0]+"&"+reporte1Datos[8][3][1]+"&"+reporte1Datos[8][3][2]+"&"+reporte1Datos[8][3][3]+"&"+reporte1Datos[8][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[8][4][0]+"&"+reporte1Datos[8][4][1]+"&"+reporte1Datos[8][4][2]+"&"+reporte1Datos[8][4][3]+"&"+reporte1Datos[8][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("<h3>Para realizar esta operación tanto A como B deben tener las mismas dimensiones</h3>");
            opeInter.append("<h3>La matriz resultante se obtiene sumando los elementos de las dos matrices que ocupan la misma posición</h3>");
            opeInter.append("<h3 class = \"h3__sub--resInter\"> La matriz resultante fue: </h3>");
            opeInter.append("<h3>Matriz R: ");
            opeInter.append("$$\\begin{pmatrix}");
            opeInter.append(reporte1Datos[9][0][0]+"&"+reporte1Datos[9][0][1]+"&"+reporte1Datos[9][0][2]+"&"+reporte1Datos[9][0][3]+"&"+reporte1Datos[9][0][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[9][1][0]+"&"+reporte1Datos[9][1][1]+"&"+reporte1Datos[9][1][2]+"&"+reporte1Datos[9][1][3]+"&"+reporte1Datos[9][1][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[9][2][0]+"&"+reporte1Datos[9][2][1]+"&"+reporte1Datos[9][2][2]+"&"+reporte1Datos[9][2][3]+"&"+reporte1Datos[9][2][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[9][3][0]+"&"+reporte1Datos[9][3][1]+"&"+reporte1Datos[9][3][2]+"&"+reporte1Datos[9][3][3]+"&"+reporte1Datos[9][3][4]+"\\\\\\ ");
            opeInter.append(reporte1Datos[9][4][0]+"&"+reporte1Datos[9][4][1]+"&"+reporte1Datos[9][4][2]+"&"+reporte1Datos[9][4][3]+"&"+reporte1Datos[9][4][4]+"\\\\\\ ");
            opeInter.append("\\end{pmatrix}$$");
            opeInter.append("</h3>");
            opeInter.append("</p>");
        }else if(reporte1Opciones[3] == -1 || reporte1Opciones[1] == 0){
            opeInter.append("<p>");
            opeInter.append("<br>");
            opeInter.append("<h2 class=\"h2__err\">No hubo una cuarta penalización en operaciones Intermedias </h2>");
            opeInter.append("<br>");
            opeInter.append("</p>");
        }else if(reporte1Opciones[3] == -2){
            opeInter.append("<p>");
            opeInter.append("<br>");
            opeInter.append("<h2 class=\"h2__err\">No se pudo realizar la suma en la cuarta penalización porque una de las matrices es inválida </h2>");
            opeInter.append("<br>");
            opeInter.append("</p>");
        }
        return opeInter;
    }

    private StringBuilder OperacionesDificiles(int[] reporte1Opciones, double[][][] reporte1Datos){
        DecimalFormat df = new DecimalFormat("###.###");
        StringBuilder opeDif = new StringBuilder();

        if(reporte1Opciones[4] == 1){
            opeDif.append("<p>");
            opeDif.append("<h3 class = \"h3__sub--Inter\">Se realizó con éxito la operación 1 en la quinta penalización </h3>");
            opeDif.append("<h3>Instrucciones: Realizar la división de matrices de A y B</h3>");
            opeDif.append("<h3>");
            opeDif.append("La división de dos matrices es la multiplicación de una matriz por la matriz inversa de la matriz divisora, y al mismo tiempo, exige que la matriz divisora sea una matriz cuadrada y que su determinante sea distinto de cero.");
            opeDif.append("</h3>");
            opeDif.append("<h3> La fórmula quedaría así:   \\[ A = ({ A \\over B}) = A*B^-1 \\] </h3>");
            opeDif.append("<h3> Lo siguiente es sacar la inversa de B una vez comprobado que su determinante no es cero utilizaríamos la siguiente fórmula</h3>");
            opeDif.append("<h3>\\[ B^{-1} = ({ 1 \\over \\det{B^{-1}} })*Adj(B^t) \\] </h3>");
            opeDif.append("<h3>Sabiendo esto nuestros datos son los siguientes: </h3>");
            opeDif.append("<h3>Matriz A:  </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(reporte1Datos[10][0][0]+"&"+reporte1Datos[10][0][1]+"&"+reporte1Datos[10][0][2]+"&"+reporte1Datos[10][0][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[10][1][0]+"&"+reporte1Datos[10][1][1]+"&"+reporte1Datos[10][1][2]+"&"+reporte1Datos[10][1][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[10][2][0]+"&"+reporte1Datos[10][2][1]+"&"+reporte1Datos[10][2][2]+"&"+reporte1Datos[10][2][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[10][3][0]+"&"+reporte1Datos[10][3][1]+"&"+reporte1Datos[10][3][2]+"&"+reporte1Datos[10][3][3]);
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("<h3>Matriz B:  </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(reporte1Datos[11][0][0]+"&"+reporte1Datos[11][0][1]+"&"+reporte1Datos[11][0][2]+"&"+reporte1Datos[11][0][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[11][1][0]+"&"+reporte1Datos[11][1][1]+"&"+reporte1Datos[11][1][2]+"&"+reporte1Datos[11][1][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[11][2][0]+"&"+reporte1Datos[11][2][1]+"&"+reporte1Datos[11][2][2]+"&"+reporte1Datos[11][2][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[11][3][0]+"&"+reporte1Datos[11][3][1]+"&"+reporte1Datos[11][3][2]+"&"+reporte1Datos[11][3][3]);
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("<h3>El determinante de  B es: " + reporte1Datos[22][0][0] + "</h3>");
            opeDif.append("<h3>La Matriz Inversa de B es : </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(df.format(reporte1Datos[12][0][0])+"&"+df.format(reporte1Datos[12][0][1])+"&"+df.format(reporte1Datos[12][0][2])+"&"+df.format(reporte1Datos[12][0][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[12][1][0])+"&"+df.format(reporte1Datos[12][1][1])+"&"+df.format(reporte1Datos[12][1][2])+"&"+df.format(reporte1Datos[12][1][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[12][2][0])+"&"+df.format(reporte1Datos[12][2][1])+"&"+df.format(reporte1Datos[12][2][2])+"&"+df.format(reporte1Datos[12][2][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[12][3][0])+"&"+df.format(reporte1Datos[12][3][1])+"&"+df.format(reporte1Datos[12][3][2])+"&"+df.format(reporte1Datos[12][3][3]));
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("<h3>La multiplicación de \\(A*B^{-1}\\) </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(df.format(reporte1Datos[13][0][0])+"&"+df.format(reporte1Datos[13][0][1])+"&"+df.format(reporte1Datos[13][0][2])+"&"+df.format(reporte1Datos[13][0][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[13][1][0])+"&"+df.format(reporte1Datos[13][1][1])+"&"+df.format(reporte1Datos[13][1][2])+"&"+df.format(reporte1Datos[13][1][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[13][2][0])+"&"+df.format(reporte1Datos[13][2][1])+"&"+df.format(reporte1Datos[13][2][2])+"&"+df.format(reporte1Datos[13][2][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[13][3][0])+"&"+df.format(reporte1Datos[13][3][1])+"&"+df.format(reporte1Datos[13][3][2])+"&"+df.format(reporte1Datos[13][3][3]));
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("</p>");
        }else if(reporte1Opciones[4] == 2){
            opeDif.append("<p>");
            opeDif.append("<h3 class = \"h3__sub--Inter\">Se realizó con éxito la operación 2 en la quinta penalización </h3>");
            opeDif.append("<h3>Instrucciones: Realizar la división de matrices de A y B</h3>");
            opeDif.append("<h3>");
            opeDif.append("La división de dos matrices es la multiplicación de una matriz por la matriz inversa de la matriz divisora, y al mismo tiempo, exige que la matriz divisora sea una matriz cuadrada y que su determinante sea distinto de cero.");
            opeDif.append("</h3>");
            opeDif.append("<h3> La fórmula quedaría así:   \\[ A = ({ A \\over B}) = A*B^-1 \\] </h3>");
            opeDif.append("<h3> Lo siguiente es sacar la inversa de B una vez comprobado que su determinante no es cero utilizaríamos la siguiente fórmula</h3>");
            opeDif.append("<h3>\\[ B^{-1} = ({ 1 \\over \\det{B^{-1}} })*Adj(B^t) \\] </h3>");
            opeDif.append("<h3>Sabiendo esto nuestros datos son los siguientes: </h3>");
            opeDif.append("<h3>Matriz A:  </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(reporte1Datos[14][0][0]+"&"+reporte1Datos[14][0][1]+"&"+reporte1Datos[14][0][2]+"&"+reporte1Datos[14][0][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[14][1][0]+"&"+reporte1Datos[14][1][1]+"&"+reporte1Datos[14][1][2]+"&"+reporte1Datos[14][1][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[14][2][0]+"&"+reporte1Datos[14][2][1]+"&"+reporte1Datos[14][2][2]+"&"+reporte1Datos[14][2][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[14][3][0]+"&"+reporte1Datos[14][3][1]+"&"+reporte1Datos[14][3][2]+"&"+reporte1Datos[14][3][3]);
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("<h3>Matriz B:  </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(reporte1Datos[15][0][0]+"&"+reporte1Datos[15][0][1]+"&"+reporte1Datos[15][0][2]+"&"+reporte1Datos[15][0][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[15][1][0]+"&"+reporte1Datos[15][1][1]+"&"+reporte1Datos[15][1][2]+"&"+reporte1Datos[15][1][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[15][2][0]+"&"+reporte1Datos[15][2][1]+"&"+reporte1Datos[15][2][2]+"&"+reporte1Datos[15][2][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[15][3][0]+"&"+reporte1Datos[15][3][1]+"&"+reporte1Datos[15][3][2]+"&"+reporte1Datos[15][3][3]);
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("<h3>El determinante de  B es: " + reporte1Datos[22][0][1] + "</h3>");
            opeDif.append("<h3>La Matriz Inversa de B es : </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(df.format(reporte1Datos[16][0][0])+"&"+df.format(reporte1Datos[16][0][1])+"&"+df.format(reporte1Datos[16][0][2])+"&"+df.format(reporte1Datos[16][0][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[16][1][0])+"&"+df.format(reporte1Datos[16][1][1])+"&"+df.format(reporte1Datos[16][1][2])+"&"+df.format(reporte1Datos[16][1][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[16][2][0])+"&"+df.format(reporte1Datos[16][2][1])+"&"+df.format(reporte1Datos[16][2][2])+"&"+df.format(reporte1Datos[16][2][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[16][3][0])+"&"+df.format(reporte1Datos[16][3][1])+"&"+df.format(reporte1Datos[16][3][2])+"&"+df.format(reporte1Datos[16][3][3]));
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append(" <h3>La multiplicación de \\(A*B^{-1}\\) </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(df.format(reporte1Datos[17][0][0])+"&"+df.format(reporte1Datos[17][0][1])+"&"+df.format(reporte1Datos[17][0][2])+"&"+df.format(reporte1Datos[17][0][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[17][1][0])+"&"+df.format(reporte1Datos[17][1][1])+"&"+df.format(reporte1Datos[17][1][2])+"&"+df.format(reporte1Datos[17][1][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[17][2][0])+"&"+df.format(reporte1Datos[17][2][1])+"&"+df.format(reporte1Datos[17][2][2])+"&"+df.format(reporte1Datos[17][2][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[17][3][0])+"&"+df.format(reporte1Datos[17][3][1])+"&"+df.format(reporte1Datos[17][3][2])+"&"+df.format(reporte1Datos[17][3][3]));
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("</p>");
        }else if(reporte1Opciones[4] == 3){
            opeDif.append("<p>");
            opeDif.append("<h3 class = \"h3__sub--Inter\">Se realizó con éxito la operación 3 en la quinta penalización </h3>");
            opeDif.append("<h3>Instrucciones: Realizar la división de matrices de A y B</h3>");
            opeDif.append("<h3>");
            opeDif.append("La división de dos matrices es la multiplicación de una matriz por la matriz inversa de la matriz divisora, y al mismo tiempo, exige que la matriz divisora sea una matriz cuadrada y que su determinante sea distinto de cero.");
            opeDif.append("</h3>");
            opeDif.append("<h3> La fórmula quedaría así:   \\[ A = ({ A \\over B}) = A*B^-1 \\]   </h3>");
            opeDif.append("<h3> Lo siguiente es sacar la inversa de B una vez comprobado que su determinante no es cero utilizaríamos la siguiente fórmula</h3>");
            opeDif.append("<h3>\\[ B^{-1} = ({ 1 \\over \\det{B^{-1}} })*Adj(B^t) \\] </h3>");
            opeDif.append("<h3>Sabiendo esto nuestros datos son los siguientes: </h3>");
            opeDif.append("<h3>Matriz A:</h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(reporte1Datos[18][0][0]+"&"+reporte1Datos[18][0][1]+"&"+reporte1Datos[18][0][2]+"&"+reporte1Datos[18][0][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[18][1][0]+"&"+reporte1Datos[18][1][1]+"&"+reporte1Datos[18][1][2]+"&"+reporte1Datos[18][1][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[18][2][0]+"&"+reporte1Datos[18][2][1]+"&"+reporte1Datos[18][2][2]+"&"+reporte1Datos[18][2][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[18][3][0]+"&"+reporte1Datos[18][3][1]+"&"+reporte1Datos[18][3][2]+"&"+reporte1Datos[18][3][3]);
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("<h3>Matriz B: </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(reporte1Datos[19][0][0]+"&"+reporte1Datos[19][0][1]+"&"+reporte1Datos[19][0][2]+"&"+reporte1Datos[19][0][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[19][1][0]+"&"+reporte1Datos[19][1][1]+"&"+reporte1Datos[19][1][2]+"&"+reporte1Datos[19][1][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[19][2][0]+"&"+reporte1Datos[19][2][1]+"&"+reporte1Datos[19][2][2]+"&"+reporte1Datos[19][2][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[19][3][0]+"&"+reporte1Datos[19][3][1]+"&"+reporte1Datos[19][3][2]+"&"+reporte1Datos[19][3][3]);
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("<h3>El determinante de  B es: " + reporte1Datos[22][0][2] + "</h3>");
            opeDif.append("<h3>La Matriz Inversa de B es : </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(df.format(reporte1Datos[20][0][0])+"&"+df.format(reporte1Datos[20][0][1])+"&"+df.format(reporte1Datos[20][0][2])+"&"+df.format(reporte1Datos[20][0][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[20][1][0])+"&"+df.format(reporte1Datos[20][1][1])+"&"+df.format(reporte1Datos[20][1][2])+"&"+df.format(reporte1Datos[20][1][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[20][2][0])+"&"+df.format(reporte1Datos[20][2][1])+"&"+df.format(reporte1Datos[20][2][2])+"&"+df.format(reporte1Datos[20][2][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[20][3][0])+"&"+df.format(reporte1Datos[20][3][1])+"&"+df.format(reporte1Datos[20][3][2])+"&"+df.format(reporte1Datos[20][3][3]));
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append(" <h3>La multiplicación de \\(A*B^{-1}\\) </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(df.format(reporte1Datos[21][0][0])+"&"+df.format(reporte1Datos[21][0][1])+"&"+df.format(reporte1Datos[21][0][2])+"&"+df.format(reporte1Datos[21][0][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[21][1][0])+"&"+df.format(reporte1Datos[21][1][1])+"&"+df.format(reporte1Datos[21][1][2])+"&"+df.format(reporte1Datos[21][1][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[21][2][0])+"&"+df.format(reporte1Datos[21][2][1])+"&"+df.format(reporte1Datos[21][2][2])+"&"+df.format(reporte1Datos[21][2][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[21][3][0])+"&"+df.format(reporte1Datos[21][3][1])+"&"+df.format(reporte1Datos[21][3][2])+"&"+df.format(reporte1Datos[21][3][3]));
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("</p>");
        }else if(reporte1Opciones[4] == -1 || reporte1Opciones[1] == 0){
            opeDif.append("<p>");
            opeDif.append("<br>");
            opeDif.append("<h2 class=\"h2__err\">No  hubo una quinta penalización en operaciones díficiles </h2>");
            opeDif.append("<br>");
            opeDif.append("</p>");
        }else if(reporte1Opciones[4] == -2){
            opeDif.append("<p>");
            opeDif.append("<br>");
            opeDif.append("<h2 class=\"h2__err\">No se pudo realizar la suma en la quinta penalización porque una de las matrices es inválida </h2>");
            opeDif.append("<br>");
            opeDif.append("</p>");
        }else if(reporte1Opciones[4] == -3){
            opeDif.append("<p>");
            opeDif.append("<br>");
            opeDif.append("<h2 class=\"h2__err\">No se pudo realizar la suma en la quinta penalización porque el determinante de la matriz B es Cero </h2>");
            opeDif.append("<br>");
            opeDif.append("</p>");
        }

        if(reporte1Opciones[5] == 1){
            opeDif.append("<p>");
            opeDif.append("<h3 class = \"h3__sub--Inter\">Se realizó con éxito la operación 1 en la sexta penalización </h3>");
            opeDif.append("<h3>Instrucciones: Realizar la división de matrices de A y B</h3>");
            opeDif.append("<h3>");
            opeDif.append("La división de dos matrices es la multiplicación de una matriz por la matriz inversa de la matriz divisora, y al mismo tiempo, exige que la matriz divisora sea una matriz cuadrada y que su determinante sea distinto de cero.");
            opeDif.append("</h3>");
            opeDif.append("<h3> La fórmula quedaría así:   \\[ A = ({ A \\over B}) = A*B^-1 \\]    </h3>");
            opeDif.append("<h3> Lo siguiente es sacar la inversa de B una vez comprobado que su determinante no es cero utilizaríamos la siguiente fórmula </h3>");
            opeDif.append("<h3>\\[ B^{-1} = ({ 1 \\over \\det{B^{-1}} })*Adj(B^t) \\] </h3>");
            opeDif.append("<h3>Sabiendo esto nuestros datos son los siguientes: </h3>");
            opeDif.append("<h3>Matriz A: </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(reporte1Datos[10][0][0]+"&"+reporte1Datos[10][0][1]+"&"+reporte1Datos[10][0][2]+"&"+reporte1Datos[10][0][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[10][1][0]+"&"+reporte1Datos[10][1][1]+"&"+reporte1Datos[10][1][2]+"&"+reporte1Datos[10][1][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[10][2][0]+"&"+reporte1Datos[10][2][1]+"&"+reporte1Datos[10][2][2]+"&"+reporte1Datos[10][2][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[10][3][0]+"&"+reporte1Datos[10][3][1]+"&"+reporte1Datos[10][3][2]+"&"+reporte1Datos[10][3][3]);
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("<h3>Matriz B: </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(reporte1Datos[11][0][0]+"&"+reporte1Datos[11][0][1]+"&"+reporte1Datos[11][0][2]+"&"+reporte1Datos[11][0][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[11][1][0]+"&"+reporte1Datos[11][1][1]+"&"+reporte1Datos[11][1][2]+"&"+reporte1Datos[11][1][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[11][2][0]+"&"+reporte1Datos[11][2][1]+"&"+reporte1Datos[11][2][2]+"&"+reporte1Datos[11][2][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[11][3][0]+"&"+reporte1Datos[11][3][1]+"&"+reporte1Datos[11][3][2]+"&"+reporte1Datos[11][3][3]);
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("<h3>El determinante de  B es: " + reporte1Datos[22][0][0] + "</h3>");
            opeDif.append("<h3>La Matriz Inversa de B es : </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(df.format(reporte1Datos[12][0][0])+"&"+df.format(reporte1Datos[12][0][1])+"&"+df.format(reporte1Datos[12][0][2])+"&"+df.format(reporte1Datos[12][0][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[12][1][0])+"&"+df.format(reporte1Datos[12][1][1])+"&"+df.format(reporte1Datos[12][1][2])+"&"+df.format(reporte1Datos[12][1][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[12][2][0])+"&"+df.format(reporte1Datos[12][2][1])+"&"+df.format(reporte1Datos[12][2][2])+"&"+df.format(reporte1Datos[12][2][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[12][3][0])+"&"+df.format(reporte1Datos[12][3][1])+"&"+df.format(reporte1Datos[12][3][2])+"&"+df.format(reporte1Datos[12][3][3]));
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append(" <h3>La multiplicación de \\(A*B^{-1}\\) </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(df.format(reporte1Datos[13][0][0])+"&"+df.format(reporte1Datos[13][0][1])+"&"+df.format(reporte1Datos[13][0][2])+"&"+df.format(reporte1Datos[13][0][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[13][1][0])+"&"+df.format(reporte1Datos[13][1][1])+"&"+df.format(reporte1Datos[13][1][2])+"&"+df.format(reporte1Datos[13][1][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[13][2][0])+"&"+df.format(reporte1Datos[13][2][1])+"&"+df.format(reporte1Datos[13][2][2])+"&"+df.format(reporte1Datos[13][2][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[13][3][0])+"&"+df.format(reporte1Datos[13][3][1])+"&"+df.format(reporte1Datos[13][3][2])+"&"+df.format(reporte1Datos[13][3][3]));
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("</p>");
        }else if(reporte1Opciones[5] == 2){
            opeDif.append("<p>");
            opeDif.append("<h3 class = \"h3__sub--Inter\">Se realizó con éxito la operación 2 en la sexta penalización </h3>");
            opeDif.append("<h3>Instrucciones: Realizar la división de matrices de A y B</h3>");
            opeDif.append("<h3>");
            opeDif.append("La división de dos matrices es la multiplicación de una matriz por la matriz inversa de la matriz divisora, y al mismo tiempo, exige que la matriz divisora sea una matriz cuadrada y que su determinante sea distinto de cero.");
            opeDif.append("</h3>");
            opeDif.append("<h3> La fórmula quedaría así:   \\[ A = ({ A \\over B}) = A*B^-1 \\] =   </h3>");
            opeDif.append("<h3> Lo siguiente es sacar la inversa de B una vez comprobado que su determinante no es cero utilizaríamos la siguiente fórmula</h3>");
            opeDif.append("<h3>\\[ B^{-1} = ({ 1 \\over \\det{B^{-1}} })*Adj(B^t) \\] </h3>");
            opeDif.append("<h3>Sabiendo esto nuestros datos son los siguientes: </h3>");
            opeDif.append("<h3>Matriz A: </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(reporte1Datos[14][0][0]+"&"+reporte1Datos[14][0][1]+"&"+reporte1Datos[14][0][2]+"&"+reporte1Datos[14][0][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[14][1][0]+"&"+reporte1Datos[14][1][1]+"&"+reporte1Datos[14][1][2]+"&"+reporte1Datos[14][1][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[14][2][0]+"&"+reporte1Datos[14][2][1]+"&"+reporte1Datos[14][2][2]+"&"+reporte1Datos[14][2][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[14][3][0]+"&"+reporte1Datos[14][3][1]+"&"+reporte1Datos[14][3][2]+"&"+reporte1Datos[14][3][3]);
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("<h3>Matriz B: </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(reporte1Datos[15][0][0]+"&"+reporte1Datos[15][0][1]+"&"+reporte1Datos[15][0][2]+"&"+reporte1Datos[15][0][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[15][1][0]+"&"+reporte1Datos[15][1][1]+"&"+reporte1Datos[15][1][2]+"&"+reporte1Datos[15][1][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[15][2][0]+"&"+reporte1Datos[15][2][1]+"&"+reporte1Datos[15][2][2]+"&"+reporte1Datos[15][2][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[15][3][0]+"&"+reporte1Datos[15][3][1]+"&"+reporte1Datos[15][3][2]+"&"+reporte1Datos[15][3][3]);
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("<h3>El determinante de  B es: " + reporte1Datos[22][0][1] + "</h3>");
            opeDif.append("<h3>La Matriz Inversa de B es : </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(df.format(reporte1Datos[16][0][0])+"&"+df.format(reporte1Datos[16][0][1])+"&"+df.format(reporte1Datos[16][0][2])+"&"+df.format(reporte1Datos[16][0][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[16][1][0])+"&"+df.format(reporte1Datos[16][1][1])+"&"+df.format(reporte1Datos[16][1][2])+"&"+df.format(reporte1Datos[16][1][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[16][2][0])+"&"+df.format(reporte1Datos[16][2][1])+"&"+df.format(reporte1Datos[16][2][2])+"&"+df.format(reporte1Datos[16][2][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[16][3][0])+"&"+df.format(reporte1Datos[16][3][1])+"&"+df.format(reporte1Datos[16][3][2])+"&"+df.format(reporte1Datos[16][3][3]));
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append(" <h3>La multiplicación de \\(A*B^{-1}\\) </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(df.format(reporte1Datos[17][0][0])+"&"+df.format(reporte1Datos[17][0][1])+"&"+df.format(reporte1Datos[17][0][2])+"&"+df.format(reporte1Datos[17][0][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[17][1][0])+"&"+df.format(reporte1Datos[17][1][1])+"&"+df.format(reporte1Datos[17][1][2])+"&"+df.format(reporte1Datos[17][1][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[17][2][0])+"&"+df.format(reporte1Datos[17][2][1])+"&"+df.format(reporte1Datos[17][2][2])+"&"+df.format(reporte1Datos[17][2][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[17][3][0])+"&"+df.format(reporte1Datos[17][3][1])+"&"+df.format(reporte1Datos[17][3][2])+"&"+df.format(reporte1Datos[17][3][3]));
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("</p>");
        }else if(reporte1Opciones[5] == 3){
            opeDif.append("<p>");
            opeDif.append("<h3 class = \"h3__sub--Inter\">Se realizó con éxito la operación 3 en la sexta penalización </h3>");
            opeDif.append("<h3>Instrucciones: Realizar la división de matrices de A y B</h3>");
            opeDif.append("<h3>");
            opeDif.append("La división de dos matrices es la multiplicación de una matriz por la matriz inversa de la matriz divisora, y al mismo tiempo, exige que la matriz divisora sea una matriz cuadrada y que su determinante sea distinto de cero.");
            opeDif.append("</h3>");
            opeDif.append("<h3> La fórmula quedaría así:   \\[ A = ({ A \\over B}) = A*B^-1 \\]    </h3>");
            opeDif.append("<h3> Lo siguiente es sacar la inversa de B una vez comprobado que su determinante no es cero utilizaríamos la siguiente fórmula </h3>");
            opeDif.append("<h3>\\[ B^{-1} = ({ 1 \\over \\det{B^{-1}} })*Adj(B^t) \\] </h3>");
            opeDif.append("<h3>Sabiendo esto nuestros datos son los siguientes: </h3>");
            opeDif.append("<h3>Matriz A: </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(reporte1Datos[18][0][0]+"&"+reporte1Datos[18][0][1]+"&"+reporte1Datos[18][0][2]+"&"+reporte1Datos[18][0][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[18][1][0]+"&"+reporte1Datos[18][1][1]+"&"+reporte1Datos[18][1][2]+"&"+reporte1Datos[18][1][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[18][2][0]+"&"+reporte1Datos[18][2][1]+"&"+reporte1Datos[18][2][2]+"&"+reporte1Datos[18][2][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[18][3][0]+"&"+reporte1Datos[18][3][1]+"&"+reporte1Datos[18][3][2]+"&"+reporte1Datos[18][3][3]);
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("<h3>Matriz B: </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(reporte1Datos[19][0][0]+"&"+reporte1Datos[19][0][1]+"&"+reporte1Datos[19][0][2]+"&"+reporte1Datos[19][0][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[19][1][0]+"&"+reporte1Datos[19][1][1]+"&"+reporte1Datos[19][1][2]+"&"+reporte1Datos[19][1][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[19][2][0]+"&"+reporte1Datos[19][2][1]+"&"+reporte1Datos[19][2][2]+"&"+reporte1Datos[19][2][3]+"\\\\\\ ");
            opeDif.append(reporte1Datos[19][3][0]+"&"+reporte1Datos[19][3][1]+"&"+reporte1Datos[19][3][2]+"&"+reporte1Datos[19][3][3]);
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("<h3>El determinante de  B es: " + reporte1Datos[22][0][2] + "</h3>");
            opeDif.append("<h3>La Matriz Inversa de B es : </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(df.format(reporte1Datos[20][0][0])+"&"+df.format(reporte1Datos[20][0][1])+"&"+df.format(reporte1Datos[20][0][2])+"&"+df.format(reporte1Datos[20][0][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[20][1][0])+"&"+df.format(reporte1Datos[20][1][1])+"&"+df.format(reporte1Datos[20][1][2])+"&"+df.format(reporte1Datos[20][1][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[20][2][0])+"&"+df.format(reporte1Datos[20][2][1])+"&"+df.format(reporte1Datos[20][2][2])+"&"+df.format(reporte1Datos[20][2][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[20][3][0])+"&"+df.format(reporte1Datos[20][3][1])+"&"+df.format(reporte1Datos[20][3][2])+"&"+df.format(reporte1Datos[20][3][3]));
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append(" <h3>La multiplicación de \\(A*B^{-1}\\) </h3>");
            opeDif.append("<h3>");
            opeDif.append("$$\\begin{pmatrix}");
            opeDif.append(df.format(reporte1Datos[21][0][0])+"&"+df.format(reporte1Datos[21][0][1])+"&"+df.format(reporte1Datos[21][0][2])+"&"+df.format(reporte1Datos[21][0][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[21][1][0])+"&"+df.format(reporte1Datos[21][1][1])+"&"+df.format(reporte1Datos[21][1][2])+"&"+df.format(reporte1Datos[21][1][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[21][2][0])+"&"+df.format(reporte1Datos[21][2][1])+"&"+df.format(reporte1Datos[21][2][2])+"&"+df.format(reporte1Datos[21][2][3])+"\\\\\\ ");
            opeDif.append(df.format(reporte1Datos[21][3][0])+"&"+df.format(reporte1Datos[21][3][1])+"&"+df.format(reporte1Datos[21][3][2])+"&"+df.format(reporte1Datos[21][3][3]));
            opeDif.append("\\end{pmatrix}$$");
            opeDif.append("</h3>");
            opeDif.append("</p>");
        }else if(reporte1Opciones[5] == -1 || reporte1Opciones[1] == 0){
            opeDif.append("<p>");
            opeDif.append("<br>");
            opeDif.append("<h2 class=\"h2__err\">No  hubo una sexta penalización en operaciones díficiles </h2>");
            opeDif.append("<br>");
            opeDif.append("</p>");
        }else if(reporte1Opciones[5] == -2){
            opeDif.append("<p>");
            opeDif.append("<br>");
            opeDif.append("<h2 class=\"h2__err\">No se pudo realizar la suma en la sexta penalización porque una de las matrices es inválida </h2>");
            opeDif.append("<br>");
            opeDif.append("</p>");
        }else if(reporte1Opciones[5] == -3){
            opeDif.append("<p>");
            opeDif.append("<br>");
            opeDif.append("<h2 class=\"h2__err\">No se pudo realizar la suma en la sexta penalización porque el determinante de la matriz B es Cero </h2>");
            opeDif.append("<br>");
            opeDif.append("</p>");
        }

        return opeDif;
    }

}
