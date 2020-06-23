package project.by.stormnet.functional.tests;

import by.stormnet.core.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.by.stormnet.api.entities.UserService;

public class UserTest {
    private UserService userService = new UserService();
    private String bodyPost = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";
    private String bodyPut = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"zion resident\"\n" +
            "}";

    @Test
    public void postUserTest(){
        Response response = userService.postUser(bodyPost);
        int code = response.getCode();
        Assert.assertTrue(code == 201,"User not added");

    }

    @Test
    public void putUserTest(){
        Response response = userService.putUser(bodyPut);
        int code = response.getCode();
        boolean containsText = response.getBody().contains("morpheus");
        Assert.assertTrue(code == 200 && containsText,"User not put");

    }

    @Test
    public void deleteUserTest(){
        Response response = userService.deleteUser();
        int code = response.getCode();
        Assert.assertTrue(code == 204,"User not deleted");

    }


}
