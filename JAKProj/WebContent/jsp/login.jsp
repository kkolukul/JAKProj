 
			<jsp:include page="header.jsp"></jsp:include>


	<div id="site_content" >   
			<form id="contact" action="authController" method="post">
				<center>
				<h2>Login Your Account</h2>
					<div>
						<%
							String result=(String)request.getAttribute("result"); 
							if("FAIL".equals(result))
							{
							 %>
								<h4><span style="color:red">Invalid Credentials</span></h4> 
							<%
							}
						%>
					</div>
					<div>
						<%
							String msg=(String)request.getAttribute("msg"); 
							if(msg!=null)
							{
							 %>
							 	<div>
							 	<h4><span style="color:green"> <b><%=msg %></b></span></h4>
							 	</div>
								<br/> 
							 <%			
							}	
						%>
					</div>
					 <div class="form_settings" >
						<table>
						<tr>
							<td>Email Id  </td>
							<td><input type="email" class = "concat" size=20 name="email" required></td>
						</tr>
						
						<tr>
							<td>Password </td>
							<td><input type="password" class = "concat" size=20 name="password" minlength="6" required></td>
						</tr>						
						<tr>
							<td> &nbsp;</td>
							<td><input class="submit" type="submit"  value="Submit"/></td>					
						</tr>
					</table>
					</div>	
						<input type="hidden" name="action" value="login">
				</center>		
			</form>
    </div>

 
			<jsp:include page="footer.jsp"></jsp:include>
