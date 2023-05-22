import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[100];
        for(int i = 0; i < N; i++) {
            if (st.hasMoreTokens()) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(arr[i]);
        }
        
        int count = 0;
        int num = 2;
        for(int j=0; j < N; j++) {
            for (int k=2; k <= num; k++) {
                if(num % k == 0 && k != num) break;
                if(num % k == 0 && k == num) count++;
            }
        }
    }
}
