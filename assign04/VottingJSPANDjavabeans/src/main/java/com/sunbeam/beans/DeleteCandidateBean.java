package com.sunbeam.beans;



import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidateBean {
	
	private int id;
	private String msg;
	public DeleteCandidateBean() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void delete() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			int count  = candDao.deleteById(id);
			
			this.msg="candidated deleted"+count;
	}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
	

}
	}
	}
