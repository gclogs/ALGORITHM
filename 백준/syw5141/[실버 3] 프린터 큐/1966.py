from collections import deque
import sys

input = sys.stdin.readline

def solution(m):
    # 중요도 리스트를 큐로 변환
    priorities = list(map(int, input().split()))
    queue = deque([(p, idx) for idx, p in enumerate(priorities)])  # (중요도, 원래 위치)
    
    count = 0
    while queue:
        # 현재 문서의 중요도와 위치
        current = queue[0]
        
        # 현재 문서보다 중요도가 높은 문서가 있는지 확인
        if any(current[0] < q[0] for q in queue):
            # 현재 문서를 맨 뒤로 이동
            queue.append(queue.popleft())
        else:
            # 현재 문서 인쇄
            count += 1
            if queue.popleft()[1] == m:  # 찾고자 하는 문서인지 확인
                return count
    
    return count

# 테스트 케이스 수만큼 반복
for _ in range(int(input())):
    n, m = map(int, input().split())
    print(solution(m))