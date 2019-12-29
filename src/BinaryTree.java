
public class BinaryTree {
	
	Student root;
	String inOrderTravStr;

	//First set the root to null when constructing the tree as the tree should be empty
	public BinaryTree() {
		setRoot(null);
		inOrderTravStr = "";
	}
	
	//We will need a method to insert, traverse the tree inOrder, and traverse the tree by level
	public void insert(Student st) {
		//firstly check that the passed node is not null
		if(st == null) {
			return;
		}
		//secondly set the left and right childs of the passed node to null just incase
		st.setLeft(null);
		st.setRight(null);
		//now check to see if root is null, if it is simply set root to st
		if(root == null) {
			setRoot(st);
		}
		//However if root is not null we will have to use a cursor to go through the tree and insert where null
		else {
			Student cursor = getRoot();
			while(true) {
				Student parent = cursor;
				if(st.getlName().compareToIgnoreCase(cursor.getlName()) <= 0) {
					cursor = cursor.getLeft();
					if(cursor == null){
						parent.setLeft(st);
						return;
					}
				}
				else {
					cursor = cursor.getRight();
					if(cursor == null) {
						parent.setRight(st);
						return;
					}
				}	
			}
		}	
	}
	
	
	
	public void inOrderTraversal() {
		inOrderTraversal(getRoot());
	}
	
	
	
	public void inOrderTraversal(Student cursor) {
		if(cursor !=null) {
			inOrderTraversal(cursor.getLeft());
			//System.out.println(cursor.toString());
			inOrderTravStr +=cursor.toString() + "\n";
			inOrderTraversal(cursor.getRight());
		}
	}
	
	
	
	//Next we will implement a breadth first traversal (aka level order traversal)
	public String printBreadthFirst() {
		Queue myQ = new Queue();
		myQ.enQueue(getRoot());
		String breadthFirstString = "Number  Last_Name  Home_Dep  Program  Year\n";;
		while(!myQ.isEmptyWrapper()) {
			Student temp = myQ.deQueue();
			//System.out.println(temp.toString());
			breadthFirstString += temp.toString()+"\n";
			
			//Now we have printed the data in parent node --> we must add both its children to the queue
			//enQueue the left child
			if(temp.getLeft()!= null) {
				myQ.enQueue(temp.getLeft());
			}
			//enQueue the right child
			if(temp.getRight() != null) {
				myQ.enQueue(temp.getRight());
			}
		}
		return breadthFirstString;
	}
	
	
	
	//delete a node   --->  this code has been written using the method shown on: https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
	public void deleteKey(String key) {
		root = deleteRec(getRoot(), key);
	}
	
	private Student deleteRec(Student cursor, String key) {
		if(cursor==null) {
			return cursor;
		}
		if(key.compareTo(cursor.getlName()) < 0) {
			cursor.setLeft(deleteRec(cursor.getLeft(), key));
		}
		else if(key.compareTo(cursor.getlName())>0) {
			cursor.setRight(deleteRec(cursor.getRight(), key));
		}
		
		else {
			if(cursor.getLeft() == null) {
				return cursor.getRight();
			}
			else if(cursor.getRight()==null) {
				return cursor.getLeft();
			}
			
			cursor.setlName(minValue(cursor.getRight()));
			cursor.setRight(deleteRec(cursor.getRight(), cursor.getlName()));
		}
		
		return cursor;
	}
	
	private String minValue(Student cursor) {
		String minv = cursor.getlName();
		while(cursor.getLeft()!=null) {
			minv = cursor.getLeft().getlName();
			cursor = cursor.getLeft();
		}
		return minv;
	}
	

	
//GETTERS AND SETTERS 
	public Student getRoot() {
		return root;
	}

	public void setRoot(Student root) {
		this.root = root;
	}
	
	public String getInOrderTravStr() {
		String header = "Number  Last_Name  Home_Dep  Program  Year\n";
		return header + inOrderTravStr;
	}

}
