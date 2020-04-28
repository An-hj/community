package com.example.cuni.service;

import java.util.List;

import com.example.cuni.dto.Article;

public interface ArticleService {

	List<Article> getArticles();

	Article getArticle(int id);

}
