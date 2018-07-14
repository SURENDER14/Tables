package e.sura23.tables2;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;

import static android.support.v4.content.ContextCompat.getColor;


/**
 * Created by SURA23 on 7/14/2018.
 */

public class GetPreferedColor {


    public static int setColor(Context context, String colorFromPreference) {
        switch (colorFromPreference) {
            case "red":
                return ContextCompat.getColor (context, R.color.red);
            case "blue":
                return ContextCompat.getColor (context, R.color.blue);
            case "green":
                return ContextCompat.getColor (context, R.color.green);

            default:
                return ContextCompat.getColor (context, R.color.holoGreen);
        }

    }
}

