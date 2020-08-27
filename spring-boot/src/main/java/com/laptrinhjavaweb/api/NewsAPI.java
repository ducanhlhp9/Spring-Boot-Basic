package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.api.output.NewsOutput;
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

	@GetMapping(value = "/news")
	public NewsOutput showNews(@RequestParam(value ="page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit) {
		NewsOutput result = new NewsOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);

			result.setListResult(newsService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (newsService.totalItem()) / limit));
		} else {
			result.setListResult(newsService.findAll());
		}

		return result;
	}

	@PostMapping(value = "/news")
	public NewsDTO createNews(@RequestBody NewsDTO model) {
		return newsService.save(model);
	}

	@PutMapping(value = "/news/{id}")
	public NewsDTO updateNews(@RequestBody NewsDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return newsService.save(model);
	}

	@DeleteMapping(value = "/news")
	public void deleteNews(@RequestBody long[] ids) {
		newsService.delete(ids);
		System.out.println("{}");
	}
}
