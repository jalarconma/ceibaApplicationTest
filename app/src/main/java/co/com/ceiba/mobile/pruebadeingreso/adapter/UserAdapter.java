package co.com.ceiba.mobile.pruebadeingreso.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.business.models.UserS;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.adapter.listener.UserListener;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<UserS> mData;
    private Context mContext;

    private UserListener mListener;

    public UserAdapter(Context mContext,
                       UserListener mListener) {
        this.mContext = mContext;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new ViewHolder(rootView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.getPostClickListener.setPosition(position);

        UserS user = mData.get(position);
        viewHolder.name.setText(user.getName());
        viewHolder.phone.setText(user.getPhone());
        viewHolder.email.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setData(List<UserS> data) {

        if (data != null) {
            mData = new ArrayList<>();
            mData.addAll(data);
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.phone)
        TextView phone;
        @BindView(R.id.email)
        TextView email;
        @BindView(R.id.btn_view_post)
        Button btn_view_post;

        GetPostClickListener getPostClickListener;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            getPostClickListener = new GetPostClickListener();
            btn_view_post.setOnClickListener(getPostClickListener);
        }

        private class GetPostClickListener implements View.OnClickListener {

            private int mPosition;

            public void setPosition (int mPosition) {
                this.mPosition = mPosition;
            }

            @Override
            public void onClick(View v) {

                if (mPosition < getItemCount()) {
                    UserS user = mData.get(mPosition);
                    mListener.onGetPosts(user.getId().intValue());
                }
            }
        }
    }
}
