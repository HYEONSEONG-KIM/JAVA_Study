package e_oop.report;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AllInOne {

	//잉크량, A4용지, 전원
	int ink;
	int paper;
	boolean power;
	
	int max_paper = 100;
	int max_ink = 40;
	
	//전원을 키고 끄는 메서드
	void power(){
		power = !power;
		System.out.println(power ? "On" : "Off");
	}
	
	
	//잉크 충전 메서드
	void addInk(){
		ink = 40;
		ink_balance();
	}
	
	//종이 추가 메서드
	void addPaper(){
		paper = 100;
		paper_balance();
	}
	
	
	//출력시 잉크 종이 소모량 메서드
	void consume(){
		paper -= 2;
		ink --;
	}
	
	//종이 잔량 표시
	void paper_balance(){
		System.out.println("현재 종이의 잔량");
		for(int i = 0; i < max_paper; i++){
			if(i % 5 == 0 && paper >= i){
				System.out.print("■");
			}else if(i % 10 == 0 && paper < i){
				System.out.print("□");
			}
		}
		System.out.println();
		
	}
	
	//잉크잔량표시
	void ink_balance(){
		System.out.println("현재 잉크의 잔량");
		for(int i = 0; i < max_ink; i++){
			if(i % 2 == 0 && ink >= i){
				System.out.print("■");
			}else if(i % 2 == 0 && ink < i){
				System.out.print("□");
			}
		}
		System.out.println();
	}
	
	//경고 출력문
	void Error(int paper, int ink){
		this.paper = paper;
		this.ink = ink;
		
		if(paper == 0){
			System.out.println("종이가 없습니다. 종이를 넣어주세요");
			paper_balance();
		}
		if(ink == 0){
			System.out.println("잉크가 없습니다. 잉크를 충전해주세요");
			ink_balance();
		}
	}
	
	void off_error(){
		System.out.println("전원이 꺼져있습니다. 전원을 켜주세요");
	}
	
	
	//프린트 메서드
	void print(){
		if(power){
			if(paper != 0 && ink != 0){
			consume();
			System.out.println("출력이 완료 되었습니다");
			paper_balance();
			ink_balance();
			}
			Error(paper,ink);
		}else{
			off_error();
		}
	}
	
	//복사 메서드
	void copy(){
		if(power){
			if(paper != 0 && ink != 0){
				scan();
				consume();
				System.out.println("복사가 완료 되었습니다");
				paper_balance();
				ink_balance();
			}
			Error(paper,ink);
		}else{
			off_error();
		}
	}
	
	//스캔 메서드
	void scan(){
		if(power){
			System.out.println("스캔이 완료되었습니다");
		}
		else{
			off_error();
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		AllInOne all = new AllInOne();
		
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.println("1.전원  2.잉크충전  3.종이추가  4.프린트  5.복사  6.스캔  7.종료");
			System.out.print("번호입력>");
			int num = Integer.parseInt(sc.nextLine());
			
			if(num == 7){
				break;
			}
			
			switch(num){
			case 1 : 
				all.power();
				break;
			case 2 :
				all.addInk();
				break;
			case 3 :
				all.addPaper();
				break;
			case 4 :
				all.print();
				break;
			case 5 :
				all.copy();
				break;
			case 6 :
				all.scan();
				break;
			}
			
			
		}
		
		
	}

}
