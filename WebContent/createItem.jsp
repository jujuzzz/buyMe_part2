<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Auctions - buyMe</title>

<script type="text/javascript">

function getType(){
	var type = document.getElementById("type");
	var types = ["bathroom", "bedroom", "dinning&kitchen", "living room", "office"];
	type.length = 0;
	for (var i=0; i<types.length; i++){
		var op = document.createElement("option");
		op.value = types[i];
		op.innerHTML = types[i];
		type.appendChild(op);
	}
	getSubType();
}

function getSubType(){
	var subType = document.getElementById("subType");
	var subTypes = [	
		["Sink&faucets", "bathroom mirrors", "bathroom lighting", "showers", "bathroom storage", "bathroom accessories"],
		["Dinning tables", "dinning chairs", "bar tables", "bar chairs","kitchen sinks&faucets", "kitchen cabinets", 
			"countertops", "kitchen accessories", "step tools"],
		["Beds", "mattresses", "bedding", "wardrobes", "bedroom storage", "bedroom mirrors", "bedroom lighting"],
		["media furniture", "sofas", "armchairs, side tables", "living room storage", "living room lighting", "living room decoration"],
		["Desk", "office chair", "bookshelves&bookcase", "office storage&accessories"]
	];
	var typeIndex = document.getElementById("type").selectedIndex;
	subType.length = 0;
	for (var i = 0; i < subTypes[typeIndex].length; i++){
		var op = document.createElement("option");
		op.value = subTypes[typeIndex][i];
		op.innerHTML = subTypes[typeIndex][i];
		subType.appendChild(op);
	}
} 
	
</script>

</head>
<body onload="getType()">
 <div>
  <form action="servlet/createItemServlet" method="post">
    <br/>Please add information for your auction, fields with * are mandatory.
    <br/>
    <br/>
    
    <br/> Describe you item(s):
    <table>
	<tr><td>Item Name:</td><td><input type="text"  name="itemname"/>*</td></tr>
	<tr><td>Type: 
	</td><td>
	 Category <SELECT name="type" id="type" onChange="getSubType()"></SELECT> 
     Sub-Category <SELECT name="subType" id="subType"></SELECT>*
    </td></tr>
 	 
	<tr><td>Material: 
	</td><td>
     <input type="radio" name="material" align="middle" value="mental"/>mental
     <input type="radio" name="material" align="middle"  value="texture"/>texture 
     <input type="radio" name="material" align="middle" value="plastic"/>plastic   
     <input type="radio" name="material" align="middle"  value="wood"/>wood
     <input type="radio" name="material" align="middle"  value="leather"/>leather  
    </td></tr>
        
    
    <tr><td>Condition：
    </td><td>
     <input type="radio" name="condition" align="middle" value="brand new"/>brand new
     <input type="radio" name="condition" align="middle"  value="refurbished"/>refurbished
     <input type="radio" name="condition" align="middle" value="used"/>used    
    </td></tr>
    
    <tr><td>Color：
    </td><td>
     <select name="color">
      <option>black</option>
      <option>blue</option>
      <option>brown</option>
      <option>grey</option>
      <option>green</option>
      <option>orange</option>
      <option>yellow</option>
      <option>pink</option>
      <option>red</option>
      <option>white</option>
      <option>yellow</option>
      <option>multiple</option>     
    </select>
    
    </td></tr>
    <tr><td>Start price:</td><td><input type="text"  name="price"/>*</td></tr>
        
    </table>  
    
      
    <table>
    <tr><td>Details about your item(s):</td></tr>
    <tr><td><textarea name="description" rows="6" cols="30"></textarea></td></tr>
    
    </table>
    
    <br/> Set your auction:
    <table>
	<tr><td>Start Time</td><td><input type="text"  name="startTime"/>*</td></tr>
	<tr><td>End Time</td><td><input type="text"  name="endTime"/>*</td></tr>
	<tr><td>Reserve Price</td><td><input type="text"  name="reversePrice"/>(If you don't have a reserve price, enter 0)</td></tr>
	<tr><td><input type="submit" name="g" value="create"/></td></tr>
	
    </table>
    
    
   
    
            
  </form>
</div>
</body>
</html>
