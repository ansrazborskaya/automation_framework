package by.stormnet.core;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Response {
    HttpResponse httpResponse;

    public Response(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public int getCode() {
        return httpResponse.getStatusLine().getStatusCode();
    }

    public String getBody() {
        HttpEntity entity = httpResponse.getEntity();
        String body = "";

        try {
            body = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }
}
