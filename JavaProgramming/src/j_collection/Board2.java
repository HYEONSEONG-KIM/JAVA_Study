package j_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtill;

public class Board2 {

	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판 만들기
		 * 
		 * 
		 * 번호(PK), 제목, 내용, 작성자, 작성일
		 */
		int num;
		int num2;
		int sequence = 0;
		String content;
		ArrayList<HashMap<String,String>> board = new ArrayList<>();
		HashMap<String, String> post;
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		
		while(true){
		
		System.out.println("1.조회\t2.등록\t3.수정\t4.삭제\t5.종료");
		
		System.out.print("입력>");
		num = ScanUtill.nextInt();
		label3 : switch(num){
		
		case 1 :
			System.out.println("\n번호\t제목\t내용\t작성자\t작성일");
//			System.out.printf("%s \t %s \t %s \t %30s \t %s \n","번호","제목","내용","작성자","작성일");
			System.out.println("---------------------------------------------");
			for(int i = 0; i < board.size(); i ++){
				
			/*	System.out.printf("%s \t %s \t %s \t %30s \t %s \n",board.get(i).get("번호"),
						board.get(i).get("제목"),board.get(i).get("내용"),board.get(i).get("작성자")
						,board.get(i).get("작성일"));
			*/	
				
				
				System.out.println(	board.get(i).get("번호") + "\t" + 
									board.get(i).get("제목") + "\t" +
									board.get(i).get("내용") + "\t" + 
									board.get(i).get("작성자") + "\t" +
									board.get(i).get("작성일") + "\t" );
			}
			System.out.println("---------------------------------------------\n");
			
			break;
			
		case 2 :
			post = new HashMap<>();
			sequence ++;
			post.put("번호", Integer.toString(sequence));
			
			System.out.print("제목 입력>");
			content = ScanUtill.nextLine();
			post.put("제목", content);
			
			System.out.print("내용 입력 >");
			content = ScanUtill.nextLine();
			post.put("내용", content);
			
			System.out.print("작성자>");
			content = ScanUtill.nextLine();
			post.put("작성자", content);
			
			Date time = new Date();
			content = format.format(time);
			post.put("작성일", content);
			
			board.add(post);
			break;
			
			
		
		case 3 :
			if(board.size() != 0){
			boolean flag = true;
			
			label : while(flag){
			System.out.print("수정하고자 하는 게시글의 번호를 입력하여 주세요(이전으로 돌아려면 0 입력)>");
			
			num = ScanUtill.nextInt();
			
			if(num == 0){
				break label3;
			}
			for(int i = 0; i < board.size(); i++){
				int check = Integer.parseInt(board.get(i).get("번호"));
				if(check == num){
					flag = false;
					break label;
				}
			}
			System.out.println("======================================");
			System.out.println("입력하신 번호의 게시물은 존재하지 않습니다");
			System.out.println("======================================");
			}
			
			
			System.out.println("수정하고 싶은 항목을 선택하세요");
			label2 : while(true){
		
				System.out.println("1.제목\t2.내용\t3.작성자\t4.완료");
				System.out.print("입력>");
				num2 = ScanUtill.nextInt();
				
				for(int i = 0; i < board.size(); i++){
					if(Integer.parseInt(board.get(i).get("번호")) == (num)){
				
				if(num2 == 1){
					System.out.println("수정 전 제목 : " + board.get(i).get("제목"));
					System.out.print("제목 수정>");
					content = ScanUtill.nextLine();
					board.get(i).put("제목", content);
				}else if(num2 == 2){
					System.out.println("수정 전 내용 : " + board.get(i).get("내용"));
					System.out.print("내용 수정>");
					content = ScanUtill.nextLine();
					board.get(i).put("내용", content);
				}else if(num2 == 3){
					System.out.println("수정 전 작성자 : " + board.get(i).get("작성자"));
					System.out.print("작성자 수정>");
					content = ScanUtill.nextLine();
					board.get(i).put("작성자", content);
					
				}else if(num2 == 4){
					time = new Date();
					content = format.format(time);
					board.get(i).put("작성일", content);
					break label2;
				}
				}
				}
			}
			}
			else{
				System.out.println("현재 게시판이 비어있습니다");
			}
			
			break;
			
		case 4 :
			if(board.size() != 0){
			boolean flag = true;
			
			label : while(flag){
			System.out.print("삭제하고자 하는 게시글의 번호를 입력하여 주세요(이전으로 돌아려면 0 입력)>");
			
			num = ScanUtill.nextInt();
			
			if(num == 0){
				break label3;
			}
			for(int i = 0; i < board.size(); i++){
				int check = Integer.parseInt(board.get(i).get("번호"));
				if(check == num){
					flag = false;
					break label;
				}
			}
			
			
			System.out.println("======================================");
			System.out.println("입력하신 번호의 게시물은 존재하지 않습니다");
			System.out.println("======================================");
			}
			for(int i = 0; i < board.size(); i++){
				if(Integer.parseInt(board.get(i).get("번호")) == (num))
				board.remove(i);
			}
			}else{
				System.out.println("현재 게시판이 비어있습니다");
			}
			/*if(board.size() != 0){
				System.out.print("삭제하고자 하는 게시글의 번호를 입력하여 주세요(이전으로 돌아가려면 0 입력)>");
				num = ScanUtill.nextInt();
				
				
				if(num == 0){
					break label3;
				}
			
				for(int i = 0; i < board.size(); i++){
						if(Integer.parseInt(board.get(i).get("번호")) == (num))
						board.remove(i);
					
					}
			}else{
				System.out.println("현재 게시판이 비어있습니다");
			}
			break;*/
			
		}
		if(num == 5)
			break;
		
		}
		
	}

}
























