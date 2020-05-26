package com.example.recyclerview.ViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.Adapter.PostsAdapter;
import com.example.recyclerview.Model.Posts;
import com.example.recyclerview.R;
import com.example.recyclerview.ViewModel.PostViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel= ViewModelProviders.of(this).get(PostViewModel.class);
        //callback
        postViewModel.getPost();
        //view
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        final PostsAdapter postsAdapter=new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(postsAdapter);

        postViewModel.postMutableLiveData.observe(this, new Observer<List<Posts>>() {
            @Override
            public void onChanged(List<Posts> posts) {
                postsAdapter.setList((ArrayList<Posts>) posts);
            }
        });
    }
}
