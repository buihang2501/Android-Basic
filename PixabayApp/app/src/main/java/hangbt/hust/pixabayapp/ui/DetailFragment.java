package hangbt.hust.pixabayapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import hangbt.hust.pixabayapp.R;
import hangbt.hust.pixabayapp.data.Hit;

public class DetailFragment extends Fragment {

    private static final String BUNDLE_HIT = "BUNDLE_HIT";
    private ImageView imageBack, imageDetail;
    private FrameLayout frameMain;

    public static DetailFragment newInstance(Hit hit) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_HIT, hit);

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageBack = view.findViewById(R.id.imageBack);
        imageDetail = view.findViewById(R.id.imageHitDetail);
        frameMain = view.findViewById(R.id.frameMain);

        imageBack.setOnClickListener(view1 -> getActivity().onBackPressed());
        frameMain.setOnClickListener(view12 -> getActivity().onBackPressed());
        imageDetail.setOnClickListener(view13 -> {
        });
        showDetail();
    }

    public void showDetail(){
        Hit hit = (Hit) getArguments().getSerializable(BUNDLE_HIT);
        Glide.with(this).load(hit.getUrl()).into(imageDetail);
    }
}