package hello;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleController.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class SampleControllerTest {
	
	@Value("${local.server.port}")
	int port;
	
	@Before
	public void setUp() {
		
		RestAssured.port = port;
		
	}
	
	@Test
	public void canFetchHomePage() {
		when().
				get("/").
		then().
				statusCode(HttpStatus.SC_OK).
				assertThat().body(containsString("Hello World"));
		
	}

}