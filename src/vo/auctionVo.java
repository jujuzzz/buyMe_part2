package vo;

import java.sql.Timestamp;

public class auctionVo {
	private float reverse;
	private Timestamp start;
	private Timestamp end;
	private Timestamp time;
	private String sid;
	private int iid;
	private int aid;
	
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public Timestamp getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	public Timestamp getEnd() {
		return end;
	}
	public void setEnd(Timestamp end) {
		this.end = end;
	}
	public float getReverse() {
		return reverse;
	}
	public void setReverse(float reserve) {
		this.reverse = reserve;
	}
	
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	@Override
	 public String toString() {
	  // TODO Auto-generated method stub
	  return "reverse: " + reverse + 
	    "\n start: " + start +
	    "\n end: " + end +
	    "\n time: " + time + 
	    "\n sid: " + sid +
	    "\n iid: " + iid + 
	    "\n aid: " + aid;
	 }



}
