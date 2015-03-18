package tinycastle.hearyehearye.castleforum;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;


public class Forum extends ActionBarActivity {

    private Toolbar toolbar;
    Intent intent = new Intent(this, Kingdom.class);
    public static final String BASE_URL = "https://challenge2015.myriadapps.com/api/v1/kingdoms";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*final RestApi restApi = new RestAdapter.Builder().setEndpoint(BASE_URL).build().create(RestApi.class);
        new AsyncTask<Void, Void, Place>(){

            @Override
            protected Place doInBackground(Void... params) {
                return restApi.getKingdom();
            }
        }.execute();*/
        //get back as list?

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
        pickKingdom(id);
        return super.onOptionsItemSelected(item);

    }

    public void pickKingdom(int k)
    {
        //pass int to kingdom to open
        startActivity(intent);
    }

}
