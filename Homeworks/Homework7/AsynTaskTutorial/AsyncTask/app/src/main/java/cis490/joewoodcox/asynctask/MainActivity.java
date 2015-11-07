package cis490.joewoodcox.asynctask;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;


public class MainActivity extends Activity {
    final Context context = this;

    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private class LoadWebPage extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
                         /*Your background work here */

            WebView webView = (WebView) findViewById(R.id.webView);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(urls[0]);

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
                       /* Called when work in doInBackground() is finished.*/
                       /* So you can write UI here i.e. update your UI after finishing doInBackground*/
        }
    }
    public void readWebpage(View v) {
        LoadWebPage task = new LoadWebPage();
        task.execute(new String[] { "http://www.google.com" });

    }
}