package com.sheshan.employee.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.sheshan.employee.service.dto.EmployeeDto;
import com.sheshan.employee.service.logic.EmployeeLogic;



@Path("/employee")
public class EmployeeService {
	
	
	
	@GET
	@Path("/validate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg(@QueryParam("token") String tokenId) {

		EmployeeLogic employeeLogincHandelr = new EmployeeLogic();
		EmployeeDto employeeDto = employeeLogincHandelr.validateEmployeeLogin(tokenId);
		Gson g = new Gson();
		String response = g.toJson(employeeDto);
		return Response.status(200).entity(response).build();
	}
	
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response validateEmployeeLogin(@QueryParam("token") String tokenId) {

		EmployeeLogic employeeLogincHandelr = new EmployeeLogic();
		EmployeeDto employeeDto = employeeLogincHandelr.validateEmployeeLogin(tokenId);
		Gson g = new Gson();
		String response = g.toJson(employeeDto);
		return Response.status(200).entity(response).build();
	}

	@GET
	@Path("/bygroupid")
	@Produces(MediaType.APPLICATION_JSON)
	public Response employeesByGroupId(@QueryParam("groupid") String groupid) {

		EmployeeLogic employeeLogincHandelr = new EmployeeLogic();
		ArrayList<EmployeeDto> employeeDtoList = employeeLogincHandelr.getEmployeeListByGroupId(groupid);
		
		Gson g = new Gson();
		String response = g.toJson(employeeDtoList);
		return Response.status(200).entity(response).build();
	}
	
}
