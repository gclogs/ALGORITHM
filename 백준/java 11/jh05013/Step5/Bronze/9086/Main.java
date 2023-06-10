import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        String str;
        for(int i = 0; i < T; i++) {
            str = br.readLine();
            // 첫번째 글자와 마지막 글자 가져오기
            System.out.println(str.charAt(0) + "" + str.charAt(str.length() - 1));
        }
        br.close();
    }
}