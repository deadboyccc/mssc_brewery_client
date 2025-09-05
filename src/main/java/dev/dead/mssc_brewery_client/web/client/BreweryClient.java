package dev.dead.mssc_brewery_client.web.client;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dev.dead.mssc_brewery_client.web.model.BeerDto;

@Component
@ConfigurationProperties(value = "dead.brewery", ignoreUnknownFields = false)
public class BreweryClient {
  // TODO CONFIGURE THE EXTRA SLASH
  public final String BEER_PATH_V1 = "/api/v1/beer";
  private final RestTemplate restTemplate;

  public BreweryClient(RestTemplateBuilder restTemplatebBuilder) {
    this.restTemplate = restTemplatebBuilder.build();
  }

  private String apiHost;

  public void setApiHost(String apiHost) {
    this.apiHost = apiHost;
  }

  public BeerDto getBeerById(UUID beerId) {
    return restTemplate.getForObject(apiHost + BEER_PATH_V1 + "/" + beerId.toString(), BeerDto.class);
  }

}
