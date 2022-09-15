package com.onetomany.onetomanyproblem.dto;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public class PageDTO<T> {

	private Collection<T> content;
	private boolean last;
	private int totalPages;
	private long totalElements;
	private int size;
	private int number;
	private Sort sort;
	private boolean first;
	private int numberOfElements;
	private boolean empty;
	
	public PageDTO(Collection<T> objs, Page<?> page) {
		content = objs;
		last = page.isLast();
		totalPages = page.getTotalPages();
		totalElements = page.getTotalElements();
		size = page.getSize();
		number = page.getNumber();
		sort = page.getSort();
		first = page.isFirst();
		numberOfElements = page.getNumberOfElements();
		empty = page.isEmpty();
	}

	public Collection<T> getContent() {
		return content;
	}

	public boolean isLast() {
		return last;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public int getSize() {
		return size;
	}

	public int getNumber() {
		return number;
	}

	public Sort getSort() {
		return sort;
	}

	public boolean isFirst() {
		return first;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public boolean isEmpty() {
		return empty;
	}
}
