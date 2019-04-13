package ${ projectDescription.groupId };

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Application.
 *
 * @author ${ authorService.getAuthor() }
 */
@SpringBootApplication
public class Application {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
