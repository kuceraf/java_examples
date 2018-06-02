package cz.fku.oracle.bytestreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("E:\\Development\\git_project\\java_examples\\src\\main\\java\\cz\\fku\\oracle\\bytestreams\\xanadu.txt");
            outputStream = new FileWriter("E:\\Development\\git_project\\java_examples\\src\\main\\java\\cz\\fku\\oracle\\bytestreams\\outagain.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
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

