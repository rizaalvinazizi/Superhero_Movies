package id.sch.smktelkom_mlg.privateassignment.xirpl130.superheromovies.Captamerica;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl130.superheromovies.DetailActivity;
import id.sch.smktelkom_mlg.privateassignment.xirpl130.superheromovies.R;

/**
 * Created by Nugrahanto on 13/05/2017.
 */

public class CaptamericaAdapter extends RecyclerView.Adapter<CaptamericaAdapter.ViewHolder> {
    private List<CaptamericaListItem> captamericaListItems;
    private Context context; //mode default, hanya bisa diakses dengan dipanggil

    public CaptamericaAdapter(List<CaptamericaListItem> captamericaListItems, Context context) {
        this.captamericaListItems = captamericaListItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.captamerica_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final CaptamericaListItem captamericaListItem = captamericaListItems.get(position);

//        holder.imageViewOtof.setImageResource(R.drawable.ic_memory_black_24dp);
        holder.textViewTitle.setText(captamericaListItem.getTitle());
        holder.textViewYear.setText(captamericaListItem.getYear());

        Glide
                .with(context)
                .load(captamericaListItem.getImageUrl())
                .into(holder.imageViewOtof);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "Will be released soon", Toast.LENGTH_LONG).show();

//                Intent singleBlogIntent = new Intent(context, TechnologyDetailActivity.class);
//                singleBlogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //addFLags membuka activity dari fragment
//                singleBlogIntent.putExtra("blog_id", position); //position untuk menentukan posisi di array
//                context.startActivity(singleBlogIntent);

                Intent singleBlogIntent = new Intent(context, DetailActivity.class);
                singleBlogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                singleBlogIntent.putExtra("blog_id", position);
                singleBlogIntent.putExtra("jenis", "Captamerica");
                context.startActivity(singleBlogIntent);
            }
        });
    }

    public int getItemCount() {
        return captamericaListItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;
        public TextView textViewYear;
        public ImageView imageViewOtof;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewTitle = (TextView) itemView.findViewById(R.id.textViewHeadCap);
            textViewYear = (TextView) itemView.findViewById(R.id.textViewDescCap);
            imageViewOtof = (ImageView) itemView.findViewById(R.id.imageViewOtofCap);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.LinearLayoutCap);
        }
    }
}
