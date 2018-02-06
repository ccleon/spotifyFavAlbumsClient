package cori.spotifyapi_client;

import android.os.Parcel;
import android.os.Parcelable;


public class Album implements Parcelable {

    private int id, calificacion;
    private String name, type, image, opinion;

    public Album (int id, String name, String type, String image){
        this.id = id;
        this.name = name;
        this.type =type;
        this.image= image;

    }


    public Album (int id, String name, String type, String image, String opinion, int calificacion){
        this.id = id;
        this.name = name;
        this.type =type;
        this.image= image;
        this.opinion=opinion;
        this.calificacion = calificacion;

    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    @Override
    public String toString() {
        return  name;
    }


    public Album(Parcel in) {
        readFromParcel(in);
    }



    public void readFromParcel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        type = in.readString();
        image = in.readString();
        opinion = in.readString();
        calificacion = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(image);
        dest.writeString(opinion);
        dest.writeInt(calificacion);
    }

    public static final Parcelable.Creator<Album> CREATOR = new
            Parcelable.Creator<Album>() {
                public Album createFromParcel(Parcel in) {
                    return new Album(in);
                }

                public Album[] newArray(int size) {
                    return new Album[size];
                }
            };

}
