package hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {
	
    @RequestMapping("/")
    @ResponseBody
    @CrossOrigin
    String home() {
		System.out.println("Inside the home method");
        // return "{ \"title\": \"Hello World!\"}";
		return "{"
			+ "\"data\": ["
		    +	"{\"id\": 21, \"name\": \"Michael\"},"
		    +	"{\"id\": 22, \"name\": \"Izzy\"},"
		    +	"{\"id\": 23, \"name\": \"Nathan\"},"
		    +	"{\"id\": 24, \"name\": \"Kian\"},"
		    +	"{\"id\": 25, \"name\": \"Tea\"},"
		    +	"{\"id\": 26, \"name\": \"Sam\"},"
		    +	"{\"id\": 27, \"name\": \"Tyler\"},"
		    +	"{\"id\": 28, \"name\": \"Mark\"},"
		    +	"{\"id\": 29, \"name\": \"Jack\"},"
		    +	"{\"id\": 30, \"name\": \"Nicholas\"}"
			+ "]"
		+ "}";
    }
    
    @RequestMapping("/loaderio-c0534af88b9d608b60ec5cb382de7c80/")
    @ResponseBody
    @CrossOrigin
    String verify() {
    	return "loaderio-c0534af88b9d608b60ec5cb382de7c80";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
            
}