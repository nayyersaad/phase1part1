package com.example.phase1part1;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DashboardActivity extends Activity {
	
	private String[] nDrawerListItems;
	private DrawerLayout nDrawerLayout;
	private ListView nDrawerList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		
		nDrawerListItems = getResources().getStringArray(R.array.listDrawerItems);
		nDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		nDrawerList = (ListView) findViewById(R.id.left_drawer);
		
		ArrayAdapter<CharSequence> mDrawerListAdapter = ArrayAdapter.createFromResource(getBaseContext(),
				R.array.listDrawerItems,
				R.layout.drawer_list_item);
		nDrawerList.setAdapter(mDrawerListAdapter);
		
		FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				
				DrawerFragment fragment = new DrawerFragment();
				fragmentTransaction.add(R.id.content_frame, fragment);
				fragmentTransaction.commit();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dashboard, menu);
		return true;
	}

	public static class DrawerFragment extends Fragment{
		public DrawerFragment() {
			// TODO Auto-generated constructor stub
		}
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
	        return inflater.inflate(R.layout.activity_login_screen, container, false);
	    }		
	}
	
}
