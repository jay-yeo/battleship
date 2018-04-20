package com.matritellabs.utama.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LineByLineReader {

    private BufferedReader myReader;

    public LineByLineReader() {
        myReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLineFromStdIn() {
        try {
            return myReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
