package com.highgreat.sven.binder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

public class HGAidlService extends Service {

    private ArrayList<Person> personArrayList;

    @Override
    public IBinder onBind(Intent intent) {
        personArrayList = new ArrayList<>();
        return iBinder;
    }

    private IBinder iBinder = new HGAidl.Stub(){

        @Override
        public void addPerson(Person person) throws RemoteException {
            personArrayList.add(person);
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return personArrayList;
        }
    };


}
