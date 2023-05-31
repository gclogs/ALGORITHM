import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());   // 현재 시각 A시
        int b = Integer.parseInt(st.nextToken());   // 현재 시각 B분
        int c = Integer.parseInt(br.readLine());    // 요리하는데 필요한 시간 C분
        br.close();

        a += c / 60;    // A시에 (c분/60분)의 몫을 A시에 더해준다.
        b += c % 60;    // B분에 (c분%60분)의 나머지를 B에 더해준다.

        if(b>=60) {     // B분이 60분 이상이 되면
            ++a;        // A를 더해주고
            b -= 60;    // B에서 60분을 뺀다
        }
        if(a>=24) {     // A시가 24시를 넘어가면
            a -= 24;    // A에서 24를 뺀다
        }

        System.out.println(a + " " + b);
    }
}
