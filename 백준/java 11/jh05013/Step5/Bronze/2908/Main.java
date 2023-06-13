import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        br.close();

        A = reverse(A);
        B = reverse(B);

        System.out.println(A > B ? A : B);
    }

    private static int reverse(int x) {
        return Integer.parseInt(new StringBuilder().append(x).reverse().toString());
    }
}
