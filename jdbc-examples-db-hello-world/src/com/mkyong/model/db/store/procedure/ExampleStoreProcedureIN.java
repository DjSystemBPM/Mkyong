package com.mkyong.model.db.store.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.mkyong.model.db.connect.Conexion;

public class ExampleStoreProcedureIN {

	public static void main(String[] argv) {

		try {

			callOracleStoredProcINParameter();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	private static void callOracleStoredProcINParameter() throws SQLException {

		Connection dbConnection = null;
		CallableStatement callableStatement = null;

		String insertStoreProc = "{call insertDBUSER(?,?,?,?)}";

		try {
			dbConnection = Conexion.getDBConnection();
			callableStatement = dbConnection.prepareCall(insertStoreProc);

			callableStatement.setInt(1, 1001);
			callableStatement.setString(2, "alfredo");
			callableStatement.setString(3, "system");
			callableStatement.setDate(4, getCurrentDate());

			// execute insertDBUSER store procedure
			callableStatement.executeUpdate();

			System.out.println("Record is inserted into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (callableStatement != null) {
				callableStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
	
	
	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

}
