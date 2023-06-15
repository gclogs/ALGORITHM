import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] hs = { 1, 1, 2, 2, 2, 8 }; // { king 1, queen 1, rook 2, bishop 2, knight 2, phone 8 }

        int[] board = new int[6];

        for(int i = 0; i < board.length; i++) {
            board[i] = hs[i] - Integer.parseInt(st.nextToken());
            System.out.print(board[i] + " ");
        }
        br.close();
    }
}
