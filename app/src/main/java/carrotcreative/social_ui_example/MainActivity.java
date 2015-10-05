package carrotcreative.social_ui_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.carrotcreative.socialui.util.SocialActionHandler;
import com.carrotcreative.socialui.widget.SocialTextView;

public class MainActivity extends AppCompatActivity
{
    private SocialTextView mTextView;

    SocialActionHandler mHandler = new SocialActionHandler()
    {
        @Override
        public void handleHashtag(String hashtag)
        {
            Toast.makeText(MainActivity.this, "Hashtag: " + hashtag, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void handleMention(String mention)
        {
            Toast.makeText(MainActivity.this, "Mention: " + mention, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void handleUrl(String url)
        {
            Toast.makeText(MainActivity.this, "URL: " + url, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void handleEmail(String email)
        {
            Toast.makeText(MainActivity.this, "Email: " + email, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTextView = (SocialTextView) findViewById(R.id.social_text_example);
        mTextView.linkify(mHandler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
