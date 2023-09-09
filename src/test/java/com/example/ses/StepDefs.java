package com.example.ses;

import com.example.ses.SpringIntegrationTests;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.tomcat.util.buf.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatusCode;

import java.net.CookieManager;

import static org.hamcrest.MatcherAssert.assertThat;
public class StepDefs extends SpringIntegrationTests {
    private final String baseUrl = "http://localhost:9090";
    private HttpStatusCode lastStatusCode;
    private ResponseEntity<String> lastResponse;

    private String lastResponseReq;

    private String lastRequest;
    private HttpURLConnection con;
    private List<HttpCookie> cookies = null;
    private final CookieManager cookieManager = new CookieManager();


    @When("the client calls {string}")
    public void theClientCalls(String endpoint) {
        sendRequest(endpoint, "POST", lastRequest);
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(Integer statusCodes) {
        boolean inList = false;

            inList = statusCodes.equals(lastStatusCode.value()) ? true : inList;

        Assertions.assertTrue(inList);
    }

    @When("the client after auth {string} {string}")
    public void callAfterAuth(String type, String endpoint) {
        sendRequest(endpoint, type, type.equals("GET") ? null : lastRequest);
    }

    private void sendRequest(String endpoint, String type, String jsonBody) {
        try {
            URL url = new URL(baseUrl + endpoint);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(type);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            if (cookies != null) {
                con.setRequestProperty("Cookie",
                        StringUtils.join(cookieManager.getCookieStore().getCookies().stream().map(object -> Objects.toString(object, null))
                                .toList(), ';'));
            }
            con.setDoOutput(true);
            if (jsonBody != null && !jsonBody.isBlank()) {
                OutputStream outputStream = con.getOutputStream();
                byte[] input = jsonBody.getBytes("utf-8");
                outputStream.write(input, 0, input.length);
                outputStream.close();
                con.getOutputStream();
            }
            lastStatusCode = HttpStatusCode.valueOf(con.getResponseCode());
            System.out.println(lastStatusCode);
            if (!lastStatusCode.isError()) {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = bufferedReader.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                bufferedReader.close();
                con.getInputStream().close();
                lastResponseReq = response.toString();
                System.out.println(lastResponse);

                String cookiesHeader = con.getHeaderField("Set-Cookie");
                if (cookiesHeader != null) {
                    cookies = HttpCookie.parse(cookiesHeader);
                    cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, cookie));
                }
                con.disconnect();

            }

        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (HttpClientErrorException.Unauthorized exception) {
            lastStatusCode = HttpStatusCode.valueOf(401);
            System.out.println(lastStatusCode);
        }
    }


    @When("the client calls {string} with the request body:")
    public void whenClientCallsWithRequestBody(String endpoint, String requestBody) {
        this.lastRequest = requestBody;
        sendRequest(endpoint, "POST", requestBody);
    }
    // Define a parameter type to convert the request body from the feature file.


    // Implement the remaining step definitions for your scenario here.
    // You can use the 'statusCode' and 'responseBody' variables to perform assertions and validations.
}
