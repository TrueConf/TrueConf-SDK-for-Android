package com.trueconf.sample;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.trueconf.sample.databinding.FragmentEmptyBinding;

public class EmptyFragment extends Fragment {

    public EmptyFragment() {
        super(R.layout.fragment_empty);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentEmptyBinding binding = FragmentEmptyBinding.bind(view);
        binding.close.setOnClickListener(v ->
                getParentFragmentManager()
                .beginTransaction()
                .remove(this)
                .commit());
    }
}
