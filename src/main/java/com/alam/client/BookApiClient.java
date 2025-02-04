package com.alam.client;

import com.alam.dto.BookDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import java.util.List;

@RegisterRestClient(baseUri = "https://potterapi-fedeperin.vercel.app/en")
public interface BookApiClient {

	@GET
	@Path("/books")
	List<BookDTO> getBooks();

}
