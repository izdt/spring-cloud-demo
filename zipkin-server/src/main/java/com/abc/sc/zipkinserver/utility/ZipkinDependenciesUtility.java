package com.abc.sc.zipkinserver.utility;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.ParseException;

public class ZipkinDependenciesUtility {
    public static String[] pathToUberJar() throws UnsupportedEncodingException {
        URL jarFile = ZipkinDependenciesUtility.class.getProtectionDomain().getCodeSource().getLocation();
        return new File(jarFile.getPath()).isDirectory() ? null
            : new String[] {URLDecoder.decode(jarFile.getPath(), "UTF-8")};
    }

    public static long parseDay(String formattedDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return df.parse(formattedDate).getTime();
        } catch (ParseException e) {
            throw new IllegalArgumentException(
                "First argument must be a yyyy-MM-dd formatted date. Ex. 2016-07-16");
        }
    }
}