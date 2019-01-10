package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.vaibhav.screen10.R;

import java.util.ArrayList;

import adapter.New_Adapter;
import model.New_Model;

public class New_s10 extends Fragment {

    private Integer abc[] = {R.drawable.shose2, R.drawable.shose1,R.drawable.shose3,R.drawable.shose3,R.drawable.shose2
            , R.drawable.shose1,R.drawable.shose3,R.drawable.shose3};

    private RecyclerView recyclerView;
    private ArrayList<New_Model> new_models;
    private New_Adapter new_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_screen10, container, false);

        recyclerView = view.findViewById(R.id.news);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        new_models = new ArrayList<>();

        for (int i = 0; i < abc.length; i++) {
            New_Model ab = new New_Model(abc[i]);
            new_models.add(ab);
        }
        new_adapter = new New_Adapter(getActivity(), new_models);
        recyclerView.setAdapter(new_adapter);
        return view;
    }
}
