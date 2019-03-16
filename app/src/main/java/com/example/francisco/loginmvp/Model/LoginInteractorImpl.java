package com.example.francisco.loginmvp.Model;

import android.text.TextUtils;

import java.util.logging.Handler;

public class LoginInteractorImpl implements LoginInteractor {


    @Override
    public void login(final String username, final String password, final onLoginFinishListener listener) {

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    return;
                }

                listener.onSuccess();

            }
        }, 1000 );
    }
}
