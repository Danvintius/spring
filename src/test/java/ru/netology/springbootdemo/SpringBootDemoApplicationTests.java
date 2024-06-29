package ru.netology.springbootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootDemoApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    private final GenericContainer<?> myapp = new GenericContainer<>().withExposedPorts(8081);
    private final GenericContainer<?> myapp2 = new GenericContainer<>().withExposedPorts(8082);

    @BeforeEach
    void setUp() {
        myapp.start();
        myapp2.start();
    }
    @Test
    void contextLoads() {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" +
                myapp.getMappedPort(8081) + "/profile", String.class);
        Assertions.assertEquals("Current profile is production\n", entity.getBody());
        System.out.println(entity.getBody());
    }

    @Test
    void contextLoads2() {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" +
                myapp2.getMappedPort(8082) + "/profile", String.class);
        Assertions.assertEquals("Current profile is dev\n", entity.getBody());
        System.out.println(entity.getBody());

    }
}
