package com.answer.ZcJsonGenerator.View;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/*
 * ClassName: AnswerLibrary_ColorLibrary 
 * Chinese: 颜色库
 * Based: AnswerLibrary 3.1
 * © AnswerTame 2022
 * Time: 2022/08/05/00:14
 * By Answer.Dev
 * QQ 2903536884
 */

public class ColorLibrary {

    public static String[][] colors =new String[][]{
        {" ", " &nbsp;"},
        {"\n", "<br/>"},
        {"§l", "</b><b>"},
        {"§m", "</del><del>"},
        {"§n", "</ins><ins>"},
        {"§o", "</i><i>"},
        {"§r", "</font></b></del></ins></i>"},
        {"§0", "</font><font color=#000000>"},
        {"§1", "</font><font color=#0000AA>"},
        {"§2", "</font><font color=#72EEBC>"},
        {"§3", "</font><font color=#00AAAA>"},
        {"§4", "</font><font color=#FFA39E>"},
        {"§5", "</font><font color=#FB98BF>"},
        {"§6", "</font><font color=#B0E2FF>"},
        {"§7", "</font><font color=#d3cad3>"},
        {"§8", "</font><font color=#555555>"},
        {"§9", "</font><font color=#5555FF>"},
        {"§a", "</font><font color=#55FF55>"},
        {"§b", "</font><font color=#70E3FF>"},
        {"§c", "</font><font color=#FF5555>"},
        {"§d", "</font><font color=#e9a2eb>"},
        {"§e", "</font><font color=#ffcf75>"},
        {"§f", "</font><font color=#FFFFFF>"}
    };

    private static final int RED = 0xffFF8080;

    private static final int BLUE = 0xff8080FF;

    private static final int WHITE = 0xffffffff;

    private static final int GREEN = 0xff80ff80;


    public static android.text.Spanned FontColor(String text) {

        for (int e = 0; e < colors.length; e++) {
            text = join(text.split(colors[e][0]), colors[e][1]);
        }
        return android.text.Html.fromHtml(text);
    }

    public static String join(Iterator it, String str) {
        if (!it.hasNext()) {
            return "";
        }
        String start = it.next().toString();
        if (!it.hasNext()) {
            return start;
        }
        StringBuilder sb = new StringBuilder(64).append(start);
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    public static String join(Collection collection, String str) {
        return join(collection.iterator(), str);
    }

    public static String join(String[] strArr, String str) {
        return join(Arrays.asList(strArr), str);
    }
    /*
     public static GradientDrawable Portable(Object[] var0, Object var1) {
     String[] var2 = (String[])var0;
     ArrayList var3 = new ArrayList();


     for (int i = 1; i < var2.length; ++i) {
     var3.add(hexColor(var2[i].toString()));
     }

     int[] var5 = new int[var3.size()];

     for (int i = 0; i < var3.size(); ++i) {
     var5[i] = ((Integer)var3.get(i)).intValue();
     }

     return new roundRect(var5, var1, var2[0]);
     }
     */
    public static GradientDrawable Portable(Object[] hex, int round) {
        ArrayList<Object> hexed=new ArrayList<Object>();

        String[] hex2=(String[])(hex);
        int[] color;

        for (int a=1;a < hex2.length;a++) {    
            hexed.add(hexColor(hex2[a].toString()));
        }
        color = new int[hexed.size()];
        for (int b=0;b < hexed.size();b++) {    
            color[b] = hexed.get(b);
        }

        return new roundRect(color, round, hex2[0]);
    }


    //正式版
    public static GradientDrawable roundBG(Object hex, Object round, String f, Object s) {
        if (isArray(hex)) {
            String[] hex2=(String[])hex;
            return new roundRect(new int[]{Color.parseColor(hex2[0]),Color.parseColor(hex2[1])}, round, hex2[2], 0);
        } else {
            return new roundRect(Color.parseColor((String)(hex)), round, f, s);
        }
    }

    public static GradientDrawable roundBG(Object hex, Object round, String f) {
        if (isArray(hex)) {
            String[] hex2=(String[])hex;
            return new roundRect(new int[]{Color.parseColor(hex2[0]),Color.parseColor(hex2[1])}, round, hex2[2], 0);
        } else {
            return new roundRect(Color.parseColor((String)(hex)), round, f, null);
        }
    }

    public static GradientDrawable roundBG(Object hex, Object round) {
        if (isArray(hex)) {
            String[] hex2=(String[])hex;
            return new roundRect(new int[]{Color.parseColor(hex2[0]),Color.parseColor(hex2[1])}, round, hex2[2], 0);
        } else {
            return new roundRect(Color.parseColor((String)(hex)), round, null);
        }
    }

    public static GradientDrawable roundBG(Object hex) {
        if (isArray(hex)) {
            String[] hex2=(String[])hex;
            return new roundRect(new int[]{Color.parseColor(hex2[0]),Color.parseColor(hex2[1])}, 0, hex2[2], 0);
        } else {
            return new roundRect(Color.parseColor((String)(hex)), 0);
        }
    }
    
    public static GradientDrawable roundBG(int hex, int round) {
 
            return new roundRect(hex, round, null);
        
    }
    

    public static int hexColor(String c) {
        return android.graphics.Color.parseColor(c);
    };

    public static boolean isArray(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.getClass().isArray();
    }

    public static void createAnimation(View view, int... colors) {

        ObjectAnimator colorAnim = ObjectAnimator.ofInt(view, "TextColor", colors);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setDuration(3000);
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();



    }

    public static void createDefaultAnimation(View view) {
        ObjectAnimator colorAnim = ObjectAnimator.ofInt(view, "TextColor", WHITE, RED, BLUE, GREEN, WHITE);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setDuration(3000);
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();

    }



}
