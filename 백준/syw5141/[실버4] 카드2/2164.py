import sys
from collections import deque
input = sys.stdin.readline

def solve1(n):
    """2의 거듭제곱을 이용한 해결 방법
    시간복잡도: O(log N) - N을 2로 나누는 횟수만큼 반복
    공간복잡도: O(1) - 추가 메모리 거의 사용하지 않음
    
    원리: N보다 작거나 같은 가장 큰 2의 거듭제곱(k)을 찾아서
    - N이 2의 거듭제곱이면 N이 답
    - 그 외의 경우 2*(N-k)가 답
    - 공식: 2*(N-k(가장 가까운 작은 2의 거듭제곱))
    
    - 예시: N=7일 때
        7보다 작은 가장 큰 2의 거듭제곱은 4
        답 = 2*(7-4) = 2*3 = 6
    """
    # 입력값이 1인 경우 바로 처리
    if n == 1: return 1
    
    # N보다 작거나 같은 가장 큰 2의 거듭제곱 찾기
    temp = n
    cnt = 0
    while temp != 1:
        temp //= 2
        cnt += 1
    
    # 2의 거듭제곱 계산
    power_of_two = 2**cnt
    
    # N이 2의 거듭제곱인 경우와 아닌 경우 처리
    if power_of_two == n:
        return power_of_two
    else:
        return 2 * (n - power_of_two)

def solve2(n):
    # list에 1부터 n까지의 숫자를 저장
    list = deque(range(1, n+1))
    
    # n-1까지 반복
    for _ in range(n-1):
        list.popleft() # 맨 앞의 요소 제거
        list.append(list.popleft()) # 그 다음 요소 제거하고 맨 뒤에 추가
    return list[0]

# 테스트 코드
def test_solutions():
    """세 가지 해결 방법의 결과를 비교하는 테스트"""
    test_cases = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    
    print("N\tsolve1\tsolve2")
    print("-" * 32)
    
    for n in test_cases:
        result1 = solve1(n)
        result2 = solve2(n)
        print(f"{n}\t{result1}\t{result2}")

# 테스트 실행
test_solutions()

# 실제 문제 해결
n = int(input().strip())
print(solve1(n))  # 가장 효율적인 방법 사용