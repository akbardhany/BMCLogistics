package co.id.pelindologistics.ui.warehouse;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.id.pelindologistics.R;

public class WarehouseFragment extends Fragment {
    private String[] dataWarehouseName;
    private String[] dataWarehouseArea;
    private String[] dataWarehouseStatus;
    private String[] dataWarehouseStatusContainer;
    private String[] dataWarehouseServices;
    private String[] dataWarehouseAddress;
    private TypedArray dataWarehouseImg;
    private RecyclerView rv_warehouse;

    public WarehouseFragment(){
        //required
    }

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_warehouse, container, false);
        rv_warehouse = root.findViewById(R.id.rv_warehouse);
        rv_warehouse.setHasFixedSize(true);
        prepare();
        showRecyclerList();
        return root;
    }

    private void prepare(){
        dataWarehouseName = getResources().getStringArray(R.array.warehouseName);
        dataWarehouseArea = getResources().getStringArray(R.array.warehouseAreaCode);
        dataWarehouseImg = getResources().obtainTypedArray(R.array.warehouseImg);
        dataWarehouseServices = getResources().getStringArray(R.array.warehouseServices);
        dataWarehouseStatus = getResources().getStringArray(R.array.warehouseStatus);
        dataWarehouseStatusContainer = getResources().getStringArray(R.array.warehouseStatusContainer);
        dataWarehouseAddress = getResources().getStringArray(R.array.warehouseAddress);
    }

    private void showRecyclerList(){
        ArrayList<WarehouseViewModel> warehouseViewModelArrayList = new ArrayList<>();

        for (int i = 0; i < dataWarehouseName.length; i++){
            WarehouseViewModel warehouseViewModel = new WarehouseViewModel();
            warehouseViewModel.setWarehouseName(dataWarehouseName[i]);
            warehouseViewModel.setWarehouseAreaCode(dataWarehouseArea[i]);
            warehouseViewModel.setWarehouseImg(dataWarehouseImg.getResourceId(i, -1));
            warehouseViewModel.setWarehouseServices(dataWarehouseServices[i]);
            warehouseViewModel.setWarehouseStatus(dataWarehouseStatus[i]);
            warehouseViewModel.setWarehouseStatusContainer(dataWarehouseStatusContainer[i]);
            warehouseViewModel.setWarehouseAddress(dataWarehouseAddress[i]);

            warehouseViewModelArrayList.add(warehouseViewModel);
        }

        rv_warehouse.setLayoutManager(new LinearLayoutManager(getActivity()));
        WarehouseAdapter warehouseAdapter = new WarehouseAdapter(getActivity(), warehouseViewModelArrayList);
        rv_warehouse.setAdapter(warehouseAdapter);
    }
}