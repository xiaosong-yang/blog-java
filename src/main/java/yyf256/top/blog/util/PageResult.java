package yyf256.top.blog.util;

import java.util.List;

public class PageResult {
	private int pageCount;
	
	private int pageSize;
	
	private int curPage;
	
	private List<?> result;
	
	private PageSearch searchParams;
	
	
	

	public PageResult() {
		super();
	}

	public PageResult(int pageCount, int pageSize, int curPage, List<?> result, PageSearch searchParams) {
		super();
		this.pageCount = pageCount;
		this.pageSize = pageSize;
		this.curPage = curPage;
		this.result = result;
		this.searchParams = searchParams;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<?> result) {
		this.result = result;
	}

	public PageSearch getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(PageSearch searchParams) {
		this.searchParams = searchParams;
	}
	
	
}
