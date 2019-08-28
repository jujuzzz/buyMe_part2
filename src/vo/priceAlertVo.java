package vo;

public class priceAlertVo {
	private String buyerid;
	private int itemid;
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	private float newprice;
	
	public String getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}
	
	public float getNewprice() {
		return newprice;
	}
	public void setNewprice(float newprice) {
		this.newprice = newprice;
	}

}
