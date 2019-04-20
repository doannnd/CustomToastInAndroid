package com.nguyendinhdoan.customtoastinandroid;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.nguyendinhdoan.customtoastinandroid.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void onShowToast() {
        CustomToastNotification customToastNotification = new CustomToastNotification(this);
        Random random = new Random();
        int rd = random.nextInt();

        switch (rd) {
            case 0:
                customToastNotification.setIcon(R.mipmap.ic_launcher);
                break;
            case 1:
                customToastNotification.setIcon(R.drawable.ic_launcher_background).setTitle("Minion");
                break;
            case 2:
                customToastNotification.setIcon(R.mipmap.ic_launcher_round).setTitle("Round");
                break;
        }

        customToastNotification.setMessage("Type: " + rd);
        Toast toast = Toast.makeText(this, "a", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.FILL_HORIZONTAL, 0, 0);
        toast.setView(customToastNotification);
        toast.show();
    }
}
