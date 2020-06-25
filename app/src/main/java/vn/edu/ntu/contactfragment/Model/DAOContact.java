package vn.edu.ntu.contactfragment.Model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAOContact {

        @Insert
        public void insertContact(Contact...contacts);

        @Update
        public void updateContact(Contact...contacts);

        @Delete
        public void deleteContact(Contact...contacts);

        @Query("SELECT * FROM contact")
        List<Contact> getAllContact();

        @Query("SELECT * FROM Contact WHERE id = :id")
        public Contact findContactByID(long id);

}
