package relax.sn.com.relax.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import relax.sn.com.relax.R;

/**
 * Created by John on 2018/3/15.
 */
public class WelcomeActivity extends AppCompatActivity{
    private final long SPLASH_LENGTH = 3000;
    Handler handler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //延迟0.7秒后执行run方法中的页面跳转
        handler.postDelayed(new Runnable() {  //使用handler的postDelayed实现延时跳转

            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_LENGTH);//3秒后跳转至应用主界面MainActivity
    }
}
