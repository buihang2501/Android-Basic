package hangbt.hust.shortstoryapp.ui;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import hangbt.hust.shortstoryapp.R;
import hangbt.hust.shortstoryapp.data.model.ShortStory;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

    private List<ShortStory> stories = new ArrayList<>();
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new StoryViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        ShortStory story = stories.get(position);
        holder.bindData(story);
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public void updateData(List<ShortStory> storyList) {
        stories.clear();
        stories.addAll(storyList);
        notifyDataSetChanged();
    }

    public void updateItem(ShortStory story, int position){
        stories.set(position, story);
        notifyItemChanged(position);
    }

    static class StoryViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTitle, textViewAuthor;
        private ImageView image;
        private View viewBookmark;

        private OnItemClickListener listener;

        public StoryViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            image = itemView.findViewById(R.id.image);
            viewBookmark = itemView.findViewById(R.id.viewBookmark);
            this.listener = listener;
        }

        public void bindData(ShortStory story) {
            textViewTitle.setText(story.getTitle());
            textViewAuthor.setText(story.getAuthor());

            Glide.with(itemView)
                    .load(story.getImage())
                    .into(image);

            if (story.getBookmark() == 1) {
                viewBookmark.setBackgroundResource(R.color.colorBookmark);
            }

            itemView.setOnClickListener(view -> {
                listener.onClick(story, getAdapterPosition());
            });
        }
    }

    public interface OnItemClickListener{
        void onClick(ShortStory story, int position);
    }

}
