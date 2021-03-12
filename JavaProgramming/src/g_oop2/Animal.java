package g_oop2;

public abstract class Animal {

	void run(){
		System.out.println("달려가자~~");
	}
	
	abstract void sound();
	
}


class Dog extends Animal{


	@Override
	void sound() {
		System.out.println("멍멍!!");
		
	}
	
}

class mouse extends Animal{

	@Override
	void sound() {
		System.out.println("찍찍!!");
	}
	

	
}

class cat extends Animal{

	@Override
	void sound() {
		System.out.println("야옹~~");
	}
	
}























