# 1. 배열(리스트) 끝에 새 값을 추가한다.
# 2. 추가한 원소의 인덱스를 구한다.
# 3. 부모 인덱스를 구하여 값을 비교한다.
# 4. 새 값이 부모의 값보다 작으면 값을 교환한다.
# 5. 인덱스를 갱신한다. (자리를 바꿨으므로, 새로 추가한 값의 인덱스가 변했다.)
# 6. 3번으로 돌아가서 같은 과정을 반복하되, 루트에 도달하면 종료한다.
# 7. 새 값이 부모의 값보다 크거나 같으면 종료한다.

def heap_push(heap, data):
    heap.append(data)

    current = len(heap) - 1 # 새로 추가한 원소의 인덱스
    while current > 0: # 부모 인덱스를 구하기
        parent = (current - 1) // 2
        if heap[current] < heap[parent]:  # 새의 값이 부모의 값보다 작다면
            heap[current], heap[parent] = heap[parent], heap[current]  # 교환
            current = parent  # 인덱스를 갱신
        else:
            break

import heapq
h1 = [3,4,5,6,7,8,9]
h2 = [3,4,5,6,7,8,9]

heap_push(h1, 10)
heapq.heappush(h2, 10)

print(f"힙 {h1}을 추가한 결과")
print("구현한 함수의 결과:", h1)
print("heapq.heappush 메소드의 결과:", h2)

heap_push(h1, 1)
heapq.heappush(h2, 1)

print(f"힙 {h1}에 3을 추가한 결과")
print("구현한 함수의 결과:", h1)
print("heapq.heappush 메소드의 결과:", h2)