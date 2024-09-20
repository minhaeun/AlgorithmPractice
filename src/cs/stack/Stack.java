package cs.stack;

import java.util.Arrays;

public class Stack {
    private int[] stack;
    private int top;
    private int stackSize;

    public boolean isFull(){
        return top == this.stackSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int num){
        if(isFull()) System.out.println("Stack is Full");
        else{
            stack[++top] = num;
            System.out.println("push num : " + num);
        }
    }

    public void pop(){
        if(isEmpty()) System.out.println("Stack is Empty");
        else{
            int num = stack[top--];
            System.out.println("pop num : " + num);
        }
    }

    public void peek(){
        if(isEmpty()) System.out.println("Stack is Empty");
        else{
            int num = stack[top];
            System.out.println("peek num : " + num);
        }
    }

    public void clear(){
        if(isEmpty()) System.out.println("Stack is Empty");
        else{
            top = -1;
            Arrays.fill(stack, 0);
            System.out.println("Stack is clear!");
        }
    }
}
