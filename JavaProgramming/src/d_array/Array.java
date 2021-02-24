package d_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {

		/*
		 * 배열
		 * - 여러개의 값을 하나의 변수에 저장해서 사용하는 것
		 * - 참조형 타입
		 * - 인덱스로 값을 구분
		 * - 길이를 변경할 수 없음
		 */
		
		int[] array; //배열의 주소를 저장할 공간
		array = new int[5]; //배열이 생성되고 그 주소가 저장

		/*
		 * 변수 = 주소
		 * 주소{0, 0, 0, 0, 0}
		 */

		//배열 초기화시 기본값이 저장
		
		/*
		 * 기본값
		 * - byte, short, int ,long : 0
		 * - float, double : 0.0
		 * - char : 0(' ')
		 * - boolean : false
		 * - 참조형타입 : null
		 */
		
		array = new int[]{1, 2, 3, 4, 5};
		
//		array = {1, 2, 3, 4, 5}; 선언과 초기화를 동시에 해야함
		int[] array2 = {1, 2, 3, 4, 5};
		
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);
		
		array[0] = 10; //인덱스 값 할당
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;
		
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		} //반복문을 이용하여 배열 인덱스 출력
		
		for(int i = 0; i < array.length; i++){
			array[i] = (i + 1) * 10;
		}	//반복문을 이용하여 배열 인덱스 값 할당
		
		//Q.10개의 정수를 저장할 수 있는 배열을 선언 및 초기화
		int[] array_3;
		array_3 = new int[10];
		
		
		//Q.배열의 모든 인덱스에 1~100사이의 랜덤한 값을 저장
		for(int i = 0; i < array_3.length; i++){
			array_3[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(array_3));
		//Arrays.toString(배열) -> 배열의 모든 요소 문자열로 출력
		
		//Q.배열에 저장된 모든 값의 합계와 평균구하기
		int sum = 0;
		double avg = 0;
		
		for(int i = 0; i < array_3.length; i++){
			sum += array_3[i];
		}
		
		avg = (double)sum / array_3.length;
		System.out.println("합계 : " + sum + " 평균 : " + avg);
		
		//Q.배열에 저장된 값들 중 최솟값과 최댓값 출력
		int max = array_3[0];
		int min = array_3[0];
		int length = array_3.length;
		
		for(int i = 0; i < length; i++){
			
			if(max < array_3[i]){
				max = array_3[i];
			}
			
			if(min > array_3[i]){
				min = array_3[i];
			}
		}

		System.out.println("배열의 최대값 : " + max);
		System.out.println("배열의 최솟값 : " + min);
		
		
	/*	
		
		for(int i = 0; i < length; i++){
			for(int j = i; j < length; j++){
				if(array_3[i] < array_3[j]){
					temp = array_3[j];
					array_3[j] = array_3[i];
					array_3[i] = temp;
					cnt++;
				}
			}
		}
		
		System.out.println(Arrays.toString(array_3));*/
	
		
		
		/*Q.크기가 10인 shuffle 배열을 생성하여 정수 1~10을 인덱스에 차례로 할당 후 
			랜덤함수를 이용해 배열인덱스의 순서 무작위로 바꾸기*/
		
		int[] shuffle = new int[10];
		for(int i = 0; i < shuffle.length; i++){
			shuffle[i] = i + 1;
		}
		System.out.println(Arrays.toString(shuffle));
		
		int ran = 0;
		int temp = 0;
		
		for(int i = 0; i < shuffle.length; i++){
			
			ran = (int)(Math.random() * 9) + 1;
			
			temp = shuffle[0];
			shuffle[0] = shuffle[ran];
			shuffle[ran] = temp;
		}
		System.out.println(Arrays.toString(shuffle));
		
		//Q.1~10 사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력
		
//		int[] randoms = new int[500];
//		int ranCnt = 0;
		
		/*int[] randomsCnt = new int[10];
		for(int i = 0; i < randoms.length; i++){
			
			ran = (int)(Math.random() * 10) + 1;
			randoms[i] = ran;
		}
		
		for(int i = 0; i < randomsCnt.length; i++){
			ranCnt = 0;
			for(int j = 0; j < randoms.length; j++){
				if(i + 1 == randoms[j]){
					ranCnt++;
				}
			}
			randomsCnt[i] = ranCnt;
			System.out.println("랜덤으로 생성 된 500개의 숫자 중 " + (i + 1) +
					"의 갯수는 " + randomsCnt[i] + "개 입니다");
		}
		
		
		System.out.println(Arrays.toString(randomsCnt));
		*/
		
		
/*		for(int i = 0; i < randoms.length; i++){
			
			ran = (int)(Math.random() * 10) + 1;
			randoms[i] = ran;
		}
		
		
		for(int i = 1; i <= 10; i++){
			
			ranCnt = 0;
		
			for(int j = 0; j < randoms.length; j++){
				
				if(i == randoms[j]){
					ranCnt++;
				}
			}
			System.out.println("랜덤으로 생성 된 500개의 숫자 중 " + i +
					"의 갯수는 " + ranCnt + "개 입니다");
		}
*/		
		
		
		int[] counts = new int[10];
		
		for(int i = 0; i < 500; i++){
			int random = (int)(Math.random() * 10) + 1;
			
			counts[random - 1]++;
		}
		
		System.out.println(Arrays.toString(counts));
		
		
		
	}

}

















