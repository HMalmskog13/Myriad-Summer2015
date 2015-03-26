package tinycastle.hearyehearye.castleforum;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit.RestAdapter;

/*To-do:
* recyclerview/picasso
* */
public class Forum extends ActionBarActivity {

    private Toolbar toolbar;
    Intent intent = new Intent(this, Kingdom.class);
    public static final String BASE_URL = "https://challenge2015.myriadapps.com/api/v1";
    List<Place> places;
    Bundle extra = getIntent().getExtras();
    String em  = extra.getString("email");
    private RecyclerView recView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        //make toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //get list of kingdoms
        RestApi restApi = new RestAdapter.Builder().setEndpoint(BASE_URL).build().create(RestApi.class);
        places = restApi.placeList();

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //set title to user email
        getMenuInflater().inflate(R.menu.menu_forum, menu);
        String user = SignUp.sharedPref.getString(SignUp.PREF_EMAIL, "");
        toolbar.setTitle(user);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        //pass the selected kingdom's name, id # and image path
        intent.putExtra("id", id);
        String kn = places.get(id).name;
        intent.putExtra("name", kn);
        String kImg = places.get(id).image;
        intent.putExtra("image", kImg);
        pickKingdom();
        return super.onOptionsItemSelected(item);

    }

    //move to  the screen with the chosen kingdom's info
    public void pickKingdom()
    {
        startActivity(intent);
    }

    //this method erases the user's email from local memory
    public void onLogout()
    {
        SharedPreferences.Editor edit = SignUp.sharedPref.edit();
        edit.remove(SignUp.PREF_EMAIL);
        edit.commit();
    }

//for showing the recyclerview
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
       View layout = inflater.inflate(R.layout.activity_forum, container, false);
       recView = (RecyclerView) findViewById(R.id.rView);
       //picasso in rviewer?
       return layout;
    }

}
