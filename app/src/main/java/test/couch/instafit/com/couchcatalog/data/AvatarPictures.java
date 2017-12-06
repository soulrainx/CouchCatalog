package test.couch.instafit.com.couchcatalog.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvatarPictures {


    public AvatarPictures(String fullSize, String big, String medium, String small) {
        this.fullSize = fullSize;
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
/*
     *  Room Annotation
     *  @PrimaryKey
     *  @NonNull
     *  @ColumnInfo
     *  @Embedded
     *
     *  Gson
     *  @SerializedName
     *  @Expose
     */

    @SerializedName("full_size")
    @Expose
    private String fullSize;

    @SerializedName("big")
    @Expose
    private String big;

    @SerializedName("medium")
    @Expose
    private String medium;

    @SerializedName("small")
    @Expose
    private String small;

    public String getFullSize() {
        return fullSize;
    }

    public void setFullSize(String fullSize) {
        this.fullSize = fullSize;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

}
