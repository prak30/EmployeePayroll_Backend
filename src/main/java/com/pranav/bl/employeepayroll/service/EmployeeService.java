package com.pranav.bl.employeepayroll.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.pranav.bl.employeepayroll.model.EmployeeModel;

public class EmployeeService {

	Connection con;

	public EmployeeService() {
		try {
			String url = String.format("jdbc:mysql://localhost:3306/users");
			String uname = "root";
			String pwd = "SGs1k@k@";

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, uname, pwd);
		} catch (Exception e) {
			System.out.println(e + "data insert unsuccessfull.");
		}

	}

	public ArrayList<EmployeeModel> getAllEmployee() throws SQLException {
		ArrayList<EmployeeModel> data = new ArrayList<EmployeeModel>();
		String select = "select * from employee_payroll";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			EmployeeModel model = new EmployeeModel();
			model.setName(rs.getString("name"));
			model.setGender(rs.getString("gender"));
			model.setSalary(rs.getInt("salary"));
			model.setDepartment(rs.getString("department"));
			model.setAddress(rs.getString("address"));

			data.add(model);
		}
		return data;
	}

	public EmployeeModel insertEmployee(EmployeeModel employee) {
		String insert = "insert into employee_payroll(name,gender,salary,department,address) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getGender());
			ps.setInt(3, employee.getSalary());
			ps.setString(4, employee.getDepartment());
			ps.setString(5, employee.getAddress());

			ps.execute();
		} catch (Exception e) {
			System.out.println(e + "insert unsuccessfull.");

		}
		return employee;

	}

	public ArrayList<EmployeeModel> getEmployeeById(int id) throws SQLException {

		ArrayList<EmployeeModel> data = new ArrayList<EmployeeModel>();
		String select = "select * from employee_payroll where id=?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			EmployeeModel model = new EmployeeModel();
			model.setName(rs.getString("name"));
			model.setGender(rs.getString("gender"));
			model.setSalary(rs.getInt("salary"));
			model.setDepartment(rs.getString("department"));
			model.setAddress(rs.getString("address"));

			data.add(model);
		}
		return data;
	}
	
	public EmployeeModel updateEmployee(EmployeeModel employee) {
		String update = "update employee_payroll set name = ?, gender = ?, salary = ?, department = ? , address = ? where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(update);

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getGender());
			ps.setInt(3, employee.getSalary());
			ps.setString(4, employee.getDepartment());
			ps.setString(5, employee.getAddress());

			ps.setInt(6, employee.getId());

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e + "update unsuccessfull.");

		}
		return employee;

	}
	
	public int deleteEmployee(int id) {
		String delete = "delete from employee where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(delete);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e + "delete unsuccessfull.");

		}
		return id;

	}


}
