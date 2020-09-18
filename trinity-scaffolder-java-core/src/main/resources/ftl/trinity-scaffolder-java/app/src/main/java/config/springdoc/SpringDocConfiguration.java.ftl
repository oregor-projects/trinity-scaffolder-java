package ${ projectDescription.groupId }.config.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Spring doc configuration.
 *
 * @author ${ authorService.getAuthor() }
 */
@Configuration
public class SpringDocConfiguration {

  // ===============================================================================================
  // STATIC
  // ===============================================================================================

  private static final String BEARER_AUTH = "bearerAuth";

  // ===============================================================================================
  // BEANS
  // ===============================================================================================

  /**
   * Open api.
   *
   * @return the open api
   */
  @Bean
  public OpenAPI openApi() {
    return new OpenAPI()
        .components(
            new Components()
                .addSecuritySchemes(
                    BEARER_AUTH,
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")))
        .addSecurityItem(new SecurityRequirement().addList(BEARER_AUTH))
        .info(
            new Info()
                .title("${ projectDescription.name } API")
                .version("v1")
                .description("This is the ${ projectDescription.name } server.")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
  }

  /**
   * Admin open api grouped open api.
   *
   * @return the grouped open api
   */
  @Bean
  public GroupedOpenApi adminOpenApi() {
    String[] pathsToMatch = {
      "/api/auth/logins/**", "/api/auth/admin/**", "/api/market/admin/**", "/api/team/admin/**"
    };

    String[] pathsToExclude = {"/api/market/admin/transfers/**", "/api/team/system/**"};

    OpenApiCustomiser openApiCustomiser =
        openApi ->
            openApi.info(
                new Info()
                    .title("${ projectDescription.name } Admin API")
                    .version("v1")
                    .description("This is the ${ projectDescription.name } API for Administrators."));

    return GroupedOpenApi.builder()
        .group("openapi-admin")
        .pathsToMatch(pathsToMatch)
        .pathsToExclude(pathsToExclude)
        .addOpenApiCustomiser(openApiCustomiser)
        .build();
  }

  /**
   * User open api grouped open api.
   *
   * @return the grouped open api
   */
  @Bean
  public GroupedOpenApi userOpenApi() {
    String[] pathsToMatch = {"/api/auth/**", "/api/market/**", "/api/team/**"};

    String[] pathsToExclude = {
      "/api/auth/admin/**", "/api/market/admin/**", "/api/team/admin/**", "/api/team/system/**"
    };

    OpenApiCustomiser openApiCustomiser =
        openApi ->
            openApi.info(
                new Info()
                    .title("${ projectDescription.name } User API")
                    .version("v1")
                    .description("This is the ${ projectDescription.name } API for Users."));

    return GroupedOpenApi.builder()
        .group("openapi-user")
        .pathsToMatch(pathsToMatch)
        .pathsToExclude(pathsToExclude)
        .addOpenApiCustomiser(openApiCustomiser)
        .build();
  }
}
