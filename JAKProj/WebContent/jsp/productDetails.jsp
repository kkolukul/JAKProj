<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
 
			<jsp:include page="header.jsp"></jsp:include>


	<div id="site_content"> 
		<div class="form_settings" >
			<%
				Map details = (HashMap) request.getAttribute("productDetails");	
			
				String id = (String)details.get("id");				
				String imageUrl = (String)details.get("imageUrl");
				String name = (String)details.get("name");
				String brand = (String)details.get("brand");
				String price = (String)details.get("price");
			%>
	<form action="prodController" method="post">		
			<table>
				<tr>
					<td>
						<img src="<%=request.getContextPath()%>\images\<%=imageUrl%>" />
					</td>
					<td>
						<div>
							<h2><%=name%></h2>
						</div>							
						<div>
							<h3><%=brand%></h3>
						</div>
						<div>
							<h3>Price:&nbsp;&nbsp;Rs.&nbsp; <%=price%>&nbsp;/-</h3>
						</div>
						<div>
							Product will be delivered in 2-3 business days.
						</div>
					</td>
				<tr>
				<tr>
					<td>&nbsp;</td>
					<td><input class="submit" type="submit"  value="BUY NOW"/></td>					
				</tr>
			</table>
			<input type="hidden" name="productId" value="<%=id%>" />
			<input type="hidden" name="action" value="buyProduct" />
			</form>
		</div>	
    </div>

 
		  <jsp:include page="footer.jsp"></jsp:include>
