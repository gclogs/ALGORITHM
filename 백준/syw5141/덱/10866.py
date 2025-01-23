# class Deque:
#     def __init__(self):
#         self.items = []

#     def isEmpty(self):
#         return self.items == []

#     def push_front(self, item):
#         self.items.insert(0, item)

#     def push_back(self, item):
#         self.items.append(item)
    
#     def pop_front(self):
#         if self.isEmpty():
#             print(-1)
#             return
#         print(self.items.pop(0))
    
#     def pop_back(self):
#         if self.isEmpty():
#             print(-1)
#             return
#         print(self.items.pop())
    
#     def size(self):
#         print(len(self.items))
    
#     def empty(self):
#         print(1 if self.isEmpty() else 0)
    
#     def front(self):
#         if self.isEmpty():
#             print(-1)
#             return
#         print(self.items[0])
    
#     def back(self):
#         if self.isEmpty():
#             print(-1)
#             return
#         print(self.items[-1])

from collections import deque
import sys

input = sys.stdin.readline
n = int(input())
deque = deque()

for _ in range(n):
    command = input().split()

    if command[0] == "push_front":
        deque.appendleft(command[1])
    elif command[0] == "push_back":
        deque.append(command[1])
    
    elif command[0] == "pop_front":
        if deque:
            print(deque.popleft())
        else:
            print(-1)
    
    elif command[0] == "pop_back":
        if deque:
            print(deque.pop())
        else:
            print(-1)
    
    elif command[0] == "size":
        print(len(deque))
    
    elif command[0] == "empty":
        if deque:
            print(0)
        else:
            print(1)
    
    elif command[0] == "front":
        if deque:
            print(deque[0])
        else:
            print(-1)
    
    elif command[0] == "back":
        if deque:
            print(deque[-1])
        else:
            print(-1)
