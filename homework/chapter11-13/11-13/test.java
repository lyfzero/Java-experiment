class Test {
    int x; 
	String y; 
	public Test() { 
		this("1"); 
		System.out.print("one "); 
	} 
	public Test(String y) { 
		this(1, "2"); 
		System.out.print("two "); 
	} 
	public Test(int x, String y) { 
		this.x = x; 
		this.y = y; 
		System.out.print("three "); 
	} 
	public static void main(String[] args) { 
		Test c = new Test(); 
		System.out.println(c.x + " " + c.y); 
	} 
}