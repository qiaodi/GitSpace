/**
 * @title JsonParserBase.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午10:31:40
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.RespHeadInfo;
import com.youku.ticket.android.http.lib.common.Logger;

/**
 * @className ResponseParserBase
 * @description 响应解析基础类
 * @author LLC
 * @date 2014-12-25 上午10:31:40
 */
public abstract class ResponseParserBase extends ParserObject {

    private final String TAG_HEAD = "head";

    private final String LABEL_HEAD_PROVIDER = "provider";

    private final String LABEL_HEAD_CODE = "code";

    private final String LABEL_HEAD_DESC = "desc";

    protected final String TAG_BODY = "body";

    protected JSONObject jsonObject = null;

    protected RespHeadInfo headInfo = new RespHeadInfo();

    /**
     * description: 解析响应头
     * 
     * @creater LLC
     * @throws Exception
     * @date 2014-12-25 上午10:56:50
     * @editer
     */
    private void fetchHead() throws Exception {

        if (null != this.jsonObject && this.jsonObject.has(TAG_HEAD)) {
            JSONObject resultObject = this.jsonObject.getJSONObject(TAG_HEAD);

            String provider = resultObject.getString(LABEL_HEAD_PROVIDER);
            int code = resultObject.getInt(LABEL_HEAD_CODE);
            String desc = resultObject.getString(LABEL_HEAD_DESC);

            this.headInfo.setProvider(provider);
            this.headInfo.setCode(code);
            this.headInfo.setDesc(desc);
        }
    }

    /**
     * description: 初始化Json对象
     * 
     * @creater LLC
     * @param datas
     * @throws UnsupportedEncodingException
     * @throws JSONException
     * @date 2014-12-25 上午11:33:26
     * @editer
     */
    private void initJsonObject(byte[] datas) throws UnsupportedEncodingException, JSONException {
        if (null != datas) {
            String decodeStr = new String(datas, "UTF-8");
            Logger.log("ResponseData", decodeStr);
            this.jsonObject = new JSONObject(decodeStr);
        }
    }

    @Override
    public Object getResponseData(byte[] responseData) throws Exception {
        initJsonObject(responseData);
        fetchHead();
        if (this.headInfo.getCode() == ErrorCode.OK && null != this.jsonObject && this.jsonObject.has(TAG_BODY)) {
            fetchBody();
        }
        return getResponseData();
    }

    /**
     * description: 返回响应数据
     * 
     * @creater LLC
     * @return
     * @throws Exception
     * @date 2014-12-25 上午11:34:07
     * @editer
     */
    public abstract Object getResponseData() throws Exception;

    /**
     * description: 解析响应体
     * 
     * @creater LLC
     * @throws Exception
     * @date 2014-12-25 上午11:34:26
     * @editer
     */
    protected abstract void fetchBody() throws Exception;

}
