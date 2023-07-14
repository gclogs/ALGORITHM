import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
    
    String str = br.readLine();
    String word;

    for(int i = 0; i < str.length(); i++) {
      char ch1 = str.charAt(i); // 한글자 따오기

      for(int j = 0; j < croatia.length; j++) {
        int tmp = ch1 + str.charAt(i+1);
        if(tmp == croatia) {

        }
      }
        
    }
  }
}