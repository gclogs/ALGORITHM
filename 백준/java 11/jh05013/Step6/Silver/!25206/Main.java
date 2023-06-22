import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[][] grade = new String[20][3]; // 20행 3열

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        double sumGrade = 0.0;  // 학점
        double sumScore = 0.0;  // 평점

        for(int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            grade[i][0] = st.nextToken();
            grade[i][1] = st.nextToken();
            grade[i][2] = st.nextToken();

            if(!grade[i][2].equalsIgnoreCase("P")) {    // P 등급을 제외한
                sumScore += calcGrade(Double.parseDouble(grade[i][1]), grade[i][2]);    // 학점*과목평점 합산
                sumGrade += Double.parseDouble(grade[i][1]);    // 학점 총합
            }
        }

        if(sumScore != 0) { // 전공 점수가 0이 아니면
			sumScore /= sumGrade;   // (학점x과목평점)의 합을 학점의 총합으로 나눔
		}

        br.close();
        
        bw.write(String.valueOf((float)sumScore));
        bw.flush();
        bw.close();
    }

    private static double calcGrade(double score, String grade) {
        double sum = 0;

        // 학점 * 등급 점수 = 전공 점수
        switch(grade) {
            case "A+":
                sum = score * 4.5;
                break;
            case "A0":
                sum = score * 4.0;
                break;
            case "B+":
                sum = score * 3.5;
                break;
            case "B0":
                sum = score * 3.0;
                break;
            case "C+":
                sum = score * 2.5;
                break;
            case "C0":
                sum = score * 2.0;
                break;
            case "D+":
                sum = score * 1.5;
                break;
            case "D0":
                sum = score * 1.0;
                break;
        }
        return sum;
    }
}
