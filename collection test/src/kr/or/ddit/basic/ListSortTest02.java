package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

	public static void main(String[] args) {
		
		ArrayList<Member> memList = new ArrayList<>();
		
		memList.add(new Member(1,"홍길동","010-1111-1111"));
		memList.add(new Member(5,"이순신","010-2222-1111"));
		memList.add(new Member(9,"성춘향","010-3333-1111"));
		memList.add(new Member(3,"강감찬","010-4444-1111"));
		memList.add(new Member(6,"일지매","010-5555-1111"));
		memList.add(new Member(2,"변학도","010-6666-1111"));
		
		System.out.println("정렬전...");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("---------------------------------------");
		
		Collections.sort(memList);
		System.out.println("정렬후...");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("---------------------------------------");
		
		// Member의 num값의 내림 차순으로 정렬하는 외부 정렬 기준을 이용해서 정렬
		Collections.sort(memList, new SortNumDesc());
		System.out.println("회원번호의 내림차순 정렬후...");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("---------------------------------------");
	}

}

// 회원 정보(회원번호, 회원이름, 전화번호)를 처리하는 Member클래스를 작성
// Member클래스는 '회원이름'을 기준으로 오름차순이 되도록 내부 정렬 
class Member implements Comparable<Member>{
	

	private int num;


	private String name;
	private String tel;

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	
	public Member(int num, String name, String tel){
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
	// 자신의 데이터가 앞쪽 데이터, 매개변수에 저장된 데이터가 뒤쪽 데이터
	// 회원이름의 오름차순 정렬 기준 만들기
	@Override
	public int compareTo(Member mem) {
		
		//방법1
		/*if(name.compareTo(mem.getName()) > 0){
			return 1;
		}else if(name.compareTo(mem.getName()) < 0){
			return -1;
		}else{
			return 0;
		}*/
		
		//방법2
		return name.compareTo(mem.getName());
	}
	
}

// Member의 num값을 기준으로 내림차순 정렬하는 외부 정렬 기준 클래스
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
		// 방법1 - 직접 비교
		/*if(mem1.getNum() > mem2.getNum()){
			return -1;
		}else if(mem1.getNum() < mem2.getNum()){
			return 1;
		}else{
			return 0;
		}
		*/
		
		// 방법2 - Wrapper클래스를 이용 1
//		return (new Integer(mem1.getNum()).compareTo(mem2.getNum())) * -1;
		
		// 방법 3 - Wrapper 클래스를 이용 2
		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
	}
	
	
}


















