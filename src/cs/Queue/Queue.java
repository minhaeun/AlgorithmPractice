package cs.Queue;

public class Queue {
    private int[] queue;
    private int front, rear;
    private int queueSize;

    public boolean isFull(){
        return this.rear == queueSize-1;
    }

    public boolean isEmpty(){
        return this.front == this.rear;
    }

    public void offer(int num){
        if(isFull()) System.out.println("Queue is Full");
        else{
            queue[++rear] = num;
            System.out.println("offer num : " + num);
        }
    }

    public void poll(){
        if(isEmpty()) System.out.println("Queue is Empty");
        else{
            int num = queue[front++];
            System.out.println("poll num : " + num);
        }
    }

    public void peek(){
        if(isEmpty()) System.out.println("Queue is Empty");
        else{
            int num = queue[front];
            System.out.println("peek num : " + num);
        }
    }

    public void clear(){
        if(isEmpty()) System.out.println("Queue is Empty");
        else{
            front = rear = -1;
            //Arrays.fill(queue, 0);
            queue = new int[queueSize];
            System.out.println("Queue is clear!");
        }
    }


}
