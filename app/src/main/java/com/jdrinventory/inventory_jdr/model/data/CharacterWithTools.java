package com.jdrinventory.inventory_jdr.model.data;

import androidx.lifecycle.LiveData;
import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CharacterWithTools {
    @Embedded
    public Character character;

    @Relation(
            parentColumn = "character_id",
            entityColumn = "characterCreatorId"
    )
    public List<Tool> tools;

    public CharacterWithTools(Character character, List<Tool> tools) {
        this.character = character;
        this.tools = tools;
    }

    public Character getCharacter() {
        return this.character;
    }

    public List<Tool> getTools() {
        return this.tools;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }
}
