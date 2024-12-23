package com.relk;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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
