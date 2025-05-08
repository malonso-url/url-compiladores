package edu.url;

import java.io.Console;
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

        System.out.println(G4Parser.parse(programa));
        in.close();
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
