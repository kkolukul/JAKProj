 
			<jsp:include page="header.jsp"></jsp:include>


	<div id="site_content">   
			<form action="authController" name="reg" method="get">
			<div class="form_settings" >
		<center>
			
		<h2>Create New Account</h2>
		 <div>
				<%
				String result=(String)request.getAttribute("result"); 
				if("FAIL".equals(result))
				{
				 %>
					<h4><span style="color:red">User already exist associated with this email.</span></h4> 
				<%
				}
				%>
			</div>
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" class="concat" name="fname" required></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" class="concat" name="lname" required></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" class="concat" name="email" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" class="concat" name="password" required></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="number" class="concat" name="age" required></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<input type="radio" name="gender" value="male" checked="checked">Male<br/>
					<input type="radio" name="gender" value="female">Female 
				</td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><input type="number" class="concat" name="phnno" required></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="submit" value=" Submit ">&nbsp;&nbsp;
				<input type="reset" class="submit" value=" Reset "></td>
			</tr>
			</table>
			<input type="hidden" name="action" value="signup"> 
		</center>
		
		</div>
		</form>
    </div>

 
			<jsp:include page="footer.jsp"></jsp:include>
