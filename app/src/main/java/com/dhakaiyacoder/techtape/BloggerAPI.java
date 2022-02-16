package com.dhakaiyacoder.techtape;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class BloggerAPI {

    public static final String KEY="AIzaSyCcMmflCyxNj1M8dhyfY2wKyuViWzhGvlM";
    public static final String URL="https://www.googleapis.com/blogger/v3/blogs/6032974129011681817/posts/";

    public static PostService postService = null;

    public static PostService getPostService(){
        if (postService==null){

            Retrofit retrofit= new Retrofit.Builder().baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService = retrofit.create(PostService.class);

        }
        return postService;
    }

    public interface PostService{
        @GET("?key="+KEY)
        Call<PostList> getPostList();

        @GET("{postId}/?key="+KEY)
        Call<Item> getPOstById(@Path("postId") String id);
    }

}
