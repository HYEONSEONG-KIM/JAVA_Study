package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		/*
		 * 석차구하기 : 정수를 비교해 작은 점수의 등수를 증가시키는 방식
		 * 선택 정렬   : 가장 작은 숫자를 찾아서 앞으로 보내는 방식
		 * 버블 정렬   : 바로 뒤의 숫자와 비교해서 큰수를 뒤로 보내는 방식
		 * 삽입 정렬   : 두번째 숫자부터 앞의 숫자들과 비교해서 큰수는 뒤로 밀고 중간에 삽입하는 방식
		 */
		
		int[] arr =new int[10];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));
		
		//석차 구하기
		int[] rank = new int[arr.length];
		for(int i = 0; i < rank.length; i++){
			rank[i] = 1;
		}
		
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length; j++){
				if(arr[i] < arr[j]){
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));
		
		
		//선택정렬
		/*
		 * 0,1 0,2 0,3 0,4 0,5 0,6 0,7 0,8 0,9
		 * 1,2 1,3 1,4 1,5 1,6 1,7 1,8 1,9
		 * 
		 */
		
		
		/*for(int i = 0; i < arr.length -1; i++){
			int min = i;
			int temp;
			
			for(int j = i + 1; j < arr.length; j++){
				if(arr[j] < arr[min]){
					min = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		
		System.out.println(Arrays.toString(arr));*/
		
		
		
		
		
		//버블 정렬
		/*
		 *	0,1	1,2	2,3	3,4	4,5	5,6	6,7	7,8	8,9
		 *	0,1	1,2	2,3	3,4	4,5	5,6	6,7	7,8
		 *	0,1	1,2	2,3	3,4	4,5	5,6	6,7
		 *	0,1	1,2	2,3	3,4	4,5	5,6
		 *	0,1	1,2	2,3	3,4	4,5
		 *	0,1	1,2	2,3	3,4
		 *	0,1	1,2	2,3
		 *	0,1	1,2
		 *	0,1
		 */
		
		
		/*for(int i = 0; i < arr.length - 1; i++){
			
			int temp ;
			boolean check =true;
			
			for(int j = 0; j < arr.length - 1 - i; j++){
				
				if(arr[j] > arr[j+1]){
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					check = false;
				}
				
			}
			
			if(check){
				break;
			}
		}
		System.out.println(Arrays.toString(arr));*/
		
		
		//삽입정렬
		
/*		for(int i = 1; i < arr.length; i++){
			int temp = arr[i];
			int j = 0;
			for(j = i - 1; j >= 0; j--){
				if(arr[j] > temp){
					arr[j + 1] = arr[j];
				}else{
					break;
				}
			}
			arr[j + 1] = temp;
		}
*/		

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
	}

}
