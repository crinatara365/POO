package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    public void Print(String text, int option, File file) throws IOException {
        if(option == 0)
            /* se afiseaza in consola */
            System.out.println(text);
        else {
            /* se afiseaza in fisier */
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(text);
            writer.close();
        }
    }
}

