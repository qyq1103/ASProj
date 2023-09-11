package org.qyq.as.proj.common.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @Author: Net Spirit
 * @Time: 2023/8/7 21:53
 * @FixAuthor:
 * @FixTime:
 * @Desc: 对fragment的管理
 */
public class HiFragmentTabView extends FrameLayout {
    private HiTabViewAdapter mAdapter;
    private int currentPosition;

    public HiFragmentTabView(@NonNull Context context) {
        super(context);
    }

    public HiFragmentTabView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HiFragmentTabView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HiTabViewAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(HiTabViewAdapter adapter) {
        if (this.mAdapter != null || adapter == null) {
            return;
        }
        this.mAdapter = adapter;
        currentPosition = -1;
    }

    public int getCurrentItem() {
        return currentPosition;
    }

    /**
     * 设置选中第几个fragment
     * @param position
     */
    public void setCurrentItem(int position) {
        if (position < 0 || position > mAdapter.getCount()) {
            return;
        }
        //选中当前之外的fragment
        if (currentPosition != position) {
            currentPosition = position;
            //打开选中的fragment
            mAdapter.instantiateItem(this, position);
        }
    }

    /**
     * 获取当前fragment
     * @return 当前fragment
     */
    public Fragment getCurrentFragment() {
        if (this.mAdapter == null) {
            throw new IllegalArgumentException("Please call setAdapter first.");
        }
        return mAdapter.getCurrentFragment();
    }
}
