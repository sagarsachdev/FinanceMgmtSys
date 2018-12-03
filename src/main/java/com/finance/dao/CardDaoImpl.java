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
import org.springframework.stereotype.Controller;

import com.finance.model.Card;
import com.finance.model.User;

@Controller
public class CardDaoImpl implements CardDao {
	@Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  static final int GOLD_VALUE = 40000;
	  static final int TITANIUM_VLAUE = 80000;
	  public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	  }
	  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	  }
	
	/**
	 *@param u:The user registered.
	 * @return generate the card for the user registered.
	 */
	public int insertCard(User u) {
		long first14 = (long) (Math.random() * 100000000000000L);
		long number = 5200000000000000L + first14;
		int value= u.getCard().equals("gold") ? GOLD_VALUE : TITANIUM_VLAUE;
		String query = "insert into gr1_card values("+number+",'"+u.getUname()+"','"+u.getCard()+"',"+"ADD_MONTHS(SYSDATE,60)"+","+value+")";
		return jdbcTemplate.update(query);
	}
	
	/**
	 * @return list:The list returns all the card details of all users.
	 */
	public List<Card> getAllCards(){  
		 return jdbcTemplate.query("select * from gr1_card",new ResultSetExtractor<List<Card>>(){  
		    public List<Card> extractData(ResultSet rs) throws SQLException, DataAccessException {    
		        List<Card> list=new ArrayList<Card>();  
		        while(rs.next()){  
		        Card c=new Card();
		        c.setCardNo(rs.getLong(1));
		        c.setUname(rs.getString(2));
		        c.setCardType(rs.getString(3));
		        c.setValidity(rs.getString(4));
		        c.setValue(rs.getInt(5));
		        list.add(c);  
		        }  
		        return list;  
		        }  
		 });  
	 }
	
	/**
	 * @param fname:Username to get the card.
	 * @return lst:The card details of the particular user.
	 */
	public List<Card> getCardByName(String uname){
		String q = "select * from gr1_card where gc_name=?";
		return jdbcTemplate.query(q, new Object[]{uname} ,new ResultSetExtractor<List<Card>>() {
			public List<Card> extractData(ResultSet rs) throws SQLException, DataAccessException {    
				List<Card> lst = new ArrayList<Card>();
				while(rs.next()){ 
				Card c=new Card();
		        c.setCardNo(rs.getLong(1));
		        c.setUname(rs.getString(2));
		        c.setCardType(rs.getString(3));
		        c.setValidity(rs.getString(4));
		        c.setValue(rs.getInt(5));
		        lst.add(c);
		        }
				return lst;
			}
		});
		
	}
}
