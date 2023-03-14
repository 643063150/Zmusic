package com.zpp.mobile.zmusic.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.view
 * @ClassName: SongSheetBg
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/10 14:36
 * @UpdateUser:
 * @UpdateDate: 2023/3/10 14:36
 * @UpdateRemark:
 */
public class SongSheetBg {
    public static Bitmap generateLeftToRightGradientBitmap(int width, int height, int startColor, int endColor) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        LinearGradient gradient = new LinearGradient(0, 0, width, 0, startColor, endColor, Shader.TileMode.CLAMP);

        paint.setShader(gradient);
        canvas.drawRect(0, 0, width, height, paint);

        return bitmap;
    }

    public static Drawable getDrawable(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv); // 转换为 HSV 颜色
        hsv[2] *= 0.5f; // 降低亮度值
        int lighterColor = Color.HSVToColor(hsv); // 转换回 RGB 颜色
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{lighterColor, color});

// 设置渐变的角度为 90 度
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
        return gradientDrawable;
    }
}
