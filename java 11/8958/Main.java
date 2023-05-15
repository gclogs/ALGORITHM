import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= count; i++) {
            String str = br.readLine();

            int sum = 0;
            int temp = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == 'O') {
                    temp++;
                    sum += temp;
                } else {
                    temp = 0;
                }
            }
            System.out.println(sum);
        }
        br.close();
    }
}
