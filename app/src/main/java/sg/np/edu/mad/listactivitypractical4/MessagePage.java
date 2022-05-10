package sg.np.edu.mad.listactivitypractical4;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MessagePage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.message_page);

        //create the airPump and inflate accordingly...

        //get the button from the view..
        Button b1 = findViewById(R.id.group1Button); //button to inflate group 1
        Button b2 = findViewById(R.id.group2Button); //button to inflate group 2

        b1.setOnClickListener(function -> {
            controller(new Fragment1Pump());
        });

        b2.setOnClickListener(function -> {
            controller(new Fragment2Pump());
        });
    }

    //pump
    protected void controller(Fragment balloon){
        //now we will need to connect these 'balloons' to a 'pump controller' which will controls the inflation
        //and deflation of the 'balloons' separately...
        FragmentManager pumpMachine = getSupportFragmentManager();
        FragmentTransaction inflationProcess = pumpMachine.beginTransaction();
        inflationProcess.replace(R.id.toggling, balloon);
        inflationProcess.commit();
    }
}
