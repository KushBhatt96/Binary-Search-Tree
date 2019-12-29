
public class BinaryTreeApp {
	
	public static void main(String [] args) {		
		
		//1. Load in the text file, Insert nodes, and delete nodes with "D"
		BinaryTree myTree = new BinaryTree();
		FileManager fileManager = new FileManager();
		System.out.println("Original Input Data (Before Deletions)------------------------");
		fileManager.loadTextFile(myTree, "a3input1_withD"+".txt");   
		
		
		//2. Depth-first traversal
		System.out.println("\nIn Order Traversal (Depth First)----------------------");
		myTree.inOrderTraversal();
		String inOrderTravStr = myTree.getInOrderTravStr();
		System.out.println(inOrderTravStr);
		fileManager.writeToFile(inOrderTravStr, "inOrderOutput");    
		

		//3. Breadth-first traversal
		System.out.println("Breadth First Traversal---------------------");
		String breadthFirstStr = myTree.printBreadthFirst();
		System.out.println(breadthFirstStr);
		fileManager.writeToFile(breadthFirstStr, "breadthFirstOutput");    
		
	}

}
