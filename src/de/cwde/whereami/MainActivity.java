package de.cwde.whereami;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView imageView = (ImageView) findViewById(R.id.imageView);
		imageView.setBackgroundColor(Color.WHITE);
		// Parse the SVG file, using svg-android
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
			// todo
			return true;
		case R.id.action_about:
			// to do
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
