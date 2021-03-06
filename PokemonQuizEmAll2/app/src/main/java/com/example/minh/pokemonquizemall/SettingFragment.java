package com.example.minh.pokemonquizemall;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    @BindView(R.id.iv_gen1)
    ImageView ivGen1;
    @BindView(R.id.iv_gen2)
    ImageView ivGen2;
    @BindView(R.id.iv_gen3)
    ImageView ivGen3;
    @BindView(R.id.iv_gen4)
    ImageView ivGen4;
    @BindView(R.id.iv_gen5)
    ImageView ivGen5;
    @BindView(R.id.iv_gen6)
    ImageView ivGen6;
    @BindView(R.id.sw_music)
    Switch swMusic;
    @BindView(R.id.sw_sound)
    Switch swSound;

    public MediaPlayer mediaPlayerSound1;
    public MediaPlayer mediaPlayerSound2;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        ButterKnife.bind(this, view);
        mediaPlayerSound1 = MediaPlayer.create(getContext(), R.raw.uiclick);
        mediaPlayerSound2 = MediaPlayer.create(getContext(), R.raw.uitoggle);
        swMusic.setChecked(((MainActivity)getActivity()).isPlayedMusic);
        swSound.setChecked(((MainActivity)getActivity()).isPlayedSound);
        addListener();
        return view;
    }

    private void addListener(){
        ivGen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChosen(ivGen1, ivGen2, ivGen3, ivGen4, ivGen5, ivGen6);
                checkSound(((MainActivity)getActivity()).isPlayedSound, mediaPlayerSound1);
            }
        });

        ivGen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChosen(ivGen2, ivGen1, ivGen3, ivGen4, ivGen5, ivGen6);
                checkSound(((MainActivity)getActivity()).isPlayedSound, mediaPlayerSound1);
            }
        });

        ivGen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChosen(ivGen3, ivGen1, ivGen2,ivGen4, ivGen5, ivGen6);
                checkSound(((MainActivity)getActivity()).isPlayedSound, mediaPlayerSound1);
            }
        });

        ivGen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChosen(ivGen4, ivGen1, ivGen2, ivGen3,ivGen5, ivGen6);
                checkSound(((MainActivity)getActivity()).isPlayedSound, mediaPlayerSound1);
            }
        });

        ivGen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChosen(ivGen5, ivGen1, ivGen2, ivGen3, ivGen4, ivGen6);
                checkSound(((MainActivity)getActivity()).isPlayedSound, mediaPlayerSound1);
            }
        });

        ivGen6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChosen(ivGen6, ivGen1, ivGen2, ivGen3, ivGen4, ivGen5);
                checkSound(((MainActivity)getActivity()).isPlayedSound, mediaPlayerSound1);
            }
        });
        swMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkSound(((MainActivity)getActivity()).isPlayedSound, mediaPlayerSound2);
                if (!isChecked) {
                    ((MainActivity)getActivity()).isPlayedMusic = false;
                }else{
                    ((MainActivity)getActivity()).isPlayedMusic = true;
                }
            }
        });
        swSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    ((MainActivity)getActivity()).isPlayedSound = false;
                }else{
                    ((MainActivity)getActivity()).isPlayedSound = true;
                }
                checkSound(((MainActivity)getActivity()).isPlayedSound, mediaPlayerSound2);
            }
        });
    }

    private void checkSound(boolean isPlayedSound, MediaPlayer mediaPlayer){
        if (isPlayedSound) {
            mediaPlayer.start();
        }else;
    }
    private void setChosen(ImageView imageView1, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6){
        if (imageView2.getAlpha() == 0.5f && imageView3.getAlpha() == 0.5f && imageView4.getAlpha() == 0.5f && imageView5.getAlpha() == 0.5f && imageView6.getAlpha() == 0.5f){
            imageView1.setAlpha(1f);
        }else if (imageView1.getAlpha() == 0.5){
            imageView1.setAlpha(1f);
        }else if (imageView1.getAlpha() == 1){
            imageView1.setAlpha(0.5f);
        }else;
    }
}
