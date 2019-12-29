
public class Student {
	private int studentNum;
	private String lName;
	private int homeDep;
	private String program;
	private int year;
	private Student left,right;	
	private Student next;
	
	public Student(int studentNum, String lName, int homeDep, String program, int year) {
		this.setStudentNum(studentNum);
		this.setlName(lName);
		this.setHomeDep(homeDep);
		this.setProgram(program);
		this.setYear(year);
		this.left =null;
		this.right = null;
		this.next = null;
	}
	
//GETTERS, SETTERS, & TOSTRING
	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getHomeDep() {
		return homeDep;
	}

	public void setHomeDep(int homeDep2) {
		this.homeDep = homeDep2;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Student getLeft() {
		return left;
	}

	public void setLeft(Student left) {
		this.left = left;
	}

	public Student getRight() {
		return right;
	}

	public void setRight(Student right) {
		this.right = right;
	}
	
	public String toString() {
		return studentNum + " " + lName + " " + homeDep + " " + program + " " + year;
	}

	public Student getNext() {
		return next;
	}

	public void setNext(Student next) {
		this.next = next;
	}
	
	
}
