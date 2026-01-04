package com.example.hello.Tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("helloTasklet2")
@StepScope
@Slf4j
public class HelloTasklet2 implements Tasklet {

    @Value("#{JobExecutionContext['jobKey1']}")
    private String jobValue1;

    @Override
    @Nullable
    public RepeatStatus execute(
            StepContribution contribution,
            ChunkContext chunkContext) throws Exception {

        log.info("HelloTasklet2!!!");
        log.info("jobValue1 = {}", jobValue1);

        return RepeatStatus.FINISHED;

    }

}
