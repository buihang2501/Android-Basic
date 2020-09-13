package hangbt.hust.shortstoryapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import hangbt.hust.shortstoryapp.R;
import hangbt.hust.shortstoryapp.data.base.BaseAsyncTask;
import hangbt.hust.shortstoryapp.data.model.ShortStory;
import hangbt.hust.shortstoryapp.data.source.AppDatabase;
import hangbt.hust.shortstoryapp.data.source.ShortStoryDao;

public class DetailStoryFragment extends Fragment {

    public static final String BUNDLE_STORY = "BUNDLE_STORY";
    public static final String BUNDLE_POSITION = "BUNDLE_POSITION";

    private int position;

    private static final String TAG = "DetailStoryFragment";

    private ImageView image;
    private TextView textViewTitle, textViewAuthor, textViewDescription;
    private ImageView imageViewBack, imageViewMark;
    private Button buttonRead;
    private ConstraintLayout constrainFragment;

    private OnClickBookmarkListener onClickBookmarkListener;

    public static DetailStoryFragment newInstance(ShortStory story, int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_STORY, story);
        bundle.putInt(BUNDLE_POSITION, position);

        DetailStoryFragment fragment = new DetailStoryFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onClickBookmarkListener = (OnClickBookmarkListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_story, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        image = view.findViewById(R.id.image);
        textViewTitle = view.findViewById(R.id.textViewTitle);
        textViewAuthor = view.findViewById(R.id.textViewAuthor);
        textViewDescription = view.findViewById(R.id.textViewDescription);
        imageViewBack = view.findViewById(R.id.imageViewBack);
        imageViewMark = view.findViewById(R.id.imageViewMark);
        buttonRead = view.findViewById(R.id.buttonRead);
        constrainFragment = view.findViewById(R.id.constrainFragment);

        constrainFragment.setOnClickListener(view12 -> {
        });
        imageViewBack.setOnClickListener(view1 -> {
            getActivity().onBackPressed();
        });
        showDetail();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onClickBookmarkListener = null;
    }

    public void showDetail() {
        ShortStory story = (ShortStory) getArguments().getSerializable(BUNDLE_STORY);
        position = getArguments().getInt(BUNDLE_POSITION);

        Glide.with(this).load(story.getImage()).into(image);
        textViewTitle.setText(story.getTitle());
        textViewAuthor.setText(story.getAuthor());
        textViewDescription.setText(story.getDescription());

        if (story.getBookmark() != 0) {
            imageViewMark.setBackgroundResource(R.drawable.ic_baseline_bookmark_24);
        }

        imageViewMark.setOnClickListener(view -> setBookMark(story));

        buttonRead.setOnClickListener(view -> {
            //TODO: implement reading click
        });
    }

    private void setBookMark(ShortStory story) {
        int resId = story.getBookmark() == 0 ? R.drawable.ic_baseline_bookmark_24 : R.drawable.ic_baseline_bookmark_border_24;
        story.setBookmark(1 - story.getBookmark());
        imageViewMark.setBackgroundResource(resId);
//        if (story.getBookmark() == 0) {
//            story.setBookmark(1);
//            imageViewMark.setBackgroundResource(R.drawable.ic_baseline_bookmark_24);
//        } else {
//            story.setBookmark(0);
//            imageViewMark.setBackgroundResource(R.drawable.ic_baseline_bookmark_border_24);
//        }

        onClickBookmarkListener.onAddBookmark(story,position);
    }

    public interface OnClickBookmarkListener{
        void onAddBookmark(ShortStory story, int position);
    }
}
