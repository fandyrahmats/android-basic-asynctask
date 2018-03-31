package com.example.fandyrahmatsaputra.myasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static final String DEMO_ASYNC = "demo_async";
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = (TextView) findViewById(R.id.tv_status);
        DemoAsync demoAsync = new DemoAsync();
        demoAsync.execute("Halo Demo Async");
    }

    private class DemoAsync extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvStatus.setText("status : OnPreExecute");
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.d(DEMO_ASYNC, "status : doInBackground");
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                Log.d(DEMO_ASYNC, e.getMessage());
            }
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvStatus.setText("status : OnPostExecute"+s);
        }
    }

}
