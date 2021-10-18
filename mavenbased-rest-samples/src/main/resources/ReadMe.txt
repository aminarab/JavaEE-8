JAX-RS :
https://stackoverflow.com/questions/31289470/http-500-internal-server-error-in-simple-rest-based-program-confused-in-get-and

JBatch : 
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


JSON-B : 
https://mvnrepository.com/artifact/javax/javaee-api/8.0
https://stackoverflow.com/questions/51049278/json-b-in-weblogic-12-1-3-as-new-feature-of-jdk-8
https://stackoverflow.com/questions/54087178/circular-reference-issue-with-json-b

Jackson : 
https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
https://stackoverflow.com/questions/16881382/jsonignore-and-jsonbackreference-are-being-ignored
use import com.fasterxml.jackson.annotation.JsonBackReference; instead of import org.codehaus.jackson.annotate.JsonBackReference;.
@JsonIgnoreProperties https://stackoverflow.com/questions/41407921/eliminate-circular-json-in-java-spring-many-to-many-relationship
