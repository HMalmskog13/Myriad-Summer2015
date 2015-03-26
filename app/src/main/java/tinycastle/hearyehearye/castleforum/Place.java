package tinycastle.hearyehearye.castleforum;



/**
 * Created by Heather on 3/17/2015.
 * for kingdom get with restapi
 * https://challenge2015.myriadapps.com/api/v1/kingdoms
 */
public class Place {
    public int id;
    public String name;
    public String image;

    public void Place(int num, String n, String i)
    {
        id = num;
        name = n;
        image = i;
    }
}
