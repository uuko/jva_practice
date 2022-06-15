package com.example.jva_practice.ui.post;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.jva_practice.data.Repository;
import com.example.jva_practice.data.Status;
import com.example.jva_practice.data.Users;
import com.example.jva_practice.data.navigation.NavigationDestination;
import com.example.jva_practice.db.UserTable;
import com.example.jva_practice.db.post.PostTable;
import com.example.jva_practice.util.DBUtils;
import com.example.jva_practice.util.Util;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {
    private PostRepository repository;

    public PostViewModel(PostRepository repository) {
        this.repository = repository;

    }

    private final MutableLiveData<Boolean> _mLoading
            = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> mLoading
            = _mLoading;
    public MutableLiveData<String> userIdLiveData
            = new MutableLiveData<>();
    public LiveData<Status<List<PostTable>>> statusLiveData
            = Transformations.switchMap(
            userIdLiveData, new Function<String, LiveData<Status<List<PostTable>>>>() {
                @Override
                public LiveData<Status<List<PostTable>>> apply(String input) {
                    Log.e("setDataList", "getUsers: 1111111");
                    return repository.getPostsByUserId(input);
                }
            }
    );

    private MutableLiveData<NavigationDestination> _destination = new MutableLiveData<NavigationDestination>(null);
    LiveData<NavigationDestination> destination = _destination;

    public void setDestinationToNull() {
        _destination.setValue(null);
    }


    public void start() {
        _destination.setValue(NavigationDestination.NAVIGATION_DESTINATION_ADD_POSTING);
    }
    public void getPostUserId() {
//        Log.e("onNext", "postTest: userId===> "+userId);
        userIdLiveData.setValue(userIdLiveData.getValue());
    }

    public void setQueryData(String userId) {
        userIdLiveData.setValue(userId);
        ;
    }
}
