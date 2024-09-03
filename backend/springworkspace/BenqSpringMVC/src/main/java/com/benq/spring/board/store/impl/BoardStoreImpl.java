package com.benq.spring.board.store.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.benq.spring.board.domain.BoardVO;
import com.benq.spring.board.store.BoardStore;

@Repository
public class BoardStoreImpl implements BoardStore {

    @Override
    public int insertBoard(SqlSession session, BoardVO board) {
        return session.insert("BoardMapper.insertBoard", board);
    }

    @Override
    public BoardVO selectOneByNo(SqlSession session, Integer boardNo) {
        return session.selectOne("BoardMapper.selectOneByNo", boardNo);
    }

    @Override
    public List<BoardVO> selectBoardList(SqlSession session, int currentPage) {
        int limit = 10;
        int offset = (currentPage - 1) * limit;
        RowBounds rowBounds = new RowBounds(offset, limit);
        return session.selectList("BoardMapper.selectBoardList", null, rowBounds);
    }

    @Override
    public int getTotalCount(SqlSession session) {
        return session.selectOne("BoardMapper.getTotalCount");
    }

    @Override
    public int getTotalCount(SqlSession session, Map<String, String> searchMap) {
        return session.selectOne("BoardMapper.getTotalCountWithSearch", searchMap);
    }

    @Override
    public int deleteBoard(SqlSession session, Integer boardNo) {
        return session.delete("BoardMapper.deleteBoard", boardNo);
    }

    @Override
    public int updateBoard(SqlSession session, BoardVO board) {
        return session.update("BoardMapper.updateBoard", board);
    }

    @Override
    public List<BoardVO> selectSearchList(SqlSession session, Map<String, String> searchMap, int currentPage, int recordCountPerPage) {
        int offset = (currentPage - 1) * recordCountPerPage;
        RowBounds rowBounds = new RowBounds(offset, recordCountPerPage);
        return session.selectList("BoardMapper.selectSearchList", searchMap, rowBounds);
    }
}
