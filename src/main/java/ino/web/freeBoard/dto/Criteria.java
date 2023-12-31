package ino.web.freeBoard.dto;

import org.springframework.web.util.UriComponentsBuilder;

public class Criteria {

    private int pageNum;
    private int amount;

    private String type;
    private String keyword;
    
    public Criteria() {
        this(1, 10);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	 @Override
	    public String toString() {
	        return "Criteria{" +
	                "pageNum=" + pageNum +
	                ", amount=" + amount +
	                ", type='" + type + '\'' +
	                ", keyword='" + keyword + '\'' +
	                '}';
	    }
	  public String[] getTypeArr() {
		    return type == null? new String[] {}: type.split("");
		  }
	  public String getListLink() {
		     String path = "";
		     UriComponentsBuilder builder  = 
		           UriComponentsBuilder.fromPath(path)
		           .queryParam("pageNum", this.pageNum)
		           .queryParam("amount", this.amount)
		           .queryParam("type", this.getType())
		           .queryParam("keyword", this.keyword) 
		           ;      
		     return builder.toUriString();
		  }
}

