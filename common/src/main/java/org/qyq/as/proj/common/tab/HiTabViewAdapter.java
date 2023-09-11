package org.qyq.as.proj.common.tab;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.qyq.as.proj.hi_ui.tab.bottom.HiTabBottomInfo;

import java.util.List;

/**
 * @Author: Net Spirit
 * @Time: 2023/8/7 22:01
 * @FixAuthor:
 * @FixTime:
 * @Desc: 底部导航适配器
 */
public class HiTabViewAdapter {
    /**
     * 底部列表集合
     */
    private List<HiTabBottomInfo<?>> mInfoList;
    /**
     * 当前选中的Fragment实例
     */
    private Fragment mCurFragment;
    private FragmentManager mFragmentManager;

    public HiTabViewAdapter(FragmentManager mFragmentManager, List<HiTabBottomInfo<?>> mInfoList) {
        this.mFragmentManager = mFragmentManager;
        this.mInfoList = mInfoList;
    }

    /**
     * 实例化以及显示指定位置的fragment
     *
     * @param container
     * @param position
     */
    public void instantiateItem(View container, int position) {
        FragmentTransaction mCurTransaction = mFragmentManager.beginTransaction();
        //判断当前的fragment是否为空
        if (mCurFragment != null) {
            //不为空隐藏当前fragment
            mCurTransaction.hide(mCurFragment);
        }

        String name = container.getId() + ":" + position;
        //通过tag获取fragment
        Fragment fragment = mFragmentManager.findFragmentByTag(name);
        //判断fragment是否为空
        if (fragment != null) {
            //不为空，即之前在manager里添加过，显示即可
            mCurTransaction.show(fragment);
        } else {
            //为空，创建实例
            fragment = getItem(position);
            //是否有添加
            if (fragment.isAdded()) {
                //没有就添加到Transaction
                mCurTransaction.add(container.getId(), fragment, name);
            }
        }
        mCurFragment = fragment;
        //提交修改
        mCurTransaction.commitAllowingStateLoss();
    }

    public Fragment getCurrentFragment() {
        return mCurFragment;
    }

    public Fragment getItem(int position) {
        try {
            return mInfoList.get(position).fragment.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getCount() {
        return mInfoList == null ? 0 : mInfoList.size();
    }
}
