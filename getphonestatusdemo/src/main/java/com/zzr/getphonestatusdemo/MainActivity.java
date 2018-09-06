package com.zzr.getphonestatusdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView tvType, tvIP, tvLo, tvLa, tvLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        getNetIp();

//        getLngAndLat(this);

    }

    private void initView() {
        tvType = findViewById(R.id.tv_type);
        tvIP = findViewById(R.id.tv_ip);
        tvLo = findViewById(R.id.tv_lo);
        tvLa = findViewById(R.id.tv_la);
        tvLocation = findViewById(R.id.tv_location);
        tvLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getLocation(MainActivity.this);
                String lngAndLat = LocationUtil.getLngAndLat(MainActivity.this);
                tvLa.setText(lngAndLat);
            }
        });
    }

    private void getNetIp() {
        String ip = "";
        if (SystemUtils.isWifiConnected(this)) {
            ip = SystemUtils.getWifiIP(this);
            tvType.setText("wifi");
        } else if (SystemUtils.isMobileNetworkConnected(this)) {
            ip = SystemUtils.getLocalIpAddress();
            tvType.setText("手机流量");
        }
        tvIP.setText(ip);
    }

//    /**
//     * 获取经纬度
//     *
//     * @param context
//     * @return
//     */
//    public String getLngAndLat(Context context) {
//        double latitude = 0.0;
//        double longitude = 0.0;
//
//        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
//        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {  //从gps获取经纬度
//            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
//                    != PackageManager.PERMISSION_GRANTED
//                    && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
//                    != PackageManager.PERMISSION_GRANTED) {
//
//            }
//            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//            if (location != null) {
//                latitude = location.getLatitude();
//                longitude = location.getLongitude();
//
////                MyApplication.mHeaderBean.setLongitude(longitude + "");
////                MyApplication.mHeaderBean.setLatitude(latitude + "");
//            } else {//当GPS信号弱没获取到位置的时候又从网络获取
//                return getLngAndLatWithNetwork(context);
//            }
//        } else {    //从网络获取经纬度
//            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, locationListener);
//            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//            if (location != null) {
//                latitude = location.getLatitude();
//                longitude = location.getLongitude();
//
////                MyApplication.mHeaderBean.setLongitude(longitude + "");
////                MyApplication.mHeaderBean.setLatitude(latitude + "");
//            }
//        }
//        return latitude + "," + longitude;
//    }
//
//    //从网络获取经纬度
//    private String getLngAndLatWithNetwork(Context context) {
//        double latitude = 0.0;
//        double longitude = 0.0;
//        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
//
//        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED
//                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//
//        }
//
//        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, locationListener);
//        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//        if (location != null) {
//            latitude = location.getLatitude();
//            longitude = location.getLongitude();
////            MyApplication.mHeaderBean.setLongitude(longitude + "");
////            MyApplication.mHeaderBean.setLatitude(latitude + "");
//        }
//        return latitude + "," + longitude;
//    }
//
//
//    LocationListener locationListener = new LocationListener() {
//
//        // Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
//        @Override
//        public void onStatusChanged(String provider, int status, Bundle extras) {
//
//        }
//
//        // Provider被enable时触发此函数，比如GPS被打开
//        @Override
//        public void onProviderEnabled(String provider) {
//
//        }
//
//        // Provider被disable时触发此函数，比如GPS被关闭
//        @Override
//        public void onProviderDisabled(String provider) {
//
//        }
//
//        //当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
//        @Override
//        public void onLocationChanged(Location location) {
//        }
//    };

}
