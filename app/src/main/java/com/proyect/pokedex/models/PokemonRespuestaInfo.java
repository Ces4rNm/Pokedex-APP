package com.proyect.pokedex.models;

import java.util.ArrayList;

/**
 * Created by Daniel Alvarez on 28/7/16.
 * Copyright © 2016 Alvarez.tech. All rights reserved.
 */
public class PokemonRespuestaInfo {

    private ArrayList<Pokemon> forms;
    private ArrayList<Pokemon> stats;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Pokemon> getForms() {
        return forms;
    }

    public void setForms(ArrayList<Pokemon> forms) {
        this.forms = forms;
    }

    public ArrayList<Pokemon> getStats() {
        return stats;
    }

    public void setStats(ArrayList<Pokemon> stats) {
        this.stats = stats;
    }
}
