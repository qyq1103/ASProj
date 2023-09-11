package org.qyq.as.proj.main;

import android.os.Bundle;

import org.qyq.as.proj.common.ui.component.HiBaseActivity;
import org.qyq.as.proj.main.logic.MainActivityLogic;

/**
 * @Author: Net Spirit
 * @Time: 2023/8/7 21:26
 * @FixAuthor:
 * @FixTime:
 * @Desc:
 */
public class MainActivity extends HiBaseActivity implements MainActivityLogic.ActivityProvider {
    private MainActivityLogic activityLogic;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityLogic = new MainActivityLogic(this);
    }
}