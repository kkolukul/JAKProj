package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

public class PurchaseOrderDao 
{
	public Connection con;
	public Statement st;
	
	public PurchaseOrderDao()
	{
		con = ConFactory.getConnection();
	}
	
	public int placeOrder(int customerId, String orderInfo, long totalPrice, String shippingAddress)
	{
		
		try
		{
			PreparedStatement st = con.prepareStatement("insert into purchase_order(customer_id,order_info,amount,shipping_address,order_date) values (?,?,?,?,?)");
			
			st.setInt(1,customerId);
			st.setString(2,orderInfo);
			st.setLong(3, totalPrice);
			st.setString(4, shippingAddress);
			st.setString(5, new Date().toString());			
					
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

	
