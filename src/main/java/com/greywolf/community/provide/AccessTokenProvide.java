package com.greywolf.community.provide;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greywolf.community.dbo.AccessTokenDTO;
import com.greywolf.community.dbo.GitHubUser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class AccessTokenProvide {
    private GitHubUser gitHubUser;
    private String AccessToken;
    @Autowired
    ObjectMapper objectMapper;
    public String getAccessToken(AccessTokenDTO accessTokenDTO) throws JsonProcessingException {
        MediaType JSON
                = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(objectMapper.writeValueAsString(accessTokenDTO),JSON);
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                AccessToken= response.body().string().split("&")[0].split("=")[1];
                System.out.println(AccessToken);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return AccessToken;
    }
    public GitHubUser getGitHubUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try (Response ignored = client.newCall(request).execute()) {
            gitHubUser = objectMapper.readValue(ignored.body().string(), GitHubUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
            return gitHubUser;
    }

}

