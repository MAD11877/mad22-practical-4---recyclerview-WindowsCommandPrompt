package sg.np.edu.mad.listactivitypractical4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Array;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = "myTAG";

    private static int LAYOUT_NORMAL = 1;
    private static int LAYOUT_EXTRA = 2;

    Context context;

    ArrayList<User> userList;

    ArrayList<Integer> container = new ArrayList<Integer>();

    //extract the nameID
    private ArrayList<String> addToArray() {
        ArrayList<String> temporalStorage = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            temporalStorage.add(userList.get(i).getNameID());
        }
        return temporalStorage; //size() -> 20
    }

    public RecyclerViewAdapter(Context context, ArrayList<User> userList){
        this.context = context;
        this.userList = userList;
    }

    private ArrayList<Boolean> Switcher(){
        ArrayList<Boolean> boolList = new ArrayList<>();
        for (int i = 0; i < addToArray().size(); i++){
            if (addToArray().get(i).charAt(addToArray().get(i).length() - 1) == '7'){
                boolList.add(true);
            }
            else{
                boolList.add(false);
            }
        }
        return boolList;
    }

    @Override
    public int getItemViewType(int location){
        if (Switcher().get(location)){
            return LAYOUT_EXTRA; //2
        }
        else if (!Switcher().get(location)) {
            return LAYOUT_NORMAL; //
        }
        return 0;
    }

    /*Implement all the methods*/
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //now we will need to inflate the viewholder...
        //should be inflate(R.layout.containerTemplate)
        //Log.d(TAG, Switcher().toString());
        RecyclerView.ViewHolder vh = null;
        if (viewType == LAYOUT_NORMAL) { //for nameID with no '7' at the back
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.listing_format, parent, false);
            vh = new ViewHolder(item);
        } else if (viewType == LAYOUT_EXTRA) { //for nameID with a '7' at the back
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.listing_format_extra, parent, false);
            vh = new ViewHolderExtra(item);
        }
        return vh; //return the relevant viewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //nameString -> nameHolder
        //descriptionString -> descriptionHolder
        if (getItemViewType(position) == LAYOUT_NORMAL){ //if no 7
            //we will need to create the object???
            //Log.d(TAG, Integer.toString(getItemViewType(position)));
            ViewHolder vh = (ViewHolder) holder;
            vh.nh.setText(userList.get(position).getNameID());
            vh.dh.setText(userList.get(position).getDescID());

            //funny thing is why is not called 'setOnTapListener'???
            vh.VH_LL.setOnClickListener(function -> {
                AlertDialog.Builder messageConstructor = new AlertDialog.Builder(context);
                messageConstructor
                    .setTitle("Profile")
                    .setMessage(((ViewHolder)holder).nh.getText())
                    .setPositiveButton(
                        "View",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                CharSequence nameID = ((ViewHolder)holder).nh.getText();
                                CharSequence descID = ((ViewHolder)holder).dh.getText();
                                Intent teleporter = new Intent();
                                teleporter.putExtra("NameString", nameID);
                                teleporter.putExtra("DescString", descID);
                                teleporter.setClassName("sg.np.edu.mad.listactivitypractical4", "sg.np.edu.mad.listactivitypractical4.userProfileController");
                                context.startActivity(teleporter);
                            }
                        }
                    )
                    .setNegativeButton(
                        "Cancel",
                            new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                //Log.d(TAG, "Dialog box closed and process terminated");
                            }
                        }
                    );
                AlertDialog display = messageConstructor.create();
                display.show();
            });
        }
        else{ //if 7
            ViewHolderExtra vhe = (ViewHolderExtra) holder;
            vhe.nhe.setText(userList.get(position).getNameID());
            vhe.dhe.setText(userList.get(position).getDescID());

            vhe.VHE_LL.setOnClickListener(function -> {
                //Build the message...
                AlertDialog.Builder messageBuilder = new AlertDialog.Builder(context);
                messageBuilder
                    .setTitle("Profile")
                    .setMessage(((ViewHolderExtra)holder).nhe.getText())
                    .setPositiveButton(
                            "View",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            CharSequence nameID = ((ViewHolderExtra)holder).nhe.getText();
                            CharSequence descID = ((ViewHolderExtra)holder).dhe.getText();
                            Intent teleporter = new Intent();
                            teleporter.putExtra("NameString", nameID);
                            teleporter.putExtra("DescString", descID);
                            teleporter.setClassName("sg.np.edu.mad.listactivitypractical4", "sg.np.edu.mad.listactivitypractical4.userProfileController");
                            context.startActivity(teleporter);
                        }
                    })
                    .setNegativeButton(
                    "Cancel",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                AlertDialog show = messageBuilder.create();
                show.show();
            });
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
