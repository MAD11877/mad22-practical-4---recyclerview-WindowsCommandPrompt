package sg.np.edu.mad.listactivitypractical4;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2Pump extends Fragment {
    //pump controls fragment2.xml
    @Override
    public View onCreateView(LayoutInflater pump, ViewGroup cluster, Bundle savedInstanceState){
        View v = pump.inflate(R.layout.fragment2, cluster, false);
        return v;
    }
}
