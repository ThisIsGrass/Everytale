package com.idlewink.everytale;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CharaSingleton {
    private static CharaSingleton sCharaSingleton;

    private List<Character> mCharacters;

    public static CharaSingleton get(Context context) {
        if (sCharaSingleton == null) {
            sCharaSingleton = new CharaSingleton(context);
        }
        return sCharaSingleton;
    }

    private CharaSingleton(Context context){
        mCharacters = new ArrayList<>();
        mCharacters.add(new Character("Asgore", R.drawable.asgore));
        mCharacters.add(new Character("Asriel", R.drawable.asriel));
        mCharacters.add(new Character("Alphys", R.drawable.alphys));
        mCharacters.add(new Character("sans", R.drawable.sans));
        mCharacters.add(new Character("Mettaton", R.drawable.mettaton));
        mCharacters.add(new Character("Napstablook", R.drawable.napstablook));
        mCharacters.add(new Character("Undyne", R.drawable.undyne));
        mCharacters.add(new Character("Toriel", R.drawable.tori));
        mCharacters.add(new Character("Papyrus", R.drawable.papyrus));
        mCharacters.add(new Character("Muffet", R.drawable.muffetbit));
        mCharacters.add(new Character("Flowey", R.drawable.flowey));
    }


    public List<Character> getCharacters(){
        return mCharacters;
    }

    public Character getCharacter(UUID id) {
        for (Character character : mCharacters) {
            if (character.getId().equals(id)){
                return character;
            }
        }
        return null;
    }

}
