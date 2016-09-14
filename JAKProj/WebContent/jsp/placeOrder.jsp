<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
 
			<jsp:include page="header.jsp"></jsp:include>


	<div id="site_content"> 
	
	<center><h1>Place Your order</h1></center><br/>
	
		<div class="form_settings" >
			<%
				Map details = (HashMap) request.getAttribute("productDetails");	
			
				String id = (String)details.get("id");				
				String imageUrl = (String)details.get("imageUrl");
				String name = (String)details.get("name");
				String brand = (String)details.get("brand");
				String price = (String)details.get("price");
			%>
	<form action="prodController" name="f1" method="post">		
			<table width="80%">
				<tr>
					<th>Product</th>
					<th>Product Details</th>
					<th>Unit Price</th>
				<tr>
				<tr>
					<td>
						<img src="<%=request.getContextPath()%>\images\<%=imageUrl%>" height="100" width="100" />
					</td>
					<td>
						<div>
							<h2><%=name%></h2>
						</div>							
						<div>
							<h3><%=brand%></h3>
						</div>						
					</td>
					<td>						
						<h3>&nbsp;Rs.&nbsp; <%=price%>&nbsp;/-</h3>						
					</td>
				<tr>				
			</table>
			<br/>
			<h1>Order Information</h1>
			<table>
				<tr>
					<td>Quantity </td>
					<td><input type="number" id="txtQnty" name="qnty" onblur="calcPrice()" required/>	</td>				
				</tr>				
				<tr>
					<td>Shipping Address </td>
					<td><textarea name="shipAddress" rows="10" cols="80" required></textarea> </td>
				</tr>
				<tr>
					<td>Total Price </td>
					<td><input type="text" id="txtTotalPrice" readonly/></td>					
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td> <input class="submit" type="submit"  value=" Place Order "/> </td>
				</tr>
			</table>
			<input type="hidden" name="productId" value="<%=id%>" />
			<input type="hidden" id="hidUnitPrice" name="unitPrice" value="<%=price%>" />
			<input type="hidden" name="action" value="placeOrder" />
			</form>
		</div>	
    </div>

 
		  <jsp:include page="footer.jsp"></jsp:include>
		  
		  
<SCRIPT LANGUAGE="JavaScript">
	function calcPrice(){
	    var qty =0;
	    var price =0;
	    qty = document.getElementById("txtQnty").value;	
	    price = document.getElementById("hidUnitPrice").value;	
	    var totPrice = qty * price;
	    document.getElementById("txtTotalPrice").value = "Rs. " + totPrice + " /-"; 
	}
</SCRIPT>