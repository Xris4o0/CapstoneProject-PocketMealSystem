package ca.georgebrown.comp3074.pocketmealapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity {
private TextView txtV;
DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      dbHelper = new DBHelper();

      User u = new User(1,"Orelljunior@gmail.com","Junior","Nazario","password","donor","torontom5");
      Food f = new Food("test2","12-09-2020","oignon,mushroom,tomatoes");
       //dbHelper.addFood("Rodrigo","F1",f);
       // dbHelper.addFood("Rodrigo","F2",f);
     //   dbHelper.insertUser("Rodrigo",u);
        dbHelper.updateUserInfo("Rodrigo","CoryKenshin@gmail.com","email");

    }

    public static String filterEmailKey(String email){
       // String str_final = "";
        String[] str =  email.split("@",2);
       String str_final = str[0];

        if(str[0].contains(".")) {
            String[] str_2 = str[0].split("\\.", 2);
            str_final = str_2[0] + str_2[1];

        }

        return  str_final;
    }



/*private void readData(final MyCallback myCall) {

        reffUserManager.orderByKey().equalTo(filterEmailKey("Stephan.junior@gmail.com"))
                .addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override

                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        Log.d("===", String.valueOf(dataSnapshot.exists()));

                        for (DataSnapshot dataObject : dataSnapshot.getChildren()) {


                            Log.d("===", dataObject.child("first_name").getValue().toString());
                           int id = Integer.parseInt(dataObject.child("id").getValue().toString());
                           String email = dataObject.child("email").getValue().toString();
                           String city_PostalCode = dataObject.child("city_PostalCode").getValue().toString();
                           String first_name = dataObject.child("first_name").getValue().toString();
                           String last_name = dataObject.child("last_name").getValue().toString();
                           String pass = dataObject.child("password").getValue().toString();
                            String type = dataObject.child("type").getValue().toString();

                            user = new User(
                                  id,email,first_name,last_name,pass,type,city_PostalCode


                            );
                            double lon = Double.parseDouble(dataObject.child("userPoint/longitude").getValue().toString());
                            double lat = Double.parseDouble(dataObject.child("userPoint/latitude").getValue().toString());
                          user.setUserPoint(lat,lon);

                        }

                        myCall.onCallback(user);


                        // user = childSnapshot.getValue(User.class);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


    }


    interface MyCallback {
        void onCallback(User user);

    }*/
}

