class MyStack<T> {
    private static final int MAX_SIZE_STACK = 100;
    private T[] stack;
    private int top;
    
    public MyStack() {
        this.stack = (T[]) new Object[MAX_SIZE_STACK];
        this.top = -1;
    }

    public void push(T item) {
        if (top >= MAX_SIZE_STACK - 1) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = stack[top];
        stack[top--] = null;  // 메모리 누수 방지
        return item;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public int search(T value) {
        for (int i = top; i >= 0; i--) {
            if (stack[i] == value) {
                return top - i;
            }
        }
        return -1;
    }
}

public class Stack {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        
        System.out.println("=== Stack 작동 테스트 ===");
        
        // 스택이 비어있는지 확인
        System.out.println("스택이 비어있나요? " + stack.isEmpty());
        
        // 데이터 삽입 테스트
        System.out.println("\n=== 데이터 삽입 ===");
        System.out.println("'첫번째' 삽입");
        stack.push("첫번째");
        System.out.println("'두번째' 삽입");
        stack.push("두번째");
        System.out.println("'세번째' 삽입");
        stack.push("세번째");
        
        // 현재 스택 상태
        System.out.println("\n=== 현재 스택 상태 ===");
        System.out.println("스택 크기: " + stack.size());
        System.out.println("맨 위 요소: " + stack.peek());
        
        // LIFO 확인을 위한 데이터 추출
        System.out.println("\n=== LIFO 동작 확인 ===");
        System.out.println("첫 번째 pop: " + stack.pop());  // '세번째' 출력
        System.out.println("두 번째 pop: " + stack.pop());  // '두번째' 출력
        System.out.println("세 번째 pop: " + stack.pop());  // '첫번째' 출력
        
        // 스택이 비어있는지 다시 확인
        System.out.println("\n=== 최종 상태 ===");
        System.out.println("스택이 비어있나요? " + stack.isEmpty());
        
        // 빈 스택에서 pop 시도
        try {
            System.out.println("\n=== 빈 스택에서 pop 시도 ===");
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}