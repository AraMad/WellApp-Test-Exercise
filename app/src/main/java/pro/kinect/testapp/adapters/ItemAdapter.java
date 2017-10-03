package pro.kinect.testapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pro.kinect.testapp.R;
import pro.kinect.testapp.models.RecyclerItem;

/**
 * Created by Arina on 03.10.2017
 */

public class ItemAdapter extends
        RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private final String TAG = getClass().getSimpleName();

    private List<RecyclerItem> items;

    public ItemAdapter(List<RecyclerItem> items) {
        Log.d(TAG, "ItemAdapter: ");
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "position: " + position);

        if (position < items.size()){
            if (items.get(position).getType() == RecyclerItem.Type.TypeText){
                holder.text.setText(items.get(position).getData());
                holder.image.setVisibility(View.INVISIBLE);
            } else {
                // TODO: load picture
            }
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.item_image);
            text = (TextView) itemView.findViewById(R.id.item_text);
        }
    }
}
