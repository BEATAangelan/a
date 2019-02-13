package com.example.njx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.button_one)
    Button button_one;
    @BindView(R.id.button_two)
    Button button_two;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
    }
    @OnClick(R.id.button_one)
    public void one(View v){
        DraweeViewAnnotation draweeViewAnnotation = new DraweeViewAnnotation();
        Class<DraweeViewAnnotation> c = DraweeViewAnnotation.class;
        try {
            Method method = c.getMethod("sha", new Class[]{});
            if (method.isAnnotationPresent(Annotation.class)) {
                Annotation annotation = method.getAnnotation(Annotation.class);
                try {
                    method.invoke(draweeViewAnnotation, new Object[]{});
                    Toast.makeText(MainActivity.this,annotation.name(), Toast.LENGTH_SHORT).show();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    @OnClick(R.id.button_two)
    public void two(View v){
        ArrayList<String> list = new ArrayList<String>();
        list.add("哈哈");
        //获得集合对象的Class类
        Class cl = list.getClass();
        //从集合Class类中获取add()方法 参数为object
        Method method = null;
        try {
            method = cl.getMethod("add", Object.class);
            //方法唤醒并调用 传入集合对象和需要存储的元素
            method.invoke(list, 123);
            method.invoke(list, 456);
            method.invoke(list, 789);
            Toast.makeText(MainActivity.this,list+"", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
