package ${ projectDescription.groupId }.config.resttemplate;

import java.time.Duration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * The type Rest template configuration.
 *
 * @author ${ authorService.getAuthor() }
 */
@Configuration
public class RestTemplateConfiguration {

  // ===============================================================================================
  // BEANS
  // ===============================================================================================

  /**
   * Rest template.
   *
   * @param builder the builder
   * @return the rest template
   */
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder
        .setConnectTimeout(Duration.ofMillis(5000))
        .setReadTimeout(Duration.ofMillis(5000))
        .build();
  }
}
