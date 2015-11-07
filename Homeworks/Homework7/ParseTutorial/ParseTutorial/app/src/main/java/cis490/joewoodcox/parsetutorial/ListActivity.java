package cis490.joewoodcox.parsetutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import cis490.joewoodcox.parsetutorial.model.Task;
import cis490.joewoodcox.parsetutorial.model.TasksAdapter;

public class ListActivity extends ActionBarActivity {
    private Button btnCreate;
    private TasksAdapter adapter;
    private ArrayList<Task> arrayOfTasks;
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

        Parse.initialize(this, "IvaEeSgTE7H2iFjj9GbGh3UqHjl37Exm0UtDUlZW", "km1Ob5Xe6e52aGahnMABa8FaCzbLHheT6WuO15eU");
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("Parse", "tutorial");
        testObject.saveInBackground();
        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent createActivity = new Intent(getApplicationContext(), CreateActivity.class);
                startActivity(createActivity);

            }
        });

        arrayOfTasks = new ArrayList<Task>();
        adapter = new TasksAdapter(this, arrayOfTasks);
        ListView listView = (ListView) findViewById(R.id.lv_task);
        listView.setAdapter(adapter);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");

        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> taskList, ParseException e) {
                if (e == null) {
                    for (ParseObject tasks : taskList) {

                        Task task = new Task();

                        task.setTaskId(tasks.getObjectId());
                        task.setName(tasks.getString("name"));

                        Log.d("name",task.getName());
                        adapter.add(task);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = adapter.getItem(position);

                Intent intent = new Intent(getBaseContext(), UpdateActivity.class);
                intent.putExtra("objectId",  task.getTaskId());
                startActivity(intent);
            }
        });
    }

}
