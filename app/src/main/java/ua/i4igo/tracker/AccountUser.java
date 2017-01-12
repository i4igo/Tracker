package ua.i4igo.tracker;

import android.content.SharedPreferences;

/**
 * Created by Android on 12.01.2017.
 */

public class AccountUser {

    private String name;
    private String lName;
    private String photo;
    private String phone;
    private String eMail;
    private String city;
    private SharedPreferences preferences;

    public AccountUser(String name, String lName, String photo, String phone, String eMail, String city) {
        this.name = name;
        this.lName = lName;
        this.photo = photo;
        this.phone = phone;
        this.eMail = eMail;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getlName() {
        return lName;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPhone() {
        return phone;
    }

    public String geteMail() {
        return eMail;
    }

    public String getCity() {
        return city;
    }

    /**
     * сохраняем в preferences данные
     */
    public void saveName(String name) {
        this.name = name;
    }

    public void savelName(String lName) {
        this.lName = lName;

    }

    public void savePhoto(String photo) {
        this.photo = photo;

    }

    public void savePhone(String phone) {
        this.phone = phone;

    }

    public void saveMail(String eMail) {
        this.eMail = eMail;

    }

    public void saveCity(String city) {
        this.city = city;

    }

}
