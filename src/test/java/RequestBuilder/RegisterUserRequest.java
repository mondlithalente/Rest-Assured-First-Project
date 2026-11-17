package RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import static Common.TestData.generateFirstName;
import static Common.TestData.generateLastName;
import static Common.TestData.generateEmail;
import static Common.TestData.generatePassword;
import static Common.TestData.groupID;
import static Common.BasePaths.BaseURL;
import static Common.BasePaths.REGISTER_PATH;
import static PayloadBuilder.RegisterUserPayload.registerUserPayload;

public class RegisterUserRequest {

    public static String registeredUserId;
    public static Response registerUser()
    {
        String firstName = generateFirstName();
        String lastName = generateLastName();
        String email=  generateEmail();
        String password = generatePassword();
        String confirmPassword = password;


        Response response = RestAssured.given()
                .baseUri(BaseURL)
                .basePath(REGISTER_PATH)
                .header("Content-Type","application/json")
                .body(registerUserPayload(firstName,lastName,email,password,confirmPassword,groupID))
                .post()
                .then()
                .log().all()
                .extract().response();


        //Okay here im just saving the id that comes from the response after registering
        registeredUserId = response.jsonPath().getString("data.id");
        return  response;
    }

    //To make an assert test on the Tests file I need to make the id visible and accessible for other classes
    public static String getRegisteredUserId(){
        return registeredUserId;
    }

}
