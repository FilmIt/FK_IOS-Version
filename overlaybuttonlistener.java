package com.app.filmkit.listeners;

import java.util.ArrayList;
import java.util.List;

import com.app.filmkit.EditScreenActivity;
import com.app.filmkit.IntroScreenActivity;
import com.app.filmkit.R;
import com.app.filmkit.R.drawable;
import com.app.filmkit.R.id;
import com.app.filmkit.image.Effect;
import com.app.filmkit.image.Effect.effectName;
import com.app.filmkit.utils.IabHelper;
import com.app.filmkit.utils.IabResult;
import com.app.filmkit.utils.Inventory;
import com.app.filmkit.utils.Purchase;
import com.app.filmkit.utils.SkuDetails;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class OverlayButtonsListener implements OnClickListener {

    //Context context = getApplicationContext();

    CharSequence text = "Comming Soon";
    int duration = Toast.LENGTH_SHORT;

    EditScreenActivity editScreen;
    private RelativeLayout lensflareMenu, bookehMenu, lightleaksMenu, paperMenu, vignetteMenu, vintageMenu, oldStyleMenu;
    static Effect effect;
    SeekBar seekBar;
    TextView titleTextView;
    public IabHelper mHelper;
    private Dialog toast;

    public OverlayButtonsListener(Activity activity) {
        editScreen = (EditScreenActivity) activity;
        effect = editScreen.effect;
        seekBar = editScreen.seekBar;

        titleTextView = editScreen.titleTextView;
        lensflareMenu = (RelativeLayout) editScreen.findViewById(R.id.lenseflare_menu);
        bookehMenu = (RelativeLayout) editScreen.findViewById(R.id.bokeh_menu);
        lightleaksMenu = (RelativeLayout) editScreen.findViewById(R.id.lightleaks_menu);
        paperMenu = (RelativeLayout) editScreen.findViewById(R.id.paper_menu);
        vignetteMenu = (RelativeLayout) editScreen.findViewById(R.id.vignette_menu);
        vintageMenu = (RelativeLayout) editScreen.findViewById(R.id.vintage_menu);

        this.mHelper = ((EditScreenActivity)activity).mHelper; //naughty, must change later

    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {

        // lensflare menu
        case R.id.gleaming_button:
            openSlidebar(lensflareMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Gleaming");
            effect.setEffectToApply(effectName.LensFlare);
            effect.setOverlayName("Gleaming");
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.lf6));
            effect.setOverlayType(effect.getOverlayType().lf6);
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;

        case R.id.eminent_button:
            openSlidebar(lensflareMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Eminent");
            effect.setOverlayName("Eminent");
            effect.setEffectToApply(effectName.LensFlare);
            effect.setOverlayType(effect.getOverlayType().lf3);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.lf3));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));break;

        case R.id.blinding_button:
            openSlidebar(lensflareMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Blinding");
            effect.setOverlayName("Blinding");
            effect.setEffectToApply(effectName.LensFlare);
            effect.setOverlayType(effect.getOverlayType().lf1);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.lf1));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));break;

        case R.id.glint_button:
            openSlidebar(lensflareMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Glint");
            effect.setOverlayName("Glint");
            effect.setEffectToApply(effectName.LensFlare);
            effect.setOverlayType(effect.getOverlayType().lf7);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.lf7));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;

        case R.id.lustrous_button:
            openSlidebar(lensflareMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Lustrous");
            effect.setOverlayName("Lustrous");
            effect.setEffectToApply(effectName.LensFlare);
            effect.setOverlayType(effect.getOverlayType().lf2);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.lf2));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            toast.show();
            break;

        case R.id.sparkle_button:
            /*openSlidebar(lensflareMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Sparkle");
            effect.setOverlayName("Sparkle");
            effect.setEffectToApply(effectName.LensFlare);
            effect.setOverlayType(effect.getOverlayType().lf5);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.lf5));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));*/
            break;
        case R.id.resplendent_button:
            /*openSlidebar(lensflareMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Resplendent");
            effect.setOverlayName("Resplendent");
            effect.setEffectToApply(effectName.LensFlare);
            effect.setOverlayType(effect.getOverlayType().lf4);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.lf4));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));*/
            toast.show();
            break;

        // Vignette menu
        case R.id.sutle_button:
            openSlidebar(vignetteMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Sutle");
            effect.setOverlayName("Sutle");
            effect.setEffectToApply(effectName.Vignette);
            effect.setOverlayType(effect.getOverlayType().vig1);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vig1));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.greengradiant_button:
            openSlidebar(vignetteMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Green Gradient");
            effect.setOverlayName("Green Gradient");
            effect.setEffectToApply(effectName.Vignette);
            effect.setOverlayType(effect.getOverlayType().vig2);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vig2));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.red_Gradient_button:
            openSlidebar(vignetteMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Red Gradient");
            effect.setOverlayName("Red Gradient");
            effect.setEffectToApply(effectName.Vignette);
            effect.setOverlayType(effect.getOverlayType().vig5);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vig5));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.vivid_button:
            openSlidebar(vignetteMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Vivid");
            effect.setOverlayName("Vivid");
            effect.setEffectToApply(effectName.Vignette);
            effect.setOverlayType(effect.getOverlayType().vig4);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vig4));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;

        case R.id.obscure_button:
            /*openSlidebar(vignetteMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Obscure");
            effect.setOverlayName("Obscure");
            effect.setEffectToApply(effectName.Vignette);
            effect.setOverlayType(effect.getOverlayType().vig6);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vig6));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));*/
            toast.show();
            break;

        case R.id.slats_button:
            /*openSlidebar(vignetteMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Slats");
            effect.setOverlayName("Slats");
            effect.setEffectToApply(effectName.Vignette);
            effect.setOverlayType(effect.getOverlayType().vig7);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vig7));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));*/
            toast.show();
            break;

        // Lightleaks menu
        case R.id.old_Film_button:
            openSlidebar(lightleaksMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Old Film");
            effect.setOverlayName("Old Film");
            effect.setEffectToApply(effectName.LightLeaks);
            effect.setOverlayType(effect.getOverlayType().ll9);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.ll9));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.grained_button:
            openSlidebar(lightleaksMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Grained");
            effect.setOverlayName("Grained");
            effect.setEffectToApply(effectName.LightLeaks);
            effect.setOverlayType(effect.getOverlayType().ll1);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.ll1));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.retro_button:
            openSlidebar(lightleaksMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Retro");
            effect.setOverlayName("Retro");
            effect.setEffectToApply(effectName.LightLeaks);
            effect.setOverlayType(effect.getOverlayType().ll5);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.ll5));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.cinematic_button:
            openSlidebar(lightleaksMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Cinematic");
            effect.setOverlayName("Cinematic");
            effect.setEffectToApply(effectName.LightLeaks);
            effect.setOverlayType(effect.getOverlayType().ll3);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.ll3));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.abstract_button:
            openSlidebar(lightleaksMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Abstract");
            effect.setOverlayName("Abstract");
            effect.setEffectToApply(effectName.LightLeaks);
            effect.setOverlayType(effect.getOverlayType().ll2);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.ll2));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;

        case R.id.shadded_button:
            /*openSlidebar(lightleaksMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Shadded");
            effect.setOverlayName("Shadded");
            effect.setEffectToApply(effectName.LightLeaks);
            effect.setOverlayType(effect.getOverlayType().ll6);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.ll6));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));*/
            toast.show();
            break;

        case R.id.triangular_button:
            /*openSlidebar(lightleaksMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Triangular");
            effect.setOverlayName("Triangular");
            effect.setEffectToApply(effectName.LightLeaks);
            effect.setOverlayType(effect.getOverlayType().ll7);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.ll7));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));*/
            toast.show();
            break;

        // Paper
        case R.id.folded_button:
            openSlidebar(paperMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Folded");
            effect.setOverlayName("Folded");
            effect.setEffectToApply(effectName.Paper);
            effect.setOverlayType(effect.getOverlayType().p3);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.p3));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.crumbled_button:
            openSlidebar(paperMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Crumbled");
            effect.setOverlayName("Crumbled");
            effect.setEffectToApply(effectName.Paper);
            effect.setOverlayType(effect.getOverlayType().p5);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.p5));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;

        case R.id.scratchy_button:
            openSlidebar(paperMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Scratchy");
            effect.setOverlayName("Scratchy");
            effect.setEffectToApply(effectName.Paper);
            effect.setOverlayType(effect.getOverlayType().p6);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.p6));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;

        case R.id.old_button:
            openSlidebar(paperMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Old");
            effect.setOverlayName("Old");
            effect.setEffectToApply(effectName.Paper);
            effect.setOverlayType(effect.getOverlayType().p2);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.p2));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;

        case R.id.textured_button:
            openSlidebar(paperMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Textured");
            effect.setOverlayName("Textured");
            effect.setEffectToApply(effectName.Paper);
            effect.setOverlayType(effect.getOverlayType().p4);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.p4));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.grungy_button:
            openSlidebar(paperMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Grungy");
            effect.setOverlayName("Grungy");
            effect.setEffectToApply(effectName.Paper);
            effect.setOverlayType(effect.getOverlayType().o1);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.o1));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.printed_button:
            /*openSlidebar(paperMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Printed");
            effect.setOverlayName("Printed");
            effect.setEffectToApply(effectName.Paper);
            effect.setOverlayType(effect.getOverlayType().o3);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.o3));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));*/
            toast.show();
            break;

        case R.id.antique_button:
            /*openSlidebar(paperMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Antique");
            effect.setOverlayName("Antique");
            effect.setEffectToApply(effectName.Paper);
            effect.setOverlayType(effect.getOverlayType().p11);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.p11));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));*/
            toast.show();
            break;


        // Bookeh
        case R.id.aureate_button:
            /*Log.d("IAB", "Gonna try the aureate effect");
            List<String> skuList = new ArrayList<String>();
            skuList.add("test_aureate");
            mHelper.queryInventoryAsync(true, skuList, mGotInventoryListener);*/
            openSlidebar(bookehMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Aureate");
            effect.setOverlayName("Aureate");
            effect.setEffectToApply(effectName.Bokeh);
            effect.setOverlayType(effect.getOverlayType().b1);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.b1));
            seekBar.setMax(6);
            seekBar.setProgress(seekBar.getMax()/2);
            break;
        case R.id.dappled_button:
            openSlidebar(bookehMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Dappled");
            effect.setOverlayName("Dappled");
            effect.setEffectToApply(effectName.Bokeh);
            effect.setOverlayType(effect.getOverlayType().b51);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.b51));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.incandescent_button:
            openSlidebar(bookehMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Incandescent");
            effect.setOverlayName("Incandescent");
            effect.setEffectToApply(effectName.Bokeh);
            effect.setOverlayType(effect.getOverlayType().b3);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.b3));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.luminescent_button:
            openSlidebar(bookehMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Luminescent");
            effect.setOverlayName("Luminescent");
            effect.setEffectToApply(effectName.Bokeh);
            effect.setOverlayType(effect.getOverlayType().b2);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.b2));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.iridescent_button:
            openSlidebar(bookehMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Iridescent");
            effect.setOverlayName("Iridescent");
            effect.setEffectToApply(effectName.Bokeh);
            effect.setOverlayType(effect.getOverlayType().b4);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.b4));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.monochrome_button:
            /*openSlidebar(bookehMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Monochrome");
            effect.setOverlayName("Monochrome");
            effect.setEffectToApply(effectName.Bokeh);
            effect.setOverlayType(effect.getOverlayType().b7);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.b7));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));*/
            toast.show();
            break;

        case R.id.blurred_button:
            /*openSlidebar(bookehMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Blurred");
            effect.setOverlayName("Blurred");
            effect.setEffectToApply(effectName.Bokeh);
            effect.setOverlayType(effect.getOverlayType().b6);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.b6));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));*/
            toast.show();
            break;

        //Vintage Menu
        case R.id.groovy_button:
            openSlidebar(vintageMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Groovy");
            effect.setOverlayName("Groovy");
            effect.setEffectToApply(effectName.Vintage);
            effect.setOverlayType(effect.getOverlayType().vin2);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vin2));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.artistic_button:
            openSlidebar(vintageMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Artistic");
            effect.setOverlayName("Artistic");
            effect.setEffectToApply(effectName.Vintage);
            effect.setOverlayType(effect.getOverlayType().vin5);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vin5));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.radiant_button:
            openSlidebar(vintageMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Radiant");
            effect.setOverlayName("Radiant");
            effect.setEffectToApply(effectName.Vintage);
            effect.setOverlayType(effect.getOverlayType().vin4);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vin4));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.negative_button:
            openSlidebar(vintageMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Negative");
            effect.setOverlayName("Negative");
            effect.setEffectToApply(effectName.Vintage);
            effect.setOverlayType(effect.getOverlayType().vin6);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vin6));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.spectral_button:
            openSlidebar(vintageMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Spectral");
            effect.setOverlayName("Spectral");
            effect.setEffectToApply(effectName.Vintage);
            effect.setOverlayType(effect.getOverlayType().vin1);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vin1));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;
        case R.id.cryptic_button:
            openSlidebar(vintageMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Cryptic");
            effect.setOverlayName("Cryptic");
            effect.setEffectToApply(effectName.Vintage);
            effect.setOverlayType(effect.getOverlayType().vin3);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vin3));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));
            break;

        case R.id.luxury_button:
            /*openSlidebar(vintageMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Luxury");
            effect.setOverlayName("Luxury");
            effect.setEffectToApply(effectName.Vintage);
            effect.setOverlayType(effect.getOverlayType().vin8);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vin8));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));*/
            toast.show();
            break;

        case R.id.sky_button:
            /*openSlidebar(vintageMenu);
            seekBar.setVisibility(View.VISIBLE);
            titleTextView.setText("Sky");
            effect.setOverlayName("Sky");
            effect.setEffectToApply(effectName.Vintage);
            effect.setOverlayType(effect.getOverlayType().vin7);
            effect.setOverlayImage(BitmapFactory.decodeResource(IntroScreenActivity.res,R.drawable.vin7));
            seekBar.setMax(6);
            seekBar.setProgress((seekBar.getMax()/2));*/
            toast.show();
            break;


        }
    }

    public void openSlidebar(View view) {
        view.setVisibility(View.INVISIBLE);
        editScreen.editing_bar.setVisibility(View.VISIBLE);
        editScreen.bottom_bar.setVisibility(View.INVISIBLE);
    }

    public IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            String TAG = "OverlayButton";
            Log.d(TAG, "Query inventory finished.");

            // Have we been disposed of in the meantime? If so, quit.
            if (mHelper == null) return;

            // Is it a failure?
            if (result.isFailure()) {
                //complain("Failed to query inventory: " + result);
                Log.d(TAG, "Failed to query inventory: " + result);
                return;
            }

            //alert("Result message: " + result.getMessage());

            Log.d(TAG, "Query inventory was successful.");

            /*
             * Check for items we own. Notice that for each purchase, we check
             * the developer payload to see if it's correct! See
             * verifyDeveloperPayload().
             *
             */
            //SkuDetails aureateEffect = inventory.getSkuDetails("test_aureate");


            //verifyDeveloperPayload()
            /*if (aureateEffect != null)
            {
                String message = "Sku: " + aureateEffect.getSku() + "\n";
                message += "Type: " + aureateEffect.getType() + "\n";
                message += "Price: " + aureateEffect.getPrice() + "\n";
                message += "Title: " + aureateEffect.getTitle() + "\n";
                message += "Desc: " + aureateEffect.getDescription();
                //alert("We have an effect that can be purchased -> " + message);

                Purchase aureatePurchase = inventory.getPurchase("test_aureate");
                if (aureatePurchase != null)
                {
                    String purchaseDetails = "Item type: " + aureatePurchase.getItemType();
                    purchaseDetails += "Order id: " + aureatePurchase.getOrderId() + "; ";
                    purchaseDetails += "Package name: " + aureatePurchase.getPackageName() + "; ";
                    purchaseDetails += "Sku: " + aureatePurchase.getSku() + "; ";
                    purchaseDetails += "Purchase time: " + aureatePurchase.getPurchaseTime() + "; ";
                    purchaseDetails += "Purchase state: " + aureatePurchase.getPurchaseState() + "; ";
                    purchaseDetails += "Dev payload: " + aureatePurchase.getDeveloperPayload() + "; ";
                    purchaseDetails += "Token: " + aureatePurchase.getToken() + "; ";
                    purchaseDetails += "Orig json: " + aureatePurchase.getOriginalJson() + "; ";
                    purchaseDetails += "Signature: " + aureatePurchase.getSignature() + "; ";
                    alert("Phew! This effect has already been purchased! -> " + purchaseDetails);

                }
                else
                {
                    alert("Oh no, you gonna have to buy this one, MoFo\n" + message);

                    mHelper.launchPurchaseFlow(editScreen, "test_aureate", 10001,
                               mPurchaseFinishedListener, "aureate-effect-payload");

                }


            }
            else
            {
                alert("Effect details not found in Play, is this really a valid product?");
                Log.d(TAG, "Oh noes, this doesn't exist!");
            }*/




        }
    };

    /*IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            String TAG = "IAB";
            Log.d(TAG, "Purchase finished: " + result + ", purchase: " + purchase);

            // if we were disposed of in the meantime, quit.
            if (mHelper == null) return;

            if (result.isFailure()) {
                alert("Error purchasing: " + result);
                //setWaitScreen(false);
                return;
            }
            /*if (!verifyDeveloperPayload(purchase)) {
                complain("Error purchasing. Authenticity verification failed.");
                setWaitScreen(false);
                return;
            }

            Log.d(TAG, "Purchase successful.");

            if (purchase.getSku().equals("test_aureate"))
            {
                alert("Congratulations, you've purchased this effect");

            }
            else
            {
                alert("What the hell did you purchase? Computer says " + purchase.getSku());

            }


        }
    };*/

    void alert(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(editScreen);
        alert.setMessage(message).setPositiveButton("OK", new DialogInterface.OnClickListener(){
             @Override
             public void onClick(DialogInterface dialog, int which)
             {

             }
             })
             .show();
    }

}
