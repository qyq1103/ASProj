package org.qyq.as.proj.main.logic;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentManager;

import org.qyq.as.proj.common.tab.HiFragmentTabView;
import org.qyq.as.proj.hi_ui.tab.bottom.HiTabBottomInfo;
import org.qyq.as.proj.hi_ui.tab.bottom.HiTabBottomLayout;
import org.qyq.as.proj.main.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Net Spirit
 * @Time: 2023/8/22 22:53
 * @FixAuthor:
 * @FixTime:
 * @Desc: MainActivity逻辑辅助类
 * 将MainActivity的一些逻辑内聚在这，让MainActivity更加清爽
 */
public class MainActivityLogic {
    private HiFragmentTabView fragmentTabView;
    private HiTabBottomLayout hiTabBottomLayout;
    private List<HiTabBottomInfo<?>> infoList;
    private static final String SAVE_CURRENT_ID = "SAVE_CURRENT_ID";
    private ActivityProvider activityProvider;
    private int currentItemIndex;

    public MainActivityLogic(ActivityProvider activityProvider) {
        this.activityProvider = activityProvider;
    }

    private void initTabBottom() {
        hiTabBottomLayout = activityProvider.findViewById(R.id.tab_bottom_layout);
        hiTabBottomLayout.setAlpha(0.85f);
        infoList = new ArrayList<>();
    }

    public interface ActivityProvider {
        <T extends View> T findViewById(@IdRes int id);

        Resources getResources();

        FragmentManager getSupportFragmentManager();

        String getString(@StringRes int resId);
    }
}
