package sg.np.edu.mad.listactivitypractical4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.*;
import java.util.*;

public class ListActivityPractical4 extends AppCompatActivity {

    private static final String TAG = "ListActivityPractical4";

    public ListActivityPractical4(){ }

    public static ArrayList<User> userList = new ArrayList<User>();

    @Override   
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //root view
        setContentView(R.layout.activity_list_practical4);

        /*
        //Following chunk of code tests for whether are there exactly 20 descID and nameID being appended to the list
        for(int i = 0; i < userList.size(); i++){
            Log.v(TAG, String.format("%s", userList.get(i).getDescID()));
            Log.v(TAG, String.format("%s", userList.get(i).getNameID()));
        }
         */

        //create 20 user objects...
        do{
            Random generator = new Random();
            User user = new User(); //null constructor
            int descIDIntegerSegment = Math.abs(generator.nextInt());
            int nameIDIntegerSegment = Math.abs(generator.nextInt());
            int followStatus = Math.abs(generator.nextInt(2));
            user.setDescID("Description" + Integer.toString(descIDIntegerSegment));
            user.setNameID("Name" + Integer.toString(nameIDIntegerSegment));
            if (followStatus == 0){
                user.setFollowed(false);
            }
            else if (followStatus == 1){
                user.setFollowed(true);
            }
            userList.add(user);
        }
        while (userList.size() < 20);

        /*
        for (int i = 0; i < userList.size(); i++) {
            Log.d(TAG, Boolean.toString(userList.get(i).getFollowed()));
        }
        */


        RecyclerView rv = findViewById(R.id.recyclerViewMain); //locate the recycler view

        //insert the data into the adapter...
        RecyclerViewAdapter rva = new RecyclerViewAdapter(this, userList); //insert the data...


        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setLayoutManager(llm);
        rv.setAdapter(rva);
    }
}