package org.zerock.myapp.domain;

import lombok.Data;

////페이징 처리를 위한 2가지 기준정보를 가지는 클래스 
@Data
public class Criteria {
	private int currPage = 1;  //현재 페이지 번호 
	private int amount = 3; 	//각 페이지에서 보여줄 게시물 개수 
	

}//end class 

//@Data
//public class Criteria {
//    
//    private int page = 1;
//    private int perPageNum = 3;
//    
//    public int getPageStart() {
//        return (this.page-1)*perPageNum;
//    }
//    
////    public Criteria() {
////        this.page = 1;
////        this.perPageNum = 3;
////    }
//    
//    public int getPage() {
//        return page;
//    }
//    public void setPage(int page) {
//        if(page <= 0) {
//            this.page = 1;
//        } else {
//            this.page = page;
//        }
//    }
//    public int getPerPageNum() {
//        return perPageNum;
//    }
//    public void setPerPageNum(int pageCount) {
//        int cnt = this.perPageNum;
//        if(pageCount != cnt) {
//            this.perPageNum = cnt;
//        } else {
//            this.perPageNum = pageCount;
//        }
//    }
//    
//}
//
