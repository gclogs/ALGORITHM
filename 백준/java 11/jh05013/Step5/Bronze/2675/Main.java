import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {    // 1. TC 개수 T만큼 반복
            String[] str = br.readLine().split(" ");    // 공백을 기준으로 자름
            
            int r = Integer.parseInt(str[0]);   // 공백을 기준으로 자른 str[0] 인덱스가 반복 횟수

            for(byte val : str[1].getBytes()) { // 2. str[0] 인덱스의 문자열 길이 만큼 순회
                for(int j = 0; j < r; j++) {    // 3. j번째 문자를 r만큼 반복
                    sb.append((char)val);
                }
                sb.append('\n');
            }
            System.out.println(sb);
        }
    }
}