import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] li = new int[101]; 
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int i,j,k,idx;
        while(m > 0) {
            st = new StringTokenizer(br.readLine());

            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            for(idx = i; idx <= j; ++idx) li[idx] = k;
            m--;
        }
        
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(idx = 1; idx <= n; ++idx) bw.write(li[idx] + " ");
        bw.flush();
        bw.close();
    }
}