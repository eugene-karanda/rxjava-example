package org.overmind.rxjavaexample.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 15.07.2017 18:25
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Github {

    @JsonProperty("login")
    private String nickname;

    @JsonProperty("blog")
    private String blog;

    @JsonProperty("public_repos")
    private int repositoriesCount;

    @JsonCreator
    public Github(
        @JsonProperty("login") String nickname,
        @JsonProperty("blog") String blog,
        @JsonProperty("publicRepos") int repositoriesCount
    ) {
        this.nickname = nickname;
        this.blog = blog;
        this.repositoriesCount = repositoriesCount;
    }
}