package hthan.javascripttunnelsample;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView title;
	private Button summit;

	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final WebView web = (WebView) findViewById(R.id.web);
		summit = (Button)findViewById(R.id.summit);
		title = (TextView)findViewById(R.id.text);
		web.getSettings().setJavaScriptEnabled(true);
		TunnelInterface tunnelInterface = new TunnelInterface();
		web.addJavascriptInterface(tunnelInterface, "tunnel");
		web.loadUrl("file:///android_asset/tunnelSample.html");
		 
		summit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 web.loadUrl("javascript: changeBody('Ethan Change')");
			}
		});
	}
	
	class TunnelInterface{
		public void setTitle(String _title){
			title.setText(_title);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
