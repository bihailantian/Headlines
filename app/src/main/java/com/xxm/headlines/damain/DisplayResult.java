package com.xxm.headlines.damain;

import java.util.List;

public class DisplayResult {
	
	private List<ResultItem> data;  //结果条目
	private int stat;  //状态码
	
	public List<ResultItem> getData() {
		return data;
	}

	public void setData(List<ResultItem> data) {
		this.data = data;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	@Override
	public String toString() {
		return "DisplayResult [data=" + data + ", stat=" + stat + "]";
	}
	
	

}
