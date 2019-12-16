package co.id.pelindologistics.ui.depot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import co.id.pelindologistics.R;

public class DepotDetailActivity extends AppCompatActivity {
    TextView detDepotMainName, detDepotStatusContainer, detDepotAddress, detDepotCapacity, detDepotAVRYORstr, detDepotServices, detDepotPartner, detDepotFL10T, detDepotFL7T, detDepotFL3T, detDepotRS, detDepotSL;
    ImageView detDepotImg;
    ProgressBar detDepotAVRYOR;
    public static final String EXTRA_DEPOT = "extra_depot";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depot_detail);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

//        detDepotAreaCode = findViewById(R.id.txt_detailDepotAreaCode);
        detDepotAVRYOR = findViewById(R.id.pb_detailDepotAVRYOR);
        detDepotCapacity = findViewById(R.id.txt_detailDepotCapacity);
        detDepotFL3T = findViewById(R.id.txt_detailDepotFL3T);
        detDepotFL7T = findViewById(R.id.txt_detailDepotFL7T);
        detDepotFL10T = findViewById(R.id.txt_detailDepotFL10T);
        detDepotImg = findViewById(R.id.iv_detailDepotImg);
        detDepotMainName = findViewById(R.id.txt_detailDepotMainName);
        detDepotPartner = findViewById(R.id.txt_detailDepotPartner);
        detDepotRS = findViewById(R.id.txt_detailDepotRS);
        detDepotServices = findViewById(R.id.txt_detailDepotServices);
        detDepotSL = findViewById(R.id.txt_detailDepotSL);
        detDepotStatusContainer = findViewById(R.id.txt_detailDepotStatusContainer);
        detDepotAVRYORstr = findViewById(R.id.tv_detailDepotAVRYORstr);
        detDepotAddress = findViewById(R.id.txt_detailDepotAddress);

        DepotViewModel depotViewModel = getIntent().getParcelableExtra(EXTRA_DEPOT);
  //      detDepotAreaCode.setText(depotViewModel.getDepotAreaCode());
        detDepotAVRYOR.setProgress(depotViewModel.getDepotAVRYOR());
        detDepotCapacity.setText(depotViewModel.getDepotCapacity());
        detDepotFL3T.setText(depotViewModel.getDepotFL3T());
        detDepotFL7T.setText(depotViewModel.getDepotFL7T());
        detDepotFL10T.setText(depotViewModel.getDepotFL10T());
        detDepotImg.setImageResource(depotViewModel.getDepotImg());
        detDepotMainName.setText(depotViewModel.getDepotMainName());
        detDepotPartner.setText(depotViewModel.getDepotPartner());
        detDepotRS.setText(depotViewModel.getDepotRS());
        detDepotServices.setText(depotViewModel.getDepotServices());
        detDepotSL.setText(depotViewModel.getDepotSL());
        detDepotStatusContainer.setText(depotViewModel.getDepotStatusContainer());
        detDepotAVRYORstr.setText(depotViewModel.getDetDepotAVRYORstr());
        detDepotAddress.setText(depotViewModel.getDepotAddress());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if(hasFocus) {
            enableImmersiveMode();
        }
    }

    protected void enableImmersiveMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }
    }
}
