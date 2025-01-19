class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        try:
            return self.items.pop()
        except IndexError:
            return -1

    def empty(self):
        if(self.items == []):
            return 1
        else:
            return 0

    def size(self):
        return len(self.items)
    
    def top(self):
        if(self.items == []):
            return -1
        else:
            return self.items[-1]
    
n = int(input())
stack = Stack()

while n > 0:
    n -= 1

    command = input().split()
    if command[0] == 'push':
        stack.push(int(command[1]))
    elif command[0] == 'pop':
        print(stack.pop())
    elif command[0] == 'size':
        print(stack.size())
    elif command[0] == 'empty':
        print(stack.empty())
    elif command[0] == 'top':
        print(stack.top())