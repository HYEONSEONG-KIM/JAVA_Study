package g_oop2;

//추상 메서드가 있는 클래스는 반드시 추상 클래스로
public abstract class SampleAbstractParent {
	
	
	//일반적인 메서드 선언
	void method(){
		
	}
	
	//추상 메서드 : 선언부만 있고 구현부는 없는 메서드
	abstract void abstractMethod();
	
	
}


class SampleAbstractChild extends SampleAbstractParent{

	@Override
	void abstractMethod() {
		
	}
	
}






















