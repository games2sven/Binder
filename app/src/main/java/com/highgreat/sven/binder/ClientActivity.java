package com.highgreat.sven.binder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class ClientActivity extends Activity{

    private HGAidl hgaIdl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        bindService();
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(
                "com.highgreat.sven.binder",
                "com.highgreat.sven.binder.HGAidlService"));
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            hgaIdl = HGAidl.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public void click(View view) {
        try {
            hgaIdl.addPerson(new Person("zhou", 10));
            List<Person> people = hgaIdl.getPersonList();
            Toast.makeText(this, people.toString(), Toast.LENGTH_SHORT).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
