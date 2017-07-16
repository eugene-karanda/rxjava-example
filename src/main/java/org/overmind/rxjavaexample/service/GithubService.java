package org.overmind.rxjavaexample.service;

import io.reactivex.Observable;
import org.overmind.rxjavaexample.model.Github;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 15.07.2017 18:21
 */
public interface GithubService {

    String SERVICE_ENDPOINT = "https://api.github.com";

    @GET("/users/{nickname}")
    Observable<Github> find(
        @Path("nickname") String nickname
    );

}
