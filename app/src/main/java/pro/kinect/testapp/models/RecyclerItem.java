package pro.kinect.testapp.models;

/**
 * Created by Arina on 03.10.2017
 */

public class RecyclerItem {

    public enum Type{
        TypeText,
        TypePicture
    }

    private String data;
    private Type type;

    public RecyclerItem(String data, Type type) {
        this.data = data;
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public Type getType() {
        return type;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
