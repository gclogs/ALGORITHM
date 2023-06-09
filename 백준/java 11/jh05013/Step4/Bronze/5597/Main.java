import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] students = new int[31]; // 출석부 30명 (0은 제외)
        
        for(int i = 1; i < 29; i++) {                       // 제출한 학생 28명
            int success = Integer.parseInt(br.readLine());  // 누가 제출했는지 출석번호 입력
            students[success] = 1;                          // 학생 인덱스에 출석번호 저장
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < students.length; i++) {  // 출석부 30명 순회
            if(students[i] != 1) {  // 학생[출석번호] 중 제출하지 않은 인원 판별
                sb.append(i);
                sb.append("\n");
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        
    }
}
