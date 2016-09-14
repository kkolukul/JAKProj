 
			<jsp:include page="header.jsp"></jsp:include>


	<div id="site_content" >   
			<form id="contact" action="authController" method="post">
				<center>
				<h2>Change Your Password</h2>
					<div>
						<%
						String result=(String)request.getAttribute("result"); 
						if("MISMATCH".equals(result))
						{
						 %>
							<h4><span id="message" style="color:red">Password mismatch.</span></h4> 
						<%
						}
						else if("FAIL".equals(result))
						{
							%>
							<h4><span id="message" style="color:red">Invalid Password.</span></h4> 
							<%
						}
						%>
					</div>
					 <div class="form_settings" >
						<table>
						<tr>
							<td>Current Password </td>
							<td><input type="password" class = "concat" size=20 name="password" minlength="6" required></td>
						</tr>
						
						<tr>
							<td>New Password </td>
							<td><input type="password" class = "concat" size=20 name="newpwd" minlength="6" required></td>
						</tr>						
						<tr>
							<td>Confirm Password </td>
							<td><input type="password" class = "concat" size=20 name="cnfpwd" minlength="6" required></td>				
						</tr>
						<tr>
							<td> &nbsp;</td>
							<td><input class="submit" type="submit"  value="Submit"/></td>					
						</tr>
					</table>
					</div>	
						<input type="hidden" name="action" value="changePwd">
				</center>		
			</form>
    </div>

 
			<jsp:include page="footer.jsp"></jsp:include>
