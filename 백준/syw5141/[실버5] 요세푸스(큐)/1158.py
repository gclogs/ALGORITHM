import sys
from collections import deque
input = sys.stdin.readline

def solve1():
    N, K = map(int, input().split())
    queue = []
    for i in range(1, N+1):
        queue.append(i)
    
    result = []
    while queue:
        for i in range(K-1):
            queue.append(queue.pop(0))
        result.append(queue.pop(0))

    print("<", end='')
    print(", ".join(map(str, result)), end='')
    print(">")

def solve2():
    N, K = map(int, input().split())
    
    queue = deque(range(1, N+1))
    result = []
    
    while queue:
        queue.rotate(-(K-1))
        result.append(queue.popleft())
    
    print("<" + ", ".join(map(str, result)) + ">")

def solve3():
    N, K = map(int, input().split())
    arr = list(range(1, N+1))
    idx = 0
    result = []
    
    while arr:
        idx = (idx + K - 1) % len(arr)
        result.append(arr.pop(idx))
    
    print("<" + ", ".join(map(str, result)) + ">")

if __name__ == "__main__":
    solve3()