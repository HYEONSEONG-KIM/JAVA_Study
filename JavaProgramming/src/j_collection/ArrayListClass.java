package j_collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListClass {

	public static void main(String[] args) {
		/*
		 * Collections Framework : 다수의 데이터를 다루기 위한 표준화된 방법
		 * - List => 배열과 같고 index를 가짐
		 * - Map => key와 value를 가짐
		 * - Set = > index라는 개념이 없음, 값이 중복되지 않음
		 *
		 * 
		 * boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부 반환(순서대로 저장)
		 * void add(int index, Object obj) : 지정된 위치에 객체를 추가
		 * Object set(int index, Object obj) : 지정된 위치에 객체를 저장 후 기존 객체를 반환
		 * Object get(int index) : 지정된 위치에 객체를 반환
		 * int size() : 저장된 객체의 수를 반환
		 * boolean remove(int index) : 지정된 위치의 객체를 제거
		 */

		ArrayList sample = new ArrayList();
		
		sample.add("abc");
		sample.add(100);
		sample.add(new Scanner(System.in));
		
		//제네릭
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
//		list.add("abc");
		list.add(20);
		System.out.println(list.add(30));
		System.out.println(list);
		
		list.add(1, 40); //1번 인덱스부터 뒤로 밀고 값을 저장
		System.out.println(list);
		
//		list.add(5,50);
		

		Integer before = list.set(2,50);
		System.out.println("before : " + before);
		System.out.println("after : " + list.get(2));
		System.out.println(list);
		
		Integer integer = list.get(2);
		System.out.println(integer);
		
/*		for(int i = 0; i < list.size(); i++){
			System.out.println(i + " : " + list.get(i));
			
			list.remove(i);
		}
		
		System.out.println(list);
*/
		
		//값을 제거 할 때는 뒤에서부터 제거
		for(int i = list.size() -1; i >= 0; i--){
			System.out.println(i + " : " +  list.get(i));
			list.remove(i);
		}
		System.out.println(list);
	
		
		//Q.list에 1~100사이의 랜덤값을 10개 저장
		for(int i = 0; i < 10; i++){
			list.add(i,(int)(Math.random()*100) + 1);
		}
		System.out.println(list);
		
		//list에 저장된 값의 합계와 합계의 평균
		int sum = 0;
		double avg = 0;
		
		for(int i = 0; i < list.size(); i++){
			sum += list.get(i);
		}
		
		avg = Math.round((double)sum / list.size() * 100) / 100;
		
		System.out.println("합계 : " + sum + "\t평균 : " + avg);
		
		
		/*
		 * byte : Byte
		 * short : Short
		 * int : Integer
		 * long : Long
		 * float : Float
		 * double : Double
		 * char : Character
		 * boolean : Boolean
		 * 
		 * 서로 자동으로 형 변환
		 */
		
		//Q.list에서 최소값 최대값 출력
		Integer max = list.get(0);
		Integer min = list.get(0);
		
		for(int i = 0; i < list.size(); i++){
			if(max < list.get(i)){
				max = list.get(i);
			}
			
			if(min > list.get(i)){
				min = list.get(i);
			}
		}
		
		System.out.println("최소값 : " + min + " / 최대값 : " + max);
		
		//Q.list를 오름차순으로 정렬
		
		for(int i = 0; i < list.size(); i++){
			int minIndex = i;
			for(int j = i + 1; j < list.size(); j++){
				if(list.get(minIndex) > list.get(j)){
					minIndex = j;
				}
			}
			int temp = list.get(minIndex);
			list.set(minIndex, list.get(i));
			list.set(i, temp);
		}
		
		/*for(int i = 0; i < list.size() - 1; i++){
			int temp;
			boolean check = true;
			for(int j = 0; j < list.size() -1 - i; j++ ){
				if(list.get(j) > list.get(j + 1)){
					temp = list.get(j + 1);
					list.set(j + 1, list.get(j));
					list.set(j, temp);
					check = false;
				}
			}
			
			if(check){
				break;
			}
		}*/
		
		System.out.println(list);
		
		
		//2차원
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
		
		list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list2.add(list);
		
		list = new ArrayList<>();
		list2.add(list);
		list.add(40);
		list.add(50);
		
		System.out.println(list2);
		
		for(int i = 0; i < list2.size(); i++){
			ArrayList<Integer> li = list2.get(i);
			for(int j = 0; j < li.size(); j++){
				System.out.print(li.get(j) + "\t");
			}
			System.out.println();
		}
		
		Integer integer2 = list2.get(0).get(1);
		System.out.println(integer2);
		
		
	}

}



















