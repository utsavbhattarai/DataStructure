public class Queue {
	static String[] queue;
	int front = -1;
	int rear = -1;

	public static void main(String[] args) {

		queue = new String[88];
		Queue Q = new Queue();
		Q.push("bob");

		Q.push("eat too much");

		Q.push("I love greasy food");
		Q.push("FORTRAN 77 RULES");

		Q.popAll();

	}

	public void push(String element) {
		if (rear == (queue.length - 1)) {
			System.out.println("overflow");
		} else {
			if (front == -1 && rear == -1) {
				front = rear = 0;
			} else {
				rear = rear + 1;
			}
			queue[rear] = element;
		}
	}

	public String pop() {
		if (front == -1 || front > rear) {
			System.out.println("underflow");
			throw new RuntimeException("popping an empty stack");
		} else {
			String popElement = queue[front];

			if (front == rear) {
				front = -1;
				rear = -1;
			} else {
				front += 1;
			}
			return popElement;
		}
	}

	public void popAll() {
		while (!isEmpty()) {
			System.out.println(pop());
		}
		System.out.println();
	}

	public boolean isEmpty() {
		if (front == -1 && rear == -1) {
			return true;

		} else {
			return false;
		}
	}

	public void display() {
		if (rear == -1) {
			System.out.println("The queue is empty");
		} else {
			System.out.println("The items in the queue are: ");
			for (int i = front; i <= rear; i++) {
				System.out.println(queue[i] + "\n");
			}
		}

	}
}
