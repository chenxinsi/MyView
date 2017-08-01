package com.liangyu.myview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyTextView textView;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (MyTextView) findViewById(R.id.text_view);
       //textView.setTop(100);
        //tv = (TextView) findViewById(R.id.tv);
        //TextView加载完成时回调
        Log.d("xinsi","onCreate");
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    int width = textView.getRight() - textView.getLeft();
                    int height = textView.getBottom() - textView.getTop();
                    Log.d("xinsi","width: " + width + "height: " + height);
                }
        });
        //view重绘时调用
        textView.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
            @Override
            public void onDraw() {
                Log.d("xinsi","view重绘");
            }
        });

        textView.setOnClickListener(new MyTextView.OnClickListener(){


            @Override
            public void click(Context context) {
                Log.d("xinsi","click");
                Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("xinsi","onResume");

    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
