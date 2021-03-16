package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JdbcConnectionTest {
	
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Class.forName("oeacle.jdbc.driver.OracleDriver");
		/* urlµÄÐ´·¨£º
		 * mysql:  jdbc:mysql://hostname:port/databasename+param
		 * oracle: jdbc:oracle:thin:@hostname:port:databasename
		 */
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/world?serverTimezone=UTC", "root", "wangzhao@2021");
		
		Statement statement=connection.createStatement();
		
		ResultSet resultSet=statement.executeQuery("select * from city where 1=1 and ID < '10'");
		ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
		int colNum = resultSetMetaData.getColumnCount();
		String header="|";
		for(int i=1;i<=colNum;i++) {
			if(i!=colNum) {
				header=header+resultSetMetaData.getColumnName(i)+"\t"+"|";
			}else {
				header=header+resultSetMetaData.getColumnName(i)+"\t"+"|"+"\n";
			}
			
		}
		System.out.printf(header);
		
		String record="|";
		while(resultSet.next()) {
			for(int i=1;i<=colNum;i++) {
				if(i!=colNum) {
					record=record+resultSet.getString(i)+"\t"+"|";
				}else {
					record=record+resultSet.getString(i)+"\t"+"|"+"\n";
				}
			}
			System.out.printf(record);
			record="|";
		}
		
		resultSet.close();
		statement.close();
		connection.close();
	}
}
