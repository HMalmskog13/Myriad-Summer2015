package tinycastle.hearyehearye.castleforum;


/**
 * Created by Heather on 3/17/2015.
 * for quest get w/restapi
 * https://challenge2015.myriadapps.com/api/v1/kingdoms/{id}
 */
public class Task {
    public String climate;
    public String population;
    public String name;
    public int id;
    public String description;
    public String giver;
    public String image;

    public void Task(String c, String p, String n, int num, String d, String g, String i)
    {
        climate = c;
        population = p;
        name = n;
        id = num;
        description = d;
        giver = g;
        image = i;
    }
}
