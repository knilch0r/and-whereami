package de.cwde.whereami;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView i = (ImageView) findViewById(R.id.imageView);
		Path p = new Path();
		p.moveTo(1, 0);
		p.lineTo(3, 2);
		p.lineTo(5, 0);
		p.lineTo(6, 1);
		p.lineTo(4, 3);
		p.lineTo(6, 5);
		p.lineTo(5, 6);
		p.lineTo(3, 4);
		p.lineTo(1, 6);
		p.lineTo(0, 5);
		p.lineTo(2, 3);
		p.lineTo(0, 1);
		p.lineTo(1, 0);
		PathShape ps = new PathShape(p, 6, 6);
		ShapeDrawable s = new ShapeDrawable(ps);
		Paint pt = s.getPaint();
		pt.setColor(0x0000eb);
		pt.setPathEffect(new CornerPathEffect((float) 0.1));
		i.setImageDrawable(s);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
