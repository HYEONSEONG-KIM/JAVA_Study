package kr.or.ddit.basic.enumtest;

/*
 *	enum(열거형) 	=> 서로 관련이 있는 상수들의 집합을 나타냄
 *				=> 클래스처럼 보이게하는 상수
 *	- 작성 방법
 *		=> 	열거형은 클래스처럼 독립된 java파일에 만들수 있고, 
 *			하나의 java파일에 클래스와 같이 만들수 있고,
 *			클래스 내부에 내부 클래스처럼 만들수 있음
 *	- 열거형의 속성 및 메서드
 *	1) name()		=> 열거형 상수의 이름을 문자열로 반환
 *	2) ordinal()	=> 열거형 상수가 정의된 순서값(Index값)을 반환(0부터 시작)
 *	3) valueOf("열거형 상수명")		=> 인수값에 지정한 '열거형상수명'과 일치하는 열거형 상수를 반환
 *	4) 열거형이름.상수명	=> valueOf()메서드와 같음
 *----------------------------------------------------------------------------------
 * 	- 열거형 선언
 * 
 * 	방법1)
 * 		enum 열거형이름{ 상수명1, 상수명2, 상수명3, ... }
 * 
 * 		
 * 	방법2)
 * 		enum 열거형이름{
 * 			상수명1(값1, 값2, ...),
 * 			상수명2(값1, 값2, ...),
 * 			상수명3(값1, 값2, ...),
 * 			...
 * 
 * 			// 상수명 옆의 값들이 저장될 변수 선언...
 * 			private 자료형이름 변수명1;
 * 			private 자료형이름 변수명2;
 * 
 * 			// 열거형의 생성자를 만듬
 * 			// 열거형의 생성자는 '열거형상수'에 '값들'을 셋팅하는 역할을 수행
 * 			// 열거형 생성자는 묵시적으로 'private'
 * 
 * 			// 생성자의 매개변수는 상수옆의 값들과 자료형이 맞아야 함
 * 			private 열거형이름(자료형이름 변수명1,...){
 * 				위에 선언된 변수들을 초기화
 * 				....
 * 			}
 * 
 * 			// 위에 선언한 변수들을 외부에서 불러올 수 있는 getter메서드를 만듬
 * 
 * 			
 * 		}
 * 
 * 	
 */


public class EnumTest {
	public enum Color { RED, GREEN, BLUE}
	
	public enum Count { ONE, TWO, THREE }
	
	public enum Season{
		봄("3월부터 5월까지"),		//상수명(값들...) 형식의 선언
		여름("6월부터 8월까지"),
		가을("9월부터 11월까지"),
		겨울("12월부터 2월까지");
		
		private String span;	// 값이 저장될 변수 선언, 상수안의 값을 저장할 변수
		
		//생성자
		Season(String months){	// private Season(String months) 와 같음(default -> private)
			span = months;
		}
	
		//getter
		public String getSpan(){
			return span;
		}
	}

	public static void main(String[] args) {

		
/*		ConstTest test = new ConstTest();
		
//		System.out.println(test.ONE);
		System.out.println(ConstTest.ONE);
		
		if(ConstTest.ONE == ConstTest.RED){
			System.out.println("같다...");
		}else{
			System.out.println("같지 않다...");
		}
*/
//		if(Color.RED == Count.ONE){  //다른 종류의 열거형끼리 비교 불가
//			System.out.println();
//		}
		
		Color mycol = Color.valueOf("GREEN"); // Color.GREEN과 같음
		Count mycnt = Count.ONE; // Count.valueOf("ONE") 과 같음
		
		System.out.println("mycol : " + mycol);
		System.out.println("mycnt : " + mycnt);
		
		System.out.println("mycol의 ordinal : " + mycol.ordinal());
		System.out.println("mycnt의 ordinal : " + mycnt.ordinal());
		
		
		
		
		if(mycol == Color.GREEN){	//같은 종류의 열거형끼리만 비교 가능
			System.out.println("같다...");
		}else{
			System.out.println("다르다...");
		}
		System.out.println("-------------------------------------------------");
		
		Season ss = Season.valueOf("봄");
		System.out.println("name : " + ss.name());
		System.out.println("ordinal : " + ss.ordinal());
		System.out.println("span : " + ss.getSpan());
		System.out.println();
		
		// 열거형이름.values() => 모든 상수들을 배열로 가져옴
		for(Season time : Season.values()){
			System.out.println(time.name() + " == " + time + " --> " + time.getSpan());
		}
		
		for(Color co : Color.values()){
			System.out.println(co + " ==> " + co.ordinal());
		}
		
		//열거형을 switch문에서 비교
		//case 옆에는 '상수명'만 기술
		switch(mycol){
			case RED : 
				System.out.println("RED입니다");
				break;
			case GREEN :
				System.out.println("그린...");
				break;
			case BLUE :
				System.out.println("파랑...");
				break;
//			case Color.GREEN  // case 열거형이름.상수명 -> 사용 불가
		}
		
	}

}


















