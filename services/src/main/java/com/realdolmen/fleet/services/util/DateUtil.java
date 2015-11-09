package com.realdolmen.fleet.services.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by SDOAX36 on 3/11/2015.
 */
public class DateUtil {


    public static final String DAY_MONTH_YEAR = "dd-MM-yyyy";

    public static Date addAFewDays(Date date,int aantalDays)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, aantalDays);
        return c.getTime();
    }

    public static Date calculateEndLease(Date date)
    {
        return addAFewDays(date,1460);
    }

    public static String endLeaseDate(Date date)
    {
        return dateToString(calculateEndLease(date),DAY_MONTH_YEAR);
    }

    public static Date stringToDate(String date, String format)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateToString(Date date, String format)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static int daysBetween(Date d1, Date d2)
    {
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }


}
