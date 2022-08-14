package com.online.power.View;
import android.content.Context;
import android.app.Activity;
import android.text.Editable;
import android.widget.Toast;
import com.online.power.AppConfig;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.MotionEvent;
import android.widget.EditText;
import android.graphics.drawable.GradientDrawable;
import android.graphics.Canvas;
import android.graphics.Color;
import android.widget.TextView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import java.util.Timer;
import java.util.TimerTask;
import android.view.WindowManager;

/*
 * ClassName: AnswerLibrary_AEditText 
 * Chinese: 编辑框
 * Based: AnswerLibrary 3.1
 * © AnswerTame 2022
 * Time: 2022/08/05/00:18
 * By Answer.Dev
 * QQ 2903536884
 */
 
public class AEditText extends android.widget.EditText {

    public static void AEditText(final EditText ed, final Activity activity, String hname, String oname, int size, String color2, String color, boolean bg) {
        
        ed.setHint(hname);
        if (color2 != null) {
            ed.setHintTextColor(android.graphics.Color.parseColor(color2));
        }
        ed.setText(oname);
        ed.setTextSize(size);
        if (color != null) {
            ed.setTextColor(android.graphics.Color.parseColor(color));
        }
        
        if (!bg) {
            ed.setBackground(null);
        } else {
            
        }
        
        ed.setSingleLine(true);
       
        }
    
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setGravitys("LC",this);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(15.0f);
        gradientDrawable.setStroke(5, Color.parseColor("#FF1E88E5"));
        setBackground(gradientDrawable);
    }

    private static void setGravitys(String gravity, EditText v) {
        if (gravity == "LT" || gravity == null) {
            v.setGravity(android.view.Gravity.LEFT | android.view.Gravity.TOP);
        } else if (gravity == "LC") {
            v.setGravity(android.view.Gravity.LEFT | android.view.Gravity.CENTER);
        } else if (gravity == "LB") {
            v.setGravity(android.view.Gravity.LEFT | android.view.Gravity.BOTTOM);
        } else if (gravity == "CT") {
            v.setGravity(android.view.Gravity.CENTER | android.view.Gravity.TOP);
        } else if (gravity == "CC") {
            v.setGravity(android.view.Gravity.CENTER | android.view.Gravity.CENTER);
        } else if (gravity == "CB") {
            v.setGravity(android.view.Gravity.CENTER | android.view.Gravity.BOTTOM);
        } else if (gravity == "RT") {
            v.setGravity(android.view.Gravity.RIGHT | android.view.Gravity.TOP);
        } else if (gravity == "RC") {
            v.setGravity(android.view.Gravity.RIGHT | android.view.Gravity.CENTER);
        } else if (gravity == "RB") {
            v.setGravity(android.view.Gravity.RIGHT | android.view.Gravity.BOTTOM);
        }
    }

    public AEditText(final Activity activity, String hname, String oname, int size, String color, String color2, boolean bg) {
        super(activity);
        AEditText(this, activity, hname, oname, size, color, color2, bg);
    }

    public AEditText(Activity activity, String hname, String oname, int size, String color, String color2) {
        super(activity);
        AEditText(this, activity, hname, oname, size, color, color2, true);
    }

    public AEditText(Activity activity, String hname, String oname, int size, String color) {
        super(activity);
        AEditText(this, activity, hname, oname, size, color, AppConfig.theme[13], true);
    }

    public AEditText(Activity activity, String hname, String oname, int size) {
        super(activity);
        AEditText(this, activity, hname, oname, size, AppConfig.theme[5], AppConfig.theme[13], true);
    }
    public AEditText(Activity activity, String hname, String oname) {
        super(activity);
        AEditText(this, activity, hname, oname, 15, AppConfig.theme[5], AppConfig.theme[13], true);
    }

    public AEditText(Activity activity, String hname) {
        super(activity);
        AEditText(this, activity, hname, "", 15, AppConfig.theme[5], AppConfig.theme[13], true);
    }

    public AEditText(Activity activity) {
        super(activity);
        AEditText(this, activity, "", "", 15, AppConfig.theme[5], AppConfig.theme[13], true);
    }
}
