# 쇠막대기 문제 풀이 비교 분석
백준 10799번 - 쇠막대기 (Silver II)
[문제 링크](https://www.acmicpc.net/problem/10799)

## 문제 개요
여러 개의 쇠막대기를 레이저로 절단하는 문제로, 괄호를 이용해 레이저의 위치와 쇠막대기를 표현합니다.
- `()`는 레이저를 표현
- `(...)`는 쇠막대기를 표현

## 풀이 방법 비교

### [solve1 방식 (인덱스 기반 접근)](https://116116.tistory.com/28)
```python
def solve1():
    for i in range(len(n)):
        if n[i] == "(":
            stack.append(n[i])
        elif n[i] == ")":
            stack.pop()
            if(n[i-1] == "("):
                cnt += len(stack)
            else:
                cnt += 1
```

#### 특징
1. 문자열 인덱싱을 사용하여 이전 문자 확인
2. 전체 입력을 미리 저장
3. 직관적인 코드 구조

#### 장점
- 코드가 단순하고 이해하기 쉬움
- 디버깅이 용이함

#### 단점
- 추가 메모리 사용 (전체 입력 저장)
- 인덱스 접근으로 인한 잠재적 오류 가능성

### [solve2 방식 (상태 변수 기반 접근)](https://www.acmicpc.net/source/85991728)
```python
def solve2():
    for i in input():
        if i == "(":
            stack.append(i)
            last = "("
        else:
            if last == "(":
                stack.pop()
                cnt += 1
            else:
                stack.pop()
                cnt += len(stack)
            last = ")"
```

#### 특징
1. 상태 변수(`last`)를 사용하여 이전 문자 추적
2. 스트림 방식의 입력 처리
3. 구조화된 상태 관리

#### 장점
- 메모리 효율적 (입력을 저장하지 않음)
- 안전한 상태 관리
- 확장성이 좋음

#### 단점
- 상태 변수 관리로 인한 약간의 복잡도 증가

## 성능 비교

### 시간 복잡도
- 두 방식 모두 O(n) 시간 복잡도

### 공간 복잡도
- solve1: O(n) - 입력 문자열 저장
- solve2: O(k) - k는 현재 열린 괄호의 수

## 권장 사용 상황
- solve1: 코드의 단순성과 가독성이 중요한 경우
- solve2: 메모리 효율성과 확장성이 중요한 경우

## 참고 자료
- [백준 10799번 문제](https://www.acmicpc.net/problem/10799)
- [스택을 활용한 문제 해결 전략](https://www.geeksforgeeks.org/stack-data-structure/)
