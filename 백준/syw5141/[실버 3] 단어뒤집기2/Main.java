import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 효율적으로 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열을 효율적으로 조작하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        // 문자를 임시 저장할 스택 선언
        Stack<Character> stack = new Stack<>();
        
        // 입력 문자열 받기
        String str = br.readLine();
        int len = str.length();

        // 현재 태그 안에 있는지 여부를 추적
        boolean tag = false;
        
        // 문자열의 각 문자를 순회
        for(int i = 0; i < len; i++) {
            // 태그 시작 만남
            if(str.charAt(i) == '<') {
                tag = true;
                
                // 태그 시작 전에 스택에 있던 모든 문자를 꺼내서 뒤집어 추가
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(str.charAt(i));  // '<' 추가
            } 
            // 태그 끝 만남
            else if(str.charAt(i) == '>') {
                tag = false;
                sb.append(str.charAt(i));  // '>' 추가
            } 
            // 태그 안의 문자 처리
            else if(tag) {
                sb.append(str.charAt(i));  // 태그 안의 문자는 그대로 추가
            } 
            // 태그 밖의 문자 처리
            else {
                if(str.charAt(i) == ' ') {  // 공백 만남
                    // 스택에 있는 문자들을 모두 꺼내서 뒤집어 추가
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(str.charAt(i));  // 공백 추가
                } else {
                    // 일반 문자는 스택에 저장
                    stack.push(str.charAt(i));
                }
            }
        }

        // 문자열 끝에 도달했을 때 스택에 남아있는 문자들 처리
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }   
}