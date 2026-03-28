package Glab.SketchX;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.caverock.androidsvg.*;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButtonGroup;
import com.google.android.material.card.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MaterialwidBottomdialogFragmentActivity extends BottomSheetDialogFragment {
	
	private String GitUrl = "";
	
	private LinearLayout linear2;
	private LinearLayout linear34;
	private Button button8;
	private RelativeLayout relativelayout2;
	private ScrollView vscroll1;
	private MaterialButtonGroup linear20;
	private LinearLayout linear31;
	private MaterialCardView cardview2;
	private MaterialCardView cardview3;
	private TextView description;
	private LinearLayout linear25;
	private TextView textview7;
	private TextView convert;
	private Button button5;
	private LinearLayout linear29;
	private TextView textview8;
	private TextView attributes;
	private Button button7;
	private Button GitHub;
	private Button copyX;
	
	private Intent i = new Intent();
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.materialwid_bottomdialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear2 = _view.findViewById(R.id.linear2);
		linear34 = _view.findViewById(R.id.linear34);
		button8 = _view.findViewById(R.id.button8);
		relativelayout2 = _view.findViewById(R.id.relativelayout2);
		vscroll1 = _view.findViewById(R.id.vscroll1);
		linear20 = _view.findViewById(R.id.linear20);
		linear31 = _view.findViewById(R.id.linear31);
		cardview2 = _view.findViewById(R.id.cardview2);
		cardview3 = _view.findViewById(R.id.cardview3);
		description = _view.findViewById(R.id.description);
		linear25 = _view.findViewById(R.id.linear25);
		textview7 = _view.findViewById(R.id.textview7);
		convert = _view.findViewById(R.id.convert);
		button5 = _view.findViewById(R.id.button5);
		linear29 = _view.findViewById(R.id.linear29);
		textview8 = _view.findViewById(R.id.textview8);
		attributes = _view.findViewById(R.id.attributes);
		button7 = _view.findViewById(R.id.button7);
		GitHub = _view.findViewById(R.id.GitHub);
		copyX = _view.findViewById(R.id.copyX);
		
		button8.setOnClickListener(_v -> dismiss());
		
		button5.setOnClickListener(_v -> {
			((ClipboardManager) getContext().getSystemService(getContext().getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", convert.getText().toString()));
			button5.setText("Copied");
		});
		
		button7.setOnClickListener(_v -> {
			((ClipboardManager) getContext().getSystemService(getContext().getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", attributes.getText().toString()));
			button7.setText("Copied");
		});
		
		GitHub.setOnClickListener(_v -> {
			i.setAction(Intent.ACTION_VIEW);
			i.setData(Uri.parse(GitUrl));
			startActivity(i);
		});
	}
	
	private void initializeLogic() {
		String markdownText = getArguments().getString("desc");
		SpannableStringBuilder formattedText = MarkdownParser.parseMarkdown(markdownText);
		
		description.setText(formattedText);
		convert.setText(getArguments().getString("convert"));
		attributes.setText(getArguments().getString("inject"));
		GitUrl = getArguments().getString("GitUrl");
		copyX.setEnabled(false);
		description.setTextIsSelectable(true);
		setCancelable(false); 
	}
	
}