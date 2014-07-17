package com.teenstian.universaldemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.TransactionTooLargeException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.teenstian.universaldemo.circleimage.CircleImageActivity;
import com.teenstian.universaldemo.compoundviews.CompoundViewsActivity;
import com.teenstian.universaldemo.crouton.CroutonDemo;
import com.teenstian.universaldemo.demolayout.LayoutActivity;
import com.teenstian.universaldemo.imageslider.ImageSilderActivity;
import com.teenstian.universaldemo.pagersliding.PagerSlidingActivity;
import com.teenstian.universaldemo.progressbutton.ProgressButtonActivity;
import com.teenstian.universaldemo.qrcode.QREncodeActivity;
import com.teenstian.universaldemo.swipelistview.PackageInfoActivity;
import com.teenstian.universaldemo.swipelistview.SwipeListViewExampleActivity;
import com.teenstian.universaldemo.swipelistview.library.SwipeListViewListener;
import com.teenstian.universaldemo.translucentactionbar.TranslucentActionBarActivity;
import com.teenstian.universaldemo.viewanimation.ViewAnimationActivity;
import com.teenstian.universaldemo.vparser.VparserMainActivity;


public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		private ListView listView;

		public PlaceholderFragment() {

		}

		@Override
		public void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			listView = (ListView) rootView.findViewById(R.id.listview);
			
			listView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, getData()));
			
			listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();
					int i = position;
					switch (i) {
					case 0:
						intent.setClass(getActivity(), LayoutActivity.class);
						break;
					case 1:
						intent.setClass(getActivity(), CircleImageActivity.class);
						break;
					case 2:
						intent.setClass(getActivity(), ViewAnimationActivity.class);
						break;
					case 3:
						intent.setClass(getActivity(), CompoundViewsActivity.class);
						break;
					case 4:
						intent.setClass(getActivity(), QREncodeActivity.class);
						break;
					case 5:
						intent.setClass(getActivity(), VparserMainActivity.class);
						break;
					case 6:
						intent.setClass(getActivity(), ProgressButtonActivity.class);
						break;
					case 7:
						intent.setClass(getActivity(), PagerSlidingActivity.class);
						break;
					case 8:
						intent.setClass(getActivity(), CroutonDemo.class);
						break;
					case 9:
						intent.setClass(getActivity(), SwipeListViewExampleActivity.class);
						break;
					case 10:
						intent.setClass(getActivity(), ImageSilderActivity.class);
						break;
					case 11:
						intent.setClass(getActivity(), TranslucentActionBarActivity.class);
						break;
					default:
						break;
					}
					getActivity().startActivity(intent);
				}
			});
			
			return rootView;
		}

		private List<String> getData() {
			List<String> data = new ArrayList<String>();
			data.add("Demo Layout");
			data.add("Circle Image");
			data.add("View Animation");
			data.add("Compound Views");
			data.add("QR Encode");
			data.add("Vparser");
			data.add("ProgressButton");
			data.add("PagerSlidingTabStrip");
			data.add("Crouton");
			data.add("Swipe ListView");
			data.add("ImageSlider");
			data.add("Translucent ActionBar");
			return data;
		}
		
	}

}




