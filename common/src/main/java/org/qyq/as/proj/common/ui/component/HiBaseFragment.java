package org.qyq.as.proj.common.ui.component;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @Author: Net Spirit
 * @Time: 2023/8/7 21:26
 * @FixAuthor:
 * @FixTime:
 * @Desc: 基类Fragment
 */
public abstract class HiBaseFragment extends Fragment {
    /**
     * fragment根布局
     */
    protected View layoutView;

    /**
     * 布局界面
     *
     * @return 布局界面的ID（R.layout.fragment_xxx）
     */
    @LayoutRes
    public abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutView = inflater.inflate(getLayoutId(), container, false);
        return layoutView;
    }

}
