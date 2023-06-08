import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x; // 총 금액 x
        int n; // 구매한 물건의 종류의 수 n
        int a; // 물건의 가격 a
        int b; // 물건의 개수 b

        
        x = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        int sum=0; // 영수증에 적힌 물건들의 합
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sum += a*b;
        }

        if(x == sum) { // 총 금액 x 와 물건들의 합 sum이 같다면
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
