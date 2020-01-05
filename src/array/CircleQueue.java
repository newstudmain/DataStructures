package array;

public class CircleQueue {
	
	private int[] queue;
	private int head;
	private int tail;
	private int maxSize;
	
	public CircleQueue(int maxSize) {
		this.maxSize = maxSize;
		this.queue = new int[maxSize];
		this.head = 14;
		this.tail = 0;
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public boolean isFull() {
		return (tail + 1) % maxSize == head;
	}
	
	public void push(int n) {
		if(!isFull()) {
			queue[tail] = n;
			tail = (tail + 1) % maxSize;
		}
	}

	public void print() {
		for(;!isFull();tail++) {
			System.out.println((tail + 1) % maxSize);
		}
	}
	
	public static void main(String[] args) {
		CircleQueue circleQueue = new CircleQueue(15);
		circleQueue.print();
	}
}
