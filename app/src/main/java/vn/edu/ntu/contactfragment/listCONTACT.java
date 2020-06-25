package vn.edu.ntu.contactfragment;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.contactfragment.Controller.IController;
import vn.edu.ntu.contactfragment.Model.Contact;

public class listCONTACT extends Fragment {
    RecyclerView rvListContact;
    ContactAdapter adapter;
    List<Contact> listContacts = new ArrayList<>();
    IController controller;
    NavController navController;

    public listCONTACT() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_list_contact2, container, false);
        addviews(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.mnu_phone,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    private void addviews(View view) {
        rvListContact = view.findViewById(R.id.LISTCONTACT_RCV);
        controller = ((MainActivity)getActivity()).controller;
        listContacts =controller.getAllContact();
        adapter = new ContactAdapter(listContacts);

        rvListContact.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rvListContact.setAdapter(adapter);
        navController = NavHostFragment.findNavController(listCONTACT.this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case  R.id.Close:
                this.getActivity().finish();
                break;

            case R.id.itemADD:
                showAddContact();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void showAddContact(){
        Bundle bundle = new Bundle();
        bundle.putInt("id",-1);
        navController.navigate(R.id.action_listCONTACT_to_addContact,bundle);
    }

    private class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView tvname, tvaddress, tvphone;
        ImageView tv_img_phone, tv_img_mess, tv_img_edit;
        Contact p;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = this.itemView.findViewById(R.id.tvName);
            tvaddress = this.itemView.findViewById(R.id.tvAddress);
            tvphone = this.itemView.findViewById(R.id.tvPhone);

            tv_img_phone = this.itemView.findViewById(R.id.tvImgPhone);
            tv_img_mess = this.itemView.findViewById(R.id.tvImgMess);
            tv_img_edit = this.itemView.findViewById(R.id.tvImgEdit);


            tv_img_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IController controller = ((MainActivity)getActivity()).controller;
                    navController = NavHostFragment.findNavController(listCONTACT.this);
                    navController.navigate(R.id.action_listCONTACT_to_addContact);
                }
            });
        }

        public void bind(Contact p){
            this.p = p;
            tvname.setText(p.getName());
            tvaddress.setText(p.getAddress());
            tvphone.setText(p.getPhoneNumber());
        }
    }

    private class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder>{

        List<Contact> listContacts = new ArrayList<>();


        public ContactAdapter(List<Contact> listContacts) {
            this.listContacts = listContacts;
        }

        @NonNull
        @Override
        public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.contact,parent,false);
            return new ContactViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ContactViewHolder holder, final int position) {
            holder.bind(listContacts.get(position));
            holder.tv_img_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("id",listContacts.get(position).getID());
                    navController.navigate(R.id.action_listCONTACT_to_addContact,bundle);
                }
            });

        }

        @Override
        public int getItemCount() {
            return listContacts.size();
        }
    }

}
