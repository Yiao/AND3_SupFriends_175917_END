package and3.supinfo.com.and3_supfriends_175917;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    private static String page = "0";

    public static String getPage() {
        return page;
    }

    public static void setPage(String page) {
        MainActivity.page = page;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String mytab = "0";

        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);

        /** TabSpec used to create a new tab.
         * By using TabSpec only we can able to setContent to the tab.
         * By using TabSpec setIndicator() we can set name to tab. */

        /** tid1 is firstTabSpec Id. Its used to access outside. */
        TabHost.TabSpec firstTabSpec = tabHost.newTabSpec("tab_id1");
        TabHost.TabSpec secondTabSpec = tabHost.newTabSpec("tab_id2");
        TabHost.TabSpec thirdTabSpec = tabHost.newTabSpec("tab_id3");

        /** TabSpec setIndicator() is used to set name for the tab. */
        /** TabSpec setContent() is used to set content for a particular tab. */
        firstTabSpec.setIndicator("Login").setContent(new Intent(this, LoginActivity.class));
        secondTabSpec.setIndicator("ListInfo ").setContent(new Intent(this, ListActivity.class));
        thirdTabSpec.setIndicator("Maps").setContent(new Intent(this, MapsActivity.class));


        /** Add tabSpec to the TabHost to display. */
        tabHost.addTab(firstTabSpec);
        tabHost.addTab(secondTabSpec);
        tabHost.addTab(thirdTabSpec);



        if (page.equals("1"))
        {
            tabHost.setCurrentTab(1);
        }
        else if (page.equals("2"))
        {
            tabHost.setCurrentTab(2);
        }
        else if(page.equals("0"))
        {
            tabHost.setCurrentTab(0);
        }

    }
}
