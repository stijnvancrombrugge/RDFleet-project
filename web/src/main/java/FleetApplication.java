import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by SDOAX36 on 27/10/2015.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.realdolmen.fleet")
public class FleetApplication{


    public static void main(String[]args)
    {
         new SpringApplicationBuilder(FleetApplication.class).profiles("production").run();
        //SpringApplication.run(FleetApplication.class,args);
    }
}
