package cs.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;

    private class Node{
        private Object data;
        private Node next;

        public Node(Object date){
            this.data = data;
            this.next = null;
        }
    }

    private void addFirst(Object data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if(head.next == null)   tail = head;
    }

    private void addLast(Object data){
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;

    }

    private Node search(int index){
        Node node = head;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    private void add(int index, Object data){
        Node prevNode = search(index-1);
        Node newNode = new Node(data);
        Node nextNode = prevNode.next;

        prevNode.next = null;
        prevNode.next = newNode;
        newNode.next = nextNode;
    }

    private void remove(){

        Node node = head.next;
        head.next = null;
        head.data = null;
        head = node;
    }

    private void remove(int index){
        Node prevNode = search(index);
        Node nextNode = prevNode.next.next;

        prevNode.next = nextNode;
    }
}
