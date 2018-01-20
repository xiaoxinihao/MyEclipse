package cn.xiaoxi.util;

public class PageUtil {
	
	private int totalCount;// 总记录数
	private int pageSize = 8;// 页大小
	private int pageCount;// 总页数
	private int pageIndex;// 当前页

	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 在获取总记录数的同时，给 总页数赋值
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.pageCount = (totalCount % pageSize == 0) ? (totalCount / pageSize)
				: (totalCount / pageSize + 1);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public PageUtil() {
		super();
	}

	public PageUtil(int totalCount, int pageSize, int pageCount, int pageIndex) {
		super();
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.pageIndex = pageIndex;
	}

	@Override
	public String toString() {
		return "PageUtil [totalCount=" + totalCount + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", pageIndex=" + pageIndex + "]";
	}

}
