package com.example.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class SynthesizerActivity extends AppCompatActivity implements View.OnClickListener{



    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonGs;
    private Button buttonG;
    private Button buttonFs;
    private Button buttonhighA;
    private Button buttonhighBb;
    private Button buttonhighB;
    private Button buttonhighC;
    private Button buttonhighCs;
    private Button buttonhighD;
    private Button buttonhighDs;
    private Button buttonhighE;
    private Button buttonScale;
    private Button buttonAlexa;
    private Button buttonMChannel;
    private Button buttonEScale;
    private SoundPool soundPool;
    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteDs;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteGs;
    private int noteG;
    private int notehighA;
    private int notehighBb;
    private int notehighB;
    private int notehighC;
    private int notehighCs;
    private int notehighD;
    private int notehighDs;
    private int notehighE;
    private int notehighF;
    private int notehighFs;
    private Map<Integer,Integer> noteMap;


    public static final float DEFAULT_VOLUME = 1.0f;
    public static final float DEFAULT_RATE= 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final int WHOLE_NOTE = 1000;
    public static final int Q_NOTE = 250;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);

        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
    }

    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        // in a map, you store a key:value pair
        // the key is the button Id, the value is the noteID
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_bb, noteBb);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_cs, noteCs);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_ds, noteDs);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_fs, noteFs);
        noteMap.put(R.id.button_synth_g, noteG);
        noteMap.put(R.id.button_synth_gs, noteGs);
        noteMap.put(R.id.button_synth_higha, notehighA);
        noteMap.put(R.id.button_synth_highBb, notehighBb);
        noteMap.put(R.id.button_synth_highb, notehighB);
        noteMap.put(R.id.button_synth_highC, notehighC);
        noteMap.put(R.id.button_synth_highcs, notehighCs);
        noteMap.put(R.id.button_synth_highd, notehighD);
        noteMap.put(R.id.button_synth_highds, notehighDs);
        noteMap.put(R.id.button_synth_highe, notehighE);

    }

    private void initializeSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        noteA = soundPool.load(this,R.raw.scalea,1);
        noteBb = soundPool.load(this,R.raw.scalebb,1);
        noteB = soundPool.load(this,R.raw.scaleb,1);
        noteC = soundPool.load(this,R.raw.scalec,1);
        noteCs = soundPool.load(this,R.raw.scalecs,1);
        noteD = soundPool.load(this,R.raw.scaled,1);
        noteDs = soundPool.load(this,R.raw.scaleds,1);
        noteE = soundPool.load(this,R.raw.scalee,1);
        noteF = soundPool.load(this,R.raw.scalef,1);
        noteGs = soundPool.load(this,R.raw.scalegs,1);
        noteG = soundPool.load(this,R.raw.scaleg,1);
        noteFs = soundPool.load(this,R.raw.scalefs,1);
        notehighA = soundPool.load(this,R.raw.scalehigha,1);
        notehighBb = soundPool.load(this,R.raw.scalehighbb,1);
        notehighB = soundPool.load(this,R.raw.scalehighb,1);
        notehighC = soundPool.load(this,R.raw.scalehighc,1);
        notehighCs = soundPool.load(this,R.raw.scalehighcs,1);
        notehighD = soundPool.load(this,R.raw.scalehighd,1);
        notehighDs = soundPool.load(this,R.raw.scalehighds,1);
        notehighE = soundPool.load(this,R.raw.scalehighe,1);
        notehighF = soundPool.load(this,R.raw.scalehighf,1);
        notehighFs = soundPool.load(this,R.raw.scalehighfs,1);
    }

    private void setListeners() {

        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCs.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDs.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFs.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGs.setOnClickListener(noteListener);
        buttonhighA.setOnClickListener(noteListener);
        buttonhighBb.setOnClickListener(noteListener);
        buttonhighB.setOnClickListener(noteListener);
        buttonhighC.setOnClickListener(noteListener);
        buttonhighCs.setOnClickListener(noteListener);
        buttonhighD.setOnClickListener(noteListener);
        buttonhighDs.setOnClickListener(noteListener);
        buttonhighE.setOnClickListener(noteListener);
        buttonEScale.setOnClickListener(this);
        buttonScale.setOnClickListener(this);
        buttonAlexa.setOnClickListener(this);
        buttonMChannel.setOnClickListener(this);
    }

    private void wireWidgets() {

        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonB = findViewById(R.id.button_synth_b);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCs = findViewById(R.id.button_synth_cs);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDs = findViewById(R.id.button_synth_ds);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFs = findViewById(R.id.button_synth_fs);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGs = findViewById(R.id.button_synth_gs);
        buttonhighA= findViewById(R.id.button_synth_higha);
        buttonhighBb = findViewById(R.id.button_synth_highBb);
        buttonhighB = findViewById(R.id.button_synth_highb);
        buttonhighC = findViewById(R.id.button_synth_highC);
        buttonhighCs = findViewById(R.id.button_synth_highcs);
        buttonhighD = findViewById(R.id.button_synth_highd);
        buttonhighDs = findViewById(R.id.button_synth_highds);
        buttonhighE = findViewById(R.id.button_synth_highe);
        buttonScale = findViewById(R.id.button_synth_scale);
        buttonAlexa = findViewById(R.id.button_synth_alexa);
        buttonEScale = findViewById(R.id.button_synth_escale);
        buttonMChannel = findViewById(R.id.button_synth_mchannel);
    }

    @Override
    public void onClick(View view) {
        // one method to handle the clicks of all the buttons
        // but don't forget to tell the buttons who is doing the listening
        switch(view.getId()) {
//
//
            case R.id.button_synth_scale:
                 playScale();
                 break;
            case R.id.button_synth_escale:
                playEScale();
                break;
            case R.id.button_synth_alexa:
                playAlexa();
                break;
            case R.id.button_synth_mchannel:
                playchannel();
                break;
        }
    }

    private void playchannel() {

        Song mchannel = new Song();
        mchannel.add(new Note(noteFs,600));
        mchannel.add(new Note(notehighA,300));
        mchannel.add(new Note(notehighCs,600));
        mchannel.add(new Note(notehighA,600));
        mchannel.add(new Note(noteFs,300));
        mchannel.add(new Note(noteD,300));
        mchannel.add(new Note(noteD,300));
        mchannel.add(new Note(noteD,1500));
        mchannel.add(new Note(noteCs,300));
        mchannel.add(new Note(noteD,300));
        mchannel.add(new Note(noteFs,300));
        mchannel.add(new Note(notehighA,300));
        mchannel.add(new Note(notehighCs,600));
        mchannel.add(new Note(notehighA,600));
        mchannel.add(new Note(noteFs,300));
        mchannel.add(new Note(notehighE,900));
        mchannel.add(new Note(notehighDs,300));
        mchannel.add(new Note(notehighD,1200));
        mchannel.add(new Note(noteGs,600));
        mchannel.add(new Note(notehighCs,300));
        mchannel.add(new Note(noteFs,600));
        mchannel.add(new Note(notehighCs,600));
        mchannel.add(new Note(noteGs,600));
        mchannel.add(new Note(notehighCs,600));
        mchannel.add(new Note(noteG,300));
        mchannel.add(new Note(noteFs,600));
        mchannel.add(new Note(noteE,600));
        mchannel.add(new Note(noteC,300));
        mchannel.add(new Note(noteC,300));
        mchannel.add(new Note(noteC,1200));
        mchannel.add(new Note(noteC,300));
        mchannel.add(new Note(noteC,300));
        mchannel.add(new Note(noteC,1200));
        mchannel.add(new Note(noteDs,600));
        mchannel.add(new Note(noteD,600));
        mchannel.add(new Note(noteCs,600));
        mchannel.add(new Note(notehighA,300));
        mchannel.add(new Note(notehighCs,600));
        mchannel.add(new Note(notehighA,600));
        mchannel.add(new Note(noteFs,300));
        mchannel.add(new Note(noteD,300));
        mchannel.add(new Note(noteD,300));
        mchannel.add(new Note(noteD,600));
        mchannel.add(new Note(notehighE,600));
        mchannel.add(new Note(notehighE,600));
        mchannel.add(new Note(noteE,900));
        mchannel.add(new Note(noteFs,300));
        mchannel.add(new Note(notehighA,300));
        mchannel.add(new Note(notehighCs,600));
        mchannel.add(new Note(notehighA,600));
        mchannel.add(new Note(noteFs,300));
        mchannel.add(new Note(notehighE,1200));
        mchannel.add(new Note(notehighD,1200));





        playSong(mchannel);
    }

    private void playEScale() {
        playNote(noteE);
        delay(WHOLE_NOTE);
        playNote(noteFs);
        delay(WHOLE_NOTE);
        playNote(noteG);
        delay(WHOLE_NOTE);
        playNote(notehighA);
        delay(WHOLE_NOTE);
        playNote(notehighB);
        delay(WHOLE_NOTE);
        playNote(notehighCs);
        delay(WHOLE_NOTE);
        playNote(notehighD);
        delay(WHOLE_NOTE);
        playNote(notehighE);

    }

    private void playAlexa() {
        Song alexa = new Song();




        alexa.add(new Note(noteD,133));
        alexa.add(new Note(noteFs,133));
        alexa.add(new Note(notehighB,133));
        alexa.add(new Note(notehighD,100));
        alexa.add(new Note(notehighCs,100));
        alexa.add(new Note(notehighB,100));
        alexa.add(new Note(notehighBb,100));
        alexa.add(new Note(notehighB,1600));


        alexa.add(new Note(notehighB, 400)); //intro
        alexa.add(new Note(notehighCs, 400));
        alexa.add(new Note(notehighD, 400));
        alexa.add(new Note(notehighE, 400));
        alexa.add(new Note(notehighFs, 400));
        alexa.add(new Note(notehighD, 400));
        alexa.add(new Note(notehighFs, 400));
        alexa.add(new Note(notehighD, 400));
        alexa.add(new Note(notehighFs,1600));
        alexa.add(new Note(noteFs));
        alexa.add(new Note(notehighD,500));
        alexa.add(new Note(noteE));
        alexa.add(new Note(notehighCs,500));
        alexa.add(new Note(noteD));
        alexa.add(new Note(notehighB,800)); //start off verse
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighCs));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighE,250));
        alexa.add(new Note(notehighD,250));
        alexa.add(new Note(notehighCs,250));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(noteG,600));
        alexa.add(new Note(notehighD,600));
        alexa.add(new Note(notehighD,800));
        alexa.add(new Note(notehighD,400));
        alexa.add(new Note(notehighA,400));
        alexa.add(new Note(notehighD,400));
        alexa.add(new Note(notehighA,400));
        alexa.add(new Note(notehighD,400));
        alexa.add(new Note(notehighA,400));
        alexa.add(new Note(notehighD,400));
        alexa.add(new Note(notehighE));
        alexa.add(new Note(notehighCs,750));
        alexa.add(new Note(notehighA,1000));
        alexa.add(new Note(notehighB,1000)); //verse 2
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighCs));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighE,250));
        alexa.add(new Note(notehighD,250));
        alexa.add(new Note(notehighCs,250));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(noteG,600));
        alexa.add(new Note(notehighD,400));
        alexa.add(new Note(notehighD,600));
        alexa.add(new Note(notehighD,400));
        alexa.add(new Note(notehighA,400));
        alexa.add(new Note(notehighD,400));
        alexa.add(new Note(notehighA,400));
        alexa.add(new Note(notehighD,400));
        alexa.add(new Note(notehighA,400));
        alexa.add(new Note(notehighD,400));
        alexa.add(new Note(notehighE));
        alexa.add(new Note(notehighCs,750));
        alexa.add(new Note(notehighA,1000));
        alexa.add(new Note(notehighB,1000));//pre-chorus
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighCs));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighCs));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighCs));
        alexa.add(new Note(notehighD,350));
        alexa.add(new Note(notehighCs));
        alexa.add(new Note(notehighB,800));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighCs));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighCs));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighCs));
        alexa.add(new Note(notehighD,300));
        alexa.add(new Note(notehighE));
        alexa.add(new Note(notehighA,1000));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighD,300));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighE));
        alexa.add(new Note(notehighE,400));
        alexa.add(new Note(notehighCs,1200));
        alexa.add(new Note(notehighD,800));// Despacito
        alexa.add(new Note(notehighCs,800));
        alexa.add(new Note(notehighB,400));
        alexa.add(new Note(noteFs,400));
        alexa.add(new Note(noteFs));
        alexa.add(new Note(noteFs));
        alexa.add(new Note(noteFs));
        alexa.add(new Note(noteFs));
        alexa.add(new Note(noteFs));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighB,400));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighB,400));
        alexa.add(new Note(noteG,600));
        alexa.add(new Note(noteG));
        alexa.add(new Note(noteG));
        alexa.add(new Note(noteG));
        alexa.add(new Note(noteG));
        alexa.add(new Note(noteG));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighB,400));
        alexa.add(new Note(notehighCs));
        alexa.add(new Note(notehighD,400));
        alexa.add(new Note(notehighA,600));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighE,400));
        alexa.add(new Note(notehighE,600));
        alexa.add(new Note(notehighCs,1200));
        alexa.add(new Note(notehighD,800));
        alexa.add(new Note(notehighCs,800));
        alexa.add(new Note(notehighB,400));
        alexa.add(new Note(noteFs,400));
        alexa.add(new Note(noteFs));
        alexa.add(new Note(noteFs));
        alexa.add(new Note(noteFs));
        alexa.add(new Note(noteFs));
        alexa.add(new Note(noteFs));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighB,400));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighB,400));
        alexa.add(new Note(noteG,600));
        alexa.add(new Note(noteG));
        alexa.add(new Note(noteG));
        alexa.add(new Note(noteG));
        alexa.add(new Note(noteG));
        alexa.add(new Note(noteG));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighB));
        alexa.add(new Note(notehighB,400));
        alexa.add(new Note(notehighCs));
        alexa.add(new Note(notehighD,400));
        alexa.add(new Note(notehighA,600));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighA));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighD));
        alexa.add(new Note(notehighE,400));
        alexa.add(new Note(notehighE,600));
        alexa.add(new Note(notehighCs,1200));







        playSong(alexa);


    }

    private void playScale() {
        //play all the notes in a scale
        Song scale = new Song();


        scale.add(new Note(noteA));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteB));
        scale.add(new Note(noteC));


            playSong(scale);


    }

    private void playSong(Song scale) {
        for(Note note : scale.getNotes()) {
            playNote(note);
            delay(note.getDelay());
        }
    }

    private void delay(int duration) {
        try {
            Thread.sleep(duration);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void playNote(int note, int loop) {
        soundPool.play(note, DEFAULT_VOLUME,DEFAULT_VOLUME,DEFAULT_PRIORITY,loop ,DEFAULT_RATE);

    }
    private void playNote(int note){
        playNote(note, 0 );
    }
    private void playNote(Note note){
        playNote(note.getNoteId(),0);
    }

    //make an inner class to handle the button clicks
    // for the individual notes
    private class KeyboardNoteListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            // get the id of the button that was clicked
            int id = view.getId();
            // use the map to figure out what note to play
            int note = noteMap.get(id);
            // play the note
            playNote(note);
        }
    }


}
