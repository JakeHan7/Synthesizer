package com.example.synthesizer;

public class Note {
    private int noteId;
    private int delay;
    public static final int WHOLE_NOTE = 200;

    public Note(int noteId) {
        this.noteId = noteId;
        this.delay = WHOLE_NOTE;
    }

    public Note(int noteId, int delay) {
        this.noteId = noteId;
        this.delay = delay;
    }

    public int getNoteId() {
        return noteId;
    }

    public int getDelay() {
        return delay;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", delay=" + delay +
                '}';
    }
}
