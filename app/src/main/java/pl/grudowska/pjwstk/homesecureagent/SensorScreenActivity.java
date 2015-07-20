package pl.grudowska.pjwstk.homesecureagent;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class SensorScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_screen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sensor_screen, menu);
        restoreActionBar();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        switch (item.getItemId()) {
            case R.id.action_about:
                DialogFragment about = new AboutDialog();
                about.show(getSupportFragmentManager(), "");
                return true;
            case R.id.action_update:
                // Update option clicked.
                return true;
            case R.id.action_notification:
                // Notification option clicked.
                return true;
            case R.id.action_sensors_dialog:
                DialogFragment dialog = new SensorDialog();
                dialog.show(getSupportFragmentManager(), "");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * callback method from SensorDialog (fragment), returning the value of user
     * input.
     *
     * @param selectedValues value returned from SensorDialog. array of selected checkboxes.
     */
    public void onUserSelectValues(ArrayList<Integer> selectedValues) {
        Toast.makeText(this, "index " + selectedValues.get(0).toString(),Toast.LENGTH_LONG).show();
        // TODO add your implementation.
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.icon_orange);
    }
}
