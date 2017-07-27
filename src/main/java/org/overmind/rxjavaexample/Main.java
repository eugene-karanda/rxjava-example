package org.overmind.rxjavaexample;

import io.reactivex.Observable;
import org.overmind.rxjavaexample.model.Github;
import org.overmind.rxjavaexample.service.GithubService;
import org.overmind.rxjavaexample.service.RestServiceFactory;
import retrofit2.Response;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 15.07.2017 18:32
 */
public class Main {

    public static void main(String[] args) throws IOException {
        final GithubService githubService = RestServiceFactory.create(
            GithubService.class,
            GithubService.SERVICE_ENDPOINT
        );

        final Observable<String> messageObservable = Observable.generate(
            () -> new Scanner(System.in),
            ((scanner, emitter) -> {
                emitter.onNext(scanner.nextLine());
            })
        );

        messageObservable
            .takeWhile(message -> !".exit".equals(message))
            .flatMap(githubService::find)
            .subscribe(Main::printResult);
    }

    private static void printResult(Response<Github> githubResponse) {
        if(githubResponse.isSuccessful()) {
            System.out.println(githubResponse.body());
        } else {
            System.out.println(githubResponse.message());
        }
    }

}