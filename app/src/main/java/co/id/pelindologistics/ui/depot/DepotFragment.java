package co.id.pelindologistics.ui.depot;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.id.pelindologistics.R;

public class DepotFragment extends Fragment {
    private String[] dataDepotName;
    private String[] dataDepotCodeArea;
    private String[] dataDepotMainName;
    private String[] dataDepotStatusContainer;
    private String[] dataDepotCapacity;
    private int[] dataDepotAVRYOR;
    private String[] dataDepotAVRYORstr;
    private String[] dataDepotServices;
    private String[] dataDepotPartner;
    private String[] dataDepotFL10T;
    private String[] dataDepotFL7T;
    private String[] dataDepotFL3T;
    private String[] dataDepotRS;
    private String[] dataDepotSL;
    private String[] dataDepotAdr;
    private TypedArray  dataDepotImg;
    private RecyclerView rv_depots;

    public DepotFragment(){
        //required
    }
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_depot, container, false);
        rv_depots = root.findViewById(R.id.rv_depots);
        rv_depots.setHasFixedSize(true);
        prepare();
        showRecyclerList();
        return root;
    }
    private void prepare(){
        dataDepotName = getResources().getStringArray(R.array.depotName);
        dataDepotCodeArea = getResources().getStringArray(R.array.depotAreaCode);
        dataDepotImg = getResources().obtainTypedArray(R.array.depotImg);
        dataDepotAVRYOR = getResources().getIntArray(R.array.depotAVRYOR);
        dataDepotCapacity = getResources().getStringArray(R.array.depotCapacity);
        dataDepotFL3T = getResources().getStringArray(R.array.depotForklift3T);
        dataDepotFL7T = getResources().getStringArray(R.array.depotForklift7T);
        dataDepotFL10T = getResources().getStringArray(R.array.depotForklift10T);
        dataDepotMainName = getResources().getStringArray(R.array.depotMainName);
        dataDepotPartner = getResources().getStringArray(R.array.depotPartner);
        dataDepotRS = getResources().getStringArray(R.array.depotReachStacker);
        dataDepotServices = getResources().getStringArray(R.array.depotServices);
        dataDepotSL = getResources().getStringArray(R.array.depotSideLoader);
        dataDepotStatusContainer = getResources().getStringArray(R.array.depotStatusContainer);
        dataDepotAVRYORstr = getResources().getStringArray(R.array.depotAVRYORstr);
        dataDepotAdr = getResources().getStringArray(R.array.depotAddress);
    }
    private void showRecyclerList(){
        ArrayList<DepotViewModel> depotViewModelArrayList = new ArrayList<>();
        for (int i = 0; i < dataDepotName.length; i++){
            DepotViewModel depotViewModel = new DepotViewModel();
            depotViewModel.setDepotName(dataDepotName[i]);
            depotViewModel.setDepotAreaCode(dataDepotCodeArea[i]);
            depotViewModel.setDepotImg(dataDepotImg.getResourceId(i, -1));
            depotViewModel.setDepotAVRYOR(dataDepotAVRYOR[i]);
            depotViewModel.setDepotCapacity(dataDepotCapacity[i]);
            depotViewModel.setDepotFL3T(dataDepotFL3T[i]);
            depotViewModel.setDepotFL7T(dataDepotFL7T[i]);
            depotViewModel.setDepotFL10T(dataDepotFL10T[i]);
            depotViewModel.setDepotMainName(dataDepotMainName[i]);
            depotViewModel.setDepotPartner(dataDepotPartner[i]);
            depotViewModel.setDepotRS(dataDepotRS[i]);
            depotViewModel.setDepotServices(dataDepotServices[i]);
            depotViewModel.setDepotSL(dataDepotSL[i]);
            depotViewModel.setDepotStatusContainer(dataDepotStatusContainer[i]);
            depotViewModel.setDetDepotAVRYORstr(dataDepotAVRYORstr[i]);
            depotViewModel.setDepotAddress(dataDepotAdr[i]);

            depotViewModelArrayList.add(depotViewModel);
        }
        rv_depots.setLayoutManager(new LinearLayoutManager(getActivity()));
        DepotAdapter depotAdapter = new DepotAdapter(getActivity(), depotViewModelArrayList);
        rv_depots.setAdapter(depotAdapter);
    }
}