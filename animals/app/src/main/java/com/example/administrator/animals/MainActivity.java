package com.example.administrator.animals;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.widget.AdapterView.OnItemClickListener;
import static android.widget.AdapterView.OnItemSelectedListener;


public class  MainActivity extends AppCompatActivity {
    private String[] animals = new String[]
            {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] imageIds = new int[]
            {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < animals.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("text", animals[i]);
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.item_layout,
                new String[]{"text", "image"},
                new int[]{R.id.texts, R.id.views});
        ListView list = (ListView) findViewById(R.id.listview);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);

        // 为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new OnItemClickListener() {
            // 第position项被单击时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                view.setBackgroundColor(Color.RED);
                Toast toast = Toast.makeText(MainActivity.this,animals[position],Toast.LENGTH_SHORT);
                toast.show();

            }
        });
        // 为ListView的列表项的选中事件绑定事件监听器
        list.setOnItemSelectedListener(new OnItemSelectedListener() {
            // 第position项被选中时激发该方法
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    };
};