package io.github.jhcpokemon.topbardemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import io.github.jhcpokemon.topbardemo.R;


/**
 * Created by jhcpokemon on 12/19/15.
 */
public class TopBar extends RelativeLayout {
    private TextView textView;
    private Button leftButton, rightButton;
    private String titleText, leftButtonText, rightButtonText;
    private int titleColor, leftButtonTextColor, rightButtonTextColor, titleTextSize;
    private Drawable leftButtonBackground, rightButtonBackground;
    private LayoutParams leftParams, rightParams, titleParams;
    private OnTopBarClickListener listener;

    public void setOnTopBarOnClickListener(OnTopBarClickListener listener){
        this.listener = listener;
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.topBar);

        titleText = ta.getString(R.styleable.topBar_titleText);
        titleColor = ta.getColor(R.styleable.topBar_titleColor, 0);
        titleTextSize = ta.getDimensionPixelSize(R.styleable.topBar_titleSize, 0);

        leftButtonText = ta.getString(R.styleable.topBar_leftButtonText);
        leftButtonTextColor = ta.getColor(R.styleable.topBar_leftButtonTextColor, 0);
        leftButtonBackground = ta.getDrawable(R.styleable.topBar_leftButtonBackground);

        rightButtonText = ta.getString(R.styleable.topBar_rightButtonText);
        rightButtonTextColor = ta.getColor(R.styleable.topBar_rightButtonTextColor, 0);
        rightButtonBackground = ta.getDrawable(R.styleable.topBar_rightButtonBackground);
        ta.recycle();

        textView = new TextView(context);
        leftButton = new Button(context);
        rightButton = new Button(context);

        textView.setText(titleText);
        textView.setTextSize(titleTextSize);
        textView.setTextColor(titleColor);
        textView.setGravity(Gravity.CENTER);

        leftButton.setText(leftButtonText);
        leftButton.setTextColor(leftButtonTextColor);
        leftButton.setBackground(leftButtonBackground);

        rightButton.setText(rightButtonText);
        rightButton.setTextColor(rightButtonTextColor);
        rightButton.setBackground(rightButtonBackground);

        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(leftButton, leftParams);

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(rightButton, rightParams);

        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(CENTER_IN_PARENT, TRUE);
        addView(textView, titleParams);

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onLeftClick();
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRightClick();
            }
        });
    }

    public interface OnTopBarClickListener {
        void onLeftClick();
        void onRightClick();
    }
}
