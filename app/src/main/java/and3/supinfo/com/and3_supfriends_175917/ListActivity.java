package and3.supinfo.com.and3_supfriends_175917;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView mListView = (ListView) findViewById(R.id.listView);
//        Groups[] mygoups;
//        ArrayList<Groups> arrayGroups = new ArrayList<Groups>();
//        try {
//            String json = "{\"groups\": [{\"id\":1, \"name\": \"myGroup\"}, {\"id\":2, \"name\": \"myGroup2\"}, {\"id\":3, \"name\": \"myGroup3\"}]}";
//            Gson gson = new Gson();
////            BufferedReader br = new BufferedReader( new FileReader(""));
//            mygoups = gson.fromJson(json, Groups[].class);
//            for (Groups group : mygoups)
//            {
//                arrayGroups.add(group);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        String[] values = new String[] { "Yiao",
                "Gael",
                "Khalil",
                "Eric",
        };


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,values );
//        ArrayAdapter<Groups> arrayAdapter = new ArrayAdapter<Groups>(this, android.R.layout.simple_list_item_1, arrayGroups);
//        assert mListView != null;
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                MainActivity.setPage("2");

                String item = ((TextView) view).getText().toString();

                Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                if(item.equals("Yiao"))
                {
                    intent.putExtra("Title", "QingDao China");
                    intent.putExtra("Latitude", "36.1357459");
                    intent.putExtra("Longitude", "120.0853454");
                    intent.putExtra("snippet", "Yiao");
                }
                else if(item.equals("Gael"))
                {
                    intent.putExtra("Title", "Paris France");
                    intent.putExtra("Latitude", "48.8589507");
                    intent.putExtra("Longitude", "2.2775175");
                    intent.putExtra("snippet", "Gael");
                }
                else if(item.equals("Khalil"))
                {
                    intent.putExtra("Title", "Tunis");
                    intent.putExtra("Latitude", "36.7949999");
                    intent.putExtra("Longitude", "10.073238");
                    intent.putExtra("snippet", "Khalil");
                }
                else if(item.equals("Eric"))
                {
                    intent.putExtra("Title", "Lille");
                    intent.putExtra("Latitude", "50.6310465");
                    intent.putExtra("Longitude", "2.9771209");
                    intent.putExtra("snippet", "Eric");
                }
                else
                {
                    intent.putExtra("Title", "Orleans");
                    intent.putExtra("Latitude", "47.8735098");
                    intent.putExtra("Longitude", "1.8421691");
                    intent.putExtra("snippet", "Orleans");
                    Toast.makeText(getBaseContext(), "Mistake", Toast.LENGTH_SHORT).show();
                }
                startActivity(intent);
            }
        });
    }
}
