package d_array;

import java.util.Arrays;

public class MultiDimensionalArray {

	public static void main(String[] args) {

		/*
		 * 다차원 배열
		 * - 배열안에 배열이 저장되어 있는 형태
		 */
		
		//2차원
		int[][] array2;
		
		//3차원
		int[][][] array3;
		
		/*
		 * {주소1, 주소2}
		 * 
		 * 주소1
		 * {0, 0, 0}
		 * 
		 * 주소2
		 * {0, 0, 0}
		 */
		
		int[][] arr = new int[2][3];
		int arr2[][] = new int[][]{{1, 2, 3}, {4, 5, 6}};
		int[] arr3[] = {{1, 2, 3}, {4, 5 ,6}, {7, 8, 9}};
		
		int[][] arr4 = new int[3][]; //가변 배열
		arr4[0] = new int[3];
		arr4[1] = new int[4];
		arr3[2] = new int[10];
		
		System.out.println(arr[0][1]);
		
//		arr[0] = 10; //값을 저장할 수 없음
		arr[0] = new int[5];  //배열을 저장해야 함
		arr[0][0] = 10;  //2차원에 값을 저장할 수 있음
		arr[0][1] = 20;
		arr[1][0] = 100;
		
		System.out.println(arr.length); //1차원 배열의 길이
		System.out.println(arr[0].length); //2차원 배열의 길이
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j <arr[i].length; j++){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		System.out.println(Arrays.toString(arr)); //주소값 출력
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		
		//Q.각 학생의 과목합계와 평균구하기
		
		int[][] scores = new int[3][5];		//int[학생수][과목수]
		int[] sum = new int[scores.length]; 	//합계
		double[] avg = new double[scores.length]; 	//평균
		
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j< scores[i].length; j++){
				scores[i][j] = (int)(Math.random()* 101);
			}
			System.out.println(Arrays.toString(scores[i]));
		}
		
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				sum[i] += scores[i][j];
			}
			avg[i] = (double)sum[i] / scores[i].length;
		}
		System.out.println(Arrays.toString(sum));
		System.out.println(Arrays.toString(avg));
		
		
		
	}

}





















