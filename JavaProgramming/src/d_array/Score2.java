package d_array;

public class Score2 {

	public static void main(String[] args) {
		
		String[] subjects = new String[] {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};
		String[] students = new String[]{"김병수", "곽명훈" , "김나위", "김성현", "김영광", "김정명", 
				"김찬미", "김현민", "김현성", "류창현", "맹세희", "배병주", "설동비", "양규진", "여지연", 
				"오태훈", "이기정" ,"이상훈", "이재헌", "이치우", "전민주", "조기범", "조영현", "조항민", 
				"최진우"};
		int[][] scores = new int[students.length][subjects.length];
		
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				scores[i][j] = (int)(Math.random() * 101);
			}
		}
		
		int[] stdSum = new int[students.length];
		double[] stdAvg = new double[students.length];
		
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				stdSum[i] += scores[i][j];
			}
			stdAvg[i] = Math.round((double)stdSum[i] / scores[i].length * 100) / 100.0;
		}
		
		
		int[] subSum = new int[subjects.length];
		double[] subAvg = new double[subjects.length];
		
		for(int i = 0; i < subjects.length; i++){
			for(int j = 0; j < scores.length; j++){
				subSum[i] += scores[j][i];
			}
			subAvg[i] = Math.round((double)subSum[i] / scores.length * 100) / 100.0;
		}
		
		
		int[] rank = new int[students.length];
		
		for(int i = 0; i < rank.length; i++){
			rank[i] = 1;
				for(int j = 0; j < rank.length; j++){
					if(stdSum[i] < stdSum[j]){
						rank[i]++;
					}
				}
		}
		
		
		for(int i = 0; i < subjects.length; i++){
			System.out.print("\t" + subjects[i]);
		}
		
		System.out.println("\t합계\t평균\t석차");
		
		for(int i = 0; i < scores.length; i++){
			System.out.print(students[i] + "\t");
			for(int j = 0; j < scores[i].length; j++){
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println(stdSum[i] + "\t" + stdAvg[i] + "\t" + rank[i]);
		}
		
		System.out.print("과목합계" + "\t");
		for(int i = 0; i < subSum.length; i++){
			System.out.print(subSum[i] + "\t");
		}
		System.out.println();
		System.out.print("과목평균" + "\t");
		for(int i = 0; i < subAvg.length; i++){
			System.out.print(subAvg[i] + "\t");
		}
		
		
	}

}
