package Glab.SketchX;

import android.app.Service; import android.content.Intent; import android.os.IBinder; public class ZipCompressService extends Service { public static final String BROADCAST_ACTION = "zip_progress"; @Override public IBinder onBind(Intent intent) { return null; } }