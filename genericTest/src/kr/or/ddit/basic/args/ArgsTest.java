package kr.or.ddit.basic.args;

public class ArgsTest {

	// 배열을 이용한 메서드
	// 매개변수로 받은 정수들의 합계를 구해서 반환하는 메서드
	public int sumArr(int[] data){
		int sum = 0;
		
		for(int i = 0; i < data.length; i++){
			sum += data[i];
		}
		
		return sum;
	}
	
	// 가변형 인수 : 메서드의 인수의 갯수가 실행될 때마다 다를때 사용, 메서드 안에서는 배열로 처리 , 한 가지 자료형만 사용 가능
	// 가변형 인수를 지원하는 메서드
	public int sumArg(int...data){
		int sum = 0;
		for(int i = 0; i < data.length; i++){
			sum += data[i];
		}
		return sum;
	}
	
	// 가변형 변수와 일반 변수를 같이 사용할 경우에는 가변형 변수를 제일 뒤에 배치
	public String sumArg2(String name, int...data){
		
		int sum = 0;
		
		for(int i = 0; i < data.length; i++){
			sum += data[i];
		}
		
		return name + "씨 점수" + sum;
	}

	
	
	public static void main(String[] args) {
		
		ArgsTest at = new ArgsTest();
		
		int[] score = {100, 80, 60};
		
		int result = at.sumArr(score);
		
		System.out.println("결과 : " + result);
		System.out.println("결과 : " + at.sumArr(new int[]{50, 60, 90}));
		
		System.out.println();
		
		System.out.println("가변형 결과1 : " + at.sumArg(60,50,40));
		System.out.println("가변형 결과2 : " + at.sumArg(1,2,3,4,5));
		System.out.println();
		
		System.out.println(at.sumArg2("홍길동", 10,20,30,40,50,60,70));
		
	}

}


















