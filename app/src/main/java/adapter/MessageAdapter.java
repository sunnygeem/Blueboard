package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.se.blueboard.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.Message;

public class MessageAdapter extends BaseAdapter {

    private List<Message> messageList;
    private LayoutInflater inflater;

    public MessageAdapter(Context context, List<Message> messageList) {
        this.inflater = LayoutInflater.from(context);
        this.messageList = messageList;
    }

    @Override
    public int getCount() {
        return messageList.size();
    }

    @Override
    public Object getItem(int position) {
        return messageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.message_list_item, null);
            holder = new ViewHolder();
            holder.textViewReceiver = convertView.findViewById(R.id.textViewReceiver);
            holder.textViewDate = convertView.findViewById(R.id.textViewDate);
            holder.textViewTitle = convertView.findViewById(R.id.textViewTitle);
            holder.textViewContent = convertView.findViewById(R.id.textViewContent);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Message message = messageList.get(position);

        // Bind data to views
        holder.textViewReceiver.setText(message.getSenderId());  // Change to senderId as there's no receiverId in the provided Message class
        holder.textViewDate.setText(formatDate(message.getDate()));
        holder.textViewTitle.setText(message.getTitle());
        holder.textViewContent.setText(message.getContent());

        return convertView;
    }

    private String formatDate(Date date) {
        // Format the date as needed
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    static class ViewHolder {
        TextView textViewReceiver;
        TextView textViewDate;
        TextView textViewTitle;
        TextView textViewContent;
    }
}
