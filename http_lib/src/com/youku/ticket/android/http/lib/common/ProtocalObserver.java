/**
 * @title ProtocalObserver.java
 * @package com.youku.ticket.android.http.lib.common
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午5:45:16
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.common;

/**
 * @className ProtocalObserver
 * @description 协议观察者
 * @author LLC
 * @date 2014-12-22 下午5:45:16
 */
public interface ProtocalObserver {

    /**
     * description: 协议通过
     * 
     * @creater LLC
     * @param paramObject
     * @date 2014-12-22 下午5:46:14
     * @editer
     */
    public void onProtocalSuccess(Object paramObject);

    /**
     * description: 协议失败
     * 
     * @creater LLC
     * @param paramObject
     * @date 2014-12-25 下午1:32:39
     * @editer
     */
    public void onProtocalError(Object paramObject);

    /**
     * description: 协议过程（不必需）
     * 
     * @creater LLC
     * @param paramObject
     * @date 2014-12-25 下午1:32:45
     * @editer
     */
    public void onProtocalProcess(Object paramObject);
}
