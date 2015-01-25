package me.rei_m.androidsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import me.rei_m.androidsample.activitiy.AsyncImageViewActivity;
import me.rei_m.androidsample.activitiy.ListViewSampleActivity;
import me.rei_m.androidsample.activitiy.ObserverSampleActivity;
import me.rei_m.androidsample.model.AtndApi;
import me.rei_m.androidsample.model.ModelLocator;


public class IndexActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        // モデルの初期化
        ModelLocator.getInstance().setAtndApi(AtndApi.createInstance());

    }

    @Override
    protected void onStart() {
        super.onStart();
        final Activity activity = this;
        Button openListView = (Button) findViewById(R.id.open_listView);
        openListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, ListViewSampleActivity.class));
            }
        });

        Button openObserverSample = (Button) findViewById(R.id.open_observerSample);
        openObserverSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(ObserverSampleActivity.createIntent(activity));
            }
        });

        Button openCustomImageView = (Button) findViewById(R.id.open_customImageView);
        openCustomImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, AsyncImageViewActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.index, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
