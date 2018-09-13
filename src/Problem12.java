/**
 * Author: Wenqiang Kuang
 * Date: 2018-07-18
 */

/**
 * Given the head and to-be-deleted node, delete the node in linked list in O(1).
 */
public class Problem12 {
    // A simple implementation of generic node
    private static class Node<E>{
        E value;
        Node<E> next;

        public Node(E elem){
            value = elem;
            next = null;
        }
    }

    public static <E> Node deleteNode(Node<E> head, Node<E> toBeDel){
        if(head == null || toBeDel == null){
            return head;
        }

        if(toBeDel.value == head.value){
            return head.next;
        }

        // if the node is not the last element of the linked list.
        if(toBeDel.next != null){
            toBeDel.value = toBeDel.next.value;
            toBeDel.next = toBeDel.next.next;
        // if this is the last node.
        }else{
            Node temp = head;
            while(temp.next != toBeDel){
                temp = temp.next;
            }
            // set the toBeDel node to be null.
            temp.next = null;
        }
        return head;
    }

    public static <E> void printNodes(Node<E> head){
        while(head != null){
            System.out.print(head.value.toString() + ' ');
            head = head.next;
        }
    }

    public static void main(String[] args){
        Node<Integer> n1 = new Node<>(5);
        n1.next = new Node<>(6);
        n1.next.next = new Node<>(7);

        Node<Integer> newHead = deleteNode(n1, n1);
        printNodes(newHead);
    }
}
