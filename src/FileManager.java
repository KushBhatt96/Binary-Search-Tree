import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManager {
	private Scanner fileOpen;
	
	public void loadTextFile(BinaryTree myTree, String fileName) {
		try {
			fileOpen = new Scanner(new File(fileName));
			//fileOpen.useDelimiter("\r\n");
			while(fileOpen.hasNext()) {
				String word1 = fileOpen.next().split(" ")[0];
				int studentNum = Integer.parseInt(word1.substring(1, 8));
				String lName = word1.substring(8);
				//System.out.print(studentNum + "  " + lName + "  ");
				String word2 = fileOpen.next().split(" ")[0];
				int homeDep = Integer.parseInt(word2.substring(0,4));
				String program = word2.substring(4);
				//System.out.print(homeDep + "  " + program + "  ");
				String word3 = fileOpen.next().split(" ")[0];
				int year = Integer.parseInt(word3);
				//System.out.println(year + "\n");
				System.out.println(studentNum + " " + lName + " " + homeDep + " " + program + " " + year);
				myTree.insert(new Student(studentNum, lName, homeDep, program, year));
			}
			
			fileOpen = new Scanner(new File(fileName));
			while(fileOpen.hasNext()) {
				String word4 = fileOpen.next().split(" ")[0];
				String word5 = fileOpen.next().split(" ")[0];
				String word6 = fileOpen.next().split(" ")[0];
				if(word4.substring(0,1).equals("D")) {
					System.out.println("\nDeleted Node: " + word4.substring(8));
					myTree.deleteKey(word4.substring(8));
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error in loading the file! Please ensure your inputs are correct.");
			System.exit(0);
		}
	}
	
	public void writeToFile(String whatToWrite, String newFileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(newFileName+".txt"));
			writer.write(whatToWrite);
			writer.close();
		}catch (Exception e) {
			System.out.println("Could not write to file. Please ensure your inputs are correct.");
			System.exit(0);
		}
	}

}
