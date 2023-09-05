package ino.web.freeBoard.dto;


public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria criteria;

	public PageDTO(Criteria criteria, int total) {
		this.criteria = criteria;
		this.total = total;
		
		this.endPage = (int) (Math.ceil(criteria.getPageNum() / 10.0)) * 10;
		
		this.startPage = this.endPage - 9;
		
		int realEnd = (int) (Math.ceil((total * 1.0) / criteria.getAmount()));
		
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
	public int getStartPage() {
        return startPage;
    }
	
	public int getCurrentPage() {
	    return criteria.getPageNum();
	}

    public int getEndPage() {
        return endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }

    public int getTotal() {
        return total;
    }

    public Criteria getCri() {
        return criteria;
    }
}