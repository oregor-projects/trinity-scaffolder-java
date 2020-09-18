package com.somg.actuator;

import io.micrometer.core.instrument.util.IOUtils;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The type Open api system endpoint.
 *
 * @author Christos Tsakostas
 */
@ControllerEndpoint(id = "openapi-system")
@Component
public class OpenApiSystemEndpoint {

  // ===============================================================================================
  // STATIC
  // ===============================================================================================

  /**
   * The constant OPENAPI_YAML.
   */
  public static final String OPENAPI_YAML = "/openapi/openapi-system.yaml";

  // ===============================================================================================
  // CONSRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Open api system endpoint.
   */
  public OpenApiSystemEndpoint() {
    super();
  }

  // ===============================================================================================
  // ENDPOINTS
  // ===============================================================================================

  /**
   * Get open api specification for system calls.
   *
   * @return Spec as string
   * @throws IOException when opening openapi-system.yml file
   */
  @GetMapping(value = "/")
  @ResponseBody
  public String openapi() throws IOException {
    final URL resource = this.getClass().getResource(OPENAPI_YAML);
    if (resource == null) {
      return StringUtils.EMPTY;
    }
    return IOUtils.toString(resource.openStream());
  }
}
