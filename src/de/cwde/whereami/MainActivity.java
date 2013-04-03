package de.cwde.whereami;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView imageView = (ImageView) findViewById(R.id.imageView);
		imageView.setBackgroundColor(Color.WHITE);
		// Parse the SVG file, using svg-android
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			Log.d("MainActivity", "disabling hw acceleration");
			imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		}
		SVG svg = SVGParser.getSVGFromResource(getResources(), R.raw.x);
		imageView.setImageDrawable(svg.createPictureDrawable());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.action_settings:
			displaySettings();
			return true;
		case R.id.action_about:
			displayAbout();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void displayAbout() {
		PackageInfo pInfo;
		try {
			pInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_META_DATA);
			String appname = getString(R.string.app_name);
			String aboutTitle = "About " + appname;
			String versionString = appname + " "+ pInfo.versionName;
			String aboutText = getString(R.string.aboutText);

			final TextView message = new TextView(this);
			final SpannableString s = new SpannableString(aboutText);

			message.setPadding(5, 5, 5, 5);
			message.setText(versionString + s);
			Linkify.addLinks(message, Linkify.ALL);

			new AlertDialog.Builder(this)
			.setTitle(aboutTitle)
			.setCancelable(true)
			.setIcon(R.drawable.ic_launcher)
			.setPositiveButton(android.R.string.ok, null)
			.setView(message).create()
			.show();
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void displaySettings() {
		new AlertDialog.Builder(this)
		.setTitle(R.string.action_settings)
		.setMessage(R.string.nosettingsyet)
		.setCancelable(true)
		.setPositiveButton(android.R.string.ok, null)
		.create().show();
	}
}
