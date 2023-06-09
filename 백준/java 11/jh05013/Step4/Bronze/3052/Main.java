import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int input;
        HashSet<Integer> remainder = new HashSet<Integer>();

        for(int i = 1; i <= 10; i++) { // 수 10개를 입력 받음
            input = Integer.parseInt(br.readLine());
            remainder.add(input%42);  // HashSet을 사용하여 중복값 없애기 (서로 다른 나머지 추출)
        }
        br.close();
        
        int cnt=0;
        for(int i : remainder) {    // remainder에 저장된 값만큼 반복
            cnt++;
        }
        System.out.println(cnt);
    }
}