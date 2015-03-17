package tinycastle.hearyehearye.castleforum;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit.RestAdapter;
import retrofit.http.POST;


public class SignUp extends ActionBarActivity  {


    public static final String BASE_URL = "https://challenge2015.myriadapps.com/api/v1/subscribe";
    private static final String PREFS = "prefs";
    private static final String PREF_EMAIL = "email";
    SharedPreferences sharedPref;
    EditText eText = (EditText)findViewById(R.id.email);
    String email = eText.getText().toString();
    Intent intent = new Intent(this, Forum.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button mainButton = (Button) findViewById(R.id.submit);
       //check for listener
        mainButton.setOnClickListener((View.OnClickListener) this);
        onLoading();
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

        return super.onOptionsItemSelected(item);
    }

    public boolean checkName() {
        EditText nText = (EditText)findViewById(R.id.name);
        String name = nText.getText().toString();
        if(name != null)
            return true;
        else
            return false;
    }

    public boolean checkEmail()
    {

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        }
        else
            return false;
    }
    private TextView errorMessage = (TextView)findViewById(R.id.error);

    public void onClick(View view)
    {
        boolean nameGood;
        boolean emailGood;
        nameGood = checkName();
        emailGood = checkEmail();
        if (nameGood && emailGood)
        {
            //send to api
            /*RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(BASE_URL)
                    .build();
            @POST("email")*/
            //email as param - required
            //save email locally
            sharedPref = getSharedPreferences(PREFS, MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPref.edit();
            edit.putString(PREF_EMAIL, email);
            edit.commit();
            startActivity(intent);
        }
        else if (nameGood && !emailGood)
            errorMessage.setText("You need to enter a valid email!");
        else if (!nameGood && emailGood)
            errorMessage.setText("You need to enter a name!");
        else
        errorMessage.setText("You need to enter a name and valid email!");

    }


    //check when created
    public void onLoading()
    {
        String filled = sharedPref.getString(PREF_EMAIL, "");
        if(filled.equals("") && filled != null)
        {
            //open the next screen immediately & close this one
            startActivity(intent);
        }
    }
}
