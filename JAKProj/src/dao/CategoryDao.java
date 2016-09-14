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


public class CategoryDao {

	public Connection con;
	public Statement st;
	
	public CategoryDao()
	{
		con = ConFactory.getConnection();
	}
	
	public List getSubCategories(int code, int parentCode) 
	{
		try
		{
			st = con.createStatement();
			
			String query = null;
			
			if(parentCode == 0)
			{
				query = "select name,code,parent_code from category where parent_code = "+ code;
			}
			else
			{
				query = "select name,code,parent_code from category where parent_code = "+ parentCode;
			}
			
			ResultSet rs = st.executeQuery(query);
				
			List list = new ArrayList<>();
			
			while(rs.next()){
				
				Map cat = new HashMap();
				cat.put("name", rs.getString("name"));
				cat.put("code", rs.getInt("code"));
				cat.put("parentCode", rs.getInt("parent_code"));
				
				list.add(cat);
			}
			
			st.close();
			con.close();		
			
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
}
