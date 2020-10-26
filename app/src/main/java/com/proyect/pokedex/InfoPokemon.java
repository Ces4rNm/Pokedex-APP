package com.proyect.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.proyect.pokedex.models.Pokemon;
import com.proyect.pokedex.models.PokemonRespuesta;
import com.proyect.pokedex.models.PokemonRespuestaInfo;
import com.proyect.pokedex.pokeapi.PokeapiService;
import com.proyect.pokedex.pokeapi.PokeapiServiceInfo;

import java.util.ArrayList;

public class InfoPokemon extends AppCompatActivity {

    int id_pokemon;
    private Retrofit retrofit;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pokemon);

        id_pokemon = Integer.parseInt(getIntent().getExtras().getString("id_pokemon"));
        Log.e("", "id_pokemon:" + id_pokemon);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtenerDatos(id_pokemon);
    }


    private void obtenerDatos(int id_pokemon) {
        PokeapiServiceInfo service2 = retrofit.create(PokeapiServiceInfo.class);
        Call<PokemonRespuestaInfo> pokemonRespuestaCall = service2.obtenerPokemon(id_pokemon);
        context = this;
        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuestaInfo>() {
            @Override
            public void onResponse(Call<PokemonRespuestaInfo> call, Response<PokemonRespuestaInfo> response) {
                if (response.isSuccessful()) {

                    PokemonRespuestaInfo pokemonRespuestaInfo = response.body();

                    TextView tVNombre = findViewById(R.id.tVNombre);
                    TextView tVCodigo = findViewById(R.id.tVCodigo);
                    ImageView fotoImageView2 = findViewById(R.id.fotoImageView2);
                    TextView textView3 = findViewById(R.id.textView3);
                    TextView textView4 = findViewById(R.id.textView4);
                    TextView textView5 = findViewById(R.id.textView5);
                    TextView textView6 = findViewById(R.id.textView6);
                    TextView textView7 = findViewById(R.id.textView7);
                    TextView textView8 = findViewById(R.id.textView8);

                    //ArrayList<Pokemon> listaPokemon = pokemonRespuestaInfo.getStats();
                    tVNombre.setText(pokemonRespuestaInfo.getForms().get(0).getName());
                    tVCodigo.setText(String.valueOf(pokemonRespuestaInfo.getId()));

                    Glide.with(context)
                            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + String.valueOf(pokemonRespuestaInfo.getId()) + ".png")
                            .centerCrop()
                            .crossFade()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(fotoImageView2);
                    textView3.setText("HP: "+pokemonRespuestaInfo.getStats().get(0).getBase_stat());
                    textView4.setText("ATTACK: "+pokemonRespuestaInfo.getStats().get(1).getBase_stat());
                    textView5.setText("DEFENSE: "+pokemonRespuestaInfo.getStats().get(2).getBase_stat());
                    textView6.setText("SP.ATK: "+pokemonRespuestaInfo.getStats().get(3).getBase_stat());
                    textView7.setText("SP.DEF: "+pokemonRespuestaInfo.getStats().get(4).getBase_stat());
                    textView8.setText("SPEED: "+pokemonRespuestaInfo.getStats().get(5).getBase_stat());

                } else {
                    Log.e("", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonRespuestaInfo> call, Throwable t) {
                Log.e("", " onFailure: " + t.getMessage());
            }
        });
    }
}