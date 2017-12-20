package com.test.footballapp.network;

import com.test.footballapp.models.League;
import com.test.footballapp.models.response.TableResponse;
import com.test.footballapp.models.response.TeamsResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface RestApi {

    @GET("v1/soccerseasons/")
    Observable<List<League>> getSeason();

    @GET("v1/competitions/{id}/teams")
    Observable<TeamsResponse> getTeams(@Path("id") String id);

    @GET("v1/competitions/{id}/leagueTable")
    Observable<TableResponse> getTable(@Path("id") String id);

}