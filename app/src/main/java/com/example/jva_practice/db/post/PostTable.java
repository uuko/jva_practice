package com.example.jva_practice.db.post;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "posts")
public class PostTable implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int userId;
    private int pkId;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String title;
    private String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPkId() {
        return pkId;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PostTable(int userId, int pkId, String title, String body) {
        this.userId = userId;
        this.pkId = pkId;
        this.title = title;
        this.body = body;
    }
}
