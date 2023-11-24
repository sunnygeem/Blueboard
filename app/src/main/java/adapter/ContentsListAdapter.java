package adapter;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.se.blueboard.R;
import com.se.blueboard.UploadContentPage;

import java.util.ArrayList;

import model.Lecture;
import model.LectureContent;
import utils.Utils;

public class ContentsListAdapter extends BaseAdapter {
    ArrayList<LectureContent> lectureContentList = new ArrayList<>();

    public ContentsListAdapter(ArrayList<LectureContent> lectureContentList) {
        this.lectureContentList = lectureContentList;
    }

    @Override
    public int getCount() {
        return lectureContentList.size();
    }

    @Override
    public Object getItem(int position) {
        return lectureContentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        final LectureContent lectureContent = lectureContentList.get(position);

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.contents_list, parent, false);

            TextView currentWeek = (TextView) convertView.findViewById(R.id.contentsList_week);
            currentWeek.setText( "Week " + Integer.toString(lectureContent.getWeek()));

            Button uploadButton = convertView.findViewById(R.id.contentsList_uploadButton);
            uploadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Utils.gotoPage(context, UploadContentPage.class);
                }
            });
        }
        else {
            View newView = new View(context);
            newView = (View) convertView;
        }



        return convertView;
    }
}
