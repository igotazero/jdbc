package controller.dao.oracle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andrei_Zanozin on 6/24/2016.
 */
public class ParseHandler {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static String oracleFormat = "YYYY-MM-DD HH24:MI:SS";

    public static String dateToString(Date date){
        return format.format(date);
    }

    public static Date stringToDate(String string){
        try {
            return format.parse(string);
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }

    public static int convert(Boolean value){
        if (value){
            return 1;
        }else {
            return 0;
        }
    }

    public static boolean convert(int value){
        switch (value){
            case 0:{
                return false;
            }
            case 1:{
                return true;
            }
            default:return false;
        }
    }

    public static String getOracleFormat() {
        return oracleFormat;
    }
}
