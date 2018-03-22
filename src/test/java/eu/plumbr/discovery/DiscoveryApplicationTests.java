package eu.plumbr.discovery;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscoveryApplicationTests {

  @ClassRule
  public static GenericContainer zookeeper = new GenericContainer("zookeeper:3.4.9").withExposedPorts(2181);

  @BeforeClass
  public static void setup() {
    System.setProperty("spring.cloud.zookeeper.connect-string", zookeeper.getContainerIpAddress() + ":" + zookeeper.getMappedPort(2181));
  }

  @Test
  public void contextLoads() {
  }

}
