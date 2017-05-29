package com.mkyong.model.db.prepared.statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mkyong.model.db.connect.Conexion;

public class ExampleDeleteRecordPrepared {

	public static void main(String[] argv) {

		try {

			deleteRecordFromTable();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	private static void deleteRecordFromTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE DBUSER1 WHERE USER_ID = ?";

		try {
			dbConnection = Conexion.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, 1);

			// execute delete SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is deleted!");

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
