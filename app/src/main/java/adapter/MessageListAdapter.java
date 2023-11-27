package adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.se.blueboard.MainActivity;
import com.se.blueboard.MessageSendPage;
import com.se.blueboard.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Message;
import utils.Utils;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.MyViewHolder> {
    private Context mContext;
    private List<Message> mDataset = new ArrayList<>();
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView sender, subject, date, content;
        public ImageView blueCircle;

        public MyViewHolder(View v) {
            super(v);
            sender = v.findViewById(R.id.Sender);
            subject = v.findViewById(R.id.Subject);
            date = v.findViewById(R.id.Date);
            content = v.findViewById(R.id.Content);
            blueCircle = v.findViewById(R.id.Blue_Circle);

            v.setOnClickListener(view -> {
                Utils.gotoPage(mContext, MessageSendPage.class);
            });
        }
    }
    // 배열 데이터를 받는 생성자
    public MessageListAdapter(Context myContext, List<Message> myDataset) {
        mContext = myContext;
        mDataset = myDataset;
    }

    // 새로운 뷰 생성
    @Override
    public MessageListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 뷰 생성
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mail_list, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // 뷰 내용 수정
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // 현재 포지션에 해당하는 데이타 값을 가져옴
        // 해당 값을 뷰에 적용
        SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yy");
        Message myMessage = mDataset.get(position);

        holder.sender.setText(myMessage.getSenderId());
        holder.subject.setText(myMessage.getTitle());
        holder.date.setText(newFormat.format(myMessage.getDate()));
        holder.content.setText(myMessage.getContent());
        if (myMessage.getIsRead() == true || myMessage.getSenderId().equals(MainActivity.loginUser.getId()))
            holder.blueCircle.setVisibility(View.INVISIBLE);
        else
            holder.blueCircle.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
