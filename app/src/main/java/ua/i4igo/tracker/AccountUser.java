package ua.i4igo.tracker;

import android.content.SharedPreferences;

/**
 * Created by Android on 12.01.2017.
 */

public class AccountUser {

    private String name;
    private String lName;
    private String password;
    private String confirmPassword;
    private String phone;
    private String eMail;
    private String city;

    private SharedPreferences preferences;

    public AccountUser(String phone, String password, String confirmPassword, String name, String lName, String eMail, String city) {
        this.phone = phone;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.name = name;
        this.lName = lName;
        this.eMail = eMail;
        this.city = city;
    }

    // методы полученния данных обьекта AccountUser
    public String getName() {
        return name;
    }

    public String getLName() {
        return lName;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPhone() {
        return phone;
    }

    public String getEMail() {
        return eMail;
    }

    public String getCity() {
        return city;
    }

    // методы сохранения данных в SharedPreferences
    public void saveName(String name) {
        this.name = name;
        //saveInPreferencesUser(name);
        preferences.edit().putString(Constants.KEY_USER_NAME, name).apply();
    }

    public void saveLName(String lName) {
        this.lName = lName;
        preferences.edit().putString(Constants.KEY_USER_LAST_NAME, lName).apply();

    }

    public void savePassword(String password) {
        this.password = password;
        preferences.edit().putString(Constants.KEY_USER_PASSWORD, password).apply();
    }

    public void saveConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        preferences.edit().putString(Constants.KEY_USER_CONFIRM_PASSWORD, confirmPassword).apply();
    }

    public void savePhone(String phone) {
        this.phone = phone;
        preferences.edit().putString(Constants.KEY_USER_PHONE, phone).apply();
    }

    public void saveEMail(String eMail) {
        this.eMail = eMail;
        preferences.edit().putString(Constants.KEY_USER_EMAIL, eMail).apply();
    }

    public void saveCity(String city) {
        this.city = city;
        preferences.edit().putString(Constants.KEY_USER_CITY, city).apply();
    }
}

///data/data/имя_пакета/shared_prefs/имя_файла_настроек.xml.