package LGSMS.Dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import LGSMS.Model.Account;
import LGSMS.Model.Role;

@Repository
public class AccountDao extends JdbcDaoSupport  {
	
	 @Autowired
	    public AccountDao(DataSource dataSource) {
	        this.setDataSource(dataSource);
	    }
	 
	 private static final String BASE_SQL = //
	            "Select  p.email, p.created_at, p.updated_at, a.account_id, a.username, a.role_id,  a.is_active, r.role_name "
	            + "from ((account a inner join profile p on a.profile_id = p.profile_id) inner join role r on a.role_id = r.role_id) ";
	  
	  class getAllTheListAccount implements  ResultSetExtractor <List<Account>>{

		@Override
		public List<Account> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<Account> list = new ArrayList<Account>();
			 while (rs.next()) {
				 	
				 	
	                int account_id = rs.getInt("account_id");
	                String username = rs.getString("username");
	                String email = rs.getString("email");
	                Role role= new Role();
	                
	                int role_id= rs.getInt("role_id");
	                String role_name= rs.getString("role_name");
	                Boolean is_active = rs.getBoolean("is_active");
	                Date created_at= rs.getDate("created_at");
	                Date updated_at= rs.getDate("updated_at");
	                role.setRoleID(role_id);
	                role.setRoleName(role_name);
	                Account acc = new Account();
	                acc.setAccount_id(account_id);
	                acc.setUsername(username);
	                acc.setEmail(email);
	                acc.setRole(role);
	                acc.setIs_active(false);
	                acc.setCreated_at(created_at);
	                acc.setUpdated_at(updated_at);
	                list.add(acc);
	            }
	            return list;
		}
		  
	  }
	  
	  
	  class getAllTheRole implements  ResultSetExtractor <List<Role>>{

			@Override
			public List<Role> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Role> list = new ArrayList<Role>();
				 while (rs.next()) {
					 	
					 	
					 int role_id= rs.getInt("role_id");
		                String role_name= rs.getString("role_name");
		                
		                Role ro = new Role();
		                ro.setRoleID(role_id);
		                ro.setRoleName(role_name);
		                list.add(ro);
		            }
		            return list;
			}
			  
		  }
	  
	   public List<Account> getAccounts() {
	        String sql = BASE_SQL;
	                

	        getAllTheListAccount rse = new getAllTheListAccount();

	        // <T> T query(String sql, ResultSetExtractor<T> rse, Object... args)
	        List<Account> listAcc = this.getJdbcTemplate().query(sql, rse);
	        return listAcc;
	    }
	   
//	   public List<Role> getRole() {
//	        String sql = BASE_SQL;
//	                
//
//	        getAllTheRole rse = new getAllTheRole();
//
//	        // <T> T query(String sql, ResultSetExtractor<T> rse, Object... args)
//	        List<Role> list = this.getJdbcTemplate().query(sql, rse);
//	        return list;
//	    }
//	   
//	   public Account getAccountRoleByID(int roleID) {
//		   
//		   for(Account a: getAccount()) {
//			   if(a.getRole_id() == roleID) {
//				   return a;
//			   }
//		   }
//		return null;
//	   }
}
