package io.smartnexus.ats.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.naming.ServiceUnavailableException;

import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;

public class PublicClient {

    private final static String AUTHORITY = "https://login.microsoftonline.com/common";
    private final static String CLIENT_ID = "374d7231-a9e1-4587-ab4e-4e20876678b6";
    private final static String RESOURCE = "374d7231-a9e1-4587-ab4e-4e20876678b6";

    public String token() throws Exception {
    	String username ="python@smartnexus.io";
    	String password="qyr^H$bUYB!jkpegQps&6qY$rcC!f&VhbTNnY$by!4B4$3z8RPU6hkUwg5e4rNQp";


          //  AuthenticationResult result = getAccessTokenFromUserCredentials(username, password);
           // System.out.println("Access Token - " + result.getAccessToken());
           // System.out.println("Refresh Token - " + result.getRefreshToken());
           // System.out.println("ID Token - " + result.getIdToken());
			return "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6InBpVmxsb1FEU01LeGgxbTJ5Z3FHU1ZkZ0ZwQSIsImtpZCI6InBpVmxsb1FEU01LeGgxbTJ5Z3FHU1ZkZ0ZwQSJ9.eyJhdWQiOiJkYzk1MDlmZi1kNDM1LTQ0OTUtOGZhOC02YmFhNzc1OTgyZjUiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC83ZDEyY2IzNy02YjIzLTQ0N2UtOGJmZi0xNTFlMWU5OGNlNjAvIiwiaWF0IjoxNTc5Nzc0OTEyLCJuYmYiOjE1Nzk3NzQ5MTIsImV4cCI6MTU3OTc3ODgxMiwiYWlvIjoiQVdRQW0vOE9BQUFBMUxVK1FaOGd1SllSVVMyQWVHaG9CNFVRTlc2VS9QL3BNKzNtM2RMQXBhR0xVUDA5T3kxa3FMSm90anc2bDBoYml5QmRuTzFXQkJKQ1pxS2NZUzF6U1FkellsNUNyME51TmNsenE2MUkzY2ptZ056SElWN0E2K3h2ME80OTZIZnUiLCJhbXIiOlsicHdkIiwibWZhIl0sImVtYWlsIjoiRGV2ZW5kcmEuSmhhQGZsZXguY29tIiwiZmFtaWx5X25hbWUiOiJKaGEiLCJnaXZlbl9uYW1lIjoiRGV2ZW5kcmEiLCJpZHAiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC8zZjBlNjllMC1lYjM4LTRlYjItYjRlZS01MjkxOTcxOWQzMWUvIiwiaXBhZGRyIjoiMTE5LjE1MS43Mi44MCIsIm5hbWUiOiJEZXZlbmRyYSBKaGEiLCJub25jZSI6IjgwN2VlOGRkLTNlMDItNGNiZi1hZGZkLTdiOWZiZmM4MWEyNyIsIm9pZCI6ImUwZDJiZWEzLTk4NzgtNGQ2ZS04NDIwLWIxY2FlMmMyNThjNyIsInJvbGVzIjpbIlVzZXIiXSwic3ViIjoiSmpJM1BDVmQ3Mm5KbXhVMjdrOVNycGYxQk40QVY3UVl0aUhhenhNd0FJZyIsInRpZCI6IjdkMTJjYjM3LTZiMjMtNDQ3ZS04YmZmLTE1MWUxZTk4Y2U2MCIsInVuaXF1ZV9uYW1lIjoiRGV2ZW5kcmEuSmhhQGZsZXguY29tIiwidXRpIjoidXpNN1Y4ek1xMHkxNHYzUTBkQUVBQSIsInZlciI6IjEuMCJ9.iYNWNvNX8NmcEnEFD6WZj_98I36JqUd9cgYEabQSjdsoCxHml6cF9Vr2XI-MKQLgYma35DwuJi5Zru6USFzV71-rHME3mf6Sw_vqvwOQNu8J1DLx5RwvsE1MWG7FWylqdJ4bPvR_XdiISkseHjIv42CoKyp21o1idY6RfLv-oMCqNnR9mwiy8cLMEoTnBjBtsQZJUxaCnDKLIG2JlSP9cp-d83sBUMw6q18lhAWenxQCIFyuDiSxqpNR9iPdyxMQNIe5K3qlHTH5hNZ2kZNl59ugm7nDK3nSrasgaTu3OwG4DtQ_DwFozUXZVVPstvcxUZz4qv0cbvv0rSnRDEjyuw";
			//  result.getAccessToken();
    }

}
