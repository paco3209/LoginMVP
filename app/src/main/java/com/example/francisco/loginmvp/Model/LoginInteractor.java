package com.example.francisco.loginmvp.Model;

public interface LoginInteractor     {

    interface onLoginFinishListener{

        void onUsernameError();

        void onPasswordError();

        void onSuccess();


    }

    void login(String username,String password, onLoginFinishListener listener);




}
