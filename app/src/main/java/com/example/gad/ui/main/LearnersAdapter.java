package com.example.gad.ui.main;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gad.R;
import com.example.gad.model.SkillIQ;
import com.example.gad.model.SkillLearners;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 *
 */
public class LearnersAdapter extends  RecyclerView.Adapter<LearnersAdapter.ViewHolder>{

    private final Context mContext;
    private final LayoutInflater mlayoutInflater;
    private final List<SkillLearners> mLearners;


    public LearnersAdapter(Context context, List<SkillLearners> learners){
        mContext=context;
        this.mLearners = learners;
        mlayoutInflater=LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(@Nullable ViewGroup parent, int viewType) {
        //View itemView = mlayoutInflater.from(parent.getContext()).inflate(R.layout.item_note_list, parent, false);
        View itemView=mlayoutInflater.inflate(R.layout.item_note_list,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillLearners learners=mLearners.get(position);
        holder.textname.setText(learners.getName());
        holder.textsubtitle.setText(learners.getHours());
        Picasso.get().load(learners.getBadgeUrl()).into(holder.imageView);
        holder.mCurrentPosition=position;
    }

    @Override
    public int getItemCount() {

        int a ;

        if(mLearners != null && !mLearners.isEmpty()) {

            a = mLearners.size();
        }
        else {

            a = 0;

        }
        return a;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textname;
        public final TextView textsubtitle;
        public final ImageView imageView;
        public int mCurrentPosition;
        public ViewHolder(View itemView) {
            super(itemView);
            textname = (TextView) itemView.findViewById(R.id.text_head);
            textsubtitle = (TextView) itemView.findViewById(R.id.text_subtitle);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }


    }
}
