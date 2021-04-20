interface I { } 
class A implements I { } 
class B extends A { } 
class C extends B { 
	public static void main(String[] args) { 
		B b = new B(); 
		A a = b;
        I i = b;
        // C c = (C) b;
        B d = (B) (A) b;
	} 
}