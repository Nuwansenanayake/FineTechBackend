package com.sheshan.employee.service;

import java.sql.Connection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sheshan.employee.service.util.DbConnection;


@Path("/healthCheck")
public class HelloWorldService {

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg(@PathParam("param") String msg) {
		String output=null;
		Connection con  = DbConnection.getDbconnection();
		if(con!=null){
			output= "Db Conection : Ok";
		}else{
			output= "Db Conection : FAILED";
		}
		return Response.status(200).entity(output).build();
		

	}
}
