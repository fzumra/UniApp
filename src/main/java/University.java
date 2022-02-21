import com.google.gson.annotations.SerializedName;

import java.util.List;

public class University {
    @SerializedName("country")
    public String country;

    @SerializedName("web_pages")
    public List<String> webPages;

    @SerializedName("name")
    public String name;

    @Override
    public String toString() {
        return "University{" +
                "country='" + country + '\'' +
                ", webPages=" + webPages +
                ", name='" + name + '\'' +
                '}';
    }
}
