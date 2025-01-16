package camuda_svc.demo;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService {

    private final ZeebeClient zeebeClient;

    public WorkflowService(ZeebeClient zeebeClient) {
        this.zeebeClient = zeebeClient;
    }

    @ZeebeWorker(type = "my-worker-type")
    public void handleJob(ActivatedJob job) {
        // Your business logic for processing the task
        System.out.println("Processing job with key: " + job.getKey());

        // Complete the job
        job.complete();
    }

    public void deployProcess() {
        ZeebeClient client = ZeebeClient.newClientBuilder()
                .brokerContactPoint("localhost:26500")
                .usePlaintext()
                .build();

        client.newDeployCommand()
                .addResourceFile("path_to_your_bpmn_file.bpmn")
                .send()
                .join();
    }

    public void startProcessInstance(ZeebeClient client){
        client.newCreateInstanceCommand()
                .bpmnProcessId("your-process-id")
                .latestVersion()
                .variables("{\"key\": \"value\"}")
                .send()
                .join();

    }

}
