package kr.or.ddit.basic;

import java.util.LinkedList;

public class StackQueueTest {

	public static void main(String[] args) {
		
		/*
		 * - Stack : 후입선출(LIFO)의 자료구조 
		 * - Queue : 선입선출(FIFO)의 자료구조
		 * 
		 * - Stack과 Queue는  LinkedList를 이용하여 사용
		 */
		
		/*
		 *  Stack 명령어
		 *  - 자료 입력  : 	push(입력값)
		 *  - 자료 출력  : 	pop() => 자료를 꺼내온 후 Stack에서 삭제
		 *  			peek() => 삭제없이 자료를 꺼내옴
		 */
		
		//Stack으로 사용할 LinkedList
		LinkedList<String> stack = new LinkedList<>();
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
	
		System.out.println("stack => " + stack);
		
		System.out.println();
		String data = stack.pop();
		System.out.println("꺼내온 데이터 : " + data);
		System.out.println("꺼내온 데이터 : " + stack.pop());
		System.out.println("stack => " + stack);
		System.out.println();
		
		stack.push("성춘향");
		System.out.println("추가 후 stack => " + stack);
		System.out.println();
		
		System.out.println("꺼내온 데이터 : " + stack.pop());
		System.out.println("stack => " + stack);
		System.out.println();
		
		System.out.println("삭제없이 꺼내온 데이터 : " + stack.peek());
		System.out.println("stack => " + stack);
		System.out.println();
		
		/*
		 * Queue 명령어
		 * - 자료입력 	: offer(입력값)
		 * - 자료출력 	: poll() => 자료를 꺼내온 후 Queue에서 삭제
		 * 		    : peek() => 삭제없이 자료를 꺼내옴	
		 */
		
		//Queue로 사용할 LinkedList
		LinkedList<String> queue = new LinkedList<>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("queue => " + queue);
		System.out.println();
		
		String temp = queue.poll();
		System.out.println("꺼내온 데이터 : " + temp);
		System.out.println("꺼내온 데이터 : " + queue.poll());
		System.out.println("queue => " + queue);
		System.out.println();
		
		queue.offer("성춘향");
		System.out.println("queue => " + queue);
		System.out.println();
		
		System.out.println("꺼내온 데이터 : " + queue.poll());
		System.out.println("queue => " + queue);
		System.out.println();
		
		System.out.println("삭제없이 꺼내오기 : " + queue.peek());
		System.out.println("queue => " + queue);
		System.out.println();
		
		
		
		
	}

}




















