package com.jdrinventory.inventory_jdr.model.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Character {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "character_id")
    public long characterId;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "pods_max")
    public int podsMax;

    @ColumnInfo(name = "pods_current")
    public int podsCurrent;

    public Character(String firstName, String lastName, int podsMax) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.podsMax = podsMax;
        this.podsCurrent = 0;
    }

    public long getCharacterId() {
        return this.characterId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullname() {
        return this.firstName + " " + this.lastName;
    }

    public int getPodsMax() {
        return this.podsMax;
    }

    public int getPodsCurrent() {
        return this.podsCurrent;
    }

    public void setCharacterId(long characterId) {
        this.characterId = characterId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPodsMax(int podsMax) {
        this.podsMax = podsMax;
    }

    public void setPodsCurrent(int podsCurrent) {
        this.podsCurrent = podsCurrent;
    }
}