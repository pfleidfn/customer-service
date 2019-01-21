package smoke.example.customer.contract;

import com.example.customer.domain.CustomerResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.invoke.MethodHandles;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author Marcin Grzejszczak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmokeTests.class,
		webEnvironment = SpringBootTest.WebEnvironment.NONE)
@EnableAutoConfiguration
public class SmokeTests {

	private static final Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass());

	@Value("${stubrunner.url}") String stubRunnerUrl;
	@Value("${application.url}") String applicationUrl;

	TestRestTemplate testRestTemplate = new TestRestTemplate();

	@Test
	public void shouldWork() {
		ResponseEntity<CustomerResponse> entity = this.testRestTemplate
				.getForEntity("http://" + this.applicationUrl + "/customer/1", CustomerResponse.class);

		then(entity.getStatusCode().is2xxSuccessful()).isTrue();
		System.out.println("checking for name 'Florian Pfleiderer'");
		then(entity.getBody().getName()).isEqualTo("Florian Pfleiderer");
		System.out.println("checking for firstName 'Florian'");
		then(entity.getBody().getFirstName()).isEqualTo("Florian");
		System.out.println("checking for lastName 'Pfleiderer'");
		then(entity.getBody().getLastName()).isEqualTo("Pfleiderer");
	}

}
