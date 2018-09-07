package com.zzr.ballcalte.widge;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zzr.ballcalte.R;
import com.zzr.ballcalte.adapter.SelectAdapter;
import com.zzr.ballcalte.bean.BallBean;
import com.zzr.ballcalte.utils.NewBeeToastUtils;

import java.util.List;

/**
 * 作者：zzr
 * 创建日期：2018/9/6
 * 描述：
 */
public class SelectDialog {
    private Context context;
    private Display display;
    private Dialog dialog;
    private SelectAdapter adapter;
    private List<BallBean> list;
    private int type;   //0:胆码 1:拖码 2:篮球

    private LinearLayout ll_dialog;
    private TextView tv_sure, tv_cancel;
    private RecyclerView recyclerView;

    public SelectDialog(Context context, List<BallBean> list, int type) {
        this.context = context;
        this.list = list;
        this.type = type;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public SelectDialog builder() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_select, null);
        ll_dialog = view.findViewById(R.id.ll_dialog);
        tv_sure = view.findViewById(R.id.tv_sure);
        tv_cancel = view.findViewById(R.id.tv_cancel);
        recyclerView = view.findViewById(R.id.recyclerView);

        dialog = new Dialog(context, R.style.AlertDialogStyle);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        ll_dialog.setLayoutParams(new FrameLayout.LayoutParams((int) (display.getWidth() * 0.8),
                ViewGroup.LayoutParams.WRAP_CONTENT));

        initAdapter();

        return this;
    }

    public List<BallBean> getList() {
        return list;
    }

    public int getType() {
        return type;
    }

    public SelectDialog setList(List<BallBean> list) {
        this.list = list;
        adapter.setNewData(list);
        return this;
    }

    public SelectDialog setType(int type) {
        this.type = type;
        return this;
    }

    private void initAdapter() {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 5));
        adapter = new SelectAdapter(R.layout.item_ball);
        recyclerView.setAdapter(adapter);

        if (list != null)
            adapter.setNewData(list);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BallBean ballBean = list.get(position);
                if (!ballBean.isSelect()) {
                    int num = 0;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isSelect()) {
                            num++;
                        }
                    }

                    switch (type) {
                        case 0:
                            if (num >= 5) {
                                NewBeeToastUtils.showToastLong(context, "胆码不能超过五个！");
                                return;
                            }
                            break;
                        case 1:
                            break;
                        case 2:
                            if (num >= 3) {
                                NewBeeToastUtils.showToastLong(context, "篮球不能超过3个！");
                                return;
                            }
                            break;
                    }

                    ballBean.setSelect(true);
                } else {
                    ballBean.setSelect(false);
                }

                adapter.setNewData(list);
            }
        });
    }

    public SelectDialog setOnCancelClickListener(final View.OnClickListener listener) {
        if (listener == null)
            return null;

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                if (dialog != null)
                    dialog.dismiss();
            }
        });
        return this;
    }

    public SelectDialog setOnSureClickListener(final View.OnClickListener listener) {
        if (listener == null)
            return null;

        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
            }
        });
        return this;
    }

    public void show() {
        if (context != null && dialog != null)
            dialog.show();
    }

    public void dismiss() {
        if (context != null && dialog != null)
            dialog.dismiss();
    }
}
