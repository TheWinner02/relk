package com.relk.ui.film;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.relk.databinding.FragmentFilmBinding;

public class FilmFragment extends Fragment {

    private FragmentFilmBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FilmViewModel filmViewModel =
                new ViewModelProvider(this).get(FilmViewModel.class);

        binding = FragmentFilmBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFilm;
        filmViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}