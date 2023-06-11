import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] aph = new int[26]; // 1. a ~ z 알파벳

        for(int i = 0; i < aph.length; i++) {
            aph[i] = -1;    // 2. aph 배열에 -1을 저장
        }
        
        String s = br.readLine();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(aph[ch - 'a'] == -1) {
                aph[ch - 'a'] = i;
            }

        }

        for(int val : aph) {
            System.out.print(val + " ");
        }
    }
}