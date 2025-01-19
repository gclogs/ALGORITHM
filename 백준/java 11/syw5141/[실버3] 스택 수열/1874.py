import sys
input = sys.stdin.readline

n = int(input().strip())
stack = []
result = []
current = 1

for _ in range(n):
    target = int(input().strip())
    while current <= target:
        stack.append(current)
        result.append('+')
        current += 1
    if stack[-1] == target:
        stack.pop()
        result.append('-')
    else:
        print("NO")
        sys.exit(0)  # 프로그램 즉시 종료

print("\n".join(result))