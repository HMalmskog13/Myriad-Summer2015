package tinycastle.hearyehearye.castleforum;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit.RestAdapter;


public class Kingdom extends ActionBarActivity {


    public static final String BASE_URL = "https://challenge2015.myriadapps.com/api/v1";
    Intent intent = new Intent(this, Quest.class);
    int kId ;
    static String kName;
    String kImage;
    static List<Task> quests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kingdom);
        //create toolbar and set title to kingdom name
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(kName);
        //receive data from forum class
        Bundle extras = getIntent().getExtras();
        kId = Integer.parseInt(extras.getString("id"));
        kName = extras.getString("name");
        kImage = extras.getString("image");
        //set kingdom name and image
        EditText editName = (EditText) findViewById(R.id.kName);
        editName.setText(kName);
        Picasso.with(this).load(kImage).into((android.widget.ImageView) findViewById(R.id.kingdomImage));
        //back arrow
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //screen slider
        ScreenSlider slide = new ScreenSlider();
        slide.onCreate(savedInstanceState);
        //retrieve quests from web
        RestApi restApi = new RestAdapter.Builder().setEndpoint(BASE_URL).build().create(RestApi.class);
        quests  = restApi.taskList(kId);
        //set kingdom info
        EditText climate = (EditText) findViewById(R.id.kClimate);
        climate.setText(quests.get(kId).climate);
        EditText pop = (EditText) findViewById(R.id.kPop);
        pop.setText(quests.get(kId).population);
        EditText lang = (EditText)findViewById(R.id.kLang);
        lang.setText(quests.get(kId).language);
        ImageView imageView = (ImageView)findViewById(R.id.kingdomImage);
        imageView.setImageURI(Uri.parse(kImage));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kingdom, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        final int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        startActivity(intent);
        //for back arrow
        if(id == android.R.id.home)
        {
            Intent intent2 = new Intent (this, Forum.class);
            startActivity(intent2);
        }
        return super.onOptionsItemSelected(item);
    }

    //on swipe start quest screen with quest 1
}
