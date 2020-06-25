package vn.edu.ntu.contactfragment.Controller;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vn.edu.ntu.contactfragment.Model.AppDatabase;
import vn.edu.ntu.contactfragment.Model.Contact;
import vn.edu.ntu.contactfragment.Model.DAOContact;

public class ControllerDB extends Application implements IController {
  DAOContact dao;
  AppDatabase database;

  public ControllerDB(Context context){
      database = Room.databaseBuilder(context,
              AppDatabase.class,"contactApp")
              .allowMainThreadQueries()
              .build();
      dao = database.getDaoContact();
  }

    @Override
    public void InsertContact(Contact contact) {
        dao.insertContact(contact);
    }

    @Override
    public void DeleteContact(Contact contact) {
        dao.deleteContact(contact);
    }

    @Override
    public void UpdateContact(Contact contact) {
        dao.updateContact(contact);
    }

    @Override
    public List<Contact> getAllContact() {
        return dao.getAllContact();
    }

    @Override
    public Contact findContactById(int id) {
        return dao.findContactByID(id);
    }
}
