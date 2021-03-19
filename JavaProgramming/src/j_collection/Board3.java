package j_collection;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtill;

public class Board3 {

	public static void main(String[] args) {
		
		Board3 board = new Board3();
		board.start();
		
	}

	private void start() {
		
		ArrayList<HashMap<String, Object>> boardList = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("yy-mm-dd");
		
		while(true){
			
			HashMap<String, Object> board = new HashMap<>();
			System.out.println();
			System.out.println("********************************************************************");

			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("-------------------------------------");
			for(int i = 0; i < boardList.size(); i++){
				System.out.println(boardList.get(i).get("No") + "\t" +
									boardList.get(i).get("Title") + "\t" +
									boardList.get(i).get("User") + "\t" +
									format.format(boardList.get(i).get("Date")));
			}
			System.out.println("-------------------------------------");
			System.out.println("********************************************************************");

			
			System.out.print("1.조회\t2.등록\t0.종료 > ");
			int input = ScanUtill.nextInt();
			
			switch(input){
				case 1 :
					read(boardList, board);
					break;
					
				case 2 :
					create(boardList, board);
					break;
				
				case 0 :
					System.out.println("프로그램이 종료 되었습니다");
					System.exit(0);
					break;
			
			}
		}
	}

	

	private void read(ArrayList<HashMap<String, Object>> boardList ,
			HashMap<String, Object> board) {
		
		if(boardList.size() != 0){
			
				System.out.println();
				System.out.print("상세조회하고자 하는 게시판의 번호를 입력해주세요 (이전으로 돌아가려면 0번을 입력하세요)>");
				int input = ScanUtill.nextInt();
				boolean flag = true;
				for(int i = 0; i < boardList.size(); i++){
					int check = (int)boardList.get(i).get("No");
					if(input != check){
						flag = true;
					}else{
						flag = false;
						break;
					}
				}
				if(flag){
					System.out.println("입력하신 번호의 게시글이 존재하지 않습니다");
					return;
				}
				if(input == 0)
					return;
		
			System.out.println();
			System.out.println("===================================================================");
			for(int i = 0; i < boardList.size(); i++){
				int check = (int)boardList.get(i).get("No");
				if(check == input){
					System.out.println("번호 : " + boardList.get(i).get("No") +  " || " + "작성일 : "+ boardList.get(i).get("Date"));
					System.out.println("-------------------------------------------------------------");
					System.out.println("제목 : " + boardList.get(i).get("Title") + " || " + "작성자 : " + boardList.get(i).get("User"));
					System.out.println("-------------------------------------------------------------");
					System.out.println("내용 : " + boardList.get(i).get("Content"));
					board = boardList.get(i);
				}
			}
			
			System.out.println("===================================================================\n");
			
			System.out.println("다음의 작업 중 선택하여 주세요");
			System.out.print("1.수정\t2.삭제\t 0.처음으로>");
			 input = ScanUtill.nextInt();
			
			switch(input){
				case 1 :
					update(board);
					break;
					
				case 2 :
					delete(boardList, board);
					break;
					
				case 0 :
					break;
			
			}
			
			
			
			
		}else{
			System.out.println("현재 게시글이 존재 하지 않습니다");
		}
	}

	

	private void delete(ArrayList<HashMap<String, Object>> boardList,
			HashMap<String, Object> board) {
		
		System.out.println();
		for(int i = 0; i < boardList.size(); i++){
			if(boardList.get(i).get("No").equals(board.get("No"))){
				boardList.remove(i);
			}
		}
		System.out.println("삭제되었습니다\n");
		
	}

	private void update(HashMap<String, Object> board) {
		
		label : while(true){
				
				System.out.println();
				System.out.print("1.제목\t2.내용\t0.완료");
				int input = ScanUtill.nextInt();
				System.out.println();
			switch(input){	
			case 1 :
				System.out.print("제목 > ");
				String title = ScanUtill.nextLine();
				board.put("Title", title);
				break;
			case 2 :
				System.out.print("내용 > ");
				String content = ScanUtill.nextLine();
				board.put("Content", content);
				break;
			case 0 :
				break label;
			}
		
			}
		
		
		
		
		System.out.println("수정이 완료 되었습니다");
	}

	private void create(ArrayList<HashMap<String, Object>> boardList,
			HashMap<String, Object> board) {
		
		int boardNo = boqardNo(boardList);
		
		System.out.println("제목 >");
		String title = ScanUtill.nextLine();
		
		System.out.println("내용 >");
		String content = ScanUtill.nextLine();
		
		System.out.println("작성자 >");
		String user = ScanUtill.nextLine();
		
		
		board.put("No", boardNo);
		board.put("Title", title);
		board.put("Content", content);
		board.put("User", user);
		board.put("Date", new Date());
		
		boardList.add(board);
		
	}

	private int boqardNo(ArrayList<HashMap<String, Object>> boardList) {
		int max = 0;
		for(int i = 0; i < boardList.size(); i++){
			int check = (int)boardList.get(i).get("No");
			if(check > max){
				max = check;
			}
		}
		
		return (max + 1);
	}



	

}
