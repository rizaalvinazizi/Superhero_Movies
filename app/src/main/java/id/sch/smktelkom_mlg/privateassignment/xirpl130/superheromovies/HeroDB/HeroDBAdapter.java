package id.sch.smktelkom_mlg.privateassignment.xirpl130.superheromovies.HeroDB;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl130.superheromovies.R;

/**
 * Created by Nugrahanto on 14/05/2017.
 */

public class HeroDBAdapter extends RecyclerView.Adapter<HeroDBAdapter.ViewHolder> {

    private final Context context;
    ArrayList<HeroDBItem> fItem;

    public HeroDBAdapter(ArrayList<HeroDBItem> heroDBItems, Context context) {
        this.fItem = heroDBItems;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HeroDBItem heroDBItem = fItem.get(position);
        holder.textViewHeadfav.setText(heroDBItem.title);
        holder.textViewHeadfav.setText(heroDBItem.year);

        Glide
                .with(context)
                .load(heroDBItem.imageUrl)
                .into(holder.imageViewOtoffav);

    }

    @Override
    public int getItemCount() {
        return fItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHeadfav;
        public TextView textViewDescfav;
        public ImageView imageViewOtoffav;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHeadfav = (TextView) itemView.findViewById(R.id.textViewHeadFav);
            textViewDescfav = (TextView) itemView.findViewById(R.id.textViewDescFav);
            imageViewOtoffav = (ImageView) itemView.findViewById(R.id.imageViewOtofFav);
//            buttonDelete.setOnClickListener(new View.OnClickListener()
//            {
//                @Override
//                public void onClick(View v)
//                {
//                    iFavouriteAdapter.doDelete(getAdapterPosition());
//                }
//            });
        }

    }
}

