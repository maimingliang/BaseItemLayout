package com.maiml.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.maiml.baseitemlayoutlibrary.R;
import com.maiml.library.item.ButtonItem;
import com.maiml.library.config.CommonCons;
import com.maiml.library.config.ConfigAttrs;
import com.maiml.library.item.AbstractItem;
import com.maiml.library.config.Mode;
import com.maiml.library.factory.AbstractItemFactory;
import com.maiml.library.factory.ItemFactory;
import com.maiml.library.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maimingliang on 2016/10/27.
 */

public class BaseItemLayout extends LinearLayout {



    private Context mContext;


    private AbstractItemFactory mFactory;
    private ConfigAttrs mConfigAttrs;

    private List<View> mViewList = new ArrayList<>();
    private int mLineColor;
    private int mTextSize;
    private int mTextColor;
    private int mIconMarginLeft;
    private int mIconTextMargin;
    private int mArrowMarginRight;
    private int mItemHeight;
    private int mRightTextSize;
    private int mRightTextColor;
    private int mRightTextMagin;
    private int mItemBgSelector;


    public BaseItemLayout(Context context) {
        this(context,null);
    }

    public BaseItemLayout(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public BaseItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        initCostomerArrts(context, attrs);
        init(context);
    }

    private void initCostomerArrts(Context context, AttributeSet attrs) {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ItemAttrs);

        mLineColor = a.getColor(R.styleable.ItemAttrs_bil_line_color, CommonCons.DF_LINE_COLOR);
        mTextSize = a.getInt(R.styleable.ItemAttrs_bil_text_size, CommonCons.DF_TEXT_SIZE);
        mTextColor = a.getColor(R.styleable.ItemAttrs_bil_text_color, CommonCons.DF_TEXT_COLOR);
        mIconMarginLeft = a.getInt(R.styleable.ItemAttrs_bil_icon_margin_left, CommonCons.DF_ICON_MARGIN_LEFT);
        mIconTextMargin = a.getInt(R.styleable.ItemAttrs_bil_icon_text_margin, CommonCons.DF_ICON_TEXT_MARGIN);
        mArrowMarginRight = a.getInt(R.styleable.ItemAttrs_bil_margin_right, CommonCons.DF_ARROW_MARGIN_RIGHT);
        mItemHeight = a.getInt(R.styleable.ItemAttrs_bil_item_height, CommonCons.DF_ITEM_HEIGHT);
        mRightTextSize = a.getInt(R.styleable.ItemAttrs_bil_right_text_size, CommonCons.DF_RIGHT_TEXT_SIZE);
        mRightTextColor = a.getColor(R.styleable.ItemAttrs_bil_right_text_color, CommonCons.DF_RIGHT_TEXT_COLOR);
        mRightTextMagin = a.getInt(R.styleable.ItemAttrs_bil_right_text_margin, CommonCons.DF_RIGHT_TEXT_MAGIN);
        mItemBgSelector = a.getInt(R.styleable.ItemAttrs_bil_item_bg_color, CommonCons.ITEM_BG_COLOR);

        a.recycle();
    }


    private void init(Context context){
        mContext = context;
        setOrientation(VERTICAL);
        mFactory = new ItemFactory(context);
    }



    public void create(){


        if(mConfigAttrs == null){
            throw new RuntimeException("config attrs  is null");
        }


        if(mConfigAttrs.getValueList() == null){
            throw new RuntimeException("valueList  is null");
        }

        if(mConfigAttrs.getResIdList() == null){
            throw new RuntimeException(" resIdList is null");
        }

        if(mConfigAttrs.getValueList().size() != mConfigAttrs.getResIdList().size()){
            throw new RuntimeException("params not match, valueList.size() should be equal resIdList.size()");
        }

        for(int i = 0; i < mConfigAttrs.getValueList().size(); i++){


            mConfigAttrs.setPosition(i);
            SparseArray<Mode> modeArray = mConfigAttrs.getModeArray();
            Mode mode = modeArray.get(i);
            AbstractItem itemView = mFactory.createItem(mode, mConfigAttrs);
            addItem(itemView,i);

        }

    }

    /**
     * 添加 item
     * @param view
     * @param pos
     */
    private void addItem(AbstractItem view, final int pos){



        if (mConfigAttrs.getMarginArray() != null ) {

            if(mConfigAttrs.getMarginArray().get(pos) != null){
                addView(createLineView((Integer) mConfigAttrs.getMarginArray().get(pos)));
            }

        } else {
            addView(createLineView(CommonCons.DEFAULT_HEIGHT));
        }


        addView(view);
        addView(createLineView(CommonCons.ZERO_HEIGHT));
        //
        if(onBaseItemClick != null){
            setListener(view,pos);
        }

        if(onSwitchClickListener != null){
            setButtonClick();
        }

        mViewList.add(view);
    }

    /**
     * 创建线
     * @param margin
     * @return
     */
    private View createLineView(int margin){

        View view = new View(mContext);
        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        lp.topMargin = DensityUtil.dip2px(mContext,margin);

        view.setLayoutParams(lp);
        view.setBackgroundColor(mLineColor);
        return view;
    }

    private void setOnClick() {
        if(onBaseItemClick != null){
            for(int i = 0; i < mViewList.size(); i++){
                View view = mViewList.get(i);
                setListener(view,i);
            }
        }
    }

    /**
     * 设置 item 的监听回调
     * @param view
     * @param position
     */
    private void setListener(View view, final int position) {
        if(view == null){
            return;
        }

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBaseItemClick.onItemClick(position);
            }
        });
    }

    /**
     * 设置 button的点击事件
     */
    private void setButtonClick() {

        if(onSwitchClickListener != null){

            for(int i = 0; i< mViewList.size(); i++){

                SparseArray<Mode> modeArray = mConfigAttrs.getModeArray();

                Mode mode = modeArray.get(i);

                if(mode == Mode.BOTTON){

                    ButtonItem view = (ButtonItem) mViewList.get(i);

                    SwitchImageView switchImageView = view.getSwitchImageView();

                    onButtonClick(i,switchImageView);

                }

            }

        }
    }


    private void onButtonClick(final int pos, final SwitchImageView switchImageView) {

        switchImageView.setOnSwitchClickListener(new SwitchImageView.OnSwitchClickListener() {
            @Override
            public void onClick(boolean isCheck) {


                if(isCheck){
                    switchImageView.setImageResource(R.drawable.img_up);
                }else{
                    switchImageView.setImageResource(R.drawable.img_turn_down);
                }
                onSwitchClickListener.onClick(pos,isCheck);
            }
        });
    }


    public BaseItemLayout setConfigAttrs(ConfigAttrs attrs){


        if(attrs == null){
            throw new RuntimeException("attrs is null");
        }
        this.mConfigAttrs = attrs;


        if (mConfigAttrs.getLineColor() == 0) {
            mConfigAttrs.setLineColor(mLineColor);
        }

        if (mConfigAttrs.getTextSize() == 0) {
            mConfigAttrs.setTextSize(mTextSize);
        }

        if (mConfigAttrs.getTextColor() == 0) {
            mConfigAttrs.setTextColor(mTextColor);
        }

        if (mConfigAttrs.getIconMarginLeft() == 0) {
            mConfigAttrs.setIconMarginLeft(mIconMarginLeft);
        }

        if (mConfigAttrs.getRightTextColor() == 0) {
            mConfigAttrs.setRightTextColor(mRightTextColor);
        }
        if (mConfigAttrs.getRightTextSize() == 0) {
            mConfigAttrs.setRightTextSize(mRightTextSize);
        }

        if (mConfigAttrs.getIconTextMargin() == 0) {
            mConfigAttrs.setIconTextMargin(mIconTextMargin);
        }
        if (mConfigAttrs.getMarginRight() == 0) {
            mConfigAttrs.setMarginRight(mArrowMarginRight);
        }

        if (mConfigAttrs.getItemHeight() == 0) {
            mConfigAttrs.setItemHeight(mItemHeight);
        }

        if (mConfigAttrs.getRightTextMagin() == 0) {

            mConfigAttrs.setRightTextMagin(mRightTextMagin);
        }
        if (mConfigAttrs.getItemBgSelector() == 0) {

            mConfigAttrs.setItemBgSelector(mItemBgSelector);
        }
        return this;
    }

    //=================================监听事件====================================









    private OnBaseItemClick onBaseItemClick;

    public void setOnBaseItemClick(OnBaseItemClick onBaseItemClick) {
        this.onBaseItemClick = onBaseItemClick;
        setOnClick();
    }

    public interface OnBaseItemClick{

        void onItemClick(int position);
    }


    private OnSwitchClickListener onSwitchClickListener;

    public void setOnSwitchClickListener(OnSwitchClickListener onSwitchClickListener) {
        this.onSwitchClickListener = onSwitchClickListener;
        setButtonClick();
    }


    public interface OnSwitchClickListener{

        void onClick(int position, boolean isCheck);
    }



}
