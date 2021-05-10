package kr.or.ddit.mvc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.BuildedSqlMapClient;

public class MemberDaoImpl implements IMemberDao {
	
	private static MemberDaoImpl member;
	SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();
	
	private MemberDaoImpl(){};
	
	public static MemberDaoImpl getInstance(){
		if(member == null){
			member =  new MemberDaoImpl();
		}
		return member;
	}
	

	@Override
	public int insertMember(MemberVO memVo) {

		Object obj = null;
		int cnt = 0;
		
		try {
			obj = smc.insert("member.insertMember", memVo);
			if(obj == null){
				cnt =1;
			}else{
				cnt = 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		
		int cnt = 0;
		
		try {
			cnt = smc.delete("member.deleteMember", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("member.updateMember",memVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		
		
		List<MemberVO> member = null;
		
		try {
			member = smc.queryForList("member.getAllMember");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public int getMemberCount(String memId) {
		
		int count = 0;
		
		try {
			count = (int) smc.queryForObject("member.memberCnt", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		
	
	
		int cnt = 0;
		
		
		return cnt;
	}

}



































