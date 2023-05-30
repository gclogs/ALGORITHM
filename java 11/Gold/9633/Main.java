import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int count = 0;
    private static int[] board;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];
        
        nQueen(0);
        System.out.println(count);
    }

    // 유망한지 판단하는 함수
    public static boolean promising(int cdx) {
        // 같은 열이면 안됨 || 같은 대각선상에 있어도 안됨
        for(int i = 0; i < cdx; i++) {
            if (board[cdx] == board[i] || cdx - i == Math.abs(board[cdx] - board[i])) {
                return false;
            }
        }
        return true;
    }

    // 알고리즘 수행 함수
    public static void nQueen(int cdx) {
        // 행을 다 채우면 카운트를 1증가 후 리턴
        if(cdx == n) {
            count++;
            System.out.println("cdx:" + cdx + "count:" + count + "n:" + n);
            return;
        }

        for(int i = 0; i < n; i++) {
            board[cdx] = i; // cdx번째 행, i번째 열에 quuen을 임시위치
            // 이후 임시 위치의 유망성을 판단
            if(promising(cdx)) { // 임시위치가 괜찮다면
                nQueen(cdx+1);  // 그 다음 행에 대해 퀸을 위치
            }
        }
    }
    
}
