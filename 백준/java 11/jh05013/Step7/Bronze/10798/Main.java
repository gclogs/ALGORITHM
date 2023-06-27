import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[][] str = new char[5][15];
        
        for(int i = 0; i < 5; i++) {
            String s = br.readLine();
            
            for(int j = 0; j < s.length(); j++) {
                str[i][j] = s.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(str[j][i] != '\0') {
                    sb.append(str[j][i]);
                }
            }
        }
        System.out.println(sb);
    }
}
