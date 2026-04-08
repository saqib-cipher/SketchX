package Glab.SketchX;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
import com.google.android.material.chip.*;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.loadingindicator.LoadingIndicator;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import android.content.ClipboardManager;
import android.text.util.Linkify;
import android.text.method.LinkMovementMethod;
import com.google.gson.reflect.TypeToken;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AssistantFragmentActivity extends Fragment {
	
	private final String ASSIST_FILE = FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/SketchX/Files/AssistData.json");
	
	private String id = "";
	private HashMap<String, Object> oficial = new HashMap<>();
	private HashMap<String, Object> m = new HashMap<>();
	private double pos = 0;
	private HashMap<String, Object> chatMap = new HashMap<>();
	private String API_GEMINI = "";
	private HashMap<String, Object> ApiMap = new HashMap<>();
	private HashMap<String, Object> oficialMap = new HashMap<>();
	private HashMap<String, Object> Params = new HashMap<>();
	private String projectId = "";
	
	private ArrayList<HashMap<String, Object>> history = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> chatList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> todoList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> ChatList = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear5;
	private MaterialCardView cardview1;
	private RelativeLayout relativelayout2;
	private LinearLayout linear2;
	private Button fille;
	private TextView textview2;
	private TextView textview1;
	private LinearLayout linear19;
	private TextView textview5;
	private LinearLayout linear20;
	private CardView cardview2;
	private LinearLayout linear21;
	private Button replace;
	private RelativeLayout relativelayout1;
	private ImageView imageview1;
	private TextView num;
	private TextView name;
	private TextView packages;
	private LinearLayout linear23;
	private LinearLayout linear22;
	private LinearLayout ln_2;
	private RecyclerView recyclerview1;
	private Button button1;
	private EditText edittext1;
	private LoadingIndicator loading_indicator2;
	private Button button2;
	private Button button3;
	private HorizontalScrollView hscroll1;
	private ChipGroup linear24;
	private Chip Normal;
	private Chip LastEror;
	private Chip WholeSource;
	private Chip AddNew;
	
	private SharedPreferences it;
	private RequestNetwork GeminiApi;
	private RequestNetwork.RequestListener _GeminiApi_request_listener;
	private Calendar c = Calendar.getInstance();
	private Intent i = new Intent();
	private SharedPreferences key;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.assistant_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear1 = _view.findViewById(R.id.linear1);
		linear5 = _view.findViewById(R.id.linear5);
		cardview1 = _view.findViewById(R.id.cardview1);
		relativelayout2 = _view.findViewById(R.id.relativelayout2);
		linear2 = _view.findViewById(R.id.linear2);
		fille = _view.findViewById(R.id.fille);
		textview2 = _view.findViewById(R.id.textview2);
		textview1 = _view.findViewById(R.id.textview1);
		linear19 = _view.findViewById(R.id.linear19);
		textview5 = _view.findViewById(R.id.textview5);
		linear20 = _view.findViewById(R.id.linear20);
		cardview2 = _view.findViewById(R.id.cardview2);
		linear21 = _view.findViewById(R.id.linear21);
		replace = _view.findViewById(R.id.replace);
		relativelayout1 = _view.findViewById(R.id.relativelayout1);
		imageview1 = _view.findViewById(R.id.imageview1);
		num = _view.findViewById(R.id.num);
		name = _view.findViewById(R.id.name);
		packages = _view.findViewById(R.id.packages);
		linear23 = _view.findViewById(R.id.linear23);
		linear22 = _view.findViewById(R.id.linear22);
		ln_2 = _view.findViewById(R.id.ln_2);
		recyclerview1 = _view.findViewById(R.id.recyclerview1);
		button1 = _view.findViewById(R.id.button1);
		edittext1 = _view.findViewById(R.id.edittext1);
		loading_indicator2 = _view.findViewById(R.id.loading_indicator2);
		button2 = _view.findViewById(R.id.button2);
		button3 = _view.findViewById(R.id.button3);
		hscroll1 = _view.findViewById(R.id.hscroll1);
		linear24 = _view.findViewById(R.id.linear24);
		Normal = _view.findViewById(R.id.Normal);
		LastEror = _view.findViewById(R.id.LastEror);
		WholeSource = _view.findViewById(R.id.WholeSource);
		AddNew = _view.findViewById(R.id.AddNew);
		it = getContext().getSharedPreferences("save", Activity.MODE_PRIVATE);
		GeminiApi = new RequestNetwork((Activity) getContext());
		key = getContext().getSharedPreferences("save", Activity.MODE_PRIVATE);
		
		fille.setOnClickListener(_v -> {
			View alertLayout = getActivity().getLayoutInflater().inflate(R.layout.dial, null);
			MaterialAlertDialogBuilder m = new MaterialAlertDialogBuilder(requireContext());
			
			m.setView(alertLayout);
			final com.google.android.material.textfield.TextInputLayout UserName = (com.google.android.material.textfield.TextInputLayout)alertLayout.findViewById(R.id.UserNameEditText);
			final TextInputEditText UserNameValue= (TextInputEditText)alertLayout.findViewById(R.id.UserNameValue);
			UserName.setHint("Gemini Api Key");
			UserName.setHelperText("Get Gemini Api Key then enter here");
			if (key.contains("customV")) UserNameValue.setText(key.getString("customV", ""));
			m.setTitle("Enter Gemini Api Key ");
			m.setMessage("Get Ai assistant for Sketchware projects, Make your work faster ");
			m.setIcon(R.drawable.icon_assistant_round);
			m.setPositiveButton("Save", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					key.edit().putString("customV", UserNameValue.getText().toString()).commit();
					API_GEMINI = UserNameValue.getText().toString();
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
		
		replace.setOnClickListener(_v -> {
			Bundle bundle = new Bundle();
			
			ProjectDialogFragmentActivity _fragment_ = new ProjectDialogFragmentActivity();
			_fragment_.setArguments(bundle);
			_fragment_.show(getActivity().getSupportFragmentManager(), "fragment");
		});
		
		recyclerview1.addOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(RecyclerView recyclerView, int _scrollState) {
				super.onScrollStateChanged(recyclerView, _scrollState);
				
			}
			
			@Override
			public void onScrolled(RecyclerView recyclerView, int _offsetX, int _offsetY) {
				super.onScrolled(recyclerView, _offsetX, _offsetY);
				
				LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerview1.getLayoutManager();
				if (layoutManager != null) {
					int lastVisibleItem = layoutManager.findLastCompletelyVisibleItemPosition();
					int totalItems = chatList.size();
					
					if (lastVisibleItem == totalItems - 1) {
						// Last item reached → hide footer
						_Anima(false);
					} else {
						// Not at last item → show footer
						_Anima(true);
					}
				}
				
				
			}
		});
		
		button1.setOnClickListener(_v -> edittext1.setText(""));
		
		button2.setOnClickListener(_v -> {
			if (API_GEMINI.equals("")) {
				SketchwareUtil.showMessage(getContext().getApplicationContext(), "Enter Key First");
			} else {
				loading_indicator2.setVisibility(View.VISIBLE);
				button2.setVisibility(View.GONE);
				c = Calendar.getInstance();
				ApiMap = new HashMap<>();
				ApiMap.put("Content-Type", "application/json");
				_addText(edittext1.getText().toString(), true);
				GeminiApi.setHeaders(ApiMap);
				GeminiApi.setParams(oficialMap, RequestNetworkController.REQUEST_BODY);
				GeminiApi.startRequestNetwork(RequestNetworkController.POST, "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=".concat(API_GEMINI), "", _GeminiApi_request_listener);
				chatMap = new HashMap<>();
				chatMap.put("user", "you");
				chatMap.put("text", edittext1.getText().toString());
				chatMap.put("time", new SimpleDateFormat("hh:mm a").format(c.getTime()));
				chatList.add(chatMap);
				recyclerview1.setAdapter(new Recyclerview1Adapter(chatList));
				recyclerview1.smoothScrollToPosition((int)chatList.size() - 1);
				edittext1.setText("");
				_HistorySave();
			}
		});
		
		button3.setOnClickListener(_v -> {
			if (Normal.getAlpha() == 0) _Anima(true); else _Anima(false);
		});
		
		LastEror.setOnCheckedChangeListener((_buttonView, _isChecked) -> {
			if (_isChecked) {
				if (FileUtil.isExistFile("/storage/emulated/0/.sketchware/data/".concat(projectId.concat("/compile_log")))) {
					String CompEror;
					CompEror = "Hey, I Found Error While Compilation in Sketchware pro\n\n";
					CompEror += FileUtil.readFile("/storage/emulated/0/.sketchware/data/" + projectId + "/compile_log");
					edittext1.setText(CompEror);
				} else {
					SketchwareUtil.showMessage(getContext().getApplicationContext(), "There is no Compilation error ");
				}
			}
		});
		
		_GeminiApi_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try{
					Map<String, Object> geminiMap = new Gson().fromJson(_response, Map.class);
					List<Map<String, Object>> candidates = (List<Map<String, Object>>) geminiMap.get("candidates");
					Map<String, Object> content = (Map<String, Object>) candidates.get(0).get("content");
					List<Map<String, Object>> parts = (List<Map<String, Object>>) content.get("parts");
					String geminiText = parts.get(0).get("text").toString();
					
					c = Calendar.getInstance();
					chatMap = new HashMap<>();
					chatMap.put("user", "Ai");
					chatMap.put("text", geminiText);
					chatMap.put("time", new SimpleDateFormat("hh:mm a").format(c.getTime()));
					_addText(geminiText, false);
					chatList.add(chatMap);
					recyclerview1.setAdapter(new Recyclerview1Adapter(chatList));
					recyclerview1.smoothScrollToPosition((int)chatList.size() - 1);
					_HistorySave();
				}catch(Exception e){
					com.google.android.material.snackbar.Snackbar.make(edittext1, _response, com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Copy", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
							((ClipboardManager) getContext().getSystemService(getContext().getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _response));
						}
					}).show();
				}
				loading_indicator2.setVisibility(View.GONE);
				button2.setVisibility(View.VISIBLE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				button2.setVisibility(View.VISIBLE);
				loading_indicator2.setVisibility(View.GONE);
			}
		};
	}
	
	private void initializeLogic() {
		// Load file safely
		todoList = readAssistFile();
		loading_indicator2.setVisibility(View.GONE);
		if (it.contains("pos")) {
			_DCheck(it.getString("pos", ""), it.getString("name", ""), it.getString("pkg", ""), it.getString("cust", ""));
		} else {
			name.setText("No Project Selected!");
			packages.setText("First Select a Project ");
			cardview2.setVisibility(View.GONE);
		}
		WholeSource.setEnabled(false);
		AddNew.setEnabled(false);
		hscroll1.setHorizontalScrollBarEnabled(false);
		if (key.contains("customV")) API_GEMINI = key.getString("customV", "");
	}
	
	@Override
	public void onStart() {
		super.onStart();
		getParentFragmentManager().setFragmentResultListener("requestKey", this,
		(requestKey, result) -> {
			// result contains updated bundle
			String pos = result.getString("pos");
			String namee = result.getString("name");
			String pkg = result.getString("pkg");
			String cust = result.getString("cus");
			
			
			it.edit().putString("pos", pos).commit();
			it.edit().putString("name", namee).commit();
			it.edit().putString("pkg", pkg).commit();
			it.edit().putString("cust", cust).commit();
			_DCheck(pos, namee, pkg, cust);
		});
		if (!key.getBoolean("noitf", false)) {
			MaterialAlertDialogBuilder m = new MaterialAlertDialogBuilder(requireContext());
			m.setTitle("Chat History Location");
			m.setMessage("SketchX doesn't store chats data online! \nit uses Device Storage to store, You can Checkout the location -->\n/storage/emulated/0/Download/SketchX/Files/AssistData.json\n\nImport Your Gemini api key to use ai feature");
			m.setPositiveButton("Understood", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					key.edit().putBoolean("noitf", true).apply();
					fille.performClick();
				}
			});
			m.setCancelable(false);
			m.show();
		}
	}
	
	public void _DCheck(final String _Pos, final String _name, final String _pkg, final String _cust) {
		id = _pkg + "_" + _Pos;
		projectId = _Pos;
		num.setText(_Pos);
		name.setText(_name);
		packages.setText(_pkg);
		cardview2.setVisibility(View.VISIBLE);
		
		if ("true".equals(_cust)) {
			imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(
			"/storage/emulated/0/.sketchware/resources/icons/" + _Pos + "/icon.png",
			1024, 1024));
		} else {
			imageview1.setImageResource(R.drawable.default_image);
		}
		
		
		
		
		
		todoList = readAssistFile();
		
		boolean found = false;
		for (int i = 0; i < todoList.size(); i++) {
			Object idObj = todoList.get(i).get("id");
			if (idObj != null && idObj.toString().equals(id)) {
				// Load context (history) and chatList
				history = safeParseList(todoList.get(i).get("context"));
				chatList = safeParseList(todoList.get(i).get("history"));
				found = true;
				pos = i;
				break;
			}
		}
		
		if (!found) {
			// Create new entry; DO NOT clear history, only chatList
			_CreateChat();
			chatList = new ArrayList<>();
			// history is the initial MainRespo loaded inside _CreateChat (we set it by writing string, now load it back)
			todoList = readAssistFile();
			for (int i = 0; i < todoList.size(); i++) {
				Object idObj = todoList.get(i).get("id");
				if (idObj != null && idObj.toString().equals(id)) {
					history = safeParseList(todoList.get(i).get("context"));
					pos = i;
					break;
				}
			}
		}
		
		recyclerview1.setLayoutManager(new LinearLayoutManager(getContext()));
		recyclerview1.setAdapter(new Recyclerview1Adapter(chatList));
		if (chatList.size() > 0) {
			((LinearLayoutManager) recyclerview1.getLayoutManager())
			.scrollToPositionWithOffset(chatList.size() - 1, 0);
		}
		
		if (LastEror.isChecked()) {
			edittext1.setText("");
			Normal.setChecked(true);
		}
	}
	
	
	public void _addText(final String _text, final boolean _you) {
		
		// Create one message
		HashMap<String, Object> message = new HashMap<>();
		message.put("role", _you ? "user" : "model");
		
		ArrayList<HashMap<String, String>> partsList = new ArrayList<>();
		HashMap<String, String> partsMap = new HashMap<>();
		partsMap.put("text", _text);
		partsList.add(partsMap);
		
		message.put("parts", partsList);
		
		// ✅ Add message to history list
		history.add(message);
		
		// ✅ Send FULL history to Gemini
		oficialMap.clear();
		oficialMap.put("contents", history);
		
	}
	
	
	public void _CreateChat() {
		String customName = name.getText().toString(); 
		String ProjectPackage = packages.getText().toString();
		String ProjectId = num.getText().toString();
		
		// or any other name you want to use
		String response = "{\"role\":\"user\",\"parts\":[{\"text\":\"From now on I'll start helping you for " + customName + "project\"}]}";
		String response2 = "{\"role\":\"user\",\"parts\":[{\"text\":\"Hello, This is a Skethware pro's project named " + customName + " Project id:" + ProjectId + " Package name: " + ProjectPackage + "! From now on you'll help me about related to this project.\"}]}";
		
		String MainRespo = "[" + response + "," + response2 + "]";
		todoList = readAssistFile();
		
		HashMap<String, Object> newEntry = new HashMap<>();
		newEntry.put("context", MainRespo);  // JSON string of history array
		newEntry.put("history", "[]");       // empty chatList
		newEntry.put("id", id);
		
		todoList.add(newEntry);
		FileUtil.writeFile(ASSIST_FILE, new Gson().toJson(todoList));
		
		pos = todoList.size() - 1;
	}
	
	
	public void _HistorySave() {
		try {
			m = new HashMap<>();
			m.put("context", new Gson().toJson(history));   // full history (user + model)
			m.put("history", new Gson().toJson(chatList));  // rendered chat rows (user + Ai)
			m.put("id", id);
			
			todoList = readAssistFile();
			
			int idx = (int) pos;
			if (idx >= 0 && idx < todoList.size()) {
				todoList.set(idx, m);
			} else {
				todoList.add(m);
				pos = todoList.size() - 1;
			}
			
			FileUtil.writeFile(ASSIST_FILE, new Gson().toJson(todoList));
		} catch (Exception ignored) {}
	}
	
	
	private ArrayList<HashMap<String, Object>> readAssistFile() {
        if (!FileUtil.isExistFile(ASSIST_FILE)) return new ArrayList<>();
        try {
            String raw = FileUtil.readFile(ASSIST_FILE);
            if (raw == null || raw.trim().isEmpty()) return new ArrayList<>();
            ArrayList<HashMap<String, Object>> list =
                    new Gson().fromJson(raw, new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
            return (list == null) ? new ArrayList<>() : list;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

private ArrayList<HashMap<String, Object>> safeParseList(Object jsonStrObj) {
        try {
            if (jsonStrObj == null) return new ArrayList<>();
            String jsonStr = jsonStrObj.toString();
            ArrayList<HashMap<String, Object>> list =
                    new Gson().fromJson(jsonStr, new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
            return (list == null) ? new ArrayList<>() : list;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
	
	
	public void _Anima(final boolean _tyep) {
		if (_tyep) {
			//Blocks.made by Grafix Lab
			
			View[] vieew = {Normal, LastEror, WholeSource, AddNew};
			for (int i = 0; i < vieew.length; i++) {
				final View ViewsGr = vieew[i];
				hscroll1.setVisibility(View.VISIBLE);
				//Blocks.Made by Grafix Lab
				ViewsGr.animate()
				.setStartDelay(i * 200)
				.setInterpolator(new OvershootInterpolator(4f))
				.alpha(1f)
				.translationY(0f);
				
			}
		} else {
			//Blocks.made by Grafix Lab
			
			View[] vieew = {Normal, LastEror, WholeSource, AddNew};
			for (int i = 0; i < vieew.length; i++) {
				final View ViewsGr = vieew[i];
				//Blocks.Made by Grafix Lab
				ViewsGr.animate()
				.setStartDelay(i * 200)
				.setInterpolator(new OvershootInterpolator(4f))
				.alpha(0f)
				.translationY(30f)
				.withEndAction(new Runnable() {
					@Override
					public void run() {
						
						hscroll1.setVisibility(View.GONE);
					}
				}
				);
				
			}
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
			View _v = _inflater.inflate(R.layout.chat, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout you_base = _view.findViewById(R.id.you_base);
			final LinearLayout ia_base = _view.findViewById(R.id.ia_base);
			final TextView you_name_text = _view.findViewById(R.id.you_name_text);
			final LinearLayout you_linear4 = _view.findViewById(R.id.you_linear4);
			final TextView you_message_time = _view.findViewById(R.id.you_message_time);
			final TextView you_prompt_text = _view.findViewById(R.id.you_prompt_text);
			final de.hdodenhof.circleimageview.CircleImageView ia_perfil = _view.findViewById(R.id.ia_perfil);
			final LinearLayout ia_linear3 = _view.findViewById(R.id.ia_linear3);
			final TextView ia_name_text = _view.findViewById(R.id.ia_name_text);
			final LinearLayout containerLayout = _view.findViewById(R.id.containerLayout);
			final LinearLayout linear13 = _view.findViewById(R.id.linear13);
			final TextView ia_message_time = _view.findViewById(R.id.ia_message_time);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			
			if (chatList.get((int) _position).get("user").toString().equals("you")) {
				you_base.setVisibility(View.VISIBLE);
				ia_base.setVisibility(View.GONE);
				you_message_time.setText(chatList.get((int) _position).get("time").toString());
				you_prompt_text.setText(chatList.get((int) _position).get("text").toString());
				you_prompt_text.setTextIsSelectable(true);
				you_name_text.setText(chatList.get((int) _position).get("user").toString());
			}
			if (chatList.get((int) _position).get("user").toString().equals("Ai")) {
				ia_base.setVisibility(View.VISIBLE);
				you_base.setVisibility(View.GONE);
				ia_message_time.setText(chatList.get((int) _position).get("time").toString());
				// Inside your adapter or activity, before using them
				TypedValue typedValue = new TypedValue();
				Context context = getContext(); // or getContext().getApplicationContext()
				
				context.getTheme().resolveAttribute(com.google.android.material.R.attr.colorPrimaryContainer, typedValue, true);
				int codeBackgroundColor = typedValue.data;
				
				context.getTheme().resolveAttribute(com.google.android.material.R.attr.colorOnSurface, typedValue, true);
				int codeTextColor = typedValue.data;
				
				context.getTheme().resolveAttribute(com.google.android.material.R.attr.colorSecondary, typedValue, true);
				int linkTextColor = typedValue.data;
				
				context.getTheme().resolveAttribute(com.google.android.material.R.attr.colorOnSurface, typedValue, true);
				int normalTextColor = typedValue.data;
				
				context.getTheme().resolveAttribute(com.google.android.material.R.attr.colorTertiary, typedValue, true);
				int codeColor = typedValue.data;
				String markdown = _data.get((int)_position).get("text").toString();
				List<MarkdownSegment> parts = MarkdownRenderer.segmentMarkdown(markdown);
				containerLayout.removeAllViews();
				
				for (final MarkdownSegment segment : parts) {
					if (segment.isCode) {
						LinearLayout layout = new LinearLayout(getContext().getApplicationContext());
						layout.setOrientation(LinearLayout.HORIZONTAL);
						layout.setPadding(12, 12, 12, 12);
						
						layout.setBackground(new GradientDrawable() {   
							public GradientDrawable getIns(int a, int b) {   
								this.setCornerRadius(a);   
								this.setColor(b);   
								return this;   
							}   
						}.getIns(14, codeBackgroundColor));  
						
						TextView codeView = new TextView(getContext().getApplicationContext());  
						codeView.setText(segment.content);  
						codeView.setTypeface(Typeface.MONOSPACE);  
						codeView.setTextSize(14f);  
						codeView.setTextColor(codeTextColor);  
						codeView.setLayoutParams(new LinearLayout.LayoutParams(  
						0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));  
						
						ImageButton copyBtn = new ImageButton(getContext().getApplicationContext());  
						copyBtn.setImageResource(R.drawable.ic_copy); // your custom icon  
						copyBtn.setBackground(null);  
						copyBtn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);  
						copyBtn.setContentDescription("Copy");  
						
						int size = (int) TypedValue.applyDimension(  
						TypedValue.COMPLEX_UNIT_DIP, 45, getContext().getApplicationContext().getResources().getDisplayMetrics()  
						);  
						copyBtn.setLayoutParams(new LinearLayout.LayoutParams(size, size));  
						copyBtn.setOnClickListener(new View.OnClickListener() {  
							@Override  
							public void onClick(View _view) {  
								android.content.ClipboardManager cm = (android.content.ClipboardManager)  
								getContext().getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);  
								ClipData clip = ClipData.newPlainText("Code", segment.content);  
								cm.setPrimaryClip(clip);  
								Toast.makeText(getContext().getApplicationContext(), "Copied!", Toast.LENGTH_SHORT).show();  
							}  
						});  
						
						layout.addView(codeView);  
						layout.addView(copyBtn);  
						containerLayout.addView(layout);  
						
					} else if (segment.isTableLike()) {  
						TableLayout table = new TableLayout(getContext().getApplicationContext());
						table.setLayoutParams(new TableLayout.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.WRAP_CONTENT
						));
						table.setStretchAllColumns(true);
						
						MarkdownRenderer.renderTableWithLayout(segment.content, table, getContext().getApplicationContext());  
						HorizontalScrollView scrollView = new HorizontalScrollView(getContext().getApplicationContext());  
						scrollView.setHorizontalScrollBarEnabled(false); // optional  
						scrollView.setLayoutParams(new LinearLayout.LayoutParams(  
						ViewGroup.LayoutParams.MATCH_PARENT,  
						ViewGroup.LayoutParams.WRAP_CONTENT  
						));  
						scrollView.addView(table);  
						
						containerLayout.addView(scrollView); // now adds scrollable table  
					} else {  
						TextView markdownText = new TextView(getContext().getApplicationContext());  
						
						markdownText.setText(MarkdownRenderer.render(segment.content, getContext().getApplicationContext()));  
						markdownText.setLinksClickable(true);  
						markdownText.setMovementMethod(LinkMovementMethod.getInstance());  
						
						
						
						markdownText.setLinkTextColor(linkTextColor);  
						markdownText.setTextSize(16f);  
						markdownText.setTextColor(normalTextColor);  
						markdownText.setPadding(8, 8, 8, 4);  
						
						containerLayout.addView(markdownText);  
					}
					
				}
				
				ia_name_text.setText(chatList.get((int) _position).get("user").toString());
			}
			imageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					((ClipboardManager) getContext().getSystemService(getContext().getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", chatList.get((int) _position).get("text").toString()));
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