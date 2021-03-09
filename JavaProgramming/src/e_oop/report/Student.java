package e_oop.report;



public class Student {
	
	int kor;
	int eng;
	int math;
	
	int sum;
	double avg;
	int rank;
	
	String name;
	
	int[] score(){
		kor = (int)(Math.random() * 101);
		eng = (int)(Math.random() * 101);
		math = (int)(Math.random() * 101);
		
		return new int[]{kor, eng, math};
	}

	int sumScore(){
		sum = kor + eng + math;
		return sum;
	}
	
	double avgScore(){
		avg = Math.round((double)sum / 3 * 100) / 100.0;
		return avg;
	}
	
	int setRank(){
		rank = 1;
		return rank;
	}
	
	String setName(int cnt){
		name = "학생" + (cnt+1);
		return name;
	}
	
}