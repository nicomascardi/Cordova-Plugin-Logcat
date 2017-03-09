package org.apache.cordova.logcat;
import java.io.File;
import java.io.IOException;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Environment;
import zLabsLogProcessor.*;

public class LogCat extends CordovaPlugin {
	protected void pluginInitialize() {
	  }

	  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) 
	      throws JSONException {
	    if (action.equals("sendLogs")) {
			
				zLabsLogProcessor logProc = new zLabsLogProcessor();
				logProc.exportLogsString();
				
				JSONObject json1 = args.getJSONObject(0);
								
                // save logcat in file	
                File outputFile = new File(Environment.getExternalStorageDirectory(),"logcat.txt");
                try {
                    Runtime.getRuntime().exec(
                            json1.get("logcat") + " " + outputFile.getAbsolutePath());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
             return true;
	    }
          else{        
	    return false;
	  }
      }
}