package ezen.hang.heritage.domain.comment.dto;



public class Comment {
	private int ruid; // 코멘트 고유번호 pk
	private String userid;
	private String ccbaAsno; // 문화제 고유 번호
	private int starpoint; // 별점

	public Comment() {
	}

	public Comment(int ruid, String userid, String ccbaAsno, int starpoint) {
		this.ruid = ruid;
		this.userid = userid;
		this.ccbaAsno = ccbaAsno;
		this.starpoint = starpoint;
	}

	public int getRuid() {
		return ruid;
	}

	public void setRuid(int ruid) {
		this.ruid = ruid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCcbaAsno() {
		return ccbaAsno;
	}

	public void setCcbaAsno(String ccbaAsno) {
		this.ccbaAsno = ccbaAsno;
	}

	public int getStarpoint() {
		return starpoint;
	}

	public void setStarpoint(int starpoint) {
		this.starpoint = starpoint;
	}

}
