import sys
input = sys.stdin.readline

class Queue:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        if self.items:
            print(self.items.pop(0))
        else:
            print(-1)
    
    def size(self):
        print(len(self.items))
    
    def empty(self):
        print(1 if not self.items else 0)
    
    def front(self):
        if self.items:
            print(self.items[0])
        else:
            print(-1)
    
    def back(self):
        if self.items:
            print(self.items[-1])
        else:
            print(-1)
    
def main():
    n = int(input())
    queue = Queue()

    for _ in range(n):
        command = input().strip().split()  

        if command[0] == 'push':
            queue.push(int(command[1]))
        elif command[0] == 'pop':
            queue.pop()
        elif command[0] == 'size':
            queue.size()
        elif command[0] == 'empty':
            queue.empty()
        elif command[0] == 'front':
            queue.front()
        elif command[0] == 'back':
            queue.back()

if __name__ == '__main__':
    main()