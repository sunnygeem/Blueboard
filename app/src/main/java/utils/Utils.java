package utils;

import android.content.Context;
import android.widget.Toast;

public class Utils implements Utilities {
    public static void toastTest(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
