package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {

		/*
		 * 조건문
		 * - if문
		 * - switch문
		 * 
		 * if문
		 * - if(조건식){} : 조건식의 결과가 true이면 블럭한의 문장을 수행
		 * - else if(조건식){} : 다수의 조건이 필요할 때 if 뒤에 추가
		 * - else{} : 결과가 true인 조건식이 하나도 없는 경우를 위해 추가
		 */

		
		int a = 1;
		
		if(a == 1){
			System.out.println("조건식의 연산결과가 true이면 수행된다.");
		}
		
		if(a == 0){
			System.out.println("조건식의 연산결과가 false이면 수행되지 않는다.");
		}
		
		
		if(a == 1){
			System.out.println("a가 1인 경우에 하고싶은 것");
		}else if(a == 2){
			System.out.println("a가 2인 경우에 하고싶은 것");
		}else if(a == 3){
			System.out.println("a가 3인 경우에 하고싶은 것");
		}else{
			System.out.println("이외의 경우에 하고싶은 것");
		}
		
		//조건을 한 묶음으로 사용하기 위해서는 반드시 else if를 사용
		if(a < 10){
			System.out.println("a가 10보다 작다");
		}
		if(a < 20){
			System.out.println("a가 20보다 작다");
		}
	
		//Q.시험점수가 60점 이상이면 합격, 그렇지 않으면 불합격
		int score = 50;
		
		if(score >= 60){
			System.out.println("합격");
		}else{
			System.out.println("불합격");
		}
		
		//Q.성적에 등급을 부여하는 프로그램
		score = 80;
		String grade = null;
		
		if(score >= 90){
			grade = "A";
		}else if(score >= 80){
			grade = "B";
		}else if(score >= 70){
			grade = "C";
		}else if(score >= 60){
			grade = "D";
		}else{
			grade = "F";
		}
		
		System.out.println("성적은 "+ grade +"입니다");
		
		//Q.성적을 +,-까지 분기
		score = 80;
		grade = null;
		
		if(score >= 90){
			grade = "A";
			if(score >= 97){
				grade += "+";
			}else if(score <= 93){
				grade += "-";
			}
		}else if(score >= 80){
			grade = "B";
			if(score >= 87){
				grade += "+";
			}else if(score <= 83){
				grade += "-";
			}
		}else if(score >= 70){
			grade = "C";
			if(score >= 77){
				grade += "+";
			}else if(score <= 73){
				grade += "-";
			}
		}else if(score >= 60){
			grade = "D";
			if(score >= 67){
				grade += "+";
			}else if(score <= 63){
				grade += "-";
			}
		}else{
			grade = "F";
		}
		 
		System.out.println("성적은 "+ grade +"입니다");
		
		
		/*
		 * switch문
		 * - switch(int/String){ case 1 : break; }
		 * - 조건식의 결과는 정수와 문자열만(JDK1.7부터 문자열 허용) 허용
		 * - 조건식과 일치하는 case문 이후의 문장을 수행
		 */
		
		a = 1;
		
		switch(a){
		
		case 1 : 
			System.out.println("a가 1인 경우에 하고싶은 것");
			break;
		
		case 2 : 
			System.out.println("a가 2인 경우에 하고싶은 것");
			break;
		
		default : 
			System.out.println("이외에 경우에 하고싶은 것");
		}
		
		String b = "a";
		
		switch(b){
		
		case "a" : 
			System.out.println("b가 \"a\"인 경우에 하고싶은것");
			break;
		case "b" : 
			System.out.println("b가 \"b\"인 경우에 하고싶은것");
			break;
		default :
			System.out.println("이외의 경우에 하고싶은 것");
		}
		
		//같은 조건일때 switch문이 if문보다 조금더 빠름

		//Q.주어진 월에 해당하는 계절을 출력
		
		int month = 1;
		String season = null;
		
		switch(month){
		
		case 3 :
		case 4 :
		case 5 :
			season = "Spring";
			break;
			
		case 6 :
		case 7 :
		case 8 :
			season = "Summer";
			break;
			
		case 9 :
		case 10 :
		case 11 :
			season = "Fall";
			break;
		
		default : 
			season = "Winter";
		}
		
		System.out.println(month + "월은 " + season + "입니다");
		
		//Q.switch문을 이용하여 성적의 등급
		
		score = 90;
		grade = null;
		
		switch(score / 10){
		
		case 9 : 
			grade = "A";
			break;
		
		case 8 :
			grade = "B";
			break;
		
		case 7 :
			grade = "C";
			break;
			
		case 6 :
			grade = "D";
			break;
		
		default : 
			grade = "F";
		
		}
		
		System.out.println(score + "점에 해당하는 성적은 " + grade + "입니다");
		
		//Q.숫자를 입력받아 그 숫자가 0인지 0이 아닌지 출력
		Scanner sc =new Scanner(System.in);
		int num;
		
	/*	System.out.print("숫자 입력>");
		num = Integer.parseInt(sc.nextLine());
		
		if(num == 0){
			System.out.println("입력받은 숫자는 0입니다");
		}else{
			System.out.println("입력받은 숫자는 0이 아닙니다");
		}*/
		
		
		//Q.숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력
		
	/*	System.out.println("숫자 입력>");
		num = Integer.parseInt(sc.nextLine());
		
		if(num % 2 == 0){
			System.out.println("짝수 입니다");
		}else{
			System.out.println("홀수 입니다");
		}*/
		
		
		//Q.점수 3개를 입력받아 총점, 평균, 등급 출력
	/*	int score_1, score_2, score_3;
		int sum;
		double avg;
		
		System.out.println("첫번째 점수 입력>");
		score_1 = Integer.parseInt(sc.nextLine());
		System.out.println("두번째 점수 입력>");
		score_2 = Integer.parseInt(sc.nextLine());
		System.out.println("세번째 점수 입력>");
		score_3 = Integer.parseInt(sc.nextLine());
		
		sum = score_1 + score_2 + score_3;
		avg = sum / 3.0;
		avg = Math.round(avg*100) / 100.0;
		
		if(avg >=90){
			grade = "A";
			if(avg >=97){
				grade += "+";
			}else if(avg <= 93){
				grade += "-";
			}	
		}else if(avg >=80){
			grade = "B";
			if(avg >=87){
				grade += "+";
			}else if(avg <= 83){
				grade += "-";
			}	
		}else if(avg >=70){
			grade = "C";
			if(avg >=77){
				grade += "+";
			}else if(avg <= 73){
				grade += "-";
			}	
		}else if(avg >=60){
			grade = "D";
			if(avg >=67){
				grade += "+";
			}else if(avg <= 63){
				grade += "-";
			}	
		}else{
			grade = "F";
		}
		
		System.out.println("총점 : "+ sum + " 평균 : " + avg + " 등급 : " + grade);*/
		
		
		
		//Q.1~100 사이의 램덤한 수를 3개 발생시키고 오름차순으로 정렬
		
		int ran_1, ran_2, ran_3;
		ran_1 = (int)(Math.random() * 100) + 1;
		ran_2 = (int)(Math.random() * 100) + 1;
		ran_3 = (int)(Math.random() * 100) + 1;
	
		System.out.println("정렬 전 : " + ran_1 + " " + ran_2 + " " + ran_3);
		
		//case 1
		int max_1 = 0;
		int max_2 = 0; 
		int max_3 = 0;
		
		
		if(ran_1 > ran_2 && ran_1 > ran_3){
			
			max_1 = ran_1;
			
			if(ran_2 > ran_3){
				max_2 = ran_2;
				max_3 = ran_3;
			}else if(ran_2 < ran_3){
				max_2 = ran_3;
				max_3 = ran_2;
			}
		
		}else if(ran_2 > ran_1 && ran_2 > ran_3){
			
			max_1 = ran_2;
			
			if(ran_1 > ran_3){
				max_2 = ran_1;
				max_3 = ran_3;
			}else if(ran_1 < ran_3){
				max_2 = ran_3;
				max_3 = ran_1;
			}
		
		}else if(ran_3 > ran_1 && ran_3 > ran_2){
			
			max_1 = ran_3;
			
			if(ran_1 > ran_2){
				max_2 = ran_1;
				max_3 = ran_2;
			}else if(ran_1 < ran_2){
				max_2 = ran_2;
				max_3 = ran_1;
			}
		
		}
		
		
		System.out.println("case 1 정렬 후 : " + max_3 + " " + max_2 + " " + max_1);

	
		//case 2
		int temp;
		
		if(ran_1 > ran_2){
			temp = ran_1;
			ran_1 = ran_2;
			ran_2 = temp;
		}
		if(ran_1 > ran_3){
			temp = ran_1;
			ran_1 = ran_3;
			ran_3 = temp;
		}
		if(ran_2 > ran_3){
			temp = ran_2;
			ran_2 = ran_3;
			ran_3 = temp;
		}
		
		System.out.println("case 2 정렬 후 : " + ran_1 + " " + ran_2 + " " + ran_3);
	
	
	
	
	
	}
}














