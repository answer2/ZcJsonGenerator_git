package com.answer.ZcJsonGenerator.View;
import java.util.*;
import java.io.*;
import android.os.*;

/*
 * ClassName: AnswerLibrary_TextLibrary 
 * Chinese: 文本库
 * Based: AnswerLibrary 3.1
 * © AnswerTame 2022
 * Time: 2022/08/05/00:15
 * By Answer.Dev
 * QQ 2903536884
 */
 
public class TextLibrary {
    
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
    
    public static boolean isArray(Object obj) {
        if(obj == null) {
            return false;
        }
        return obj.getClass().isArray();
    }
   
}
