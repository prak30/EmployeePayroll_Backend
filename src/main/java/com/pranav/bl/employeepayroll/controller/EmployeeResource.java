package com.pranav.bl.employeepayroll.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pranav.bl.employeepayroll.model.EmployeeModel;
import com.pranav.bl.employeepayroll.service.EmployeeService;

@Path("/employeepayroll")
public class EmployeeResource {
	
	EmployeeService service = new EmployeeService();
	
	@POST
	@Path("/insertion")
	@Consumes(MediaType.APPLICATION_JSON)
	public EmployeeModel addEmployee(EmployeeModel employee) {
		return service.insertEmployee(employee);
	}
	
	
	@GET
	@Path("/retrieve")
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<EmployeeModel> getAllEmployee() throws SQLException{
		return service.getAllEmployee();
	}
	
	@GET
	@Path("/retrievebyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<EmployeeModel> getEmployee(@PathParam("id") int id) throws SQLException {
		return service.getEmployeeById(id);
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public EmployeeModel updateEmployee(EmployeeModel employee) {
		return service.updateEmployee(employee);
	}
	
	@DELETE
	@Path("/deletebyid/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteEmployee(@PathParam("id") int id) {
		return service.deleteEmployee(id);
	}

}
