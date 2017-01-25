package ua.i4igo.tracker;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Android on 12.01.2017.
 */

public interface Constants {

    String KEY_LOGIN = "login";
    String KEY_PASSWORD = "password";


    String KEY_USER_PHOTO = "photo";
    String KEY_USER_PHONE = "phone";
    String KEY_USER_PASSWORD = "password";
    String KEY_USER_CONFIRM_PASSWORD = "confPassword";
    String KEY_USER_NAME = "name";
    String KEY_USER_LAST_NAME = "lName";
    String KEY_USER_EMAIL = "eMail";
    String KEY_USER_CITY = "city";

    String FILE_SAVE = "pref_user";

    LatLng KYIV = new LatLng(50.4501, 30.5234);
}
