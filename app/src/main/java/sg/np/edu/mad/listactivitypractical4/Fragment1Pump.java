package sg.np.edu.mad.listactivitypractical4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Fragment1Pump extends Fragment {
    //pump controls fragment2.xml
    @Override
    public View onCreateView(LayoutInflater pump, ViewGroup cluster, Bundle savedInstanceState){
        View v = pump.inflate(R.layout.fragment1, cluster, false);
        return v;
    }
}
