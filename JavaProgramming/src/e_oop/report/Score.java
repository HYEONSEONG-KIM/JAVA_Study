package e_oop.report;

import java.util.Arrays;



public class Score {

	public static void main(String[] arg){
		
		Student[] students = new Student[10];
		
		for(int i = 0; i < students.length; i++){
			Student student = new Student();
			student.score();
			student.sumScore();
			student.avgScore();
			student.setRank();
			student.setName(i);
			students[i] = student;
		}
		
		
		for(int i = 0; i < students.length; i++){
			students[i].rank = 1;
			for(int j = 0; j < students.length; j++){
				if(students[i].sum < students[j].sum){
					students[i].rank++;
				}
			}
			
		}
		
		for(int i = 0; i < students.length -1; i++){
			for(int j = i + 1; j < students.length; j++){
			if(students[i].avg == students[j].avg && students[i].rank < students[j].rank){
				students[j].rank--;
			}
			}
		}
		
		
		
		
		for(int i = 0; i < students.length; i++){
			int min = i;
			for(int j = i + 1; j <students.length; j++){
				if(students[i].rank <students[min].rank){
					min = j;
				}
				
			}
			Student temp = students[i];
			students[i] = students[min];
			students[min] = temp;
		}
		
		
		System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t석차" );
		for(int i = 0; i < students.length; i++){
			System.out.println(students[i].name + "\t" + students[i].kor +
					"\t" + students[i].eng + "\t" + students[i].math + "\t" + 
					students[i].sum + "\t" + students[i].avg + "\t" + students[i].rank);
		}
		
		
		for(int i = 0; i < students.length - 1; i++){
			Student temp = new Student();
			for(int j = 0; j < students.length -1 -i; j++){
			if(students[j].rank > students[j+1].rank){
				temp = students[j+1];
				students[j+1] = students[j];
				students[j] = temp;
			}
			}
		}
	
		int[] subSum = new int[3];
		double[] subAvg = new double[3];
		
		for(int i = 0 ; i < students.length; i++){
			subSum[0] += students[i].kor;
			subSum[1] += students[i].eng;
			subSum[2] += students[i].math;
		}
		
		for(int i = 0; i < subAvg.length; i++){
			subAvg[i] = Math.round((double)subSum[i] / students.length * 100) / 100.0;
		}
		
		System.out.println("과목합계\t"+ subSum[0] + "\t" + subSum[1] + "\t" + subSum[2]);
		System.out.println("과목평균\t"+ subAvg[0] + "\t" + subAvg[1] + "\t" + subAvg[2]);
		
		
		
	}
	 
	
			
			
			
	

	
	
	
	
}
