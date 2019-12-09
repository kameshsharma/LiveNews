package adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.livenews.BrowserActivity;
import com.example.livenews.R;

import java.util.List;

import model.Article;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<Article> articles;
    private Context context;

    public NewsAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_news_view, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, final int position) {
        holder.title.setText(articles.get(position).getTitle());
        holder.date.setText(articles.get(position).getPublishedAt());

        String photoUrl = articles.get(position).getUrlToImage();
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, BrowserActivity.class);
                intent.putExtra("webdata", articles.get(position).getUrl());
                context.startActivity(intent);

                System.out.println("get url" + articles.get(position).getUrl() + "get source" + articles.get(position).getSource());
            }
        });
        Glide.with(context).load(photoUrl).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


    class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView title, date;
        ImageView imageView;

        NewsViewHolder(@NonNull final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            imageView = itemView.findViewById(R.id.image);

        }
    }

}
