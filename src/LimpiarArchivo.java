import java.io.*;

public class LimpiarArchivo {

    public static void main(String[] args) {

        /* TODO 1: Validar los argumentos (debe haber 2: entrada y salida).
           - Si no son correctos, mostrar:
             "Uso: java limpiararchivo <entrada.txt> <salida.txt>"
           - Terminar el programa si faltan.
        */

        /* TODO 2: Obtener las rutas de entrada y salida desde args[0] y args[1]. */

        /* TODO 3: Abrir los flujos.
           - Crear BufferedReader envolviendo un FileReader con la ruta de entrada.
           - Crear BufferedWriter envolviendo un FileWriter con la ruta de salida (sobrescribe).
           - Guardar las referencias para cerrarlas manualmente después.
        */

        /* TODO 4: Leer línea a línea con readLine().
           - Patrón: leer primera línea; mientras no sea null, procesar; luego leer la siguiente.
        */

        /* TODO 5: Procesamiento por línea.
           - Aplicar trim() para quitar espacios al inicio y final.
           - Si la línea queda vacía o empieza por "#", saltarla (continue).
           - Llevar un contador de líneas válidas (empieza en 1).
           - Escribir en el BufferedWriter el formato: n + "\t" + contenido, seguido de newLine().
        */

        /* TODO 6: Al terminar el bucle, llamar a flush() para asegurar que todo se escribe. */

        /* TODO 7: Manejar IOException con try-catch alrededor de la lógica principal.
           - Mostrar un mensaje simple si ocurre un error de E/S.
        */

        /* TODO 8: Cerrar manualmente los recursos en un bloque finally.
           - Cerrar primero el BufferedWriter y luego el BufferedReader.
           - Cada close() envuelto en su propio try-catch para evitar fallos en cascada.
        */

        /* TODO 9 (opcional): Imprimir un resumen final:
           - Total de líneas escritas y la ruta del archivo de salida.
        */

        if (args[0] == null || args[1] == null) {
            System.out.println("Uso: java limpiararchivo <entrada.txt> <salida.txt>");
        } else {
            String rutaEntrada = args[0];
            String rutaSalida = args[1];


            try {
                BufferedReader fbr = new BufferedReader(new FileReader(rutaEntrada));
                BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaSalida));

                    try {
                        String linea = fbr.readLine();
                        int contadorLineasValidas = 1;

                        while (linea != null) {
                            linea = linea.trim();
                            if (linea.isEmpty() || linea.startsWith("#")) {
                                linea = fbr.readLine();
                                continue;
                            }
                            escritor.write(contadorLineasValidas + "\t" + linea);
                            escritor.newLine();
                            contadorLineasValidas++;
                            linea = fbr.readLine();
                        }
                        escritor.flush();

                        System.out.printf("Total de líneas escritas: %d en el archivo %s%n", contadorLineasValidas - 1, rutaSalida);
                    } catch (IOException e) {
                        System.out.println("Error de E/S: " + e.getMessage());
                    } finally {
                        try {
                            if (escritor != null) {
                                escritor.close();
                            }
                        } catch (IOException e) {
                            System.out.println("Error al cerrar el escritor: " + e.getMessage());
                        }
                        try {
                            if (fbr != null) {
                                fbr.close();
                            }
                        } catch (IOException e) {
                            System.out.println("Error al cerrar el lector: " + e.getMessage());
                        }
                    }

            } catch (IOException e) {
                System.out.println("Error al abrir los archivos: " + e.getMessage());
            }
        }
    }
}