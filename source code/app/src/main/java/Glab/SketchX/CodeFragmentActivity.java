package Glab.SketchX;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.caverock.androidsvg.*;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CodeFragmentActivity extends Fragment {
	
	private Timer _timer = new Timer();
	
	private String str = "";
	private String coeds = "";
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> originalFiles = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear17;
	private RecyclerView recyclerview1;
	private EditText edittext1;
	private Button button3;
	private CircularProgressIndicator progressBar;
	
	private Intent i = new Intent();
	private TimerTask time;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.code_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear1 = _view.findViewById(R.id.linear1);
		linear17 = _view.findViewById(R.id.linear17);
		recyclerview1 = _view.findViewById(R.id.recyclerview1);
		edittext1 = _view.findViewById(R.id.edittext1);
		button3 = _view.findViewById(R.id.button3);
		progressBar = _view.findViewById(R.id.progressBar);
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.trim().equals("")) _showFullList(); else searchListMap(_charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		button3.setOnClickListener(_v -> {
			edittext1.setText("");
			SketchwareUtil.hideKeyboard(getContext().getApplicationContext());
			_showFullList();
		});
	}
	
	private void initializeLogic() {
		{
			try{
				java.io.InputStream strIn = getActivity().getAssets().open("codes.json");
				int strSi = strIn.available();
				byte[] strBu = new byte[strSi];
				strIn.read(strBu);
				strIn.close();
				str = new String(strBu, "UTF-8");
			}catch(Exception e){
				
			}
		}
		coeds = DecryptingTheTextMethod(str,"32@free");
		listmap = new Gson().fromJson(coeds, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		recyclerview1.setAdapter(new Recyclerview1Adapter(listmap));
		recyclerview1.setLayoutManager(new LinearLayoutManager(getContext()));
		if (!listmap.isEmpty()) {
			
			// Clear originalFiles before copying
			originalFiles.clear();
			
			
			int counter = 0;
			originalFiles.clear();
			for (HashMap<String, Object> item : listmap) {
				item.put("id", counter++); // assign unique id
				originalFiles.add(new HashMap<>(item));
			}
		}
		
	}
	
	public void _extr() {
	}
	public String EcryptingTheTextMethod(final String _string, final String _key) {
		try{
			javax.crypto.SecretKey key = generateKey(_key);
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(_string.getBytes());
			return android.util.Base64.encodeToString(encVal,android.util.Base64.DEFAULT);
		} catch (Exception e) {
		}
		return "";
	}
	
	public String DecryptingTheTextMethod(final String _string, final String _key) {
		try {
			javax.crypto.spec.SecretKeySpec key = (javax.crypto.spec.SecretKeySpec) generateKey(_key);
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
			c.init(javax.crypto.Cipher.DECRYPT_MODE,key);
			byte[] decode = android.util.Base64.decode(_string,android.util.Base64.DEFAULT);
			byte[] decval = c.doFinal(decode);
			return new String(decval);
		} catch (Exception ex) {
		}
		return "";
	}
	public static javax.crypto.SecretKey generateKey(String pwd) throws Exception {
		final java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
		byte[] b = pwd.getBytes("UTF-8");
		digest.update(b,0,b.length);
		byte[] key = digest.digest();
		javax.crypto.spec.SecretKeySpec sec = new javax.crypto.spec.SecretKeySpec(key, "AES");
		return sec;
	}
	{
	}
	
	
	public void _showFullList() {
		
		
		DiffCallBack diffCallback = new DiffCallBack(listmap, originalFiles);
		DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
		
		listmap.clear();
		for (HashMap<String, Object> item : originalFiles) {
			listmap.add(new HashMap<>(item)); // deep copy to avoid shared reference
		}
		diffResult.dispatchUpdatesTo(recyclerview1.getAdapter());
		recyclerview1.scrollToPosition(0); // ✅ scroll to top
		
		
	}
	
	
	public void _search2() {
	}
	private void searchListMap(String searchKeyword) {
		progressBar.setVisibility(View.VISIBLE);
		
		Handler handler = new Handler(Looper.getMainLooper());
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		executor.execute(() -> {
			List<HashMap<String, Object>> matchedItems = new ArrayList<>();
			
			// ✅ Always filter against originalFiles (the full list)
			List<HashMap<String, Object>> sourceList = originalFiles;
			
			if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
				// Reset to full list
				for (HashMap<String, Object> item : sourceList) {
					matchedItems.add(new HashMap<>(item));
				}
			} else {
				for (HashMap<String, Object> item : sourceList) {
					String title = item.get("title") != null ? item.get("title").toString().toLowerCase() : "";
					
					if (title.contains(searchKeyword.toLowerCase())){
						matchedItems.add(new HashMap<>(item));
					}
				}
			}
			
			handler.post(() -> {
				DiffCallBack diffCallback = new DiffCallBack(sourceList, matchedItems);
				DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
				
				listmap.clear();
				listmap.addAll(matchedItems);
				diffResult.dispatchUpdatesTo(recyclerview1.getAdapter());
				
				progressBar.setVisibility(View.GONE);
				
			});
		});
	}
	{
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.coding, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final com.google.android.material.card.MaterialCardView materialcardview1 = _view.findViewById(R.id.materialcardview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final Button button1 = _view.findViewById(R.id.button1);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			
			textview3.setText(_data.get((int) _position).get("title").toString());
			button1.setText(_data.get((int) _position).get("id").toString());
			materialcardview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					i.setClass(getContext().getApplicationContext(), CodeActivity.class);
					i.putExtra("code", _data.get((int) _position).get("code").toString());
					i.putExtra("title", _data.get((int) _position).get("title").toString());
					startActivity(i);
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