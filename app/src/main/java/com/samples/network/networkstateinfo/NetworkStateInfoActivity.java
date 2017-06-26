package com.samples.network.networkstateinfo;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NetworkStateInfoActivity extends AppCompatActivity {

    private TextView text;
    private ConnectivityManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_state_info);

        text = (TextView)findViewById(R.id.text);

        manager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo[] networkInfos = manager.getAllNetworkInfo();

        for (int i=0; i < networkInfos.length; i++){
            text.append("Type:\t" + networkInfos[i].getTypeName());
            text.append("\n\tAvailable:\t" + networkInfos[i].isAvailable());
            text.append("\n\tConnected:\t" + networkInfos[i].isConnected());
            text.append("\n\tExtra:\t" + networkInfos[i].getExtraInfo() + "\n");
        }
    }
}
