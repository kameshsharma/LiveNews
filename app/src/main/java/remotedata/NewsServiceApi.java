package remotedata;

import model.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NewsServiceApi {

    @GET
    Call<News> getAllNews(@Url String urlString);

}
