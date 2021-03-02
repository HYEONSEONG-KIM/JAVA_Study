package d_array;

import java.util.Arrays;

public class Score {

	public static void main(String[] args) {
		/*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
		 * 0~100 까지 랜덤으로 생성하고, 아래와 같이 출력
		 * 
		 * 			국어 		영어		수학		사회		과학		Oracle		Java	합계		평균		석차	
		 * 홍길동		90		90		90		90		90		90			90		630		90.0 	 1
		 * 홍길동		90		90		90		90		90		90			90		630		90.0 	 1
		 * 홍길동		90		90		90		90		90		90			90		630		90.0 	 1
		 * 홍길동		90		90		90		90		90		90			90		630		90.0 	 1
		 * 홍길동		90		90		90		90		90		90			90		630		90.0 	 1
		 * 과목합계	450		450		450		450		450		450			450		
		 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00		90.00
		 */
		
		int[][] scores = new int[25][7];
		
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				scores[i][j] = (int)(Math.random() * 101);
			}
//			System.out.println(Arrays.toString(scores[i]));
		}
		String[] column = new String[]{"국어", "영어", "수학", "사회", "과학", "Oracle", "Java", "합계", "평균", "석차"};
		
		
		
		String[] students = new String[]{"김병수", "곽명훈" , "김나위", "김성현", "김영광", "김정명", 
				"김찬미", "김현민", "김현성", "류창현", "맹세희", "배병주", "설동비", "양규진", "여지연", 
				"오태훈", "이기정" ,"이상훈", "이재헌", "이치우", "전민주", "조기범", "조영현", "조항민", 
				"최진우"};
		
		String[] etc = new String[]{"과목합계", "과목평균"};
		
		
		int[] sum = new int[scores.length];
		double[] avg = new double[scores.length];
		int[] subSum = new int[scores[0].length];
		double[] subAvg = new double[scores[0].length];
		int[] rank = new int[scores.length];
		
		//각 학생별 과목 합과 평균
		for(int i = 0; i <scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				sum[i] += scores[i][j];
			}
			avg[i] =(double) Math.round((double)sum[i] / scores[i].length * 100) /100;
		}
		
		//과목별 합과 평균
		for(int i = 0; i < scores[0].length; i++){
			for(int j = 0; j < scores.length; j++){
				subSum[i] += scores[j][i];
			}
			subAvg[i] = (double)subSum[i] / scores.length;
		}
		
		
		//석차
		for(int i = 0; i < rank.length; i++){
			rank[i] = 1;
		}
		
		for(int i = 0; i < rank.length; i++){
			double compare = avg[i];
			for(int j = 0; j < rank.length; j++){
				if(compare < avg[j]){
					rank[i] += 1;
				}
			}
		}
		
		
		//출력
		
		
		for(int i = 0; i < column.length; i++){
			System.out.print("\t" + column[i]);
		}
		System.out.println();
		
		for(int i = 0; i < scores.length; i++){
			
			System.out.print(students[i] + "\t");
			
			for(int j = 0; j < scores[i].length; j++){
				System.out.print(scores[i][j] + "\t");
				
			}
			
			System.out.print(sum[i] + "\t"+ avg[i] + "\t" + rank[i]);
			System.out.println();
			
		
			}
		
		for(int i = 0; i < etc.length; i++){
			System.out.print(etc[i]);
			for(int j = 0; j < subSum.length; j++){
				if(i == 0){
				System.out.print("\t" + subSum[j]);
				}else{
					System.out.print("\t" + subAvg[j]);
				}
				
			}
			System.out.println();
		}
		
		
		/*System.out.print("과목합계 \t");
		
		for(int i = 0; i < subSum.length; i++){
			System.out.print(subSum[i] + "\t");
		}
		System.out.println();
		
		System.out.print("과목평균\t");
		
		
		for(int i = 0; i < subAvg.length; i++){
			System.out.print(subAvg[i] + "\t");
		}*/
		
		
		
		
		}
		
		
	


}
