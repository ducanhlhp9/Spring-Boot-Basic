package com.laptrinhjavaweb.api.output;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.NewsDTO;

public class NewsOutput {
	private int page;
	private int totalPage;
	private List<NewsDTO> listResult = new ArrayList<>();

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<NewsDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<NewsDTO> listResult) {
		this.listResult = listResult;
	}

}
