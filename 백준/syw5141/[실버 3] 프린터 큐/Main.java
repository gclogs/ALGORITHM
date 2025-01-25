import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 입력을 위한 BufferedReader와 출력을 위한 BufferedWriter 설정 (Python의 sys.stdin.readline과 유사)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();  // 출력을 모아서 한 번에 처리하기 위한 StringBuilder
        
        // 각 중요도별 개수를 저장할 배열 (Python에서는 필요없었던 부분)
        int[] priority = new int[10];  // 중요도는 1~9까지이므로 크기 10의 배열
        
        // 테스트 케이스 수 입력 (Python: T = int(input()))
        int tc = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // N(문서 개수)과 M(찾을 문서 위치) 입력
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            // 중요도와 원래 위치를 저장할 덱 생성 (Python의 deque와 유사)
            Deque<int[]> deque = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            
            // 각 문서의 중요도를 입력받고 처리
            // Python의 enumerate 대신 인덱스를 직접 관리
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                priority[num]++;  // 해당 중요도의 개수 증가
                deque.addLast(new int[]{num, j});  // [중요도, 원래 위치] 저장
            }
            
            // 프린터 큐 시뮬레이션 시작
            while(!deque.isEmpty()) {   
                // 현재 문서 정보 가져오기 (Python의 queue.popleft()와 유사)
                int[] current = deque.pollFirst();
                boolean flag = true;  // 현재 문서가 가장 높은 중요도인지 확인
                
                // 현재 문서보다 높은 중요도가 있는지 확인
                // Python의 any() 대신 직접 순회하며 확인
                for(int j = 9; j > current[0]; j--) {
                    if(priority[j] > 0) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) {  // 현재 문서가 가장 높은 중요도라면
                    priority[current[0]]--;  // 중요도 개수 감소
                    if(current[1] == M) {  // 찾던 문서라면
                        // 현재까지 인쇄된 문서 수 계산 (N - 남은 문서 수)
                        sb.append(N - deque.size()).append('\n');
                        break;
                    }
                } else {  // 더 높은 중요도가 있는 경우
                    deque.addLast(current);  // 현재 문서를 맨 뒤로 이동
                }
            }
        }
        
        // 최종 결과 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}