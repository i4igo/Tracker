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

    public String getName() {
        return name;
    }

    public String getlName() {
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

    public String geteMail() {
        return eMail;
    }

    public String getCity() {
        return city;
    }

    /**
     * сохраняем в preferences данные
     *
         preferences = getSharedPreferences(Constants.FILE_SAVE, MODE_PRIVATE);
         SharedPreferences.Editor editor = preferences.edit()
             .putString(Constants.KEY_USER_PHONE, etRPhone.getText().toString())
             .putString(Constants.KEY_USER_PASSWORD, etRPassword.getText().toString())
             .putString(Constants.KEY_USER_CONFIRM_PASSWORD, etRConfirmPass.getText().toString())
             .putString(Constants.KEY_USER_NAME, etRName.getText().toString())
             .putString(Constants.KEY_USER_LAST_NAME, etRLName.getText().toString())
             .putString(Constants.KEY_USER_EMAIL, etREMail.getText().toString())
             .putString(Constants.KEY_USER_CITY, etRCity.getText().toString())
             .commit()

     */
    public void saveInPreferencesUser(String string) {

    }

    public void saveName(String name) {
        this.name = name;
        saveInPreferencesUser(name);
    }



    public void savelName(String lName) {
        this.lName = lName;

    }

    public void savePassword(String password) {
        this.password = password;

    }

    public void saveConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;

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