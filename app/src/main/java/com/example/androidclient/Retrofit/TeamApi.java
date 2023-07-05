package com.example.androidclient.Retrofit;

import com.example.androidclient.Model.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TeamApi {

    @GET("/api/v1/teams")
    Call<List<Team>> getAllTeams();

    @POST("/api/v1/teams")
    Call<Team> save(@Body Team team);
}
