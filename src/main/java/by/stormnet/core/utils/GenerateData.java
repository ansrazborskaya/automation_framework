package by.stormnet.core.utils;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class GenerateData {
    private String emailAdress;
    private String randomValue;
    private String postcode;
    private String phone;

    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"),new RandomService());

    public String generateRandomEmail(){
        return emailAdress = fakeValuesService.bothify("??????##@gmail.com");
    }

    public String generateRandomValue(){
        return randomValue = fakeValuesService.bothify("??????????????????????");
    }

    public String generateRandomPostcode(){
        return postcode = fakeValuesService.bothify("#####");
    }

    public String generateRandomPhone(){
        return phone = fakeValuesService.bothify("#########");
    }

}
