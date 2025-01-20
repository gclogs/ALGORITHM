import sys
from collections import deque
input = sys.stdin.readline

# queue.pop(0)을 사용하여 앞 원소를 제거하고 k-1번 회전시킨 후 k번째 원소 제거
def solve1():
    N, K = map(int, input().split())
    

    queue = []
    for i in range(1, N+1):
        queue.append(i)
    
    result = []
    # O(N^2)의 시간복잡도라서 시간이 오래 걸림
    while queue:  
        for i in range(K-1):
            # queue.pop(0)는 '리스트의 모든 요소'를 한 칸씩 앞으로 이동시켜야 하므로 O(n)의 시간이 걸림
            # queue.append()로 뒤에 추가하면서 K-1번 회전시킨 후 K번째 원소를 제거
            queue.append(queue.pop(0)) 

        result.append(queue.pop(0))

    print("<", end='')
    print(", ".join(map(str, result)), end='')
    print(">")

# collections.deque를 사용하여 양방향 큐를 활용
def solve2():
    N, K = map(int, input().split())
    
    queue = deque(range(1, N+1))
    result = []
    
    while queue:
        queue.rotate(-(K-1))
        result.append(queue.popleft())
    
    print("<" + ", ".join(map(str, result)) + ">")

# 인덱스 계산을 활용한 리스트 구현
def solve3():
    N, K = map(int, input().split())
    arr = list(range(1, N+1))
    idx = 0
    result = []
    
    while arr:
        # (idx + K - 1) % len(arr)로 다음 제거할 위치를 계산합니다
        idx = (idx + K - 1) % len(arr)
        # pop(idx)로 해당 인덱스의 요소만 제거
        result.append(arr.pop(idx))
    
    print("<" + ", ".join(map(str, result)) + ">")

if __name__ == "__main__":
    solve3()