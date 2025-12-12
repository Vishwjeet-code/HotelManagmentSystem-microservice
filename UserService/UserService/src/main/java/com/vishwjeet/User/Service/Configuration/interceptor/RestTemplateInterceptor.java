package com.vishwjeet.User.Service.Configuration.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

import java.io.IOException;

public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    Logger logger = LoggerFactory.getLogger(RestTemplateInterceptor.class);

    public OAuth2AuthorizedClientManager manager;

    public RestTemplateInterceptor(OAuth2AuthorizedClientManager manager) {
        this.manager = manager;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        OAuth2AuthorizeRequest authRequest = OAuth2AuthorizeRequest
                .withClientRegistrationId("my-internal-client")
                .principal("internal")
                .build();
        OAuth2AuthorizedClient client = manager.authorize(authRequest);

        if (client == null || client.getAccessToken() == null) {
            logger.error("Failed to obtain access token from Okta");
            throw new IllegalStateException("Could not authorize client");
        }

        String Token = client.getAccessToken().getTokenValue();
        logger.info("RestTemplate interceptor: token generated successfully");

        logger.info("Rest Templet interceptor: token : {} ",Token);

                request.getHeaders().add("Authorization","Bearer "+Token);

        return execution.execute(request,body);
    }
}
