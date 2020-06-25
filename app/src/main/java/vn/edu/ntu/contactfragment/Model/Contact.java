package vn.edu.ntu.contactfragment.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Contact")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    int ID;
    @NonNull
    String Name;
    @NonNull
    String PhoneNumber;
    @NonNull
    String Address;

    public Contact() {
    }

    public Contact(int ID, @NonNull String name, @NonNull String phoneNumber, @NonNull String address) {
        this.ID = ID;
        Name = name;
        PhoneNumber = phoneNumber;
        Address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @NonNull
    public String getName() {
        return Name;
    }

    public void setName(@NonNull String name) {
        Name = name;
    }

    @NonNull
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(@NonNull String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @NonNull
    public String getAddress() {
        return Address;
    }

    public void setAddress(@NonNull String address) {
        Address = address;
    }
}
