package stl;

public class queue { // 연결리스트로 구현 

	private Node front;
	private Node rear;

	public queue() {
		this.front = null;
		this.rear = null;
	}

	public boolean isEmpty() {
		return (front == null);
	}

	public void insert(Object item) {
		Node node = new Node(item);
		node.nextNode = null;
		if (isEmpty()) {
			front = node;
			rear = node;
		} else {
			rear.nextNode = node;
			rear = node;
		}
	}

	public Object peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("empty");
		} else {
			return front.data;
		}
	}

	public Object remove() {
		Object item = peek();
		front = front.nextNode;

		if (front == null) {
			rear = null;
		}
		return item;

	}

	private class Node {
		private Object data;
		private Node nextNode;

		public Node(Object data) {
			this.data = data;
			this.nextNode = null;
		}
	}
}
