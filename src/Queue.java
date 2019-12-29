
public class Queue {
	
	private Student head, tail;
	
	//Queue constructor should simply set head and tail to null as there are no nodes to begin with
	public Queue() {
		setHead(null);
		setTail(null);
	}
	//We need enQueueing and deQueueing methods for the queue
	//Recall that enQueueing occurs at the end of the list and requires the tail Node to point to the new Node
	//While also making that new Node the new Tail --> we will be passed the new Node as a parameter
	public void enQueue(Student st) {
		if(st == null) {
			return;
		}
		else if(st.getNext()!=null) {
			st.setNext(null);
		}
		if(isEmpty()) {
			setHead(st);
			setTail(st);
		}
		else {
			getTail().setNext(st);        //setting things to one side will just create a linked-list so thats good
			setTail(st);
		}
	}
	
	//Next we must be able to deQueue --> occurs at the beginning of queue --> FIFO
	//Note that when we remove it is also desirable to return the object
	public Student deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is already empty.");
			return null;
		}
		Student temp = getHead();
		if(getHead() == getTail()) {
			setHead(null);
			setTail(null);
		}
		else{
		setHead(getHead().getNext());
		}
		temp.setNext(null);    //Security: we must set next of this Node to null to ensure we don't give access to entire queue
		return temp;
	}
	
	public boolean isEmptyWrapper() {
		return isEmpty();
	}
	
//HELPERS
	private boolean isEmpty() {
		if(head == null && tail == null) {
			return true;
		}
		return false;
	}
	
	
	
	
//GETTER AND SETTERS
	public Student getHead() {
		return head;
	}

	public void setHead(Student head) {
		this.head = head;
	}

	public Student getTail() {
		return tail;
	}

	public void setTail(Student tail) {
		this.tail = tail;
	}
	
}
