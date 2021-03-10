package HangMan;

public class Man {


	
	
	void man_state(int cnt){
	
	
	String[][] man = new String[20][14];
	
	if(cnt <= 10){
	for(int i = 0; i < cnt; i++){
		for(int j = 0; j < man[i].length; j++){
			man[i][j] = "■";
		}
	}
	
	man[10][5] = "■"; man[10][6] = "■"; man[10][7] = "■";
	man[11][5] = "■"; man[11][6] = "■"; man[11][7] = "■";
	man[12][5] = "■"; man[12][6] = "■"; man[12][7] = "■";
	man[13][4] = "■"; man[13][6] = "■"; man[14][4] = "■";
	man[14][5] = "■"; man[14][6] = "■"; man[14][7] = "■";
	man[14][8] = "■"; man[15][6] = "■"; man[15][8] = "■";
	man[16][6] = "■"; man[17][4] = "■"; man[17][5] = "■";
	man[17][7] = "■"; man[17][8] = "■"; man[18][4] = "■";
	man[18][8] = "■"; man[19][4] = "■"; man[19][8] = "■";
	
	for(int i = 0; i < man.length; i++){
		for(int j = 0; j < man[i].length; j++){
			if(man[i][j] == null){
				man[i][j] = "□";
				System.out.print(man[i][j] + " ");
			}else{
				System.out.print(man[i][j] + " ");
			}
		}
		System.out.println();
	}
	}
	}
	
}


