package data_structure.LinkedList;

class MyNode {
    private int data;
    private MyNode next;

    MyNode() {
        this.data = 0;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public MyNode getNextNode() {
        return this.next;
    }

    public MyNode setNextNode(MyNode next) {
        this.next = next;
        return this;
    }
}

class MyLinkedList {
    private MyNode head;
    private MyNode tail;
    private int size;

    MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void append(int data) {
        MyNode node = new MyNode();
        node.setData(data);
        node.setNextNode(null);  

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNextNode(node);
            this.tail = node;
        }
        this.size++;
    }

    public void remove(int data) {
        MyNode current = this.head;
        MyNode prev = null;

        while (current != null && current.getData() != data) {
            prev = current;
            current = current.getNextNode();
        }

        if (current != null) {
            if (prev == null) {
                this.head = current.getNextNode();
            } else {
                prev.setNextNode(current.getNextNode());
            }
            if (current == this.tail) {
                this.tail = prev;
            }
            this.size--;
        }
    }

    public boolean search(int data) {
        MyNode current = this.head;
        while (current != null) {
            if (current.getData() == data) {
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    public void insertAt(int position, int data) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        MyNode newNode = new MyNode();
        newNode.setData(data);

        if (position == 0) {
            newNode.setNextNode(head);
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            MyNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNextNode();
            }
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
            if (position == size) {
                tail = newNode;
            }
        }
        size++;
    }

    public void print() {
        MyNode current = this.head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNextNode();
        }
        System.out.println();
    }   
}

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        
        // 노드 추가 테스트
        list.append(1);
        list.append(2);
        list.append(3);
        System.out.println("Initial list:");
        list.print();  // Expected: 1 2 3

        // 특정 위치에 삽입 테스트
        list.insertAt(1, 5);
        System.out.println("After inserting 5 at position 1:");
        list.print();  // Expected: 1 5 2 3

        // 검색 테스트
        System.out.println("Search for 5: " + list.search(5));  // Expected: true
        System.out.println("Search for 4: " + list.search(4));  // Expected: false

        // 삭제 테스트
        list.remove(5);
        System.out.println("After removing 5:");
        list.print();  // Expected: 1 2 3
    }
}
