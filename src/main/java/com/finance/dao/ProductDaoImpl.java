package com.finance.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.finance.model.Period;
import com.finance.model.Product;

  
public class ProductDaoImpl implements ProductDao{  
	@Autowired
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	} 

	/**
	 * @param 
	 * @return p:The list of all the products stored in database.
	 */
public List<Product> getProducts(){  
    return jdbcTemplate.query("select * from gr1_products order by gp_product_id",new RowMapper<Product>(){  
        public Product mapRow(ResultSet rs, int row) throws SQLException {  
            Product p=new Product();  
            p.setProductId(rs.getInt(1));  
            p.setProductName(rs.getString(2));  
            p.setProductDetails(rs.getString(3));  
            p.setCost(rs.getDouble(4)); 
            p.setImage(rs.getString(5));
            return p;  
        }  
    });  
} 

/**
 * @param id:ID for the particular product to retrieve.
 * @return list: Product details of that particular product.
 */
public List<Product> getCategoryProducts(int id){  
	String q;
		q = "select * from gr1_products where gp_product_id = ?";
	return jdbcTemplate.query(q, new Object[] {id}, new ResultSetExtractor<List<Product>>(){  
		public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {    
			List<Product> list=new ArrayList<Product>();  
			while(rs.next()){  
				Product p=new Product();
				p.setProductId(rs.getInt(1));  
	            p.setProductName(rs.getString(2));  
	            p.setProductDetails(rs.getString(3));  
	            p.setCost(rs.getDouble(4)); 
	            p.setImage(rs.getString(5));
				list.add(p);  
			}  
			return list;  
		}  
	});  
}

/**
 * @param
 * @return p1:The list of all the Periods stored in the database.
 */
public List<Period> getPeriod1(){  
    return jdbcTemplate.query("select * from gr1_tenure",new RowMapper<Period>(){  
    	 public Period mapRow(ResultSet rs, int row) throws SQLException {  
             Period p1=new Period();  
             p1.setPeriod(rs.getInt(1));
             return p1;
    	 }  
    });  
} 
}