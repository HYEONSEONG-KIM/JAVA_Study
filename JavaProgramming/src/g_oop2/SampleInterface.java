package g_oop2;

public interface SampleInterface {

	//인터페이스 : 상수와 추상메서드만 가질 수 있는 클래스
	//인터페이스의 모든 멤버변수는  public static final 제어자를 사용
	public static final int num1 =  1;
	
	//모든 멤버변수의 제어자가 같기 때문에 생략이 가능
	int num2 = 1;
	
	//인터페이스의 모든 메서드는 public abstract 제어자를 사용
	public abstract void method1();
	
	//모든 메서드의 제어자가 같기 때문에 생략 가능
	void method2();
	
	
}

class SampleImplement implements SampleInterface, SampleInterface2{

	//인터페이스는 다중 상속이 가능, 다중 상속 받은 인터페이스의 메서드가 이름이 같으면 하나만 오버라이딩
	@Override
	public void method1() {
		
	}

	@Override
	public void method2() {
		
	}

	@Override
	public void method3() {
		
	}
	
}

interface SampleInterface2{
	void method1();
	void method3();
}





























