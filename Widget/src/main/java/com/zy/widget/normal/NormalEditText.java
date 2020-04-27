package com.zy.widget.normal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputType;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.EditText;

import com.zy.widget.R;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;

/**
 * @author:zhangyue
 * @date:2020/4/26
 */
public class NormalEditText extends AppCompatEditText {
    private Paint mPaint;

    private Paint mBorderPaint;

    private int defaultBound=30;

    private Drawable userIcon;
    private Drawable pwdIcon;
    private Drawable displayPwdIcon;
    private Drawable hidePwdIcon;
    private Drawable removeIcon;
    private int borderColor;
    private int style;

    private NormalEditTextListener listener;

    public void setListener(NormalEditTextListener listener) {
        this.listener = listener;
    }

    /**
     * 密码模式
     */
    private boolean isPwdMode;

    /**
     * 密码模式下右侧的“眼睛”的是否闭合状态——默认：闭合
     */
    boolean eyeState=false;

    public NormalEditText(Context context) {
        super(context);
    }

    public NormalEditText(Context context, AttributeSet attrs) {
        super(context,attrs);
        initDrawable(context);
        init(context,attrs);
        initPaint();
    }


    public NormalEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initDrawable(context);
        init(context,attrs);
        initPaint();
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NormalEditText);
        borderColor = typedArray.getColor(R.styleable.NormalEditText_border_color, Color.LTGRAY);
        style = typedArray.getInteger(R.styleable.NormalEditText_style, 0);


        setCompoundDrawablePadding(10);
        setBackground(null);

        typedArray.recycle();

        int currentInputType=this.getInputType();

        if (this.getInputType()==(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD)){
            isPwdMode = true;
            setCompoundDrawables(pwdIcon,null,hidePwdIcon,null);
        }else{
            isPwdMode=false;
            setCompoundDrawables(userIcon,null,null,null);
        }
    }


    private void initDrawable(Context context) {
        userIcon= ContextCompat.getDrawable(context, R.drawable.user);

        userIcon.setBounds(0,0,defaultBound,defaultBound);

        pwdIcon=ContextCompat.getDrawable(context,R.drawable.lock);

        pwdIcon.setBounds(0,0,defaultBound,defaultBound);

        displayPwdIcon=ContextCompat.getDrawable(context,R.drawable.displaypwd);

        displayPwdIcon.setBounds(0,0,defaultBound,defaultBound);

        hidePwdIcon=ContextCompat.getDrawable(context,R.drawable.hidepwd);

        hidePwdIcon.setBounds(0,0,defaultBound,defaultBound);

        removeIcon=ContextCompat.getDrawable(context,R.drawable.remove);

        removeIcon.setBounds(0,0,defaultBound,defaultBound);
    }

    private void initPaint() {
        mPaint=new Paint();

        mBorderPaint=new Paint();
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setStrokeWidth(1.5f);
        mBorderPaint.setColor(borderColor);
        mBorderPaint.setAntiAlias(true);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (hasFocus()&&text.length()>0){
            if (isPwdMode){
                setCompoundDrawables(pwdIcon,null,eyeState?displayPwdIcon:hidePwdIcon,null);
            }
            else{
                setCompoundDrawables(userIcon,null,removeIcon,null);
            }

        }else{
            if (isPwdMode){
                setCompoundDrawables(pwdIcon,null,eyeState?displayPwdIcon:hidePwdIcon,null);
            }else{
                setCompoundDrawables(userIcon,null,null,null);
            }

        }
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (style){
            case 0:
                canvas.drawLine(0,getMeasuredHeight(),getMeasuredWidth(),getMeasuredHeight(),mBorderPaint);
                break;
            case 1:
                canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mBorderPaint);
                break;
            case 2:
                RectF rectF=new RectF(0,0,getMeasuredWidth(),getMeasuredHeight());
                canvas.drawRoundRect(rectF,10,10,mBorderPaint);
                break;
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean isNull=removeIcon!=null;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                /**
                 * 密码模式处理
                 */
                if (isPwdMode){
                    boolean isContains=event.getX()<=(getWidth()-getPaddingRight())&&
                            event.getX()>=(getWidth()-getPaddingLeft() -hidePwdIcon.getBounds().width());
                    //true 表示已经点击到了 “眼睛” 图标区域
                    if (isContains){
//                        listener.onEvent(this,"123","234",8,9.0f);
                        //睁开状态
                        if (eyeState){
                            setCompoundDrawables(pwdIcon,null,hidePwdIcon,null);

                            eyeState=!eyeState;

                            this.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            Editable text = this.getText();
                            Selection.setSelection(text,text.length());

                        }else{//闭合状态
                            setCompoundDrawables(pwdIcon,null,displayPwdIcon,null);

                            eyeState=!eyeState;

                            this.setInputType(InputType.TYPE_CLASS_TEXT);
                            Editable text = this.getText();
                            Selection.setSelection(text,text.length());

                        }

                    }

                }
                else{
                    boolean isContains=event.getX()<=(getWidth()-getPaddingRight())&&
                            event.getX()>=(getWidth()-getPaddingLeft() -removeIcon.getBounds().width());
                    if (isNull&&isContains){
                        setText("");
                    }
                }
                break;
        }



        return true;//super.onTouchEvent(event);
    }

    public interface NormalEditTextListener{
        void onEvent(NormalEditText objs,Object... args);
    }
}
