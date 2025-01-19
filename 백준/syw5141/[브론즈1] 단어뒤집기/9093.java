import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 BufferedReader와 BufferedWriter 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 개수 입력 받기
        int t = Integer.parseInt(br.readLine());
        
        // t번 만큼 반복
        for(int i = 0; i < t; i++) {
            // 문자열을 입력받고 공백(" ")을 기준으로 단어들을 분리
            // 예: "I am happy" -> ["I", "am", "happy"]
            String[] words = br.readLine().split(" ");
            
            // 각 단어별로 처리
            for(int j = 0; j < words.length; j++) {
                String word = words[j];
                // StringBuilder를 사용해 단어를 뒤집기
                // 예: "happy" -> "yppah"
                String reversedWord = new StringBuilder(word).reverse().toString();
                bw.write(reversedWord);
                
                // 마지막 단어가 아니라면 공백 추가
                if(j < words.length - 1) {
                    bw.write(" ");
                }
            }
            // 한 줄이 끝나면 개행문자 추가
            bw.write("\n");
        }

        // 버퍼에 있는 모든 내용을 출력하고 닫기
        bw.flush();
        bw.close();
    }
}