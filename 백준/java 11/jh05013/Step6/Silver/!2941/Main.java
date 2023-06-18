import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int count = 0;
    
    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      
      if(ch == 'c' && i < s.length() - 1) { // 만약 ch가 c라면?
        if(s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {  // 만약 ch 다음 문자가 '=' 또는 '-' 이라면?
          i++;  // i + 1 까지가 하나의 문자이므로 다음 문자를 건너 뛰기 위해 1 증가
        }
      } else if(ch == 'd' && i < s.length() - 1) {
        if(s.charAt(i + 1) == '-') { // "d-" 일 경우
          i++;
        } else if(s.charAt(i + 1) == 'z' && i < s.length() - 2) { // "dz="일 경우
          if(s.charAt(i + 2) == '=') {
            i += 2;
          }
        }
      } else if(ch == 'l' && i < s.length() - 1) {
          if(s.charAt(i + 1) == 'j') {  // lj 일 경우
            i++;
          }
      } else if(ch == 'n' && i < s.length() - 1) {
          if(s.charAt(i + 1) == 'j') {  // nj 일 경우
            i++;
          }
      } else if(ch == 's' && i < s.length() - 1) {
          if(s.charAt(i + 1) == '=') {  // s= 일 경우
            i++;
          }
      } else if(ch == 'z' && i < s.length() - 1) {
          if(s.charAt(i + 1) == '=') {  // z= 일 경우
            i++;
          }
      }
      count++;
    }
    System.out.println(count);
  }
}