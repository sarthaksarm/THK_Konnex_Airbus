package com.sarm.konnex.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.sarm.konnex.R;

public class ChatBotFragment extends Fragment {

    public ChatBotFragment() {
        // Required empty public constructor
    }

    public static ChatBotFragment newInstance() {
        ChatBotFragment fragment = new ChatBotFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat_bot, container, false);
    }
}