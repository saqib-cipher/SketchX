package Glab.SketchX;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
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
import com.caverock.androidsvg.*;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.*;
import com.google.android.material.button.MaterialButtonGroup;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.card.*;
import com.google.android.material.textfield.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.text.ClipboardManager;


public class ScanBottomdialogFragmentActivity extends BottomSheetDialogFragment {
	
	private HashMap<String, Object> temp_map1 = new HashMap<>();
	private double number = 0;
	private String temp_decrypted = "";
	private double n = 0;
	private String svg = "";
	private String svgName = "";
	private String id = "";
	private boolean filled = false;
	private boolean custom = false;
	private String K = "";
	private String L = "";
	private String path1 = "";
	private String t = "";
	private HashMap<String, Object> m = new HashMap<>();
	private boolean project = false;
	private boolean xml = false;
	private double posi = 0;
	private String savePath = "";
	
	private ArrayList<String> temp_str1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> temp_listmap1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> files = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	private ArrayList<String> s = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview2;
	private TextView textview1;
	private TextView textview3;
	private MaterialButtonToggleGroup linear18;
	private TextView textview6;
	private MaterialButtonToggleGroup linear24;
	private MaterialCardView cardview1;
	private MaterialCardView cardview3;
	private LinearLayout linear26;
	private MaterialButtonGroup linear27;
	private MaterialButton skproj;
	private MaterialButton fille;
	private MaterialButton icXml;
	private MaterialButton button2;
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
	private LinearLayout linear25;
	private TextView textview7;
	private TextInputLayout textinputlayout1;
	private MaterialButtonGroup linear28;
	private EditText edittext1;
	private Button button5;
	private Button button6;
	private Button button3;
	private Button button4;
	
	private SharedPreferences it;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.scan_bottomdialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear1 = _view.findViewById(R.id.linear1);
		linear2 = _view.findViewById(R.id.linear2);
		textview2 = _view.findViewById(R.id.textview2);
		textview1 = _view.findViewById(R.id.textview1);
		textview3 = _view.findViewById(R.id.textview3);
		linear18 = _view.findViewById(R.id.linear18);
		textview6 = _view.findViewById(R.id.textview6);
		linear24 = _view.findViewById(R.id.linear24);
		cardview1 = _view.findViewById(R.id.cardview1);
		cardview3 = _view.findViewById(R.id.cardview3);
		linear26 = _view.findViewById(R.id.linear26);
		linear27 = _view.findViewById(R.id.linear27);
		skproj = _view.findViewById(R.id.skproj);
		fille = _view.findViewById(R.id.fille);
		icXml = _view.findViewById(R.id.icXml);
		button2 = _view.findViewById(R.id.button2);
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
		linear25 = _view.findViewById(R.id.linear25);
		textview7 = _view.findViewById(R.id.textview7);
		textinputlayout1 = _view.findViewById(R.id.textinputlayout1);
		linear28 = _view.findViewById(R.id.linear28);
		edittext1 = _view.findViewById(R.id.edittext1);
		button5 = _view.findViewById(R.id.button5);
		button6 = _view.findViewById(R.id.button6);
		button3 = _view.findViewById(R.id.button3);
		button4 = _view.findViewById(R.id.button4);
		it = getContext().getSharedPreferences("save", Activity.MODE_PRIVATE);
		
		skproj.setOnClickListener(_v -> {
			project = true;
			_check();
		});
		
		fille.setOnClickListener(_v -> {
			project = false;
			_check();
		});
		
		icXml.setOnClickListener(_v -> xml = true);
		
		button2.setOnClickListener(_v -> xml = false);
		
		replace.setOnClickListener(_v -> {
			Bundle bundle = new Bundle();
			
			ProjectDialogFragmentActivity _fragment_ = new ProjectDialogFragmentActivity();
			_fragment_.setArguments(bundle);
			_fragment_.show(getActivity().getSupportFragmentManager(), "fragment");
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		button5.setOnClickListener(_v -> {
			it.edit().putString("rem", edittext1.getText().toString()).commit();
			textview1.setText("Saved text values ✓");
		});
		
		button6.setOnClickListener(_v -> {
			android.content.ClipboardManager clipboard =
			(android.content.ClipboardManager) requireContext().getSystemService(Context.CLIPBOARD_SERVICE);
			
			if (clipboard != null && clipboard.hasPrimaryClip()) {
				CharSequence pasteData = clipboard.getPrimaryClip().getItemAt(0).getText();
				if (pasteData != null) {
					edittext1.setText(pasteData.toString());
				}
			}
			
		});
		
		button3.setOnClickListener(_v -> dismiss());
		
		button4.setOnClickListener(_v -> {
			if (xml) {
				if (filled || custom) {
					
					
					ArrayList<HashMap<String, Object>> fileList = (ArrayList<HashMap<String, Object>>) getArguments().getSerializable("files");
					
					// Ensure the file list is valid
					if (fileList == null || fileList.isEmpty()) {
						
						textview1.setText("No files to process");
						return;
					}
					
					for (int n = fileList.size() - 1; n >= 0; n--) {
						HashMap<String, Object> fileMap = fileList.get(n);
						
						if (!fileMap.containsKey("selected") || !fileMap.get("selected").toString().equals("true")) {
							continue;
						}
						
						String filePath = fileMap.get("file").toString();
						File file = new File(filePath);
						if (!file.exists()) {
							
							textview1.setText("File not found: " + filePath);
							continue;
						}
						
						String svgContent = FileUtil.readFile(filePath);
						if (svgContent == null || svgContent.isEmpty()) {
							textview1.setText("Empty SVG File"); 
							continue;
						}
						
						
						String svgName = Uri.parse(filePath)
						.getLastPathSegment()
						.replaceAll("\\.svg$", "") // Removes only ".svg" extension
						.concat(".xml"); // Converts to ".xml"
						
						
						SvgParser.SvgAttributes parsedSvg = SvgParser.extractSvgDetails(svgContent);
						
						// Extract lists using **getter methods**
						List<String> paths = parsedSvg.getPaths();
						List<String> fills = parsedSvg.getFills();
						List<String> strokes = parsedSvg.getStrokes();
						List<String> strokeWidths = parsedSvg.getStrokeWidths();
						
						// Convert to Vector XML
						String vectorXml = convertSvgToVectorXML(paths, fills, strokes, strokeWidths, parsedSvg.getWidth(), parsedSvg.getHeight(), parsedSvg.getViewportWidth(), parsedSvg.getViewportHeight());
						
						
						if (project) {
							savePath = "/storage/emulated/0/.sketchware/data/" + id + "/files/resource/drawable/" + svgName;
						}
						else
						{
							savePath = edittext1.getText().toString() + svgName;
							
						}
						
						File directory = new File(savePath).getParentFile();
						
						
						if (!directory.exists()) directory.mkdirs();
						
						FileUtil.writeFile(savePath, vectorXml);
						
						textview1.setText("File saved: " + savePath);
					}
				} else {
					
					
					ArrayList<HashMap<String, Object>> fileList = (ArrayList<HashMap<String, Object>>) getArguments().getSerializable("files");
					
					
					// Ensure the file list is valid
					if (fileList == null || fileList.isEmpty()) {
						
						textview1.setText("No files to process");
						return;
					}
					
					for (int n = fileList.size() - 1; n >= 0; n--) {
						HashMap<String, Object> fileMap = fileList.get(n);
						
						if (!fileMap.containsKey("selected") || !fileMap.get("selected").toString().equals("true")) {
							continue;
						}
						
						String filePath = fileMap.get("file").toString();
						File file = new File(filePath);
						if (!file.exists()) {
							
							textview1.setText("File not found: " + filePath);
							continue;
						}
						
						String svgContent = FileUtil.readFile(filePath);
						if (svgContent == null || svgContent.isEmpty()) {
							textview1.setText("Empty SVG File"); 
							continue;
						}
						
						
						String svgName = Uri.parse(filePath)
						.getLastPathSegment()
						.replaceAll("\\.svg$", "") // Removes only ".svg" extension
						.concat(".xml"); // Converts to ".xml"
						
						List<String> paths = extractPathData(svgContent); // Extracted paths
						String vectorXml = convertSvgToVectorXML(paths, "#FF000000", "2.0");
						Log.d("GeneratedXML", vectorXml);
						
						
						
						if (project) {
							savePath = "/storage/emulated/0/.sketchware/data/" + id + "/files/resource/drawable/" + svgName;
						} else {
							
							savePath = edittext1.getText().toString() + svgName;
						}
						File directory = new File(savePath).getParentFile();
						
						if (!directory.exists()) directory.mkdirs();
						
						FileUtil.writeFile(savePath, vectorXml);
						
						textview1.setText("File saved: " + savePath);
					}
				}
			} else {
				if (project) {
					
					String saveRes = "/storage/emulated/0/.sketchware/data/" + id + "/resource";
					_c(saveRes);
					
					
					// ----------------------------------------------------
					// READ EXISTING INPUT (@images, @sounds… JSON objects)
					// ----------------------------------------------------
					String input = t;
					String[] lines = input.split("\n");
					
					String currentSection = "";
					
					for (String line : lines) {
						line = line.trim();
						if (line.equals("")) continue;
						
						if (line.startsWith("@")) {
							currentSection = line.replace("@", "").trim();
							continue;
						}
						
						if (line.startsWith("{") && line.endsWith("}")) {
							
							try {
								HashMap<String, Object> map =
								new Gson().fromJson(line, new TypeToken<HashMap<String, Object>>(){}.getType());
								
								if (map == null) continue;
								
								// VALIDATION – must contain required keys
								if (!map.containsKey("resFullName")
								|| !map.containsKey("resName")
								|| !map.containsKey("resType")) {
									continue;
								}
								
								// INTERNAL USE ONLY
								map.put("_section", currentSection);
								
								list.add(map);
								
							} catch (Exception e) {
								// invalid line is skipped
							}
						}
					}
					
					// ----------------------------------------------------
					// AUTO DETECT SECTION IF EMPTY
					// ----------------------------------------------------
					for (int i = 0; i < list.size(); i++) {
						HashMap<String, Object> item = list.get(i);
						
						String section = item.get("_section").toString();
						if (section.equals("")) {
							
							String name = item.get("resFullName").toString().toLowerCase();
							
							if (name.endsWith(".png") || name.endsWith(".jpg") || name.endsWith(".jpeg")) {
								section = "images";
							} else if (name.endsWith(".mp3") || name.endsWith(".wav") || name.endsWith(".opus")) {
								section = "sounds";
							} else if (name.endsWith(".ttf") || name.endsWith(".otf")) {
								section = "fonts";
							} else {
								section = "unknown";
							}
							
							item.put("_section", section);
						}
						
						list.set(i, item);
					}
					
					// ----------------------------------------------------
					// ADD NEW PNG ITEMS (SVG → PNG)
					// ----------------------------------------------------
					ArrayList<HashMap<String, Object>> fileList =
					(ArrayList<HashMap<String, Object>>) getArguments().getSerializable("files");
					
					if (fileList == null || fileList.isEmpty()) {
						textview1.setText("No files to process");
					} else {
						for (int n = fileList.size() - 1; n >= 0; n--) {
							
							HashMap<String, Object> fileMap = fileList.get(n);
							
							if (!fileMap.containsKey("selected") ||
							!fileMap.get("selected").toString().equals("true")) continue;
							
							String filePath = fileMap.get("file").toString();
							File file = new File(filePath);
							
							if (!file.exists()) {
								textview1.setText("File not found: " + filePath);
								continue;
							}
							
							String svgContent = FileUtil.readFile(filePath);
							if (svgContent == null || svgContent.isEmpty()) {
								textview1.setText("Empty SVG File");
								continue;
							}
							
							String pngName = Uri.parse(filePath)
							.getLastPathSegment()
							.replaceAll("\\.svg$", "") + ".png";
							
							String resName = pngName.replace(".png", "").replace("-", "_");
							
							File saveFile = new File("/storage/emulated/0/.sketchware/resources/images/" 
							+ id + "/" + pngName);
							
							File directory = saveFile.getParentFile();
							if (!directory.exists()) directory.mkdirs();
							
							try {
								SvgToPngHelper.convertSvgFileToPng(file, saveFile, 512, 512);
								textview1.setText("PNG saved: " + saveFile.getAbsolutePath());
								
							} catch (Exception e) {
								textview1.setText("Error: " + e.getMessage());
							}
							
							// ADD to list (OLD + NEW)
							HashMap<String, Object> m = new HashMap<>();
							m.put("_section", "images");
							m.put("resType", "1");
							m.put("resName", resName);
							m.put("resFullName", pngName);
							list.add(m);
						}
					}
					
					// ----------------------------------------------------
					// GENERATE FINAL OUTPUT (@images → items…)
					// ----------------------------------------------------
					StringBuilder out = new StringBuilder();
					String[] order = {"images", "sounds", "fonts"};
					
					for (String section : order) {
						
						out.append("@").append(section).append("\n");
						
						for (HashMap<String, Object> item : list) {
							
							if (item.get("_section").toString().equals(section)) {
								
								HashMap<String, Object> cleanItem = new HashMap<>(item);
								cleanItem.remove("_section");
								
								out.append("{\"resFullName\":\"")
								.append(cleanItem.get("resFullName"))
								.append("\",\"resName\":\"")
								.append(cleanItem.get("resName"))
								.append("\",\"resType\":")
								.append(cleanItem.get("resType"))
								.append("}\n");
							}
						}
					}
					String finalOutput = out.toString();
					t = finalOutput;
					
					
					_d(saveRes);
				} else {
					// ----------------------------------------------------
					// ADD NEW PNG ITEMS (SVG → PNG)
					// ----------------------------------------------------
					ArrayList<HashMap<String, Object>> fileList =
					(ArrayList<HashMap<String, Object>>) getArguments().getSerializable("files");
					
					if (fileList == null || fileList.isEmpty()) {
						textview1.setText("No files to process");
					} else {
						for (int n = fileList.size() - 1; n >= 0; n--) {
							
							HashMap<String, Object> fileMap = fileList.get(n);
							
							if (!fileMap.containsKey("selected") ||
							!fileMap.get("selected").toString().equals("true")) continue;
							
							String filePath = fileMap.get("file").toString();
							File file = new File(filePath);
							
							if (!file.exists()) {
								textview1.setText("File not found: " + filePath);
								continue;
							}
							
							String svgContent = FileUtil.readFile(filePath);
							if (svgContent == null || svgContent.isEmpty()) {
								textview1.setText("Empty SVG File");
								continue;
							}
							
							String pngName = Uri.parse(filePath)
							.getLastPathSegment()
							.replaceAll("\\.svg$", "") + ".png";
							
							
							
							File saveFile = new File(edittext1.getText().toString() + pngName);
							
							File directory = saveFile.getParentFile();
							if (!directory.exists()) directory.mkdirs();
							
							try {
								SvgToPngHelper.convertSvgFileToPng(file, saveFile, 512, 512);
								textview1.setText("PNG saved: " + saveFile.getAbsolutePath());
								
							} catch (Exception e) {
								textview1.setText("Error: " + e.getMessage());
							}
							
							
						}
					}
					
				}
			}
		});
	}
	
	private void initializeLogic() {
		textview1.setText("");
		filled = getArguments().getBoolean("filled");
		custom = getArguments().getBoolean("custom");
		K = "sketchwaresecure";
		n = 0;
		xml = true;
		project = true;
		skproj.performClick();
		icXml.performClick();
		if (it.contains("pos")) {
			_DCheck(it.getString("pos", ""), it.getString("name", ""), it.getString("pkg", ""), it.getString("cust", ""));
		} else {
			name.setText("No Project Selected!");
			packages.setText("First Select a Project to Import Icons");
			cardview2.setVisibility(View.GONE);
		}
		if (it.contains("rem")) edittext1.setText(it.getString("rem", ""));
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
	}
	
	public void _fu() {
	}
	
	private List<String> extractPathData(String svgContent) {
		List<String> pathList = new ArrayList<>();
		try {
			XmlPullParser parser = Xml.newPullParser();
			parser.setInput(new StringReader(svgContent));
			
			while (parser.next() != XmlPullParser.END_DOCUMENT) {
				if (parser.getEventType() == XmlPullParser.START_TAG && "path".equals(parser.getName())) {
					String pathData = parser.getAttributeValue(null, "d");
					pathList.add(pathData);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pathList;
	}
	
	{
	}
	
	
	public void _convert() {
	} private String convertSvgToVectorXML(List<String> pathDataList, String strokeColor, String strokeWidth) {
		StringBuilder xmlBuilder = new StringBuilder();
		
		xmlBuilder.append("<vector xmlns:android=\"http://schemas.android.com/apk/res/android\" ")
		.append("android:width=\"24dp\" android:height=\"24dp\" ")
		.append("android:viewportWidth=\"24\" android:viewportHeight=\"24\">\n");
		
		for (String pathData : pathDataList) {
			// Filter paths that are too large (possible unwanted backgrounds)
			if (!pathData.contains("M0 0") && !pathData.contains("H24V24H0Z")) {  
				xmlBuilder.append("    <path android:fillColor=\"#00000000\" ")
				.append("android:pathData=\"").append(pathData).append("\" ")
				.append("android:strokeColor=\"").append(strokeColor).append("\" ")
				.append("android:strokeWidth=\"").append(strokeWidth).append("\" ")
				.append("android:strokeLineCap=\"round\" ")
				.append("android:strokeLineJoin=\"round\"/>\n");
			}
		}
		
		xmlBuilder.append("</vector>");
		
		return xmlBuilder.toString();
	}
	{
	}
	
	
	public void _ConvrtM2forFilled() {
	}
	private String convertSvgToVectorXML(List<String> pathDataList, List<String> fills, List<String> strokes, List<String> strokeWidths, 
	String width, String height, String viewportWidth, String viewportHeight) {
		StringBuilder xmlBuilder = new StringBuilder();
		
		xmlBuilder.append("<vector xmlns:android=\"http://schemas.android.com/apk/res/android\" ")
		.append("android:width=\"").append(width).append("dp\" ")
		.append("android:height=\"").append(height).append("dp\" ")
		.append("android:viewportWidth=\"").append(viewportWidth).append("\" ")
		.append("android:viewportHeight=\"").append(viewportHeight).append("\">\n");
		
		for (int i = 0; i < pathDataList.size(); i++) {
			String pathData = pathDataList.get(i);
			String fillColor = (fills.size() > i) ? fills.get(i) : "none";
			String strokeColor = (strokes.size() > i) ? strokes.get(i) : "none";
			String strokeWidth = (strokeWidths.size() > i) ? strokeWidths.get(i) : "1.0";
			
			// **Filter out unwanted large paths that might introduce background**
			if (pathData.contains("M0 0") || pathData.contains("H24V24H0Z")) {
				continue;  
			}
			
			// Ensure correct detection
			boolean isOutlined = strokeColor != null && !strokeColor.equalsIgnoreCase("none");
			boolean isFilled = fillColor != null && !fillColor.equalsIgnoreCase("none");
			
			xmlBuilder.append("    <path android:pathData=\"").append(pathData).append("\" ");
			
			// **Fix: Replace `"none"` colors to prevent Sketchware errors**
			if (fillColor.equalsIgnoreCase("none")) {
				fillColor = "#FFFFFFFF"; // Default white if no fill is specified
			} else if (fillColor.equalsIgnoreCase("currentColor")) {
				fillColor = "#FF000000"; // Default black for `currentColor`
			}
			xmlBuilder.append("android:fillColor=\"").append(fillColor).append("\" ");
			
			if (isOutlined) {
				if (strokeColor.equalsIgnoreCase("none")) {
					strokeColor = "#FF000000"; // Default black if stroke is unspecified
				}
				xmlBuilder.append("android:strokeColor=\"").append(strokeColor).append("\" ")
				.append("android:strokeWidth=\"").append(strokeWidth).append("\" ")
				.append("android:strokeLineCap=\"round\" ")
				.append("android:strokeLineJoin=\"round\" ");
			}
			
			xmlBuilder.append("/>\n");
		}
		
		xmlBuilder.append("</vector>");
		
		return xmlBuilder.toString();
	}
	{
	}
	
	
	public void _v() {
	}
	int yy;
	{
	}
	
	
	public void _c(final String _str) {
		try {
			int i = this.yy;
			javax.crypto.Cipher instance = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] bytes = this.K.getBytes();
			instance.init(2, new javax.crypto.spec.SecretKeySpec(bytes, "AES"), new javax.crypto.spec.IvParameterSpec(bytes));
			java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(_str, "r");
			byte[] bArr = new byte[((int) randomAccessFile.length())];
			randomAccessFile.readFully(bArr);
			this.t = new String(instance.doFinal(bArr));
			
			
		} catch (Exception e) {
			Toast.makeText(getContext().getApplicationContext(), e.toString(), 0).show();
		}
	}
	
	
	public void _d(final String _str) {
		path1 = _str;
		try {
			int i = yy + 1;
			javax.crypto.Cipher instance = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] bytes = this.K.getBytes();
			instance.init(1, new javax.crypto.spec.SecretKeySpec(bytes, "AES"), new javax.crypto.spec.IvParameterSpec(bytes));
			byte[] bytes1 = this.t.getBytes();
			new java.io.RandomAccessFile(path1, "rw").write(instance.doFinal(bytes1));
			
		} catch (Exception e) {
			Toast.makeText(getContext().getApplicationContext(), e.toString(), 0).show();
		}
	}
	
	
	public void _check() {
		if (project) {
			cardview1.setVisibility(View.VISIBLE);
			cardview3.setVisibility(View.GONE);
		} else {
			cardview1.setVisibility(View.GONE);
			cardview3.setVisibility(View.VISIBLE);
		}
	}
	
	
	public void _DCheck(final String _Pos, final String _name, final String _pkg, final String _cust) {
		id = _Pos;
		num.setText(_Pos);
		name.setText(_name);
		packages.setText(_pkg);
		cardview2.setVisibility(View.VISIBLE);
		if (_cust.equals("true")) imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath("/storage/emulated/0/.sketchware/resources/icons/".concat(_Pos.concat("/icon.png")), 1024, 1024)); else imageview1.setImageResource(R.drawable.default_image);
	}
	
}