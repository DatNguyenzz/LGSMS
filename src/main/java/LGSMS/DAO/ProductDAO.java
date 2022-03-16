package LGSMS.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO extends JdbcDaoSupport {
	@Autowired
	public ProductDAO (Datasource dataSource) {
		this.setDataSource(getDataSource());
	}
	
	private static final String BASE_SQL = 
}
