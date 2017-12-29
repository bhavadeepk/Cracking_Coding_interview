
public class LinkedList {
	
	Node head;

	public LinkedList() {
	}
	
	public class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public void addToTail(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		}
		else {
			Node tail = head;
			while(tail.next != null) {
				tail = tail.next;
			}
			tail.next = newNode;
		}
	}
	
	public void addToTail(Node newNode) {
	
		if(head == null) {
			head = newNode;
		}
		else {
			Node tail = head;
			while(tail.next != null) {
				tail = tail.next;
			}
			tail.next = newNode;
		}
	}
	
	public void printList() {
		Node head = this.head;
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addToTail(3);
		list.addToTail(4);
		list.addToTail(6);
		list.addToTail(7);
		list.addToTail(6);
		list.addToTail(4);
		list.addToTail(3);
		
		list.printList();
		System.out.println(list.isPalindrome());
		Node l2 = list.head;
		l2 = l2.next.next.next;
		
		LinkedList list2 = new LinkedList();
		list2.addToTail(9);
		list2.addToTail(7);
		
		list2.addToTail(l2);
		
		list2.printList();
		
		System.out.println(findIntersection(list, list2).data);
		
		
		
	}
	
	public boolean isPalindrome() {
		LinkedList reversedList = this.reverse();
		Node nextNode = this.head;
		if(nextNode == null)
			return false;
		Node reverseNext = reversedList.head;
		while(nextNode!=null) {
			if(nextNode.data != reverseNext.data)
				return false;
			nextNode = nextNode.next;
			reverseNext = reverseNext.next;
		}
		return true;
		
	}
	
	public LinkedList reverse() {
		LinkedList reversedList = new LinkedList();
		Node current = null;
		Node head = this.head;
		while(head!= null) {
			Node n = new Node(head.data);
			n.next = current;
			current = n;
			head = head.next;
		}
		reversedList.head = current;
		return reversedList;
	}
	
	public static Node findIntersection(LinkedList l1, LinkedList l2) {
				
		int length1 = l1.length();
		int length2 = l2.length();
		
		Node tail1 = l1.head;
		Node tail2 = l2.head;
		
		while(tail1.next != null)
			tail1 = tail1.next;
		while(tail2.next != null)
			tail2 = tail2.next;
		
		if(tail1 != tail2)
			return null;
		
		Node shorter = length1 < length2 ? l1.head : l2.head;
		Node longer = length1 < length2 ? l2.head : l1.head;
		 
		
		int extra = Math.abs(length1 - length2);
		
		while(extra>0) {
			longer = longer.next;
			extra--;
		}
		
		while(shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		
		return shorter;
	}

	public int length() {
		int length = 0;
		Node head = this.head;
		while(head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

}
