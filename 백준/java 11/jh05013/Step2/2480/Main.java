import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        // 1. 같은 눈이 3개가 나오는 경우
        if(a==b && b==c) {
            System.out.println( 10000 + a * 1000); // 3가지 경우 모두 같이 때문에 a,b,c중 하나의 변수만 사용하여 곱해도 됨
        
        // 2.같은 눈이 2개가 나오는 경우
        // 같은 눈이 2개인 경우는 a,b,c 중 2개가 같은 경우이기 때문에 2개의 변수가 똑같으므로 3개중 2개를 택하여 곱해주면 됨
        } else if(a==b || b==c) {
            System.out.println( 1000 + b * 100);
        } else if(c==a) {
            System.out.println( 1000 + c * 100);
        // 3.모두 다른 눈이 나오는 경우
        } else {
            if(a > b && a > c) System.out.println(a * 100); // a가 가장 큰 경우
            else if(b > a && b > c) System.out.println(b * 100); // b가 가장 큰 경우
            else System.out.println(c * 100); // c가 가장 큰 경우
        }
    }
}
