package com.proyect.pokedex.pokeapi;

import com.proyect.pokedex.models.PokemonRespuestaInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Daniel Alvarez on 28/7/16.
 * Copyright © 2016 Alvarez.tech. All rights reserved.
 */
public interface PokeapiServiceInfo {

    @GET("pokemon/{id}")
    Call<PokemonRespuestaInfo> obtenerPokemon(@Path("id") int id_pokemon);

}
