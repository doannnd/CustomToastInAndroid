package com.nguyendinhdoan.customtoastinandroid;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.nguyendinhdoan.customtoastinandroid.databinding.CustomToastNotificationBinding;

public class CustomToastNotification extends LinearLayout {

    private Context context;
    private CustomToastNotificationBinding binding;
    private String message;
    private String title;

    public CustomToastNotification(Context context) {
        super(context);
        init(context);
    }

    public CustomToastNotification(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomToastNotification(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomToastNotification(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_toast_notification, this, true);
        binding.setViewModel(this);
    }

    public String getTitle() {
        if (TextUtils.isEmpty(title)) {
            return context.getString(R.string.app_name);
        }
        return title;
    }

    public CustomToastNotification setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CustomToastNotification setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomToastNotification setBackground(int id) {
        binding.notificationBackground.setBackground(ContextCompat.getDrawable(context, id));
        return this;
    }

    public void setBackgroundResourse(int resId) {
        binding.notificationBackground.setBackgroundResource(resId);
    }

    public CustomToastNotification setIcon(int resId) {
        binding.iconToast.setImageResource(resId);
        return this;
    }
}
