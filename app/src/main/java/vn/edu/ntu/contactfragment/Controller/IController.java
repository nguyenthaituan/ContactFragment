package vn.edu.ntu.contactfragment.Controller;

import android.content.Context;

import java.util.List;

import vn.edu.ntu.contactfragment.Model.Contact;

public interface IController {
    public void InsertContact(Contact contact);
    public void DeleteContact(Contact contact);
    public void UpdateContact(Contact contact);
    public List<Contact> getAllContact();
    public Contact findContactById( int id);
}
