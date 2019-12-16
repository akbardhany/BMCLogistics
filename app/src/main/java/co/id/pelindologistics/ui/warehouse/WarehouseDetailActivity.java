package co.id.pelindologistics.ui.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import co.id.pelindologistics.R;

public class WarehouseDetailActivity extends AppCompatActivity {
    TextView detWarehouseName, detWarehouseArea, detWarehouseStatus, detWarehouseStatusContainer, detWarehouseServices, detWarehouseAddress;
    ImageView detWarehouseImg;
    public static final String EXTRA_WAREHOUSE = "extra_warehouse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse_detail);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

        detWarehouseArea = findViewById(R.id.txt_detailWarehouseCodeArea);
        detWarehouseImg = findViewById(R.id.iv_detailWarehouseImg);
        detWarehouseName = findViewById(R.id.txt_detailWarehouseName);
        detWarehouseServices = findViewById(R.id.txt_detailWarehouseServices);
        detWarehouseStatus = findViewById(R.id.txt_detailWarehouseStatus);
        detWarehouseStatusContainer = findViewById(R.id.txt_detailWarehouseStatusContainer);
        detWarehouseAddress = findViewById(R.id.txt_detailWarehouseAddress);

        WarehouseViewModel warehouseViewModel = getIntent().getParcelableExtra(EXTRA_WAREHOUSE);
        detWarehouseArea.setText(warehouseViewModel.getWarehouseAreaCode());
        detWarehouseImg.setImageResource(warehouseViewModel.getWarehouseImg());
        detWarehouseName.setText(warehouseViewModel.getWarehouseName());
        detWarehouseServices.setText(warehouseViewModel.getWarehouseServices());
        detWarehouseStatus.setText(warehouseViewModel.getWarehouseStatus());
        detWarehouseStatusContainer.setText(warehouseViewModel.getWarehouseStatusContainer());
        detWarehouseAddress.setText(warehouseViewModel.getWarehouseAddress());

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
