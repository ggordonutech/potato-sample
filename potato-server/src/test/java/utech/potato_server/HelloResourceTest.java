package utech.potato_server;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import static org.junit.Assert.assertEquals;

public class HelloResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
    	String name="paul";
        String responseMsg = target.path("hello")
        		                   .queryParam("name", name)
        		                   .request()
        		                   .get(String.class);
        System.out.println("Received Response: "+responseMsg);
        
        Gson gson = new Gson();
        Result res = gson.fromJson(responseMsg, Result.class);
        assertEquals("Hello "+name, res.getName());
    }
    
    public class Result {
		private String name;
		private boolean succes=true;
		private int num;
		
		public Result(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Result [name=" + name + ", success=" + succes+ "]";
		}
		
		
	}
}