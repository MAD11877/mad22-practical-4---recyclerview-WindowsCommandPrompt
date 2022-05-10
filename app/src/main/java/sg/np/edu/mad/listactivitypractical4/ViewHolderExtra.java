package sg.np.edu.mad.listactivitypractical4;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderExtra extends RecyclerView.ViewHolder {
    TextView nhe, dhe;
    LinearLayout VHE_LL;
    public ViewHolderExtra(View obj){
        super(obj);
        nhe = obj.findViewById(R.id.nameHolderExtra); //target
        dhe = obj.findViewById(R.id.descriptionHolderExtra); //target
        VHE_LL = obj.findViewById(R.id.mainContainerTemplate);
    }
}
