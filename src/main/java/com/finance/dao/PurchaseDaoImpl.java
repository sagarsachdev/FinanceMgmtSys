package com.finance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.finance.model.Card;
import com.finance.model.Purchase;
import com.finance.model.User;

public class PurchaseDaoImpl implements PurchaseDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	} 

	public int purchaseDetails(Purchase pd){    
	    String sql="insert into gr1_products_details values('"+pd.getId()+"','"+pd.getProductId()+"',"+"sysdate"+",'"+pd.getPeriod()+"','"+pd.getCost()+"')";    
	    return  jdbcTemplate.update(sql);    
	}   
	
	public int updateCard(Card c, User u, Purchase pd){  
		String sql=null;
			float value = c.getValue() - pd.getCost();
		    sql="update gr1_card set gc_value = '"+value+"' where gc_name = '"+u.getUname()+"'";
		    return jdbcTemplate.update(sql);
	}  
	
	public List<Purchase> getPurchaseById(int id){
		String sql = "select * from GR1_PRODUCTS_DETAILS where GPD_GU_U_ID = ?";
		return jdbcTemplate.query(sql, new Object[]{id},new ResultSetExtractor<List<Purchase>>(){  
		    public List<Purchase> extractData(ResultSet rs) throws SQLException, DataAccessException {    
		        List<Purchase> list=new ArrayList<Purchase>();  
		        while(rs.next()){  
		        	Purchase p = new Purchase();
		        	p.setId(rs.getInt(1));
		        	p.setProductId(rs.getInt(2));
		        	p.setBuyingDate(rs.getString(3));
		        	p.setPeriod(rs.getInt(4));
		        	p.setCost(rs.getFloat(5));
		        	list.add(p);
		        }
		        return list;
		    }
		});
	} 
}
