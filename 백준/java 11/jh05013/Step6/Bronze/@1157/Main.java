import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] aph = new int[26];    // 영문자의 개수는 26개
        String str = br.readLine();
        
        for(int i = 0; i < str.length(); i++) {
            if(65 <= str.charAt(i) && str.charAt(i) <= 90) { // 대문자 범위
                aph[str.charAt(i) - 'A']++;
            } else {    // 소문자 범위
                aph[str.charAt(i) - 'a']++;
            }
        }
        br.close();

        int max = -1;
        char ch = '?';

        for(int i = 0; i < 26; i++) {
            if(aph[i] > max) {
                max = aph[i];
                ch = (char) (i + 65);
            } else if (aph[i] == max) {
                ch = '?';
            }
        }

        bw.write(ch);
        bw.flush();
        bw.close();
    }
}