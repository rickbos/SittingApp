package rick.bos.sittingapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.wahoofitness.connector.HardwareConnector;
import com.wahoofitness.connector.HardwareConnector.Listener;
import com.wahoofitness.connector.HardwareConnectorEnums;
import com.wahoofitness.connector.capabilities.Capability;
import com.wahoofitness.connector.capabilities.Heartrate;
import com.wahoofitness.connector.conn.connections.SensorConnection;
import com.wahoofitness.connector.conn.connections.params.ConnectionParams;
import com.wahoofitness.connector.listeners.discovery.DiscoveryListener;

public class WahooService extends Service implements DiscoveryListener, SensorConnection.Listener, Heartrate.Listener {
    private HardwareConnector mHardwareConnector;
    private final HardwareConnector.Listener mHardwareConnectorListener=new WahooListener();


    public WahooService() {
    }

    public void onCreate() {
        super.onCreate();
        mHardwareConnector=new HardwareConnector(this,mHardwareConnectorListener);
        mHardwareConnector.startDiscovery(this);


    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onDeviceDiscovered(ConnectionParams connectionParams) {
        mHardwareConnector.requestSensorConnection(connectionParams,this);
    }

    @Override
    public void onDiscoveredDeviceLost(ConnectionParams connectionParams) {

    }

    @Override
    public void onDiscoveredDeviceRssiChanged(ConnectionParams connectionParams, int i) {

    }

    @Override
    public void onSensorConnectionStateChanged(SensorConnection sensorConnection, HardwareConnectorEnums.SensorConnectionState sensorConnectionState) {

    }

    @Override
    public void onSensorConnectionError(SensorConnection sensorConnection, HardwareConnectorEnums.SensorConnectionError sensorConnectionError) {

    }

    @Override
    public void onNewCapabilityDetected(SensorConnection sensorConnection, Capability.CapabilityType capabilityType) {
        if(capabilityType== Capability.CapabilityType.Heartrate){
            Heartrate heartrate=(Heartrate)sensorConnection.getCurrentCapability(Capability.CapabilityType.Heartrate);
            heartrate.addListener(this);
        }
    }

    @Override
    public void onHeartrateData(Heartrate.Data data) {

    }

    @Override
    public void onHeartrateDataReset() {

    }
}
