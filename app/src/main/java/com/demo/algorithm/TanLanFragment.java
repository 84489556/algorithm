package com.demo.algorithm;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.demo.algorithm.databinding.FragmentTanlanBinding;
import com.demo.algorithm.run.Tanxin;

public class TanLanFragment extends Fragment {

    private FragmentTanlanBinding binding;
    int[] arr = new int[]{1,2,3,2,3,4,3,4,5,6,7};

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentTanlanBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonTanlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TanLanFragment.this)
                        .navigate(R.id.action_TanLan_to_FirstFragment);
            }
        });


        int length = Tanxin.findLength(arr);
        Log.d("TanLanFragment",length+"");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}