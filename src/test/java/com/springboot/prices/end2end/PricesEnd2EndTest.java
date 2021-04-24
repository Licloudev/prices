package com.springboot.prices.end2end;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.response.Response;
import com.springboot.prices.dto.PriceDTO;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class PricesEnd2EndTest {

    @Test
    public void test1() {
        // Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        // ID 1
        Response response = given().when().get("/price?brandId=1&date=2020-06-14-10.00.00&productId=35455").andReturn();

        List<PriceDTO> pricesList = getPricesList(response);

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertNotEquals(0, pricesList.size());
    }

    @Test
    public void test2() {
        // Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        // ID 1 y 2
        Response response = given().when().get("/price?brandId=1&date=2020-06-14-16.00.00&productId=35455").andReturn();

        List<PriceDTO> pricesList = getPricesList(response);

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertNotEquals(0, pricesList.size());
    }

    @Test
    public void test3() {
        // Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        // ID 1
        Response response = given().when().get("/price?brandId=1&date=2020-06-14-21.00.00&productId=35455").andReturn();

        List<PriceDTO> pricesList = getPricesList(response);

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertNotEquals(0, pricesList.size());
    }

    @Test
    public void test4() {
        // Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
        // ID 1 y 3
        Response response = given().when().get("/price?brandId=1&date=2020-06-15-10.00.00&productId=35455").andReturn();

        List<PriceDTO> pricesList = getPricesList(response);

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertNotEquals(0, pricesList.size());
    }

    @Test
    public void test5() {
        // Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
        // ID 1 y 4
        Response response = given().when().get("/price?brandId=1&date=2020-06-16-21.00.00&productId=35455").andReturn();

        List<PriceDTO> pricesList = getPricesList(response);

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertNotEquals(0, pricesList.size());
    }

    private List<PriceDTO> getPricesList(Response response) {
        Gson gson = new Gson();
        Type userListType = new TypeToken<List<PriceDTO>>() {
        }.getType();
        return gson.fromJson(response.asString(), userListType);
    }
}
