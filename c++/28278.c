/**
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
3: 스택에 들어있는 정수의 개수를 출력한다.
4: 스택이 비어있으면 1, 아니면 0을 출력한다.
5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
*/

#include <stdio.h>

int stack[1000001];
int topIndex = -1;

void push(int value) {
    topIndex++;
    stack[topIndex] = value;
}

void pop() {
    if (topIndex == -1) {
        printf("-1\n");
    } else {
        printf("%d\n", stack[topIndex]);
        topIndex--;
    }
}

int size() {
    return topIndex + 1;
}

int empty() {
    return (topIndex == -1) ? 1 : 0;
}

int peek() {
    if (topIndex == -1) {
        return -1;
    } else {
        return stack[topIndex];
    }
}

int main() {
    int N;
    if (scanf("%d", &N) != 1) return 0;
    
    int command;
    int value;
    
    for (int i = 0; i < N; i++) {
        if (scanf("%d", &command) != 1) break;
        switch (command)
        {
        case 1:
            scanf("%d", &value);
            push(value);
            break;
        case 2:
            pop();
            break;
        case 3:
            printf("%d\n", size());
            break;
        case 4:
            printf("%d\n", empty());
            break;
        case 5:
            printf("%d\n", peek());
            break;
        default:
            break;
        }
    }
    return 0;
}
