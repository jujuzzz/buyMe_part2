package vo;

import java.sql.Timestamp;

public class bidVo {
	private int bid;
	private String buid;
	private float money;
	private Timestamp time;
	private int aid;
	
	
	
	
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBuid() {
		return buid;
	}
	public void setBuid(String buid) {
		this.buid = buid;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	@Override
	 public String toString() {
	  // TODO Auto-generated method stub
	  return "Bid ID: " + bid + 
	    "\n Buyer Username: " + buid +
	    "\n Auction ID: " + aid +
	    "\n Bid Time: " + time + 
	    "\n Bid Price: " + money;
	 }

	

}
