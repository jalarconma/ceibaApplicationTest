package co.com.ceiba.mobile.pruebadeingreso.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.business.models.Post;
import com.example.business.models.UserS;
import com.raizlabs.android.dbflow.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.ceiba.mobile.pruebadeingreso.R;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> mData;
    private Context mContext;

    public PostAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list_item, parent, false);
        return new ViewHolder(rootView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Post post = mData.get(position);
        String tittle = StringUtils.isNotNullOrEmpty(post.getTitle()) ? post.getTitle() : "";
        String body = StringUtils.isNotNullOrEmpty(post.getBody()) ? post.getBody() : "";
        viewHolder.titlePostItem.setText(tittle);
        viewHolder.body.setText(body);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setData(List<Post> data) {

        if (data != null) {
            mData = new ArrayList<>();
            mData.addAll(data);
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titlePostItem)
        TextView titlePostItem;
        @BindView(R.id.body)
        TextView body;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
