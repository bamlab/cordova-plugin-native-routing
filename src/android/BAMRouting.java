package fr.bamlab.routing;

import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class BAMRouting extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("go")) {
            String withData = data.getString(1);
            String activityName = data.getString(2);

            Context context = this.cordova.getActivity().getApplicationContext();

            try {
                Class c = Class.forName(activityName);
                Intent intent=new Intent(context, c);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("withData", withData);
                context.startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return true;

        } else {

            return false;

        }
    }
}
