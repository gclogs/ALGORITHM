import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        br.close();

        m -= 45; // m에서 45분을 뺌
        if(m < 0) { // m이 0보다 작으면
            m += 60; // m에 60을 더함
            h -= 1; // h에 -1 시간을 뺌

            if(h<0) h = 23; // h가 0보다 작으면 23으로 초기화
        }
        System.out.println(h + " " + m);
    }
}
