package array;

import java.util.Random;


public class Queue {

	private int[] queue;
	private int front;
	private int rear;
	private int maxSize;
	
	public Queue(int maxSize) {
		this.front = -1;
		this.rear = -1;
		this.maxSize = maxSize;
		this.queue = new int [maxSize];
	}
	
	public void push(int i) {
		if(rear<maxSize) {
			queue[++rear] = i;
		}
	}
	
	public int pop() {
		if(front<rear) {
			int i = queue[++front];
			return i;
		}
		return -1;
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
