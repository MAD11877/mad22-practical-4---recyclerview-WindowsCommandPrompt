package sg.np.edu.mad.listactivitypractical4;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView nh, dh;
    LinearLayout VH_LL;
    public ViewHolder (View obj){
        super(obj);
        nh = obj.findViewById(R.id.nameHolder); //target
        dh = obj.findViewById(R.id.descriptionHolder); //target
        VH_LL = obj.findViewById(R.id.containerTemplate);
    }
}
