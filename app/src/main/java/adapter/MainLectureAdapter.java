package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.se.blueboard.R;

import java.util.ArrayList;

import model.Lecture;

// Main(Home)에서 강의 목록을 gridview로 출력할 수 있게 하는 adapter
public class MainLectureAdapter extends BaseAdapter {
    ArrayList<Lecture> lectureItems = new ArrayList<Lecture>();

    public void addLecture(Lecture lecture) {
        lectureItems.add(lecture);
    }

    @Override
    public int getCount() {
        return lectureItems.size();
    }

    @Override
    public Object getItem(int position) {
        return lectureItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();
        final Lecture lectureItem = lectureItems.get(position);

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.home_lecturelist, viewGroup, false);

            TextView lectureName = (TextView) view.findViewById(R.id.main_lectureName);
            TextView lectureID = (TextView) view.findViewById(R.id.main_lectureID);

            lectureName.setText(lectureItem.getName());
            lectureID.setText(lectureItem.getId());
        }
        else {
            View newView = new View(context);
            newView = (View) view;
        }

        // Return view object
        return view;
    }
}
