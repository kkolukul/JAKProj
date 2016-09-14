 
			<jsp:include page="header.jsp"></jsp:include>


	<div id="site_content">  
	
		<% 
				String message =(String)session.getAttribute("msg"); 
				if(message !=null)
				{
				 %>
				 	<div>
				 	<center><h2><span style="color:green"> <b><%=message %></b></span></h2></center>
				 	</div>
					<br/> 
				 <%			
				}
		%>

<h1>Welcome to JAK Shopping </h1>
<img src="images/cart1.jpeg" height="200"/>
<img src="images/cart2.jpeg" height="200"/>	
			<p><br/>
				<b>Hello!!<br/>
Its always better and comfortable to get things done from home.<br/>
Online shopping or e-shopping is a form of electronic commerce which allows 
consumers to directly buy goods or services from a seller over the internet using a web browser.<br/>
All that you need is having access to the internet.<br/>
Users find a product of interest by visiting the website of retailer directly.<br/>
Once required product is found on the website of seller,it can be added to the shipping cart.<br/>
The software enables the user to accumulate multiple items and also to adjust quantities.<br/>
A checkout process follows in which total cost is estimated and delivery information is collected.<br/>
We,in our website provide cash-on-delivery facility(only).<br/>
You can also check for the status(track) of your order time to time.<br/><br/>
Customers are attracted to online shopping not only because of high levels of convenience,
but also because of:<br/>
<i>Broader selections<br/>
Competitive pricing<br/>
Greater access to information<br/>
24 hours Availability of services<br/>
</i></b>
		</p>
    </div>

 
			<jsp:include page="footer.jsp"></jsp:include>
