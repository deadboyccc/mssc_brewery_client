package dev.dead.mssc_brewery_client.web.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.dead.mssc_brewery_client.web.model.BeerDto;
import dev.dead.mssc_brewery_client.web.model.CustomerDto;

@SpringBootTest
public class BreweryClientTest {
  @Autowired
  BreweryClient client;

  @Test
  void testGetBeerById() {
    BeerDto dto = client.getBeerById(UUID.randomUUID());
    assertNotNull(dto);
  }

  @Test
  void testCreateNewBeer() {
    // given
    BeerDto dto = BeerDto.builder().beerName("New Beer").build();
    URI uri = client.createNewBeer(dto);
    System.out.println(uri.toString());
    assertNotNull(uri);

  }

  @Test
  void testUpdateBeer() {
    // given
    BeerDto dto = BeerDto.builder().beerName("New Beer").build();
    client.updateBeer(UUID.randomUUID(), dto);

  }

  @Test
  void testDeleteBeer() {
    client.deleteBeer(UUID.randomUUID());

  }
  // Customer

  @Test
  void testGetCustomerById() {
    CustomerDto dto = client.getCustomerById(UUID.randomUUID());
    assertNotNull(dto);
  }

  @Test
  void testCreateNewCustomer() {
    // given
    CustomerDto dto = CustomerDto.builder().customerName("New Customer").build();
    URI uri = client.createNewCustomer(dto);
    System.out.println(uri.toString());
    assertNotNull(uri);

  }

  @Test
  void testUpdateCustomer() {
    // given
    CustomerDto dto = CustomerDto.builder().customerName("New Customer").build();
    client.updateCustomer(UUID.randomUUID(), dto);

  }

  @Test
  void testDeleteCustomer() {
    client.deleteCustomer(UUID.randomUUID());

  }

}
