package edu.northeastern.mobileapplicationteam18;

public class Emoji implements Comparable<Emoji> {
    public int id;
    public String sender;
    public String receiver;
    public String sendTime;

    public Emoji(int id, String sender, String receiver, String sendTime) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.sendTime = sendTime;
    }

    public String getKey() {
        return id + "|" + sender + "|" + receiver + "|" + sendTime;
    }

    @Override
    public int compareTo(Emoji other) {
        return this.sendTime.compareTo(other.sendTime);
    }
}
