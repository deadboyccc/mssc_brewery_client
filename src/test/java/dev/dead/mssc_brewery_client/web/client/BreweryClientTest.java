package dev.dead.mssc_brewery_client.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.dead.mssc_brewery_client.web.model.BeerDto;

@SpringBootTest
public class BreweryClientTest {
  @Autowired
  BreweryClient client;

  @Test
  void testGetBeerById() {
    BeerDto dto = client.getBeerById(UUID.randomUUID());
    assertNotNull(dto);
  }
}
