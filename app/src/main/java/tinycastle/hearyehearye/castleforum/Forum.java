package tinycastle.hearyehearye.castleforum;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import java.util.List;

import retrofit.RestAdapter;

/*To-do:
* make toolbar behave - show email & logout overflow
* (how to replace in v 22?)
* check get
* recycler view to show kingdoms
* images - picasso
* */
public class Forum extends ActionBarActivity {

    private Toolbar toolbar;
    Intent intent = new Intent(this, Kingdom.class);
    public static final String BASE_URL = "https://challenge2015.myriadapps.com/api/v1/kingdoms";
    List<Place> places;
    Bundle extra = getIntent().getExtras();
    String em  = extra.getString("email");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RestApi restApi = new RestAdapter.Builder().setEndpoint(BASE_URL).build().create(RestApi.class);
        places = restApi.placeList();
        //Picasso.with(context).load("image").into(imageView);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forum, menu);
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
        intent.putExtra("id", id);
        String kn = places.get(id).name;
        intent.putExtra("name", kn);
        String kImg = places.get(id).image;
        intent.putExtra("image", kImg);
        pickKingdom();
        return super.onOptionsItemSelected(item);

    }

    public void pickKingdom()
    {
        //pass int to kingdom to open
        startActivity(intent);
    }

    public void onLogout()
    {
        SharedPreferences.Editor edit = SignUp.sharedPref.edit();
        edit.remove(SignUp.PREF_EMAIL);
        edit.commit();
    }

}
