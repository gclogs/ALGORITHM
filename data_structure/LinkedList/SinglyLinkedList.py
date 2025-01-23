from ast import Delete


class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
    
    def append(self,data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
            return
        else:
            curr = self.head
            while curr.next is not None:
                curr = curr.next
            curr.next = new_node
    
    def print_list(self):
        curr = self.head
        while curr is not None:
            print(curr.data)
            curr = curr.next
    
    def search(self, data):
        curr = self.head
        while curr is not None:
            if curr.data == data:
                return True
            curr = curr.next
        return False

    def insert(self, data, position):
        new_node = Node(data)
        if position == 0:
            new_node.next = self.head
            self.head = new_node
            return

        curr = self.head
        while position > 1:
            curr = curr.next
            position -= 1

        new_node.next = curr.next
        curr.next = new_node

    def delete(self, data):
        if self.head and self.head.data == data:
            self.head = self.head.next
            return

        curr = self.head
        while curr.next:
            if curr.next.data == data:
                curr.next = curr.next.next
                return
        if curr.next is None and curr.data == data:
            curr.next = curr.next.next
            return
        else:
            raise ValueError("Data not in list")
    
link = LinkedList()
link.append(1)
link.append(3)
link.append(4)

link.insert(0, 0)
link.insert(1, 1)
link.insert(2, 2)

link.delete(0)
link.delete(1)
link.delete(2)

link.print_list()
