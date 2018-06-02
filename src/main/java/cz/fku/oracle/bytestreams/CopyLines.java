package cz.fku.oracle.bytestreams;

import java.io.*;

import static cz.fku.oracle.bytestreams.Constant.INPUT_FILE;
import static cz.fku.oracle.bytestreams.Constant.OUTPUT_FILE;

public class CopyLines {
    public static void main(String[] args) throws IOException {
        System.out.println("test");

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(INPUT_FILE));
            outputStream = new PrintWriter(new FileWriter(OUTPUT_FILE));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
