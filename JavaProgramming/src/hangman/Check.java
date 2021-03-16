package hangman;

import e_oop.ScanUtill;

public class Check {

	Keyword key = new Keyword();
	String[] answer = key.word();
	String[] show = new String[answer[1].length()];
	String input_check;
	boolean pass = false;
	boolean hint = false;
	String[] alphabet = new String[26];
	
	 int cnt = 0;
	
	
	
	//내가 맞힌 알파벳 보여주는 배열'_'로 셋팅
	void showSet(){
		for(int i = 0; i < show.length; i++){
			show[i] = "_";
		}
	}
	
	
	//show배열 출력
	void showPrint(){
		System.out.println("==========단어 조합 상태==========");
		for(int i = 0; i < show.length; i++){
			System.out.print(show[i] + " ");
		}
		System.out.println("\n==============================");
	}
	
	
	//알파벳 입력 및 체크
	void inputAlphabet_check(){
		
		System.out.print("알파벳 입력👉");
		input_check = ScanUtill.nextLine();
		int flag = 0;
	 
		for(int i = 0; i < answer[1].length(); i++){
			if(answer[1].charAt(i) == input_check.charAt(0)){
				show[i] = input_check;
				flag++;
				alphabetCheck(input_check);
				System.out.println("\n입력하신"+ input_check +"가(이) 포함 되어있습니다😁\n");
			}else if(i == answer[1].length() - 1 && flag == 0){
				cnt++;
				alphabetCheck(input_check);
				System.out.println("\n입력하신 단어"+ input_check +"가(이) 포함되어 있지 않습니다😂\n");
			}
		}
	}
	
	
	void inputAnswer_check(){
		System.out.print("정답입력👉");
		input_check = ScanUtill.nextLine();
		
		if(input_check.equals(answer[1])){
			System.out.println("\n😊정답입니다^^무사히 HangMan을 구출했어요😊\n");
			pass = true;
			
		}else{
			cnt += 2;
			System.out.println("\n오답 입니다😈\n");
		}
	}
	
	
	//힌트
	void hint(){
		hint = true;
		int hintNum = 0;
		String hintStr = "";
		boolean flag = true;
		while(flag){
			hintNum = (int)(Math.random() * answer[1].length());
			hintStr = String.valueOf(answer[1].charAt(hintNum));
			
			for(int i = 0; i < show.length; i ++){
				if(show[i].equals(hintStr)){
					flag = true;
					break;
				}else if(i == show.length - 1 && flag){
					flag = false;
				}
			}
		}
		
		for(int i = 0; i < show.length; i++){
			if(answer[1].charAt(i) == hintStr.charAt(0)){
				show[i] = hintStr;
			}
		}
		alphabetCheck(hintStr);
		
		
		
	}	
	
	
	void alphabetSet(){
		char ch = 'a';
		for(int i = 0; i < alphabet.length; i++){
			alphabet[i] = String.valueOf(ch);
			ch++;
		}
	}
	
	
	void alphabetCheck(String str){
		for(int i = 0; i < alphabet.length; i++){
			if(alphabet[i].equals(str)){
				alphabet[i] = "👊";
			}
		}
	}
	
	
	void alphabetPrint(){
		System.out.println("========입력하지 않은 알파벳=======");
		for(int i = 0; i < alphabet.length; i++){
			System.out.print(alphabet[i] + "  ");
			if((i + 1) % 10 == 0){
				System.out.println();
			}
		}
		System.out.println();
	}
	
	
	
	
	void start(){
		alphabetSet();
		Man man = new Man();
		key.showRule();
		System.out.println("*****정답의 keyword는 \"" + answer[0] + "\" 이며 알파벳" + answer[1].length() + "자 입니다*****\n");
		showSet();
		
		while(true){
			System.out.println("1.알파벳입력\t2.정답입력\t3.힌트");
			System.out.print("입력👉");
			
			int num = ScanUtill.nextInt();
			if(num == 1){
				inputAlphabet_check();
				man.man_state(cnt);
			}else if(num == 2){
				inputAnswer_check();
				if(pass){
					man.smileMan();
				}else if(!pass && cnt <= 10){
				man.man_state(cnt);
				}
			}else if(num == 3 && !hint){
				hint();
			}else if(num == 3 && hint){
				System.out.println("이미 힌트를 사용하셨습니다");
				continue;
			}
			
			if(pass || cnt > 10){
				break;
			}
			alphabetPrint();
			showPrint();
			System.out.println();
		}

		
		if(cnt > 10){
			System.out.println("정답은 " + answer[1] + "입니다😫");
			man.dieMan();
		}
		
	}
}
