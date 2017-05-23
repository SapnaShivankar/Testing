package com.appxbuild.newstu;


        import android.app.Activity;
        import android.app.ProgressDialog;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Toast;

        import com.androidquery.AQuery;

public class MainActivity extends Activity {
    // AQuery object
    private AQuery aq;
    // Progress Dialog bar object
    ProgressDialog prgDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instantiate AQuery object
        aq = new AQuery(this);
        // Simple Image Loading
        aq.id(R.id.simpleLoadBtn).text("Simple Image Load").clicked(this, "loadImageFromInternet");
        // Image loading with progress bar
        aq.id(R.id.loadProgressBtn).text("Load Image with progress bar").clicked(this, "loadImageFromInternetWithProgressBar");
        // Image loading with Progress Dialog Bar
        aq.id(R.id.loadProgressDialogBtn).text("Load Image with progress dialog bar").clicked(this, "loadImageFromInternetWithProgressDialogBar");
        // Image loading with Fading effect
        aq.id(R.id.loadEffectBtn).text("Load Image with Effect").clicked(this, "loadImageWithFadeInEffect");
    }

    // Call back method for Button - R.id.simpleLoadBtn click
    public void loadImageFromInternet(View image) {
        Toast.makeText(aq.getContext(), "Download initiated...",Toast.LENGTH_SHORT).show();
        aq.id(R.id.simpleLoadImg).image("http://programmerguru.com/android-tutorial/wp-content/uploads/2014/01/asynctask_thumb.png",false,false);
    }

    // Call back method for Button - R.id.loadProgressBtn click
    public void loadImageFromInternetWithProgressBar(View image) {
        Toast.makeText(aq.getContext(), "Download initiated...",Toast.LENGTH_SHORT).show();
        // Display progress bar by invoking progress method
        aq.id(R.id.loadProgressImg).progress(R.id.progress).image("http://programmerguru.com/android-tutorial/wp-content/uploads/2014/01/why_aysnctask.png",false,false);
    }

    // Call back method for Button - R.id.loadProgressDialogBtn click
    public void loadImageFromInternetWithProgressDialogBar(View image) {
        prgDialog = new ProgressDialog(this);
        prgDialog.setMessage("Downloading Image from Internet. Please wait...");
        prgDialog.setIndeterminate(false);
        prgDialog.setMax(100);
        prgDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        prgDialog.setCancelable(false);
        Toast.makeText(aq.getContext(), "Download initiated...",Toast.LENGTH_SHORT).show();
        // Display Progress Dialog Bar by invoking progress method
        aq.id(R.id.loadProgressDialogImg).progress(prgDialog).image("http://programmerguru.com/android-tutorial/wp-content/uploads/2012/08/full_screen.png",false,false);
    }

    // Call back method for Button - R.id.loadEffectBtn click
    public void loadImageWithFadeInEffect(View image) {
        String imageUrl = "http://programmerguru.com/android-tutorial/wp-content/uploads/2012/07/intent.png";
        Toast.makeText(aq.getContext(), "Download initiated...",Toast.LENGTH_SHORT).show();
        // Load image with fading effect
        aq.id(R.id.loadEffectImg).image(imageUrl, true, true, 0, 0, null, AQuery.FADE_IN);
    }
}