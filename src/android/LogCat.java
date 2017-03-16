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
			
				JSONObject params = args.getJSONObject(0);
				
				zLabsLogProcessor logProc = new zLabsLogProcessor();
				
				String log = logProc.exportLogsString((String)params.get("logcat"));
				
				if ((Boolean)params.get("compress")) {
					callbackContext.success(log);
				} else {
					JSONObject compressed = logProc.exportADBLogsJSON(true);
					callbackContext.success((String)compressed.get("Log"));
				}
				
				return true;
	    }
        else{
			return false;
		}
      }
}