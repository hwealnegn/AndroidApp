package com.example.listview1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	private ListView listView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listView = (ListView) findViewById(R.id.listView1);
        
//        setData1();
//        setData2();
//        setData3();
        setData4();
    }

    private void setData1(){
    	String[] objects = {"1", "2", "3", "4", "5", "6", "7", "8",
        		"9", "10", "11", "12", "13"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, objects);
        listView.setAdapter(adapter);
    }
    
    private void setData2(){
    	List<People> objects = new ArrayList<People>();
    	objects.add(new People("Tom", 1));
    	objects.add(new People("Jane", 10));
    	ArrayAdapter<People> adapter = new ArrayAdapter<People>(this,
    			android.R.layout.simple_list_item_1, objects);
    	listView.setAdapter(adapter);
    }

    private void setData3(){
    	int[] imageIds = {R.drawable.image1, R.drawable.image2, 
    			R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6};
    	String[] imageText = {"honinbo-shusakus-185th-birthday", 
    			"denmark-national-day-2014", 
    			"alejandro-obregons-93rd-birthday", 
    			"julija-beniuseviciute-zymantienes-169th-birthday", 
    			"italian-republic-day-2014", 
    			"dragon-boat-festival-2014"};
    	List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
    	
    	for (int i=0; i<imageIds.length; i++){
    		Map<String,Object> item = new HashMap<String,Object>();
    		item.put("image", imageIds[i]);
    		item.put("text", imageText[i]);
    		data.add(item);
    	}
    	
    	String[] from = new String[] {"image", "text"};
    	int[] to = new int[] {R.id.imageView1, R.id.textView1};
    	
    	SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.listview_item, from, to);
    	listView.setAdapter(adapter);
    }
    
    private void setData4(){
    	String[] text = {"honinbo-shusakus-185th-birthday", 
    			"denmark-national-day-2014", 
    			"alejandro-obregons-93rd-birthday", 
    			"julija-beniuseviciute-zymantienes-169th-birthday", 
    			"italian-republic-day-2014", 
    			"dragon-boat-festival-2014"};
    	
    	List<Map<String,String>> data = new ArrayList<Map<String, String>>();
    	
    	for (int i=0; i<text.length; i++){
    		Map<String,String> item = new HashMap<String, String>();
    		item.put("text1", text[i].substring(0,5));
    		item.put("text2", text[i]);
    		data.add(item);
    	}
    	
    	String[] from = new String[] {"text1", "text2"};
    	int[] to = new int[] {android.R.id.text1, android.R.id.text2};
    	SimpleAdapter adapter = new SimpleAdapter(this, data, android.R.layout.simple_list_item_2, from, to);
    	listView.setAdapter(adapter);
    	
    	listView.setOnItemClickListener(new OnItemClickListener(){
    		@Override
    		public void onItemClick(AdapterView<?> parent, View view, int position, long id){
    			TextView textView1 = (TextView) view.findViewById(android.R.id.text1);
    			TextView textView2 = (TextView) view.findViewById(android.R.id.text2);
    			
    			String detail = "position:" + position + " title:" + textView1.getText() + " subtitle:" + textView2.getText();
    			
    			Toast.makeText(MainActivity.this, detail, Toast.LENGTH_SHORT).show();
    		}
    	});
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
}
