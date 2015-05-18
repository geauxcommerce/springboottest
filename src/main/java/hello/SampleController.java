package hello;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {
	
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
      TomcatEmbeddedServletContainerFactory tomcat = new      TomcatEmbeddedServletContainerFactory() {
          
    	  /* @Override
          protected void postProcessContext(Context context) {
            SecurityConstraint securityConstraint = new SecurityConstraint();
            securityConstraint.setUserConstraint("CONFIDENTIAL");
            SecurityCollection collection = new SecurityCollection();
            collection.addPattern("/*");
            securityConstraint.addCollection(collection);
            context.addConstraint(securityConstraint);
          } */
        };

      tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
      return tomcat;
    }

    private Connector initiateHttpConnector() {
      Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
      connector.setScheme("http");
      connector.setPort(8080);
      connector.setSecure(false);
      // connector.setRedirectPort(8443);

      return connector;
    }    
}