package Glab.SketchX;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.caverock.androidsvg.*;
import com.google.android.material.card.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class ProjectDialogFragmentActivity extends DialogFragment {
	
	private HashMap<String, Object> temp_map1 = new HashMap<>();
	private double number = 0;
	private String temp_decrypted = "";
	
	private ArrayList<String> temp_str1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> temp_listmap1 = new ArrayList<>();
	
	private MaterialCardView cardview1;
	private LinearLayout linear1;
	private TextView textview2;
	private RecyclerView recyclerview1;
	private Button button1;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.project_dialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		cardview1 = _view.findViewById(R.id.cardview1);
		linear1 = _view.findViewById(R.id.linear1);
		textview2 = _view.findViewById(R.id.textview2);
		recyclerview1 = _view.findViewById(R.id.recyclerview1);
		button1 = _view.findViewById(R.id.button1);
		
		button1.setOnClickListener(_v -> dismiss());
	}
	
	private void initializeLogic() {
		_Load_Projects();
		recyclerview1.setAdapter(new Recyclerview1Adapter(temp_listmap1));
		recyclerview1.setLayoutManager(new LinearLayoutManager(getContext()));
	}
	
	@Override
	public void onStart() {
		super.onStart();
		Dialog dialog = getDialog();
		if (dialog != null && dialog.getWindow() != null) {
			// Убираем отступы 
			dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // Прозрачный фон
			
			WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
			params.width = WindowManager.LayoutParams.MATCH_PARENT;
			params.height = WindowManager.LayoutParams.WRAP_CONTENT;
			params.gravity = Gravity.BOTTOM;
			
			dialog.getWindow().setAttributes(params);
		}
	}
	public void _Load_Projects() {
		temp_str1.clear();
		temp_listmap1.clear();
		temp_map1.clear();
		FileUtil.listDir(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list/"), temp_str1);
		Collections.sort(temp_str1, String.CASE_INSENSITIVE_ORDER);
		number = 0;
		for(int _repeat18 = 0; _repeat18 < (int)(temp_str1.size()); _repeat18++) {
			if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list/".concat(Uri.parse(temp_str1.get((int)(number))).getLastPathSegment().concat("/project"))))) {
				try {
					javax.crypto.Cipher instance = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
					byte[] bytes = "sketchwaresecure".getBytes();
					instance.init(2, new javax.crypto.spec.SecretKeySpec(bytes, "AES"), new javax.crypto.spec.IvParameterSpec(bytes));
					java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list/".concat(Uri.parse(temp_str1.get((int)(number))).getLastPathSegment().concat("/project"))), "r");
					byte[] bArr = new byte[((int) randomAccessFile.length())];
					randomAccessFile.readFully(bArr);
					temp_decrypted = new String(instance.doFinal(bArr));
					temp_map1 = new HashMap<>();
					temp_map1 = new Gson().fromJson(temp_decrypted, new TypeToken<HashMap<String, Object>>(){}.getType());
					temp_listmap1.add(temp_map1);
				} catch(Exception e) {
					
				}
			}
			number++;
		}
		Collections.reverse(temp_listmap1);
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.projects, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final RelativeLayout relativelayout1 = _view.findViewById(R.id.relativelayout1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView num = _view.findViewById(R.id.num);
			final TextView name = _view.findViewById(R.id.name);
			final TextView packages = _view.findViewById(R.id.packages);
			
			num.setText(_data.get((int) _position).get("sc_id").toString());
			name.setText(_data.get((int) _position).get("my_app_name").toString());
			packages.setText(_data.get((int) _position).get("my_sc_pkg_name").toString());
			if (_data.get((int) _position).get("custom_icon").toString().equals("true")) imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath("/storage/emulated/0/.sketchware/resources/icons/".concat(_data.get((int) _position).get("sc_id").toString().concat("/icon.png")), 1024, 1024)); else imageview1.setImageResource(R.drawable.default_image);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					Bundle newBundle = new Bundle();
					newBundle.putSerializable("map", _data);
					newBundle.putString("pos", _data.get((int)_position).get("sc_id").toString()); 
					
					newBundle.putString("cus", _data.get((int)_position).get("custom_icon").toString()); 
					
					newBundle.putString("name", _data.get((int)_position).get("my_app_name").toString()); 
					
					newBundle.putString("pkg", _data.get((int)_position).get("my_sc_pkg_name").toString()); 
					
					getActivity().getSupportFragmentManager().setFragmentResult("requestKey", newBundle);
					dismiss();
				}
			});
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
}