# 방법 1: 스택을 사용한 방식
def is_vps_stack(s):
    stack = []
    for char in s:
        if char == '(':
            stack.append(char)
        else:
            if not stack:
                return False
            stack.pop()
    return len(stack) == 0

# 방법 2: 카운터를 사용한 방식
def is_vps_counter(s):
    count = 0
    for char in s:
        if char == '(':
            count += 1
        else:
            count -= 1
            if count < 0:
                return False
    return count == 0

# 방법 3: replace()를 활용한 방식
def check_vps_replace(s):
    while True:
        if '()' in s:
            s = s.replace("()", "")
        else:
            break
    return s == ""

# 테스트 케이스 개수 입력
t = int(input())

# 각 테스트 케이스 처리
for _ in range(t):
    ps = input().strip()
    print("YES" if check_vps_replace(ps) else "NO")
    print("YES" if is_vps_counter(ps) else "NO")
    print("YES" if is_vps_stack(ps) else "NO")