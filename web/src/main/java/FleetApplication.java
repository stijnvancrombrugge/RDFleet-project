import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by SDOAX36 on 27/10/2015.
 */
@SpringBootApplication
public class FleetApplication {


    public static void main(String[]args)
    {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(FleetApplication.class).profiles("production").run();
    }
}
