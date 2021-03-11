package HangMan;

import e_oop.ScanUtill;

public class Check {

	Keyword key = new Keyword();
	String[] answer = key.word();
	String[] show = new String[answer[1].length()];
	boolean pass = false;
	
	static int cnt = 0;
	
	
	
	
	void showSet(){
		for(int i = 0; i < show.length; i++){
			show[i] = "_";
		}
	}
	
	void showPrint(){
		System.out.println("==========맞춘 단어 조합==========");
		for(int i = 0; i < show.length; i++){
			System.out.print(show[i] + " ");
		}
		System.out.println("\n==============================");
	}
	
	
	void inputAlphabet_check(){
		
		System.out.print("알파벳 입력👉");
		String check = ScanUtill.nextLine();
		int flag = 0;
	 
		for(int i = 0; i < answer[1].length(); i++){
			if(answer[1].charAt(i) == check.charAt(0)){
				show[i] = check;
				flag++;
				System.out.println("\n입력하신"+ check +"가(이) 포함 되어있습니다😁\n");
			}else if(i == answer[1].length() - 1 && flag == 0){
				cnt++;
				System.out.println("\n입력하신 단어"+ check +"가(이) 포함되어 있지 않습니다😂\n");
			}
		}
	}
	
	
	void inputAnswer_check(){
		System.out.print("정답입력👉");
		String check = ScanUtill.nextLine();
		
		if(check.equals(answer[1])){
			System.out.println("\n😊정답입니다^^무사히 HangMan을 구출했어요😊\n");
			pass = true;
			
		}else{
			cnt += 2;
			System.out.println("\n오답 입니다😈\n");
		}
	}
	
	
	void start(){
		Man man = new Man();
		key.showRule();
		System.out.println("*****정답의 keyword는 \"" + answer[0] + "\" 이며 알파벳" + answer[1].length() + "자 입니다*****\n");
		showSet();
		
		while(true){
			System.out.println("1.알파벳입력\t2.정답입력");
			System.out.print("입력👉");
			int num = ScanUtill.nextInt();
			if(num == 1){
				inputAlphabet_check();
				man.man_state(cnt);
			}else{
				inputAnswer_check();
				if(pass){
					man.smileMan();
				}else if(!pass && cnt <= 10){
				man.man_state(cnt);
				}
			}
			

			if(pass || cnt > 10){
				break;
			}
			showPrint();
			System.out.println();
			
		}
		
		if(cnt > 10){
			System.out.println("정답은 " + answer[1] + " 입니다😫");
			man.dieMan();
		}
		
		
		
	}
}
