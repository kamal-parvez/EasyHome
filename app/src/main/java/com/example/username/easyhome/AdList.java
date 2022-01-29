package com.example.username.easyhome;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class AdList extends ArrayAdapter<PostInfo>{
    private Activity context;
    private List<PostInfo> list;
    //HashMap<PostInfo, String> map;

    public AdList(Activity context, List<PostInfo> list) {
        super(context, R.layout.listview, list);
        this.context = context;
        this.list = list;
        //this.map = map;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.listview, null, true);
        TextView title = (TextView) listViewItem.findViewById(R.id.title);
        TextView size = (TextView) listViewItem.findViewById(R.id.size);
        TextView area = (TextView) listViewItem.findViewById(R.id.area);
       // Button button=(Button) listViewItem.findViewById(call);


        final PostInfo flatInfo = list.get(position);
        title.setText(flatInfo.getTitle());
        area.setText("Area: " + flatInfo. getArea() + "        Renter Type: " + flatInfo.getRenter());

        size.setText("Size: " + flatInfo.getSize() + "        Rent: " + flatInfo.getRent());


        listViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String   str = flatInfo.getTitle() + "---" + flatInfo.getBed() + "---" + flatInfo.getBath() + "---"
                                + flatInfo.getSize() + "---" + flatInfo.getRent() + "---" +flatInfo.getDivision() + "---"
                                + flatInfo.getArea() + "---" + flatInfo.getRenter() + "---" + flatInfo.getAddress() + "---"
                                + flatInfo.getDescription() + "---" + flatInfo.getFeatures() + "---" + flatInfo.getName() + "---"
                                + flatInfo.getPhn() + "---" + flatInfo.getCategory();

                //String key = map.get(flatInfo);
                Intent intent = new Intent(context, Description.class);
                intent.putExtra("KEY",str);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }
        });

        return listViewItem;
    }

}
