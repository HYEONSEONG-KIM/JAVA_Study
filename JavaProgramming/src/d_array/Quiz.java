package d_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args) {
		//1.거스름돈 동전의 갯수
		int money = (int)(Math.random() * 500) * 10;
		int[] coin = {500, 100, 50, 10};
		System.out.println("거스름돈 : " + money);
		
		/*
		 * 거스름돈에 동전의 단위마다 몇개의 동전이 필요한지 출력
		 * 
		 * ex)
		 * 거스름돈 : 2860원
		 * 500원 : 5개
		 * 100원 : 3개
		 * 50원   : 1개
		 * 10원   : 1개
		 */
		
	/*	for(int i = 0; i < coin.length; i++){
			int cnt = 0;
			
			while(true){
				if(money - coin[i]*cnt >= coin[i]){
					cnt++;
				}else{
					break;
				}
			}
			money -= coin[i] * cnt;
			System.out.println(coin[i] + "원 : " + cnt + "개");
	
		}*/
		
		
		/*for(int i = 0; i < coin.length; i++){
			int cnt = money / coin[i];
			money -= coin[i] * cnt;
			System.out.println(coin[i] + "원 : " + cnt + "개");
		}*/
		
		for(int i = 0; i < coin.length; i++){
			System.out.println(coin[i] + "원 : " + money / coin[i] + "개");
			money %= coin[i];
		}
		
		//2.그래프 그리기
		/*int[] arr = new int[20];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * 5) + 1;
		}
		System.out.println(Arrays.toString(arr));*/
		
		/*
		 * 1~5사의 숫자가 발생된 만큼 *을 사용해 그래프를 그리기
		 * 
		 * ex)
		 * 1 : ***3
		 * 2 : **** 4
		 * 3 : ** 2
		 * 4 : ***** 5
		 * 5 : ******6
		 */
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * 5) + 1;
		}
		System.out.println(Arrays.toString(arr));
		
		/*for(int i = 1; i <= 5; i++){
			System.out.print(i + " : ");
			int cnt = 0;
			
			for(int j = 0; j < arr.length; j++){
				if(arr[j] == i){
					System.out.print("*");
					cnt++;
				}
			}
			System.out.println(" " + cnt);
		}*/
		
	/*	int[] count = new int[5];
		for(int i = 0; i < arr.length; i++){
			count[arr[i] -1]++;
		}
		
		for(int i = 0; i < count.length; i++){
			System.out.print(i + 1 + " : ");
			for(int j = 0; j < count[i]; j++){
				System.out.print("*");
			}
			System.out.println(" " + count[i]);
		}*/
		
		
		//3.배열에 중복된 숫자 제거
		
		/*
		 * ex)
		 * 1 ~ 5사이의 랜덤한 값이 10개 저장된 배열에서 중복된 값이 제거된 배열 만들기
		 * [3, 4, 3, 1, 1, 3, 4, 5, 2, 4]
		 * [3, 4, 1, 5, 2]
		 */
		
		
		
		
	/*	int check;
		int cnt = arr.length;
		
		for(int i = 0; i < arr.length; i++){
			check = arr[i];
			
			if(check != 0){
			for(int j = i + 1; j < arr.length; j++){
				if(check == arr[j]){
					arr[j] = 0 ;
				}
			}
			}else{
				cnt--;
			}
		}
//		System.out.println(Arrays.toString(arr)+cnt);
		
		
		int[] newArr = new int[cnt];
		for(int i = 0; i < cnt; i++){
			
			for(int j = i; j < arr.length; j++){
				if(arr[j] != 0 && newArr[i] == 0){
					newArr[i] = arr[j];
					arr[j] = 0;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(newArr));*/

		int[] temp = new int[5];
		int count = 0;
		
		for(int i = 0; i < arr.length; i++){
			boolean flag = true;
			
			for(int j = 0; j < temp.length; j++){
				if(arr[i] == temp[j]){
					flag = false;
				}
			}
			if(flag){
				temp[count++] = arr[i];
			}
		}
		int[] result = new int[count];
		for(int i = 0; i < count; i++){
			result[i] = temp[i];
		}
		
		System.out.println(Arrays.toString(result));
		
		
	}
}













