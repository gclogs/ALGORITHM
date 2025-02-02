class DoublyLinkedList<T> {
    private static class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private T data;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void print() {
        Node<T> current = this.head;
        System.out.println("\n=== Linked List Status ===");
        while (current != null) {
            System.out.print("Node(" + current.data + ") -> ");
            System.out.print("prev: " + (current.prev != null ? current.prev.data : "null") + ", ");
            System.out.println("next: " + (current.next != null ? current.next.data : "null"));
            current = current.next;
        }
        System.out.println("\nHead: " + (this.head != null ? this.head.data : "null"));
        System.out.println("Tail: " + (this.tail != null ? this.tail.data : "null"));
        System.out.println("Size: " + this.size);
        System.out.println("=====================");
    }

    public void add(T data, int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            this.addFirst(data);
            return;
        }

        if (index == this.size) {
            this.addLast(data);
            return;
        }

        Node<T> next_node = this.search(index);
        Node<T> prev_node = next_node.prev;
        Node<T> node = new Node<>(data, prev_node, next_node);
        this.size++;

        prev_node.next = node;
        next_node.prev = node;
    }

    public void addFirst(T data) {
        Node<T> node = new Node<>(data, null, this.head);

        if(this.head == null) { // if head is null, then list is empty
            this.head = node;
            this.tail = node;
        } else {
            this.head.prev = node;
            this.head = node;
        }
        this.size++;
    }

    public void addLast(T data) {
        Node<T> node = new Node<>(data, this.tail, null);

        if(this.head == null) { // if head is null, then list is empty
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public void removeFirst() {
        if (this.head == null) {
            System.out.println("List is empty");
            return;
        }
    
        Node<T> oldHead = this.head;
        this.head = oldHead.next;
        
        if (this.head != null) {
            this.head.prev = null;
        } else {
            // 마지막 노드를 제거하는 경우
            this.head = null;
            this.tail = null;
        }
        
        // 이전 참조 정리
        oldHead.next = null;
        this.size--;
    }

    public void removeLast() {
        if (this.tail == null) {
            System.out.println("List is empty");
            return;
        }
        
        this.tail = this.tail.prev;
        if (this.tail != null) {
            this.tail.next = null;
        } else {
            this.head = null; // 마지막 노드를 제거한 경우
        }
        this.size--;
    }

    public Node<T> search(int index) {
        Node<T> n;

        // 1. 만일 인덱스가 시작에 가까우면, 순차 탐색
        if((this.size / 2) > index) {
            n = this.head;
            for(int i = 0; i < index; i++) {
                n = n.next;
            }   
        } else {
            // 2. 만일 인덱스가 끝에 가까우면, 역순 탐색
            n = this.tail;
            for(int i = this.size - 1; i > index; i--) {
                n = n.prev;
            }
        }
        return n;
    }

    public void clear() {
        for (Node<T> current = this.head; current != null;) {
            Node<T> next = current.next;
            current.prev = null;
            current.next = null;
            current = next;
        }
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        
        System.out.println("Adding elements...");
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);
        list.addLast(5);
        list.print();

        System.out.println("\nRemoving first element...");
        list.removeFirst();
        list.print();

        System.out.println("\nRemoving last element...");
        list.removeLast();
        list.print();
    }
}