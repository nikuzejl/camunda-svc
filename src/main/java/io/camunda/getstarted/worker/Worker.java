package io.camunda.getstarted.worker;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Worker {

    private static final Logger LOGGER = LoggerFactory.getLogger(Worker.class);

    @Autowired
    private ZeebeClient zeebeClient;

    @JobWorker(type = "camunda-worker", streamEnabled = false)
    public void doWork(final ActivatedJob job) throws InterruptedException {
        final String input = (String) job.getVariablesAsMap().get("param1");
        LOGGER.info("Doing something with param1={}", input);

        Thread.sleep(10000);

        zeebeClient
                .newCompleteCommand(job.getKey())
                .variables(Map.of("result", "done"))
                .send()
                .join();

        LOGGER.info("Job completed for key={}", job.getKey());
    }
}
