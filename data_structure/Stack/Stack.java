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
        stack[top--] = null;  // �޸� ���� ����
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
        
        System.out.println("=== Stack �۵� �׽�Ʈ ===");
        
        // ������ ����ִ��� Ȯ��
        System.out.println("������ ����ֳ���? " + stack.isEmpty());
        
        // ������ ���� �׽�Ʈ
        System.out.println("\n=== ������ ���� ===");
        System.out.println("'ù��°' ����");
        stack.push("ù��°");
        System.out.println("'�ι�°' ����");
        stack.push("�ι�°");
        System.out.println("'����°' ����");
        stack.push("����°");
        
        // ���� ���� ����
        System.out.println("\n=== ���� ���� ���� ===");
        System.out.println("���� ũ��: " + stack.size());
        System.out.println("�� �� ���: " + stack.peek());
        
        // LIFO Ȯ���� ���� ������ ����
        System.out.println("\n=== LIFO ���� Ȯ�� ===");
        System.out.println("ù ��° pop: " + stack.pop());  // '����°' ���
        System.out.println("�� ��° pop: " + stack.pop());  // '�ι�°' ���
        System.out.println("�� ��° pop: " + stack.pop());  // 'ù��°' ���
        
        // ������ ����ִ��� �ٽ� Ȯ��
        System.out.println("\n=== ���� ���� ===");
        System.out.println("������ ����ֳ���? " + stack.isEmpty());
        
        // �� ���ÿ��� pop �õ�
        try {
            System.out.println("\n=== �� ���ÿ��� pop �õ� ===");
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}