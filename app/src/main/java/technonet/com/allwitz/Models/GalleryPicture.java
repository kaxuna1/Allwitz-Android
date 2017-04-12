package technonet.com.allwitz.Models;

/**
 * Created by vakhtanggelashvili on 4/12/17.
 */

public class GalleryPicture {
    public GalleryPicture() {
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    private long id;

    private String name;

    private String extension;
}
