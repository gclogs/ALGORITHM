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

        int[] bucket = new int[101]; // 1 < n < 101 (0은 제외하고)
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) { // 바구니에 공을 채움
            bucket[i] = i;
        }

        int a,b,tmp;
        for(int i = 0; i < m; i++) {    // m개의 줄만큼 순회 (이때 i=0이 아님)
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());   // a번 바구니
            b = Integer.parseInt(st.nextToken());   // b번 바구니
            
            tmp = bucket[a];        // 임시 바구니 <- a번 바구니(공)
            bucket[a] = bucket[b];  // a번 바구니 <- b번 바구니(공)
            bucket[b] = tmp;        // b번 바구니 <- 임시 바구니(공)
        }
        br.close();
        

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= n; i++) {
            bw.write(bucket[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}