package hangbt.hust.pixabayapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.pixabayapp.R;
import hangbt.hust.pixabayapp.data.Hit;

public class HitAdapter extends RecyclerView.Adapter<HitAdapter.HitViewHolder> {

    private List<Hit> hits = new ArrayList<>();
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public HitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hit, parent, false);
        return new HitViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull HitViewHolder holder, int position) {
        Hit hit = hits.get(position);
        holder.bindData(hit);
    }

    @Override
    public int getItemCount() {
        return hits.size();
    }

    public void updateData(List<Hit> hitList){
        hits.clear();
        hits.addAll(hitList);
        notifyDataSetChanged();
    }


    static class HitViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageHit, imageDelete;
        private OnItemClickListener listener;

        public HitViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            imageHit = itemView.findViewById(R.id.imageHit);
            imageDelete = itemView.findViewById(R.id.imageDelete);
            this.listener = listener;
        }

        public void bindData(Hit hit) {
            Glide.with(itemView)
                    .load(hit.getPreviewUrl())
                    .into(imageHit);
            imageHit.setOnClickListener(view -> {
                listener.onClick(hit);
            });
        }
    }

    public interface OnItemClickListener{
        void onClick(Hit hit);
    }
}
