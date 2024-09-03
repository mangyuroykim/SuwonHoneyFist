package com.benq.spring.board.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benq.spring.board.domain.BoardVO;
import com.benq.spring.board.service.BoardService;
import com.benq.spring.board.store.BoardStore;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardStore bStore;
    
    @Autowired
    private SqlSession session;

    @Override
    public int insertBoard(BoardVO board) {
        return bStore.insertBoard(session, board);
    }

    @Override
    public List<BoardVO> selectBoardList(int currentPage) {
        return bStore.selectBoardList(session, currentPage);
    }

    @Override
    public int getTotalCount(Map<String, String> searchMap) {
        return bStore.getTotalCount(session, searchMap);
    }

    @Override
    public BoardVO selectOneByNo(Integer boardNo) {
        return bStore.selectOneByNo(session, boardNo);
    }

    @Override
    public int deleteBoard(Integer boardNo) {
        return bStore.deleteBoard(session, boardNo);
    }

    @Override
    public int updateBoard(BoardVO board) {
        return bStore.updateBoard(session, board);
    }

    @Override
    public List<BoardVO> selectSearchList(Map<String, String> searchMap, int currentPage, int recordCountPerPage) {
        return bStore.selectSearchList(session, searchMap, currentPage, recordCountPerPage);
    }

    @Override
    public int getTotalCount() {
        return bStore.getTotalCount(session);
    }
}
