package viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import model.Article;
import model.repo.NewsRepository;


public class MainActivityViewModel extends AndroidViewModel {

    private NewsRepository newsRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        newsRepository = new NewsRepository(application);
    }

    public LiveData<List<Article>> getAllArticle() {
        return newsRepository.getMutableLiveData();
    }


}