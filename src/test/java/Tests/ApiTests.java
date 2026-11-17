package Tests;

import RequestBuilder.RegisterUserRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTests {

    @Test
    public void testRegisterUserApi(){

        Response response = RegisterUserRequest.registerUser();

        Assert.assertEquals(response.getStatusCode(), 201, "Status code must be 201, for a successfully registered user.");

        Assert.assertNotNull(RegisterUserRequest.getRegisteredUserId(),"The user Id must not be null");
        System.out.println("This is the taken user id " + RegisterUserRequest.getRegisteredUserId());
    }
}
