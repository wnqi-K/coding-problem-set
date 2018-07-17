/**
 * Author: Wenqiang Kuang
 * Date: 2018-07-17
 */

import java.util.Stack;

/**
 * Realize a queue using two stack.
 */
public class Problem6 {
    public static class MockQueue<T>{
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();
        public MockQueue(){}

        public void appendTail(T value){
            stack1.add(value);
        }

        public T deleteHead(){
            if(stack2.empty()) {
                while(!stack1.empty()){
                    stack2.add(stack1.pop());
                }
            }
            if(stack2.empty()){
                throw new RuntimeException("the mock queue is empty.");
            }
            return stack2.pop();
        }

        public void printQueue(){
            T[] array1 = (T[]) stack1.toArray();
            while(!stack2.isEmpty()){
                System.out.print(stack2.pop() + " ");
            }
            for (T i:array1){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args){
        MockQueue<Integer> mq= new MockQueue<>();
        mq.appendTail(1);
        mq.appendTail(2);
        mq.appendTail(3);
        mq.appendTail(4);
        mq.deleteHead();
        mq.appendTail(5);
        mq.appendTail(6);
        mq.appendTail(7);
        mq.appendTail(8);
        mq.deleteHead();
        mq.printQueue();
    }
}
