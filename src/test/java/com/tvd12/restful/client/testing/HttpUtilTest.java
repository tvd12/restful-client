/**
 * 
 */
package com.tvd12.restful.client.testing;

import java.io.UnsupportedEncodingException;

import org.testng.annotations.Test;

import com.tvd12.restful.client.HttpUtil;
import com.tvd12.test.base.BaseTest;

/**
 * @author tavandung12
 *
 */
public class HttpUtilTest extends BaseTest {

    @Test(expectedExceptions = {IllegalStateException.class})
    public void test() throws UnsupportedEncodingException {
        HttpUtil.credential("abc", "123", "xyz");
    }
    
    @Override
    public Class<?> getTestClass() {
        return HttpUtil.class;
    }
    
}
