package Glab.SketchX;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.google.android.material.button.*;
import com.google.android.material.button.MaterialButtonGroup;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.progressindicator.CircularProgressIndicator;
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
import com.caverock.androidsvg.SVG;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import
com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.android.material.textfield.TextInputLayout;


public class IconFragmentActivity extends Fragment {

	private Timer _timer = new Timer();

	private String directoryName = "";
	HashMap<String, String> selectedMap = new HashMap<>();
	private String pathBind = "";
	private String name = "";
	private double counter = 0;
	private boolean filled = false;
	private boolean custom = false;
	private String path = "";

	private ArrayList<String> Pathhh = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> files = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> originalFiles = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> metadataIcons = new ArrayList<>();
	private String currentFamily = "Material Icons Outlined";
	private RequestNetwork requestNetwork;
	private ExecutorService iconLoadExecutor = Executors.newFixedThreadPool(4);

	private LinearLayout linear1;
	private LinearLayout linear17;
	private RelativeLayout relativelayout1;
	private EditText edittext1;
	private CircularProgressIndicator progressBar;
	private Button button3;
	private RecyclerView recyclerview1;
	private MaterialButtonToggleGroup linear18;
	private LinearLayout linear19;
	private MaterialButtonGroup linear20;
	private Button button4;
	private Button button5;
	private MaterialButton outline;
	private MaterialButton fille;
	private MaterialButton round;
	private MaterialButton sharp;
	private MaterialButton twotone;
	private TextView textview1;
	private Button cancel;
	private Button impor;

	private Intent g = new Intent();
	private SharedPreferences sv;
	private TimerTask t;

	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.icon_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}

	private void initialize(Bundle _savedInstanceState, View _view) {
		linear1 = _view.findViewById(R.id.linear1);
		linear17 = _view.findViewById(R.id.linear17);
		relativelayout1 = _view.findViewById(R.id.relativelayout1);
		edittext1 = _view.findViewById(R.id.edittext1);
		progressBar = _view.findViewById(R.id.progressBar);
		button3 = _view.findViewById(R.id.button3);
		recyclerview1 = _view.findViewById(R.id.recyclerview1);
		linear18 = _view.findViewById(R.id.linear18);
		linear19 = _view.findViewById(R.id.linear19);
		linear20 = _view.findViewById(R.id.linear20);
		button4 = _view.findViewById(R.id.button4);
		button5 = _view.findViewById(R.id.button5);
		outline = _view.findViewById(R.id.outline);
		fille = _view.findViewById(R.id.fille);
		round = _view.findViewById(R.id.round);
		sharp = _view.findViewById(R.id.sharp);
		twotone = _view.findViewById(R.id.twotone);
		textview1 = _view.findViewById(R.id.textview1);
		cancel = _view.findViewById(R.id.cancel);
		impor = _view.findViewById(R.id.impor);
		sv = getContext().getSharedPreferences("sv", Activity.MODE_PRIVATE);

		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.trim().equals("")) {
					_showFullList();
				} else {
					searchFiles(_charSeq);
				}
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
			_showFullList();
			SketchwareUtil.hideKeyboard(getContext().getApplicationContext());
		});

		button4.setOnClickListener(_v -> {
			View alertLayout = getActivity().getLayoutInflater().inflate(R.layout.dial, null);
			MaterialAlertDialogBuilder m = new MaterialAlertDialogBuilder(requireContext());
			
			m.setView(alertLayout);
			final com.google.android.material.textfield.TextInputLayout UserName = (com.google.android.material.textfield.TextInputLayout)alertLayout.findViewById(R.id.UserNameEditText);
			final TextInputEditText UserNameValue= (TextInputEditText)alertLayout.findViewById(R.id.UserNameValue);
			UserName.setHint("Parent folder path");
			UserName.setHelperText("Example: /storage/emulated/0/Download/svg/");
			if (sv.contains("customV")) UserNameValue.setText(sv.getString("customV", ""));
			m.setTitle("Custom svg icons");
			m.setMessage("Do you have Svg collections?\nprovide path, convert and import to your projects");
			m.setIcon(R.drawable.imp);
			m.setPositiveButton("Import", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					Pathhh.clear();
					files.clear();
					originalFiles.clear(); // ✅ store full list
					
					filled = false;
					custom = true;
					
					String basePath = UserNameValue.getText().toString();
					if (FileUtil.isExistFile(basePath)) {
						FileUtil.listDir(basePath, Pathhh);
						for (String filePath : Pathhh) { 	
							HashMap<String, Object> item = new HashMap<>();
							item.put("file", filePath);
							item.put("selected", selectedMap.getOrDefault(filePath, "false"));
							files.add(item);
							originalFiles.add(new HashMap<>(item)); // ✅ deep copy
						}
						_Recheck();
						recyclerview1.setAdapter(new Recyclerview1Adapter(files));
						recyclerview1.setLayoutManager(new GridLayoutManager(getContext(), 4));
						_lgi(files.size());
					}
					sv.edit().putString("customV", UserNameValue.getText().toString()).commit();
				}
			});
			m.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			m.setCancelable(true);
			m.show();
		});

		button5.setOnClickListener(_v -> _showBottomSheet());

		outline.setOnClickListener(_v -> {
			currentFamily = "Material Icons Outlined";
			_loadFamily();
		});

		fille.setOnClickListener(_v -> {
			currentFamily = "Material Icons";
			_loadFamily();
		});

		round.setOnClickListener(_v -> {
			currentFamily = "Material Icons Round";
			_loadFamily();
		});

		sharp.setOnClickListener(_v -> {
			currentFamily = "Material Icons Sharp";
			_loadFamily();
		});

		twotone.setOnClickListener(_v -> {
			currentFamily = "Material Icons Two Tone";
			_loadFamily();
		});

		cancel.setOnClickListener(_v -> {
			selectedMap.clear();
			counter = 0;
			_loadFamily();
			//Blocks.made by Grafix Lab
			
			View[] vieew = {cancel, impor};
			for (int i = 0; i < vieew.length; i++) {
				final View ViewsGr = vieew[i];
				//Blocks.Made by Grafix Lab
				ViewsGr.animate()
				.alpha(0f)
				.translationX((float)20)
				.setStartDelay(i * 150)
				.setInterpolator(new OvershootInterpolator(4f))
				.withEndAction(new Runnable() {
					@Override
					public void run() {
						
						linear20.setVisibility(View.GONE);
					}
				}
				);
				
			}
		});

		impor.setOnClickListener(_v -> {
			files.clear(); // Clear existing list
			
			for (Map.Entry<String, String> entry : selectedMap.entrySet()) {
				HashMap<String, Object> fileItem = new HashMap<>();
				fileItem.put("file", entry.getKey());       // file path or ID
				fileItem.put("selected", entry.getValue()); // "true" or "false"
				
				files.add(fileItem);
			}
			recyclerview1.setAdapter(new Recyclerview1Adapter(files));
			if (files.size() > 0) {
				Bundle bundle = new Bundle();
				bundle.putSerializable("files", files);
				bundle.putBoolean("custom", custom);
				bundle.putBoolean("filled", filled); 
				ScanBottomdialogFragmentActivity _fragment_ = new ScanBottomdialogFragmentActivity();
				_fragment_.setArguments(bundle);
				_fragment_.show(getActivity().getSupportFragmentManager(), "fragment");
			} else {
				SketchwareUtil.showMessage(getContext().getApplicationContext(), "No items, Re-select ");
				cancel.performClick();
			}
		});
	}

	private void initializeLogic() {
		requestNetwork = new RequestNetwork(getActivity());
		_fetchMetadata();
		Animation animation = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in);
		recyclerview1.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.animatet));
		recyclerview1.scheduleLayoutAnimation();
	}

	public void _lgi(final double _g) {
		textview1.setText(String.valueOf((long)(_g)).concat(" items"));
	}


	public void _fetchMetadata() {
		progressBar.setVisibility(View.VISIBLE);
		requestNetwork.startRequestNetwork("GET", "https://fonts.google.com/metadata/icons", "metadata", new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String tag, String response, HashMap<String, Object> responseHeaders) {
				try {
					// The response starts with )]}'
					String jsonString = response.substring(response.indexOf("{"));
					JSONObject jsonObject = new JSONObject(jsonString);
					JSONArray iconsArray = jsonObject.getJSONArray("icons");
					metadataIcons.clear();
					for (int i = 0; i < iconsArray.length(); i++) {
						JSONObject iconObj = iconsArray.getJSONObject(i);
						HashMap<String, Object> iconMap = new HashMap<>();
						iconMap.put("name", iconObj.getString("name"));
						iconMap.put("version", iconObj.getInt("version"));

						JSONArray familiesArray = iconObj.getJSONArray("families");
						ArrayList<String> families = new ArrayList<>();
						for (int j = 0; j < familiesArray.length(); j++) {
							families.add(familiesArray.getString(j));
						}
						iconMap.put("families", families);

						if (iconObj.has("tags")) {
							JSONArray tagsArray = iconObj.getJSONArray("tags");
							ArrayList<String> tags = new ArrayList<>();
							for (int k = 0; k < tagsArray.length(); k++) {
								tags.add(tagsArray.getString(k).toLowerCase());
							}
							iconMap.put("tags", tags);
						} else {
							iconMap.put("tags", new ArrayList<String>());
						}

						metadataIcons.add(iconMap);
					}
					_loadFamily();
				} catch (Exception e) {
					Log.e("IconFragment", "Error parsing metadata", e);
				}
				progressBar.setVisibility(View.GONE);
			}

			@Override
			public void onErrorResponse(String tag, String message) {
				progressBar.setVisibility(View.GONE);
				SketchwareUtil.showMessage(getContext(), "Failed to fetch icons: " + message);
			}
		});
	}

	public void _loadFamily() {
		files.clear();
		originalFiles.clear();
		String familyShortName = currentFamily.toLowerCase().replace(" ", "");
		// Special case for "Material Icons" -> "materialicons"
		// Special case for "Material Icons Outlined" -> "materialiconsoutlined"

		for (HashMap<String, Object> icon : metadataIcons) {
			ArrayList<String> families = (ArrayList<String>) icon.get("families");
			if (families.contains(currentFamily)) {
				HashMap<String, Object> item = new HashMap<>();
				String name = (String) icon.get("name");
				int version = (int) icon.get("version");
				// URL pattern: https://fonts.gstatic.com/s/i/{family}/{icon}/v{version}/24px.svg
				String url = "https://fonts.gstatic.com/s/i/" + familyShortName + "/" + name + "/v" + version + "/24px.svg";
				item.put("file", url);
				item.put("name", name);
				item.put("selected", selectedMap.getOrDefault(url, "false"));
				files.add(item);
				originalFiles.add(new HashMap<>(item));
			}
		}
		_Recheck();
		recyclerview1.setAdapter(new Recyclerview1Adapter(files));
		recyclerview1.setLayoutManager(new GridLayoutManager(getContext(), 4));
		_lgi(files.size());
	}


	public void _Recheck() {
		for (int i = 0; i < files.size(); i++) {
			String fileId = files.get(i).get("file").toString();
			if (selectedMap.containsKey(fileId)) {
				files.get(i).put("selected", "true");
			} else {
				files.get(i).put("selected", "false");
			}
		}

	}


	public void _tw() {
	}private void toggleSelection(String filePath) {
		int position = -1;
		
		for (int i = 0; i < files.size(); i++) {
			if (files.get(i).get("file").equals(filePath)) {
				position = i;
				break;
			}
		}
		
		if (position == -1) return; // File not found in current list
		
		HashMap<String, Object> item = files.get(position);
		boolean isSelected = "true".equals(item.get("selected"));
		
		item.put("selected", isSelected ? "false" : "true");
		selectedMap.put(filePath, isSelected ? "false" : "true");
		
		if (!isSelected) {
			counter++;
			if (counter == 1) {
				linear20.setVisibility(View.VISIBLE);
				View[] vieew = {cancel, impor};
				for (int i = 0; i < vieew.length; i++) {
					final View ViewsGr = vieew[i];
					ViewsGr.setTranslationX(20f);
					ViewsGr.setAlpha(0f);
					ViewsGr.animate()
					.alpha(1f)
					.translationX(0f)
					.setStartDelay(i * 150)
					.setInterpolator(new OvershootInterpolator(4f));
				}
			}
		} else {
			counter--;
			if (counter <= 0) {
				selectedMap.clear();
				View[] vieew = {cancel, impor};
				for (int i = 0; i < vieew.length; i++) {
					final View ViewsGr = vieew[i];
					ViewsGr.animate()
					.alpha(0f)
					.translationX(20f)
					.setStartDelay(i * 150)
					.setInterpolator(new OvershootInterpolator(4f))
					.withEndAction(() -> linear20.setVisibility(View.GONE));
				}
			}
		}
		
		recyclerview1.getAdapter().notifyItemChanged(position);
	}{
	}


	public void _search2() {
	}
	private void searchFiles(String searchKeyword) {
		progressBar.setVisibility(View.VISIBLE);
		button3.setVisibility(View.GONE);
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Handler handler = new Handler(Looper.getMainLooper());
		
		final String query = searchKeyword.toLowerCase().trim();

		executor.execute(() -> {
			List<HashMap<String, Object>> matchedFiles = new ArrayList<>();
			String familyShortName = currentFamily.toLowerCase().replace(" ", "");
			
			for (HashMap<String, Object> icon : metadataIcons) {
				ArrayList<String> families = (ArrayList<String>) icon.get("families");
				if (!families.contains(currentFamily)) continue;
				
				String name = (String) icon.get("name");
				ArrayList<String> tags = (ArrayList<String>) icon.get("tags");

				boolean matches = name.toLowerCase().contains(query);
				if (!matches && tags != null) {
					for (String tag : tags) {
						if (tag.contains(query)) {
							matches = true;
							break;
						}
					}
				}

				if (matches) {
					HashMap<String, Object> item = new HashMap<>();
					int version = (int) icon.get("version");
					String url = "https://fonts.gstatic.com/s/i/" + familyShortName + "/" + name + "/v" + version + "/24px.svg";
					item.put("file", url);
					item.put("name", name);
					item.put("selected", selectedMap.getOrDefault(url, "false"));
					matchedFiles.add(item);
				}
			}
			
			handler.post(() -> {
				files.clear();
				files.addAll(matchedFiles);
				recyclerview1.getAdapter().notifyDataSetChanged();
				
				progressBar.setVisibility(View.GONE); 
				button3.setVisibility(View.VISIBLE);
				_Recheck();
			});
		});
	}
	{
	}


	public void _showFullList() {
		files.clear();
		for (HashMap<String, Object> item : originalFiles) {
			files.add(new HashMap<>(item)); // deep copy to avoid shared reference
		}
		recyclerview1.getAdapter().notifyDataSetChanged();
		recyclerview1.scrollToPosition(0); // ✅ scroll to top
	}


	public void _showBottomSheet() {
		if (getActivity() instanceof MainActivity) {
			((MainActivity) getActivity())._bottomSheetTheme();
		}

	}

	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {

		ArrayList<HashMap<String, Object>> _data;

		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}

		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.item, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}

		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;

			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final RelativeLayout relativelayout1 = _view.findViewById(R.id.relativelayout1);
			final com.caverock.androidsvg.SVGImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);

			if (files.get((int)_position).containsKey("file")) {
				name = (String) files.get((int) _position).get("name");
				pathBind = files.get((int) _position).get("file").toString();
				textview1.setText(name);

				final String url = pathBind;
				imageview1.setTag(url);
				imageview1.setSVG(null);
				iconLoadExecutor.execute(() -> {
					try {
						java.net.URL iconUrl = new java.net.URL(url);
						final SVG svg = SVG.getFromInputStream(iconUrl.openStream());
						if (getActivity() != null) {
							getActivity().runOnUiThread(() -> {
								if (url.equals(imageview1.getTag())) {
									imageview1.setSVG(svg);
								}
							});
						}
					} catch (Exception e) {
						Log.e("IconAdapter", "Error loading SVG from " + url, e);
					}
				});
			}
			String filePath = files.get((int)_position).get("file").toString();
			boolean isSelected = "true".equals(files.get((int)_position).get("selected"));
			imageview2.setVisibility(isSelected ? View.VISIBLE : View.GONE);
			cardview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					
					toggleSelection(filePath);
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