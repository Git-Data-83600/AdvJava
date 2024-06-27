package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.TagDao;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Tag;

@Service 
@Transactional 
public class BlogPostServiceImpl implements BlogPostService {
	@Autowired 
	private BlogPostDao blogPostDao;

	@Autowired
	private CommentService commentService;

	@Autowired
	private TagDao tagDao;

	@Override
	public List<BlogPost> getPostsByCategoryName(String catName) {
		
		return blogPostDao.findBySelectedCategoryCategoryName(catName);
	}

	@Override
	public List<BlogPost> getAllPosts() {
		
		return blogPostDao.findAll();
	}

	@Override
	public String deleteBlogPost(Long blogPostId) {
		
		if (blogPostDao.existsById(blogPostId)) {
			
			String mesg = commentService.deletePosts(blogPostId);
			
			blogPostDao.deleteById(blogPostId);
			return "blog post deleted " + mesg;
		}
		return "blog post deletion failed !!!!!!!!!!!!!";
	}

}
