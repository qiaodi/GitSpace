package com.youku.ticket.app.views;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.youku.ticket.R;

public class MenuItemWriteComment {
    private MenuItemImpl mItem;

    public void ShowItem(Context context, Menu menu){
        mItem = (MenuItemImpl) menu.add(0, 0, 0, "Item 1");
        Button btn = new Button(context);
        btn.setText("写影评");
        btn.setBackgroundResource(R.drawable.switch_thumb_disabled_holo_dark);
        mItem.setActionView(btn);
        mItem.setShowAsAction(MenuItemImpl.SHOW_AS_ACTION_IF_ROOM);
        btn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.w("MenuItemWriteComment","onMenuItemClick");
            }
        });
    }

    public MenuItemImpl getItem() {
        return mItem;
    }
}
