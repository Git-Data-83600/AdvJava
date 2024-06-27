package com.sunbeam.service;

import java.util.List;

import com.sunbeam.entities.BlogPost;

public interface BlogPostService {

	List<BlogPost> getPostsByCategoryName(String catName);
	
	List<BlogPost> getAllPosts();
	
	String deleteBlogPost(Long blogPostId);
}
