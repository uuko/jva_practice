package com.example.jva_practice.data;

import com.example.jva_practice.data.posts.PostApiData;
import com.example.jva_practice.db.UserTable;
import com.example.jva_practice.db.post.PostTable;

public class ApiData {

    public static DataSource<?> of(Class<?> classZ)  {
        if (classZ.isAssignableFrom(UserTable.class)){
            return new UserApiData();
        }
        else if (classZ.isAssignableFrom(PostTable.class)){
            return new PostApiData();
        }
        else
            throw new IllegalArgumentException("Unsupported data type");
    }

}
