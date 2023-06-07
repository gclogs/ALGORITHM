import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        for(int i = 0; i < count; i++) {
            int N = sc.nextInt();
            int[] score = new int[N];
            double sum = 0;

            for(int j=0; j < N; j++) {
                score[j] = sc.nextInt();
                sum += score[j];
            }

            double avg = (sum / N);
            double student = 0;
            
            for(int k=0; k < N; k++) {
                if(score[k] > avg) {
                    student++;
                }
            }

            System.out.printf("%.3f%%\n",(student/N)*100);
        }
        sc.close();
    }
}