package test.couch.instafit.com.couchcatalog.data;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "Coaches")
public class Coach {

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

    public Coach(@NonNull Integer id, String name, String description, Boolean filterAvailable, String avatar, AvatarPictures avatarPictures) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.filterAvailable = filterAvailable;
        this.avatar = avatar;
        this.avatarPictures = avatarPictures;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "coachId")
    @SerializedName("id")
    @Expose
    private Integer id;

    @Nullable
    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    private String name;

    @Nullable
    @ColumnInfo(name = "description")
    @SerializedName("description")
    @Expose
    private String description;

    @Nullable
    @ColumnInfo(name = "filter_available")
    @SerializedName("filter_available")
    @Expose
    private Boolean filterAvailable;

    @Nullable
    @ColumnInfo(name = "avatar")
    @SerializedName("avatar")
    @Expose
    private String avatar;

    @Embedded
    @SerializedName("avatar_pictures")
    @Expose
    private AvatarPictures avatarPictures;

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Nullable
    public Boolean getFilterAvailable() {
        return filterAvailable;
    }

    public void setFilterAvailable(Boolean filterAvailable) {
        this.filterAvailable = filterAvailable;
    }

    @Nullable
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public AvatarPictures getAvatarPictures() {
        return avatarPictures;
    }

    public void setAvatarPictures(AvatarPictures avatarPictures) {
        this.avatarPictures = avatarPictures;
    }
}
