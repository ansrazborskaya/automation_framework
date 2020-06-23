package project.by.stormnet.api.entities;

import by.stormnet.core.FrameworkHttpClient;
import by.stormnet.core.Response;

public class StarWarsService extends AbstractService {
    private FrameworkHttpClient client = new FrameworkHttpClient();
    private String planetUrl = baseUrl + "/planets/";

    public Response getAllPlanets(){
        System.out.println("Get all planets from Star Wars universe...");
        return client.doGet(planetUrl);
    }

}
