import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        
        br.close();
        bw.write(String.valueOf((str.equalsIgnoreCase(new StringBuffer(str).reverse().toString())) ? 1 : 0));
        bw.flush();
        bw.close();
    }   
}
