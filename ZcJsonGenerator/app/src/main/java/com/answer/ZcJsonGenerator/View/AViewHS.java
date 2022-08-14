package com.answer.ZcJsonGenerator.View;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;

/*
 * ClassName: AnswerLibrary_AViewHS 
 * Chinese: 横滑动控件
 * Based: AnswerLibrary 3.1
 * © AnswerTame 2022
 * Time: 2022/08/05/00:13
 * By Answer.Dev
 * QQ 2903536884
 */
 
public class AViewHS  extends android.widget.HorizontalScrollView {

        public AViewHS(Context context, Object sizeW, Object sizeH, Object cm, Object color, Object cr) {
                super(context);
                setSizeWH(sizeW, sizeH, this);
                setBackgroundcolors(cm, color, cr, this);
            }

        public AViewHS(Context context, Object sizeW, Object sizeH, Object cm, Object color) {
                super(context);
                setSizeWH(sizeW, sizeH, this);
                setBackgroundcolors(cm, color, 0, this);
            }

        public AViewHS(Context context, Object sizeW, Object sizeH) {
                super(context);
                setSizeWH(sizeW, sizeH, this);
            }

        public AViewHS(Context context, Object sizeW) {
                super(context);
                setSizeWH(sizeW, 0, this);
            }

        public AViewHS(Context context) {
                super(context);
            }

        private static void setSizeWH(Object sizeW, Object sizeH, HorizontalScrollView v) {
                if (sizeW != null && sizeH != null) {
                        v.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)(sizeW), (int)(sizeH)));
                    }
            }

        private static void setBackgroundcolors(int cm, Object color, Object cr, HorizontalScrollView v) {
                if (cm == 0) {
                        v.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.parseColor((String)color)));
                    } else if (cm == 1) {
                        v.setBackgroundDrawable(ColorLibrary.roundBG(color, cr, null, null));
                    } else if (cm == 2) {
                    }
            }

    }
