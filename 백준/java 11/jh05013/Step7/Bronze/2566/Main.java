import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] arr = new int[9][9];

        int max = 0;
        int x = 0;
        int y = 0;

        for(int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                if(arr[i][j] > max) {   // 최댓값이 j 번호의 값보다 크다면
                    max = arr[i][j];    // j번호가 최댓값이 됨
                    x = i+1;  // 최댓값의 row
                    y = j+1;  // 최댓값의 column
                    
                } else if(max == 0) {   // 최댓값이 0이면 격자판에 들어있는 숫자가 다 0이라는 뜻
                    // 최댓값이 2개 이상이면, 아무 인덱스나 가져오면 되기에 x,y를 1로 초기화
                    x = 1;
                    y = 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(x + " " + y);

        br.close();
    }
}
