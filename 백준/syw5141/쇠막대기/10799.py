import sys
input = sys.stdin.readline

n = input().strip()
stack = []
cnt = 0

def solve1():
    for i in range(len(n)):
        if n[i] == "(":
            stack.append(n[i])
        elif n[i] == ")":
            stack.pop()
            if(n[i-1] == "("):
                cnt += len(stack)
            else:
                cnt += 1
    print(cnt)

def solve2():
    for i in input():
        if i == "(":
            stack.append(i)
            last = "("
        else:
            if last == "(":
                stack.pop()
                cnt += 1
            else:
                stack.pop()
                cnt += len(stack)
            last = ")"

    print(cnt)

if __name__ == "__main__":
    solve1()