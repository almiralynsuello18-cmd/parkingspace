package com.example.parkingspace;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view to your layout
        setContentView(R.layout.activity_dashboard);

        // Get the root view of the layout to apply window insets
        View rootView = findViewById(R.id.dashboard);

        // Apply padding for system bars (status bar, navigation bar, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            // Get system bar insets (top, bottom, left, right)
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            // Apply the system bar insets as padding
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            // Return the insets for further handling
            return insets;
        });

        // Optional: Enable full-screen immersive mode for an edge-to-edge experience
        // This can be done using WindowInsetsController for fullscreen system bars
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            // This API requires Android 11 (API 30) or higher
            getWindow().getInsetsController().hide(android.view.WindowInsets.Type.statusBars());
            getWindow().getInsetsController().hide(android.view.WindowInsets.Type.navigationBars());
        }
    }
}
