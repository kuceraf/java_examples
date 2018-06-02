package cz.fku.oracle.bytestreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static cz.fku.oracle.bytestreams.Constant.INPUT_FILE;
import static cz.fku.oracle.bytestreams.Constant.OUTPUT_FILE;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(INPUT_FILE);
            out = new FileOutputStream(OUTPUT_FILE);
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
