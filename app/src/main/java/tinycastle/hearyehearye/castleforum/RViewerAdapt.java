package tinycastle.hearyehearye.castleforum;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Heather on 3/23/2015.
 * for making a recycler view
 */
public class RViewerAdapt extends RecyclerView.Adapter <RViewerAdapt.MyViewHolder> {

    private LayoutInflater inflater;

    public RViewerAdapt(Context context)
    {
        inflater=LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       //check this
        View views = inflater.inflate(R.layout.viewer, viewGroup);
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

}
