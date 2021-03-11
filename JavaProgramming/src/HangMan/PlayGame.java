package HangMan;

import java.util.Arrays;

import e_oop.ScanUtill;

public class PlayGame {
	
	
	
	static int cnt;
	
	
	
	String input_str(){
		String answer;
		
		answer = ScanUtill.nextLine();
		return answer;
	}
	
	String input_alpabet(){
		String word = ScanUtill.nextLine();
		return word;
		
	}
	
	
	void check(){
		Keyword key = new Keyword();
		Man man = new Man();
		String[] answer = key.word();
		String[] show = new String[answer[1].length()];
		
		for(int i = 0; i < show.length; i++){
			show[i] = "_";
		}
		
		
		label :while(true){
			
				System.out.println("1.알파벳입력\t2.정답입력");
				int num = ScanUtill.nextInt();
				if(num == 1){
					int ch = 0;
					System.out.print("알파벳 입력>");
					String check = input_alpabet();
					for(int j = 0; j < answer[1].length(); j++){
						
						if(answer[1].charAt(j) == check.charAt(0) ){
							ch++;
							show[j] = check;
							System.out.println("입력하신 단어가 포함 되어있습니다😁\n");
						}
						if(j == answer[1].length() - 1 && ch == 0){
							cnt++;
							System.out.println("입력하신 단어가 포함되어 있지 않습니다😂\n");
						}
					}
				}else{
					System.out.print("정답입력>");
					String check = input_str();
					if(check.equals(answer[1])){
						System.out.println("😊정답입니다^^무사히 HangMan을 구출했어요😊");
						break label;
					}else{
						cnt += 2;
						System.out.println("오답 입니다😈");
					}
				}
				
				if(cnt > 10)
					break;
				
				System.out.println("============현재까지 조합 상태============");
				for(int i = 0; i < show.length; i++){
					System.out.print(show[i] + " ");
				}
				System.out.println();
				System.out.println("======================================");
				System.out.println();
				
				man.warning(cnt);
				man.man_state(cnt);
		}
		
		if(cnt > 10){
			man.dieMan();
		}
		if(cnt <= 10)
			man.smileMan();
		
	}
	
	
	
	
	public static void main(String[] args) {
		new PlayGame().start();
	}
	
	
	void start(){
		Keyword key = new Keyword();
		key.showRule();
		new PlayGame().check();
		
	}

}
