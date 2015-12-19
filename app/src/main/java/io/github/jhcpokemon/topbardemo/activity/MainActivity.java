package io.github.jhcpokemon.topbardemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import io.github.jhcpokemon.topbardemo.R;
import io.github.jhcpokemon.topbardemo.view.TopBar;

public class MainActivity extends Activity {
    private TopBar topBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topBar = (TopBar)findViewById(R.id.top_bar);
        topBar.setOnTopBarOnClickListener(new TopBar.OnTopBarClickListener() {
            @Override
            public void onLeftClick() {
                Toast.makeText(MainActivity.this,"Left Clicked",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightClick() {
                Toast.makeText(MainActivity.this,"Right Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
