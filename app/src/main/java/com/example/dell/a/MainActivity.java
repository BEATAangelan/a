package com.example.dell.a;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private SimpleDraweeView circular_bead,icon_bead,icon_scale,icon_step,icon_gif,icon_cecha;
    private Button button_round,button_circle,button_scale,button_step,button_gif,button_cache;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        findViewById(R.id.button_round).setOnClickListener(this);
        findViewById(R.id.button_circle).setOnClickListener(this);
        findViewById(R.id.button_scale).setOnClickListener(this);
        findViewById(R.id.button_step).setOnClickListener(this);
        findViewById(R.id.button_gif).setOnClickListener(this);
        findViewById(R.id.button_cache).setOnClickListener(this);
    }
    /*
     *初始化控件
     */
    private void initView(){
        circular_bead = findViewById(R.id.circular_bead);
        icon_bead = findViewById(R.id.icon_bead);
        icon_scale = findViewById(R.id.icon_scale);
        icon_step = findViewById(R.id.icon_step);
        icon_gif = findViewById(R.id.icon_gif);
        icon_cecha = findViewById(R.id.icon_cecha);
    }
    /*
     *加载图片圆角
     */
    private void circular(){
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this);
        Uri parse = Uri.parse("http://img4.duitang.com/uploads/item/201407/23/20140723080415_GW4A3.thumb.700_0.jpeg");
        circular_bead.setImageURI(parse);
    }
    /*
     *加载图片圆形
     */
    private void circ(){
        Uri parse = Uri.parse("http://img4.duitang.com/uploads/item/201407/23/20140723080415_GW4A3.thumb.700_0.jpeg");
        icon_bead.setImageURI(parse);
    }
    /*
     *加载图片比例
     */
    private void scale(){
        Uri parse = Uri.parse("http://img4.duitang.com/uploads/item/201407/23/20140723080415_GW4A3.thumb.700_0.jpeg");
        icon_scale.setImageURI(parse);
    }
    /*
     *加载图片渐进式
     */
    private void step(){
        Uri parse = Uri.parse("http://img4.duitang.com/uploads/item/201407/23/20140723080415_GW4A3.thumb.700_0.jpeg");
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                //图片地址
                .setUri(parse)
                .setAutoPlayAnimations(true)
                //点击重新加载时 可以重新加载4 次
                .setTapToRetryEnabled(true)
                .build();

        GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(getResources())
                .setFadeDuration(5000)
                .build();
        icon_step.setHierarchy(hierarchy);
        icon_step.setController(controller);
    }
    /*
     *加载动图
     */
    private void gif(){
        Uri parse = Uri.parse("https://img3.duitang.com/uploads/item/201605/14/20160514165650_RHr3n.gif");
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                //图片地址
                .setUri(parse)
                //播放gif 图片
                .setAutoPlayAnimations(true)
                //点击重新加载时 可以重新加载4 次
                .setTapToRetryEnabled(true)
                .build();

        icon_gif.setController(controller);
    }
    /*
     *缓存
     */
    private void cache(){
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryName("images")
                .setBaseDirectoryPath(Environment.getExternalStorageDirectory())
                .build();
        //设置磁盘缓存的配置生成文件
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();
    }
    /*
     *点击事件
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.button_round:
                circular();
                circular_bead.setVisibility(View.VISIBLE);
                icon_bead.setVisibility(View.INVISIBLE);
                icon_scale.setVisibility(View.INVISIBLE);
                icon_step.setVisibility(View.INVISIBLE);
                icon_gif.setVisibility(View.INVISIBLE);
                icon_cecha.setVisibility(View.INVISIBLE);
                break;
            case R.id.button_circle:
                circ();
                circular_bead.setVisibility(View.INVISIBLE);
                icon_bead.setVisibility(View.VISIBLE);
                icon_scale.setVisibility(View.INVISIBLE);
                icon_step.setVisibility(View.INVISIBLE);
                icon_gif.setVisibility(View.INVISIBLE);
                icon_cecha.setVisibility(View.INVISIBLE);
                break;
            case R.id.button_scale:
                scale();
                circular_bead.setVisibility(View.INVISIBLE);
                icon_bead.setVisibility(View.INVISIBLE);
                icon_scale.setVisibility(View.VISIBLE);
                icon_step.setVisibility(View.INVISIBLE);
                icon_gif.setVisibility(View.INVISIBLE);
                icon_cecha.setVisibility(View.INVISIBLE);
                break;
            case R.id.button_step:
                step();
                circular_bead.setVisibility(View.INVISIBLE);
                icon_bead.setVisibility(View.INVISIBLE);
                icon_scale.setVisibility(View.INVISIBLE);
                icon_step.setVisibility(View.VISIBLE);
                icon_gif.setVisibility(View.INVISIBLE);
                icon_cecha.setVisibility(View.INVISIBLE);
                break;
            case R.id.button_gif:
                gif();
                circular_bead.setVisibility(View.INVISIBLE);
                icon_bead.setVisibility(View.INVISIBLE);
                icon_scale.setVisibility(View.INVISIBLE);
                icon_step.setVisibility(View.INVISIBLE);
                icon_gif.setVisibility(View.VISIBLE);
                icon_cecha.setVisibility(View.INVISIBLE);
            case R.id.button_cache:
                cache();
                circular_bead.setVisibility(View.INVISIBLE);
                icon_bead.setVisibility(View.INVISIBLE);
                icon_scale.setVisibility(View.INVISIBLE);
                icon_step.setVisibility(View.INVISIBLE);
                icon_gif.setVisibility(View.INVISIBLE);
                icon_cecha.setVisibility(View.VISIBLE);
        }
    }
}
