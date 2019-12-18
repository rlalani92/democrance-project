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
public class CustomerControllerTest {

    @LocalServerPort
    private int port;

    private static OkHttpClient client  = new OkHttpClient();;

    @Test
    public void getCustomerTest() throws IOException {

        Request request = new Request.Builder()
                .url("http://localhost:"+port+"/api/v1/customers/1")
                .build();

        Response response = client.newCall(request).execute();
        assert response.code() == 200;

    }

    @Test
    public void getInvalidCustomerTest() throws IOException {

        Request request = new Request.Builder()
                .url("http://localhost:"+port+"/api/v1/customers/2")
                .build();

        Response response = client.newCall(request).execute();
        assert response.code() == 400;

    }

    @Test
    public void getFindAllCustomerTest() throws IOException {

        Request request = new Request.Builder()
                .url("http://localhost:"+port+"/api/v1/customers")
                .build();

        Response response = client.newCall(request).execute();
        assert response.code() == 200;

    }


}
