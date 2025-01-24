import sys

# 입력 문자열 받기 (개행문자 제거)
s = sys.stdin.readline().rstrip()
# 문자를 임시 저장할 스택
stack = []
# 현재 태그 안에 있는지 여부를 추적
is_tag = False
# 최종 결과 문자열
result = ''

# 문자열의 각 문자를 순회
for char in s:
    if char == '<':
        # 태그 시작 전에 스택에 있던 모든 문자를 꺼내서 뒤집어 추가
        while stack:
            result += stack.pop()
        is_tag = True
        result += char
    elif char == '>':
        # 태그 끝 만남
        is_tag = False
        result += char
    elif char == ' ' and not is_tag:
        # 태그 밖에서 공백 만남
        # 스택에 있는 문자들을 모두 꺼내서 뒤집어 추가
        while stack:
            result += stack.pop()
        result += char
    elif is_tag:
        # 태그 안의 문자는 그대로 추가
        result += char
    else:
        # 일반 문자는 스택에 저장
        stack.append(char)

# 문자열 끝에 도달했을 때 스택에 남아있는 문자들 처리
while stack:
    result += stack.pop()

# 최종 결과 출력
print(result)