package kr.or.ddit.mvc.service;

import java.util.List;

import kr.or.ddit.mvc.dao.BoardDaoImpl;
import kr.or.ddit.mvc.dao.IBoardDao;
import kr.or.ddit.mvc.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {

	private IBoardDao dao;
	private static BoardServiceImpl service;
	
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance(){
		if(service == null){
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		return dao.insertBoard(boardVo);
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return dao.getAllBoard();
	}

	@Override
	public BoardVO showBoard(int boardNum) {
		return dao.showBoard(boardNum);
	}

	@Override
	public List<BoardVO> titleSearch(String title) {
		return dao.titleSearch(title);
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		return dao.updateBoard(boardVo);
	}

	@Override
	public int deleteBoard(int boardNum) {
		return dao.deleteBoard(boardNum);
	}

	@Override
	public int cntCreate(int boardNum) {
		return dao.cntCreate(boardNum);
	}

}
