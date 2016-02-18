package materialdrawertest.jonathancaryl.org.materialdrawertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements Drawer.OnDrawerItemClickListener {
    private static final long ID1 = 1;
    private static final long ID2 = 2;
    private static final long ID3 = 3;
    private static final long ID4 = 4;
    private static final long ID5 = 5;
    private static final long ID6 = 6;
    private static final long ID7 = 7;
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = new DrawerBuilder()
            .addDrawerItems()
            .withActivity(this)
            .withDrawerItems(generateNavItems())
            .withHeader(R.layout.drawer_header)
            .withActionBarDrawerToggle(true)
            .withOnDrawerItemClickListener(this)
            .withDelayOnDrawerClose(0)
            .withFooter(R.layout.drawer_footer)
            .build();

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.updateBadge(ID1, new StringHolder("TESTING"));
            }
        });
    }

    private ArrayList<IDrawerItem> generateNavItems() {

        BadgeStyle badgeStyle = new BadgeStyle()
            .withCorners(100);

        return new ArrayList<IDrawerItem>(Arrays.asList(
            new PrimaryDrawerItem()
                .withIdentifier(ID1)
                .withName("1"),
            new PrimaryDrawerItem()
                .withIdentifier(ID2)
                .withName("2")
                .withBadge("")
                .withBadgeStyle(badgeStyle),
            new PrimaryDrawerItem()
                .withIdentifier(ID3)
                .withName("3"),
            new PrimaryDrawerItem()
                .withIdentifier(ID4)
                .withName("4")
                .withBadge("")
                .withBadgeStyle(badgeStyle),
            new DividerDrawerItem(),
            new PrimaryDrawerItem()
                .withIdentifier(ID5)
                .withName("5"),
            new SecondaryDrawerItem()
                .withIdentifier(ID6)
                .withName("6"),
            new SecondaryDrawerItem()
                .withIdentifier(ID7)
                .withName("7")
        ));
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
        return false;
    }
}
