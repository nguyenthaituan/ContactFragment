package vn.edu.ntu.contactfragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.edu.ntu.contactfragment.Controller.IController;
import vn.edu.ntu.contactfragment.Model.Contact;

public class AddContact extends Fragment {
    EditText edtName, edtPhoneNumber,edtAddress;
    Button btnAddContact, btnCancelContact;
    int id;
    IController controller;

    NavController navController;
    public AddContact() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_add_contact, container, false);
        addViews(view);
        addActions();


        return view;
    }

    private void addActions() {
        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id == -1)
                {
                    Contact c = new Contact();
                    c.setName(edtName.getText().toString());
                    c.setAddress(edtAddress.getText().toString());
                    c.setPhoneNumber(edtPhoneNumber.getText().toString());
                    controller.InsertContact(c);

                }

                if (id != -1){
                    Contact c = controller.findContactById(id);
                    c.setName(edtName.getText().toString());
                    c.setAddress(edtAddress.getText().toString());
                    c.setPhoneNumber(edtPhoneNumber.getText().toString());
                    controller.UpdateContact(c);
                }
            }
        });

       btnCancelContact.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               navController.navigate(R.id.action_addContact_to_listCONTACT);
           }
       });
    }

    private void addViews(View view) {
        edtName = view.findViewById(R.id.tv_editADDName);
        edtPhoneNumber = view.findViewById(R.id.tv_editADDPhone);
        edtAddress = view.findViewById(R.id.tv_editADDAddress);
        btnAddContact = view.findViewById(R.id.btn_ADDContact);
        btnCancelContact = view.findViewById(R.id.btn_CancelContact);
        controller = ((MainActivity)getActivity()).controller;

        navController = NavHostFragment.findNavController(AddContact.this);


        Bundle bundle = this.getArguments();
         id = bundle.getInt("id");
        if (id != -1)
        {
            Contact c = controller.findContactById(id);
            edtName.setText(c.getName().toString());
            edtPhoneNumber.setText(c.getPhoneNumber().toString());
            edtAddress.setText(c.getAddress().toString());
            btnAddContact.setText("sửa");
        }
        if (id == -1)
        {
            btnAddContact.setText("them");

        }
    }

}
