<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.User"%>
<!DOCTYPE HTML>
<html>

<head>
  <title>JAK SHOPPING</title>
  
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>

<body>
  <div id="main">
    <header>
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="#">JAK <span class="logo_colour">SHOPPING</span></a></h1>
          <h2>shop online now...</h2>		  
        </div>
		
		<%
		   User user = (User) session.getAttribute("user");
		   if(user!=null)
		   {
		   %>
			<div>
			  <ul class="sf-menu" id="nav">
				<li><a href="#"><b>Hi <%=user.getFirstName()%>&nbsp;...!</b></a></li>
				<li><a href="navController?page=changePwd"><b>Change Password</b></a></li>
				<li><a href="navController?page=logout"><b>Logout</b></a></li>
			</ul>
			</div>
		   <%
		   }
		   else
		   {
		   %>
		    <div>
			  <ul class="sf-menu" id="nav">
				<li><a href="navController?page=login"><b>Login</b></a></li>
				<li><a href="navController?page=signup"><b>Create Account</b></a></li>
			</ul>
			</div>
			<%	   
		   }
		%>
       
		
      </div>
	 
      <nav>
        <div id="menu_container">
          <ul class="sf-menu" id="nav">
            <li><a href="prodController?code=1000&parentCode=0">Electronics</a></li>
            <li><a href="prodController?code=2000&parentCode=0">Men</a></li>
            <li><a href="prodController?code=3000&parentCode=0">Women</a></li>
            <li><a href="prodController?code=4000&parentCode=0">Baby & Kids</a></li>
            <li><a href="prodController?code=5000&parentCode=0">Books & Media</a> </li>
            <li><a href="prodController?code=6000&parentCode=0">Home & Kitchen</a></li>
			<li><a href="#">More</a></li>			
          </ul>
        </div>
      </nav>
	  
    </header>    
   
  </div>
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/jquery.easing-sooper.js"></script>
  <script type="text/javascript" src="js/jquery.sooperfish.js"></script>
  <script type="text/javascript">
    $(document).ready(function() {
      $('ul.sf-menu').sooperfish();
      $('.top').click(function() {$('html, body').animate({scrollTop:0}, 'fast'); return false;});
    });
  </script>
</body>
</html>
