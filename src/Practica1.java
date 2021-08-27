import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Practica1 {
    public static int contFacil = 0, contInter = 0, contDif = 0, indiceReporte1=0;
    public static int[] bitacora = new int[4];
    //contTurnos = 0, contPenalizaciones = 1, operacionesExito = 2, operacionesFallo = 3
    public static int[] reporte1Opciones = new int[6];
    public static double[][][] reporte1Datos = new double[23][][];
    public static Reporte1 r1 = new Reporte1();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] tablero = new String[128];
        definirArreglosparaReportes();
        menuPrincipal(tablero, entrada, false, false);
    }

    public static void definirArreglosparaReportes(){
        //Respuestas de las operaciones fáciles
        reporte1Datos[0] = new double[3][6];
        //Determinantes de las operaciones difíciles
        reporte1Datos[22] = new double[1][3];
    }

    public static void menuPrincipal(String[] tablero, Scanner entrada, boolean juegoIniciado, boolean juegoTerminado){
        int opcion;
        boolean salir = true;

        while(salir != false){

            System.out.println("\n\t .:MENÚ:.");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Retomar");
            System.out.println("3. Generar Reportes");
            System.out.println("4. Salir ");

            try{
                System.out.println("Introduce un número válido");
                opcion = entrada.nextInt();
                switch (opcion){
                    case 1:
                        inicializar(tablero, entrada);
                        break;
                    case 2:
                        if(juegoIniciado == false){
                            System.err.println("No hay ninguna partida iniciada");
                        }else{
                            jugar(tablero, entrada);
                        }
                        break;
                    case 3:
                        if(juegoIniciado == false && juegoTerminado == false){
                            System.err.println("No hay ninguna partida iniciada");
                        }else if(juegoIniciado == true){
                            menuReportes(tablero,entrada,juegoIniciado,juegoTerminado);
                        }else if(juegoTerminado == true){
                            menuReportes(tablero,entrada,juegoIniciado,juegoTerminado);
                        }

                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        salir = false;
                        break;
                    default:
                        System.err.println("Las opciones son entre 1 y 4 ");
                }
            }catch (InputMismatchException e){
                System.err.println("Debes escribir una entrada válida ");
                entrada.next();
            }
        }
    }

    public static void menuReportes(String[] tablero, Scanner entrada, boolean juegoIniciado, boolean juegoTerminado){
        int opcion;
        boolean salir = true;

        while(salir != false){

            System.out.println("\n\t .:REPORTES:.");
            System.out.println("1. REPORTE 1 (OPERACIONES HECHAS DURANTE EL JUEGO)");
            System.out.println("2. REPORTE 2 (BITACORA DEL JUEGO)");
            System.out.println("3. Salir ");

            try{
                System.out.println("Introduce un número válido");
                opcion = entrada.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("SE GENERÓ EL REPORTE #1");
                        r1.crearArchivo();
                        r1.escribirEnArchivo(reporte1Opciones,reporte1Datos);
                        break;
                    case 2:
                        System.out.println("SE GENERÓ EL REPORTE #2");
                        break;
                    case 3:
                        menuPrincipal(tablero, entrada, juegoIniciado, juegoTerminado);
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        salir = false;
                        break;
                    default:
                        System.err.println("Las opciones son entre 1 y 3 ");
                }

            }catch (InputMismatchException e){
                System.err.println("Debes escribir una entrada válida ");
                entrada.next();
            }
        }
    }

    public static void inicializar(String[] tablero, Scanner entrada){
       try{
          r1.eliminarArchivo();
       }catch (NullPointerException e){
           System.out.println("No existe el archivo");
       }
        llenarTablero(tablero);
        tablero[127] = "|    @    |";
        llenarTableroPenalizaciones(tablero);
        contarPenalizaciones(tablero);
        jugar(tablero, entrada);
    }

    public static void llenarTableroPenalizaciones(String[] tablero){
        int contadorFilas = 8;
        while(contadorFilas > 0){

            if(contadorFilas == 8){
                Penalización(tablero,8,16);
                contadorFilas--;
            }
            if(contadorFilas == 7){
                Penalización(tablero,24,32);
                contadorFilas--;
            }
            if(contadorFilas == 6){
                Penalización(tablero,40,48);
                contadorFilas--;
            }
            if(contadorFilas == 5){
                Penalización(tablero,56,64);
                contadorFilas--;
            }
            if(contadorFilas == 4){
                Penalización(tablero,72,80);
                contadorFilas--;
            }

            if(contadorFilas == 3){
                Penalización(tablero,88,96);
                contadorFilas--;
            }

            if(contadorFilas == 2){
                Penalización(tablero,104,112);
                contadorFilas--;
            }
            if(contadorFilas == 1){
                Penalización(tablero,120,127);
                contadorFilas--;
            }

        }
    }

    public static void Penalización(String[] array, int rangoMin, int rangoMax){
        int contador;
        contador = numeroAleatorio(2,4);
        while(contador >= 0){
            array[numeroAleatorio(rangoMin,rangoMax)] = "|    #    |";
            contador--;
        }
    }

    public static void jugar(String[] tablero, Scanner entrada){
        char opcion;
        do{
            mostrarTablero(tablero);
            System.out.println("\n\t .:EN PARTIDA:.");
            System.out.println("D. Tirar Dado");
            System.out.println("P. Pausar ");
            System.out.println("Digite una de las opciones de arriba ");
            opcion = entrada.next().toUpperCase().charAt(0);
            switch (opcion){
                case 'D':
                    if(tablero[8] != "|    @    |" ){
                        bitacora[0] += 1;
                        tirarDado(tablero);
                    }else{
                        System.out.println("LA PARTIDA HA FINALIZADO, NO SE PUEDEN TIRAR DADOS");
                        System.out.println("Turnos jugados hasta terminar el juego fueron " + bitacora[0]);
                        menuPrincipal(tablero,entrada,false,true);
                    }
                    break;
                case 'P':
                    menuPrincipal(tablero,entrada,true,false);
                    break;
                default:
                    System.err.println("\nINGRESE UNA OPCIÓN VÁLIDA DEL MENÚ");
            }
        }while(opcion != 'P');
    }

    public static void tirarDado(String[] tablero){
        int numeroDado = numeroAleatorio(1,7);
        System.out.println("EL NÚMERO DEL DADO FUE: " + numeroDado);
        moverFicha(tablero,numeroDado);
    }

    public static void moverFicha(String[] tablero, int numeroDado){
        int posActual = buscarJugador(tablero);

        int min = 0, inter = 0, max = 0;
        int posAux = posActual;

        if(posActual >= 112 && posActual <= 127){
            min = 112;
            inter = 120;
            max = 127;
        }else if(posActual >= 96 && posActual <= 111){
            min = 96;
            inter = 104;
            max = 111;
        }else if(posActual >= 80 && posActual <= 95){
            min = 80;
            inter = 88;
            max = 95;
        }else if(posActual >= 64 && posActual <= 79){
            min = 64;
            inter = 72;
            max = 79;
        }else if(posActual >= 48 && posActual <= 63){
            min = 48;
            inter = 56;
            max = 63;
        }else if(posActual >= 32 && posActual <= 47){
            min = 32;
            inter = 40;
            max = 47;
        }else if(posActual >= 16 && posActual <= 31){
            min = 16;
            inter = 24;
            max = 31;
        }else if(posActual >= 0 && posActual <= 15){
            min = 0;
            inter = 8;
            max = 15;
        }

        int posPrueba = (posActual - numeroDado);
        if(posPrueba <  8 ){
            //Si el dado se pasa de la última posición válida no hace nada, se queda donde estaba
            tablero[posAux] = "|    @    |";
        }else if(posPrueba >= 8){
            //Esto es si le toca una posición que está en la línea siguiente
            if(posPrueba >= min && posPrueba < inter){
                int diferencia = (posActual - inter);
                tablero[posActual] = "|         |";
                //Se ubica en la última posición de la fila
                posActual = inter;
                numeroDado = ((numeroDado - diferencia)  + 8 );
                posActual -= numeroDado;
                if(tablero[posActual] == "|    #    |"){
                    tablero[posActual] = "|    @    |";
                    validarPenalizacion(posActual);
                }else{
                    tablero[posActual] = "|    @    |";
                }
            }else{
                //Esto es sí está dentro de la línea válida por donde se mueve la ficha
                if(posActual >= inter && posActual <= max){
                    tablero[posActual] = "|         |";
                    //Simplemente hace la resta a la posición y se mueve la ficha
                    posActual -= numeroDado;
                    if(tablero[posActual] == "|    #    |"){
                        tablero[posActual] = "|    @    |";
                        validarPenalizacion(posActual);
                    }else{
                        if(posActual != 8){
                            tablero[posActual] = "|    @    |";
                        }else if(posActual == 8){
                            tablero[8] = "|    @    |";
                        }
                    }

                }
            }
        }
    }

    public static void validarPenalizacion(int posActual){
        int opcRandom;
        if( (posActual >= 104 && posActual <= 127 ) && (contFacil < 2)){
            System.out.println("\n\n\tHA CAÍDO EN UNA PENALIZACIÓN!");
            System.out.println("PROBLEMA FÁCIL: LEY DE COSENOS");
            contFacil+=1;
            opcRandom = numeroAleatorio(1,4);
            System.out.println("LA OPCIÓN FUE: " + opcRandom);
            reporte1Opciones[indiceReporte1++] = opcRandom;
            opearacionFacil(opcRandom);
            System.out.println("CONTADOR DE PENALIZACIONES FÁCILES " + contFacil);
        }
        if( (posActual >= 48 && posActual <= 95 ) && (contInter < 2 )){
            System.out.println("\n\n\tHA CAÍDO EN UNA PENALIZACIÓN!");
            System.out.println("PROBLEMA INTERMEDIO: SUMA DE MATRICES");
            contInter +=1;
            opcRandom = numeroAleatorio(1,4);
            System.out.println("LA OPCIÓN FUE: " + opcRandom);
            operacionIntermedia(opcRandom);
            System.out.println("CONTADOR DE PENALIZACIONES INTERMEDIAS " + contInter);
        }
        if( (posActual >= 0 && posActual <= 47 ) && (contDif < 2)){
            System.out.println("\n\n\tHA CAÍDO EN UNA PENALIZACIÓN!");
            System.out.println("PROBLEMA DIFÍCIL: DIVISIÓN ENTRE MATRICES");
            contDif += 1;
            opcRandom = numeroAleatorio(1,4);
            System.out.println("LA OPCIÓN FUE: " + opcRandom);
            operacionDificil(opcRandom);
            System.out.println("CONTADOR DE PENALIZACIONES DIFÍCILES " + contDif);
        }
    }

    public static int buscarJugador(String[] tablero){
        for(int i = 0; i < tablero.length ; i++){
            if(tablero[i].equals("|    @    |")){
                return i;
            }
        }
        return -1;
    }

    public static void contarPenalizaciones(String[] tablero){
        for(int i = 0; i < tablero.length ; i++){
            if(tablero[i].equals("|    #    |")){
                bitacora[1] +=1;
            }
        }
    }

    public static void mostrarTablero(String[] a){
        for(int i = 0; i < a.length ; i++){
            if(i%8==0){
                System.out.println(" ");
            }
            System.out.print(a[i]);
        }

    }

    public static void llenarTablero(String[] a){
        int numeracion = 64;
        Random random = new Random();

        for(int i = 0; i < a.length ; i++){

            if(i >= 0 && i <= 7){
                a[i] = "|-------" + (numeracion--)+ "|";
            }
            if(i >= 8 && i <= 15){
                a[i] = "|         |";
            }
            if(i >= 16 && i <= 23){
                a[i] = "|-------" + (numeracion--)+ "|";
            }
            if(i >= 24 && i <= 31){
                a[i] = "|         |";
            }
            if(i >= 32 && i <= 39){
                a[i] = "|-------" + (numeracion--)+ "|";
            }
            if(i >= 40 && i <= 47){
                a[i] = "|         |";
            }
            if(i >= 48 && i <= 55){
                a[i] = "|-------" + (numeracion--)+ "|";
            }
            if(i >= 56 && i <= 63){
                a[i] = "|         |";
            }
            if(i >= 64 && i <= 71){
                a[i] = "|-------" + (numeracion--)+ "|";
            }
            if(i >= 72 && i <= 79){
                a[i] = "|         |";
            }

            if(i >= 80 && i <= 87){
                a[i] = "|-------" + (numeracion--)+ "|";
            }
            if(i >= 88 && i <= 95){
                a[i] = "|         |";
            }
            if(i >= 96 && i <= 103){
                a[i] = "|-------" + (numeracion--)+ "|";
                if(i == 103){
                    a[i] = "|--------" + (++numeracion) + "|";
                }
            }
            if(i >= 104 && i <= 111){
                a[i] = "|         |";
            }
            if(i >= 112 && i <= 119){
                a[i] = "|--------" + (--numeracion)+ "|";
            }
            if(i >= 120 && i <= 127){
                a[i] = "|         |";
            }

        }
    }

    public static int numeroAleatorio(int min, int max){
        //valor entre min y max sin incluir max
        Random random = new Random();
        int randomInt = min + random.nextInt(max-min);
        return randomInt;
    }

    public static void opearacionFacil(int opcion){
        double a,b,c, alfa, gamma, beta;
        DecimalFormat df = new DecimalFormat("###.###");
        if(opcion == 1){
            a = 15; c = 20; alfa = Math.toRadians(25);
            reporte1Datos[0][0][0] = a;
            reporte1Datos[0][0][1] = c;
            reporte1Datos[0][0][2] = alfa;
            b = Math.sqrt(Math.pow(a,2) + Math.pow(c,2) - 2*(a)*(c)*Math.cos(alfa));
            beta = (Math.acos(-((Math.pow(a,2) - Math.pow(b,2) - Math.pow(c,2))/(2*b*c))));
            gamma = (Math.acos(-((Math.pow(c,2) - Math.pow(a,2) - Math.pow(b,2))/(2*a*b))));
            System.out.println(
                    "----------------------------------------------------- \n" +
                            "||Operación realizada con éxito los resultados son: \n" +
                            "||El lado B: " + df.format(b) +  " unidades\n" +
                            "||El ángulo beta: " + df.format(Math.toDegrees(beta))  +  " grados\n" +
                            "||El ángulo gamma: " + df.format(Math.toDegrees(gamma)) + " grados\n" +
                            "----------------------------------------------------- \n");
            reporte1Datos[0][0][3] = Double.parseDouble(df.format(b));
            reporte1Datos[0][0][4] = Double.parseDouble(df.format(Math.toDegrees(beta)));
            reporte1Datos[0][0][5] = Double.parseDouble(df.format(Math.toDegrees(gamma)));
            bitacora[2] +=1;
        }else if(opcion == 2){
            b = 10; c = 25; beta = Math.toRadians(30);
            reporte1Datos[0][1][0] = b;
            reporte1Datos[0][1][1] = c;
            reporte1Datos[0][1][2] = beta;
            a = Math.sqrt(Math.pow(b,2) + Math.pow(c,2) - 2*(b)*(c)*Math.cos(beta));
            alfa = (Math.acos(-((Math.pow(b,2) - Math.pow(a,2) - Math.pow(c,2))/(2*a*c))));
            gamma = (Math.acos(-((Math.pow(c,2) - Math.pow(a,2) - Math.pow(b,2))/(2*a*b))));
            System.out.println(
                    "---------------------------------------------------------\n" +
                            "||Operación realizada con éxito los resultados son:\n" +
                            "||El lado A: " + df.format(a) +  " unidades\n" +
                            "||El ángulo alfa: " + df.format(Math.toDegrees(alfa))  +  " grados\n" +
                            "||El ángulo gamma: " + df.format(Math.toDegrees(gamma))  + " grados\n" +
                            "---------------------------------------------------------\n");
            reporte1Datos[0][1][3] = Double.parseDouble(df.format(a));
            reporte1Datos[0][1][4] = Double.parseDouble(df.format(Math.toDegrees(alfa)));
            reporte1Datos[0][1][5] = Double.parseDouble(df.format(Math.toDegrees(gamma)));
            bitacora[2] +=1;
        }else if(opcion == 3){
            a = 18; b = 25; gamma = Math.toRadians(30);
            reporte1Datos[0][2][0] = a;
            reporte1Datos[0][2][1] = b;
            reporte1Datos[0][2][2] = gamma;
            c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2) - 2*(a)*(b)*Math.cos(gamma));
            alfa = (Math.acos(-((Math.pow(b,2) - Math.pow(a,2) - Math.pow(c,2))/(2*a*c))));
            beta = (Math.acos(-((Math.pow(a,2) - Math.pow(b,2) - Math.pow(c,2))/(2*b*c))));
            System.out.println(
                    "---------------------------------------------------------\n" +
                            "||Operación realizada con éxito los resultados son:\n" +
                            "||El lado C: " + df.format(c) +  " unidades\n" +
                            "||El ángulo alfa: " + df.format(Math.toDegrees(alfa)) +  " grados\n" +
                            "||El ángulo beta: " + df.format(Math.toDegrees(beta)) + " grados\n" +
                            "---------------------------------------------------------\n");
            reporte1Datos[0][2][3] = Double.parseDouble(df.format(c));
            reporte1Datos[0][2][4] = Double.parseDouble(df.format(Math.toDegrees(alfa)));
            reporte1Datos[0][2][5] = Double.parseDouble(df.format(Math.toDegrees(beta)));
            bitacora[2] +=1;
        }
    }

    public static void operacionIntermedia(int opcion){
        if(reporte1Opciones[1] == 0){
            reporte1Opciones[1] = -1;
            indiceReporte1 = 2;
            reporte1Opciones[indiceReporte1] = opcion;
        }else{
            reporte1Opciones[indiceReporte1] = opcion;
        }
        if(opcion == 1){
            double[][] matrizA = {{7,48,5,0,1}, {57,8,4,6,14}, {0,5,6,78,15}, {21,14,8,19,54},{32,20,26,47,12}};
            double[][] matrizB = {{9,5,2,1,8}, {4,2,3,47,8}, {48,55,32,19,6}, {7,56,32,14,8}, {32,87,0,1,7}};
            reporte1Datos[1] = matrizA;
            reporte1Datos[2] = matrizB;
            if(matrizValida(matrizA,matrizB) && validarTamañoMatriz(matrizA,matrizB)){
                double[][] matrizR = new double[matrizA.length][matrizB[0].length];
                for(int i = 0; i < matrizA.length; i++){
                    for(int j = 0; j < matrizA[0].length; j++){
                        matrizR[i][j] += matrizA[i][j] + matrizB[i][j];
                    }
                }
                reporte1Datos[3] = matrizR;
                System.out.println("OPERACIÓN REALIZADA CON ÉXITO! ");
                System.out.println("LA MATRIZ RESULTANTE ES: ");
                mostrarMatriz(matrizR);
                indiceReporte1++;
                bitacora[2] +=1;
            }else{
                System.err.println("ERROR NO SE PUDO REALIZAR SUMA LAS MATRICES SON INVÁLIDAS");
                reporte1Opciones[indiceReporte1] = -2;
                indiceReporte1++;
                bitacora[3] +=1;
            }

        }else if(opcion == 2){
            double[][] matrizA = {{4,9,7,45,18}, {7,51,26,8,38}, {48,26,37,21,19}, {1,0,6,8,1},{2,19,55,25,15}};
            double[][] matrizB = {{0,2,15,1,66}, {21,48,62,7,33}, {4,88,0,68,4}, {25,18,24,7,55}, {24,15,36,5,98}};
            reporte1Datos[4] = matrizA;
            reporte1Datos[5] = matrizB;
            if(matrizValida(matrizA,matrizB) && validarTamañoMatriz(matrizA,matrizB)){
                double[][] matrizR = new double[matrizA.length][matrizB[0].length];
                for(int i = 0; i < matrizA.length; i++){
                    for(int j = 0; j < matrizA[0].length; j++){
                        matrizR[i][j] += matrizA[i][j] + matrizB[i][j];
                    }
                }
                reporte1Datos[6] = matrizR;
                System.out.println("OPERACIÓN REALIZADA CON ÉXITO! ");
                System.out.println("LA MATRIZ RESULTANTE ES: ");
                mostrarMatriz(matrizR);
                indiceReporte1++;
                bitacora[2] +=1;
            }else{
                System.err.println("ERROR NO SE PUDO REALIZAR SUMA LAS MATRICES SON INVÁLIDAS");
                reporte1Opciones[indiceReporte1] = -2;
                indiceReporte1++;
                bitacora[3] +=1;
            }
        }else if(opcion == 3){
            double[][] matrizA = {{0,1,15,5,36}, {1,78,65,32,4}, {48,66,39,0,55}, {14,98,63,20,15},{11,39,84,7,1}};
            double[][] matrizB = {{78,25,66,48,98}, {0,45,2,3,1}, {2,9,14,10,20}, {35,87,65,2,32}, {25,8,4,9,39}};
            reporte1Datos[7] = matrizA;
            reporte1Datos[8] = matrizB;
            if(matrizValida(matrizA,matrizB) && validarTamañoMatriz(matrizA,matrizB)){
                double[][] matrizR = new double[matrizA.length][matrizB[0].length];
                for(int i = 0; i < matrizA.length; i++){
                    for(int j = 0; j < matrizA[0].length; j++){
                        matrizR[i][j] += matrizA[i][j] + matrizB[i][j];
                    }
                }
                reporte1Datos[9] = matrizR;
                System.out.println("OPERACIÓN REALIZADA CON ÉXITO! ");
                System.out.println("LA MATRIZ RESULTANTE ES: ");
                mostrarMatriz(matrizR);
                indiceReporte1++;
                bitacora[2] +=1;
            }else{
                System.err.println("ERROR NO SE PUDO REALIZAR SUMA LAS MATRICES SON INVÁLIDAS");
                reporte1Opciones[indiceReporte1] = -2;
                indiceReporte1++;
                bitacora[3] +=1;
            }
        }
    }

    public static void operacionDificil(int opcion){
        double determinante;
        double[][][] AduntaCofactores;
        double[][] matrizAdjuntaT;
        double[][] matrizInversa, divisionMatrices;

        if(reporte1Opciones[3] == 0){
            reporte1Opciones[3] = -1;
            indiceReporte1 = 4;
            reporte1Opciones[indiceReporte1] = opcion;
        }else{
            reporte1Opciones[indiceReporte1] = opcion;
        }

        if(opcion == 1){
            double[][] matrizA = {{5,10,1,3}, {9,14,2,6}, {7,8,15,3}, {6,8,9,2}};
            double[][] matrizB = {{5,13,9,4}, {1,9,6,3}, {8,11,69,33}, {25,6,7,4}};
            /*En este caso se hace una doble validación, primero que sea una matriz válida
             y segundo que ambas matrices sean del mismo tamaño */
            if(matrizValida(matrizA,matrizB) && matrizCuadrada(matrizA,matrizB)){
                determinante = determinanteMatriz(matrizB);
                if(determinante != 0){
                    reporte1Datos[10] = matrizA;
                    reporte1Datos[11] = matrizB;
                    reporte1Datos[22][0][0] = determinante;
                    System.out.println("El determinante es : " + determinante);
                    AduntaCofactores = AdjuntaCofactores(matrizB);
                    matrizAdjuntaT = AdjuntaDeLaTraspuesta(AduntaCofactores);
                    matrizInversa = matrizInversa(matrizAdjuntaT,determinante);
                    reporte1Datos[12] = matrizInversa;
                    divisionMatrices = multiplicacionMatrices(matrizA,matrizInversa);
                    reporte1Datos[13] = divisionMatrices;
                    System.out.println("La división entre la matriz A y B es:");
                    mostrarMatriz(divisionMatrices);
                    indiceReporte1++;
                    bitacora[2] +=1;
                }else{
                    System.err.println("NO SE PUDO REALIZAR LA OPERACIÓN DETERMINANTE DE MATRIZ B IGUAL A 0");
                    reporte1Opciones[indiceReporte1] = -3;
                    indiceReporte1++;
                    bitacora[3] +=1;
                }
            }else{
                System.err.println("MATRIZ INVÁLIDA");
                reporte1Opciones[indiceReporte1] = -2;
                indiceReporte1++;
                bitacora[3] +=1;
            }

        }else if(opcion == 2){
            double[][] matrizA = {{1,12,9,8}, {7,6,3,2}, {0,5,6,14}, {6,9,6,10}};
            double[][] matrizB = {{8,19,20,4}, {12,33,6,8}, {4,5,9,7}, {8,22,14,6}};
            if(matrizValida(matrizA,matrizB) && matrizCuadrada(matrizA,matrizB)){
                determinante = determinanteMatriz(matrizB);
                if(determinante != 0){
                    reporte1Datos[14] = matrizA;
                    reporte1Datos[15] = matrizB;
                    reporte1Datos[22][0][1] = determinante;
                    System.out.println("El determinante es : " + determinante);
                    AduntaCofactores = AdjuntaCofactores(matrizB);
                    matrizAdjuntaT = AdjuntaDeLaTraspuesta(AduntaCofactores);
                    matrizInversa = matrizInversa(matrizAdjuntaT,determinante);
                    reporte1Datos[16] = matrizInversa;
                    divisionMatrices = multiplicacionMatrices(matrizA,matrizInversa);
                    reporte1Datos[17] = divisionMatrices;
                    System.out.println("La división entre la matriz A y B es:");
                    mostrarMatriz(divisionMatrices);
                    indiceReporte1++;
                    bitacora[2] +=1;
                }else{
                    System.err.println("NO SE PUDO REALIZAR LA OPERACIÓN DETERMINANTE DE MATRIZ B IGUAL A 0");
                    reporte1Opciones[indiceReporte1] = -3;
                    indiceReporte1++;
                    bitacora[3] +=1;
                }
            }else{
                System.err.println("MATRIZ INVÁLIDA");
                reporte1Opciones[indiceReporte1] = -2;
                indiceReporte1++;
                bitacora[3] +=1;
            }
        }else if(opcion == 3){
            double[][] matrizA = {{5,9,14,5}, {6,0,5,3}, {1,14,68,8}, {7,5,3,9}};
            double[][] matrizB = {{0,9,7,19}, {2,30,5,48}, {1,31,2,5}, {15,8,4,3}};
            if(matrizValida(matrizA,matrizB) && matrizCuadrada(matrizA,matrizB)){
                determinante = determinanteMatriz(matrizB);
                if(determinante != 0){
                    reporte1Datos[18] = matrizA;
                    reporte1Datos[19] = matrizB;
                    reporte1Datos[22][0][2] = determinante;
                    System.out.println("El determinante es : " + determinante);
                    AduntaCofactores = AdjuntaCofactores(matrizB);
                    matrizAdjuntaT = AdjuntaDeLaTraspuesta(AduntaCofactores);
                    matrizInversa = matrizInversa(matrizAdjuntaT,determinante);
                    reporte1Datos[20] = matrizInversa;
                    divisionMatrices = multiplicacionMatrices(matrizA,matrizInversa);
                    reporte1Datos[21] = divisionMatrices;
                    System.out.println("La división entre la matriz A y B es:");
                    mostrarMatriz(divisionMatrices);
                    indiceReporte1++;
                    bitacora[2] +=1;
                }else{
                    System.err.println("NO SE PUDO REALIZAR LA OPERACIÓN DETERMINANTE DE MATRIZ B IGUAL A 0");
                    reporte1Opciones[indiceReporte1] = -3;
                    indiceReporte1++;
                }
            }else{
                System.err.println("ERROR MATRIZ INVÁLIDA");
                reporte1Opciones[indiceReporte1] = -2;
                indiceReporte1++;
                bitacora[3] +=1;
            }
        }
    }

    public static void mostrarMatriz(double[][] matriz){
        DecimalFormat df = new DecimalFormat("###.###");
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                System.out.print("\t" + df.format(matriz[i][j]));
            }
            System.out.println(" ");
        }
    }

    public static boolean validarTamañoMatriz(double[][] matrizA, double[][] matrizB){
        if((matrizA.length == matrizB.length) && (matrizA[0].length == matrizB[0].length)){
            return true;
        }
        return false;
    }

    public static boolean matrizValida(double[][] matrizA, double[][] matrizB){
        for(int i = 0; i < matrizA.length; i++) {
            if(!(matrizA[0].length == matrizA[i].length)){
                return false;
            }
        }
        for(int i = 0; i < matrizB.length; i++) {
            if(!(matrizB[0].length == matrizB[i].length)){
                return false;
            }
        }
        return  true;
    }

    public static boolean matrizCuadrada(double[][] matrizA, double[][] matrizB){
        if(!(matrizA.length == matrizA[0].length)){
            return false;
        }
        if(!(matrizB.length == matrizB[0].length)){
            return false;
        }
        return true;
    }

    public static double determinanteMatriz(double[][] matriz) {
        double determinante;
        //Realiza la matriz de cofactores pero solamente de la primera fila
        double[][][] matricesCofactores;
        //En un arreglo se almacenan los determinantes de las 4 matrices de 3x3
        double[] determinantes3x3;
        //pasa a la función para sacar los cofactores usando la primera fila
        matricesCofactores = matrizdeCofactores(matriz);
        //Por ley de Sarrus se saca el determinante de las 4 matrices de cofactores
        determinantes3x3 = determinantesSarrus(matricesCofactores);
        //Aquí se saca el determinante mediante el teorema de Laplace para determinantes
        determinante = ((matriz[0][0]*determinantes3x3[0]) - (matriz[0][1]*determinantes3x3[1])
                + (matriz[0][2]*determinantes3x3[2]) - (matriz[0][3]*determinantes3x3[3]));
        return determinante;
    }

    public static double[] determinantesSarrus(double[][][] C){
        double[] determinantesSarrus = new double[C.length];
        for(int i = 0; i < C.length; i++){
            determinantesSarrus[i] =
                    (C[i][0][0]*C[i][1][1]*C[i][2][2] + C[i][1][0]*C[i][2][1]*C[i][0][2] +
                            C[i][0][1]*C[i][1][2]*C[i][2][0] - C[i][0][2]*C[i][1][1]*C[i][2][0] -
                            C[i][0][1]*C[i][1][0]*C[i][2][2] -  C[i][1][2]*C[i][2][1]*C[i][0][0]
                    );
        }
        return determinantesSarrus;
    }

    public static double determinantesSarrusV2(double[][][] C,int i){
        /*Lo usamos para sacar la matriz Adjunta, se calcula el determinante de cada matriz de cofactores por el
         método de Sarrus*/
        double determinante;
        determinante =
                (C[i][0][0]*C[i][1][1]*C[i][2][2] + C[i][1][0]*C[i][2][1]*C[i][0][2] +
                        C[i][0][1]*C[i][1][2]*C[i][2][0] - C[i][0][2]*C[i][1][1]*C[i][2][0] -
                        C[i][0][1]*C[i][1][0]*C[i][2][2] -  C[i][1][2]*C[i][2][1]*C[i][0][0]
                );
        return determinante;
    }

    public static double[][][] matrizdeCofactores(double[][] matriz) {
        /*La utilizamos para sacar la matriz de cofactores usando sólo la primera fila que más adelante nos
        Ayudará a sacar el determinante de la matriz inicial*/
        double[][][] matrices3x3 = new double[4][][];
        for( int contador = 0; contador < 4;contador++) {
            double[][] prueba = new double[3][3];
            int fila = 0, columna = 0;
            //Ignora la primera fila (fila 0) empieza siempre desde la primera y saca los cofactores de las columnas
            for (int i = 1; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if(j != contador){
                        prueba[i-1][columna++] = matriz[i][j];
                    }
                }
                columna = 0;
            }
            matrices3x3[contador] = prueba;
        }

        return matrices3x3;
    }

    public static double[][][] AdjuntaCofactores(double[][] matriz) {
        double[][][] matrices3x3 = new double[16][][];
        int indice = 0;
        for(int contador2 = 0; contador2 < 4 ; contador2++){
            for( int contador = 0; contador < 4;contador++) {
                double[][] prueba = new double[3][3];
                int fila = 0, columna = 0;
                for (int i = 0; i < matriz.length; i++) {
                    //Ignora la fila
                    if(i != contador2){
                        for (int j = 0; j < matriz[i].length; j++) {
                            //Ignora la columna
                            if(j != contador){
                                prueba[fila][columna++] = matriz[i][j];
                            }
                        }
                        columna = 0;
                        fila++;
                    }
                }
                matrices3x3[indice] = prueba;
                indice++;
            }
        }
        return matrices3x3;
    }

    public static double[][] AdjuntaDeLaTraspuesta(double[][][] C){
        double[][] matrizAdjunta = new double[4][4];
        int indice = 0;
        for(int i = 0; i < matrizAdjunta.length; i++){
            for(int j = 0; j < matrizAdjunta[i].length; j++){
                double sumaIndices = 2+i+j;
                /*Se traspone de una vez aquí matrizAdjunta[0][0] = C[0]
                  La razón es la forma en que los valores se están guardando dentro de la matrizAdjunta
                 */
                matrizAdjunta[i][j] = ((int)Math.pow(-1,sumaIndices))*determinantesSarrusV2(C,indice);
                indice++;
            }
        }
        //Aquí ya obtenemos la adjunta de la traspuesta
        return matrizAdjunta;
    }

    public static double[][] matrizInversa(double[][] matriz, double determinante){
        double[][] matrizInversa = new double[matriz.length][matriz[0].length];
        double det = Math.abs(determinante);
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                matrizInversa[i][j] = ((double)(matriz[i][j])/det);
            }
        }
        matrizInversa = trasponerInversa(matrizInversa);
        return matrizInversa;
    }

    public static double[][] trasponerInversa(double[][] matriz){
        double aux;
        for(int i = 0; i < matriz.length ; i++){
            for(int j = 0; j < i ;j++){
                aux = matriz[i][j];
                matriz[i][j] = matriz[j][i];
                matriz[j][i] = aux;
            }
        }
        return matriz;
    }

    public static double[][] multiplicacionMatrices(double[][] matrizA, double[][] matrizB){
        double[][] multi = new double[4][4];
        for(int i = 0; i < matrizA.length; i++){
            for(int j = 0; j < matrizB[0].length; j++){
                for(int k = 0; k < matrizA[0].length; k++){
                    multi[i][j] += (-1)* matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        return multi;
    }
}
