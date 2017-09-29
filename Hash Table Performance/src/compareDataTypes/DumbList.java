package compareDataTypes;

public class DumbList implements DataType {
	private int size;
	private Node head;
	private String type = "LinkedList";

	public DumbList() {

		size = 0;
		head = null;
	}

	@Override
	public boolean addElement(String newValue) {
		// TODO Auto-generated method stub
		boolean added = false;
		if (head == null) {
			Node newNode = new Node(newValue, null);
			head = newNode;
			size++;
			added = true;
		} else if (!findElementRecurse(newValue, head)) {
			Node newNode = new Node(newValue, head);
			head = newNode;
			size++;
			added = true;
		}
		return added;
	}

	@Override
	public boolean removeElement(String value) {
		boolean removed = false;
		if (head != null) {
			if (head.data.equalsIgnoreCase(value)) {
				this.head = head.next;
				size--;
				removed = true;
			} else if (findElementRecurse(value, head)) {
				Node parent = findParentRecurse(value, head);
				parent.next = parent.next.next;
				size--;
				removed = true;
			}

		}
		return removed;
	}

	@Override
	public boolean findElement(String query) {
		// TODO Auto-generated method stub
		boolean found = findElementRecurse(query, head);

		// output
		// if(found){
		// System.out.println(query+" was found");
		// } else {
		// System.out.println(query+" was not found");
		// }

		return found;
	}

	private boolean findElementRecurse(String query, Node head) {
		boolean found = false;

		// if (head != null && head.data.equalsIgnoreCase(query)) {
		// found = true;
		// } else if (head.next != null) {
		// found = findElementRecurse(query, head.next);
		// }

		while (!found && head.next != null) {
			if (head.data.equalsIgnoreCase(query)) {
				found = true;
			} else {
				head = head.next;
			}
		}

		return found;
	}

	private Node findParentRecurse(String query, Node head) {
		// TODO Auto-generated method stub
		Node parent = null;
		if (head.next != null && head.next.data.equalsIgnoreCase(query)) {
			parent = head;
		} else {
			parent = findParentRecurse(query, head.next);
		}

		return parent;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	public void printList() {
		printListRecurse(head);
	}

	private void printListRecurse(Node head) {
		if (head != null) {
			System.out.println(head.data);
			if (head.next != null) {
				printListRecurse(head.next);
			}
		}
	}

	public Node getHead() {
		return head;
	}

	public String getHeadData() {
		String data;
		if (head != null) {
			data = head.data;
		} else {
			data = "null";
		}
		return data;
	}

	public class Node {
		private String data;
		private Node next;

		public Node(String data, Node next) {

			this.data = data;
			this.next = next;
		}

		public String getData() {
			return this.data;
		}

		public Node getNext() {
			return this.next;
		}

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
