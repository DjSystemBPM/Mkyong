package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserRestService {

	@GET
	@Path("/get")
	public Response addUser(@HeaderParam("user-agent") String userAgent) {

		return Response.status(200)
				.entity("addUser is called, userAgent : " + userAgent)
				.build();

	}
	
	
	@GET
	@Path("/get2")
	public Response addUser2(@Context HttpHeaders headers) {

		String userAgent = headers.getRequestHeader("user-agent").get(0);

		String headerComplete = "";
		for(String header : headers.getRequestHeaders().keySet()){
			headerComplete = header;
		}
		return Response.status(200)
			.entity("addUser is called, userAgent : " + userAgent + " " + headerComplete)
			.build();

	}
}