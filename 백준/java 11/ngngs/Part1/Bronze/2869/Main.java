import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int destination = V - B;
        int dist = A - B;

        int div = destination / dist;
        int mod = destination % dist;
        
        int day = div;
        if(mod != 0) {
            day += 1;
            System.out.println(day);
        } else {
            System.out.println(day);
        }
    }
}