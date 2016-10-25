package org.jerold.string;

/**
 * Created by Jerold on 2016/10/22.
 */
public class BlankReplace {
    public static void main(String[] args) {
        String str = "We are happy";
        String str2 = null;
        String ret = blankReplace(str2);
        System.out.println(ret);
        System.out.println(str.trim());
    }

    public static String blankReplace(String str) {
        String ret = null;
        if (str != null) {
            char[] chars = str.toCharArray();
            char[] tmp = new char[chars.length * 3];
            int p = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') {
                    tmp[p++] = '%';
                    tmp[p++] = '2';
                    tmp[p++] = '0';
                } else {
                    tmp[p++] = chars[i];
                }
            }
            ret = String.valueOf(tmp).trim();
        }
        return ret;
    }
}
