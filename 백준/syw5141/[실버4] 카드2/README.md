# 카드2 (백준 2164번) 문제 해결 방법 분석

## 문제 개요
N장의 카드가 있을 때, 다음 동작을 카드가 한 장 남을 때까지 반복:
1. 제일 위에 있는 카드를 바닥에 버린다.
2. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.

## 해결 방법 비교

### solve1: 수학적 패턴을 이용한 방법
```python
def solve1(n):
    if n == 1: return 1
    
    temp = n
    cnt = 0
    while temp != 1:
        temp //= 2
        cnt += 1
    
    power_of_two = 2**cnt
    
    if power_of_two == n:
        return power_of_two
    else:
        return 2 * (n - power_of_two)
```

#### 특징
- 2의 거듭제곱을 이용한 수학적 패턴 활용
- N보다 작거나 같은 가장 큰 2의 거듭제곱을 찾아 계산
- 메모리 효율적인 구현

#### 성능
- 시간복잡도: O(log N)
- 공간복잡도: O(1)
- 대규모 입력값에 효율적

### solve2: 시뮬레이션 방법
```python
def solve2(n):
    list = deque(range(1, n+1))
    for _ in range(n-1):
        list.popleft()
        list.append(list.popleft())
    return list[0]
```

#### 특징
- 실제 카드 게임 과정을 그대로 시뮬레이션
- 직관적이고 이해하기 쉬운 구현
- deque 자료구조를 활용한 효율적인 앞/뒤 요소 처리

#### 성능
- 시간복잡도: O(N)
- 공간복잡도: O(N)
- 작은 입력값에는 문제없으나 큰 입력값에서는 비효율적

## 결론
- **solve1**이 더 효율적인 해결책:
  - 메모리 사용량이 적음
  - 실행 시간이 빠름
  - 큰 입력값에도 안정적

- **solve2**는 학습과 이해에 유용:
  - 문제의 동작 과정을 직접적으로 보여줌
  - 코드가 직관적이고 이해하기 쉬움
  - 디버깅이 용이
