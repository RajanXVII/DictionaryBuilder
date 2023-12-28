package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExtractWords {

    public static void main(String[] args) throws IOException {

        String text = "";
        PDDocument document = PDDocument.load(new File("/Users/a200143684/Documents/vocab/barrons/333/barrons-333-high-freq-words-with-meanings.pdf"));
        if (!document.isEncrypted()) {
            PDFTextStripper stripper = new PDFTextStripper();
             text = stripper.getText(document);
           // System.out.println("Text:" + text);
        }
        FileOutputStream fs1 = new FileOutputStream(new File("/Users/a200143684/Documents/vocab/barrons/333/content.txt"));
        fs1.write(text.getBytes("UTF-8"));
        document.close();


        BufferedReader is = new BufferedReader( new FileReader(new File("/Users/a200143684/Documents/vocab/barrons/333/content.txt")));
        StringBuilder word = new StringBuilder();
        StringBuilder meaning = new StringBuilder();
        String dummy = "";
        String[] splittedStr ;
        dummy = is.readLine();
        while(!Objects.isNull(dummy)){

                splittedStr = dummy.split(" ", 2);
                if (splittedStr.length >= 2) {
                    word.append(splittedStr[0] + "\n");
                    meaning.append(splittedStr[1] + "\n");
                }
            dummy = is.readLine();
            }

        FileOutputStream fs3 = new FileOutputStream(new File("/Users/a200143684/Documents/vocab/barrons/333/word.txt"));
        FileOutputStream fs2 = new FileOutputStream(new File("/Users/a200143684/Documents/vocab/barrons/333/meaning.txt"));
        fs3.write(word.toString().getBytes("UTF-8"));
        fs2.write(meaning.toString().getBytes("UTF-8"));

    }
}
