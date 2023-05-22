import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolveforBufferedReader {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    try {
      String str = br.readLine();
      StringTokenizer st = new StringTokenizer(str, " ");
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      System.out.println(A+B);
      System.out.println(A-B);
      System.out.println(A*B);
      System.out.println(A/B);
      System.out.println(A%B);
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }  
}
