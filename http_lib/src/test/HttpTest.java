/**
 * @title HttpTest.java
 * @package test
 * @description TODO
 * @author LLC
 * @date 2014-12-25 下午12:03:30
 * @version V1.0
 */
package test;

import java.util.ArrayList;

import android.test.AndroidTestCase;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalEngine;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.DistrictInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.districtlist.DistrictListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.districtlist.DistrictListResponseData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ErrorCode;
import com.youku.ticket.android.http.lib.common.CommandDef;
import com.youku.ticket.android.http.lib.common.ProtocalObserver;

/**
 * @className HttpTest
 * @description 测试类
 * @author LLC
 * @date 2014-12-25 下午12:03:30
 */
public class HttpTest extends AndroidTestCase implements ProtocalObserver, CommandDef {

    public void testSend() throws Exception {

        DistrictListRequestData requestData = new DistrictListRequestData();
        requestData.setCityId(110000);

        ProtocalEngine engine = new ProtocalEngine(getContext());
        engine.request(this, CommandDef.DISTRICT_LIST, requestData);
    }

    @Override
    public void onProtocalSuccess(Object paramObject) {
        if (paramObject instanceof DistrictListResponseData) {
            DistrictListResponseData data = (DistrictListResponseData) paramObject;
            if (data.getHeadInfo().getCode() == ErrorCode.OK) {
                ArrayList<DistrictInfo> districtList = data.getDistrictList();
                for (DistrictInfo districtInfo : districtList) {
                    System.out.println(districtInfo.getDistrictId() + "<>" + districtInfo.getDistrictName());
                }
            }

        }
    }

    @Override
    public void onProtocalError(Object paramObject) {

    }

    @Override
    public void onProtocalProcess(Object paramObject) {
    }

}
