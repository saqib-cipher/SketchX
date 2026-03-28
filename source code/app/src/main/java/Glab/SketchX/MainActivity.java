package Glab.SketchX;

import Glab.SketchX.SplashActivity;
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
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.caverock.androidsvg.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import org.json.*;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.EdgeToEdge;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.elevation.SurfaceColors;

public class MainActivity extends AppCompatActivity {
	
	private FragmentManager fragmentManager;
	private Fragment activeFragment;
	private String path = "";
	
	private ArrayList<String> Pathh = new ArrayList<>();
	
	private LinearLayout linear1;
	private ViewPager viewpager1;
	private BottomNavigationView bottomnavigation1;
	
	private HiFragmentAdapter hi;
	private Intent t = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		viewpager1 = findViewById(R.id.viewpager1);
		bottomnavigation1 = findViewById(R.id.bottomnavigation1);
		hi = new HiFragmentAdapter(getApplicationContext(), getSupportFragmentManager());
		
		viewpager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int _position, float _positionOffset, int _positionOffsetPixels) {
				
			}
			
			@Override
			public void onPageSelected(int _position) {
				bottomnavigation1.setSelectedItemId(_position);
			}
			
			@Override
			public void onPageScrollStateChanged(int _scrollState) {
				
			}
		});
		
		bottomnavigation1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(MenuItem item) {
				final int _itemId = item.getItemId();
				viewpager1.setCurrentItem((int)_itemId);
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		hi.setTabCount(4);
		viewpager1.setAdapter(hi);
		bottomnavigation1.getMenu().add(0, 0, 0, "Icons").setIcon(R.drawable.icons);
		bottomnavigation1.getMenu().add(0, 1, 0, "Codes").setIcon(R.drawable.codes);
		bottomnavigation1.getMenu().add(0, 2, 0, "Assistant").setIcon(R.drawable.assistant);
		bottomnavigation1.getMenu().add(0, 3, 0, "M3 widgets").setIcon(R.drawable.blocks);
		EdgeToEdge.enable(this);
		ViewCompat.setOnApplyWindowInsetsListener(linear1, (v, insets) -> {
			androidx.core.graphics.Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
			return insets;
		});
		
	}
	
	public class HiFragmentAdapter extends FragmentStatePagerAdapter {
		// This class is deprecated, you should migrate to ViewPager2:
		// https://developer.android.com/reference/androidx/viewpager2/widget/ViewPager2
		Context context;
		int tabCount;
		
		public HiFragmentAdapter(Context context, FragmentManager manager) {
			super(manager);
			this.context = context;
		}
		
		public void setTabCount(int tabCount) {
			this.tabCount = tabCount;
		}
		
		@Override
		public int getCount() {
			return tabCount;
		}
		
		@Override
		public CharSequence getPageTitle(int _position) {
			return "";
		}
		
		
		@Override
		public Fragment getItem(int _position) {
			if (_position == 0) {
				return new IconFragmentActivity();
			}
			else if (_position == 1) {
				return new CodeFragmentActivity();
			}
			else if (_position == 2) {
				return new AssistantFragmentActivity();
			}
			else {
				return new MaterialFragmentActivity();
			}
		}
		
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		if (activeFragment != null) {
			switchFragment(activeFragment);
		}
	}
	public void _REPLACEMENT() {
		
	}
	
	
	public void _EXTRA() {
	}
	// Restart Theme
	public void restartToApply(long delay) {
		
		new Handler().postDelayed(() -> {
			if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
				finish();
			}
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
				finish();
			}
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		}, delay);
	}
	
	// Fragment Switcer Disable Double Click Menu
	private void switchFragment(Fragment fragment) {
		if (activeFragment != fragment) {
			fragmentManager.beginTransaction().hide(activeFragment).show(fragment).commit();
			activeFragment = fragment;
		}
	}
	
	{
	}
	
	
	public void _bottomSheetTheme() {
		// Call BottomSheet Theme
		new ThemeBottomSheet().show(getSupportFragmentManager(), "ThemeSwitcher");
	}
	
}