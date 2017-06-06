package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/users")
public class UserRestService {

	//@QueryParam example
	//@DefaultValue example
	//localhost:8084/RESTfulExample/rest/users/query?from=110&to=215&orderBy=age&orderBy=name
	@GET
	@Path("/query")
	public Response getUsers(
			@DefaultValue("1000") @QueryParam("from") int from,
			@DefaultValue("999") @QueryParam("to") int to,
			@DefaultValue("name") @QueryParam("orderBy") List<String> orderBy) {

		return Response
				.status(200)
				.entity("Estas llamando el metodo getUsers(), from : " + from + ", to : " + to
						+ ", orderBy" + orderBy.toString()).build();

	}
	
	//Programmatic Query Parameter
	//localhost:8084/RESTfulExample/rest/users/query?from=110&to=215&orderBy=age&orderBy=name
	@GET
	@Path("/query2")
	public Response getUsers2(@Context UriInfo info) {

		String from = info.getQueryParameters().getFirst("from");
		String to = info.getQueryParameters().getFirst("to");
		List<String> orderBy = info.getQueryParameters().get("orderBy");

		return Response
		   .status(200)
		   .entity("Estas llamando el metodo getUsers2(), con Programatic Query from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();

	}

}