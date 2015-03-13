package com.youku.ticket.app.utils;

import java.util.Stack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * @className ActiivtyStack
 * @description TODO fragment堆栈
 * @author QIAODI
 * @date 2014年12月26日 下午5:03:36
 */
public class ActiivtyStack {

    private Stack<Fragment> mActivityStack;

    private FragmentManager mFragment;

    public ActiivtyStack(FragmentManager fm) {
        this.mFragment = fm;
        mActivityStack = new Stack<Fragment>();
    }

    /**
     * description: TODO 出栈
     * @creater QIAODI
     * @param activity
     * @date 2014年12月26日 下午5:04:33
     * @editer 	
     */
    public void popActivity(Fragment activity) {
        if (activity != null) {
            mActivityStack.remove(activity);
            mFragment.popBackStack();
            // mActivityStack.pop();
            activity = null;
        }
    }

    /**
     * description: TODO 当前栈顶的fragment
     * @creater QIAODI
     * @return
     * @date 2014年12月26日 下午5:04:48
     * @editer 	
     */
    public Fragment currentActivity() {
        Fragment activity = mActivityStack.lastElement();
        return activity;
    }

    /**
     * description: TODO 入栈
     * @creater QIAODI
     * @param activity
     * @date 2014年12月26日 下午5:05:31
     * @editer 	
     */
    public void pushActivity(Fragment activity) {
        mActivityStack.add(activity);
    }

    /**
     * description: TODO 退到栈中指定位置
     * @creater QIAODI
     * @param cls
     * @date 2014年12月26日 下午5:05:50
     * @editer 	
     */
    public void popAllActivityExceptOne(Class<Fragment> cls) {
        while (true) {
            Fragment activity = currentActivity();
            if (activity == null) {
                break;
            }
            if (activity.getClass().equals(cls)) {
                break;
            }
            popActivity(activity);
        }
    }

    /**
     * description: TODO 获得栈大小
     * @creater QIAODI
     * @return
     * @date 2014年12月26日 下午5:06:05
     * @editer 	
     */
    public int getFragmentSize() {
        return mActivityStack.size();
    }
}
