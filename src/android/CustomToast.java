package org.apache.cordova.toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

/**
 * Created by Alex on 2017/5/6.
 *
 */

public class CustomToast extends CordovaPlugin {  
    private static final String TAG = "Toast";
     @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Context context = this.cordova.getActivity().getApplicationContext();

    }
    @Override  
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {  
        Activity activity = cordova.getActivity();

        if("javaShow".equals(action)) {
            Toast.makeText(activity, "java show...", Toast.LENGTH_SHORT).show();

        } else if("javaShowJs".equals(action)) {
            String str = args.getString(0);
            int lenth = args.getInt(1);

            if (lenth == 1) {
                Toast.makeText(activity, "::" + str, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(activity, "::" + str, Toast.LENGTH_SHORT).show();
            }

        } else if("jsShowJava".equals(action)) {
            int a = 4, b = 5;
            if (a > b) {
                callbackContext.success("sucsucsuc" + a);
            } else {
                callbackContext.error("errerrerr" + b);
            }
            return true;

        } else if("jsShowJs".equals(action)) {
            String text = args.getString(0);
            if (!(text.equals(""))) {
                callbackContext.success("js'text: " + text);
            } else {
                callbackContext.error("errjsjs");
            }
            return true;

        } else if("openVideo".equals(action)) {
            openVideo(args.getString(0));
        }

        callbackContext.success();  
        return true;  
    }

    private void openVideo(String text){
        String url = text;
        String extension = MimeTypeMap.getFileExtensionFromUrl(url);  
        String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);  
        Intent mediaIntent = new Intent(Intent.ACTION_VIEW);  
        mediaIntent.setDataAndType(Uri.parse(url), mimeType);  
        //startActivity(mediaIntent); 
        cordova.startActivityForResult((CordovaPlugin) this, mediaIntent, 200);
    }   
}