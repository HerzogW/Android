package com.example.v_wenjiw.downloadbyasynctask;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView htmlContent;
    private TextView alertTitle;
    private EditText targetUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        targetUrl = (EditText) findViewById(R.id.url);
        htmlContent = (TextView) findViewById(R.id.htmlContent);
        htmlContent.setMovementMethod(ScrollingMovementMethod.getInstance());

        alertTitle=(TextView)findViewById(R.id.alertTitle);
    }

    public void download(View source) throws MalformedURLException {
        if (targetUrl.getText().toString().length() <= 0) {
            Toast.makeText(MainActivity.this, "请输入Url", Toast.LENGTH_SHORT).show();
            return;
        }

        DownLoadTask task = new DownLoadTask(this);
//        task.execute(new URL("http://www.crazyit.org/ethos.php"));
        task.execute(new URL(targetUrl.getText().toString()));
    }

    class DownLoadTask extends AsyncTask<URL, Integer, String> {
        ProgressDialog dialog;
        int hasRead = 0;
        Context mContext;

        public DownLoadTask(Context ctx) {
            mContext = ctx;
        }

        @Override
        protected String doInBackground(URL... params) {
            StringBuilder sb = new StringBuilder();
            try {
                URLConnection conn = params[0].openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                    hasRead++;
                    publishProgress(hasRead);
                }

                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            htmlContent.setText(result);
            Toast.makeText(MainActivity.this, "执行完毕", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(mContext);
            dialog.setTitle("任务正在执行中");
            dialog.setMessage("任务正在执行，敬请等待...");
            dialog.setCancelable(false);
            dialog.setMax(2523);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setIndeterminate(false);
            dialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            alertTitle.setText("已经读取了【" + values[0] + "】行！");
            dialog.setProgress(values[0]);
        }
    }
}
