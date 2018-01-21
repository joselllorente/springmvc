package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBUtil {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	public void initialize() {
		//System.out.println("DbUtil.initialize() *************************************** ");
		DataSource dataSource = getDataSource();
		String sql="";
		try {
			Connection connection = dataSource.getConnection();
			try{
				sql="DROP TABLE USER_AUTHENTICATION";
				jdbcTemplate.execute(sql);
			}catch(Exception e){
				
			}
			
			sql = "CREATE TABLE USER_AUTHENTICATION (USER_ID integer, USERNAME VARCHAR2(50), PASSWORD VARCHAR2(50), ENABLED char(1))";
			jdbcTemplate.execute(sql);

			jdbcTemplate.update("INSERT INTO USER_AUTHENTICATION VALUES(1,'alpha','pass1','1')");
			jdbcTemplate.update("INSERT INTO USER_AUTHENTICATION VALUES(2,'beta','pass1','0')");
			try{
				jdbcTemplate.execute("DROP TABLE USER_AUTHORIZATION");
			}catch(Exception e){

			}

			sql = "CREATE TABLE USER_AUTHORIZATION (USER_ROLE_ID INTEGER ,USER_ID INTEGER, ROLE VARCHAR2(50))";
			jdbcTemplate.execute(sql);
			jdbcTemplate.update("INSERT INTO USER_AUTHORIZATION VALUES(1,1,'ROLE_ADMIN')");
			jdbcTemplate.update("INSERT INTO USER_AUTHORIZATION VALUES(2,2,'ROLE_USER')");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}