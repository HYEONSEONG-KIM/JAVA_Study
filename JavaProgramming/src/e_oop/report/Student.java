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
		sum = kor + eng + math;
		rank = 1;
		return new int[]{kor, eng, math, sum, rank};
	}
	

	
	
	double avgScore(){
		avg = Math.round((double)sum / 3 * 100) / 100.0;
		return avg;
	}
	
	
	
	
	String setName(int cnt){
		name = "학생" + (cnt+1);
		return name;
	}
	
}