package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.nio.file.Files;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import java.io.IOException;

@Path("/api")
public class CountryResource {

    // TODO: Connect API to restcountries (URL in properties)
    @ConfigProperty(name = "restcountries.json.path")
    String countriesJsonPath;

    @GET
    @Path("/data")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {
        try {
            String jsonData = readJsonFile(countriesJsonPath);
            return Response.ok(jsonData).build();
        } catch (IOException e) {
            return Response.serverError().build();
        }
    }

    private String readJsonFile(String filePath) throws IOException {
        return Files.readString(java.nio.file.Path.of(filePath));
    }
}
