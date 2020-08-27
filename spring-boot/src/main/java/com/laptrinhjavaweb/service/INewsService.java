package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.NewsDTO;

public interface INewsService {
	NewsDTO save(NewsDTO newsDTO);
//	NewsDTO update(NewsDTO newsDTO);
	void delete(long[] ids);
	List<NewsDTO> findAll(Pageable pageable);
	List<NewsDTO> findAll();
	int totalItem();
}
