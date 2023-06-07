import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = sc.nextInt(); // 정수 N을 입력
        int x = sc.nextInt(); // x를 입력

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt(); // 입력 받는 값마다 num에 저장
            if (x > num) { // num이 x보다 작아야하는 조건이므로
                sb.append(num + " "); // x보다 작다면 string builder에 저장
            }
        }
        sc.close();
        System.out.print(sb); // 출력
    }
}