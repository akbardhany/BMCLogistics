package co.id.pelindologistics.ui.warehouse;

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

public class WarehouseAdapter extends RecyclerView.Adapter<WarehouseAdapter.WarehouseHolder> {
    private ArrayList<WarehouseViewModel> warehouseViewModelArrayList;
    Context context;

    public WarehouseAdapter(Context context, ArrayList<WarehouseViewModel> warehouseViewModelArrayList){
        this.warehouseViewModelArrayList = warehouseViewModelArrayList;
        this.context = context;
    }

    public class WarehouseHolder extends RecyclerView.ViewHolder {
        TextView warehouseName, warehouseAreaCode;
        ImageView warehouseImg;
        LinearLayout irw;

        public WarehouseHolder(@NonNull View view) {
            super(view);
            warehouseName = view.findViewById(R.id.txt_warehouseName);
            warehouseAreaCode = view.findViewById(R.id.txt_warehouseArea);
            warehouseImg = view.findViewById(R.id.iv_warehouseImg);
            irw = view.findViewById(R.id.irw);
        }
    }
    @NonNull
    @Override
    public WarehouseAdapter.WarehouseHolder onCreateViewHolder(@NonNull ViewGroup  viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_warehouse, viewGroup, false);
        return new WarehouseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final WarehouseAdapter.WarehouseHolder holder, final int position) {
        WarehouseViewModel warehouseViewModel = warehouseViewModelArrayList.get(position);
        holder.warehouseName.setText(warehouseViewModel.getWarehouseName());
        holder.warehouseAreaCode.setText(warehouseViewModel.getWarehouseAreaCode());
        Glide.with(holder.itemView.getContext())
                .load(warehouseViewModel.getWarehouseImg())
                .apply(new RequestOptions())
                .into(holder.warehouseImg);

        holder.irw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WarehouseViewModel warehouseViewModel = new WarehouseViewModel();
                warehouseViewModel.setWarehouseName(warehouseViewModelArrayList.get(position).getWarehouseName());
                warehouseViewModel.setWarehouseImg(warehouseViewModelArrayList.get(position).getWarehouseImg());
                warehouseViewModel.setWarehouseAreaCode(warehouseViewModelArrayList.get(position).getWarehouseAreaCode());
                warehouseViewModel.setWarehouseServices(warehouseViewModelArrayList.get(position).getWarehouseServices());
                warehouseViewModel.setWarehouseStatus(warehouseViewModelArrayList.get(position).getWarehouseStatus());
                warehouseViewModel.setWarehouseStatusContainer(warehouseViewModelArrayList.get(position).getWarehouseStatusContainer());
                warehouseViewModel.setWarehouseAddress(warehouseViewModelArrayList.get(position).getWarehouseAddress());

                Intent intentWarehouse = new Intent(context, WarehouseDetailActivity.class);
                intentWarehouse.putExtra(WarehouseDetailActivity.EXTRA_WAREHOUSE, warehouseViewModel);
                context.startActivity(intentWarehouse);
            }
        });
    }

    @Override
    public int getItemCount() {
        return warehouseViewModelArrayList.size();
    }


}
