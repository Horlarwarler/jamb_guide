package com.offline.jambguide.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.offline.jambguide.Constant;
import com.offline.jambguide.R;
import com.offline.jambguide.activity.BookmarkList;
import com.offline.jambguide.activity.InstructionActivity;
import com.offline.jambguide.activity.SettingActivity;
import com.offline.jambguide.helper.SettingsPreferences;

/**
 * Created by Hetal on 09-Mar-18.
 */
public class FragmentMainMenu extends Fragment implements View.OnClickListener /*, RewardedVideoAdListener*/ {

    private View mSignIn;
    private View mSignOut;
    private ImageView imgBookmark;
    private Listener mListener = null;
    private boolean mShowSignInButton = true;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mainmenu, container, false);
        mSignIn = view.findViewById(R.id.sign_in_button);
        mSignOut = view.findViewById(R.id.sign_out_button);


        final int[] clickableIds = new int[]{
                R.id.sign_in_button,
                R.id.sign_out_button,
                R.id.instruction,
                R.id.setting1,
                R.id.english,
                R.id.achivments1,
                R.id.leaderbord1

        };

        for (int clickableId : clickableIds) {
            view.findViewById(clickableId).setOnClickListener(this);
        }

        updateUI();
        imgBookmark = (ImageView) view.findViewById(R.id.imgBookmark);
        imgBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BookmarkList.class);
                startActivity(intent);
            }
        });
        return view;
    }

    public void setListener(Listener listener) {
        mListener = listener;
    }

    private void updateUI() {

        mSignIn.setVisibility(mShowSignInButton ? View.VISIBLE : View.GONE);
        mSignOut.setVisibility(mShowSignInButton ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.english:


                mListener.onStartGameRequested();
                break;
            case R.id.sign_in_button:
            case R.id.sign_out_button:
            case R.id.leaderbord1:
//                if (SettingsPreferences.getSoundEnableDisable(getContext())) {
//                    Constant.backSoundonclick(getContext());
//                }
//                if (SettingsPreferences.getVibration(getContext())) {
//                    Constant.vibrate(getContext(), Constant.VIBRATION_DURATION);
//                }
//                if (mShowSignInButton == false) {
//                    mListener.onShowLeaderboardsRequested();
//                } else {
//                    mListener.onSignInButtonClicked();
//                }
            case R.id.achivments1:
                Toast.makeText(getActivity(), " This Feature is Coming Soon", Toast.LENGTH_SHORT).show();

                break;
            case R.id.instruction:
                SettingsPreferences.setLan(getContext(), true);
                if (SettingsPreferences.getSoundEnableDisable(getContext())) {
                    Constant.backSoundonclick(getContext());
                }
                if (SettingsPreferences.getVibration(getContext())) {
                    Constant.vibrate(getContext(), Constant.VIBRATION_DURATION);
                }
                Intent playQuiz = new Intent(getActivity(), InstructionActivity.class);
                startActivity(playQuiz);


                break;
            case R.id.setting1:
                if (SettingsPreferences.getSoundEnableDisable(getContext())) {
                    Constant.backSoundonclick(getContext());
                }
                if (SettingsPreferences.getVibration(getContext())) {
                    Constant.vibrate(getContext(), Constant.VIBRATION_DURATION);
                }
                Intent settingsActivity = new Intent(getActivity(), SettingActivity.class);
                startActivity(settingsActivity);
                break;
//                if (SettingsPreferences.getSoundEnableDisable(getContext())) {
//                    Constant.backSoundonclick(getContext());
//                }
//                if (SettingsPreferences.getVibration(getContext())) {
//                    Constant.vibrate(getContext(), Constant.VIBRATION_DURATION);
//                }
//                if (mShowSignInButton == false) {
//                    mListener.onShowAchievementsRequested();
//                } else {
//
//                    mListener.onSignInButtonClicked();
//                }
//                break;
        }
    }

    public void setShowSignInButton(boolean showSignInButton) {
        mShowSignInButton = showSignInButton;
        updateUI();
    }

    public interface Listener {
        // called when the user presses the `Easy` or `Okay` button; will pass in which via `hardMode`
        void onStartGameRequested();

        // called when the user presses the `Show Achievements` button
        void onShowAchievementsRequested();

        // called when the user presses the `Show Leaderboards` button
        void onShowLeaderboardsRequested();

        // called when the user presses the `Sign In` button
        void onSignInButtonClicked();

        // called when the user presses the `Sign Out` button
        void onSignOutButtonClicked();
    }
}