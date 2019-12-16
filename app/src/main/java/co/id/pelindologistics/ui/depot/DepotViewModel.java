package co.id.pelindologistics.ui.depot;

import android.os.Parcel;
import android.os.Parcelable;

public class DepotViewModel implements Parcelable {
    private String depotName, depotAreaCode, depotMainName, depotAddress, detDepotAVRYORstr, depotStatusContainer, depotCapacity, depotServices, depotPartner, depotFL10T, depotFL7T, depotFL3T, depotRS, depotSL;
    private int depotImg, depotAVRYOR;

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public String getDepotAreaCode() {
        return depotAreaCode;
    }

    public void setDepotAreaCode(String depotAreaCode) {
        this.depotAreaCode = depotAreaCode;
    }

    public String getDepotMainName() {
        return depotMainName;
    }

    public void setDepotMainName(String depotMainName) {
        this.depotMainName = depotMainName;
    }

    public String getDepotAddress() {
        return depotAddress;
    }

    public void setDepotAddress(String depotAddress) {
        this.depotAddress = depotAddress;
    }

    public String getDetDepotAVRYORstr() {
        return detDepotAVRYORstr;
    }

    public void setDetDepotAVRYORstr(String detDepotAVRYORstr) {
        this.detDepotAVRYORstr = detDepotAVRYORstr;
    }

    public String getDepotStatusContainer() {
        return depotStatusContainer;
    }

    public void setDepotStatusContainer(String depotStatusContainer) {
        this.depotStatusContainer = depotStatusContainer;
    }

    public String getDepotCapacity() {
        return depotCapacity;
    }

    public void setDepotCapacity(String depotCapacity) {
        this.depotCapacity = depotCapacity;
    }

    public String getDepotServices() {
        return depotServices;
    }

    public void setDepotServices(String depotServices) {
        this.depotServices = depotServices;
    }

    public String getDepotPartner() {
        return depotPartner;
    }

    public void setDepotPartner(String depotPartner) {
        this.depotPartner = depotPartner;
    }

    public String getDepotFL10T() {
        return depotFL10T;
    }

    public void setDepotFL10T(String depotFL10T) {
        this.depotFL10T = depotFL10T;
    }

    public String getDepotFL7T() {
        return depotFL7T;
    }

    public void setDepotFL7T(String depotFL7T) {
        this.depotFL7T = depotFL7T;
    }

    public String getDepotFL3T() {
        return depotFL3T;
    }

    public void setDepotFL3T(String depotFL3T) {
        this.depotFL3T = depotFL3T;
    }

    public String getDepotRS() {
        return depotRS;
    }

    public void setDepotRS(String depotRS) {
        this.depotRS = depotRS;
    }

    public String getDepotSL() {
        return depotSL;
    }

    public void setDepotSL(String depotSL) {
        this.depotSL = depotSL;
    }

    public int getDepotImg() {
        return depotImg;
    }

    public void setDepotImg(int depotImg) {
        this.depotImg = depotImg;
    }

    public int getDepotAVRYOR() {
        return depotAVRYOR;
    }

    public void setDepotAVRYOR(int depotAVRYOR) {
        this.depotAVRYOR = depotAVRYOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.depotName);
        dest.writeString(this.depotAreaCode);
        dest.writeString(this.depotMainName);
        dest.writeString(this.depotAddress);
        dest.writeString(this.detDepotAVRYORstr);
        dest.writeString(this.depotStatusContainer);
        dest.writeString(this.depotCapacity);
        dest.writeString(this.depotServices);
        dest.writeString(this.depotPartner);
        dest.writeString(this.depotFL10T);
        dest.writeString(this.depotFL7T);
        dest.writeString(this.depotFL3T);
        dest.writeString(this.depotRS);
        dest.writeString(this.depotSL);
        dest.writeInt(this.depotImg);
        dest.writeInt(this.depotAVRYOR);
    }

    public DepotViewModel() {
    }

    protected DepotViewModel(Parcel in) {
        this.depotName = in.readString();
        this.depotAreaCode = in.readString();
        this.depotMainName = in.readString();
        this.depotAddress = in.readString();
        this.detDepotAVRYORstr = in.readString();
        this.depotStatusContainer = in.readString();
        this.depotCapacity = in.readString();
        this.depotServices = in.readString();
        this.depotPartner = in.readString();
        this.depotFL10T = in.readString();
        this.depotFL7T = in.readString();
        this.depotFL3T = in.readString();
        this.depotRS = in.readString();
        this.depotSL = in.readString();
        this.depotImg = in.readInt();
        this.depotAVRYOR = in.readInt();
    }

    public static final Creator<DepotViewModel> CREATOR = new Creator<DepotViewModel>() {
        @Override
        public DepotViewModel createFromParcel(Parcel source) {
            return new DepotViewModel(source);
        }

        @Override
        public DepotViewModel[] newArray(int size) {
            return new DepotViewModel[size];
        }
    };
}