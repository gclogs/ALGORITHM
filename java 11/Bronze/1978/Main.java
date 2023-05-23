import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int arr[] = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            if(st.hasMoreTokens()) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int j = 0; j < N; j++) {
            if(checkisPrimeNumber(arr[j]) && arr[j] != 1) {
                count++;
            }
        }
        System.out.print(count);
        
    }

    static boolean checkisPrimeNumber(int num) {
        for(int i = 2; i*i<=num; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
}
