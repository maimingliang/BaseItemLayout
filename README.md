# BaseItemLayout


#更新

对项目进行了重构，详情请看[项目重构](http://www.jianshu.com/users/141bda5f1c5c/latest_articles)

上个图

![类图](https://github.com/maimingliang/BaseItemLayout/blob/master/uml.png)

 
#简介

在工作中经常会遇到下面的一些布局，如图标红处：

<div  align="center">    
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/image1.png" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/image2.png" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/image04.png" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/image05.png" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new10.png" width = "270" height = "480" alt="效果图" align=center />
</div>

 
因此自定义了一个通用的Item布局，只需一行代码就可以根据需要添加任意个item。
 
 

#使用

1. 添加Gradle依赖

    在 build.gradle 的 dependencies 添加

    ```code

    dependencies {

         ...
         //compile 'com.maiml:baseitemlayoutlibrary:1.0.0'//旧版本，如果有使用该版本的，由于新版本改动比较大，强烈建议升级。

         compile 'com.maiml:baseitemlayoutlibrary:2.1.1'

    }

    ```


2. 在布局使用

```code

  <com.maiml.library.BaseItemLayout
         android:id="@+id/layout"
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         app:text_size  = "18"
         app:text_color = "@color/gray_333333"
         app:icon_margin_left = "10"
         app:icon_text_margin = "10"
         app:margin_right = "10"
         app:item_height = "50"
         app:line_color = "@color/line_d6d6d6"
         app:right_text_size = "@color/line_d6d6d6"
         app:right_text_color  = "@color/gray_333333"
         app:right_text_margin = "10"

         >

     </com.maiml.library.BaseItemLayout>

     //其中的参数 按需配置。

```

3. 代码中调用

* 默认（Mode.NORMAL）


```code

 layout = (BaseItemLayout) findViewById(R.id.layout);


 List<String> valueList = new ArrayList<>();

        valueList.add("相册");
        valueList.add("收藏");
        valueList.add("钱包");
        valueList.add("卡包");
        valueList.add("设置");

        List<Integer> resIdList = new ArrayList<>();

        resIdList.add(R.drawable.xc);
        resIdList.add(R.drawable.sc);
        resIdList.add(R.drawable.qb);
        resIdList.add(R.drawable.kb);
        resIdList.add(R.drawable.sz);
        
       ConfigAttrs attrs = new ConfigAttrs(); // 把全部参数的配置，委托给ConfigAttrs类处理。
       
               //参数 使用链式方式配置
               attrs.setValueList(valueList)  // 文字 list
                       .setResIdList(resIdList) // icon list
                       .setIconWidth(24)  //设置icon 的大小
                       .setIconHeight(24)
                       .setItemMode(Mode.NORMAL);
       layout.setConfigAttrs(attrs) 
             .create(); //


```

<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new08.jpg" width = "270" height = "480" alt="效果图" align=center />


* 设置item 与 item 之间的间距

```code

        attrs.setValueList(valueList) // 文字 list
              .setResIdList(resIdList) // icon list
              .setItemMarginTop(10)  //设置 全部item的间距
              .setItemMarginTop(1,20); // 设置 position 下的item 的 间距
             


```


* 设置icon 图标的大小


```code

        attrs.setValueList(valueList) // 文字 list
              .setResIdList(resIdList) // icon list
              .setItemMarginTop(10)  //设置 全部item的间距
              .setItemMarginTop(1,20) // 设置 position 下的item 的 间距
              .setIconHeight(24)    // icon 的高度
              .setIconWidth(24) ;     // icon 的宽度
            


```



* 设置 item 的右边的显示模式（默认什么都不显示）

    1. Mode.TXT  //箭头左边带有文字

  ```code


  List<String> rightTextList = new ArrayList<>();

        rightTextList.add("test1");
        rightTextList.add("test2");
        rightTextList.add("test3");
        rightTextList.add("test4");
        rightTextList.add("test5");


         //参数 使用链式方式配置
        attrs.setValueList(valueList)  // 文字 list
             .setResIdList(resIdList) // icon list
             .setIconWidth(24)  //设置icon 的大小
             .setIconHeight(24)
             .setItemMarginTop(10) //该方法是 设置全部item的间距，还有个重载方法 setItemMarginTop(1,20) // 该方法是 设置 position（某个位置） 下的item 的 间距
             .setItemMode(Mode.TEXT) // 该方法是设置全部Item的模式显示模式  ,还有个重载的方法 setItemMode(1,Mode.BUTTON); //该方法是设置position（某个位置） 下Item的 显示模式
             .setRightText(rightTextList);// 只有在Mode.TXT 才需要设置改值，还有个重载的方法 setRightText(1,"love u");//设置position （某个位置）Mode.TXT 模式下的值。


  ```
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new07.jpg" width = "270" height = "480" alt="效果图" align=center />


   2. Mode.ARROW //箭头

 ```code

                 //参数 使用链式方式配置
                 attrs.setValueList(valueList)  // 文字 list
                         .setResIdList(resIdList) // icon list
                         .setIconWidth(24)  //设置icon 的大小
                         .setIconHeight(24)
                         .setItemMarginTop(10)
                         .setItemMode(Mode.ARROW)
                         .setArrowResId(R.drawable.img_find_arrow)//item 中有设置 Mode.ARROW 模式 就必须得设置该值。
                         .setMarginRight(10);//设置距离右边的间距


  ```
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new06.jpg" width = "270" height = "480" alt="效果图" align=center />


   3. Mode.BUTTON //button

    ```code
 

              //参数 使用链式方式配置
                    attrs.setValueList(valueList)  // 文字 list
                            .setResIdList(resIdList) // icon list
                            .setIconWidth(24)  //设置icon 的大小
                            .setIconHeight(24)
                            .setItemMarginTop(10)
                            .setItemMode(Mode.BOTTON)// 设置显示模式
                            .setTrunResId(R.drawable.img_turn_down)//设置未选中图片
                            .setUpResId(R.drawable.img_up)//设置选中图片
                            .setMarginRight(10);// 设置距离右边的间距



     ```
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new04.jpg" width = "270" height = "480" alt="效果图" align=center />


     
   4. Mode.RED_TXT //带红点
   
    ```code
    List<String> rightTextList = new ArrayList<>();
    
            rightTextList.add("12");
            rightTextList.add("35");
            rightTextList.add("55");
            rightTextList.add("586");
            rightTextList.add("1");
   
              //参数 使用链式方式配置
                   attrs.setValueList(valueList)  // 文字 list
                           .setResIdList(resIdList) // icon list
                           .setIconWidth(24)  //设置icon 的大小
                           .setIconHeight(24)
                           .setItemMarginTop(10)
                           .setItemMode(Mode.RED_TEXT)// 设置显示模式
                           .setRightText(rightTextList)//Mode.RED_TXT 的值必须为数字
                           .setArrowResId(R.drawable.img_find_arrow) //箭头资源
                           .setMarginRight(10)// 设置距离右边的间距
                             ;

   
   
   
        ```
   
   5. Mode.Normal,Mode.ARROW ，Mode.TXT   Mode.BUTTON ，Mode.RED_TXT 混合使用

    ```code

           List<String> rightTextList = new ArrayList<>();

           rightTextList.add("test1");
           rightTextList.add("test2");
           rightTextList.add("test3");
           rightTextList.add("test4");
           rightTextList.add("test5");


             //参数 使用链式方式配置
               attrs.setValueList(valueList)  // 文字 list
                           .setResIdList(resIdList) // icon list
                           .setIconWidth(24)  //设置icon 的大小
                           .setIconHeight(24)
                           .setItemMarginTop(10) //设置 全部item的间距
                           .setItemMarginTop(1,20)// 设置 position 下的item 的 间距
                           .setItemMode(Mode.NORMAL)//设置item 为 Mode.NORMAL 模式
                           .setItemMode(1,Mode.TEXT) //设置第二个item 为 Mode.TEXT 模式
                           .setItemMode(2,Mode.ARROW)//设置第三个item 为 Mode.ARROW 模式
                           .setItemMode(3,Mode.BOTTON)//设置第四个item 为 Mode.BOTTON 模式
                           .setItemMode(4,Mode.RED_TEXT)//设置第五个item 为 Mode.RED_TEXT 模式
                           .setRightText(1,"text1") // 设置第二个Item 的值，Mode.TEXT 模式下必须设置值
                           .setRightText(4,"22") //设置第五个item  Mode.RED_TEXT 模式下必须设置值并且为数字
                           .setArrowResId(R.drawable.img_find_arrow) //设置箭头资源值
                           .setUpResId(R.drawable.img_up) //设置开闭按钮资源值
                           .setTrunResId(R.drawable.img_turn_down)//设置开闭按钮资源值
                           .setMarginRight(10); //设置距右边边距
   


     ```

<div  align="center">
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new10.jpg" width = "270" height = "480" alt="效果图" align=center />

</div>

 
4. 设置监听事件

```code

    layout.setOnBaseItemClick(new BaseItemLayout.OnBaseItemClick() {
            @Override
            public void onItemClick(int position) {
                Log.e(TAG,"----- position = " + position);
            }
        });


     layout.setOnSwitchClickListener(new BaseItemLayout.OnSwitchClickListener() {
                    @Override
                    public void onClick(int position, boolean isCheck) {
                        Log.e(TAG,"-----> position = " + position +" isCheck = " + isCheck);
                    }
                });

```

#参数说明

|name|format|description|
|:---:|:---:|:---:|
| text_size| integer |字体大小
| text_color| color |字体颜色
| icon_margin_left| integer| 图标距离 左边的margin
| icon_text_margin| integer| 文字距离 图标左边的margin
| margin_right| integer|距离右边的margin
| item_height| integer| item的高度
| line_color| color| 线的颜色
| right_text_size| integer|右边字体大小
| right_text_color| color| 右边字体颜色
| right_text_margin| integer| 右边字体与箭头的间距

#参数图解

![这里写图片描述](https://github.com/maimingliang/BaseItemLayout/blob/master/image06.png)


#关于我

[简书maimingliang](http://www.jianshu.com/users/141bda5f1c5c/latest_articles)



#最后

如果遇到问题或者好的建议，请反馈到我的邮箱，maimingliang8#163.com (# 换 @)

如果觉得对你有用的话，点一下Star赞一下吧!
