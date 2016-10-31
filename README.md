# BaseItemLayout

#简介

一个通用的Item布局。

#效果图

![这里写图片描述](https://github.com/maimingliang/BaseItemLayout/blob/master/image2.png)



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
         app:text_size  = "15"
         app:text_color = "@color/gray_333333"
         app:icon_margin_left = "10"
         app:icon_text_margin = "10"
         app:arrow_margin_right = "10"
         app:item_height = "50"
         app:line_color = "@color/line_d6d6d6"
         >

     </com.maiml.library.BaseItemLayout>

```

3. 代码中调用

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
              .setArrowResId(R.drawable.img_find_arrow) // 右边的箭头
              .setArrowIsShow(true) //是否显示右边的箭头
              .setItemMarginTop(10)  //设置 每一个item 自己 margin
              .setItemMarginTop(0,0) // 设置 position 下的item 的 margin
              .setIconHeight(24)    // icon 的高度
              .setIconWidth(24)      // icon 的宽度
             .create();



```

4. 设置监听事件

```code

    layout.setOnBaseItemClick(new BaseItemLayout.OnBaseItemClick() {
            @Override
            public void onItemClick(int position) {
                Log.e(TAG,"----- position = " + position);
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


#参数图解

![这里写图片描述](https://github.com/maimingliang/BaseItemLayout/blob/master/image3.png)


#关于我

[简书maimingliang](http://www.jianshu.com/users/141bda5f1c5c/latest_articles)



#最后


如果觉得对你有用的话，点一下右上的星星赞一下吧!
