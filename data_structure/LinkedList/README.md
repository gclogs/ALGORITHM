# 연결 리스트 (Linked List) 구현

이 디렉토리는 연결 리스트의 다양한 구현을 포함하고 있습니다. Java와 Python으로 구현된 단방향 및 양방향 연결 리스트의 예제 코드를 제공합니다.

## 구현된 자료구조

### 1. 단방향 연결 리스트 (Singly Linked List)
- 파일: `Main.java`, `SinglyLinkedList.py`
- 특징:
  - 각 노드가 데이터와 다음 노드를 가리키는 포인터를 가짐
  - 한 방향으로만 순회 가능
  - 메모리 사용이 양방향 연결 리스트보다 효율적
- 주요 연산:
  - 삽입 (append, insert)
  - 삭제 (delete)
  - 검색 (search)
  - 순회 (traverse)

### 2. 양방향 연결 리스트 (Doubly Linked List)
- 파일: `DoublyLinkedList.py`
- 특징:
  - 각 노드가 데이터와 이전/다음 노드를 가리키는 포인터를 가짐
  - 양방향 순회 가능
  - 노드 삭제가 단방향 연결 리스트보다 효율적
- 주요 연산:
  - 삽입 (append, insert)
  - 삭제 (delete)
  - 정방향 순회 (traverse forward)
  - 역방향 순회 (traverse backward)

## 시간 복잡도

### 단방향 연결 리스트
- 접근 (Access): O(n)
- 검색 (Search): O(n)
- 삽입 (Insert):
  - 맨 앞: O(1)
  - 맨 뒤: O(1) (tail 포인터가 있는 경우)
  - 중간: O(n)
- 삭제 (Delete):
  - 맨 앞: O(1)
  - 맨 뒤: O(n)
  - 중간: O(n)

### 양방향 연결 리스트
- 접근 (Access): O(n)
- 검색 (Search): O(n)
- 삽입 (Insert):
  - 맨 앞: O(1)
  - 맨 뒤: O(1)
  - 중간: O(n)
- 삭제 (Delete):
  - 맨 앞: O(1)
  - 맨 뒤: O(1)
  - 중간: O(n)

## DoublyLinkedList 시간복잡도 분석

### 메소드별 시간복잡도

| 메소드 | 시간복잡도 | 설명 |
|--------|------------|------|
| addFirst(T data) | O(1) | 리스트 시작 부분에 노드 추가 |
| addLast(T data) | O(1) | 리스트 끝 부분에 노드 추가 |
| add(T data, int index) | O(n) | 특정 위치에 노드 추가 (search 연산 포함) |
| removeFirst() | O(1) | 첫 번째 노드 제거 |
| removeLast() | O(1) | 마지막 노드 제거 |
| search(int index) | O(n) | 특정 인덱스의 노드 검색 |
| clear() | O(n) | 모든 노드 제거 |
| print() | O(n) | 모든 노드 출력 |

### 세부 분석

#### 1. addFirst/addLast - O(1)
- 새 노드 생성
- 포인터 조정 (prev, next)
- 크기 증가
- 상수 시간 작업만 수행

#### 2. add(T data, int index) - O(n)
- 인덱스 유효성 검사: O(1)
- 노드 검색(search): O(n)
- 노드 삽입: O(1)
- 전체: O(n)

#### 3. search(int index) - O(n)
- 최적화: 양방향 검색
  - index < size/2: 앞에서부터 검색
  - index >= size/2: 뒤에서부터 검색
- 최악의 경우: O(n/2) = O(n)

#### 4. clear() - O(n)
- 모든 노드 순회
- 각 노드의 참조 제거
- 전체: O(n)

### 공간복잡도

- 노드당 필요한 공간:
  - 데이터(T data): O(1)
  - 이전 노드 참조(prev): O(1)
  - 다음 노드 참조(next): O(1)
- 전체 공간복잡도: O(n), n은 노드의 개수

### 최적화 포인트

1. search 메소드
   - 양방향 검색으로 평균 검색 시간 50% 감소
   - 비트 연산(>>1)으로 나눗셈 최적화 가능

2. add 메소드
   - 인덱스에 따라 addFirst/addLast 활용
   - 경계 조건 최적화

3. 메모리 관리
   - clear() 메소드에서 참조 정리
   - 가비지 컬렉션 최적화

## 사용 예시

### Java (단방향 연결 리스트)
```java
MyLinkedList list = new MyLinkedList();
list.append(1);
list.append(2);
list.append(3);
list.print();  // 출력: 1 2 3
```

### Python (양방향 연결 리스트)
```python
dll = DoublyLinkedList()
dll.append(1)
dll.append(2)
dll.append(3)
dll.print_list()      # 출력: 1 2 3
dll.print_reverse()   # 출력: 3 2 1
```

## 활용

연결 리스트는 다음과 같은 상황에서 유용하게 사용됩니다:
1. 데이터의 크기가 동적으로 변하는 경우
2. 데이터의 삽입/삭제가 빈번한 경우
3. 메모리를 효율적으로 사용해야 하는 경우
4. 스택, 큐 등의 다른 자료구조 구현의 기반
