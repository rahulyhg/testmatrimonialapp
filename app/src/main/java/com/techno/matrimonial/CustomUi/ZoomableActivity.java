package com.techno.matrimonial.CustomUi;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.techno.matrimonial.R;


/**
 * Created by arbaz on 27/8/16.
 */
public class ZoomableActivity extends Activity {

    public static final String KEY_TITLE = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Uri data = getIntent().getData();
        if (null == data) {
            throw new IllegalArgumentException("No data to display");
        }

        /*String title = getIntent().getStringExtra(KEY_TITLE);
        if (title != null) {
            setTitle(title);
        }
*/


        setContentView(R.layout.custom_zoom_img);
        this.setFinishOnTouchOutside(false);

        ZoomableDraweeView view = (ZoomableDraweeView) findViewById(R.id.zoomable);
        ImageView img_cross = (ImageView) findViewById(R.id.img_cross);
        img_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        DraweeController ctrl = Fresco.newDraweeControllerBuilder().setUri(
                data).setTapToRetryEnabled(true).build();
        GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(getResources())
                .setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER)
                .setProgressBarImage(new ProgressBarDrawable())
                .build();
        view.setController(ctrl);
        view.setHierarchy(hierarchy);
    }


}