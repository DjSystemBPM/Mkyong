package com.mkyong.model.db.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mkyong.model.db.connect.Conexion;

public class ExampleTransaction {

	public static void main(String[] argv) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatementInsert = null;
		PreparedStatement preparedStatementUpdate = null;

		String insertTableSQL = "INSERT INTO DBUSER1"
				+ "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES"
				+ "(?,?,?,?)";

		String updateTableSQL = "UPDATE DBUSER1 SET USERNAME =? "
				+ "WHERE USER_ID = ?";

		try {
			dbConnection = Conexion.getDBConnection();

			dbConnection.setAutoCommit(false);

			preparedStatementInsert = dbConnection.prepareStatement(insertTableSQL);
			preparedStatementInsert.setInt(1, 999);
			preparedStatementInsert.setString(2, "mkyong101");
			preparedStatementInsert.setString(3, "system");
			preparedStatementInsert.setTimestamp(4, getCurrentTimeStamp());
			preparedStatementInsert.executeUpdate();

			preparedStatementUpdate = dbConnection.prepareStatement(updateTableSQL);
			// preparedStatementUpdate.setString(1,
			// "A very very long string caused db error");
			preparedStatementUpdate.setString(1, "new string");
			preparedStatementUpdate.setInt(2, 999);
			preparedStatementUpdate.executeUpdate();

			dbConnection.commit();

			System.out.println("Done!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			dbConnection.rollback();

		} finally {

			if (preparedStatementInsert != null) {
				preparedStatementInsert.close();
			}

			if (preparedStatementUpdate != null) {
				preparedStatementUpdate.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
	
	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
}
