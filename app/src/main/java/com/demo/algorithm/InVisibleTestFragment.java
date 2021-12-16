package com.demo.algorithm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.demo.algorithm.databinding.FragmentFirstBinding;
import com.demo.algorithm.databinding.FragmentInvisibletestBinding;

public class InVisibleTestFragment extends Fragment {

    private FragmentInvisibletestBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        binding = FragmentInvisibletestBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.testview.setVisibility(View.VISIBLE);
            }
        });
        binding.invisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.testview.setVisibility(View.INVISIBLE);
            }
        });
        binding.gone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.testview.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}