package Common;

import com.github.javafaker.Faker;

public class TestData {

    private static final Faker faker = new Faker();

    public static String generateFirstName(){
        return faker.name().firstName();
    }

    public static String generateLastName(){
        return faker.name().lastName();
    }
    public static String generateEmail(){
        return faker.internet().emailAddress();
    }

    public static String generatePassword(){
//        String password;
//        String specialChar="!@#$%^&*()";
        return  faker.internet().password(8, 16, true, true);
    }

    public static String groupID = "99c545ce-aed3-4977-9d4b-0eb6adfec45e";


}
