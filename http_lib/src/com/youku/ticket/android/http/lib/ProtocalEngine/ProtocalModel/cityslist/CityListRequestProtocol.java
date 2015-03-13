/**
 * @title CityListRequestProtocol.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:09:46
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestProtocolBase;

/**
 * @className CityListRequestProtocol
 * @description 城市列表请求协议构造器
 * @author LLC
 * @date 2014-12-22 下午6:09:46
 */
public class CityListRequestProtocol extends RequestProtocolBase {

    @Override
    public String getUrl() {
        return super.getUrl() + "v1/base/city/citys.json";
    }

}
