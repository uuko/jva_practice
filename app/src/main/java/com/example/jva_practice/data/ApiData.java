package com.example.jva_practice.data;

import com.example.jva_practice.db.UserTable;

public class ApiData {

    public static DataSource<?> of(Class<?> classZ)  {
        if (classZ.isAssignableFrom(UserTable.class)){
            return new UserApiData();
        }
        else
            throw new IllegalArgumentException("Unsupported data type");
    }

}
