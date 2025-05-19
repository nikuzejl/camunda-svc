package io.camunda.getstarted.service;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ZeebeClientService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZeebeClientService.class);
    private final ZeebeClient zeebeClient;

    public ZeebeClientService(ZeebeClient zeebeClient){
        this.zeebeClient = zeebeClient;
        //startProcessInstance("worker", Map.of("variable1", "value1"));
    }

    private void startProcessInstance(String processId, Map<String, Object> variables){
        ProcessInstanceEvent event =
                zeebeClient
                        .newCreateInstanceCommand()
                        .bpmnProcessId(processId)
                        .latestVersion()
                        .variables(variables)
                        .send()
                        .join();

        LOGGER.info("Started instance for processDefinitionKey='{}', bpmnProcessId='{}', version='{}' with processInstanceKey='{}'",
                event.getProcessDefinitionKey(), event.getBpmnProcessId(), event.getVersion(), event.getProcessInstanceKey());
    }
}
