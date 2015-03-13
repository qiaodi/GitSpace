package com.youku.ticket.app.utils.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import android.graphics.Bitmap;


public class CacheBitmap extends SoftReference<Bitmap>{

    public Object key;

    public CacheBitmap(String k, Bitmap r, ReferenceQueue<Bitmap> q) {
        super(r, q);
        // TODO Auto-generated constructor stub
        key = k;
    }

}
