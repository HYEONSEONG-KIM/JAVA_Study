package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao {
	private static final Logger logger = Logger.getLogger(MemberDaoImpl.class);
	
	private static MemberDaoImpl member;
	
	private MemberDaoImpl(){};
	
	public static MemberDaoImpl getInstance(){
		if(member == null){
			member =  new MemberDaoImpl();
		}
		return member;
	}
	

	@Override
	public int insertMember(MemberVO memVo) {

		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			con = DBUtil3.getConnection();
			logger.info("insertMember - Connection객체 생성");
			String sql = "INSERT INTO MYMEMBER VALUES(?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, memVo.getMem_id());
			ps.setString(2, memVo.getMem_pass());
			ps.setString(3, memVo.getMem_name());
			ps.setString(4, memVo.getMem_tel());
			ps.setString(5, memVo.getMem_addr());
			
			logger.info("PreparedStatement객체 생성...");
			logger.info("실행SQL : " + sql);
			logger.info("사용 데이터 : [" + memVo.getMem_id() + ", " + memVo.getMem_pass()
						+ ", " + memVo.getMem_name() + ", " + memVo.getMem_tel() + ", " + memVo.getMem_addr() + "]");
			
			
			cnt = ps.executeUpdate();
			logger.info("insertMember() - 작업 성공");
		} catch (SQLException e) {
			logger.error("insertMember() - 작업 실패 : " + e.getMessage());
			cnt = 0;
			e.printStackTrace();
		}finally{
			if(ps != null) try{ ps.close(); logger.info("PreparedStatement객체 반납..."); }catch(SQLException e){}
			if(con != null) try{ con.close(); logger.info("Connection객체 반납..."); }catch(SQLException e){}
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		
		try {
			con = DBUtil3.getConnection();
			logger.info("deleteMember - Connection객체 연결 성공...");
			String sql = "delete from mymember where mem_id = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, memId);
			
			logger.info("PreparedStatement객체 생성...");
			logger.info("실행SQL : " + sql);
			logger.info("사용 데이터 [" + memId + "]");
			
			cnt = ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			logger.error("insertMember() - 작업 실패 : " + e.getMessage());
			// TODO: handle exception
		}finally{
			if(ps != null) try{ ps.close(); logger.info("PreparedStatement객체 반납..."); }catch(SQLException e){}
			if(con != null) try{ con.close(); logger.info("Connection객체 반납..."); }catch(SQLException e){}
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		
		try {
			con = DBUtil3.getConnection();
			logger.info("updateMember - Connection객체 생성...");
			String sql = "update mymember "
		               + " set mem_pass = ? , mem_name=? , mem_tel=? , mem_addr=? "
		               + " where mem_id = ?";

			ps = con.prepareStatement(sql);
			ps.setString(1,memVo.getMem_pass());
			ps.setString(2,memVo.getMem_name());
			ps.setString(3,memVo.getMem_tel());
			ps.setString(4,memVo.getMem_addr());
			ps.setString(5, memVo.getMem_id());
			
			logger.info("PreparedSatatement객체 생성...");
			logger.info("실행SQL : " + sql);
			logger.info("사용 데이터 : [" + memVo.getMem_pass() + ", " + memVo.getMem_name()
			+ ", " + memVo.getMem_tel() + ", " + memVo.getMem_addr() + ", " + memVo.getMem_id() + "]");
			
			cnt = ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			logger.error("insertMember() - 작업 실패 : " + e.getMessage());
			// TODO: handle exception
		}finally{
			if(ps != null) try{ ps.close(); logger.info("PreparedStatement객체 반납...");}catch(SQLException e){}
			if(con != null) try{ con.close(); logger.info("Connection객체 반납..."); }catch(SQLException e){}
		}
		
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MemberVO> member = null;
		
		try {
			con = DBUtil3.getConnection();
			logger.info("getAllMember() - Connection객체 생성...");
			
			String sql = "select * from mymember";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			member = new ArrayList<>();
			logger.info("PreparedStatement객체 생성...");
			logger.info("ResultSet객체 생성...");
			logger.info("실행 SQL : " + sql);
			
			while(rs.next()){
				MemberVO mem = new MemberVO();
				mem.setMem_id(rs.getString("MEM_ID"));
				mem.setMem_pass(rs.getString("MEM_PASS"));
				mem.setMem_name(rs.getString("MEM_NAME"));
				mem.setMem_tel(rs.getString("MEM_TEL"));
				mem.setMem_addr(rs.getString("MEM_ADDR"));
				
				member.add(mem);
			}
			
		} catch (SQLException e) {
			logger.error("insertMember() - 작업 실패 : " + e.getMessage());
			// TODO: handle exception
		}finally{
			if(rs != null) try{ rs.close(); }catch(SQLException e){}
			if(ps != null) try{ ps.close(); }catch(SQLException e){}
			if(con != null) try{ con.close(); }catch(SQLException e){}
		}
		
		return member;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = DBUtil3.getConnection();
			String sql = "SELECT COUNT(*) CNT FROM MYMEMBER WHERE MEM_ID = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, memId);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				count = rs.getInt("cnt");
			}
			
			
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}finally{
			if(rs != null) try{ rs.close(); }catch(SQLException e){}
			if(ps != null) try{ ps.close(); }catch(SQLException e){}
			if(con != null) try{ con.close(); }catch(SQLException e){}
		}
		
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		
		Connection con = null;
		PreparedStatement ps = null;
	
		int cnt = 0;
		
		try {
			con = DBUtil3.getConnection();
			String sql = "UPDATE MYMEMBER SET " + paramMap.get("filed") + " = ?" + " WHERE MEM_ID = ?";
			ps = con.prepareStatement(sql);
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			if(ps != null) try{ ps.close(); }catch(SQLException e){}
			if(con != null) try{ con.close(); }catch(SQLException e){}
		}
		
		return cnt;
	}

}



































