package stl;

public class stack { // 연결리스트로 구현 

	private Node top;

	public stack() {
		this.top = null;
	}

	public boolean isEmpty() {
		return (top == null);
	}

	public void push(Object item) {
		Node newNode = new Node(item);
		newNode.nextNode = top;
		top = newNode;
	}

	public Object peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("empty");
		} else {
			return top.data;
		}
	}

	public Object pop() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("empty");
		} else {
			Object item = peek();
			top = top.nextNode;
			return item;
		}
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
