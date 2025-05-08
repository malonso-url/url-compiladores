package edu.url;

import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.antlr.v4.runtime.CharStreams;

import edu.url.antlr.variablesLexer;
import edu.url.antlr.variablesParser;
import edu.url.interpreter.Environment;
import edu.url.interpreter.VariableSegment;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Ingrese el path del archivo: " );
        Scanner in = new Scanner(System.in);
        String programa = readFileAsString(in.nextLine());

        String codigo_java = G4Parser.parse(programa);
        String nombre_archivo = codigo_java.substring(0, codigo_java.indexOf("{")).replace("public class ", "");
        System.out.println(codigo_java);

        guardarContenidoEnArchivoJava(codigo_java, nombre_archivo);

        in.close();
    }

    public static void guardarContenidoEnArchivoJava(String contenido, String nombreArchivo) {
        String nombreCompleto = nombreArchivo + ".java";
        try (FileWriter escritor = new FileWriter(nombreCompleto)) {
            escritor.write(contenido);
            System.out.println("El contenido se ha guardado correctamente en el archivo: " + nombreCompleto);
        } catch (IOException e) {
            System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static String readFileAsString(String filePath) {
        Path path = Paths.get(filePath);
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }
}
