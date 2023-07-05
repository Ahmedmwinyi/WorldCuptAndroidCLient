package com.example.androidclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.androidclient.Model.Team;
import com.example.androidclient.Retrofit.RetrofitService;
import com.example.androidclient.Retrofit.TeamApi;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
    }

    private void initializeComponents() {
        TextInputEditText inputEditTeam = findViewById(R.id.textFieldTeam);
        TextInputEditText inputEditTitle = findViewById(R.id.textFieldTitle);
        TextInputEditText inputEditContinent = findViewById(R.id.textFieldContinent);
        TextInputEditText inputEditCoach = findViewById(R.id.textFieldCoach);
        TextInputEditText inputEditKeyPlayer = findViewById(R.id.textFieldKeyplayer);
        MaterialButton buttonSave = findViewById(R.id.FormBtnSave);

        RetrofitService retrofitService = new RetrofitService();
        TeamApi teamApi = retrofitService.getRetrofit().create(TeamApi.class);
        buttonSave.setOnClickListener(view -> {
            String name = String.valueOf(inputEditTeam.getText());
            String title = String.valueOf(inputEditTitle.getText());
            String cont = String.valueOf(inputEditContinent.getText());
            String coach = String.valueOf(inputEditCoach.getText());
            String keyplayer = String.valueOf(inputEditKeyPlayer.getText());

            Team team = new Team();
            team.setName(name);
            team.setTitle(title);
            team.setCont(cont);
            team.setCoach(coach);
            team.setKeyplayer(keyplayer);

            teamApi.save(team)
                    .enqueue(new Callback<Team>() {
                        @Override
                        public void onResponse(Call<Team> call, Response<Team> response) {
                            Toast.makeText(MainActivity.this, "Save Succesfully!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Team> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Failed to Save..!!!:", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error Occurred", t);
                        }
                    });
        });
    }
}