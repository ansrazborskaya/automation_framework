package project.by.stormnet.api.entities;

import by.stormnet.core.FrameworkHttpClient;
import by.stormnet.core.Response;

public class UserService extends AbstractService {
    private FrameworkHttpClient client = new FrameworkHttpClient();
    private String userUrl = baseUrl1+ "/api/users";
    private String putUrl = baseUrl1+ "/api/users/2";
    private String deleteUrl = baseUrl1+ "/api/users/2";


    public Response postUser(String body){
        System.out.println("Post new user");
        return client.doPost(userUrl,body);
    }

    public Response putUser(String body){
        System.out.println("Put user");
        return client.doPut(putUrl,body);
    }
    public Response deleteUser(){
        System.out.println("Delete user");
        return client.doDelete(deleteUrl);
    }
}
