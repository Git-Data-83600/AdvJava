package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidateBean {
	private int id;
	private int count;
	public DeleteCandidateBean () {
		
	}

	public int getId() {
		return id;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void deleteCandidate() {
		try (CandidateDao c = new CandidateDaoImpl()){
			count = c.deleteById(this.id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
