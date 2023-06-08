import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());;
        int[] list = new int[n];
        
        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(list);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(list[0] + " " + list[n-1]);
        bw.flush();
        bw.close();
    }
}
