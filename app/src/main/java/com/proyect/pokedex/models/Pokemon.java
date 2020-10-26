package com.proyect.pokedex.models;

import java.lang.reflect.Array;

/**
 * Created by Daniel Alvarez on 28/7/16.
 * Copyright © 2016 Alvarez.tech. All rights reserved.
 */
public class Pokemon {

    private int number;
    private String name;
    private String url;
    private String stat_hp, stat_attack, stat_defense, stat_special_attack, stat_special_defense, stat_speed;
    private String stats;
    private String base_stat;

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(String base_stat) {
        this.base_stat = base_stat;
    }

    public String getStat_hp() {
        return stat_hp;
    }

    public void setStat_hp(String stat_hp) {
        this.stat_hp = stat_hp;
    }

    public String getStat_attack() {
        return stat_attack;
    }

    public void setStat_attack(String stat_attack) {
        this.stat_attack = stat_attack;
    }

    public String getStat_defense() {
        return stat_defense;
    }

    public void setStat_defense(String stat_defense) {
        this.stat_defense = stat_defense;
    }

    public String getStat_special_attack() {
        return stat_special_attack;
    }

    public void setStat_special_attack(String stat_special_attack) {
        this.stat_special_attack = stat_special_attack;
    }

    public String getStat_special_defense() {
        return stat_special_defense;
    }

    public void setStat_special_defense(String stat_special_defense) {
        this.stat_special_defense = stat_special_defense;
    }

    public String getStat_speed() {
        return stat_speed;
    }

    public void setStat_speed(String stat_speed) {
        this.stat_speed = stat_speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        String[] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length - 1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
