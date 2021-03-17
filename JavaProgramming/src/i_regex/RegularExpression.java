package i_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class RegularExpression {

	public static void main(String[] args) {
		
		/*
		 * 정규표현식 : 문자열의 패턴을 검사하는 표현식
		 * 
		 * ^	뒷 문자로 시작
		 * $	앞 문자로 종료
		 * .	임의의 문자(줄바꿈 제외)
		 * *	앞 문자가 0개 이상
		 * +	앞 문자가 1개 이상
		 * ?	앞 문자가 없거나 1개
		 * []	문자의 집합이나 범위([a-z]:a부터 z까지, [^a-z]:a부터 z가 아닌것)
		 * {}	앞 문자의 개수({2}:2개, {2,4}:2개 이상 4개 이하)
		 * ()	그룹화
		 * |	OR연산
		 * \s	공백, 탭, 줄바꿈
		 * \S	공백, 탭, 줄바꿈이 아닌 문자
		 * \w	알파벳이나 숫자
		 * \W	알파벳이나 숫자가 아닌 문자
		 * \d	숫자
		 * \D	숫자가 아닌 문자
		 * (?i)	뒷 문자의 대소문자 구분 안함
		 * \	정규표현식에서 사용되는 특수문자 표현
		 */
		
		String str = "1";
//		String regex = "[a-z]{3}[0-9]{1,3}";  //a-z까지 문자 3개, 0~9까지 숫자 3개(1개 이상 3개 이하)
//		String regex = "[a-z0-9]+";	//알파벳(소문자)여도 숫자여도 상관없음,+(1개 이상)
//		String regex = "\\w*";	// \를 하나 표현하려면 두개 사용
//		String regex = ".*";
		String regex = "[\\W]";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		System.out.println(m.matches());
		
		
		//Q.아이디, 전화번호, 이메일주소의 유효성을 검사하는 정규 표현식 만들기
		
		String regexId = "[a-z0-9-_]{5,20}";
		String id = "kimgustjd123dfsdfsdfsd12-";
				
		Pattern p_id = Pattern.compile(regexId);
		Matcher m_id = p_id.matcher(id);
		System.out.println(m_id.matches());
		
		String regexPW = "^0//d{1,3}-\\d{3,4}-//d{4}";
		String pw = "rlagustjd";
		
		Pattern p_pass = Pattern.compile(regexPW);
		Matcher m_pass = p_pass.matcher(pw);
		System.out.println(m_pass.matches());
		
		String regexEmail = "[a-z0-9-_]{5,20}@[a-zA-Z]+\\.(?i)(com|nwt|org|([a-z]{2}\\.kr))$";
		String Email = "kimgustjd@naver.com";
		
		Pattern p_Email = Pattern.compile(regexEmail);
		Matcher m_Email = p_Email.matcher(Email);
		System.out.println(m_Email.matches());
	
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
