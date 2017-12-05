package test.couch.instafit.com.couchcatalog.screens.allcoaches;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import test.couch.instafit.com.couchcatalog.R;
import test.couch.instafit.com.couchcatalog.data.Coach;


/**
 * A simple {@link Fragment} subclass.
 */
public class CoachInfoFragment extends Fragment {

    static final String KEYCoachName = "Coach.Name";
    static final String KEYCoachDesc = "Coach.descriptionDiv";
    static final String KEYCoachUrl = "Coach.imageUrl";

    private String name;
    private String desc;
    private String url;

    @NonNull
    public static CoachInfoFragment newInstance(@NonNull Coach coach) {
        CoachInfoFragment fragment = new CoachInfoFragment();

        Bundle args = new Bundle();
        args.putString(KEYCoachName, coach.getName());
        args.putString(KEYCoachDesc, coach.getDescription());
        args.putString(KEYCoachUrl, coach.getAvatar());
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString(KEYCoachName, null);
        desc = getArguments().getString(KEYCoachDesc, null);
        url = getArguments().getString(KEYCoachUrl, null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_coach_info, container, false);

        // NAME
        final TextView txtName = view.findViewById(R.id.coach_info_name);
        txtName.setText(name);

        // AVATAR
        final ImageView imageView = view.findViewById(R.id.coach_info_image);
        Glide.with(this).load(url).apply(RequestOptions.circleCropTransform()).apply(RequestOptions.placeholderOf(R.drawable.userthumb).circleCrop()).into(imageView);

        // DESCRIPTION
        final WebView webView = view.findViewById(R.id.coach_info_description_webview);
        webView.setBackgroundColor(Color.TRANSPARENT);


        final String start = "<html><head><meta http-equiv='Content-Type' content='text/html' charset='UTF-8' /></head><body>";
        final String end = "</body></html>";

        webView.loadData(start + desc + end, "text/html; charset=UTF-8", null);


        return view;
    }
}
