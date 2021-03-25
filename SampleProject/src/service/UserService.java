package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.ScanUtill;
import util.View;
import controller.Controller;
import dao.UserDao;

public class UserService {
	
	//싱글톤 패턴
	private UserService(){}
	private static UserService instance;
	
	public static UserService getInstance(){
		if(instance == null){
			instance = new UserService();
		}
		return instance;
	}
	
	private UserDao userDao = UserDao.getInstance();
	
	public int join(){ //리턴타입 이동할 화면
		System.out.println("================회원가입================");
		
		
		String userId = joinIdCheck();

		
		String password = joinPasswordCheck();
		
		/*System.out.print("비밀번호>");
		String password = ScanUtill.nextLine();*/
		
		System.out.print("이름>");
		String userName = ScanUtill.nextLine();
		
		//아이디 중복 확인 및 유효성검사
		//비밀번호 확인 및 유효성 검사
		//정규 표현식(유효성 검사) 생략
		
		Map<String, Object> param = new HashMap<>();
		param.put("USER_ID", userId);
		param.put("PASSWORD", password);
		param.put("USER_NAME", userName);
		
		int result = userDao.insertUser(param);
		
		if(result > 0){
			System.out.println("회원가입 성공");
		}else{
			System.out.println("회원가입 실패");
		}
		
		return View.HOME;
	}

	
	
	private String joinPasswordCheck() {
		String password = null;
		String password2 = null;
		
		while(true){
			
			System.out.print("비밀번호>");
			password = ScanUtill.nextLine();
			System.out.print("비밀번호 확인>");
			password2 = ScanUtill.nextLine();
			
			if(!password.equals(password2)){
				System.out.println("입력하신 두 비밀번호가 일치하지 않습니다");
				continue;
			}else{
				break;
			}
			
		}
		
		return null;
	}



	public int login() {
		System.out.println("===============로그인===============");
		System.out.print("아이디>");
		String userId = ScanUtill.nextLine();
		System.out.print("비밀번호>");
		String password = ScanUtill.nextLine();
		
		Map<String, Object> user = userDao.selectUser(userId, password);
		
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		}else{
			System.out.println("로그인 성공");
			Controller.LoginUser = user;
			return View.BOARD_LIST;
		}
		
		return View.LOGIN;
	}
	
	
	public String joinIdCheck(){
		String id = null;
		while(true){
			boolean overlap = true;
			boolean effectiveness = false;
			String regexId = "[a-z0-9-_]{5,20}";
			
			System.out.print("아이디>");
			id = ScanUtill.nextLine();
			List<Map<String,Object>> usersId = userDao.checkIdDao();
			
			
			for(Map<String, Object> users : usersId){
				if(users.get("USER_ID").equals(id)){
					overlap = false;
				}
			}
			Pattern p_id = Pattern.compile(regexId);
			Matcher m_id = p_id.matcher(id);
			effectiveness = m_id.matches();
			
			if(!effectiveness){
				System.out.println("아이디는 소문자,숫자 5~20글자 입니다");
			}else if(!overlap){
				System.out.println("이미 존재하는 아이디 입니다");
			}else{
				break;
			}
		}
		return id;
	}
	
}





























