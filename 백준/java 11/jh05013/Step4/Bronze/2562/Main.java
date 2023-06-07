import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] list = new int[0];
        
        for(int i = 0; i < list.length; i++) { // 1번째 줄부터 9번째 줄까지 순회
            list[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int max = 0;    
        int cnt = 0;
        int pos = 1;
        
        for(int val : list) {
            cnt++;
            if(val > max) { // list 안의 value 값이 max보다 크다면
                max = val;  // max에 value값을 저장
                pos = cnt;   // max가 정해졌기에 위치 역시 저장되야함
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max + "\n" + pos);
        bw.flush();
        bw.close();
    }
}