package com.example.applicationtest;
 //第二项 加载
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    //让菜单显示出来
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);  //通过哪一个资源文件创建菜单 + 菜单项添加到哪一个Menu对象
        return true;
    }

    //让菜单能使用，定义菜单响应事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You Clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout); //给活动加载一个布局


        Button button1 = (Button) findViewById(R.id.button_1);   //返回的view 对象向下转换为button
        //按钮注册监听器
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(FirstActivity.this,"You Clicked button 1",Toast.LENGTH_SHORT).show();
                //上下文   +  显示文本内容 + 显示时长
                //将上面一句换成finish(); 即可销毁活动

                //Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                // 启动活动的上下文 +  要启动的目标活动


                //这里是法2  隐式调用，上面是显式
               // Intent intent = new Intent("com.example.activitytest.ACTION_START"); //然后category 是默认的
                //intent.addCategory("com.example.activitytest.MY_CATEGORY");

                // startActivity(intent);   //此函数执行这个交互intent



                //以上，即在FirstActivity 基础上打开secondActivity

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
    }
}

