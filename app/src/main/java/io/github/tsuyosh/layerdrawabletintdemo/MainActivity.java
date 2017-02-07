package io.github.tsuyosh.layerdrawabletintdemo;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Not Worked
		Button button1 = (Button) findViewById(R.id.button1);
		ViewCompat.setBackgroundTintList(button1, ContextCompat.getColorStateList(this, R.color.tint));

		// Worked
		Button button2 = (Button) findViewById(R.id.button2);
		LayerDrawableUtil.invalidateCache(button2.getBackground());
		ViewCompat.setBackgroundTintList(button2, ContextCompat.getColorStateList(this, R.color.tint));
	}
}
