# BaseItemLayout

#简介

在工作中经常会遇到下面的一些布局，如图标红处：

<div  align="center">    
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/image1.png" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/image2.png" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/image04.png" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/image05.png" width = "270" height = "480" alt="效果图" align=center />

</div>

 
因此自定义了一个通用的Item布局，只需几行代码就可以根据需要添加任意个item。
 




#使用

1. 添加Gradle依赖

    在 build.gradle 的 dependencies 添加

    ```code

    dependencies {

         ...
         compile 'com.maiml:baseitemlayoutlibrary:1.0.0'

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
         app:arrow_margin_right = "10"
         app:item_height = "50"
         app:line_color = "@color/line_d6d6d6"
         app:right_text_size = "@color/line_d6d6d6"
         app:right_text_color  = "@color/gray_333333"
         app:right_text_margin = "10"

         >

     </com.maiml.library.BaseItemLayout>


```

3. 代码中调用

* 默认


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


        layout.setValueList(valueList) // 文字 list
              .setResIdList(resIdList) // icon list
             .create();


```

<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new08.jpg" width = "270" height = "480" alt="效果图" align=center />


* 设置item 与 item 之间的间距

```code

        layout.setValueList(valueList) // 文字 list
              .setResIdList(resIdList) // icon list
              .setItemMarginTop(10)  //设置 全部item的间距
              .setItemMarginTop(1,20) // 设置 position 下的item 的 间距
             .create();


```


* 设置icon 图标的大小


```code

        layout.setValueList(valueList) // 文字 list
              .setResIdList(resIdList) // icon list
              .setItemMarginTop(10)  //设置 全部item的间距
              .setItemMarginTop(1,20) // 设置 position 下的item 的 间距
              .setIconHeight(24)    // icon 的高度
              .setIconWidth(24)      // icon 的宽度
             .create();


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


          layout.setValueList(valueList) // 文字 list
                .setResIdList(resIdList) // icon list
                .setItemMarginTop(10)  //设置 全部item的间距
                .setItemMarginTop(1,20) // 设置 position 下的item 的 间距
                .setIconHeight(24)    // icon 的高度
                .setIconWidth(24)      // icon 的宽度
                .setItemMode(BaseItemLayout.Mode.TXT) // 设置显示模式
                .setItemRightText(rightTextList)  // 只有在Mode.TXT 才需要设置改值

               .create();


  ```
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new07.jpg" width = "270" height = "480" alt="效果图" align=center />


   2. Mode.IMAGE //箭头

 ```code

        List<String> rightTextList = new ArrayList<>();

        rightTextList.add("test1");
        rightTextList.add("test2");
        rightTextList.add("test3");
        rightTextList.add("test4");
        rightTextList.add("test5");


          layout.setValueList(valueList) // 文字 list
                .setResIdList(resIdList) // icon list
                .setItemMarginTop(10)  //设置 全部item的间距
                .setItemMarginTop(1,20) // 设置 position 下的item 的 间距
                .setIconHeight(24)    // icon 的高度
                .setIconWidth(24)      // icon 的宽度
                .setItemMode(BaseItemLayout.Mode.IMAGE) // 设置显示模式

               .create();


  ```
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new06.jpg" width = "270" height = "480" alt="效果图" align=center />


   3. Mode.BUTTON //button

    ```code

           List<String> rightTextList = new ArrayList<>();

           rightTextList.add("test1");
           rightTextList.add("test2");
           rightTextList.add("test3");
           rightTextList.add("test4");
           rightTextList.add("test5");


             layout.setValueList(valueList) // 文字 list
                   .setResIdList(resIdList) // icon list
                   .setItemMarginTop(10)  //设置 全部item的间距
                   .setItemMarginTop(1,20) // 设置 position 下的item 的 间距
                   .setIconHeight(24)    // icon 的高度
                   .setIconWidth(24)      // icon 的宽度
                    .setItemMode(BaseItemLayout.Mode.BUTTON) // 设置显示模式
                   .setTrunResId(R.drawable.img_turn_down)  //设置未选中图片
                   .setUpResId(R.drawable.img_up)           ／/设置选中图片
                  .create();


     ```
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new04.jpg" width = "270" height = "480" alt="效果图" align=center />


   4. Mode.IMAGE 和 Mode.TXT 混合 或 Mode.IMAGE 和 Mode.BUTTON 混合 或 Mode.TXT 和 Mode.BUTTON 混合

    ```code

           List<String> rightTextList = new ArrayList<>();

           rightTextList.add("test1");
           rightTextList.add("test2");
           rightTextList.add("test3");
           rightTextList.add("test4");
           rightTextList.add("test5");


             layout.setValueList(valueList) // 文字 list
                   .setResIdList(resIdList) // icon list
                   .setItemMarginTop(10)  //设置 全部item的间距
                   .setItemMarginTop(1,20) // 设置 position 下的item 的 间距
                   .setIconHeight(24)    // icon 的高度
                   .setIconWidth(24)      // icon 的宽度
                   .setItemMode(BaseItemLayout.Mode.IMAGE) //设置全部item 为 Mode.IMAGE 模式
                   .setItemMode(valueList.size()-2, BaseItemLayout.Mode.TXT,"text1") //改变 倒数第二个位置 模式为 Mode.TXT
                   .setItemMode(valueList.size()-1, BaseItemLayout.Mode.TXT,"text2") //改变 最后一个位置 模式为 Mode.TXT


                   //.setItemMode(BaseItemLayout.Mode.IMAGE)
                   //.setTrunResId(R.drawable.img_turn_down)
                   //.setUpResId(R.drawable.img_up)
                   //.setItemMode(valueList.size()-2, BaseItemLayout.Mode.BUTTON)
                   //.setItemMode(valueList.size()-1, BaseItemLayout.Mode.BUTTON)



                   //.setItemMode(BaseItemLayout.Mode.TXT)
                   //.setItemRightText(rightTextList)  // 只有在Mode.TXT 才需要设置改值
                   //.setTrunResId(R.drawable.img_turn_down)
                   //.setUpResId(R.drawable.img_up)
                   //.setItemMode(valueList.size()-2, BaseItemLayout.Mode.BUTTON)
                   //.setItemMode(valueList.size()-1, BaseItemLayout.Mode.BUTTON)

                   //.setItemMode(BaseItemLayout.Mode.IMAGE)
                    //.setTrunResId(R.drawable.img_turn_down)
                   //.setUpResId(R.drawable.img_up)
                   //.setItemMode(valueList.size()-3, BaseItemLayout.Mode.TXT,"text1") //改变 倒数第二个位置 模式为 Mode.TXT

                   //.setItemMode(valueList.size()-2, BaseItemLayout.Mode.BUTTON)
                   //.setItemMode(valueList.size()-1, BaseItemLayout.Mode.BUTTON)


                   .create();


     ```

<div  align="center">
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new05.jpg" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new03.jpg" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new02.jpg" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/maimingliang/BaseItemLayout/blob/master/new01.jpg" width = "270" height = "480" alt="效果图" align=center />

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
| arrow_margin_right| integer|箭头距离右边的margin
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

如果遇到问题或者好的建议，请反馈到我的邮箱，maimingliang8@163.com

如果觉得对你有用的话，点一下Star赞一下吧!
