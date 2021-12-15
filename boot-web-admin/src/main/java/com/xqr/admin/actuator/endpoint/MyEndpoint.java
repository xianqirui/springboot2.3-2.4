package com.xqr.admin.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Endpoint(id = "myservice")
@Component
public class MyEndpoint {
    @ReadOperation
    public Map getDockerInfo(){
        return Collections.singletonMap("doclerinfo","docker start...");

    }
    @WriteOperation
    public void stopDocker(){
        System.out.println("docker stop....");
    }
}
