package com.example.jva_practice;

import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.os.Bundle;

import com.example.jva_practice.base.BaseActivity;
import com.example.jva_practice.databinding.ActivityMainBinding;
import com.example.jva_practice.ui.home.MainRepository;
import com.example.jva_practice.ui.home.MainViewModel;
import com.example.jva_practice.ui.home.MainViewModelFactory;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActViewModel, MainActViewModelFactory> {

    @Override
    public Integer getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Class<MainActViewModel> getViewModel() {
        return MainActViewModel.class;
    }

    @Override
    public MainActViewModelFactory getViewModelFactory() {
        return new MainActViewModelFactory(new MainActRepository());
    }
    AppBarConfiguration appBarConfiguration;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding.setViewModel(mViewModel);
        setSupportActionBar(mViewBinding.toolbar);
        DrawerLayout drawerLayout=mViewBinding.drawerLayout;
        NavigationView navigationView=
                mViewBinding.navView;
        NavController navController=Navigation.findNavController(this, R.id.my_nav_host_fragment);
        AppBarConfiguration appBarConfiguration=
                new AppBarConfiguration.Builder(
                    navController.getGraph()
                ).setDrawerLayout(drawerLayout).build();
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


    }




    //    private void handleAction(@NonNull final Action action) {
//        switch (action.getValue()){
//            case Action.SHOW_WELCOME:
//                //show Activity.
//                break;
//            case Action.SHOW_INVALID_PASSWARD_OR_LOGIN:
//                //show Toast
//                break;
//        }
//    }
}