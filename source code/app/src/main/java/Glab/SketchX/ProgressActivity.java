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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.caverock.androidsvg.*;
import com.google.android.material.card.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.EdgeToEdge;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.elevation.SurfaceColors;

public class ProgressActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String path = "";
	private String ZipPath = "";
	
	private LinearLayout linear1;
	private LinearLayout linear_base;
	private LinearLayout linear32;
	private TextView textview14;
	private TextView textview15;
	private CardView cardview2;
	private LinearLayout linear33;
	private TextView textview12;
	private TextView progressFileNameText;
	private MaterialCardView materialcardview1;
	private LinearLayout linear13;
	private LinearLayout linear12;
	private ProgressBar progressBar;
	private TextView progressItemText;
	private TextView progressText;
	private TextView progressSizeText;
	private LinearLayout aCBg;
	private LinearLayout mainAcBg;
	private LinearLayout linear23;
	private TextView UpdateNote;
	private LinearLayout linear28;
	private LinearLayout linear31;
	private TextView textview22;
	private ImageView imageview1;
	private TextView UpdatenoteHead;
	private ImageView imageview2;
	private TextView textview20;
	
	private Intent x = new Intent();
	private TimerTask t;
	
private final BroadcastReceiver zipProgressReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        int progress = intent.getIntExtra("progress", 0);
        String fileName = intent.getStringExtra("fileName");
        String sizeText = intent.getStringExtra("sizeText");
        String itemText = intent.getStringExtra("itemText");

        progressBar.setProgress(progress);
        progressFileNameText.setText("Extracting: " + fileName);

progressText.setText(progress + "%");
        progressSizeText.setText(sizeText);
        progressItemText.setText(itemText);

if (progress == 100) {
finish();
}

    }
};


	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.progress);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);} else {
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
		linear_base = findViewById(R.id.linear_base);
		linear32 = findViewById(R.id.linear32);
		textview14 = findViewById(R.id.textview14);
		textview15 = findViewById(R.id.textview15);
		cardview2 = findViewById(R.id.cardview2);
		linear33 = findViewById(R.id.linear33);
		textview12 = findViewById(R.id.textview12);
		progressFileNameText = findViewById(R.id.progressFileNameText);
		materialcardview1 = findViewById(R.id.materialcardview1);
		linear13 = findViewById(R.id.linear13);
		linear12 = findViewById(R.id.linear12);
		progressBar = findViewById(R.id.progressBar);
		progressItemText = findViewById(R.id.progressItemText);
		progressText = findViewById(R.id.progressText);
		progressSizeText = findViewById(R.id.progressSizeText);
		aCBg = findViewById(R.id.aCBg);
		mainAcBg = findViewById(R.id.mainAcBg);
		linear23 = findViewById(R.id.linear23);
		UpdateNote = findViewById(R.id.UpdateNote);
		linear28 = findViewById(R.id.linear28);
		linear31 = findViewById(R.id.linear31);
		textview22 = findViewById(R.id.textview22);
		imageview1 = findViewById(R.id.imageview1);
		UpdatenoteHead = findViewById(R.id.UpdatenoteHead);
		imageview2 = findViewById(R.id.imageview2);
		textview20 = findViewById(R.id.textview20);
	}
	
	private void initializeLogic() {
		path = FileUtil.getPackageDataDir(getApplicationContext()).concat("/SketchX/");
		FileUtil.makeDir(path);
		ZipPath = path.concat("svg.zip");
		try {
			int count;
			java.io.InputStream input = ProgressActivity.this.getAssets().open("svg.zip");
			java.io.OutputStream output = new java.io.FileOutputStream(path + "svg.zip");
			byte data[] = new byte[1024];
			
			while ((count = input.read(data)) > 0) {
				output.write(data, 0, count);
			}
			
			output.flush();
			output.close();
			input.close();
			
			// Once the file operation completes, execute the following
			getSharedPreferences("MyPrefs", MODE_PRIVATE).edit().clear().apply();
			
			Intent serviceIntent = new Intent(this, ZipCompressService.class);
			serviceIntent.putExtra("zipPath", ZipPath);
			serviceIntent.putExtra("password", "23@freee");
			serviceIntent.putExtra("destPath", path);
			
			startService(serviceIntent);
			textview12.setText("Started");
			
		} catch (Exception e) {
			e.printStackTrace(); // Helps in debugging if an error occurs
		}
		_FileOperationTask();
		EdgeToEdge.enable(this);
		ViewCompat.setOnApplyWindowInsetsListener(linear1, (v, insets) -> {
			androidx.core.graphics.Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
			return insets;
		});
	}
	
	@Override
	public void onBackPressed() {
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
		LocalBroadcastManager.getInstance(this).registerReceiver(zipProgressReceiver,
		new IntentFilter(ZipCompressService.BROADCAST_ACTION));
	}
	
	@Override
	public void onPause() {
		super.onPause();
		LocalBroadcastManager.getInstance(this).unregisterReceiver(zipProgressReceiver);
	}
	
	public void _FileOperationTask() {
	}
	
	
	public void _REPLACEMENT() {
		
	}
	
}