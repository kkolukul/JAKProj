package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;


public class CustomerDao {

	public Connection con;
	
	public CustomerDao()
	{
		con = ConFactory.getConnection();
	}
	
	public boolean isValidCustomer(String sname,String spassword)
	{
		try
		{

			PreparedStatement st = con.prepareStatement("select count(*) from customer where email = ? and password = ? limit 1");
			st.setString(1, sname);
			st.setString(2, spassword);
			
			ResultSet rs =st.executeQuery();
			int count = 0;
			if(rs.next())
			    count = Integer.parseInt(rs.getString(1));
				
			st.close();
			
			
			if(count == 1)
			 return true;
			else
			 return false;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public User getUser(String email)
	{
		try
		{
			PreparedStatement st = con.prepareStatement("select * from customer where email = ? limit 1");
			st.setString(1, email);		
			ResultSet rs =st.executeQuery();
			
			User user = null;
			if(rs.next())
			{
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));	
				user.setGender(rs.getString("gender"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getString("role"));
				user.setStatus(rs.getString("status"));					
			}
			st.close();	    
			
			return user;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
			
		}
		
		
		
	}

	
	
	public int addNewCustomer(User user)
	{	
		try
		{
			PreparedStatement st1=con.prepareStatement("select count(*) from customer where email= ?");
			st1.setString(1,user.getEmail());
			ResultSet rs =st1.executeQuery();
			int count = 0;
			if(rs.next())
				 count = Integer.parseInt(rs.getString(1));
			if(count==0)
			{
				PreparedStatement st = con.prepareStatement("insert into customer(first_name,last_name,email,password,age,gender,phone) values (?,?,?,?,?,?,?)");
				
				String gen = user.getGender();
				
				if("male".equals(gen))
				{
					gen = "M";
				}
				else
				{
					gen = "F";
				}
				
				st.setString(1,user.getFirstName());
				st.setString(2,user.getLastName());
				st.setString(3, user.getEmail());
				st.setString(4,user.getPassword());
				st.setInt(5,user.getAge());
				st.setString(6,gen);
				st.setString(7,user.getPhone());
			
				
				int res = st.executeUpdate();
				
				System.out.println(res);
				st.close();
				
			}
			
			return count;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 1;
		}
		
		
	}
	
	public int changePassword(String email, String newPwd) 
	{	
			try
			{
				PreparedStatement st = con.prepareStatement("update customer set password=? where email=?");
				
				st.setString(1,newPwd);
				st.setString(2,email);
						
				int res = st.executeUpdate();			
				
				st.close();
				
				return res;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return 0;
			}			
		
		
	}
	
}
