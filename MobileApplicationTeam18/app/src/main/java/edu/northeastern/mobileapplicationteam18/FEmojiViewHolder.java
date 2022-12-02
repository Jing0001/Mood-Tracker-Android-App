package edu.northeastern.mobileapplicationteam18;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FEmojiViewHolder extends RecyclerView.ViewHolder {
    private final ImageView receivedEmojiIV;
    private final TextView senderTV;
    private final TextView sendTimeTV;

    public FEmojiViewHolder(@NonNull View itemView) {
        super(itemView);
        this.senderTV = itemView.findViewById(R.id.senderTV);
        this.receivedEmojiIV = itemView.findViewById(R.id.receivedEmojiIV);
        this.sendTimeTV = itemView.findViewById(R.id.sendTimeTV);
    }

    public void bindThisData(Emoji EmojiToBind) {
        int imageResource = getImageResourceById(EmojiToBind.id);
        if (imageResource != -1) {
            receivedEmojiIV.setImageResource(imageResource);
        }
        senderTV.setText(EmojiToBind.fromUser);
        sendTimeTV.setText(EmojiToBind.sendTime);
    }

    private int getImageResourceById(int id) {
        if (id == 1) {
            return R.drawable.hi;
        } else if (id == 2) {
            return R.drawable.bye;
        } else if (id == 3) {
            return R.drawable.alright;
        } else if (id == 4) {
            return R.drawable.here;
        } else if (id == 5) {
            return R.drawable.call;
        } else if (id == 6) {
            return R.drawable.haveaniceday;
        }
        return -1;
    }
}