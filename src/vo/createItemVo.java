package vo;

import java.lang.String;
 
public class createItemVo {
	private String itemname;
	private String type;
	private String subType;
	private String material;
	private String condition;
	private String color; 
	private float price; 
	private int iid; 
	private String description;
	
	public String getName() {
		return itemname;
	}
	public void setName(String itemname) {
		this.itemname = itemname;
	}
 
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getMaterial() {
		return material;
	} 
	public void setMaterial(String material) {
		this.material = material;
	}

	
	public String getCondition() {
		return condition;
	} 
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	public String getColor() {
		return color;
	} 
	public void setColor(String color) {
		this.color = color;
	}
	
	
	public float getPrice() {
		return price;
	} 
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	public int getiid() {
		return iid;
	} 
	public void setiid(int iid) {
		this.iid = iid;
	}


	
	
	public String getDescription() {
		return description;
	} 
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	 public String toString() {
	  // TODO Auto-generated method stub
	  return "itemname:" + itemname + 
	    "\n material: " + material +
	    "\n color: " + color +
	    "\n condition: " + condition + 
	    "\n price: " + price +
	    "\n iid: " + iid + 
	    "\n type: " + type + 
	    "\n subType: " + subType +
	    "\n description: " + description  ;
	 }




 
}
