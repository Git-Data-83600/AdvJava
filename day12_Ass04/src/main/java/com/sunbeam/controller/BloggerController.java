package com.sunbeam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.service.BlogPostService;

@Controller
@RequestMapping("/blogger")
public class BloggerController {
	
	@Autowired
	private BlogPostService blogPostService;

	public BloggerController() {
		System.out.println("in ctor " + getClass());
	}

	@GetMapping("/home")
	public String renderHomePage(Model map) {
		System.out.println("in blogger hm page");
		map.addAttribute("posts", blogPostService.getAllPosts());
		return "/blogger/home";
	}

	@GetMapping("/delete_post")
	public String deleteBlogPost(@RequestParam Long postId,HttpSession session) {
		System.out.println("in delete blog post "+postId);
		 session.setAttribute("message",blogPostService.deleteBlogPost(postId));
		 return "redirect:/blogger/home";
	}
	

}
