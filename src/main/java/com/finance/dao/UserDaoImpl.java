package com.finance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.finance.model.Login;
import com.finance.model.User;
public class UserDaoImpl implements UserDao {
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
 * 
 * @param query1 : Query to retrieve next value of sequence
 * @return res : returns next value of sequence
 */
private int getSeq(String query1) {
	int res = jdbcTemplate.queryForObject(query1, Integer.class);
	return res;
}

/**
 * @param u:The particular user to register 
 * @return value if the query is successful.
 */
public int register(User u) {
	String query1 = "select gr1_users_seq.nextval from dual";
	int query2 = getSeq(query1);
	u.setId(query2);
	String query = "insert into gr1_users values('"+u.getId()+"','"+u.getName()+"','"+u.getPhone()+"','"+u.getEmail()+"','"+u.getAddress()+"','"+u.getUname()+"','"+u.getPassword()+"','"+u.getCard()+"','"+u.getAccountNo()+"','"+u.getBank()+"','"+u.getIfsc()+"','"+u.getVerified()+"')";
	return jdbcTemplate.update(query);
    }

/**
 * @param login:The login object passed to the method.
 * @return user: The particular user whose details matched. 
 */
public User validateUser(Login login) {
    String sql = "select * from gr1_users where gu_uname='" +login.getUname() + "' and gu_password='" + login.getPassword()+ "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
    }
  class UserMapper implements RowMapper<User> {
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setUname(rs.getString("gu_uname"));
    user.setPassword(rs.getString("gu_password"));
    return user;
  	}
  }
  
  /**
   * @param login : Accepts login object for updating the user's password
   * return : returns positive integer value if query is successfully executed
   */
  public int update(Login login){  
	    String sql="update gr1_users set gu_password = '" + login.getPassword() + "' where gu_uname = '"+ login.getUname() + "'";  
	    return jdbcTemplate.update(sql);  
	} 
  
}
