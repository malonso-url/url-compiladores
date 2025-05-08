package edu.url;

import org.antlr.v4.runtime.CharStreams;

import edu.url.antlr.variablesLexer;
import edu.url.antlr.variablesParser;
import edu.url.interpreter.Environment;
import edu.url.interpreter.VariableSegment;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class G4Parser {
    
    public static String parse(String code){
        // Crear lexer y parser
        variablesLexer lexer = new variablesLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        variablesParser parser = new variablesParser(tokens);

        // Obtener el árbol de sintaxis
        ParseTree tree = parser.start();

        String codigoIntermedio = "";

        // Usar el visitor
        Environment visitor = new Environment(codigoIntermedio);
        VariableSegment programa = visitor.visit(tree);

        return visitor.programa;
    }
}
