package com.example.luyue.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.luyue.handler.R.id.text2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView)findViewById(R.id.Try);
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                textView.setText(msg.arg1+"");
                TextView text3 = (TextView)findViewById(R.id.text2);
                text3.setText((String)msg.obj);

            }
        };
        final Runnable myWorker = new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();

                int progress = 0;
                while (progress<=100){
                    Message msg1 = new Message();
                    msg1.arg1 = progress;
                    handler.sendMessage(msg1);
                    progress += 20;

                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                Message msg2 = handler.obtainMessage();
                msg2.arg1 = -1;
                handler.sendMessage(msg2);
                msg.obj="你还真等着看完啦？！hh";
                handler.sendMessage(msg);
            }
        };
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Thread workThread = new Thread(null,myWorker,"WorkThread");
                workThread.start();
            }
        });
    }
}
