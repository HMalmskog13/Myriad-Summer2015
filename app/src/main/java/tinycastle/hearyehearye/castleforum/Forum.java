package tinycastle.hearyehearye.castleforum;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit.RestAdapter;


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
        recView = (RecyclerView)findViewById(R.id.rView);
        recView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recView.setLayoutManager(layoutManager);
        for (int i =0; i<places.size(); i++)
        {
            TextView pText = (TextView) findViewById(R.id.placeText);
            pText.setText(places.get(i).name);
            Picasso.with(this).load(Uri.parse(places.get(i).image)).into((ImageView) findViewById(R.id.icons));
        }
        //logout listen
        Button b = (Button) findViewById(R.id.logout);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogout();
            }
        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //set title to user email
        getMenuInflater().inflate(R.menu.menu_forum, menu);
        toolbar.setTitle(em);
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


}
