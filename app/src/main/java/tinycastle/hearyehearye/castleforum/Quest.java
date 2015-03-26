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

import com.squareup.picasso.Picasso;


public class Quest extends ActionBarActivity {

    public int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        //create the toolbar, set the title to the quest number
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitle("Quest i")
        toolbar.setTitle(Kingdom.kName+" quest " + (count+1));
        //load the quest image 
        Picasso.with(this).load(Uri.parse(Kingdom.quests.get(count).image)).into((android.widget.ImageView) findViewById(R.id.questImage));
        //add back arrow
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //slider for quest
        QuestSlider slider = new QuestSlider();
        slider.onCreate(savedInstanceState);
        //set quest info
        EditText questName = (EditText)findViewById(R.id.qName);
        questName.setText(Kingdom.quests.get(count).name);
        EditText questDesc = (EditText)findViewById(R.id.qDesc);
        questDesc.setText(Kingdom.quests.get(count).description);
        EditText questGiver = (EditText)findViewById(R.id.giver);
        questGiver.setText(Kingdom.quests.get(count).giver);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quest, menu);
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
        //for back arrow
        if(id == android.R.id.home)
        {
            Intent intent = new Intent (this, Kingdom.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
