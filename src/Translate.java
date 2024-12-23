import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;

public class Translate {
    public static void main(String[] args) throws Exception {
        String inputFile = "C:\\Users\\sdzim\\IdeaProjects\\untitled2\\src\\test.g";
        if (args.length > 0)
            inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) is = new FileInputStream(inputFile);

        CharStream input = CharStreams.fromFileName(inputFile);
        gLexer lexer = new gLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        gParser parser = new gParser(tokens);
        ParseTree tree = parser.prog(); // parse
        // Create a generic parse tree walker that can trigger callbacks
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(new CodeTranslateListener(), tree);
        System.out.println();
    }
}
