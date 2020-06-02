package com.example.cuni.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cuni.dto.Article;
import com.example.cuni.dto.Board;
import com.example.cuni.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/article/list")
	public String showList(Model model, String boardCode) {
		Board board = articleService.getBoard(boardCode);
		List<Article> articles = articleService.getArticles(boardCode);
		
		model.addAttribute("articles", articles);
		model.addAttribute("board", board);
		
		return "article/list";
	}
	
	@RequestMapping("/article/detail")
	public String showDetail(Model model, int id) {
		Article article = articleService.getArticle(id);
		
		model.addAttribute("article", article);
		
		return "article/detail";
	}

	
	@RequestMapping("/article/modify")
	public String showModify(Model model, int id) {
		Article article = articleService.getArticle(id);
		model.addAttribute("article", article);
		
		return "article/modify";
	}
	
	@RequestMapping("/article/doModify")
	@ResponseBody
	public String doModify(@RequestParam Map<String, Object> param) {
		Map<String, Object> rs = articleService.modify(param);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<script>");
		sb.append("alert('" + rs.get("msg") + "');");
		sb.append("location.replace('/article/list?boardCode=' + board.getCode());");
		sb.append("</script>");
		
		return sb.toString();
	}
	
	@RequestMapping("/article/doDelete")
	public String doDelete(Model model, int id) {
		Map<String, Object> rs = articleService.delete(id);

		model.addAttribute("locationReplaceUrl", "/article/list");
		model.addAttribute("alert", rs.get("msg"));

		return "redirect";
	}
	
	@RequestMapping("/article/write")
	public String showWrite(Model model, String boardCode) {
		Board board = articleService.getBoard(boardCode);
		
		model.addAttribute("board", board);
		
		return "article/write";
	}
	
	@RequestMapping("article/doWrite")
	public String doWrite(Model model, @RequestParam Map<String, Object> param) {
		Map<String, Object> rs = articleService.write(param);
		
		int boardId = Integer.parseInt((String)param.get("boardId"));
		
		Board board = articleService.getBoard(boardId);
		
		model.addAttribute("locationReplaceUrl", "/article/list?boardCode=" + board.getCode());
		model.addAttribute("alert", rs.get("msg"));

		return "redirect";
	}
}
