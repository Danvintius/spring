package ru.netology.springbootdemo;

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
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + myapp.getMappedPort(8080), String.class);
        System.out.println(forEntity.getBody());
        myapp.getMappedPort(8081);
        myapp2.getMappedPort(8082);
    }

}
