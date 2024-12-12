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
}
