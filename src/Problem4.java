import java.util.Stack;

/**
 * Author: Wenqiang Kuang
 * Date: 2018-07-06
 */

public class Problem4 {
    /**
     * Print a linked list reversely. Print nodes values from tail to head.
     * This method makes use of stack.
     */
    public static <E> void printLinkedListReversely(LinkedList<E> ll){
        Stack<Node<E>> stack = new Stack<>();
        Node currNode = ll.head;
        while(currNode != null){
            stack.push(currNode);
            currNode = currNode.next;
        }
        LinkedList<E> newLL = new LinkedList();
        while(!stack.isEmpty()){
            newLL.insert(stack.pop().value);
        }
        newLL.printList();
    }

    // A simple implementation of generic node
    public static class Node<E>{
        E value;
        Node<E> next;

        public Node(E elem){
            value = elem;
            next = null;
        }
    }

    // A simple implementation of linked list,
    public static class LinkedList<E>{
        private Node head = null;

        public void insert(E data){
            Node node = new Node(data);
            if(head == null){
                head = node;
                node.next = null;
            }

            Node currIndex = head;
            while(currIndex.next != null){
                currIndex = currIndex.next;
            }
            currIndex.next = node;
            node.next = null;
        }

        public void insertAtHead(E data){
            Node node = new Node(data);
            node.next = head;
            head = node;
        }

        public void printList(){
            Node currIndex = head;
            while(currIndex != null){
                System.out.println(currIndex.value + " ");
                currIndex = currIndex.next;
            }
        }
    }

    public static void main(String[] args){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.insert(11);
        ll.insert(22);
        ll.insertAtHead(33);
        ll.printList();
        printLinkedListReversely(ll);
    }
}
