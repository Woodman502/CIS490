package cis490.joewoodcox.parsetutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;

public class ListActivity extends AppCompatActivity {
    private Button btnCreate;
    private Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "tTBmXNXyIfqdQzvW9SLpw2i5fBKuc60eYqxVzQcV", "0yk9YnCBjyi5jf96bsrrmMISgpK5Z4WDCQWZIjTz");
        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent createActivity = new Intent(getApplicationContext(), CreateActivity.class);
                startActivity(createActivity);

            }
        });

        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent updateActivity = new Intent(getApplicationContext(), UpdateActivity.class);
                startActivity(updateActivity);

            }
        });
    }

}
