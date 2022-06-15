package com.example.jva_practice.util;

import com.example.jva_practice.data.Users;
import com.example.jva_practice.data.posts.Posts;
import com.example.jva_practice.db.UserTable;
import com.example.jva_practice.db.post.PostTable;

import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    public static UserTable toMainTable(Users users) {
        UserTable mainTable =
                new UserTable(
                        users.getId(),
                        users.getName(),
                        users.getUsername(),
                        users.getEmail(),
                        users.getPhone(),
                        users.getWebsite());
        return mainTable;
    }

    public static Users toUsers(UserTable users) {
        Users mainTable =
                new Users(
                        users.getPkId(),
                        users.getName(),
                        users.getUsername(),
                        users.getEmail(),
                        users.getPhone(),
                        users.getWebsite());
        return mainTable;
    }

    public static PostTable toPostTable(Posts users) {
        PostTable mainTable =
                new PostTable(
                        users.getUserId(),
                        users.getId(),
                        users.getTitle(),
                        users.getBody()
                );
        return mainTable;
    }

    public static Posts toPosts(PostTable users) {
        Posts mainTable =
                new Posts(
                        users.getUserId(),
                        users.getPkId(),
                        users.getTitle(),
                        users.getBody()
                );
        return mainTable;
    }
    public static List<PostTable> toPostsTableList(List<Posts> usersList) {
        List<PostTable> tableList = new ArrayList<>();
        for (Posts users : usersList) {
            tableList.add(toPostTable(users));
        }
        return tableList;
    }
    public static List<UserTable> toUserTableList(List<Users> usersList) {
        List<UserTable> tableList = new ArrayList<>();
        for (Users users : usersList) {
            tableList.add(toMainTable(users));
        }
        return tableList;
    }

    public static List<Users> toUsersList(List<UserTable> usersList) {
        List<Users> tableList = new ArrayList<>();
        for (UserTable users : usersList) {
            tableList.add(toUsers(users));
        }
        return tableList;
    }

    public static List<?> entityToList(List<?> usersList) {
        List<Object> tableList = new ArrayList<>();
        for (Object users : usersList) {
            if (users instanceof Users)
                tableList.add(toMainTable((Users) users));
            else if (users instanceof Posts){
                tableList.add(toPostTable((Posts) users));
            }
            else if (users instanceof PostTable){
                tableList.add((PostTable) users);
            }
            else if (users instanceof UserTable){
                tableList.add((UserTable) users);
            }

        }
        return tableList;
    }
}
