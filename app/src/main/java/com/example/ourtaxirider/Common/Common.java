package com.example.ourtaxirider.Common;

import com.example.ourtaxirider.Model.Rider;
import com.example.ourtaxirider.Remote.FCMClient;
import com.example.ourtaxirider.Remote.GoogleMapAPI;
import com.example.ourtaxirider.Remote.IFCMService;
import com.example.ourtaxirider.Remote.IGoogleAPI;

public class Common {

    public static final int PICK_IMAGE_REQUEST = 9999;
    public static boolean isDriverFound = false;
    public static String driverId = "";

    public static Rider currentUser = new Rider();

    public static final String user_field = "rider_usr";
    public static final String pwd_field = "rider_pwd";

    public static final String driver_tbl = "Drivers";
    public static final String user_driver_tbl = "DriversInformation";
    public static final String user_rider_tbl = "RidersInformation";
    public static final String pickup_request_tbl = "PickupRequest";
    public static final String token_tbl = "Tokens";
    public static final String rate_detail_tbl = "RateDetails";

    private static double base_fare = 50.0;
    private static double time_rate = 1.5;
    private static double distance_fare = 5.0;

    public static double getPrice (double km, int min)
    {
        return (base_fare+(time_rate*min)+(distance_fare*km));
    }

    public static final String fcmURL = "https://fcm.googleapis.com";
    public static final String googleAPIUrl = "https://maps.googleapis.com";

    public static IFCMService getFCMService()
    {
        return FCMClient.getClient(fcmURL).create(IFCMService.class);
    }
    public static IGoogleAPI getGoogleService()
    {
        return GoogleMapAPI.getClient(googleAPIUrl).create(IGoogleAPI.class);
    }
}
