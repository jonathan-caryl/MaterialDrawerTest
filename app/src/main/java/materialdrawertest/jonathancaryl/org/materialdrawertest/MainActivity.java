package materialdrawertest.jonathancaryl.org.materialdrawertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final long ID1 = 1;
    private static final boolean SHOULD_CRASH_ON_UPDATE = true;
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerBuilder drawerBuilder = new DrawerBuilder()
            .addDrawerItems()
            .withActivity(this)
            .withDrawerItems(generateNavItems());
        if (SHOULD_CRASH_ON_UPDATE) {
            drawerBuilder.withFooter(R.layout.drawer_footer);
        }

        drawer = drawerBuilder.build();

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.updateBadge(ID1, new StringHolder("TESTING"));
            }
        });
    }

    private ArrayList<IDrawerItem> generateNavItems() {

        return new ArrayList<IDrawerItem>(Arrays.asList(
            new PrimaryDrawerItem()
                .withIdentifier(ID1)
                .withName("1")
        ));
    }
}
