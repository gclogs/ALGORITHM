import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String str;
        int cnt = 0;    // 그룹 단어 개수
        

        for(int i = 0; i < n; i++) {
            str = br.readLine();
            boolean check[] = new boolean[26];  // 알파벳 사용 내역
            boolean tmp = true; // 그룹 단어 인지

            for(int j = 0; j < str.length(); j++) {
                int index = str.charAt(j) - 'a';
                if(check[index]) {  // 이전에 사용한 적이 있는 문자라면
                    if(str.charAt(j) != str.charAt(j-1)) {  // 이전 문자와 연속되지 않는다면
                        tmp = false;    // 그룹 문자가 아님
                        break;
                    }
                } else {    // 이전에 사용한적이 없는 문자라면
                    check[index] = true;    // 문자 사용 체크
                }
            }
            if(tmp) cnt++;
        }
        
        br.close();

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
