package HangMan;

import java.util.Arrays;

import e_oop.ScanUtill;

public class PlayGame {
	
	static int cnt;
	String[] show;
	
	String input(int num){
		String word;
		String answer;
		
		if(num == 1){
			word = ScanUtill.nextLine();
			return word;
		}else if(num == 2){
			answer = ScanUtill.nextLine();
			return answer;
		}else
		return null;
	}
	
	
	
	void check(String[] keyword){
		String[] str = keyword;
		System.out.println("1.단어입력\t2.정답입력");
		int num = ScanUtill.nextInt();
		if(num == 1){
		String check = input(num);
			for(int i = 0; i < str[1].length(); i++){
				if(str[1].charAt(i) == check.charAt(0)){
					
				} 
			}
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		new PlayGame().start();
	}
	
	
	void start(){
		Keyword key = new Keyword();
		Man man = new Man();
		key.showInfo();
		String[] check = key.word();
		man.man_state(cnt);
		
	}

}
