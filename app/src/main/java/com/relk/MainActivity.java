package com.relk;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.relk.ui.anime.AnimeFragment;
import com.relk.ui.film.FilmFragment;
import com.relk.ui.home.HomeFragment;
import com.relk.ui.tv.TVFragment;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Trova la BottomNavigationView dal layout
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        FloatingActionButton fab = findViewById(R.id.fab);
        TextInputLayout searchBarLayout = findViewById(R.id.search_bar_layout);

        // Aggiungi un click listener al FAB
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // All'interno del click listener del FAB
                if (searchBarLayout.getVisibility() == View.GONE) {
                    // Mostra la barra di ricerca con una transizione slide
                    searchBarLayout.setVisibility(View.VISIBLE);
                    Animation slideIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_top);
                    searchBarLayout.startAnimation(slideIn);
                } else {
                    // Nascondi la barra di ricerca con una transizione slide
                    Animation slideOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_out_top);
                    searchBarLayout.startAnimation(slideOut);
                    searchBarLayout.setVisibility(View.GONE);
                }
            }
        });

        // Imposta la logica per ciascun elemento della barra di navigazione
        bottomNavigationView.setOnItemSelectedListener(item -> {
            // Dichiarazione del fragment da caricare
            Fragment selectedFragment;

            // Gestisci la selezione dell'elemento nella barra di navigazione
            int itemId = item.getItemId();
            if (itemId == R.id.home) {// Sostituisci con il fragment per Home
                selectedFragment = new HomeFragment();
            } else if (itemId == R.id.film) {// Sostituisci con il fragment per Search
                selectedFragment = new FilmFragment();
            } else if (itemId == R.id.tv) {// Sostituisci con il fragment per Profile
                selectedFragment = new TVFragment();
            } else if (itemId == R.id.anime) {// Sostituisci con il fragment per Profile
                selectedFragment = new AnimeFragment();
            } else {
                return false;
            }

            // Sostituisci il fragment nel contenitore
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment, selectedFragment) // Riferimento al contenitore del fragment
                    .commit();

            return true;
        });

        // Imposta il fragment iniziale, per esempio HomeFragment
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.home);  // Imposta il primo elemento come selezionato
        }

    }
}
