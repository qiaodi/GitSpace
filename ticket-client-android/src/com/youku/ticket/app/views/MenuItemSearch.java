package com.youku.ticket.app.views;

import com.youku.ticket.R;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

public class MenuItemSearch {

    private MenuItemImpl mItem;

    public void ShowItem(Context context, Menu menu){
        mItem = (MenuItemImpl) menu.add(1, 1, 1, "Item 2");
        mItem.setIcon(R.drawable.actionbar_search_icon);
        mItem.setShowAsAction(MenuItemImpl.SHOW_AS_ACTION_IF_ROOM);
        mItem.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // TODO Auto-generated method stub
                Log.w("MenuItemSearch","onMenuItemClick");
                return false;
            }
        });
    }

    public MenuItemImpl getItem() {
        return mItem;
    }
}
