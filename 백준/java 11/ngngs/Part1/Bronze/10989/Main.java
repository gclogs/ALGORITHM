import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static ArrayList<Integer> list;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine()); // n을 입력 받음

        list = new ArrayList<Integer>(); // list 초기화

        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine())); // n만큼 list에 값을 저장
        }
        br.close();

        Collections.sort(list); // 오름차순 정렬

        
        for(int val : list) {
            sb.append(val).append("\n"); // stringbuilder 에 value와 들여쓰기를 같이 추가해줌
        }

        // 시간은 줄었으나... 메모리가 좀 크네요
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}