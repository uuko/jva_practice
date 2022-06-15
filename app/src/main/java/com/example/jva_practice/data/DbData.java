package com.example.jva_practice.data;

import android.util.Log;

import androidx.sqlite.db.SimpleSQLiteQuery;

import com.example.jva_practice.App;
import com.example.jva_practice.data.posts.PostApiData;
import com.example.jva_practice.data.posts.PostDbData;
import com.example.jva_practice.db.MainDBDataBase;
import com.example.jva_practice.db.UserTable;
import com.example.jva_practice.db.post.PostTable;

import java.util.Arrays;
import java.util.Map;

public class DbData {
    static MainDBDataBase db = App.getMainDatabase();

    public static DataSource<?> of(Class<?> classZ) {
        if (classZ.isAssignableFrom(UserTable.class)) {
            return new UserDbData(db.userDbDao());
        }
        else if (classZ.isAssignableFrom(PostTable.class)){
            return new PostDbData(db.postDao());
        }
        else
            throw new IllegalArgumentException("Unsupported data type");
    }

    public static void clearDb() {
        db.clearAllTables();
    }

    public static SimpleSQLiteQuery sqlWhere(String table, Map<String, String> params) {
        StringBuilder query = new StringBuilder("SELECT * FROM " + table);
        for (int i = 0; i < params.size(); i++) {
            if (i == 0) query.append(" WHERE");
            else query.append(" AND");
            query.append(" "+
                    params.keySet().toArray()[i]).append(" = ?");
        }

        Object[] args = params.values().toArray();
        return new SimpleSQLiteQuery(query.toString(), args);
    }
}
