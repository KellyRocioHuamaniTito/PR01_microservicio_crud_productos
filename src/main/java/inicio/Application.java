package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//como son paquetes independientes debemos indicarles los nombres
@SpringBootApplication (scanBasePackages = {"controller", "service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
