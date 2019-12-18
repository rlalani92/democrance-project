package com.democrance.controller;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PolicyControllerTest {

    @LocalServerPort
    private int port;

    private static OkHttpClient client  = new OkHttpClient();;

    @Test
    public void getPolicyTest() throws IOException {

        Request request = new Request.Builder()
                .url("http://localhost:"+port+"/api/v1/policies/1")
                .build();

        Response response = client.newCall(request).execute();
        assert response.code() == 200;

    }

    @Test
    public void getInvalidPolicyTest() throws IOException {

        Request request = new Request.Builder()
                .url("http://localhost:"+port+"/api/v1/policies/2")
                .build();

        Response response = client.newCall(request).execute();
        assert response.code() == 400;

    }

    @Test
    public void getFindAllPoliciesTest() throws IOException {

        Request request = new Request.Builder()
                .url("http://localhost:"+port+"/api/v1/policies")
                .build();

        Response response = client.newCall(request).execute();
        assert response.code() == 200;

    }
}
