package dev.dead.mssc_brewery_client.web.config;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.util.Timeout;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

  public ClientHttpRequestFactory clientHttpRequestFactory() {
    CloseableHttpClient httpClient = HttpClients.custom()
        .evictExpiredConnections()
        .build();

    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
    factory.setConnectTimeout((int) Timeout.ofSeconds(3).toMilliseconds());
    factory.setConnectionRequestTimeout((int) Timeout.ofSeconds(3).toMilliseconds());
    factory.setReadTimeout((int) Timeout.ofSeconds(3).toMilliseconds());

    return factory;
  }

  @Override
  public void customize(RestTemplate restTemplate) {
    restTemplate.setRequestFactory(this.clientHttpRequestFactory());
  }
}
