package kr.or.ddit.basic;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StuedentTest {

	public static void main(String[] args) {
		/*Q.학번(int), 이름(String),  국어점수, 영어점수, 수학점수, 총점, 등수(모두 int)를 멤버로 갖는 
		Student클래스 만들기
		이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화
		(총점은 세 과목의 점수를 이용해서 초기화)
		
		이 student 객체는 List에 저장하여 관리
		
		List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬기준 구현,
		총점의 역순으로 정렬하는데 총점이 같으면 이름의 내림차순으로 정렬
		정렬된 결과를 출력
		등수는 List에 전체 데이터가 추가된 후에 저장
		*/
		
		
		List<Student> stdList = new ArrayList<>();
		
		stdList.add(new Student(1,"홍길동",80,97,70));
		stdList.add(new Student(5,"김첨지",73,99,60));
		stdList.add(new Student(6,"강감찬",77,78,100));
		stdList.add(new Student(4,"성춘향",100,68,90));
		stdList.add(new Student(3,"이몽룡",80,97,70));
		
		
		for(int i = 0; i < stdList.size(); i++){
			int sum = stdList.get(i).getKorean() + stdList.get(i).getMath() + stdList.get(i).getEnglish();
			stdList.get(i).setRank(1);
			stdList.get(i).setTotalScore(sum);
		}
		
		
		for(int i = 0; i < stdList.size(); i++){
			for(int j = 0; j < stdList.size(); j++){
				if(stdList.get(i).getTotalScore() < stdList.get(j).getTotalScore()){
					stdList.get(i).setRank(stdList.get(i).getRank() + 1);
				}
			}
		}
		
		
		Collections.sort(stdList);
		System.out.println();
		for(Student std : stdList){
			System.out.println(std);
		}
		
		
		Collections.sort(stdList,new SortTotalDesc());
		System.out.println();
		for(Student std : stdList){
			System.out.println(std);
		}
	}

}

class Student implements Comparable<Student>{
	
	private int stdNum;
	private String name;
	private int korean;
	private int english;
	private int math;
	private int totalScore;
	private int rank;
	
	
	public Student(int stdNum, String name, int korean, int english, int math) {
		super();
		this.stdNum = stdNum;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}


	@Override
	public String toString() {
		return "Student [stdNum=" + stdNum + ", name=" + name + ", korean="
				+ korean + ", english=" + english + ", math=" + math
				+ ", totalScore=" + totalScore + ", rank=" + rank + "]";
	}


	public int getStdNum() {
		return stdNum;
	}


	public void setStdNum(int stdNum) {
		this.stdNum = stdNum;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKorean() {
		return korean;
	}


	public void setKorean(int korean) {
		this.korean = korean;
	}


	public int getEnglish() {
		return english;
	}


	public void setEnglish(int english) {
		this.english = english;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public int getTotalScore() {
		return totalScore;
	}


	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	@Override
	public int compareTo(Student std) {
		
		return Integer.compare(stdNum, std.getStdNum());
	}

	
}



class SortTotalDesc implements Comparator<Student>{

	@Override
	public int compare(Student std1, Student std2) {
		
		if(std1.getTotalScore() > std2.getTotalScore()){
			return -1;
		}else if(std1.getTotalScore() > std2.getTotalScore()){
			return 1;
		}else if(std1.getTotalScore() == std2.getTotalScore()){
			if(std1.getName().compareTo(std2.getName()) > 0){
				return -1;
			}else if(std1.getName().compareTo(std2.getName()) < 0){
				return 1;
			}else{
				return 0;
			}
		}else{
			return 0;
		}
		
	}
	
}













