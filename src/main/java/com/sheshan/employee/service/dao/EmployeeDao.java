package com.sheshan.employee.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sheshan.employee.service.util.DbConnection;

public class EmployeeDao {

	public static ResultSet getVlaidLoginEmployee(String email) {
		ResultSet rs = null;
		String query = "Select * from employee where username=? AND system_status =1";
		try {
			Connection con = DbConnection.getDbconnection();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, email);
			rs = preparedStmt.executeQuery();
			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet getEmployeeLeaveQuota(int e_id) {
		ResultSet rs = null;
		String query = "Select elq.L_id , lt.type ,elq.value ,elq.remaining_value from employee_leave_quota elq"
				+ " inner join leave_types lt " + "on elq.L_id = lt.L_id" + " where elq.E_id = ?";
		try {
			Connection con = DbConnection.getDbconnection();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, e_id);
			rs = preparedStmt.executeQuery();
			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet getEmployeeListByGroupId(String groupId) {
		ResultSet rs = null;
		 
		StringBuilder query = new StringBuilder();
		query.append(" SELECT e.E_id as emp_id, username, `status` as emp_status, start_date, system_status, role,  `name` as group_name FROM employee e");
		query.append(" inner join employee_group eg on e.E_id=eg.E_id");
		query.append(" inner join `group` g on g.G_id=eg.G_id");
		query.append(" where g.name = ?");
		try {
			Connection con = DbConnection.getDbconnection();
			PreparedStatement preparedStmt = con.prepareStatement(query.toString() );
			preparedStmt.setString(1, groupId);
			rs = preparedStmt.executeQuery();
			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
