import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
    
    String word = br.readLine();

    for(String s : croatia) {
      word = word.replace(s, "*");
    }
    System.out.println(word.length());
  }
}