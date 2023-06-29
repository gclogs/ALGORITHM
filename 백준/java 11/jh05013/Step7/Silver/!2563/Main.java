import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = 0;  // 색칠한 영역의 넓이
        boolean[][] paper = new boolean[100][100];  // 도화지 (true, false) 으로 비교

        int num = Integer.parseInt(br.readLine());  // 색종이 개수
        
        for(int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j = x; j < x+10; j++) { // (x,y)부터 (x+9,y+9) 까지의 영역을 하나씩 체크
                for(int k = y; k < y+10; k++) {
                    if(paper[j][k] ) {
                        paper[j][k] = true;
                        total++;    // 총 넓이에 더해줌
                    }
                }
            }
        }

        br.close();
        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
        
    }
}
