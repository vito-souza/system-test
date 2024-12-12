import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

	@SuppressWarnings("removal")
	@Test
	void securityManagerShouldBeNull() {
		assertEquals(null, System.getSecurityManager());
	}

	@Test
	void shoudIdentifyObjectHashCode() {
		Object dummy = new Object();
		assertEquals(dummy.hashCode(), System.identityHashCode(dummy));
	}
}
