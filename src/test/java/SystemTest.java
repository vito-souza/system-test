import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SystemTest {

	Properties properties;

	@BeforeEach
	void init() {
		properties = System.getProperties();
	}

	@AfterEach
	void tearDown() {
		System.setProperties(properties);
	}

	@Test
	void shouldCopySubArrayCorrectly() {
		char[] pikachu = { 'p', 'i', 'k', 'a', 'c', 'h', 'u' };
		char[] copy = new char[3];
		char[] chu = { 'c', 'h', 'u' };

		System.arraycopy(pikachu, 4, copy, 0, 3);
		assertArrayEquals(copy, chu);
	}

	@Test
	void shouldClearSystemProperty() {
		System.setProperty("dummy.property", "hello!");
		assertEquals("hello!", System.clearProperty("dummy.property"));
	}

	@Test
	void currentTimeMilisShouldNotBeEqual() throws InterruptedException {
		long millis = System.currentTimeMillis();
		Thread.sleep(1);
		assertNotEquals(millis, System.currentTimeMillis());
	}

	@Test
	void shouldReturnSystemEnvVariable() {
		assertEquals("vitorlegalvh@gmail.com", System.getenv("GMAIL_USERNAME"));
	}

	@Test
	void shouldReturnSystemEnvVariables() {
		Map<String, String> env = new HashMap<String, String>();
		env.putAll(System.getenv());

		assertEquals(env, System.getenv());
	}

	@Test
	void shouldReturnSystemProperties() {
		Properties properties = new Properties();
		properties.putAll(System.getProperties());

		assertEquals(properties, System.getProperties());
	}

	@Test
	void shouldReturnSystemPropertyByKey() {
		assertEquals("/home/vitor", System.getProperty("user.home"));
	}

	@Test
	void systemPropertyByKeyAndDefShouldNotEqualDefault() {
		assertNotEquals("dummy", System.getProperty("user.home", "dummy"));
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

	@Test
	void shoudNotIdentifyObjectHashCode() {
		Object dummy = new Object();
		Object ymmud = new Object();
		assertNotEquals(ymmud.hashCode(), System.identityHashCode(dummy));
	}

	@Test
	void shoulReturnUnixLineSeparator() {
		assertEquals("\n", System.lineSeparator());
	}

	@Test
	void shouldNotReturnWindosLineSeparator() {
		assertNotEquals("\r\n", System.lineSeparator());
	}

	@Test
	void nanoTimeShouldNotBeEqual() {
		long millis = System.nanoTime();
		assertNotEquals(millis, System.nanoTime());
	}

	@Test
	void shouldSetProperty() {
		System.setProperty("user.foo", "deu");
		assertNotNull(System.getProperty("user.foo"));
	}

	@Test
	void shouldSetProperties() {
		Properties properties = new Properties();
		properties.putAll(System.getProperties());

		Properties newProperties = new Properties();
		newProperties.setProperty("user.pokemon", "pikachu");

		System.setProperties(newProperties);
		assertNotEquals(properties, System.getProperties());
	}
}
