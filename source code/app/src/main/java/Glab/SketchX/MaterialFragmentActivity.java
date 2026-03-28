package Glab.SketchX;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
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
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.caverock.androidsvg.*;
import com.google.android.material.button.*;
import com.google.android.material.button.MaterialButtonGroup;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.button.MaterialSplitButton;
import com.google.android.material.chip.*;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.search.SearchBar;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;
import com.google.android.material.switchmaterial.SwitchMaterial;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class MaterialFragmentActivity extends Fragment {
	
	private Timer _timer = new Timer();
	
	private String GitUrl = "";
	private String GitIconBtUrl = "";
	private String BtConvrt = "";
	private String BtGitUrl = "";
	private String IconBtDesc = "";
	private String BtGrpCnvert = "";
	private String BtGrpDesc = "";
	private String BtGrpUrl = "";
	private String switchCONV = "";
	private String SwitchUrl = "";
	private double progress = 0;
	private String linearprogressCnrvt = "";
	private String linearprogressUrl = "";
	private String linearprogressDesc = "";
	private String ChipCnvrt = "";
	private String ChipUrl = "";
	private String ChipDesc = "";
	private String LoadingConvrt = "";
	private String LoadingUrl = "";
	private String SliderConvrt = "";
	private String SliderUrl = "";
	private String SliderDesc = "";
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private SearchBar linear2;
	private SearchBar linear3;
	private LinearLayout ln_1;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private TextView textview15;
	private Slider seekbar1;
	private TextView textview16;
	private LinearLayout linear31;
	private LinearLayout linear32;
	private TextView textview19;
	private LinearLayout linear34;
	private TextView textview20;
	private LinearLayout linear35;
	private LinearLayout linear37;
	private TextView textview22;
	private TextView tv_1;
	private LinearLayout ln_2;
	private TextView tv_2;
	private LinearLayout ln_3;
	private TextView tv_3;
	private LinearLayout ln_4;
	private TextView tv_4;
	private LinearLayout ln_5;
	private TextView tv_5;
	private LinearLayout ln_6;
	private TextView tv_6;
	private LinearLayout ln_7;
	private LinearLayout linear4;
	private MaterialButton materialbutton1;
	private MaterialButton textview8;
	private MaterialButton materialbutton3;
	private MaterialButton textview9;
	private MaterialButton materialbutton5;
	private MaterialButton textview10;
	private MaterialButton materialbutton7;
	private MaterialButton textview11;
	private MaterialButton materialbutton9;
	private MaterialButton textview12;
	private MaterialButton materialbutton_1;
	private MaterialButton materialbutton_2;
	private MaterialButton materialbutton_3;
	private MaterialButton materialbutton_4;
	private MaterialButton linear5;
	private MaterialButton linear6;
	private MaterialButton linear7;
	private MaterialButton linear8;
	private TextView textview13;
	private TextView textview1;
	private MaterialButtonToggleGroup btngroup_1;
	private TextView textview2;
	private MaterialButtonGroup btngroup_2;
	private TextView textview3;
	private MaterialButtonToggleGroup btngroup_3;
	private TextView textview4;
	private MaterialButtonGroup btngroup_4;
	private MaterialButton textview5;
	private MaterialButton materialbutton2;
	private MaterialButton textview6;
	private MaterialButton buttonicon1;
	private MaterialButton buttonicon2;
	private MaterialButton buttonicon3;
	private MaterialButton materialbutton4;
	private MaterialButton textview7;
	private MaterialButton materialbutton6;
	private MaterialButton materialbutton10;
	private MaterialButton buttonicon6;
	private MaterialButton buttonicon5;
	private TextView textview14;
	private LinearLayout linear11;
	private SwitchMaterial materialswitch2;
	private MaterialSwitch materialswitch1;
	private MaterialSwitch switch1;
	private LinearLayout linear15;
	private LinearProgressIndicator progressbar1;
	private LinearLayout linear13;
	private LinearProgressIndicator progressbar2;
	private LinearLayout linear16;
	private CircularProgressIndicator progressbar3;
	private LinearLayout linear17;
	private CircularProgressIndicator progressbar4;
	private TextView textview17;
	private HorizontalScrollView hscroll1;
	private TextView textview18;
	private ChipGroup chipgroup_2;
	private LinearLayout linear33;
	private Chip materialchip1;
	private Chip materialchip2;
	private Chip materialchip3;
	private Chip materialchip4;
	private Chip materialchip5;
	private Chip materialchip6;
	private Chip materialchip7;
	private Chip materialchip8;
	private Chip materialchip9;
	private Chip materialchip15;
	private Chip materialchip16;
	private Chip materialchip19;
	private LoadingIndicator loadingindicator;
	private LoadingIndicator loadingindicator2;
	private MaterialSplitButton linear36;
	private Button button1;
	private Button button2;
	private TextView textview21;
	private Slider seekbar2;
	private Slider seekbar3;
	private Slider seekbar4;
	private RangeSlider seekbar5;
	private LinearLayout linear38;
	private MaterialButton button3;
	private MaterialButton button4;
	private MaterialButton button5;
	private MaterialButton button6;
	
	private TimerTask t;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.material_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		vscroll1 = _view.findViewById(R.id.vscroll1);
		linear1 = _view.findViewById(R.id.linear1);
		linear2 = _view.findViewById(R.id.linear2);
		linear3 = _view.findViewById(R.id.linear3);
		ln_1 = _view.findViewById(R.id.ln_1);
		linear9 = _view.findViewById(R.id.linear9);
		linear10 = _view.findViewById(R.id.linear10);
		textview15 = _view.findViewById(R.id.textview15);
		seekbar1 = _view.findViewById(R.id.seekbar1);
		textview16 = _view.findViewById(R.id.textview16);
		linear31 = _view.findViewById(R.id.linear31);
		linear32 = _view.findViewById(R.id.linear32);
		textview19 = _view.findViewById(R.id.textview19);
		linear34 = _view.findViewById(R.id.linear34);
		textview20 = _view.findViewById(R.id.textview20);
		linear35 = _view.findViewById(R.id.linear35);
		linear37 = _view.findViewById(R.id.linear37);
		textview22 = _view.findViewById(R.id.textview22);
		tv_1 = _view.findViewById(R.id.tv_1);
		ln_2 = _view.findViewById(R.id.ln_2);
		tv_2 = _view.findViewById(R.id.tv_2);
		ln_3 = _view.findViewById(R.id.ln_3);
		tv_3 = _view.findViewById(R.id.tv_3);
		ln_4 = _view.findViewById(R.id.ln_4);
		tv_4 = _view.findViewById(R.id.tv_4);
		ln_5 = _view.findViewById(R.id.ln_5);
		tv_5 = _view.findViewById(R.id.tv_5);
		ln_6 = _view.findViewById(R.id.ln_6);
		tv_6 = _view.findViewById(R.id.tv_6);
		ln_7 = _view.findViewById(R.id.ln_7);
		linear4 = _view.findViewById(R.id.linear4);
		materialbutton1 = _view.findViewById(R.id.materialbutton1);
		textview8 = _view.findViewById(R.id.textview8);
		materialbutton3 = _view.findViewById(R.id.materialbutton3);
		textview9 = _view.findViewById(R.id.textview9);
		materialbutton5 = _view.findViewById(R.id.materialbutton5);
		textview10 = _view.findViewById(R.id.textview10);
		materialbutton7 = _view.findViewById(R.id.materialbutton7);
		textview11 = _view.findViewById(R.id.textview11);
		materialbutton9 = _view.findViewById(R.id.materialbutton9);
		textview12 = _view.findViewById(R.id.textview12);
		materialbutton_1 = _view.findViewById(R.id.materialbutton_1);
		materialbutton_2 = _view.findViewById(R.id.materialbutton_2);
		materialbutton_3 = _view.findViewById(R.id.materialbutton_3);
		materialbutton_4 = _view.findViewById(R.id.materialbutton_4);
		linear5 = _view.findViewById(R.id.linear5);
		linear6 = _view.findViewById(R.id.linear6);
		linear7 = _view.findViewById(R.id.linear7);
		linear8 = _view.findViewById(R.id.linear8);
		textview13 = _view.findViewById(R.id.textview13);
		textview1 = _view.findViewById(R.id.textview1);
		btngroup_1 = _view.findViewById(R.id.btngroup_1);
		textview2 = _view.findViewById(R.id.textview2);
		btngroup_2 = _view.findViewById(R.id.btngroup_2);
		textview3 = _view.findViewById(R.id.textview3);
		btngroup_3 = _view.findViewById(R.id.btngroup_3);
		textview4 = _view.findViewById(R.id.textview4);
		btngroup_4 = _view.findViewById(R.id.btngroup_4);
		textview5 = _view.findViewById(R.id.textview5);
		materialbutton2 = _view.findViewById(R.id.materialbutton2);
		textview6 = _view.findViewById(R.id.textview6);
		buttonicon1 = _view.findViewById(R.id.buttonicon1);
		buttonicon2 = _view.findViewById(R.id.buttonicon2);
		buttonicon3 = _view.findViewById(R.id.buttonicon3);
		materialbutton4 = _view.findViewById(R.id.materialbutton4);
		textview7 = _view.findViewById(R.id.textview7);
		materialbutton6 = _view.findViewById(R.id.materialbutton6);
		materialbutton10 = _view.findViewById(R.id.materialbutton10);
		buttonicon6 = _view.findViewById(R.id.buttonicon6);
		buttonicon5 = _view.findViewById(R.id.buttonicon5);
		textview14 = _view.findViewById(R.id.textview14);
		linear11 = _view.findViewById(R.id.linear11);
		materialswitch2 = _view.findViewById(R.id.materialswitch2);
		materialswitch1 = _view.findViewById(R.id.materialswitch1);
		switch1 = _view.findViewById(R.id.switch1);
		linear15 = _view.findViewById(R.id.linear15);
		progressbar1 = _view.findViewById(R.id.progressbar1);
		linear13 = _view.findViewById(R.id.linear13);
		progressbar2 = _view.findViewById(R.id.progressbar2);
		linear16 = _view.findViewById(R.id.linear16);
		progressbar3 = _view.findViewById(R.id.progressbar3);
		linear17 = _view.findViewById(R.id.linear17);
		progressbar4 = _view.findViewById(R.id.progressbar4);
		textview17 = _view.findViewById(R.id.textview17);
		hscroll1 = _view.findViewById(R.id.hscroll1);
		textview18 = _view.findViewById(R.id.textview18);
		chipgroup_2 = _view.findViewById(R.id.chipgroup_2);
		linear33 = _view.findViewById(R.id.linear33);
		materialchip1 = _view.findViewById(R.id.materialchip1);
		materialchip2 = _view.findViewById(R.id.materialchip2);
		materialchip3 = _view.findViewById(R.id.materialchip3);
		materialchip4 = _view.findViewById(R.id.materialchip4);
		materialchip5 = _view.findViewById(R.id.materialchip5);
		materialchip6 = _view.findViewById(R.id.materialchip6);
		materialchip7 = _view.findViewById(R.id.materialchip7);
		materialchip8 = _view.findViewById(R.id.materialchip8);
		materialchip9 = _view.findViewById(R.id.materialchip9);
		materialchip15 = _view.findViewById(R.id.materialchip15);
		materialchip16 = _view.findViewById(R.id.materialchip16);
		materialchip19 = _view.findViewById(R.id.materialchip19);
		loadingindicator = _view.findViewById(R.id.loadingindicator);
		loadingindicator2 = _view.findViewById(R.id.loadingindicator2);
		linear36 = _view.findViewById(R.id.linear36);
		button1 = _view.findViewById(R.id.button1);
		button2 = _view.findViewById(R.id.button2);
		textview21 = _view.findViewById(R.id.textview21);
		seekbar2 = _view.findViewById(R.id.seekbar2);
		seekbar3 = _view.findViewById(R.id.seekbar3);
		seekbar4 = _view.findViewById(R.id.seekbar4);
		seekbar5 = _view.findViewById(R.id.seekbar5);
		linear38 = _view.findViewById(R.id.linear38);
		button3 = _view.findViewById(R.id.button3);
		button4 = _view.findViewById(R.id.button4);
		button5 = _view.findViewById(R.id.button5);
		button6 = _view.findViewById(R.id.button6);
		
		linear2.setOnClickListener(_v -> _wdiget("android:layout_marginEnd=\"8dp\"\n          android:layout_marginStart=\"8dp\"\n          android:hint=\"Search Bar\"", "com.google.android.material.search.SearchBar", "https://github.com/material-components/material-components-android/blob/master/docs/components/Search.md#searchbar-in-materialtoolbar", true, ""));
		
		linear3.setOnClickListener(_v -> _wdiget("android:layout_marginEnd=\"8dp\"\nandroid:layout_marginStart=\"8dp\"\nandroid:hint=\"Search Bar *Exp\"\nstyle=\"@style/Widget.Material3Expressive.SearchBar.AppBarWithSearch\"", "com.google.android.material.search.SearchBar", "https://github.com/material-components/material-components-android/blob/master/docs/components/Search.md#searchbar-in-materialtoolbar", true, "This is expressive design you have to use with M3 toolbar \n\n@style/Widget.Material3Expressive.SearchBar\n@style/Widget.Material3Expressive.SearchBar.Centered.Text"));
		
		materialbutton1.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3.Button.ElevatedButton\"", BtConvrt, BtGitUrl, true, ""));
		
		textview8.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3Expressive.Button.ElevatedButton\"", BtConvrt, BtGitUrl, true, ""));
		
		materialbutton3.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3.Button\"", "com.google.android.material.button.MaterialButton", "https://github.com/material-components/material-components-android/blob/master/docs/components/CommonButton.md#filled-button", true, "You may leave the Style, Default button style is filled "));
		
		textview9.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3Expressive.Button\"", BtConvrt, BtGitUrl, true, ""));
		
		materialbutton5.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3.Button.TonalButton\"", BtConvrt, BtGitUrl, true, ""));
		
		textview10.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3Expressive.Button.TonalButton\"", BtConvrt, BtGitUrl, true, ""));
		
		materialbutton7.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3.Button.OutlinedButton\"", BtConvrt, BtGitUrl, true, ""));
		
		textview11.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3Expressive.Button.OutlinedButton\"", BtConvrt, BtGitUrl, true, ""));
		
		materialbutton9.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3.Button.TextButton\"", BtConvrt, "https://github.com/material-components/material-components-android/blob/master/docs/components/CommonButton.md#text", true, ""));
		
		textview12.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3Expressive.Button.TextButton\"", BtConvrt, "https://github.com/material-components/material-components-android/blob/master/docs/components/CommonButton.md#text", true, ""));
		
		materialbutton_1.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3.Button.IconButton\"\napp:icon=\"@drawable/ic_fav\"", BtConvrt, GitIconBtUrl, true, "Remove or Change the icon name accordingly to you"));
		
		materialbutton_2.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3.Button.IconButton.Filled\"\napp:icon=\"@drawable/ic_fav\"", BtConvrt, GitIconBtUrl, true, IconBtDesc));
		
		materialbutton_3.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3.Button.IconButton.Filled.Tonal\"\napp:icon=\"@drawable/ic_fav\"", BtConvrt, GitIconBtUrl, true, IconBtDesc));
		
		materialbutton_4.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3.Button.IconButton.Outlined\"\napp:icon=\"@drawable/ic_fav\"", BtConvrt, GitIconBtUrl, true, IconBtDesc));
		
		linear5.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3Expressive.Button.IconButton.Standard\"\napp:icon=\"@drawable/ic_fav\"", BtConvrt, GitIconBtUrl, true, IconBtDesc));
		
		linear6.setOnClickListener(_v -> _wdiget("style=@style/Widget.Material3Expressive.Button.IconButton.Filled\"\napp:icon=\"@drawable/ic_fav\"", BtConvrt, GitIconBtUrl, true, IconBtDesc));
		
		linear7.setOnClickListener(_v -> _wdiget("style=@style/Widget.Material3Expressive.Button.IconButton.Tonal\"\napp:icon=\"@drawable/ic_fav\"", BtConvrt, GitIconBtUrl, true, IconBtDesc));
		
		linear8.setOnClickListener(_v -> _wdiget("style=@style/Widget.Material3Expressive.Button.IconButton.Outlined\"\napp:icon=\"@drawable/ic_fav\"", BtConvrt, GitIconBtUrl, true, IconBtDesc));
		
		materialswitch2.setOnLongClickListener(_v -> {
			_wdiget("app:switchPadding=\"8dp\"\napp:useMaterialThemeColors=\"true\"", "com.google.android.material.switchmaterial.SwitchMaterial", "https://github.com/material-components/material-components-android/blob/master/docs/components/Switch.md#switch-deprecated", true, "This is M2 Switch ");
			return true;
		});
		
		materialswitch1.setOnLongClickListener(_v -> {
			_wdiget("", switchCONV, SwitchUrl, true, "");
			return true;
		});
		
		switch1.setOnLongClickListener(_v -> {
			_wdiget("app:switchPadding=\"8dp\"\nstyle=\"@style/Widget.Material3.CompoundButton.MaterialSwitch\"\napp:thumbIcon=\"@drawable/thumb_icon_selector\"", switchCONV, SwitchUrl, true, "This is Switch with **custom thumb** icon\n\n**Step 1 — Add icons**\nPut two icons in \"res/drawable/\"\nic_thumb_on.xml\nic_thumb_off.xml\n\n**Step 2 — Create thumb icon selector**\nCreate a new drawable file:\nres/drawable/thumb_icon_selector.xml\n\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<selector xmlns:android=\"http://schemas.android.com/apk/res/android\">\n\n    <!-- Selected / ON -->\n    <item\n        android:state_checked=\"true\"\n        android:drawable=\"@drawable/ic_thumb_on\"/>\n\n    <!-- Unselected / OFF -->\n    <item\n    android:state_checked=\"false\"\n        android:drawable=\"@drawable/ic_thumb_off\"/>\n\n</selector>");
			return true;
		});
		
		progressbar1.setOnClickListener(_v -> _wdiget("android:indeterminate=\"true\"", linearprogressCnrvt, linearprogressUrl, true, linearprogressDesc));
		
		progressbar2.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3Expressive.LinearProgressIndicator.Wavy\"\nandroid:indeterminate=\"true\"", linearprogressCnrvt, linearprogressUrl, true, linearprogressDesc));
		
		progressbar3.setOnClickListener(_v -> _wdiget("android:indeterminate=\"true\"", linearprogressCnrvt.replace("Linear", "Circular"), linearprogressUrl, true, linearprogressDesc));
		
		progressbar4.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3Expressive.CircularProgressIndicator.Wavy\"\nandroid:indeterminate=\"true\"", linearprogressCnrvt.replace("Linear", "Circular"), linearprogressUrl, true, linearprogressDesc));
		
		materialchip1.setOnLongClickListener(_v -> {
			_wdiget("style=\"@style/Widget.MaterialComponents.Chip.Choice\"", ChipCnvrt, ChipUrl, true, ChipDesc);
			return true;
		});
		
		materialchip2.setOnLongClickListener(_v -> {
			_wdiget("app:chipIcon=\"@drawable/ic_fav\"\nstyle=\"@style/Widget.Material3.Chip.Assist\"\napp:chipIconTint=\"?attr/colorOnSurfaceVariant\"", ChipCnvrt, ChipUrl, true, ChipDesc);
			return true;
		});
		
		materialchip3.setOnLongClickListener(_v -> {
			_wdiget("app:chipIcon=\"@drawable/ic_fav\"\nstyle=\"@style/Widget.Material3.Chip.Assist.Elevated\"\napp:chipIconTint=\"?attr/colorOnSurfaceVariant\"", ChipCnvrt, ChipUrl, true, ChipDesc);
			return true;
		});
		
		materialchip4.setOnLongClickListener(_v -> {
			_wdiget("style=\"@style/Widget.Material3.Chip.Filter\"", ChipCnvrt, ChipUrl, true, ChipDesc);
			return true;
		});
		
		materialchip5.setOnLongClickListener(_v -> {
			_wdiget("style=\"@style/Widget.Material3.Chip.Filter.Elevated\"", ChipCnvrt, ChipUrl, true, ChipDesc);
			return true;
		});
		
		materialchip6.setOnLongClickListener(_v -> {
			_wdiget("style=\"@style/Widget.Material3.Chip.Input\"\napp:checkedIcon=\"@drawable/ic_fav\"\napp:checkedIconTint=\"?attr/colorOnSurfaceVariant\"", ChipCnvrt, ChipUrl, true, ChipDesc);
			return true;
		});
		
		materialchip7.setOnLongClickListener(_v -> {
			_wdiget("app:chipIcon=\"@drawable/ic_fav\"\napp:checkedIcon=\"@drawable/ic_fav\"\nstyle=\"@style/Widget.Material3.Chip.Input.Icon\"\napp:chipIconTint=\"?attr/colorOnSurfaceVariant\"\napp:checkedIconTint=\"?attr/colorOnSurfaceVariant\"", ChipCnvrt, ChipUrl, true, ChipDesc);
			return true;
		});
		
		materialchip8.setOnLongClickListener(_v -> {
			_wdiget("style=\"@style/Widget.Material3.Chip.Suggestion\"", ChipCnvrt, ChipUrl, true, ChipDesc);
			return true;
		});
		
		materialchip9.setOnLongClickListener(_v -> {
			_wdiget("style=\"@style/Widget.Material3.Chip.Suggestion.Elevated\"", ChipCnvrt, ChipUrl, true, ChipDesc);
			return true;
		});
		
		loadingindicator.setOnClickListener(_v -> _wdiget("", LoadingConvrt, LoadingUrl, true, ""));
		
		loadingindicator2.setOnClickListener(_v -> _wdiget("style=\"@style/Widget.Material3.LoadingIndicator.Contained\"", LoadingConvrt, LoadingUrl, true, ""));
		
		button1.setOnClickListener(_v -> _wdiget("style=\"?attr/materialSplitButtonLeadingFilledStyle\"\napp:icon=\"@drawable/ic_fav\"", BtConvrt, "https://github.com/material-components/material-components-android/blob/master/docs/components/SplitButton.md", true, ""));
		
		button2.setOnClickListener(_v -> _wdiget("style=\"?attr/materialSplitButtonIconFilledStyle\"\napp:icon=\"@drawable/ic_fav\"", BtConvrt, "https://github.com/material-components/material-components-android/blob/master/docs/components/SplitButton.md", true, ""));
	}
	
	private void initializeLogic() {
		BtConvrt = "com.google.android.material.button.MaterialButton";
		GitIconBtUrl = "https://github.com/material-components/material-components-android/blob/master/docs/components/IconButton.md";
		BtGitUrl = "https://github.com/material-components/material-components-android/blob/master/docs/components/CommonButton.md#filled-button";
		IconBtDesc = "Remove or Change the icon name accordingly to you";
		BtGrpCnvert = "com.google.android.material.button.MaterialButtonToggleGroup";
		BtGrpDesc = "Convert linear and add outlined buttons into that and change attributes of group Linear as you want \napp:singleSelection=\"true\" or false\napp:selectionRequired=\"true\" or false\n\nToggle and non-Toggle group are different \n";
		BtGrpUrl = "https://github.com/material-components/material-components-android/blob/master/docs/components/ToggleButtonGroup.md\n";
		switchCONV = "com.google.android.material.materialswitch.MaterialSwitch";
		SwitchUrl = "https://github.com/material-components/material-components-android/blob/master/docs/components/Switch.md";
		linearprogressCnrvt = "com.google.android.material.progressindicator.LinearProgressIndicator";
		linearprogressUrl = "https://github.com/material-components/material-components-android/blob/master/docs/components/ProgressIndicator.md";
		ChipCnvrt = "com.google.android.material.chip.Chip";
		ChipUrl = "https://github.com/material-components/material-components-android/blob/master/docs/components/Chip.md";
		ChipDesc = "For more & easy details search **Chip Group** in Codes section\n\nChecked by default (already checked)\nandroid:checked=\"true\"\n\napp:checkedIcon=\"@drawable/icon\"\napp:checkedIconVisible       (true/false)\napp:checkedIconTint=\"?attr/colorOnSecondaryContainer\"\n\nandroid:text=\"Your text\"\nandroid:textColor=\"?attr/colorOnSurfaceVariant\"\n\n**Chip Group Attribute**\napp:singleLine (true or false)\napp:singleSelection=\"true\"\napp:selectionRequired=\"true\"";
		linearprogressDesc = "**Change Intermediate to determine**\nprogressbar.setIndeterminate(false);\n   progressbar.setProgress((int) value); \n\n**For smooth animation**\nprogressbar.setProgress((int) value, true); \n\n**Note:** progressbar is id and value (number) is progress ";
		LoadingConvrt = "com.google.android.material.loadingindicator.LoadingIndicator";
		LoadingUrl = "https://github.com/material-components/material-components-android/blob/master/docs/components/LoadingIndicator.md";
		SliderConvrt = "com.google.android.material.slider.Slider";
		SliderUrl = "https://github.com/material-components/material-components-android/blob/master/docs/components/Slider.md";
		SliderDesc = "Convert Seekbar\n\n**You can Set Value**\nandroid:value=\"20.0\"\nandroid:valueFrom=\"0.0\"\nandroid:valueTo=\"100.0\"\nandroid:stepSize=\"10.0\"\n\n**Get Current value** *(use in onCreate)*\n\nslider.addOnChangeListener(new Slider.OnChangeListener() {\n    @Override\n    public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {\n        \n//**value** (number) is current value\n\n}\n});";
		_BtGroup();
		seekbar1.addOnChangeListener(new Slider.OnChangeListener() {
			@Override
			public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
				
				
				if ((value == 0) || (value == 100)) _setPr(false, 0); else _setPr(true, value);
			}
		});
		Chip[] vieew = {materialchip15, materialchip16, materialchip19};
		for (int i = 0; i < vieew.length; i++) {
			final Chip ViewsGr = vieew[i];
			ViewsGr.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_wdiget("app:singleSelection=\"false\"", "com.google.android.material.chip.Chip", ChipUrl, true, ChipDesc);
					return true;
				}
			});
		}
	}
	
	public void _wdiget(final String _inject, final String _convert, final String _imp, final boolean _tr, final String _desc) {
		Bundle bundle = new Bundle();
		bundle.putString("inject", _inject); 
		bundle.putString("convert", _convert); 
		bundle.putString("GitUrl", _imp); 
		bundle.putString("desc", _desc); 
		MaterialwidBottomdialogFragmentActivity _fragment_ = new MaterialwidBottomdialogFragmentActivity();
		_fragment_.setArguments(bundle);
		_fragment_.show(getActivity().getSupportFragmentManager(), "fragment");
	}
	
	
	public void _BtGroup() {
		View[] vieew2 = {buttonicon1, buttonicon2, buttonicon3};
		for (int i = 0; i < vieew2.length; i++) {
			final View ViewsGr = vieew2[i];
			ViewsGr.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_wdiget("style=\"@style/Widget.Material3.MaterialButtonGroup.Connected\"", "com.google.android.material.button.MaterialButtonGroup", "https://github.com/material-components/material-components-android/blob/master/docs/components/ButtonGroup.md", true, BtGrpDesc);
					return true;
				}
			});
		}
		//Blocks.made by Grafix Lab
		
		View[] vieew3 = {materialbutton4, textview7, materialbutton6};
		for (int i = 0; i < vieew3.length; i++) {
			final View ViewsGr = vieew3[i];
			ViewsGr.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_wdiget("app:singleSelection=\"false\"\nstyle=\"@style/Widget.Material3Expressive.MaterialButtonToggleGroup\"", BtGrpCnvert, BtGrpUrl, true, BtGrpDesc);
					return true;
				}
			});
		}
		//Blocks.made by Grafix Lab
		
		View[] vieew4 = {materialbutton10, buttonicon5, buttonicon6};
		for (int i = 0; i < vieew4.length; i++) {
			final View ViewsGr = vieew4[i];
			ViewsGr.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_wdiget("style=\"@style/Widget.Material3Expressive.MaterialButtonGroup\"", "com.google.android.material.button.MaterialButtonGroup", "https://github.com/material-components/material-components-android/blob/master/docs/components/ButtonGroup.md", true, BtGrpDesc);
					return true;
				}
			});
		}
		//Blocks.made by Grafix Lab
		
		View[] vieew = {textview5, materialbutton2, textview6};
		for (int i = 0; i < vieew.length; i++) {
			final View ViewsGr = vieew[i];
			ViewsGr.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_wdiget("app:singleSelection=\"true\"", BtGrpCnvert, BtGrpUrl, true, BtGrpDesc);
					return true;
				}
			});
		}
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_wdiget("android:value=\"20.0\"\nandroid:valueFrom=\"0.0\"\nandroid:valueTo=\"100.0\"", SliderConvrt, SliderUrl, true, SliderDesc);
			}
		});
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_wdiget("android:valueFrom=\"0.0\"\nandroid:valueTo=\"100.0\"\nandroid:stepSize=\"10.0\"", SliderConvrt, SliderUrl, true, SliderDesc);
			}
		});
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_wdiget("android:value=\"0.0\"\nandroid:valueFrom=\"-100.0\"\nandroid:valueTo=\"100.0\"", SliderConvrt, SliderUrl, true, SliderDesc);
			}
		});
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_wdiget("android:valueFrom=\"0.0\"\n    android:valueTo=\"100.0\"\n    app:values=\"@array/initial_slider_values\"\n    android:stepSize=\"10.0\"", SliderConvrt.replace("Slider", "RangeSlider"), SliderUrl, true, SliderDesc.concat("\n**Add in values/arrays.xml**\n<resources>\n  <array name=\"initial_slider_values\">\n    <item>20.0</item>\n    <item>70.0</item>\n  </array>\n</resources>"));
			}
		});
	}
	
	
	public void _setPr(final boolean _tr, final double _po) {
		List<LinearProgressIndicator> indicators = Arrays.asList(progressbar1, progressbar2);
		
		if (_tr) {
			// Or set all to a specific value
			for (LinearProgressIndicator p : indicators) {
				p.setIndeterminate(false);
				p.setProgress((int) _po); 
			}
		} else {
			// Switch all to indeterminate
			for (LinearProgressIndicator p : indicators) {
				p.setIndeterminate(true);
			}
		}
		List<CircularProgressIndicator> indicatorsC = Arrays.asList(progressbar3, progressbar4);
		
		if (_tr) {
			// Or set all to a specific value
			for (CircularProgressIndicator n : indicatorsC) {
				n.setIndeterminate(false);
				n.setProgress((int) _po); 
			}
		} else {
			// Switch all to indeterminate
			for (CircularProgressIndicator n : indicatorsC) {
				n.setIndeterminate(true);
			}
		}
	}
	
}