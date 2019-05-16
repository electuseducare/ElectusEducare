package com.educare.admin.model;

public class SubjectWiseCampusPojo {
	private String subjname;
	private String highest_score;
	private String campusid;
	private String subjectd;
	private String campusname;

	public String getCampusid() {
		return campusid;
	}

	public void setCampusid(String campusid) {
		this.campusid = campusid;
	}

	public String getSubjectd() {
		return subjectd;
	}

	public void setSubjectd(String subjectd) {
		this.subjectd = subjectd;
	}

	private String exstrength;
	private String studentid;
	int Rank;
	int rnk;

	public int getRnk() {
		return rnk;
	}

	public void setRnk(int rnk) {
		this.rnk = rnk;
	}

	public int getRank() {
		return Rank;
	}

	public void setRank(int rank) {
		Rank = rank;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getExstrength() {
		return exstrength;
	}

	public void setExstrength(String exstrength) {
		this.exstrength = exstrength;
	}

	public String getSubjname() {
		return subjname;
	}

	public void setSubjname(String subjname) {
		this.subjname = subjname;
	}

	public String getHighest_score() {
		return highest_score;
	}

	public void setHighest_score(String highest_score) {
		this.highest_score = highest_score;
	}

	public String getCampusname() {
		return campusname;
	}

	public void setCampusname(String campusname) {
		this.campusname = campusname;
	}

}
