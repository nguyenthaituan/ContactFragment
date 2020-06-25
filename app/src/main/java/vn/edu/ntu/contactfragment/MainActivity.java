package vn.edu.ntu.contactfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;

import android.os.Bundle;
import android.view.View;

import vn.edu.ntu.contactfragment.Controller.ControllerDB;
import vn.edu.ntu.contactfragment.Controller.IController;

public class MainActivity extends AppCompatActivity {
    NavController navcontroller;
    IController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new ControllerDB(this);

//        final Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setTitle("Tuan");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        controller = new ControllerDB();
//
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                navcontroller.navigateUp();
//            }
//        });
    }
}
