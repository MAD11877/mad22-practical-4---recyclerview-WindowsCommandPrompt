package sg.np.edu.mad.listactivitypractical4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class userProfileController extends AppCompatActivity {

    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.user_profile);

        Intent whiteHole = getIntent();

        CharSequence nameString = whiteHole.getCharSequenceExtra("NameString");
        CharSequence descString = whiteHole.getCharSequenceExtra("DescString");

        TextView tv = findViewById(R.id.Name);
        TextView tv1 = findViewById(R.id.Description);

        tv.setText(nameString);
        tv1.setText(descString);

        Button followUnfollowButton = findViewById(R.id.button_no1);
        Button messageButton = findViewById(R.id.button_no2);

        ListActivityPractical4 lap4 = new ListActivityPractical4();
        ArrayList<User> userList = lap4.userList;

        //Initialise the buttons...
        /* 
        Log.d(TAG, userList.toString());
        Log.d(TAG, Integer.toString(userList.size()));
        */ 

        for (int i = 0; i < userList.size(); i++){
            if(userList.get(i).getFollowed()){
                followUnfollowButton.setText("Unfollow");
            }
            else{
                followUnfollowButton.setText("Follow");
            }
        }

        messageButton.setOnClickListener(thenFunctionAs -> {
            Intent andThenRedirect = new Intent();
            andThenRedirect.setClassName("sg.np.edu.mad.listactivitypractical4", "sg.np.edu.mad.listactivitypractical4.MessagePage");
            startActivity(andThenRedirect);
        });
        
        Log.d(TAG, "Before: " + Boolean.toString(userList.get(whiteHole.getIntExtra("ViewHolderIndex", 0)).getFollowed()));  //returns old boolean value of whether the person followed or unfollowed
        followUnfollowButton.setOnClickListener(thenFunctionAs -> {
            if ((followUnfollowButton.getText()).equals("Follow")){
                followUnfollowButton.setText("Unfollow");
                userList.get(whiteHole.getIntExtra("ViewHolderIndex", 0)).setFollowed(false);
                Log.d(TAG, "After: " + Boolean.toString(userList.get(whiteHole.getIntExtra("ViewHolderIndex", 0)).getFollowed())); //returns new boolean value of the person has followed or unfollowed, should give false. 
                Toast.makeText(this, "Followed", Toast.LENGTH_SHORT).show();
            }
            else{
                followUnfollowButton.setText("Follow");
                userList.get(whiteHole.getIntExtra("ViewHolderIndex", 0)).setFollowed(true);
                Log.d(TAG, "After: " + Boolean.toString(userList.get(whiteHole.getIntExtra("ViewHolderIndex", 0)).getFollowed())); //returns new boolean value of the person has followed or unfollowed, should give true. 
                Toast.makeText(this, "Unfollowed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
