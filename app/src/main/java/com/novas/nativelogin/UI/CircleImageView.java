package com.novas.nativelogin.UI;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import com.novas.nativelogin.R;

import java.text.AttributedCharacterIterator;
import java.util.BitSet;

/**
 * Created by novas on 2016/4/13.
 */
public class CircleImageView extends View
{
    public CircleImageView(Context context) {
        super(context);
    }
    public CircleImageView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
      //  TypedArray a = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircularImage);
     //   mBorderColor = a.getColor(R.styleable.CircularImage_border_color, mBorderColor);
     //   final int defalut = (int) (2 * paramContext.getResources().getDisplayMetrics().density + 0.5f);
     //   mBorderWidth = a.getDimensionPixelOffset(R.styleable.CircularImage_border_width, defalut);
     //   a.recycle();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {

       // super.onDraw(canvas);
           Paint paint=new Paint();
      //  canvas.drawColor(Color.WHITE);
      //  paint.setColor(Color.);
        PorterDuff.Mode localMode = PorterDuff.Mode.SRC_IN;
        Xfermode MASK_XFERMODE = new PorterDuffXfermode(localMode);

        BitmapFactory.Options options=new BitmapFactory.Options();
          options.inJustDecodeBounds=true;
          Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.launcher,options);
          System.out.println(options.outHeight+"  "+options.outWidth);
        options.outWidth=500;
        options.outHeight=300;
        options.inJustDecodeBounds=false;
        options.inSampleSize=5;
        bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.launcher,options);
        System.out.println("==" + bitmap.getWidth() + "  " + bitmap.getHeight());
     //   canvas.drawBitmap(bitmap, 0, 0, paint);
        int saveFlags = Canvas.MATRIX_SAVE_FLAG | Canvas.CLIP_SAVE_FLAG | Canvas.HAS_ALPHA_LAYER_SAVE_FLAG | Canvas.FULL_COLOR_LAYER_SAVE_FLAG | Canvas.CLIP_TO_LAYER_SAVE_FLAG;
        canvas.saveLayer(0, 0, bitmap.getWidth(), bitmap.getHeight(), null, saveFlags);
       // canvas.drawBitmap(bitmapMask, 0, 0, paint);
        Bitmap abitmap=BitmapFactory.decodeResource(getResources(),R.drawable.mask);
        canvas.drawBitmap(abitmap,0,0,paint);
        paint.setXfermode(MASK_XFERMODE);
        int left = bitmap.getWidth()/2 - bitmap.getWidth() /2;
        int top = bitmap.getHeight()/2 - bitmap.getHeight()/2;
        canvas.drawBitmap(bitmap, 0, 0, paint);
        paint.setXfermode(null);
        canvas.restore();

    }
}
