package sg.np.edu.mad.listactivitypractical4;

public class User {

    private String descID;
    private String nameID;
    private Boolean followed;

    public User(){

    }

    public String getDescID() {
        return descID;
    }

    public String getNameID() {
        return nameID;
    }

    public void setDescID(String descID) {
        this.descID = descID;
    }

    public void setNameID(String nameID) {
        this.nameID = nameID;
    }

    public boolean getFollowed(){
        return followed;
    }

    public void setFollowed(boolean followed){
        this.followed = followed;
    }
}
