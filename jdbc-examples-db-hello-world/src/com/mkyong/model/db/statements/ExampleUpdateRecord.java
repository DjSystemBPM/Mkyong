package com.mkyong.model.db.statements;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.mkyong.model.db.connect.Conexion;

public class ExampleUpdateRecord {

	public static void main(String[] argv) {

		try {

			updateRecordIntoDbUserTable();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	private static void updateRecordIntoDbUserTable() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String updateTableSQL = "UPDATE DBUSER"
				+ " SET USERNAME = 'mkyong_modificado' "
				+ " WHERE USER_ID = 1";

		try {
			dbConnection = Conexion.getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(updateTableSQL);

			// execute update SQL stetement
			statement.execute(updateTableSQL);

			System.out.println("Record is updated to DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
}
