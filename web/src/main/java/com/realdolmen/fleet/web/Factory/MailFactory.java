package com.realdolmen.fleet.web.Factory;

/**
 * Created by SDOAX36 on 6/11/2015.
 */
public class MailFactory {

    public static final String USER_CREATION_SUBJECT = "An account has been made!";
    public static String createUserMail(String name,String username,String password)
    {
        return "Hello "+name+"\nAn account has been made for RDFleet.realdolmen.com.\n" +
                "Please log in with this username : "+username+"\nand password* : "+password+
                "\n\n*We recommend you change your password on your profile page." +
                "\n\nThank you for using RDFLeet,\n\nFleetmanager";

    }

    public static final String CAR_RENEW_MESSAGE = "Renew your leasing car";
    public static String createCarRenewMail(String name, String orderCode, String comment)
    {
        if(comment.equals(""))
        {
            comment = "No comments";
        }
        if(orderCode.equals(""))
        {
            orderCode = "(example) 1ORDERuser.name";
        }
        String m = "Hello " +name+",\nYour current fleetcar has reached the end period of the leasing conditions. " +
                "A new order was created for you to choose a new Car. Please log in with on the fleet portal to order your new car.\n"
                +"<b>Ordercode = "+orderCode+"</b>"+
                "\n\nFleetmanager commented : "+comment+
                "\n\nThank you for using RDFLeet,\n\nFleetmanager";

        return m;

    }

    public static final String CAR_ORDER = "You can order your leasing car";
    public static String createCarOrderMail(String name, String orderCode, String comment)
    {
        if(comment.equals(""))
        {
            comment = "No comments";
        }
        String m = "Hello " +name+",\n"+
                "A new order was created for you to choose a new Car. Please log in on the fleet portal to order your new car.\n"
                +"Ordercode = "+orderCode+""+
                "\n\nFleetmanager commented : "+comment+
                "\n\nThank you for using RDFLeet,\n\nFleetmanager";

        return m;

    }

    public static final String CAR_ORDER_DELIVERD = "Your car has been delivered";
    public static String createCarOrdeDeliveredMail(String name,  String comment)
    {
        if(comment.equals(""))
        {
            comment = "No comments";
        }
        String m = "Hello " +name+",\n"+
                "Your car has been delivered.\n"+
                "\n\nFleetmanager commented : "+comment+
                "\n\nThank you for using RDFLeet,\n\nFleetmanager";

        return m;

    }

    public static final String CAR_ORDER_APPROVED = "Your order has been approved";
    public static String createCarOrderApprovedMail(String name, String ordercode ,String comment)
    {
        if(comment.equals(""))
        {
            comment = "No comments";
        }
        String m = "Hello " +name+",\n"+
                "Your order has been approved.\n"+
                "Order code : "+ordercode+
                "\n\nFleetmanager commented : "+comment+
                "\n\nThank you for using RDFLeet,\n\nFleetmanager";

        return m;

    }




}
