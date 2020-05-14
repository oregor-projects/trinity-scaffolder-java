package ${ projectDescription.groupId };

import static org.assertj.core.api.Assertions.assertThat;

import java.util.TimeZone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ${ authorService.getAuthor() }
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"ci"})
public class ApplicationTest {

  @Test
  public void contextLoads() {
    assertThat(TimeZone.getDefault()).isEqualTo(TimeZone.getTimeZone("UTC"));
  }
}
