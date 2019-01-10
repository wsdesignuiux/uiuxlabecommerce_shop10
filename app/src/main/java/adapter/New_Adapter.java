package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.vaibhav.screen10.R;

import java.util.ArrayList;

import model.New_Model;

public class New_Adapter extends RecyclerView.Adapter<New_Adapter.ViewHolder> {

    Context context;
    ArrayList<New_Model>models;

    public New_Adapter(Context context, ArrayList<New_Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public New_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull New_Adapter.ViewHolder holder, int position) {

        holder.abc1.setImageResource(models.get(position).getAbc());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView abc1;
        public ViewHolder(View itemView) {
            super(itemView);

            abc1 = itemView.findViewById(R.id.abc);
        }
    }
}
