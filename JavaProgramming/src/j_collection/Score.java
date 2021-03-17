package j_collection;

import java.util.ArrayList;

public class Score {

	public static void main(String[] args) {
		
		/*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
		 * 0~100 까지 랜덤으로 생성해주시고, 아래와 같이 출력해주세요.
		 * 
		 * 			국어		영어		수학		사회		과학		Oracle	Java	합계		평균		석차
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 과목합계	450		450		450		450		450		450		450
		 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00	90.00`
		 */
		
		ArrayList<String> subject = new ArrayList<>();
		ArrayList<String> student = new ArrayList<>();
		
		subject.add("국어");
		subject.add("영어");
		subject.add("수학");
		subject.add("사회");
		subject.add("과학");
		subject.add("Oracle");
		subject.add("Java");
		
		for(int i = 0; i < 5; i++){
			String std= "std" + (i + 1);
			student.add(std);
		}
	
		//점수할당
		ArrayList<ArrayList<Integer>> score = new ArrayList<>();
		
		ArrayList<Integer> scorelist;
		for(int i = 0; i < student.size(); i++){
			
			scorelist = new ArrayList<>();
			for(int j = 0; j < subject.size(); j++){
				int scoreNum = (int)(Math.random() * 101);
				scorelist.add(j, scoreNum);
			}
			score.add(i,scorelist);
		}
	
		
		//합계 평균
		ArrayList<Integer> sum = new ArrayList<>();
		ArrayList<Double> avg = new ArrayList<>();
		
		for(int i = 0; i < student.size(); i++){
			int Sum = 0;
			double Avg = 0;
			for(int j = 0; j < subject.size(); j++){
				Sum += score.get(i).get(j);
			}
			Avg = Math.round((double)Sum/subject.size() * 100) / 100.0 ;
			sum.add(Sum);
			avg.add(Avg);
		}
		
		//석차
		ArrayList<Integer> rank = new ArrayList<>();
		
		for(int i = 0; i < student.size(); i++){
			int Rank = 1;
			int check = sum.get(i);
			for(int j = 0 ; j < sum.size(); j++){
				if(check < sum.get(j)){
					Rank++;
				}
			}
			rank.add(i, Rank);
		}

		
		//동일점수시 석차 수정
		for(int i = 0; i < student.size() - 1; i++){
			for(int j = i + 1; j < student.size(); j++){
				if(sum.get(i) == sum.get(j) && rank.get(i) < rank.get(j)){
					int change = rank.get(i) - 1;
					rank.set(j,change);
					
				}
			}
		}
		
		
		
		//석차순 정렬
		for(int i = 0; i < student.size(); i++){
			int min = i;
			for(int j = i + 1; j < student.size(); j++){
				if(rank.get(min) > rank.get(j)){
					min = j;
				}
			}
			int temp = rank.get(min);
			rank.set(min, rank.get(i));
			rank.set(i, temp);
			
			temp = sum.get(min);
			sum.set(min, sum.get(i));
			sum.set(i, temp);
			
			double temp2 = avg.get(min);
			avg.set(min, avg.get(i));
			avg.set(i, temp2);
			
			scorelist = new ArrayList<>();
			scorelist = score.get(min);
			score.set(min, score.get(i));
			score.set(i,scorelist);
			
			String temp3 = student.get(min);
			student.set(min, student.get(i));
			student.set(i, temp3);
		}
		
		
		//과목 합계 평균
		ArrayList<Integer> subSum = new ArrayList<>();
		ArrayList<Double> subAvg = new ArrayList<>();
		
		for(int i = 0; i < subject.size(); i++){
			int SubSum = 0;
			double SubAvg = 0;
			for(int j = 0; j < student.size(); j++){
				SubSum += score.get(j).get(i);
			}
			SubAvg = Math.round((double)SubSum / student.size() * 100) / 100.0;
			subSum.add(SubSum);
			subAvg.add(SubAvg);
		}
		
		
		//출력
		for(int i = 0; i < subject.size(); i++){
			System.out.print("\t" + subject.get(i));
		}
		System.out.println("\t합계\t평균\t석차");
		
		
		for(int i = 0; i < student.size(); i++){
			System.out.print(student.get(i) + "\t");
			for(int j = 0; j < subject.size(); j++){
				System.out.print(score.get(i).get(j) + "\t");
			}
			System.out.println(sum.get(i) + "\t" + avg.get(i) + "\t" + rank.get(i));
			
		}
		
		System.out.print("과목합계" + "\t");
		for(int i = 0; i < subject.size(); i++){
			System.out.print(subSum.get(i) + "\t");
		}
		System.out.println();
		System.out.print("과목평균" + "\t");
		for(int i = 0; i < subject.size(); i++){
			System.out.print(subAvg.get(i) + "\t");
		}
		
		//
		
		
		
		
	}

}
















