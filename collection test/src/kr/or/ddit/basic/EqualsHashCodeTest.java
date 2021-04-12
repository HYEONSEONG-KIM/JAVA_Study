package kr.or.ddit.basic;

import java.util.HashSet;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("홍길동");

		Person p2 = new Person();
//		p2.setId(2);
//		p2.setName("일지매");
		
		p2.setId(1);
		p2.setName("홍길동");
		
		Person p3 = p1;
		
		System.out.println(p1 == p2);
		System.out.println(p1 == p3);

		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		
		HashSet<Person> testSet = new HashSet<>();
		
		testSet.add(p1);
		testSet.add(p2);
		System.out.println("set의 개수 : " + testSet.size());
		
		//hashcode를 재정의 하는 이유 : equals가 객체안의 데이터를 비교하여 동일성 여부를 체크하는 것이라면, hashcode는 객체 자체를 비교하여 동일성 여부를 체크
		// => set같은 경우에 객체를 add할 경우 hashcode를 재정의하여 같은 데이터가 들어있는 객체들을 같은 객체로 정의하여 1개의 객체만 add되도록 함 
		System.out.println("p1 : " + p1.hashCode());
		System.out.println("p2 : " + p2.hashCode());
		System.out.println("p3 : " + p3.hashCode());
	}
	

}

class Person{
	
	private int id;
	private String name;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	//id변수값과 name변수값 두가지 모두 같은 값이면 true를 반환하도록 재정의
	//@Override
	/*public boolean equals(Object obj) {
		
		if(this == obj){
			return true;
		}
		
		if(obj == null){
			return false;
		}
		
		if(this.getClass() != obj.getClass()){	// 같은 유형의 클래스인지 검사
			return false;
		}
		
		Person that = (Person)obj;
		
		if(this.name == null && that.name != null){
			return false;
		}
		
		if(this.id == that.id && this.name == that.name){
			return true;
		}
		
		if(this.id == that.id && this.name.equals(that.name)){
			return true;
		}
		
		return false;
	}*/
	
	
	
}

















