import java.io.*;
import java.util.StringTokenizer;

public class B10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] stack = new int[10000];
        int size = 0;
        
        int N = Integer.parseInt(br.readLine());
        
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            switch (command) {
                case "push":
                    stack[size++] = Integer.parseInt(st.nextToken());
                    break;
                case "pop":
                    bw.write((size > 0 ? stack[--size] : -1) + "\n");
                    break;
                case "size":
                    bw.write(size + "\n");
                    break;
                case "empty":
                    bw.write((size == 0 ? 1 : 0) + "\n");
                    break;
                case "top":
                    bw.write((size > 0 ? stack[size - 1] : -1) + "\n");
                    break;
            }
        }
        
        bw.flush();
        bw.close();
    }
}