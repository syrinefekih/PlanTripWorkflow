package com.example.ReclamTestFlowProject.Tasks;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

@Component
public class ActivityAPI implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        ConsoleHandler handler = new ConsoleHandler();
        logger.info("Activity api fetching...");
    }
}