import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            arr.add(i);
        }
        
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while(arr.size() > 1) {
            idx = (idx + K - 1) % arr.size();
            sb.append(arr.remove(idx)).append(", ");
        }
        
        sb.append(arr.remove(0)).append(">");
        System.out.println(sb.toString());
    }
}
