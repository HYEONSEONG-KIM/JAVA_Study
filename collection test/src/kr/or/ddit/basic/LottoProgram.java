package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class LottoProgram {
	
	

	Scanner sc = new Scanner(System.in);
	int input;
	
	
	private void start() {
		while(true){
			showStart();
		}
	}

	public static void main(String[] args) {
		
		LottoProgram lp = new LottoProgram();
		lp.start();
		
	}


	private void showStart() {
		
		System.out.println("============================");
		System.out.println("Lotto 프로그램");
		System.out.println("----------------------------");
		System.out.println("1.Lotto\t2.프로그램 종료");
		System.out.println("============================");
		System.out.print("메뉴선택 >>");
		
		input = Integer.parseInt(sc.nextLine());
		
		System.out.println();
		switch(input){
		case 1 : buyLotto();
				break;
				
		case 2 : System.exit(0);
		
		}

		
		

	
	}

	private void buyLotto() {
		
		int cnt = 0;
		int money = 0;
		int changes = 0;
		int lotto = 1000;
		List<List<Integer>> lottoList = new ArrayList<>();
		
		
		System.out.println("(1000원에 로또번호 하나입니다)");
		System.out.print("금액 입력>");
		money = Integer.parseInt(sc.nextLine());
		changes = money;
		
		System.out.println();
		if(money < lotto){
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
			return;
		}
		System.out.println();
		
		
		while(changes >= lotto){
			changes -= lotto;
			cnt++;
		}
		
		for(int i = 0; i < cnt; i++){
			HashSet<Integer> setLotto = new HashSet<>();
			while(setLotto.size() < 6){
				int ran = (int)(Math.random() * 45) + 1;
				setLotto.add(ran);
			}
			List<Integer> list = new ArrayList<>(setLotto);
			lottoList.add(list);
		}
		
		System.out.println("행운의 번호는 다음과 같습니다");
		for(int i = 0; i < lottoList.size(); i++){
			Collections.sort(lottoList.get(i));
			System.out.println("로또번호" + (i+1) + lottoList.get(i));
		}
		System.out.println();
		System.out.println("받은 금액은 " + money + "원이고 거스름돈은  " + changes + "원 입니다");
		System.out.println();
		
	}


}











