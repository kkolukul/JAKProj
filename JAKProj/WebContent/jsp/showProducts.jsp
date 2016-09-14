<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


 
			<jsp:include page="header.jsp"></jsp:include>


	<div id="site_content"> 

<table width="100%">
<tr>
<td width="20%" style="vertical-align:top">	
			<table width="100%">			
			
					<% 	
						List cat = (ArrayList) request.getAttribute("subCategories");	
						if(cat!=null)
						{
							for(int i=0;i<cat.size();i++){

								Map map = (HashMap) cat.get(i);

								String name = (String) map.get("name");
								int code = (Integer) map.get("code");
								int parentCode = (Integer) map.get("parentCode");
								   
								%>
									<tr style="font-weight:bold;background-color:gray">
										<td >
											<a href="prodController?code=<%=code %>&parentCode=<%=parentCode %>"><%=name %></a>
										</td>
									</tr>
								<%

								out.println("<br/>");
							}
						}
						
					%> 
				
			</table>
	</td>
	<td>
			<table width="60%">
		
				
					<%
					List list = (ArrayList) request.getAttribute("products");
					if(list!=null)
					{
						int size = list.size();	
						
						if(size > 0)
						{
							for(int i=0;i<size;i++){

							Map prod = (HashMap) list.get(i);
							String id = (String)prod.get("id");
							String name = (String)prod.get("name");
							String price = (String)prod.get("price");							
							String imgUrl=(String)prod.get("imageUrl");
							
							if(i!=0 && i%3 ==0)
							{
							%>
								</tr>
								<tr>
							<%
							}
							
							%>
								
								<td>
									<div>
										<b><%=name%></b>		
									<div>
									<div>
										<a href="prodController?action=chooseProduct&code=<%=id%>"><img src="<%=request.getContextPath()%>\images\<%=imgUrl%>"/></a>
									</div>
									<div>
										<b>Rs. <%=price%> /-</b>
									</div>									
									
								</td>
								
							<% 							
								
							}

						}
						else
						{
							out.println("No Products Found");
						}
						
					}
					
					%>

				
			
		 
 </table>
</td>
</tr>
</table>
    </div>

 
			<jsp:include page="footer.jsp"></jsp:include>


		
