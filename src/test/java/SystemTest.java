import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

class SystemTest {

	@Test
	void shoudIdentifyObjectHashCode() {
		Object dummy = new Object();
		assertEquals(dummy.hashCode(), System.identityHashCode(dummy));
	}

	@Test
	void shouldReturnEnvVariable() {
		assertEquals("vitorlegalvh@gmail.com", System.getenv("GMAIL_USERNAME"));
	}

	@Test
	void shouldReturnEnvVariables() {
		Map<String, String> env = System.getenv();
		assertEquals(env, System.getenv());
	}
}
