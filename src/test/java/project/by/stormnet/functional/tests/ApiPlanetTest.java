package project.by.stormnet.functional.tests;

import by.stormnet.core.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.by.stormnet.api.entities.StarWarsService;

public class ApiPlanetTest {
    private StarWarsService starWarsService = new StarWarsService();

    @Test
    public void getAllPlanetsTest() {
        Response response = starWarsService.getAllPlanets();
        int code = response.getCode();
        boolean containsPlanets = response.getBody().contains("Tatooine");
        Assert.assertTrue(code == 200 && containsPlanets, "Planets are not available");
    }
}
