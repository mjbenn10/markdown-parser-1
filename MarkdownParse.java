//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            // if markdown.indexOf() returns -1 then set currentIndex = 0
            if(openBracket==-1 || closeBracket==-1 || openParen==-1 || closeParen==-1) {
                break;
            }
            /* Now that we have found positions of all the ()[] we can change
            the value of current index freely without affecting any of our other
            checks */
            currentIndex = closeParen + 1;
            
            // Check if there is text between openBracket and closeBracket
            if(openBracket+1 == closeBracket) {
                continue;
            }
            // Check if there is text between openParen and closeParen
            if(openParen+1 == closeParen) {
                continue;
            }
            // Check if there is no space between closeBracket and openParen
            if(closeBracket+1 != openParen) {
                continue;
            }
            // Check if there is no '!' before openBracket
            if(openBracket!=0) {
                if(markdown.charAt(openBracket-1) == '!') {
                    continue;
                }
            }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
