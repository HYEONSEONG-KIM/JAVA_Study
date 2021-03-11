package f_game;

public class Test {

	public static void main(String[] args) {
		
		String[][] dieMan = new String[7][11];
		
		dieMan[1][3] = "■";
		dieMan[1][1] = "■"; dieMan[3][5] = "■";
		dieMan[2][3] = "■"; dieMan[2][1] = "■"; dieMan[2][2] = "■";
		dieMan[2][4] = "■"; dieMan[2][5] = "■"; dieMan[3][3] = "■";
		dieMan[4][3] = "■"; dieMan[5][1] = "■"; dieMan[5][2] = "■";
		dieMan[5][3] = "■"; dieMan[5][4] = "■"; dieMan[5][5] = "■";
		dieMan[6][1] = "■"; dieMan[6][5] = "■";
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
		
		
		System.out.println();
		System.out.println();System.out.println();
		
		
		
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
	
	

}
