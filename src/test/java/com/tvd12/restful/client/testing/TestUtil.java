/**
 * 
 */
package com.tvd12.restful.client.testing;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @author tavandung12
 *
 */
public class TestUtil {

    private TestUtil() {
        
    }
    
    public static String readExpected(String fileName) {
        try {
            return FileUtils.readFileToString(
                    new File(TestUtil.class.getResource("/expected/" + fileName).getFile()),
                    "UTF-8");
        } catch (IOException e) {
            return null;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(readExpected("access_token.json"));
    }
    
}
