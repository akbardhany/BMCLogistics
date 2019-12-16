package co.id.pelindologistics.ui.warehouse;

import android.os.Parcel;
import android.os.Parcelable;

public class WarehouseViewModel implements Parcelable {

    private String warehouseName, warehouseAreaCode, warehouseStatus, warehouseStatusContainer, warehouseServices, warehouseAddress;
    private int warehouseImg;

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseAreaCode() {
        return warehouseAreaCode;
    }

    public void setWarehouseAreaCode(String warehouseAreaCode) {
        this.warehouseAreaCode = warehouseAreaCode;
    }

    public String getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(String warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    public String getWarehouseStatusContainer() {
        return warehouseStatusContainer;
    }

    public void setWarehouseStatusContainer(String warehouseStatusContainer) {
        this.warehouseStatusContainer = warehouseStatusContainer;
    }

    public String getWarehouseServices() {
        return warehouseServices;
    }

    public void setWarehouseServices(String warehouseServices) {
        this.warehouseServices = warehouseServices;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public int getWarehouseImg() {
        return warehouseImg;
    }

    public void setWarehouseImg(int warehouseImg) {
        this.warehouseImg = warehouseImg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.warehouseName);
        dest.writeString(this.warehouseAreaCode);
        dest.writeString(this.warehouseStatus);
        dest.writeString(this.warehouseStatusContainer);
        dest.writeString(this.warehouseServices);
        dest.writeString(this.warehouseAddress);
        dest.writeInt(this.warehouseImg);
    }

    public WarehouseViewModel() {
    }

    protected WarehouseViewModel(Parcel in) {
        this.warehouseName = in.readString();
        this.warehouseAreaCode = in.readString();
        this.warehouseStatus = in.readString();
        this.warehouseStatusContainer = in.readString();
        this.warehouseServices = in.readString();
        this.warehouseAddress = in.readString();
        this.warehouseImg = in.readInt();
    }

    public static final Creator<WarehouseViewModel> CREATOR = new Creator<WarehouseViewModel>() {
        @Override
        public WarehouseViewModel createFromParcel(Parcel source) {
            return new WarehouseViewModel(source);
        }

        @Override
        public WarehouseViewModel[] newArray(int size) {
            return new WarehouseViewModel[size];
        }
    };
}