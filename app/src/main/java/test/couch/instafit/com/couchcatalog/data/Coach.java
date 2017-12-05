package test.couch.instafit.com.couchcatalog.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("filter_available")
    @Expose
    private Boolean filterAvailable;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("avatar_pictures")
    @Expose
    private AvatarPictures avatarPictures;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFilterAvailable() {
        return filterAvailable;
    }

    public void setFilterAvailable(Boolean filterAvailable) {
        this.filterAvailable = filterAvailable;
    }

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
