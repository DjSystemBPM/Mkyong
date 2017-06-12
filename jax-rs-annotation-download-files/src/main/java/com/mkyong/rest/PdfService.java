package com.mkyong.rest;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/pdf")
public class PdfService {

	private static final String FILE_PATH = "/home/acuevas/Documentos/Libros/Identity Management in Liferay - Overview and Best Practices.pdf";

	@GET
	@Path("/get")
	@Produces("application/pdf")
	public Response getFile() {

		File file = new File(FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=descarga_libro.pdf");
		return response.build();

	}
}