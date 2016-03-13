package rick.bos.sittingapp;

import android.util.Log;

import com.wahoofitness.connector.HardwareConnector;
import com.wahoofitness.connector.HardwareConnectorEnums;
import com.wahoofitness.connector.HardwareConnectorTypes;
import com.wahoofitness.connector.conn.connections.SensorConnection;


public class WahooListener implements HardwareConnector.Listener {

    private static final String TAG = "Wahoo";
    @Override
    public void connectorStateChanged(HardwareConnectorTypes.NetworkType networkType, HardwareConnectorEnums.HardwareConnectorState hardwareConnectorState) {

    }

    @Override
    public void connectedSensor(SensorConnection sensorConnection) {
        Log.i(TAG,"connectedSensor:" + sensorConnection.getDeviceName() );
    }

    @Override
    public void disconnectedSensor(SensorConnection sensorConnection) {

    }

    @Override
    public void onFirmwareUpdateRequired(SensorConnection sensorConnection, String s, String s1) {

    }
}
