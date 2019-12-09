package model.repo;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import java.util.List;


import model.Article;
import model.News;
import remotedata.NewsServiceApi;
import remotedata.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    MutableLiveData<List<Article>> mutableLiveData;
    private Application application;


    public final static String BASE_URL = "https://newsapi.org/v2/";

    String news_url = String.format("top-headlines?country=us&category=business&apiKey=78e088eee2a74423a9e70b2b67d353de");

    public NewsRepository(Application application) {
        this.application = application;
    }


    public MutableLiveData<List<Article>> getMutableLiveData() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
        }
        NewsServiceApi serviceApi = RetrofitClient.getClient(BASE_URL).create(NewsServiceApi.class);
        serviceApi.getAllNews(news_url)
                .enqueue(new Callback<News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        if (response.isSuccessful()) {
                            News newsRes = response.body();
                            List<Article> articleList = newsRes.getArticles();
                            mutableLiveData.setValue(articleList);
                        }
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {
                    }
                });
        return mutableLiveData;
    }

}