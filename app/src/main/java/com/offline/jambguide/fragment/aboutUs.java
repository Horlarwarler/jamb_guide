package com.offline.jambguide.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.offline.jambguide.R;
import com.offline.jambguide.databinding.FragmentAboutUsBinding;

public class aboutUs extends Fragment {

    FragmentAboutUsBinding FragementAboutUs;

    public aboutUs() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragementAboutUs = FragmentAboutUsBinding.inflate(inflater, container, false);
        return FragementAboutUs.getRoot();
        //return inflater.inflate(R.layout.fragment_about_us, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        FragementAboutUs.backArrow.setOnClickListener(v -> {
            requireActivity().onBackPressed();
        });

        FragementAboutUs.aboutPage.setCover(R.drawable.ic_round_mark_chat_read_24); //Pass your cover image
        FragementAboutUs.aboutPage.setName("Crezent");
        FragementAboutUs.aboutPage.setDescription("Creating Easy Solution | Technology at your Fingerprint");
        FragementAboutUs.aboutPage.setAppIcon(R.drawable.logo_png); //Pass your app icon image
        FragementAboutUs.aboutPage.setAppName("Jamb Student's Guide");
        FragementAboutUs.aboutPage.setVersionNameAsAppSubTitle("1");
        FragementAboutUs.aboutPage.setAppDescription("Jamb Student's is useful and interactive app for student for student preapring for the upcoming Jamb Examination.\n\n" +
                "Build with some amazing feature which student required to stay up to date with relevant information\n\n" +
                "Practise Jamb Question fully offline that with a nice interface to remember during your examinations");
        FragementAboutUs.aboutPage.addEmailLink("dcrescentsol@gmail.com");     //Add your email id
        FragementAboutUs.aboutPage.addFacebookLink("https://www.facebook.com/shashanksinghal02");  //Add your facebook address url
//        FragementAboutUs.aboutPage.addTwitterLink("https://twitter.com/shashank020597");
//        FragementAboutUs.aboutPage.addLinkedinLink("https://www.linkedin.com/in/shashank-singhal-a87729b5/");
//        FragementAboutUs.aboutPage.addGitHubLink("https://github.com/Shashank02051997");
//    }
    }
}