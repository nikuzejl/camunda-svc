package io.camunda.getstarted;

import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Deployment(resources = "classpath*:processes/*.bpmn")
public class ProcessApplication {
  public static void main(String[] args) {
    SpringApplication.run(ProcessApplication.class, args);
  }
}
