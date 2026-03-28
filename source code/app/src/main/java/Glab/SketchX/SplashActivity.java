package Glab.SketchX;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.caverock.androidsvg.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import android.content.pm.PackageInfo;
import android.provider.Settings;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.elevation.SurfaceColors;

public class SplashActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String path = "";
	
	private LinearLayout linear1;
	private TextView textview1;
	
	private TimerTask sa;
	private Intent xhb = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.splash);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		textview1 = findViewById(R.id.textview1);
	}
	
	private void initializeLogic() {
		//Blocks.Made by Grafix Lab
		textview1.animate()
		.alpha(1f)
		.scaleX((float)1)
		.scaleY((float)1)
		.setInterpolator(new OvershootInterpolator(4f))
		.setDuration((long)800);
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { // Android 11+
			if (!Environment.isExternalStorageManager()) {
				// Redirect to settings
				Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
				intent.setData(Uri.parse("package:" + getPackageName()));
				startActivityForResult(intent, 1000);
			} else {
				_go(); // Permission granted
			}
		} else {
			// Android < 11
			if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == 
			android.content.pm.PackageManager.PERMISSION_DENIED) {
				requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
			} else {
				_go();
			}
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		if (_requestCode == 1000) { 
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
				if (Environment.isExternalStorageManager()) {
					_go(); // Ensure transition happens after returning from settings
				}
			}
		}
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _go() {
		sa = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(() -> {
					path = FileUtil.getPackageDataDir(getApplicationContext()).concat("/SketchX/");
					if (!FileUtil.isExistFile(path.concat("svg.zip"))) xhb.setClass(getApplicationContext(), ProgressActivity.class); else xhb.setClass(getApplicationContext(), MainActivity.class);
					startActivity(xhb);
					finish();
				});
			}
		};
		_timer.schedule(sa, 2000);
	}
	
	
	public void _REPLACEMENT() {
		
	}
	
}