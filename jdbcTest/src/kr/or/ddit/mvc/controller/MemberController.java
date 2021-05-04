package kr.or.ddit.mvc.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberController {

	private IMemberService service;
	private Scanner sc;
	
	// 생성자
	public MemberController() {
		sc = new Scanner(System.in);
		service = new MemberServiceImpl();
	}
	
	public static void main(String[] args) {
		new MemberController().memberStart();
	}
	
	private void memberStart() {
		selectMenu();
	}

	private void selectMenu() {
		
		while(true){
			
			System.out.println();
			System.out.println("---작업 선택---");
			System.out.println("1. 자료 추가");
			System.out.println("2. 자료 삭제");
			System.out.println("3. 자료 수정");
			System.out.println("4. 전체 자료 출력");
			System.out.println("5. 자료 수정2");
			System.out.println("0. 작업 끝");
			System.out.print("작업 선택 >>");
			
			int input = Integer.parseInt(sc.nextLine());
			
			switch(input){
				case 1 : dataInsert();
					break;
				case 2 : dataDelete();
					break;
				case 3 : dataUpdate();
					break;
				case 4 : dataSelect();
					break;
				case 5 : //dataUpdate2();
				case 0 : System.exit(0);
					break;
			
			}
		}
	}

	private void dataSelect() {
		
		List<MemberVO> memInfo = service.getAllMember();
		
		System.out.println();
		System.out.printf("%-10s\t%-10s\t%s\t%-10s\t%s", "회원ID", "패스워드", "이름", "전화번호", "주소");
		System.out.println();
		System.out.println("=======================================================================");
		for(int i = 0; i < memInfo.size(); i++){
			
			System.out.printf("%-10s\t", memInfo.get(i).getMem_id());
			System.out.printf("%-10s\t", memInfo.get(i).getMem_pass());
			System.out.printf("%s\t", memInfo.get(i).getMem_name());
			System.out.printf("%-10s\t", memInfo.get(i).getMem_tel());
			System.out.printf("%s\t", memInfo.get(i).getMem_addr());
			System.out.println();
			if(i != memInfo.size() - 1)
			System.out.println("----------------------------------------------------------------------");
			
		}
		System.out.println("=======================================================================");
		
	}

	private void dataUpdate() {
		System.out.println();
	      System.out.println("수정할 회원 정보를 입력하세요.");
	      System.out.print("회원ID >> ");
	      String memId = sc.nextLine();
	      
	      int count = service.getMemberCount(memId);
	      if(count==0){     // 없는 회원이면...
	         System.out.println(memId + "은(는) 없는 회원ID 입니다.");
	         System.out.println("수정 작업을 종료합니다.");
	         return;
	      }
	      
	      System.out.println();
	      System.out.println("수정할 내용을 입력하세요.");
	      System.out.print("새로운 비밀번호 >> ");
	      String memPass = sc.next();
	      
	      System.out.print("새로운 회원이름 >> ");
	      String memName = sc.next();
	      
	      System.out.print("새로운 전화번호 >> ");
	      String memTel = sc.next();
	      sc.nextLine(); // 버퍼 비우기
	      System.out.print("새로운 회원주소 >> ");
	      String memAddr = sc.nextLine();
	      
	      MemberVO memVo = new MemberVO();
	      memVo.setMem_pass(memPass);
	      memVo.setMem_name(memName);
	      memVo.setMem_tel(memTel);
	      memVo.setMem_addr(memAddr);
	      memVo.setMem_id(memId);
	      
	      int result = service.updateMember(memVo);
	      
	      if(result > 0){
	    	  System.out.println("수정 성공~!!");
	      }else{
	    	  System.out.println("수정 실패...");
	      }
	      
		
	}

	private void dataDelete() {
		
		  System.out.println();
	      System.out.println("삭제할 회원 정보를 입력하세요.");
	      System.out.print("회원ID >> ");
	      String memId = sc.nextLine();
	      
	      int result = service.deleteMember(memId);
	      
	      if(result > 0){
	    	  System.out.println("삭제 작업 성공!!");
	      }else{
	    	  System.out.println("삭제 작업 실패...");
	      }
	}

	private void dataInsert() {
		System.out.println();
	      System.out.println("추가할 회원 정보를 입력하세요.");
	      
	      int count = 0;  // 회원 수가 저장될 변수
	      String memId = null;   // 회원ID가 저장될 변수
	      do{
	         System.out.print("회원ID >> ");
	         memId = sc.next();
	         
	         count = service.getMemberCount(memId);  // 회원 수를 구하는 메서드 호출
	         if(count>0){
	            System.out.println(memId + "은(는) 이미 등록된 회원ID 입니다.");
	            System.out.println("다른 회원ID를 입력하세요.");
	         }
	      }while(count>0);
	      
	      System.out.print("비밀번호 >> ");
	      String memPass = sc.next();
	      System.out.print("회원이름 >> ");
	      String memName = sc.next();
	      System.out.print("전화번호 >> ");
	      String memTel = sc.next();
	      sc.nextLine();  // 입력 버퍼 비우기...
	      System.out.print("회원주소 >> ");
	      String memAddr = sc.nextLine();
	      
	   
	      MemberVO memVo = new MemberVO();
	      memVo.setMem_id(memId);
	      memVo.setMem_pass(memPass);
	      memVo.setMem_name(memName);
	      memVo.setMem_tel(memTel);
	      memVo.setMem_addr(memAddr);
	      
	      int cnt = service.insertMember(memVo);
	      
	      if(cnt > 0){
	    	  System.out.println("추가 작업 성공~~~");
	      }else{
	    	  System.out.println("추가 작업 실패!!");
	      }
	}

}
