package HighLevelApis.ExecutorServiceInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
	public int saveUser(User user) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		int updatedNumberOfRows = 0;
	
		try {
			preparedStatement = connection.prepareStatement("insert into user values(?,?,?)");
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setInt(3, user.getAge());
			updatedNumberOfRows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updatedNumberOfRows;
	}

}
