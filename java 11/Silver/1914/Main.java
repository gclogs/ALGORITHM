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
        //n : 원판의개수, start : 시작막대번호 mid : 징검다리 막대 번호 end : 도착지막대번호
        if(n == 1) {
            steps.add(new int[] {from, to});
        } else {
            /* n개의 원판을 시작지에서 도착지로 옮기는 과정을 아래의 3가지 과정으로 쪼갤수 있음 */
            //1번과정 : n-1개 원판을 시작막대에서 도착 막대를 거쳐 중간막대로
            //2번과정 : 시작막대의 마지막 남은 1개 원판을 도착지 막대로
            //3번과정 : 중간막대로 옮겼던 n-1개 원판을 다시 도착지 막대로 이동.
            hanoi(n-1, from, via, to);
            steps.add(new int[] {from, to});
            hanoi(n-1, via, to, from);
        }

    }
}
