package HangMan;

public class Keyword {
	
	
	//과일, 국산차, 컴퓨터 용품, 동물
	String[][] keyword = {
							{"과일", "apple", "banana", "watermelon", "orange", "grape"},
							{"국산차량", "sonata", "tusan", "avante"},
							{"컴퓨터 용품", "monitor", "print", "mouse", "keyboard"},
							{"동물", "tiger", "dog", "cat", "snake", "Crocodile"},
							{"프로그래밍", "java", "oracle", "spring", "javascript"},
						};
	
	
	void showRule(){
		System.out.println("=================HangMan에 오신걸 환영합니다=================");
		System.out.println("게임의 룰을 설명 드리겠습니다");
		System.out.println("1.자동으로 영단어 하나가 뽑히며 동시에 정답의 키워드를 알려드립니다");
		System.out.println("2.단어 맞추기와 정답 맞추기중 선택하시고, 선택하신 항목에 따라 입력값을 입력해주세요");
		System.out.println("3.단어 선택시 입력하신 단어가 정답에 포함되어 있으면 해당 위치를 알려 드립니다");
		System.out.println("4.입력하신 단어가 포함 되어있지 않으면 목숨은 1 줄어듭니다");
		System.out.println("5.정답을 선택하여 입력시 맞추시면 게임은 종료되며 오답일시 목숨은 2개가 줄어듭니다");
		System.out.println("6.게임 중 힌트는 1개가 제공 되며 단어중 하나의 알파벳을 알려줍니다");
		System.out.println("7.목숨은 총 10개이며, 현재 목숨은 그림으로 표시되고, 천장이 머리보다 아래로 가게되면 HnagMan이사망합니다");
		System.out.println("===================지금부터 게임을 시작합니다===================\n\n");
	}
	
	
	String[] word(){
		int column = (int)(Math.random() * keyword.length);
		int row = (int)(Math.random() * keyword[column].length);
		if(row == 0){
			row++;
		}
		String word = keyword[column][row];
		String key = keyword[column][0];
		
		
		return new String[]{key, word};
	}
	
	
	
	
}
