package com.example.dragos.foodway.functionalitati;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dragos.foodway.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


/**
 * A placeholder fragment containing a simple view.
 */
public class LoginActivityFragment extends Fragment  {


    private TextView mTextDetails;

    private AccessTokenTracker mTokenTracker;
    private ProfileTracker mProfileTracker;
    private CallbackManager mCallBackManager;
    protected FacebookCallback<LoginResult> mCallBack = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {


            AccessToken accessToken = loginResult.getAccessToken();
            Profile profile = Profile.getCurrentProfile();
            welcomeMessage(profile);

        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException e) {

        }
    };

    public LoginActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getActivity());
        mCallBackManager = CallbackManager.Factory.create();

        mTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {

            }
        };
        mProfileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                welcomeMessage(newProfile);

            }
        };
        mTokenTracker.startTracking();
        mProfileTracker.startTracking();



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_logare_google_and_facebook, container, false);



    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        LoginButton loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setFragment(this);
        loginButton.registerCallback(mCallBackManager, mCallBack);
        mTextDetails = (TextView) view.findViewById(R.id.text_details);
    }

    public void welcomeMessage(Profile profile) {

        if (profile != null) mTextDetails.setText("Bine ai venit " + profile.getName());
        if (profile == null) mTextDetails.setText("   ");

    }




    @Override
    public void onResume(){
        super.onResume();
        Profile profile = Profile.getCurrentProfile();
        welcomeMessage(profile);
    }
    @Override
    public void onStop(){
        super.onStop();
        mTokenTracker.stopTracking();
        mProfileTracker.stopTracking();

        // LoginManager.getInstance().logOut();


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallBackManager.onActivityResult(requestCode, resultCode, data);
    }
}
