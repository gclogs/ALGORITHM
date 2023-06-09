import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // [TIP] 10818번: 공 바꾸기와 비슷함
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] basket = new int[n+1]; // 1 < n < 101 (0은 제외하고)
        for(int i = 1; i <= n; i++) { // 바구니에 번호를 적음
            basket[i] = i;
        }

        int a,b,tmp;
        for(int i = 0; i < m; i++) {    // m개의 줄만큼 순회
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());   // a번 바구니
            b = Integer.parseInt(st.nextToken());   // b번 바구니
            
            while(a < b) {  // a가 b보다 작다면
                tmp = basket[a];          // 임시 바구니 <- a번 바구니
                basket[a++] = basket[b];  // a번 바구니 <- b번 바구니
                basket[b--] = tmp;        // b번 바구니 <- 임시 바구니
            }
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= n; i++) {
            bw.write(basket[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}