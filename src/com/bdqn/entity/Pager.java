package com.bdqn.entity;

public class Pager {
	
	private int currPage=1;//��ǰҳ��
	
	private int pageSize=5;//ÿҳ��С
	
	private int totalCounts;//�ܼ�¼��
	
	private int totalPages;//��ҳ��

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCounts() {
		return totalCounts;
	}
    //�����ܼ�¼��ʱ���Զ��������ҳ��
	public void setTotalCounts(int totalCounts) {
		this.totalCounts = totalCounts;
		if(totalCounts==0){
			this.totalPages=0;//û�м�¼ֱ��Ϊ0ҳ
		}else{
			this.totalPages=(this.totalCounts-1)/this.pageSize+1;//������ҳ��
		}
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
	

}
