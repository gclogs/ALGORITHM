# A B C D E F가 있고
# 중요도 1 1 9 1 1 1이 있음
# 중요도가 높을수록 우선순위가 커짐

# 따라서 C,D,E,F,A,B 가 되어야함
# location 0이라면 A인데 우선순위가 5가 됨

def solution(priorities, location):
    # (우선순위, 초기 위치)를 리스트에 저장
    queue = []
    for idx, p in enumerate(priorities):
        queue.append((p, idx))
        print(f"큐에 추가: {(p, idx)}")
    
    answer = 0
    
    while queue:
        current = queue.pop(0)
        print(f"\n현재 프로세스: {current}")
        print(f"남은 큐: {queue}")
        
        # 우선순위 비교 과정 출력
        higher_exists = False
        for q in queue:
            if current[0] < q[0]:
                print(f"더 높은 우선순위 발견: {current[0]} < {q[0]}")
                higher_exists = True
                break
            else:
                print(f"우선순위 비교: {current[0]} >= {q[0]}")
        
        if higher_exists:
            queue.append(current)
            print(f"현재 프로세스를 뒤로 이동: {current}")
        else:
            answer += 1
            print(f"프로세스 실행 (순서: {answer})")
            if current[1] == location:
                return answer

# 테스트
test_priorities = [1, 1, 9, 1, 1, 1]
test_location = 0
print(f"\n결과: {solution(test_priorities, test_location)}")  # 예상 출력: 5