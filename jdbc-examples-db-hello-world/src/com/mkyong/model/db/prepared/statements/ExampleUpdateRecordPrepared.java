package com.mkyong.model.db.prepared.statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mkyong.model.db.connect.Conexion;

public class ExampleUpdateRecordPrepared {

	public static void main(String[] argv) {

		try {

			updateRecordToTable();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	private static void updateRecordToTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String updateTableSQL = "UPDATE DBUSER1 SET USERNAME = ? "
				                  + " WHERE USER_ID = ?";

		try {
			dbConnection = Conexion.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, "mkyong_new_value");
			preparedStatement.setInt(2, 1);

			// execute update SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
}
