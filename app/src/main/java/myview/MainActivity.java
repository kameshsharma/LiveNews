package myview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.livenews.R;

import java.util.List;

import adapter.NewsAdapter;
import model.Article;
import viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        getSupportActionBar().hide();
        MainActivityViewModel activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        activityViewModel.getAllArticle().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable List<Article> articles) {
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(new NewsAdapter(articles, MainActivity.this));
            }
        });
    }
}
