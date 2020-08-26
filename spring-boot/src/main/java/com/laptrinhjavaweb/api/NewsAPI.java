package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.NewsDTO;
import com.laptrinhjavaweb.service.INewsService;

/*
 * @Controller // khai bao class nay la 1 api public class NewsAPI {
 * 
 * @RequestMapping(value = "/news", method = RequestMethod.POST)
 * 
 * @ResponseBody // anotation de tra ve kieu du lieu json ra client
 * 
 * public NewsDTO createNew(@RequestBody NewsDTO model) { return model; } }
 */

@RestController
public class NewsAPI {
	@Autowired
	private INewsService newsService;

	@PostMapping(value = "/news")
	public NewsDTO createNews(@RequestBody NewsDTO model) {
		return newsService.save(model);
	}
	
	@PutMapping(value = "/news/{id}")
	public NewsDTO updateNews(@RequestBody NewsDTO model, @PathVariable("id")long id) {
		model.setId(id);
		return newsService.save(model);
	}
	
	@DeleteMapping(value = "/news")
	public void deleteNews(@RequestBody long[] ids) {
		System.out.println("{}");
	}
}
