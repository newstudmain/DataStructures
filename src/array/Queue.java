package array;

import java.util.Random;


public class Queue {

	private int[] queue;
	private int front;	//队列头
	private int rear;	//队列尾
	private int maxSize;	//队列容量
	
	public Queue(int maxSize) {
		this.front = -1;
		this.rear = -1;
		this.maxSize = maxSize;
		this.queue = new int [maxSize];
	}
	
	// 添加数据到队列
	public void push(int i) {
		if(isFull()) {
			queue[++rear] = i;
		}
	}
	
	// 显示队列的头数据， 注意不是取出数据
	public int pop() {
		if(isEmpty()) {
			int i = queue[++front];
			return i;
		}
		return -1;
	}
	
	public boolean isFull() {
		return rear == maxSize -1;
	}
	
	public boolean isEmpty() {
		return rear == front;
	}
	
	public void print() {
		for (int i : queue) {
			System.out.print(i+" <--");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Queue que = new Queue(5);
		
		for(int i=0;i<5;i++) {
			que.push(new Random().nextInt(10));
		}
		
		que.print();
		
		for(int i=0;i<5;i++) {
			System.out.println("--> "+que.pop());
		}
		
	}
}
