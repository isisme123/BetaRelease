package com.example.gofishgui.fish;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FishHand extends LinearLayout implements View.OnClickListener {
    private Context c;
    private ImageView[] pc;// image views for human cards
    private Button[] b;
    private Button lastClickedButton;

    // FishHand constructor
    public FishHand(Context c, ImageView[] pc, Button[] b) {
        super(c);
        this.c = c;
        this.pc = pc;
        this.b = b;
        for (int i = 0; i < pc.length; i++) {
            pc[i].setOnClickListener(this);
            b[i].setOnClickListener(this);
            b[i].setVisibility(INVISIBLE);
        }
        setOnClickListener(this);
    }

    // OnClickListener method
    @Override
    public void onClick(View v) {
        if (v instanceof ImageView) { // if card is clicked
            for (int i = 0; i < pc.length; i++) {
                if (v == pc[i]) {
                    b[i].setVisibility(VISIBLE);
                    lastClickedButton = b[i];
                } else {
                    b[i].setVisibility(INVISIBLE);
                }
            }
        } else if (v instanceof Button) {
            for (int i = 0; i < b.length; i++) {
                if (v == b[i]) {
                    // ASK FOR CARD METHOD
                }
            }
            lastClickedButton.setVisibility(INVISIBLE);
            lastClickedButton = null;
        } else { // if card is not clicked
            for (int i = 0; i < b.length; i++) {
                b[i].setVisibility(INVISIBLE);
            }
            if (lastClickedButton != null) {
                lastClickedButton.setVisibility(INVISIBLE);
                lastClickedButton = null;
            }
        }
    }
}




