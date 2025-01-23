class Node:
    def __init__(self, data, prev=None, next=None):
        self.data = data
        self.next = next
        self.prev = prev

class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0
    
    def append(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.prev = self.tail
            self.tail.next = new_node
            self.tail = new_node
        self.size += 1
    
    def print_list(self):
        curr = self.head
        while curr is not None:
            print(curr.data, end=" ")
            curr = curr.next
        print()
    
    def print_reverse(self):
        curr = self.tail
        while curr is not None:
            print(curr.data, end=" ")
            curr = curr.prev
        print()
    
    def insert(self, data, position):
        if position < 0 or position > self.size:
            raise IndexError("Invalid position")
            
        new_node = Node(data)
        
        if position == 0:
            new_node.next = self.head
            if self.head:
                self.head.prev = new_node
            self.head = new_node
            if self.tail is None:
                self.tail = new_node
        elif position == self.size:
            self.append(data)
            return
        else:
            curr = self.head
            for _ in range(position - 1):
                curr = curr.next
            
            new_node.next = curr.next
            new_node.prev = curr
            curr.next.prev = new_node
            curr.next = new_node
        
        self.size += 1
    
    def delete(self, data):
        curr = self.head
        
        while curr is not None:
            if curr.data == data:
                if curr.prev is not None:
                    curr.prev.next = curr.next
                else:
                    self.head = curr.next
                
                if curr.next is not None:
                    curr.next.prev = curr.prev
                else:
                    self.tail = curr.prev
                
                self.size -= 1
                return True
            curr = curr.next
        return False


# 테스트
if __name__ == "__main__":
    dll = DoublyLinkedList()
    
    # 노드 추가 테스트
    dll.append(1)
    dll.append(2)
    dll.append(3)
    print("Initial list:")
    dll.print_list()  # Expected: 1 2 3
    
    # 역방향 출력 테스트
    print("Reverse list:")
    dll.print_reverse()  # Expected: 3 2 1
    
    # 특정 위치에 삽입 테스트
    dll.insert(5, 1)
    print("After inserting 5 at position 1:")
    dll.print_list()  # Expected: 1 5 2 3
    
    # 삭제 테스트
    dll.delete(5)
    print("After deleting 5:")
    dll.print_list()  # Expected: 1 2 3