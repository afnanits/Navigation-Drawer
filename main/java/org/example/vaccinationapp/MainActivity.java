package org.example.vaccinationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.navigation.NavigationView;

import org.example.vaccinationapp.R;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    //DrawerLayout drawer;
    //NavigationView navigationView;
    FrameLayout frameLayout;
    ActionBarDrawerToggle toggle;
    //Toolbar toolbar;

    // Make sure to be using androidx.appcompat.app.ActionBarDrawerToggle version.
    private ActionBarDrawerToggle drawerToggle;
    private int mSelectedId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // This will display an Up icon (<-), we will replace it with hamburger later
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);
        //FragmentManager fragmentManager=new F;

        frameLayout = (FrameLayout) findViewById(R.id.flContent);
        //View headerLayout = nvDrawer.inflateHeaderView(R.layout.nav_header);
        toggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        //set default fragment
        loadFragment(new Home());


// We can now look up items within the header if needed

       // ImageView ivHeaderPhoto = headerLayout.findViewById(R.id.imageView);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass = null;
        switch(menuItem.getItemId()) {

            case R.id.childDetails:
                fragmentClass = ChildDetails.class;
                break;
            
            case R.id.home:
                fragmentClass = Home.class;
                break;
          /*  default:
                fragmentClass = FirstFragment.class;*/
            case R.id.articles:
                fragmentClass = Articles.class;
                break;
            case R.id.logout:
                fragmentClass=Home.class;
                Intent intent=new Intent(getBaseContext(),Login.class);
                startActivity(intent);
                break;
            case R.id.nearBy:
                fragmentClass=Home.class;
                Intent i=new Intent(getBaseContext(),MapsActivity.class);
                startActivity(i);
                break;


            default:
                fragmentClass = Home.class;;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment

        FragmentManager fragmentManager = getSupportFragmentManager();
        //  getFragmentManager().popBackStack();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack("fragBack").commit();
        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }
    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flContent, fragment);
        transaction.commit();
    }


}