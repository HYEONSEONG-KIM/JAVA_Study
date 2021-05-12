package kr.or.ddit.singleton;

public class SingletonTest {

	public static void main(String[] args) {
		
		MySingleton mySingleton = MySingleton.getInstance();
		MySingleton mySingleton2 = MySingleton.getInstance();
		
		mySingleton.displayTest();
		mySingleton2.displayTest();
	}

}
