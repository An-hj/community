package com.example.cuni.service;

import java.util.List;
import java.util.Map;

import com.example.cuni.dto.Article;

public interface ArticleService {

	List<Article> getArticles();

	Article getArticle(int id);

	Map<String, Object> write(Map<String, Object> param);

	Map<String, Object> modify(Map<String, Object> param);

	Map<String, Object> delete(int id);

}
