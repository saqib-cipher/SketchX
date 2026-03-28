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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.caverock.androidsvg.*;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.*;
import com.google.android.material.button.MaterialButtonGroup;
import com.google.android.material.card.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class AboutBottomdialogFragmentActivity extends BottomSheetDialogFragment {
	
	private boolean about = false;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private MaterialCardView Cardview2;
	private MaterialCardView Cd_3;
	private LinearLayout linear5;
	private TextView textview4;
	private Button button1;
	private LinearLayout linear7;
	private TextView textview6;
	private MaterialButtonGroup linear8;
	private MaterialButton button3;
	private MaterialButton button4;
	private MaterialButton button5;
	
	private Intent i = new Intent();
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.about_bottomdialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear1 = _view.findViewById(R.id.linear1);
		linear2 = _view.findViewById(R.id.linear2);
		Cardview2 = _view.findViewById(R.id.Cardview2);
		Cd_3 = _view.findViewById(R.id.Cd_3);
		linear5 = _view.findViewById(R.id.linear5);
		textview4 = _view.findViewById(R.id.textview4);
		button1 = _view.findViewById(R.id.button1);
		linear7 = _view.findViewById(R.id.linear7);
		textview6 = _view.findViewById(R.id.textview6);
		linear8 = _view.findViewById(R.id.linear8);
		button3 = _view.findViewById(R.id.button3);
		button4 = _view.findViewById(R.id.button4);
		button5 = _view.findViewById(R.id.button5);
		
		button1.setOnClickListener(_v -> {
			if (about) {
				// Get Markdown text from EditText
				String markdownText = "**About Permissions & Security**  \n\nSketchX requires **Manage Access to All Files** permission to extract icons and move them to the Sketchware folder. This ensures a seamless experience for users working with vector xml icons.  \n\nThe app operates **completely offline** (except for ai stuff), meaning no data is sent or stored externally. If users have privacy concerns, they can **disable internet permissions** from their device settings, ensuring full control over network access.  \n\nYour creativity stays yours—with **SketchX**, privacy and security are always a priority.";
				
				// Parse the Markdown text to Spannable
				SpannableStringBuilder formattedText = MarkdownParser.parseMarkdown(markdownText);
				
				// Set the formatted text to TextView
				textview4.setText(formattedText);
				button1.setText("About App");
				about = false;
			} else {
				// Get Markdown text from EditText
				String markdownText = "**SketchX**—your ultimate companion for effortless mobile development.  \n\nWith **over 5,000 free icons**, ready for both **personal and commercial use**, creativity has no limits.  \nSeamless **Java and XML integration** makes coding intuitive, helping **Sketchware Pro beginners** bring their ideas to life with ease.  \n\nFrom design to code, **SketchX simplifies your workflow**, bridging the gap between inspiration and execution.  \n\n**SketchX**—*build smarter, design faster, create effortlessly.*";
				// Parse the Markdown text to Spannable
				SpannableStringBuilder formattedText = MarkdownParser.parseMarkdown(markdownText);
				
				// Set the formatted text to TextView
				textview4.setText(formattedText);
				about = true;
				button1.setText("About Permissions and Security");
			}
			textview4.setAlpha(0f);
			textview4.setTranslationY((float)(20));
			//Blocks.Made by Grafix Lab
			textview4.animate()
			.alpha(1f)
			.translationY(0f)
			.setDuration((long)500)
			.setInterpolator(new OvershootInterpolator(4f));
			
		});
		
		button3.setOnClickListener(_v -> {
			i.setAction(Intent.ACTION_VIEW);
			i.setData(Uri.parse("https://t.me/Grafix_lab"));
			startActivity(i);
		});
		
		button4.setOnClickListener(_v -> {
			i.setAction(Intent.ACTION_VIEW);
			i.setData(Uri.parse("https://youtube.com/@grafix_lab"));
			startActivity(i);
		});
		
		button5.setOnClickListener(_v -> {
			i.setAction(Intent.ACTION_VIEW);
			i.setData(Uri.parse("https://web.sketchub.in/u/Grafix_Lab"));
			startActivity(i);
		});
	}
	
	private void initializeLogic() {
		button1.performClick();
	}
	
}