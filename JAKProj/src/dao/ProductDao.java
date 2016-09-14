package dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ProductDao {

	public Connection con;
	public Statement st;
	
	public ProductDao()
	{
		con = ConFactory.getConnection();
	}
	
	public Map getProductDetails(int id)
	{
		try
		{
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from product where id = "+ id);
			
			Map details = new HashMap();
			
			if(rs.next())
			 {
				details.put("id", rs.getString("id"));
				details.put("name", rs.getString("name"));
				details.put("brand", rs.getString("brand"));
				details.put("price", rs.getString("price"));
				details.put("quantity", rs.getString("quantity"));		
				details.put("imageUrl", rs.getString("image_url"));		
			 }
			 
			 return details;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	public List getProducts(int code, int parentCode)
	{
		try
		{
			st = con.createStatement();
			
			String query = null;
			
			if(parentCode == 0)
			{
				query = "select * from product where category = "+ code;
			}
			else
			{
				query = "select * from product where sub_category = "+ code;
			}
			
			ResultSet rs = st.executeQuery(query);
				
			List products = new ArrayList<>();
			
			while(rs.next()){

				Map prod = new HashMap();
				
				prod.put("id", rs.getString("id"));
				prod.put("name", rs.getString("name"));		
				prod.put("price",rs.getString("price"));
				prod.put("imageUrl", rs.getString("image_url"));
							
				products.add(prod);
				
			}
			
			st.close();
			
			
			return products;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	

          
}
