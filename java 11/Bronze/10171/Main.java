import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("\\    /\\" + "\n"
                + " )  ( ')" + "\n"
                + "(  /  )" + "\n"
                + " \\(__)|");
        bw.flush();
        bw.close();
    }
}