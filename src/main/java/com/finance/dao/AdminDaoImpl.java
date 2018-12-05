package com.finance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.finance.model.User;

public class AdminDaoImpl implements AdminDao {
	  @Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
		}
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
	
	/**
	 * This method 
	 * @return list:The list of all the users registered
	 */
	public List<User> getAllUsers(){  
		 return jdbcTemplate.query("select * from gr1_users",new ResultSetExtractor<List<User>>(){  
		    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {    
		        List<User> list=new ArrayList<User>();  
		        while(rs.next()){  
		        User u=new User();  
		        u.setId(rs.getInt(1));
		        u.setName(rs.getString(2));
		        u.setPhone(rs.getLong(3));
		        u.setEmail(rs.getString(4));
		        u.setAddress(rs.getString(5));
		        u.setUname(rs.getString(6));
		        u.setPassword(rs.getString(7));
		        u.setCard(rs.getString(8));
		        u.setAccountNo(rs.getLong(9));
		        u.setBank(rs.getString(10));
		        u.setIfsc(rs.getString(11));
		        u.setVerified(rs.getString(12));
		        list.add(u);  
		        }  
		        return list;  
		        }  
		 });  
	 }
	
	/**
	 * @param User u:The particular user data to update
	 * @return to the info page updating the user data after verification
	 */
	public int updateUser(User u){  
	    String sql="update gr1_users set gu_verified = '"+u.getVerified()+"' where gu_u_id = "+u.getId();
	    return jdbcTemplate.update(sql);  
	}  
	
	/**
	 * @param id.The user id for which the data has to be deleted.
	 * @return to the page which the particular data deleted.
	 */
	public int delete(int id){  
	    String sql="delete from gr1_users where gu_u_id="+id+"";  
	    return jdbcTemplate.update(sql);  
	}  
	
	/**
	 * @param id:The id of the particular user
	 * @return list:The details of the particular user to display using id
	 */
	public List<User> getUsrById(int id){  
	    String sql="select * from gr1_users where gu_u_id=?";  
	    return jdbcTemplate.query(sql, new Object[]{id},new ResultSetExtractor<List<User>>(){  
		    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {    
		        List<User> list=new ArrayList<User>();  
		        while(rs.next()){  
		        User u=new User();  	
		        u.setId(rs.getInt(1));
		        u.setName(rs.getString(2));
		        u.setPhone(rs.getLong(3));
		        u.setEmail(rs.getString(4));
		        u.setAddress(rs.getString(5));
		        u.setUname(rs.getString(6));
		        u.setPassword(rs.getString(7));
		        u.setCard(rs.getString(8));
		        u.setAccountNo(rs.getLong(9));
		        u.setBank(rs.getString(10));
		        u.setIfsc(rs.getString(11));
		        u.setVerified(rs.getString(12));
		        list.add(u);  
		        }
				return list;  
		    }
	    });  
	}  
	
	/**
	 * @param name:The name of the particular user
	 * @return list:The details of the particular user to display using name
	 */
	public List<User> getUsrByUname(String uname){  
	    String sql="select * from gr1_users where gu_uname=?";  
	    return jdbcTemplate.query(sql, new Object[]{uname},new ResultSetExtractor<List<User>>(){  
		    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {    
		        List<User> list=new ArrayList<User>();  
		        while(rs.next()){  
		        User u=new User();  	
		        u.setId(rs.getInt(1));
		        u.setName(rs.getString(2));
		        u.setPhone(rs.getLong(3));
		        u.setEmail(rs.getString(4));
		        u.setAddress(rs.getString(5));
		        u.setUname(rs.getString(6));
		        u.setPassword(rs.getString(7));
		        u.setCard(rs.getString(8));
		        u.setAccountNo(rs.getLong(9));
		        u.setBank(rs.getString(10));
		        u.setIfsc(rs.getString(11));
		        u.setVerified(rs.getString(12));
		        list.add(u);  
		        }
				return list;  
		    }
	    });
}
}
