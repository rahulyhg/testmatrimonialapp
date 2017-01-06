package com.techno.matrimonial.Api;

/**
 * Created by arbaz on 19/7/16.
 */
public class Api {

    //Dump Condition
    public static final int ConnectionTimeout = 30000; // = 30 seconds
    public static final int ConnectionSoTimeout = 60000; // = 60 seconds

    //response code
    public static final int ResponseOk = 200;
    public static final int ResponsePageError = 400;
    public static final int ResponseServerError = 500;

    // Main Url of Matimonial
    public static final String MainUrl = "http://192.168.1.7/salon/webservices/web/index.php";
    // table name
    public static final String ActionLogin = "/login";

}
