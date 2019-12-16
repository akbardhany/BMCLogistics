package co.id.pelindologistics.ui.depot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import co.id.pelindologistics.R;

public class DepotAdapter extends RecyclerView.Adapter<DepotAdapter.DepotHolder> {
    private ArrayList<DepotViewModel> depotViewModelArrayList;
    Context context;

    public DepotAdapter(Context context, ArrayList<DepotViewModel> depotViewModelArrayList){
        this.depotViewModelArrayList = depotViewModelArrayList;
        this.context = context;
    }

    public class DepotHolder extends RecyclerView.ViewHolder {
        TextView depotName, depotAreaCode;
        ImageView depotImg;
        LinearLayout ird;

        public DepotHolder(@NonNull View view){
            super(view);
            depotName = view.findViewById(R.id.txt_depotName);
            depotAreaCode = view.findViewById(R.id.txt_depotArea);
            depotImg = view.findViewById(R.id.iv_depotImg);
            ird = view.findViewById(R.id.ird);
        }
    }
    @NonNull
    @Override
    public DepotAdapter.DepotHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_depots, viewGroup, false);
        return new DepotHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DepotAdapter.DepotHolder holder, final int position) {
        final DepotViewModel depotViewModel = depotViewModelArrayList.get(position);
        holder.depotName.setText(depotViewModel.getDepotName());
        holder.depotAreaCode.setText(depotViewModel.getDepotAreaCode());
        Glide.with(holder.itemView.getContext())
                .load(depotViewModel.getDepotImg())
                .apply(new RequestOptions())
                .into(holder.depotImg);

        holder.ird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DepotViewModel depotViewModel = new DepotViewModel();
                depotViewModel.setDepotMainName(depotViewModelArrayList.get(position).getDepotMainName());
                depotViewModel.setDepotStatusContainer(depotViewModelArrayList.get(position).getDepotStatusContainer());
                depotViewModel.setDepotImg(depotViewModelArrayList.get(position).getDepotImg());
                depotViewModel.setDepotAreaCode(depotViewModelArrayList.get(position).getDepotAreaCode());
                depotViewModel.setDepotAVRYOR(depotViewModelArrayList.get(position).getDepotAVRYOR());
                depotViewModel.setDepotCapacity(depotViewModelArrayList.get(position).getDepotCapacity());
                depotViewModel.setDepotFL3T(depotViewModelArrayList.get(position).getDepotFL3T());
                depotViewModel.setDepotFL7T(depotViewModelArrayList.get(position).getDepotFL7T());
                depotViewModel.setDepotFL10T(depotViewModelArrayList.get(position).getDepotFL10T());
                depotViewModel.setDepotPartner(depotViewModelArrayList.get(position).getDepotPartner());
                depotViewModel.setDepotRS(depotViewModelArrayList.get(position).getDepotRS());
                depotViewModel.setDepotServices(depotViewModelArrayList.get(position).getDepotServices());
                depotViewModel.setDepotSL(depotViewModelArrayList.get(position).getDepotSL());
                depotViewModel.setDetDepotAVRYORstr(depotViewModelArrayList.get(position).getDetDepotAVRYORstr());
                depotViewModel.setDepotAddress(depotViewModelArrayList.get(position).getDepotAddress());

                Intent intentDepot = new Intent(context, DepotDetailActivity.class);
                intentDepot.putExtra(DepotDetailActivity.EXTRA_DEPOT, depotViewModel);
                context.startActivity(intentDepot);
            }
        });
    }

    @Override
    public int getItemCount() {
        return depotViewModelArrayList.size();
    }
}
