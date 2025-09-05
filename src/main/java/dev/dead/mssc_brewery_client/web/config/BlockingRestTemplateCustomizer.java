// package dev.dead.mssc_brewery_client.web.config;

// import org.apache.hc.client5.http.impl.classic.HttpClients;
// import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;

// import org.springframework.boot.web.client.RestTemplateCustomizer;
// import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
// import org.springframework.stereotype.Component;
// import org.springframework.web.client.RestTemplate;

// // @Component
// public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

//   private HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
//     CloseableHttpClient httpClient = HttpClients.custom()
//         .evictExpiredConnections()
//         .build();

//     HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

//     return factory;
//   }

//   @Override
//   public void customize(RestTemplate restTemplate) {
//     restTemplate.setRequestFactory(clientHttpRequestFactory());
//   }
// }
