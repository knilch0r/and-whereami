package de.cwde.whereami;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView imageView = (ImageView) findViewById(R.id.imageView);
		// Set the background color to white
		imageView.setBackgroundColor(Color.WHITE);
		// Parse the SVG file from the resource
		SVG svg = SVGParser.getSVGFromResource(getResources(), R.raw.android);
		// Get a drawable from the parsed SVG and set it as the drawable for the ImageView
		imageView.setImageDrawable(svg.createPictureDrawable());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
