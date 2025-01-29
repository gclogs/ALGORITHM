import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
q = deque(range(1, n+1))
targets = list(map(int, input().split()))  # m개의 수를 한 번에 입력 받음
cnt = 0

for target in targets:  # 각 목표 숫자에 대해
    target_idx = q.index(target)  # 찾고자 하는 덱의 인덱스
    half_idx = len(q)//2  # 중간 지점 (큐 크기가 변하므로 len(q) 사용)

    if target_idx <= half_idx:  # 왼쪽 회전이 더 빠른가?
        q.rotate(-target_idx)  # 왼쪽으로 회전
        cnt += target_idx
    else:
        q.rotate(len(q)-target_idx)  # 오른쪽으로 회전
        cnt += len(q)-target_idx
    
    q.popleft()  # 목표 숫자 제거

print(cnt)