import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    static ArrayList<int[]> steps;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        steps = new ArrayList<int []>();

        BigInteger count = new BigInteger("2");
        System.out.println(count.pow(N).subtract(new BigInteger("1")));

        if (N <= 20) {
            hanoi(N, 1, 3, 2);

            for(int i = 0; i < steps.size(); i++) {
                int[] step = steps.get(i);
                System.out.println(step[0] + " " + step[1]);
            }
        }
        
    }

    private static void hanoi(int n, int from, int to, int via) {
        if(n == 1) {
            steps.add(new int[] {from, to});
        } else {
            hanoi(n-1, from, via, to);
            steps.add(new int[] {from, to});
            hanoi(n-1, via, to, from);
        }

    }
}
