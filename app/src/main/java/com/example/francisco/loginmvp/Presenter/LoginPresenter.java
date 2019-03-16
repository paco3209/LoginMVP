package com.example.francisco.loginmvp.Presenter;

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();

}
