https://www.baeldung.com/java-ee-7-batch-processing

Let's first define each piece:
*Starting on the left, we have the JobOperator. It manages all aspects of job processing such as starting, stopping, and restarting
*Next, we have the Job. A job is a logical collection of steps; it encapsulates an entire batch process
*A job will contain between 1 and n Steps. Each step is an independent, sequential unit of work. A step is composed of reading input, processing that input, and writing output
*And last, but not least, we have the JobRepository which stores the running information of the jobs. It helps to keep track of jobs, their state, and their completion results

https://github.com/eugenp/tutorials/tree/master/jee-7/src/main/java/com/baeldung/batch/understanding



http://javaee-samples.github.io/sample/batch-chunk-checkpoint/
The checkpoint-policy can be defined as item or custom. The item policy means the chunk is checkpointed after a specified number of items are processed. The custom policy means the chunk is checkpointed according to a checkpoint algorithm implementation. To use the custom policy you also need to define a checkpoint-algorithm element.

<?xml version="1.0" encoding="UTF-8"?>
<job id="myJob" xmlns="http://xmlns.jcp.org/xml/ns/javaee" version="1.0">
    <step id="myStep" >
        <chunk checkpoint-policy="custom">
            <reader ref="myItemReader"/>
            <processor ref="myItemProcessor"/>
            <writer ref="myItemWriter"/>
            <checkpoint-algorithm ref="myCheckpointAlgorithm"/>
        </chunk>
    </step>
</job>	