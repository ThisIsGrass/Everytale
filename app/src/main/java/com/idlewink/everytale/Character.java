package com.idlewink.everytale;

import java.util.UUID;

public class Character {

    private UUID mId;
    private String mName;
    private String mDetails;
    private int mThumbnail;

    public Character(String name, int thumbnail) {
        mId = UUID.randomUUID();
        mName = name;
        mThumbnail = thumbnail;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDetails() {
        return mDetails;
    }

    public void setDetails(String details) {
        mDetails = details;
    }

    public int getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.mThumbnail = thumbnail;
    }
}
