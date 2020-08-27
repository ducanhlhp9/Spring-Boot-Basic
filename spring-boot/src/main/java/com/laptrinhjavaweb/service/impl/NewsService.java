package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.NewsConverter;
import com.laptrinhjavaweb.dto.NewsDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewsEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewsRepository;
import com.laptrinhjavaweb.service.INewsService;

@Service
public class NewsService implements INewsService {
	@Autowired // Cơ chế nhúng giống với @Inject trong Servlet
	private NewsRepository newsRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	NewsConverter newsConverter;

	@Override
	public NewsDTO save(NewsDTO newsDTO) {
		NewsEntity newsEntity = new NewsEntity();
		if (newsDTO.getId() != null) {
			NewsEntity oldNewsEntity = newsRepository.findOne(newsDTO.getId());
			newsEntity = newsConverter.toEntity(newsDTO, oldNewsEntity); 
		}else {
			newsEntity = newsConverter.toEntity(newsDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
		newsEntity.setCategory(categoryEntity);
		newsEntity = newsRepository.save(newsEntity);
		return newsConverter.toDTO(newsEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			newsRepository.delete(item);
		}
	}

	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		List<NewsDTO> result = new ArrayList<NewsDTO>();
		List<NewsEntity> entities = newsRepository.findAll(pageable).getContent();
		for(NewsEntity item: entities) {
			NewsDTO newsDTO = newsConverter.toDTO(item);
			result.add(newsDTO);
		}
		return result;
	}

	@Override
	public int totalItem() {
		
		return (int) newsRepository.count();
	}

	@Override
	public List<NewsDTO> findAll() {
		List<NewsDTO> result = new ArrayList<NewsDTO>();
		List<NewsEntity> entities = newsRepository.findAll();
		for(NewsEntity item: entities) {
			NewsDTO newsDTO = newsConverter.toDTO(item);
			result.add(newsDTO);
		}
		return result;
	}

//	@Override
//	public NewsDTO update(NewsDTO newsDTO) {
//		NewsEntity oldNewsEntity = newsRepository.findOne(newsDTO.getId());
//		NewsEntity newsEntity = newsConverter.toEntity(newsDTO, oldNewsEntity);
//		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
//		newsEntity.setCategory(categoryEntity);
//		newsEntity = newsRepository.save(newsEntity);
//		return newsConverter.toDTO(newsEntity);
//	}

}
