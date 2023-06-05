import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer> list;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<Integer>();

        for(int i = 0; i < n; i++) {    // list에 n개 만큼의 정수들을 저장
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        int v = Integer.parseInt(br.readLine());
        int count=0;    // 정수 v의 개수
        for(int val : list) {
            if(v == val) {  // 정수 v가 list 데이터의 val 값과 같다면
                count++;    // 정수 v의 개수 +1
            }
        }
        System.out.println(count);
    }
}
