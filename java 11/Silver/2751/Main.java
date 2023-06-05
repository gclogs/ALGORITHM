import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n];
        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);
        for(int val : list) {
            System.out.println(val);
        }
    }
}
