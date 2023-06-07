import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursion {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        HelloWorld(N);
    }
    public static void HelloWorld(int n) {
        if(n == 0) return;
        System.out.println("HelloWorld");
        HelloWorld(n-1);
    }
}
