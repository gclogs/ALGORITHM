class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        try:
            return self.items.pop()
        except IndexError:
            print("Stack is empty")

    def is_empty(self):
        return self.items == []

    def size(self):
        return len(self.items)

    def peek(self):
        if not self.is_empty():
            return self.items[-1]
        else:
            return -1
    
    def search(self, value):
        for i in range(len(self.items)):
            if self.items[i] == value:
                return i
        return -1

# 테스트 코드
if __name__ == "__main__":
    stack = Stack()
    
    print("=== Stack 작동 테스트 ===")
    
    # 스택이 비어있는지 확인
    print(f"스택이 비어있나요? {stack.is_empty()}")
    
    # 데이터 삽입 테스트
    print("\n=== 데이터 삽입 ===")
    print("'첫번째' 삽입")
    stack.push("첫번째")
    print("'두번째' 삽입")
    stack.push("두번째")
    print("'세번째' 삽입")
    stack.push("세번째")
    
    # 현재 스택 상태
    print("\n=== 현재 스택 상태 ===")
    print(f"스택 크기: {stack.size()}")
    print(f"맨 위 요소: {stack.peek()}")
    
    # LIFO 확인을 위한 데이터 추출
    print("\n=== LIFO 동작 확인 ===")
    print(f"첫 번째 pop: {stack.pop()}")  # '세번째' 출력
    print(f"두 번째 pop: {stack.pop()}")  # '두번째' 출력
    print(f"세 번째 pop: {stack.pop()}")  # '첫번째' 출력
    
    # 스택이 비어있는지 다시 확인
    print("\n=== 최종 상태 ===")
    print(f"스택이 비어있나요? {stack.is_empty()}")
    
    # 빈 스택에서 pop 시도
    print("\n=== 빈 스택에서 pop 시도 ===")
    stack.pop()  # "Stack is empty" 출력