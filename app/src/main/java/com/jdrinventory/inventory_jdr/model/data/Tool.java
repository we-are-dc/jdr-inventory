package com.jdrinventory.inventory_jdr.model.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tool{
    @PrimaryKey(autoGenerate = true)
    public long toolId;

    public long characterCreatorId;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "clutter")
    public int clutter;

    public Tool(long toolId, long characterCreatorId, String name, String description, int clutter) {
        this.toolId = toolId;
        this.characterCreatorId = characterCreatorId;
        this.name = name;
        this.description = description;
        this.clutter = clutter;
    }

    public long getToolId() {
        return this.toolId;
    }

    public long getCharacterCreatorId() {
        return this.characterCreatorId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getClutter() {
        return this.clutter;
    }

    public void setToolId(long toolId) {
        this.toolId = toolId;
    }

    public void setCharacterCreatorId(long characterCreatorId) {
        this.characterCreatorId = characterCreatorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClutter(int clutter) {
        this.clutter = clutter;
    }
}
