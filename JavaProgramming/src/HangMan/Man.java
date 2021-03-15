package HangMan;

public class Man {


	void smileMan(){
		
		String[][] smileMan = new String[11][11];
		
		smileMan[0][2] = "■"; smileMan[0][3] = "■"; smileMan[0][4] = "■"; smileMan[0][5] = "■";
		smileMan[0][6] = "■"; smileMan[0][7] = "■"; smileMan[0][8] = "■"; smileMan[1][1] = "■";
		smileMan[2][0] = "■"; smileMan[3][0] = "■"; smileMan[4][0] = "■"; smileMan[5][0] = "■";
		smileMan[6][0] = "■"; smileMan[7][0] = "■"; smileMan[8][0] = "■"; smileMan[1][9] = "■";
		smileMan[2][10] = "■"; smileMan[3][10] = "■"; smileMan[4][10] = "■"; smileMan[5][10] = "■";
		smileMan[6][10] = "■"; smileMan[7][10] = "■"; smileMan[8][10] = "■";
		smileMan[9][1] = "■"; smileMan[9][9] = "■";
		smileMan[10][2] = "■"; smileMan[10][3] = "■"; smileMan[10][4] = "■"; smileMan[10][5] = "■";
		smileMan[10][6] = "■"; smileMan[10][7] = "■"; smileMan[10][8] = "■";
		
		smileMan[2][3] = "■"; smileMan[3][2] = "■"; smileMan[3][4] = "■";
		smileMan[2][7] = "■"; smileMan[3][6] = "■"; smileMan[3][8] = "■";
		smileMan[6][2] = "■"; smileMan[7][2] = "■"; smileMan[6][8] = "■"; smileMan[7][8] = "■";
		smileMan[8][3] = "■"; smileMan[8][4] = "■"; smileMan[8][5] = "■"; smileMan[8][6] = "■";
		smileMan[8][7] = "■";
	
		
		for(int i = 0; i < smileMan.length; i++){
			for(int j = 0; j < smileMan[i].length; j++){
				if(smileMan[i][j] == null){
					smileMan[i][j] = "□";
					System.out.print(smileMan[i][j] + " ");
				}else{
					System.out.print(smileMan[i][j] + " ");
				}
			}
			System.out.println();
		}
		
	}
	
	
	void dieMan(){
		
		System.out.println("HangMan이...사망하였습니다...😨\n");
		String[][] dieMan = new String[7][11];
		
		dieMan[1][3] = "■";
		dieMan[1][1] = "■"; dieMan[3][5] = "■";
		dieMan[2][3] = "■"; dieMan[2][1] = "■"; dieMan[2][2] = "■";
		dieMan[2][4] = "■"; dieMan[2][5] = "■"; dieMan[3][3] = "■";
		dieMan[4][3] = "■"; dieMan[5][1] = "■"; dieMan[5][2] = "■";
		dieMan[5][3] = "■"; dieMan[5][4] = "■"; dieMan[5][5] = "■";
		dieMan[6][1] = "■"; dieMan[6][5] = "■";
		dieMan[4][7] = "■"; dieMan[4][8] = "■"; dieMan[4][9] = "■";
 		dieMan[5][7] = "■"; dieMan[5][8] = "■"; dieMan[5][9] = "■";
		dieMan[6][7] = "■"; dieMan[6][8] = "■"; dieMan[6][9] = "■";
		
		

		
		for(int i = 0; i < dieMan.length; i++){
			for(int j = 0; j < dieMan[i].length; j++){
				if(dieMan[i][j] == null){
					dieMan[i][j] = "□";
					System.out.print(dieMan[i][j] + " ");
				}else{
					System.out.print(dieMan[i][j] + " ");
				}
			}
			System.out.println();
		}
		
	}
	
	
	void man_state(int cnt){	
	String[][] man = new String[20][14];
	
	System.out.println("👇현재 HangMan의 상태👇");
	
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


