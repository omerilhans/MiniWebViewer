package android.projects.miniwebviewer;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    ProgressDialog bekle;

    WebView wv;
    EditText link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bekle = new ProgressDialog(this);


        getSupportActionBar().hide();
        link = (EditText) findViewById(R.id.editText);
        wv = (WebView) findViewById(R.id.webView);

        // AYARLAR
        wv.getSettings().setPluginState(WebSettings.PluginState.ON);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                bekle.setMessage("Lütfen Bekleyin");
                bekle.setCancelable(false);
                bekle.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                bekle.dismiss();
            }
        });
    }

    public void openPage(View v) {
        wv.loadUrl("http://" + link.getText() + "");
    }

}
