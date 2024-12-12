import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Map;
import java.util.Properties;

import org.junit.jupiter.api.Test;

class SystemTest {

	@Test
	void shouldCopySubArrayCorrectly() {
		char[] array = { 'u', 't', 'o', 'p', 'i', 'a' };
		char[] copy = new char[3];
		char[] top = { 't', 'o', 'p' };

		System.arraycopy(array, 1, copy, 0, 3);

		assertArrayEquals(copy, top);
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

	@Test
	void shouldReturnSystemProperties() {
		Properties properties = System.getProperties();
		assertEquals(properties, System.getProperties());
	}

	@Test
	void shouldReturnSystemPropertyByKey() {
		assertEquals("/home/vitor", System.getProperty("user.home"));
	}

	@SuppressWarnings("removal")
	@Test
	void securityManagerShouldBeNull() {
		assertEquals(null, System.getSecurityManager());
	}

	@Test
	void shoudNotIdentifyObjectHashCode() {
		Object dummy = new Object();
		Object ymmud = new Object();
		assertNotEquals(ymmud.hashCode(), System.identityHashCode(dummy));
	}
}
