package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.se.blueboard.R;
import com.se.blueboard.UploadContentPage;

import java.util.ArrayList;

import model.LearningStatus;
import model.LectureContent;
import utils.Utils;

public class AttendanceListAdapter extends BaseAdapter {
    ArrayList<LectureContent> lectureContentsList = new ArrayList<>();
    ArrayList<LearningStatus> learningStatusList = new ArrayList<>();

    public AttendanceListAdapter(ArrayList<LectureContent> lectureContentsList, ArrayList<LearningStatus> learningStatusList) {
        this.lectureContentsList = lectureContentsList;
        this.learningStatusList = learningStatusList;
    }

    @Override
    public int getCount() {
        return lectureContentsList.size();
    }

    private LearningStatus getStatus(String id) {
        for (LearningStatus learningStatus: learningStatusList) {
            if (learningStatus.getContentId().equals(id))
                return learningStatus;
        }
        return null;
    }

    @Override
    public Object getItem(int position) {
        return lectureContentsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        final LectureContent lectureContent = lectureContentsList.get(position);

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.attendance_list, parent, false);
        }
        else {
            View newView = new View(context);
            newView = (View) convertView;
        }

        // 강의 이름 설정
        TextView lectureName = (TextView) convertView.findViewById(R.id.attendance_contentName);
        lectureName.setText(lectureContent.getTitle());
        // 강의 출결 설정
        TextView lectureAttendance = (TextView) convertView.findViewById(R.id.attendance_contentAttendance);
        LearningStatus learningStatus = getStatus(lectureContent.getId());
        if (learningStatus == null)
            lectureAttendance.setText("NONE");
        else
            lectureAttendance.setText(learningStatus.getStatus());

        return convertView;
    }
}
