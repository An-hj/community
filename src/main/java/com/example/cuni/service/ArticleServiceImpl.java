package com.example.cuni.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cuni.dao.ArticleDao;
import com.example.cuni.dto.Article;
import com.example.cuni.dto.Board;
import com.example.cuni.util.CUtil;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;

	@Override
	public List<Article> getArticles() {
		return articleDao.getArticles();
	}
	
	@Override
	public Article getArticle(int id) {
		return articleDao.getArticle(id);
	}

	@Override
	public Map<String, Object> write(Map<String, Object> param) {
		articleDao.write(param);
		
		int id = CUtil.getAsInt(param.get("id"));
		
		Map<String, Object> rs = new HashMap<>();
		rs.put("resultCode", "S-1");
		rs.put("msg", String.format("%d번 게시물이 생성되었습니다.", id));
		
		return rs;
	}

	@Override
	public Map<String, Object> modify(Map<String, Object> param) {
		articleDao.modify(param);
		
		int id = Integer.parseInt((String)param.get("id"));
		
		Map<String, Object> rs = new HashMap<String, Object>();
		rs.put("resultCode", "S-1");
		rs.put("id", id);
		rs.put("msg", id + "번 글이 수정되었습니다.");
		
		return rs;
	}

	@Override
	public Map<String, Object> delete(int id) {
		articleDao.remove(id);
		
		Map<String, Object> rs = new HashMap<String, Object>();
		rs.put("resultCode", "S-1");
		rs.put("id", id);
		rs.put("msg", id + "번 글이 삭제되었습니다.");
		
		return rs;
	}

	@Override
	public List<Article> getArticles(String boardCode) {
		return articleDao.getArticlesByBoardCode(boardCode);
	}

	@Override
	public Board getBoard(String boardCode) {
		return articleDao.getBoardByBoardCode(boardCode);
	}

	@Override
	public Board getBoard(int boardId) {
		return articleDao.getBoard(boardId);
	}

}
