package com.example.ReclamTestFlowProject;

import jakarta.annotation.PostConstruct;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.variable.ClientValues;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ReclamTestFlowProjectApplication {
	public static void main(String... args) {
		SpringApplication.run(ReclamTestFlowProjectApplication.class, args);

	}
	/*
	@PostConstruct
	public void startProcess() {
		runtimeService.startProcessInstanceByKey("reclamCredit");
	}
*/
}